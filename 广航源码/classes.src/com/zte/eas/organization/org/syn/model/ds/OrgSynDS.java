package com.zte.eas.organization.org.syn.model.ds;

import com.cmcc.mss.msgheader.MsgHeader;
import com.cmcc.mss.nc_itf_guanghj_service.IHrService;
import com.cmcc.mss.nc_itf_guanghj_service.IHrServiceLocator;
import com.cmcc.mss.nc_itf_guanghj_service.IHrServiceSOAP11BindingStub;
import com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.InquiryORGInfoSrvOutputCollection;
import com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.SBEASEASInquiryORGInfoSrv;
import com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.SBEASEASInquiryORGInfoSrvRequest;
import com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.SBEASEASInquiryORGInfoSrvResponse;
import com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.SBEASEASInquiryORGInfoSrv_Service;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsDAO;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptMode;
import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTl;
import com.zte.eas.organization.org.syn.model.dao.IOrgSynDao;
import com.zte.ssb.framework.SSBBus;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class OrgSynDS
  implements IOrgSynDS
{
  private Logger log = Logger.getLogger(getClass());
  IOrgSynDao orgSynDao;
  
  public void doSynchHRDeptsInfo(String paramString)
    throws Exception
  {
    IFbpDeptsDAO localIFbpDeptsDAO = (IFbpDeptsDAO)SSBBus.findDaoService("fbpDeptsDAO");
    this.log.error("--------doSynchHRDeptsInfo start--------");
    IHrServiceLocator localIHrServiceLocator = new IHrServiceLocator();
    IHrServiceSOAP11BindingStub localIHrServiceSOAP11BindingStub = (IHrServiceSOAP11BindingStub)localIHrServiceLocator.getIHrServiceSOAP11port_http();
    String str = localIHrServiceSOAP11BindingStub.process(paramString);
    List localList = readDeptStringXml(str);
    syncDepts(localList);
    this.log.error("--------doSynchHRDeptsInfo end--------");
  }
  
  public List<FbpDeptMode> readDeptStringXml(String paramString)
  {
    IFbpDeptsDAO localIFbpDeptsDAO = (IFbpDeptsDAO)SSBBus.findDaoService("fbpDeptsDAO");
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
        Iterator localIterator2 = localElement2.elementIterator("Department");
        while (localIterator2.hasNext())
        {
          FbpDeptMode localFbpDeptMode = new FbpDeptMode();
          Element localElement3 = (Element)localIterator2.next();
          BigInteger localBigInteger = localIFbpDeptsDAO.getFbpDeptsByCode(localElement3.elementTextTrim("CDEPCLASSCODE") == null ? null : localElement3.elementTextTrim("CDEPCLASSCODE")).getDeptId();
          localFbpDeptMode.setDeptCode(localElement3.elementTextTrim("CDEPCODE") == null ? null : localElement3.elementTextTrim("CDEPCODE"));
          localFbpDeptMode.setEnabledFlag(localElement3.elementTextTrim("bFlag") == null ? null : localElement3.elementTextTrim("bFlag"));
          localFbpDeptMode.setLastUpdateDate(new Date(localElement3.elementTextTrim("dUpdate") == null ? null : localElement3.elementTextTrim("dUpdate")));
          localFbpDeptMode.setParentDeptId(localBigInteger);
          localFbpDeptMode.setDeptName(localElement3.elementTextTrim("CDEPNAME") == null ? null : localElement3.elementTextTrim("CDEPNAME"));
          localArrayList.add(localFbpDeptMode);
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
  
  public void syncDepts(List<FbpDeptMode> paramList)
  {
    IFbpDeptsDAO localIFbpDeptsDAO = (IFbpDeptsDAO)SSBBus.findDaoService("fbpDeptsDAO");
    String[] arrayOfString = { "ZHS", "EN" };
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FbpDeptMode localFbpDeptMode = (FbpDeptMode)localIterator.next();
      FbpDepts localFbpDepts = localIFbpDeptsDAO.getFbpDeptsByCode(localFbpDeptMode.getDeptCode());
      if (localFbpDepts != null)
      {
        localFbpDepts.setDeptCode(localFbpDeptMode.getDeptCode());
        localFbpDepts.setParentDeptId(localFbpDeptMode.getParentDeptId());
        localFbpDepts.setLastUpdateDate(localFbpDeptMode.getLastUpdateDate());
        localFbpDepts.setEnabledFlag(localFbpDeptMode.getEnabledFlag());
        localIFbpDeptsDAO.updateFbpDepts(localFbpDepts);
        for (int i = 0; i < arrayOfString.length; i++)
        {
          FbpDeptsTl localFbpDeptsTl1 = localIFbpDeptsDAO.findFbpDeptsTls(localFbpDepts.getDeptId(), arrayOfString[i]);
          if (localFbpDeptsTl1 == null)
          {
            localFbpDeptsTl1.setLastUpdateDate(localFbpDeptMode.getLastUpdateDate());
            localFbpDeptsTl1.setLastUpdatedBy(Long.valueOf(10000L));
            localFbpDeptsTl1.setLastUpdateLogin(Long.valueOf(10000L));
            localFbpDeptsTl1.setCreationDate(new Date());
            localFbpDeptsTl1.setCreationDate(new Date());
            localFbpDeptsTl1.setLanguage(arrayOfString[i]);
            localFbpDeptsTl1.setDeptName(localFbpDeptMode.getDeptName());
            localFbpDeptsTl1.setDeptId(localFbpDepts.getDeptId());
            localIFbpDeptsDAO.insertFbpDeptsTl(localFbpDeptsTl1);
          }
          else
          {
            localFbpDeptsTl1.setDeptName(localFbpDeptMode.getDeptName());
            localIFbpDeptsDAO.updateFbpDeptsTl(localFbpDeptsTl1);
          }
        }
      }
      else
      {
        localFbpDepts.setLastUpdatedBy(Long.valueOf(10000L));
        localFbpDepts.setLastUpdateLogin(Long.valueOf(10000L));
        localFbpDepts.setCreationDate(new Date());
        localFbpDepts.setCreationDate(new Date());
        localFbpDepts.setDeptCode(localFbpDeptMode.getDeptCode());
        localFbpDepts.setParentDeptId(localFbpDeptMode.getParentDeptId());
        localFbpDepts.setLastUpdateDate(localFbpDeptMode.getLastUpdateDate());
        localFbpDepts.setEnabledFlag(localFbpDeptMode.getEnabledFlag());
        localIFbpDeptsDAO.insertFbpDepts(localFbpDepts);
        BigInteger localBigInteger = localIFbpDeptsDAO.getFbpDeptsByCode(localFbpDeptMode.getDeptCode()).getDeptId();
        for (int j = 0; j < arrayOfString.length; j++)
        {
          FbpDeptsTl localFbpDeptsTl2 = localIFbpDeptsDAO.findFbpDeptsTls(localBigInteger, arrayOfString[j]);
          if (localFbpDeptsTl2 == null)
          {
            localFbpDeptsTl2.setLastUpdateDate(localFbpDeptMode.getLastUpdateDate());
            localFbpDeptsTl2.setLastUpdatedBy(Long.valueOf(10000L));
            localFbpDeptsTl2.setLastUpdateLogin(Long.valueOf(10000L));
            localFbpDeptsTl2.setCreationDate(new Date());
            localFbpDeptsTl2.setCreationDate(new Date());
            localFbpDeptsTl2.setLanguage(arrayOfString[j]);
            localFbpDeptsTl2.setDeptName(localFbpDeptMode.getDeptName());
            localFbpDeptsTl2.setDeptId(localFbpDepts.getDeptId());
            localIFbpDeptsDAO.insertFbpDeptsTl(localFbpDeptsTl2);
          }
          else
          {
            localFbpDeptsTl2.setDeptName(localFbpDeptMode.getDeptName());
            localIFbpDeptsDAO.updateFbpDeptsTl(localFbpDeptsTl2);
          }
        }
      }
    }
  }
  
  public SBEASEASInquiryORGInfoSrvResponse findOrg(SBEASEASInquiryORGInfoSrvRequest paramSBEASEASInquiryORGInfoSrvRequest)
  {
    this.log.error("-------SB_EAS_EAS_InquiryORGInfoSrv查询部门信息服务 开始-----");
    this.log.error("Request MsgHeader SOURCE_SYSTEM_ID:" + paramSBEASEASInquiryORGInfoSrvRequest.getMsgHeader().getSOURCESYSTEMID());
    this.log.error("Request MsgHeader SOURCE_SYSTEM_NAME:" + paramSBEASEASInquiryORGInfoSrvRequest.getMsgHeader().getSOURCESYSTEMNAME());
    this.log.error("Request MsgHeader USER_ID:" + paramSBEASEASInquiryORGInfoSrvRequest.getMsgHeader().getUSERID());
    this.log.error("Request MsgHeader USER_NAME:" + paramSBEASEASInquiryORGInfoSrvRequest.getMsgHeader().getUSERNAME());
    this.log.error("Request MsgHeader SUBMIT_DATE:" + paramSBEASEASInquiryORGInfoSrvRequest.getMsgHeader().getSUBMITDATE().toGregorianCalendar().getTime());
    this.log.error("Request DEPT_ID:" + paramSBEASEASInquiryORGInfoSrvRequest.getDEPTID());
    this.log.error("Request DEPT_CODE:" + paramSBEASEASInquiryORGInfoSrvRequest.getDEPTCODE());
    this.log.error("Request START_LAST_UPDATE_DATE:" + paramSBEASEASInquiryORGInfoSrvRequest.getSTARTLASTUPDATEDATE().toGregorianCalendar().getTime());
    this.log.error("Request END_LAST_UPDATE_DATE:" + paramSBEASEASInquiryORGInfoSrvRequest.getENDLASTUPDATEDATE().toGregorianCalendar().getTime());
    SBEASEASInquiryORGInfoSrv_Service localSBEASEASInquiryORGInfoSrv_Service = new SBEASEASInquiryORGInfoSrv_Service();
    SBEASEASInquiryORGInfoSrv localSBEASEASInquiryORGInfoSrv = localSBEASEASInquiryORGInfoSrv_Service.getSBEASEASInquiryORGInfoSrvPort();
    SBEASEASInquiryORGInfoSrvResponse localSBEASEASInquiryORGInfoSrvResponse = new SBEASEASInquiryORGInfoSrvResponse();
    try
    {
      localSBEASEASInquiryORGInfoSrvResponse = localSBEASEASInquiryORGInfoSrv.process(paramSBEASEASInquiryORGInfoSrvRequest);
      if (localSBEASEASInquiryORGInfoSrvResponse != null)
      {
        this.log.error("Response INSTANCE_ID" + localSBEASEASInquiryORGInfoSrvResponse.getINSTANCEID());
        this.log.error("Response SERVICE_FLAG" + localSBEASEASInquiryORGInfoSrvResponse.getSERVICEFLAG());
        this.log.error("Response SERVICE_MESSAGE" + localSBEASEASInquiryORGInfoSrvResponse.getSERVICEMESSAGE());
        this.log.error("Response dept size" + localSBEASEASInquiryORGInfoSrvResponse.getInquiryORGInfoSrvOutputCollection().getInquiryORGInfoSrvOutputItem().size());
        if ("Y".equals(localSBEASEASInquiryORGInfoSrvResponse.getSERVICEFLAG()))
        {
          InquiryORGInfoSrvOutputCollection localInquiryORGInfoSrvOutputCollection = localSBEASEASInquiryORGInfoSrvResponse.getInquiryORGInfoSrvOutputCollection();
          IOrgSynDao localIOrgSynDao = (IOrgSynDao)SSBBus.findDomainService("orgSynDao");
          localIOrgSynDao.findOrg(localInquiryORGInfoSrvOutputCollection.getInquiryORGInfoSrvOutputItem());
        }
      }
    }
    catch (Exception localException)
    {
      this.log.error("Exception:", localException);
    }
    this.log.error("-------SB_EAS_EAS_InquiryORGInfoSrv查询部门信息服务 结束-----");
    return localSBEASEASInquiryORGInfoSrvResponse;
  }
  
  public IOrgSynDao getOrgSynDao()
  {
    return this.orgSynDao;
  }
  
  public void setOrgSynDao(IOrgSynDao paramIOrgSynDao)
  {
    this.orgSynDao = paramIOrgSynDao;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.org.syn.model.ds.OrgSynDS
 * JD-Core Version:    0.7.0.1
 */