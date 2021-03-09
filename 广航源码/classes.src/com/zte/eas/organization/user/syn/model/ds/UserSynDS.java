package com.zte.eas.organization.user.syn.model.ds;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.nc_itf_guanghj_service.IHrService;
import com.cmcc.mss.nc_itf_guanghj_service.IHrServiceLocator;
import com.cmcc.mss.nc_itf_guanghj_service.IHrServiceSOAP11BindingStub;
import com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.InquiryUsersInfoSrvOutputCollection;
import com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.SBEASEASInquiryUsersInfoSrv;
import com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.SBEASEASInquiryUsersInfoSrvRequest;
import com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.SBEASEASInquiryUsersInfoSrvResponse;
import com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.SBEASEASInquiryUsersInfoSrv_Service;
import com.zte.eas.appframe.business.syscommon.InfoMapEncrypt;
import com.zte.eas.bmsctrl.ws.Fb_SC_CMS_00001.DS.IFbpEmployeeDS;
import com.zte.eas.organization.access.employeemanage.dao.FbpEmployeesTlDAO;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesDAO;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesTlDAO;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsDAO;
import com.zte.eas.organization.business.countcompanymanage.service.DataSourceU;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesModel;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTlPk;
import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;
import com.zte.eas.organization.user.syn.model.dao.IUserSynDao;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.esb.bean.EmployeeInfo;
import com.zte.esb.bean.RoleInfo;
import com.zte.esb.bean.SendEmployeeProcessReult;
import com.zte.esb.bean.SendEmployeeRequest;
import com.zte.esb.bean.SendEmployeeResponse;
import com.zte.esb.bean.SendRoleInfoProcessReult;
import com.zte.esb.bean.SendRoleInfoRequest;
import com.zte.esb.bean.SendRoleInfoResponse;
import com.zte.esb.bean.SendUserInfoProcessReult;
import com.zte.esb.bean.SendUserInfoRequest;
import com.zte.esb.bean.SendUserInfoResponse;
import com.zte.esb.bean.UserInfo;
import com.zte.esb.bean.UserRoleInfo;
import com.zte.jam.baseinfo.access.intf.GamBaseRoleDAO;
import com.zte.jam.baseinfo.access.intf.GamBaseRoleMemberDAO;
import com.zte.jam.baseinfo.access.model.GamBaseRole;
import com.zte.jam.baseinfo.access.model.GamBaseRoleMember;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.ssbext.lang.LangType;
import com.zte.ssb.ssbext.lang.LangUtil;
import java.io.PrintStream;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.rpc.ServiceException;
import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class UserSynDS
  implements IUserSynDS
{
  private Logger log = Logger.getLogger(getClass());
  static Lock lock = null;
  IUserSynDao userSynDao;
  
  public IUserSynDao getUserSynDao()
  {
    return this.userSynDao;
  }
  
  public void setUserSynDao(IUserSynDao paramIUserSynDao)
  {
    this.userSynDao = paramIUserSynDao;
  }
  
  public void synEmployeeFromHr(String paramString)
    throws ServiceException, RemoteException
  {
    IHrServiceLocator localIHrServiceLocator = new IHrServiceLocator();
    IHrServiceSOAP11BindingStub localIHrServiceSOAP11BindingStub = (IHrServiceSOAP11BindingStub)localIHrServiceLocator.getIHrServiceSOAP11port_http();
    String str = localIHrServiceSOAP11BindingStub.process(paramString);
    List localList = readEmployeeStringXml(str);
    syncEmployeeFromHr(localList);
  }
  
  public void syncEmployeeFromHr(List<FbpEmployeesModel> paramList)
  {
    IFbpEmployeesDAO localIFbpEmployeesDAO = (IFbpEmployeesDAO)SSBBus.findDaoService("fbpEmployeesDAO");
    IFbpDeptsDAO localIFbpDeptsDAO = (IFbpDeptsDAO)SSBBus.findDaoService("fbpDeptsDAO");
    FbpEmployeesTlDAO localFbpEmployeesTlDAO = (FbpEmployeesTlDAO)SSBBus.findDaoService("fbpEmployeesTlDAO");
    String[] arrayOfString = { "ZHS", "EN" };
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FbpEmployeesModel localFbpEmployeesModel = (FbpEmployeesModel)localIterator.next();
      FbpEmployees localFbpEmployees = localIFbpEmployeesDAO.getFbpEmployees(localFbpEmployeesModel.getEmployeeNumber());
      BigInteger localBigInteger;
      int i;
      FbpEmployeesTlPk localFbpEmployeesTlPk;
      FbpEmployeesTl localFbpEmployeesTl;
      if (localFbpEmployees != null)
      {
        localFbpEmployees.setEmployeeNumber(localFbpEmployeesModel.getEmployeeNumber());
        localFbpEmployees.setMobilePhone(localFbpEmployeesModel.getMobilePhone());
        localFbpEmployees.setPhone(localFbpEmployeesModel.getPhone());
        localFbpEmployees.setEmailAddress(localFbpEmployeesModel.getEmailAddress());
        localFbpEmployees.setLastUpdateDate(localFbpEmployeesModel.getLastUpdateDate());
        localBigInteger = localIFbpDeptsDAO.getFbpDeptsByCode(localFbpEmployeesModel.getDeptCode()).getDeptId();
        localFbpEmployees.setDeptId(localBigInteger);
        localFbpEmployees.setDocNumber(localFbpEmployeesModel.getDocNumber());
        localIFbpEmployeesDAO.updateFbpEmployees(localFbpEmployees);
        for (i = 0; i < arrayOfString.length; i++)
        {
          localFbpEmployeesTlPk = new FbpEmployeesTlPk();
          localFbpEmployeesTlPk.setEmployeeId(localFbpEmployees.getEmployeeId());
          localFbpEmployeesTlPk.setLanguage(arrayOfString[i]);
          localFbpEmployeesTl = localFbpEmployeesTlDAO.getFbpEmployeesTl(localFbpEmployeesTlPk);
          if (localFbpEmployeesTl != null)
          {
            localFbpEmployeesTl.setEmployeeName(localFbpEmployeesModel.getEmployeeName());
            localFbpEmployeesTl.setLastUpdateDate(localFbpEmployeesModel.getLastUpdateDate());
            localFbpEmployeesTlDAO.updateFbpEmployeesTl(localFbpEmployeesTl);
          }
          else
          {
            localFbpEmployeesTl.setLastUpdatedBy(Long.valueOf(1L));
            localFbpEmployeesTl.setCreatedBy(Long.valueOf(1L));
            localFbpEmployeesTl.setLastUpdateLogin(Long.valueOf(1L));
            localFbpEmployeesTl.setCreationDate(new Date());
            localFbpEmployeesTl.setEmployeeName(localFbpEmployeesModel.getEmployeeName());
            localFbpEmployeesTl.setLastUpdateDate(localFbpEmployeesModel.getLastUpdateDate());
            localFbpEmployeesTl.setEmployeePkTl(localFbpEmployeesTlPk);
            localFbpEmployeesTlDAO.insertFbpEmployeesTl(localFbpEmployeesTl);
          }
        }
      }
      else
      {
        localFbpEmployees.setLastUpdatedBy(Long.valueOf(1L));
        localFbpEmployees.setLastUpdateLogin(Long.valueOf(1L));
        localFbpEmployees.setCreatedBy(Long.valueOf(1L));
        localFbpEmployees.setCreationDate(new Date());
        localFbpEmployees.setEmployeeNumber(localFbpEmployeesModel.getEmployeeNumber());
        localFbpEmployees.setMobilePhone(localFbpEmployeesModel.getMobilePhone());
        localFbpEmployees.setPhone(localFbpEmployeesModel.getPhone());
        localFbpEmployees.setEmailAddress(localFbpEmployeesModel.getEmailAddress());
        localFbpEmployees.setLastUpdateDate(localFbpEmployeesModel.getLastUpdateDate());
        localBigInteger = localIFbpDeptsDAO.getFbpDeptsByCode(localFbpEmployeesModel.getDeptCode()).getDeptId();
        localFbpEmployees.setDeptId(localBigInteger);
        localFbpEmployees.setDocNumber(localFbpEmployeesModel.getDocNumber());
        localIFbpEmployeesDAO.insertFbpEmployees(localFbpEmployees);
        for (i = 0; i < arrayOfString.length; i++)
        {
          localFbpEmployeesTlPk = new FbpEmployeesTlPk();
          localFbpEmployeesTlPk.setEmployeeId(localFbpEmployees.getEmployeeId());
          localFbpEmployeesTlPk.setLanguage(arrayOfString[i]);
          localFbpEmployeesTl = localFbpEmployeesTlDAO.getFbpEmployeesTl(localFbpEmployeesTlPk);
          if (localFbpEmployeesTl != null)
          {
            localFbpEmployeesTl.setEmployeeName(localFbpEmployeesModel.getEmployeeName());
            localFbpEmployeesTl.setLastUpdateDate(localFbpEmployeesModel.getLastUpdateDate());
            localFbpEmployeesTlDAO.updateFbpEmployeesTl(localFbpEmployeesTl);
          }
          else
          {
            localFbpEmployeesTl.setLastUpdatedBy(Long.valueOf(1L));
            localFbpEmployeesTl.setCreatedBy(Long.valueOf(1L));
            localFbpEmployeesTl.setLastUpdateLogin(Long.valueOf(1L));
            localFbpEmployeesTl.setCreationDate(new Date());
            localFbpEmployeesTl.setEmployeeName(localFbpEmployeesModel.getEmployeeName());
            localFbpEmployeesTl.setLastUpdateDate(localFbpEmployeesModel.getLastUpdateDate());
            localFbpEmployeesTl.setEmployeePkTl(localFbpEmployeesTlPk);
            localFbpEmployeesTlDAO.insertFbpEmployeesTl(localFbpEmployeesTl);
          }
        }
      }
    }
  }
  
  public List<FbpEmployeesModel> readEmployeeStringXml(String paramString)
  {
    Document localDocument = null;
    ArrayList localArrayList = new ArrayList();
    try
    {
      localDocument = DocumentHelper.parseText(paramString);
      Element localElement1 = localDocument.getRootElement();
      System.out.println("根节点：" + localElement1.getName());
      Iterator localIterator1 = localElement1.elementIterator("data");
      while (localIterator1.hasNext())
      {
        Element localElement2 = (Element)localIterator1.next();
        Iterator localIterator2 = localElement2.elementIterator("Person");
        while (localIterator2.hasNext())
        {
          FbpEmployeesModel localFbpEmployeesModel = new FbpEmployeesModel();
          Element localElement3 = (Element)localIterator2.next();
          localFbpEmployeesModel.setEmployeeNumber(localElement3.elementTextTrim("employee_no") == null ? null : localElement3.elementTextTrim("employee_no"));
          localFbpEmployeesModel.setEmployeeName(localElement3.elementTextTrim("first_name") == null ? null : localElement3.elementTextTrim("first_name"));
          localFbpEmployeesModel.setMobilePhone(localElement3.elementTextTrim("mobile_number") == null ? null : localElement3.elementTextTrim("mobile_number"));
          localFbpEmployeesModel.setPhone(localElement3.elementTextTrim("phone_number") == null ? null : localElement3.elementTextTrim("phone_number"));
          localFbpEmployeesModel.setEmailAddress(localElement3.elementTextTrim("email") == null ? null : localElement3.elementTextTrim("email"));
          localFbpEmployeesModel.setPositionLevel(localElement3.elementTextTrim("level") == null ? null : localElement3.elementTextTrim("level"));
          localFbpEmployeesModel.setLastUpdateDate(new Date(localElement3.elementTextTrim("last_upd") == null ? null : localElement3.elementTextTrim("last_upd")));
          localFbpEmployeesModel.setDeptCode(localElement3.elementTextTrim("dept_code") == null ? null : localElement3.elementTextTrim("dept_code"));
          localFbpEmployeesModel.setDocNumber(localElement3.elementTextTrim("identity_number") == null ? null : localElement3.elementTextTrim("identity_number"));
          localArrayList.add(localFbpEmployeesModel);
        }
      }
    }
    catch (DocumentException localDocumentException)
    {
      localDocumentException.printStackTrace();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localArrayList;
  }
  
  public String synUser(SBEASEASInquiryUsersInfoSrvRequest paramSBEASEASInquiryUsersInfoSrvRequest)
  {
    this.log.error("-------SB_EAS_EAS_InquiryUsersInfoSrv查询员工信息服务 开始-----");
    this.log.error("Request MsgHeader SOURCE_SYSTEM_ID:" + paramSBEASEASInquiryUsersInfoSrvRequest.getMsgHeader().getSOURCESYSTEMID());
    this.log.error("Request MsgHeader SOURCE_SYSTEM_NAME:" + paramSBEASEASInquiryUsersInfoSrvRequest.getMsgHeader().getSOURCESYSTEMNAME());
    this.log.error("Request MsgHeader USER_ID:" + paramSBEASEASInquiryUsersInfoSrvRequest.getMsgHeader().getUSERID());
    this.log.error("Request MsgHeader USER_NAME:" + paramSBEASEASInquiryUsersInfoSrvRequest.getMsgHeader().getUSERNAME());
    this.log.error("Request MsgHeader SUBMIT_DATE:" + paramSBEASEASInquiryUsersInfoSrvRequest.getMsgHeader().getSUBMITDATE().toGregorianCalendar().getTime());
    this.log.error("Request EMPLOYEE_NUM:" + paramSBEASEASInquiryUsersInfoSrvRequest.getEMPLOYEENUM());
    this.log.error("Request EMPLOYEE_NAME:" + paramSBEASEASInquiryUsersInfoSrvRequest.getEMPLOYEENAME());
    this.log.error("Request START_LAST_UPDATE_DATE:" + paramSBEASEASInquiryUsersInfoSrvRequest.getSTARTLASTUPDATEDATE().toGregorianCalendar().getTime());
    this.log.error("Request END_LAST_UPDATE_DATE:" + paramSBEASEASInquiryUsersInfoSrvRequest.getENDLASTUPDATEDATE().toGregorianCalendar().getTime());
    SBEASEASInquiryUsersInfoSrv_Service localSBEASEASInquiryUsersInfoSrv_Service = new SBEASEASInquiryUsersInfoSrv_Service();
    SBEASEASInquiryUsersInfoSrv localSBEASEASInquiryUsersInfoSrv = localSBEASEASInquiryUsersInfoSrv_Service.getSBEASEASInquiryUsersInfoSrvPort();
    try
    {
      SBEASEASInquiryUsersInfoSrvResponse localSBEASEASInquiryUsersInfoSrvResponse = localSBEASEASInquiryUsersInfoSrv.process(paramSBEASEASInquiryUsersInfoSrvRequest);
      if (localSBEASEASInquiryUsersInfoSrvResponse != null)
      {
        this.log.error("Response INSTANCE_ID:" + localSBEASEASInquiryUsersInfoSrvResponse.getINSTANCEID());
        this.log.error("Response SERVICE_FLAG:" + localSBEASEASInquiryUsersInfoSrvResponse.getSERVICEFLAG());
        this.log.error("Response SERVICE_MESSAGE:" + localSBEASEASInquiryUsersInfoSrvResponse.getSERVICEMESSAGE());
        this.log.error("Response employee size:" + localSBEASEASInquiryUsersInfoSrvResponse.getInquiryUsersInfoSrvOutputCollection().getInquiryUsersInfoSrvOutputItem().size());
        if ("Y".equals(localSBEASEASInquiryUsersInfoSrvResponse.getSERVICEFLAG()))
        {
          List localList = localSBEASEASInquiryUsersInfoSrvResponse.getInquiryUsersInfoSrvOutputCollection().getInquiryUsersInfoSrvOutputItem();
          IUserSynDao localIUserSynDao = (IUserSynDao)SSBBus.findDomainService("userSynDao");
          localIUserSynDao.synUser(localList);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.log.error("Exception:", localException);
    }
    this.log.error("-------SB_EAS_EAS_InquiryUsersInfoSrv查询员工信息服务 结束-----");
    return null;
  }
  
  public SendUserInfoProcessReult setSendUserInfoResponse(UserInfo paramUserInfo, Boolean paramBoolean, String paramString)
  {
    SendUserInfoProcessReult localSendUserInfoProcessReult = new SendUserInfoProcessReult();
    localSendUserInfoProcessReult.setChangeType(paramUserInfo.getChangeType());
    localSendUserInfoProcessReult.setResult(paramBoolean.booleanValue());
    localSendUserInfoProcessReult.setReason(paramString);
    localSendUserInfoProcessReult.setAccountChangeId(paramUserInfo.getAccountChangeId());
    localSendUserInfoProcessReult.setEmpCode(paramUserInfo.getEmpCode());
    return localSendUserInfoProcessReult;
  }
  
  public SendUserInfoResponse synUser(SendUserInfoRequest paramSendUserInfoRequest)
  {
    SendUserInfoResponse localSendUserInfoResponse = new SendUserInfoResponse();
    SendUserInfoProcessReult localSendUserInfoProcessReult = null;
    ArrayList localArrayList1 = new ArrayList();
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(0);
    if ((paramSendUserInfoRequest == null) || (paramSendUserInfoRequest.getUserInfo() == null) || (paramSendUserInfoRequest.getUserInfo().isEmpty()))
    {
      localSendUserInfoProcessReult = new SendUserInfoProcessReult();
      localSendUserInfoProcessReult.setReason("传入参数不能为空!");
      localSendUserInfoProcessReult.setResult(Boolean.FALSE.booleanValue());
      localSendUserInfoResponse.setFailedCount(localInteger2.intValue());
      localSendUserInfoResponse.setSuccessCount(localInteger1.intValue());
      localArrayList1.add(localSendUserInfoProcessReult);
      localSendUserInfoResponse.setProcessResult(localArrayList1);
      return localSendUserInfoResponse;
    }
    IFbpEmployeeDS localIFbpEmployeeDS = (IFbpEmployeeDS)SSBBus.findDomainService("fbpEmployeeDS");
    IFbpEmployeesTlDAO localIFbpEmployeesTlDAO = (IFbpEmployeesTlDAO)SSBBus.findDomainService("fbpEmployeesTlDAO");
    IFbpDeptsDAO localIFbpDeptsDAO = (IFbpDeptsDAO)SSBBus.findDomainService("fbpDeptsDAO");
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    GamBaseRoleMemberDAO localGamBaseRoleMemberDAO = (GamBaseRoleMemberDAO)SSBBus.findDomainService("gamBaseRoleMemberDAO");
    List localList1 = LangUtil.listLangTypes();
    List localList2 = paramSendUserInfoRequest.getUserInfo();
    String str1 = "select * from jam.gam_base_role r where r.enabled_flag = 'Y' and r.role_no =?";
    ArrayList localArrayList2 = new ArrayList();
    String str2 = "delete from jam.gam_base_role_member m where object_type='U' and object_id = ?";
    ArrayList localArrayList3 = new ArrayList();
    String str3 = "select * from jam.gam_base_role_member m where object_type='U' and role_id = ? and object_id = ?";
    ArrayList localArrayList4 = new ArrayList();
    for (int i = 0; i < localList2.size(); i++)
    {
      UserInfo localUserInfo = (UserInfo)localList2.get(i);
      localSendUserInfoProcessReult = new SendUserInfoProcessReult();
      Object localObject2;
      try
      {
        if (localUserInfo == null)
        {
          localSendUserInfoProcessReult.setReason("传入参数不能为空!");
          localSendUserInfoProcessReult.setResult(Boolean.FALSE.booleanValue());
          localArrayList1.add(localSendUserInfoProcessReult);
          localObject1 = localInteger2;
          localObject2 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
          continue;
        }
        Object localObject1 = localIFbpEmployeeDS.getFbpEmployees(localUserInfo.getEmpCode());
        if (localObject1 == null)
        {
          localObject1 = new FbpEmployees();
          ((FbpEmployees)localObject1).setCreatedBy(Long.valueOf(1L));
          ((FbpEmployees)localObject1).setLastUpdatedBy(Long.valueOf(1L));
          ((FbpEmployees)localObject1).setCreationDate(new Date());
          ((FbpEmployees)localObject1).setLastUpdateLogin(Long.valueOf(1L));
        }
        if (!StringUtils.isEmpty(localUserInfo.getOrgCode()))
        {
          localObject2 = localIFbpDeptsDAO.getFbpDeptsByCode(localUserInfo.getOrgCode());
          if ((localObject2 == null) || (((FbpDepts)localObject2).getDeptId() == null))
          {
            localSendUserInfoProcessReult = setSendUserInfoResponse(localUserInfo, Boolean.FALSE, "组织编码[" + localUserInfo.getOrgCode() + "]不存在!");
            localArrayList1.add(localSendUserInfoProcessReult);
            localObject3 = localInteger2;
            Integer localInteger3 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
            continue;
          }
          ((FbpEmployees)localObject1).setDeptId(((FbpDepts)localObject2).getDeptId());
        }
        ((FbpEmployees)localObject1).setLastUpdateDate(new Date());
        ((FbpEmployees)localObject1).setEmployeeNumber(localUserInfo.getEmpCode());
        ((FbpEmployees)localObject1).setOrgBenchMarkCode(localUserInfo.getOrgBenchmarkCode());
        ((FbpEmployees)localObject1).setIsTemp(localUserInfo.getIsTemp() ? "Y" : "N");
        ((FbpEmployees)localObject1).setIsActive(localUserInfo.getIsActive() ? "Y" : "N");
        ((FbpEmployees)localObject1).setValidDate(localUserInfo.getValidDate());
        ((FbpEmployees)localObject1).setInvalidDate(localUserInfo.getInvalidDate());
        ((FbpEmployees)localObject1).setEnabledFlag(localUserInfo.getIsActive() ? "Y" : "N");
        if (localUserInfo.getLastModifyTime() != null) {
          ((FbpEmployees)localObject1).setLastUpdateDate(localUserInfo.getLastModifyTime());
        }
        localObject2 = Boolean.valueOf(true);
        localObject3 = localUserInfo.getRoleInfo();
        Object localObject6;
        Object localObject7;
        if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
        {
          localArrayList3.clear();
          localArrayList3.add(localUserInfo.getEmpCode());
          localIImageCommonDAO.executeSql(str2, localArrayList3);
          for (int j = 0; j < ((List)localObject3).size(); j++)
          {
            localObject5 = (UserRoleInfo)((List)localObject3).get(j);
            localObject6 = ((UserRoleInfo)localObject5).getRoleBseCode();
            for (int k = 0; k < ((List)localObject6).size(); k++)
            {
              localObject7 = (String)((List)localObject6).get(k);
              localArrayList2.clear();
              localArrayList2.add(localObject7);
              List localList3 = localIImageCommonDAO.findObjectBySQL(str1, localArrayList2, GamBaseRole.class);
              GamBaseRole localGamBaseRole = null;
              if ((localList3 != null) && (!localList3.isEmpty())) {
                localGamBaseRole = (GamBaseRole)localList3.get(0);
              }
              if (localGamBaseRole == null)
              {
                localSendUserInfoProcessReult = setSendUserInfoResponse(localUserInfo, Boolean.FALSE, "角色编号[" + (String)localObject7 + "]不存在，请先同步角色信息!");
                localArrayList1.add(localSendUserInfoProcessReult);
                localObject2 = Boolean.valueOf(false);
                break;
              }
              GamBaseRoleMember localGamBaseRoleMember = new GamBaseRoleMember();
              localGamBaseRoleMember.setCreatedBy("10000");
              localGamBaseRoleMember.setCreatedByName("系统管理员");
              localGamBaseRoleMember.setCreatedDate(new Date());
              localGamBaseRoleMember.setLastUpdatedBy("10000");
              localGamBaseRoleMember.setLastUpdatedByName("系统管理员");
              localGamBaseRoleMember.setObjectType("U");
              localGamBaseRoleMember.setRoleId(localGamBaseRole.getLineId());
              localGamBaseRoleMember.setObjectId(localUserInfo.getEmpCode());
              localGamBaseRoleMember.setLastUpdatedDate(new Date());
              localGamBaseRoleMember.setEnabledFlag("Y");
              localGamBaseRoleMemberDAO.insertGamBaseRoleMember(localGamBaseRoleMember);
              localObject2 = Boolean.valueOf(true);
            }
            if (!((Boolean)localObject2).booleanValue()) {
              break;
            }
          }
        }
        if (!((Boolean)localObject2).booleanValue())
        {
          localObject4 = localInteger2;
          localObject5 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
          continue;
        }
        if (((FbpEmployees)localObject1).getEmployeeId() == null)
        {
          if (!StringUtils.isEmpty(localUserInfo.getDesPassword())) {
            ((FbpEmployees)localObject1).setPassword(InfoMapEncrypt.encrypt(localUserInfo.getDesPassword()));
          }
          localIFbpEmployeeDS.insertFbpEmployees((FbpEmployees)localObject1);
        }
        else
        {
          localIFbpEmployeeDS.updateFbpEmployees((FbpEmployees)localObject1);
        }
        localObject4 = localList1.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (LangType)((Iterator)localObject4).next();
          localObject6 = DataSourceU.getLang(((LangType)localObject5).getCode());
          FbpEmployeesTlPk localFbpEmployeesTlPk = new FbpEmployeesTlPk();
          localFbpEmployeesTlPk.setEmployeeId(((FbpEmployees)localObject1).getEmployeeId());
          localFbpEmployeesTlPk.setLanguage((String)localObject6);
          localObject7 = localIFbpEmployeesTlDAO.getFbpEmployeesTl(localFbpEmployeesTlPk);
          int m = 1;
          if (localObject7 == null)
          {
            localObject7 = new FbpEmployeesTl();
            ((FbpEmployeesTl)localObject7).setCreatedBy(Long.valueOf(1L));
            ((FbpEmployeesTl)localObject7).setLastUpdatedBy(Long.valueOf(1L));
            ((FbpEmployeesTl)localObject7).setCreationDate(new Date());
            ((FbpEmployeesTl)localObject7).setLastUpdateLogin(Long.valueOf(1L));
            ((FbpEmployeesTl)localObject7).setEmployeePkTl(localFbpEmployeesTlPk);
            ((FbpEmployeesTl)localObject7).setSourceLang((String)localObject6);
            m = 0;
          }
          ((FbpEmployeesTl)localObject7).setLastUpdateDate(new Date());
          ((FbpEmployeesTl)localObject7).setEmployeeName(localUserInfo.getEmpName());
          if (m != 0) {
            localIFbpEmployeesTlDAO.updateFbpEmployeesTl((FbpEmployeesTl)localObject7);
          } else {
            localIFbpEmployeesTlDAO.insertFbpEmployeesTl((FbpEmployeesTl)localObject7);
          }
        }
        localSendUserInfoProcessReult = setSendUserInfoResponse(localUserInfo, Boolean.TRUE, "");
        localObject4 = localInteger1;
        Object localObject5 = localInteger1 = Integer.valueOf(localInteger1.intValue() + 1);
      }
      catch (Exception localException)
      {
        Object localObject4;
        localSendUserInfoProcessReult = setSendUserInfoResponse(localUserInfo, Boolean.FALSE, "系统异常：" + localException.getMessage());
        this.log.error("系统异常：" + localException.getMessage(), localException);
        localObject2 = localInteger2;
        Object localObject3 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
      }
      localArrayList1.add(localSendUserInfoProcessReult);
    }
    localSendUserInfoResponse.setFailedCount(localInteger2.intValue());
    localSendUserInfoResponse.setSuccessCount(localInteger1.intValue());
    localSendUserInfoResponse.setProcessResult(localArrayList1);
    return localSendUserInfoResponse;
  }
  
  public Map<String, Object> syncUserOrEmployees(SendUserInfoRequest paramSendUserInfoRequest, SendEmployeeRequest paramSendEmployeeRequest)
  {
    if (lock == null) {
      lock = new ReentrantLock();
    }
    HashMap localHashMap = null;
    try
    {
      lock.lock();
      localHashMap = new HashMap();
      if (paramSendUserInfoRequest != null) {
        localHashMap.put("SendUserInfoResponse", synUser(paramSendUserInfoRequest));
      } else if (paramSendEmployeeRequest != null) {
        localHashMap.put("SendEmployeeResponse", synEmployees(paramSendEmployeeRequest));
      }
    }
    catch (Exception localException) {}finally
    {
      lock.unlock();
    }
    return localHashMap;
  }
  
  public SendEmployeeResponse synEmployees(SendEmployeeRequest paramSendEmployeeRequest)
  {
    SendEmployeeResponse localSendEmployeeResponse = new SendEmployeeResponse();
    SendEmployeeProcessReult localSendEmployeeProcessReult = null;
    ArrayList localArrayList = new ArrayList();
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(0);
    if ((paramSendEmployeeRequest == null) || (paramSendEmployeeRequest.getEmployeeInfo() == null) || (paramSendEmployeeRequest.getEmployeeInfo().isEmpty()))
    {
      localSendEmployeeProcessReult = new SendEmployeeProcessReult();
      localSendEmployeeProcessReult.setReason("传入参数不能为空!");
      localSendEmployeeProcessReult.setResult(Boolean.FALSE.booleanValue());
      localSendEmployeeResponse.setSuccessCount(localInteger1.intValue());
      localSendEmployeeResponse.setFailedCount(localInteger2.intValue());
      localArrayList.add(localSendEmployeeProcessReult);
      localSendEmployeeResponse.setProcessResult(localArrayList);
      return localSendEmployeeResponse;
    }
    IFbpEmployeeDS localIFbpEmployeeDS = (IFbpEmployeeDS)SSBBus.findDomainService("fbpEmployeeDS");
    IFbpEmployeesTlDAO localIFbpEmployeesTlDAO = (IFbpEmployeesTlDAO)SSBBus.findDomainService("fbpEmployeesTlDAO");
    IFbpDeptsDAO localIFbpDeptsDAO = (IFbpDeptsDAO)SSBBus.findDomainService("fbpDeptsDAO");
    List localList1 = LangUtil.listLangTypes();
    List localList2 = paramSendEmployeeRequest.getEmployeeInfo();
    for (int i = 0; i < localList2.size(); i++)
    {
      localSendEmployeeProcessReult = new SendEmployeeProcessReult();
      EmployeeInfo localEmployeeInfo = (EmployeeInfo)localList2.get(i);
      Object localObject2;
      try
      {
        Object localObject1;
        if (localEmployeeInfo == null)
        {
          localSendEmployeeProcessReult.setReason("传递参数不能为空!");
          localSendEmployeeProcessReult.setResult(Boolean.FALSE.booleanValue());
          localArrayList.add(localSendEmployeeProcessReult);
          localObject1 = localInteger2;
          localObject2 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
        }
        else
        {
          localObject1 = localIFbpEmployeeDS.getFbpEmployees(localEmployeeInfo.getEmployeeCode());
          if (localObject1 == null)
          {
            localObject1 = new FbpEmployees();
            ((FbpEmployees)localObject1).setCreatedBy(Long.valueOf(1L));
            ((FbpEmployees)localObject1).setLastUpdatedBy(Long.valueOf(1L));
            ((FbpEmployees)localObject1).setCreationDate(new Date());
            ((FbpEmployees)localObject1).setLastUpdateLogin(Long.valueOf(1L));
          }
          Object localObject4;
          if (!StringUtils.isEmpty(localEmployeeInfo.getDeptCode()))
          {
            localObject2 = localIFbpDeptsDAO.getFbpDeptsByCode(localEmployeeInfo.getDeptCode());
            if ((localObject2 == null) || (((FbpDepts)localObject2).getDeptId() == null))
            {
              localSendEmployeeProcessReult = setSendEmployeeProcessReult(localEmployeeInfo, Boolean.FALSE.booleanValue(), "部门编码[" + localEmployeeInfo.getDeptCode() + "]不存在!");
              localArrayList.add(localSendEmployeeProcessReult);
              localObject3 = localInteger2;
              localObject4 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
            }
            else
            {
              ((FbpEmployees)localObject1).setDeptId(((FbpDepts)localObject2).getDeptId());
            }
          }
          else
          {
            ((FbpEmployees)localObject1).setEmployeeNumber(localEmployeeInfo.getEmployeeCode());
            ((FbpEmployees)localObject1).setLastUpdateDate(new Date());
            ((FbpEmployees)localObject1).setEnabledFlag(getEnabedFlag(localEmployeeInfo.getStatus()));
            ((FbpEmployees)localObject1).setMobilePhone(localEmployeeInfo.getMobile());
            ((FbpEmployees)localObject1).setEmailAddress(localEmployeeInfo.getOfficeEmail());
            ((FbpEmployees)localObject1).setDeptBenchMarkCode(localEmployeeInfo.getDeptBenchmarkCode());
            ((FbpEmployees)localObject1).setDegree(localEmployeeInfo.getDegree());
            ((FbpEmployees)localObject1).setDocType(localEmployeeInfo.getDocType());
            ((FbpEmployees)localObject1).setDocNumber(localEmployeeInfo.getDocNumber());
            ((FbpEmployees)localObject1).setEntryDate(localEmployeeInfo.getEntryDate());
            ((FbpEmployees)localObject1).setDepartureDate(localEmployeeInfo.getDepartureDate());
            localObject2 = localEmployeeInfo.getRemark();
            localObject3 = null;
            if ((localObject2 != null) && (((String)localObject2).lastIndexOf("@") > -1))
            {
              ((FbpEmployees)localObject1).setPositionCode(((String)localObject2).substring(((String)localObject2).lastIndexOf("@") + 1));
              localObject3 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("@"));
            }
            else
            {
              localObject3 = localObject2;
            }
            if (((FbpEmployees)localObject1).getEmployeeId() == null) {
              localIFbpEmployeeDS.insertFbpEmployees((FbpEmployees)localObject1);
            } else {
              localIFbpEmployeeDS.updateFbpEmployees((FbpEmployees)localObject1);
            }
            localObject4 = localList1.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (LangType)((Iterator)localObject4).next();
              String str = DataSourceU.getLang(((LangType)localObject5).getCode());
              FbpEmployeesTlPk localFbpEmployeesTlPk = new FbpEmployeesTlPk();
              localFbpEmployeesTlPk.setEmployeeId(((FbpEmployees)localObject1).getEmployeeId());
              localFbpEmployeesTlPk.setLanguage(str);
              FbpEmployeesTl localFbpEmployeesTl = localIFbpEmployeesTlDAO.getFbpEmployeesTl(localFbpEmployeesTlPk);
              int j = 1;
              if (localFbpEmployeesTl == null)
              {
                localFbpEmployeesTl = new FbpEmployeesTl();
                localFbpEmployeesTl.setCreatedBy(Long.valueOf(1L));
                localFbpEmployeesTl.setLastUpdatedBy(Long.valueOf(1L));
                localFbpEmployeesTl.setCreationDate(new Date());
                localFbpEmployeesTl.setLastUpdateLogin(Long.valueOf(1L));
                localFbpEmployeesTl.setEmployeePkTl(localFbpEmployeesTlPk);
                localFbpEmployeesTl.setSourceLang(str);
                j = 0;
              }
              localFbpEmployeesTl.setLastUpdateDate(new Date());
              localFbpEmployeesTl.setEmployeeName(localEmployeeInfo.getEmployeeName());
              localFbpEmployeesTl.setDescription((String)localObject3);
              if (j != 0) {
                localIFbpEmployeesTlDAO.updateFbpEmployeesTl(localFbpEmployeesTl);
              } else {
                localIFbpEmployeesTlDAO.insertFbpEmployeesTl(localFbpEmployeesTl);
              }
            }
            localObject4 = localInteger1;
            Object localObject5 = localInteger1 = Integer.valueOf(localInteger1.intValue() + 1);
            localSendEmployeeProcessReult = setSendEmployeeProcessReult(localEmployeeInfo, Boolean.TRUE.booleanValue(), "");
            localArrayList.add(localSendEmployeeProcessReult);
          }
        }
      }
      catch (Exception localException)
      {
        this.log.error("同步人员信息异常:" + localException.getMessage(), localException);
        localSendEmployeeProcessReult = setSendEmployeeProcessReult(localEmployeeInfo, Boolean.FALSE.booleanValue(), "系统异常:" + localException.getMessage());
        localObject2 = localInteger2;
        Object localObject3 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
      }
    }
    localSendEmployeeResponse.setSuccessCount(localInteger1.intValue());
    localSendEmployeeResponse.setFailedCount(localInteger2.intValue());
    localSendEmployeeResponse.setProcessResult(localArrayList);
    return localSendEmployeeResponse;
  }
  
  public SendEmployeeProcessReult setSendEmployeeProcessReult(EmployeeInfo paramEmployeeInfo, boolean paramBoolean, String paramString)
  {
    SendEmployeeProcessReult localSendEmployeeProcessReult = new SendEmployeeProcessReult();
    localSendEmployeeProcessReult.setChangeType(paramEmployeeInfo.getChangeType());
    localSendEmployeeProcessReult.setResult(paramBoolean);
    localSendEmployeeProcessReult.setReason(paramString);
    localSendEmployeeProcessReult.setEmployeeChangeId(paramEmployeeInfo.getEmployeeChangeId());
    localSendEmployeeProcessReult.setEmployeeCode(paramEmployeeInfo.getEmployeeCode());
    return localSendEmployeeProcessReult;
  }
  
  public SendRoleInfoResponse syncRole(SendRoleInfoRequest paramSendRoleInfoRequest)
  {
    SendRoleInfoResponse localSendRoleInfoResponse = new SendRoleInfoResponse();
    ArrayList localArrayList1 = new ArrayList();
    SendRoleInfoProcessReult localSendRoleInfoProcessReult = null;
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(0);
    if ((paramSendRoleInfoRequest == null) || (paramSendRoleInfoRequest.getRoleInfo() == null) || (paramSendRoleInfoRequest.getRoleInfo().isEmpty()))
    {
      localSendRoleInfoProcessReult = new SendRoleInfoProcessReult();
      localSendRoleInfoProcessReult.setResult(Boolean.FALSE.booleanValue());
      localSendRoleInfoProcessReult.setReason("传入参数不能为空!");
      localArrayList1.add(localSendRoleInfoProcessReult);
      localSendRoleInfoResponse.setFailedCount(0);
      localSendRoleInfoResponse.setSuccessCount(0);
      localSendRoleInfoResponse.setProcessResult(localArrayList1);
      return localSendRoleInfoResponse;
    }
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    GamBaseRoleDAO localGamBaseRoleDAO = (GamBaseRoleDAO)SSBBus.findDomainService("gamBaseRoleDAO");
    String str = "select * from jam.gam_base_role r where r.enabled_flag = 'Y' and r.role_no =?";
    ArrayList localArrayList2 = new ArrayList();
    List localList = paramSendRoleInfoRequest.getRoleInfo();
    for (int i = 0; i < localList.size(); i++)
    {
      RoleInfo localRoleInfo = (RoleInfo)localList.get(i);
      localSendRoleInfoProcessReult = new SendRoleInfoProcessReult();
      try
      {
        if (localRoleInfo == null)
        {
          localSendRoleInfoProcessReult.setReason("传入参数不能为空!");
          localSendRoleInfoProcessReult.setResult(Boolean.FALSE.booleanValue());
          localArrayList1.add(localSendRoleInfoProcessReult);
          localObject1 = localInteger2;
          localObject2 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
          continue;
        }
        localArrayList2.clear();
        localArrayList2.add(localRoleInfo.getRoleBasCode());
        Object localObject1 = localIImageCommonDAO.findObjectBySQL(str, localArrayList2, GamBaseRole.class);
        localObject2 = null;
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          localObject2 = (GamBaseRole)((List)localObject1).get(0);
        }
        if (localObject2 == null)
        {
          localObject2 = new GamBaseRole();
          ((GamBaseRole)localObject2).setCreatedBy("10000");
          ((GamBaseRole)localObject2).setCreatedByName("系统管理员");
          ((GamBaseRole)localObject2).setCreatedDate(new Date());
          ((GamBaseRole)localObject2).setLastUpdatedBy("10000");
          ((GamBaseRole)localObject2).setLastUpdatedByName("系统管理员");
          ((GamBaseRole)localObject2).setSystemNo("SYS10000");
          ((GamBaseRole)localObject2).setEnterpriseNo("00");
          ((GamBaseRole)localObject2).setSystemName("默认当前系统");
          ((GamBaseRole)localObject2).setIsFired("Y");
          ((GamBaseRole)localObject2).setNum1(BigInteger.valueOf(0L));
          ((GamBaseRole)localObject2).setNum2(BigInteger.valueOf(0L));
          ((GamBaseRole)localObject2).setNum3(BigInteger.valueOf(0L));
          ((GamBaseRole)localObject2).setNum4(BigInteger.valueOf(0L));
          ((GamBaseRole)localObject2).setNum5(BigInteger.valueOf(0L));
        }
        ((GamBaseRole)localObject2).setLastUpdatedDate(new Date());
        ((GamBaseRole)localObject2).setRoleNo(localRoleInfo.getRoleBasCode());
        ((GamBaseRole)localObject2).setRoleName(localRoleInfo.getRoleName());
        ((GamBaseRole)localObject2).setRoleType(localRoleInfo.getRoleType());
        ((GamBaseRole)localObject2).setRoleCode(localRoleInfo.getRoleEnCode());
        ((GamBaseRole)localObject2).setEnabledFlag("3".equals(localRoleInfo.getChangeType()) ? "N" : "Y");
        try
        {
          ((GamBaseRole)localObject2).setSourceRoleId(BigInteger.valueOf(Long.valueOf(localRoleInfo.getRoleId()).longValue()));
        }
        catch (Exception localException2) {}
        if (((GamBaseRole)localObject2).getLineId() != null)
        {
          localGamBaseRoleDAO.updateGamBaseRole((GamBaseRole)localObject2);
        }
        else
        {
          localObject3 = localGamBaseRoleDAO.getNextSeq();
          ((GamBaseRole)localObject2).setLineId((BigInteger)localObject3);
          localGamBaseRoleDAO.insertGamBaseRole((GamBaseRole)localObject2);
        }
        localSendRoleInfoProcessReult = setSendRoleInfoProcessReult(localRoleInfo, "", Boolean.TRUE);
        localObject3 = localInteger1;
        Integer localInteger3 = localInteger1 = Integer.valueOf(localInteger1.intValue() + 1);
      }
      catch (Exception localException1)
      {
        localSendRoleInfoProcessReult = setSendRoleInfoProcessReult(localRoleInfo, "系统异常：" + localException1.getMessage(), Boolean.FALSE);
        this.log.error("同步角色异常：" + localException1.getMessage(), localException1);
        Object localObject2 = localInteger2;
        Object localObject3 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
        continue;
      }
      localArrayList1.add(localSendRoleInfoProcessReult);
    }
    localSendRoleInfoResponse.setSuccessCount(localInteger1.intValue());
    localSendRoleInfoResponse.setFailedCount(localInteger2.intValue());
    localSendRoleInfoResponse.setProcessResult(localArrayList1);
    return localSendRoleInfoResponse;
  }
  
  public SendRoleInfoProcessReult setSendRoleInfoProcessReult(RoleInfo paramRoleInfo, String paramString, Boolean paramBoolean)
  {
    SendRoleInfoProcessReult localSendRoleInfoProcessReult = new SendRoleInfoProcessReult();
    localSendRoleInfoProcessReult.setChangeType(paramRoleInfo.getChangeType());
    localSendRoleInfoProcessReult.setReason(paramString);
    localSendRoleInfoProcessReult.setResult(paramBoolean.booleanValue());
    localSendRoleInfoProcessReult.setRoleBasCode(paramRoleInfo.getRoleBasCode());
    localSendRoleInfoProcessReult.setRoleId(paramRoleInfo.getRoleId());
    localSendRoleInfoProcessReult.setRoleName(paramRoleInfo.getRoleName());
    return localSendRoleInfoProcessReult;
  }
  
  private String getEnabedFlag(String paramString)
  {
    if ("1".equals(paramString)) {
      return "Y";
    }
    return "N";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.user.syn.model.ds.UserSynDS
 * JD-Core Version:    0.7.0.1
 */