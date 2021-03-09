package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.flowruleengine.business.posstru.model.FbpSitesRelations;
import com.zte.eas.flowruleengine.business.posstru.model.FbpUsersRelations;
import com.zte.eimage.access.baseconfig.dao.IFrontUserDao;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.eimage.business.baseconfig.model.CompanyInfo;
import com.zte.eimage.business.baseconfig.model.EidSites;
import com.zte.eimage.business.baseconfig.model.FrontUser;
import com.zte.eimage.business.baseconfig.model.FrontUserV;
import com.zte.eimage.business.baseconfig.model.OperationTypeInfo;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FrontUserService
  implements IFrontUserService
{
  private IFrontUserDao frontUserDao;
  
  public void insertFrontUser(FrontUser paramFrontUser)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    paramFrontUser.setLastUpdateLogin(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    paramFrontUser.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    paramFrontUser.setLastUpdateDate(new Date());
    paramFrontUser.setCreatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    paramFrontUser.setCreationDate(new Date());
    String[] arrayOfString1 = paramFrontUser.getCompanyIds().split(",");
    String[] arrayOfString2 = paramFrontUser.getSiteIds().split(",");
    Object localObject;
    if ((paramFrontUser.getCompanyIds() != null) && (!"".equals(paramFrontUser.getCompanyIds())))
    {
      this.frontUserDao.delOldSitesRelations(Long.valueOf(paramFrontUser.getEmployeeId().longValue()));
      for (int i = 0; i < arrayOfString1.length; i++)
      {
        localObject = new FbpSitesRelations();
        ObjectCopyUtils.setWho(localObject);
        ((FbpSitesRelations)localObject).setCompanyId(Long.valueOf(arrayOfString1[i]));
        ((FbpSitesRelations)localObject).setEmployeeId(Long.valueOf(paramFrontUser.getEmployeeId().longValue()));
        ((FbpSitesRelations)localObject).setEnabledFlag("Y");
        ((FbpSitesRelations)localObject).setSiteId(Long.valueOf(arrayOfString2[i]));
        this.frontUserDao.insertSitesRelation((FbpSitesRelations)localObject);
      }
    }
    String[] arrayOfString3 = paramFrontUser.getOperationTypeIds().split(",");
    if ((!"".equals(paramFrontUser.getOperationTypeIds())) && (paramFrontUser.getOperationTypeIds() != null))
    {
      this.frontUserDao.delOldUsersRelations(Long.valueOf(paramFrontUser.getEmployeeId().longValue()));
      for (String str : arrayOfString3)
      {
        FbpUsersRelations localFbpUsersRelations = new FbpUsersRelations();
        ObjectCopyUtils.setWho(localFbpUsersRelations);
        localFbpUsersRelations.setEmployeeId(Long.valueOf(paramFrontUser.getEmployeeId().longValue()));
        localFbpUsersRelations.setEnabledFlag("Y");
        localFbpUsersRelations.setOperationTypeId(Long.valueOf(str));
        this.frontUserDao.insertUsersRelation(localFbpUsersRelations);
      }
    }
    this.frontUserDao.insertFrontUser(paramFrontUser);
  }
  
  public FrontUserV findFrontUserById(Integer paramInteger)
  {
    String str1 = "FROM FrontUserV u WHERE u.frontUserId = " + paramInteger;
    FrontUserV localFrontUserV = (FrontUserV)this.frontUserDao.getObject(str1);
    if (localFrontUserV != null)
    {
      String str2 = "select (select wm_concat(fs.company_id)          from fbp.FBP_SITES_RELATIONS fs         where fs.EMPLOYEE_ID = u.EMPLOYEE_ID) company_ids,       (select zj_concat(ctl.company_name)          from fbp_company_tl ctl, fbp.FBP_SITES_RELATIONS fs         where ctl.company_id = fs.company_id           and ctl.language = ZAS_ENV_PKG.getLang()           and fs.EMPLOYEE_ID = U.EMPLOYEE_ID) company_names,       (select wm_concat(es.site_id)          from EID_SITES es, fbp_company fc, fbp.FBP_SITES_RELATIONS fs         where es.company_id = fc.company_id           and fc.company_id = fs.company_id           and fs.EMPLOYEE_ID = U.EMPLOYEE_ID) site_ids,       (select wm_concat(es.site_name)          from EID_SITES es, fbp_company fc, fbp.FBP_SITES_RELATIONS fs         where es.company_id = fc.company_id           and fc.company_id = fs.company_id           and fs.EMPLOYEE_ID = U.EMPLOYEE_ID) site_names  FROM EID_FRONT_USERS U where front_user_id = " + localFrontUserV.getFrontUserId();
      IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
      String[] arrayOfString = localIImageCommonDAO.getClobToString(str2, null, 4);
      if ((arrayOfString != null) && (arrayOfString.length >= 4))
      {
        localFrontUserV.setCompanyIds(arrayOfString[0]);
        localFrontUserV.setCompanyNames(arrayOfString[1]);
        localFrontUserV.setSiteIds(arrayOfString[2]);
        localFrontUserV.setSiteNames(arrayOfString[3]);
      }
    }
    return localFrontUserV;
  }
  
  public FrontUserV findFrontUserByEmpId(Integer paramInteger)
  {
    String str = "FROM FrontUserV u WHERE u.employeeId = " + paramInteger;
    Object localObject = this.frontUserDao.getObject(str);
    if (null == localObject) {
      return null;
    }
    return (FrontUserV)localObject;
  }
  
  public EidSites findFrontUserByEid(Integer paramInteger)
  {
    String str = "FROM EidSites u WHERE u.siteId = " + paramInteger;
    Object localObject = this.frontUserDao.getObject(str);
    if (null == localObject) {
      return null;
    }
    return (EidSites)localObject;
  }
  
  public List findFrontUserByEmpIds(Integer paramInteger)
  {
    String str = "FROM FbpEmpCompanyOperaV u WHERE u.employeeId = " + paramInteger;
    List localList = this.frontUserDao.getCompanyId(str);
    if (null == localList) {
      return null;
    }
    return localList;
  }
  
  public void updateFrontUser(FrontUser paramFrontUser)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FrontUser localFrontUser = this.frontUserDao.findFrontUserById(paramFrontUser.getFrontUserId());
    localFrontUser.setEmployeeId(paramFrontUser.getEmployeeId());
    localFrontUser.setCheckUnit(paramFrontUser.getCheckUnit());
    localFrontUser.setUploadMode(paramFrontUser.getUploadMode());
    localFrontUser.setSiteId(paramFrontUser.getSiteId());
    localFrontUser.setUserPurview(paramFrontUser.getUserPurview());
    localFrontUser.setEnabledFlag(paramFrontUser.getEnabledFlag());
    localFrontUser.setCompanyId(paramFrontUser.getCompanyId());
    localFrontUser.setUploadGroup(paramFrontUser.getUploadGroup());
    localFrontUser.setStartHour(paramFrontUser.getStartHour());
    localFrontUser.setStartMinute(paramFrontUser.getStartMinute());
    localFrontUser.setEndHour(paramFrontUser.getEndHour());
    localFrontUser.setEndMinute(paramFrontUser.getEndMinute());
    localFrontUser.setLastUpdateLogin(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    localFrontUser.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    localFrontUser.setLastUpdateDate(new Date());
    this.frontUserDao.delOldSitesRelations(Long.valueOf(paramFrontUser.getEmployeeId().longValue()));
    String[] arrayOfString1;
    String[] arrayOfString2;
    int i;
    if ((paramFrontUser.getCompanyIds() != null) && (!"".equals(paramFrontUser.getCompanyIds())))
    {
      arrayOfString1 = paramFrontUser.getCompanyIds().split(",");
      arrayOfString2 = paramFrontUser.getSiteIds().split(",");
      for (i = 0; i < arrayOfString1.length; i++)
      {
        FbpSitesRelations localFbpSitesRelations = new FbpSitesRelations();
        ObjectCopyUtils.setWho(localFbpSitesRelations);
        localFbpSitesRelations.setCompanyId(Long.valueOf(arrayOfString1[i]));
        localFbpSitesRelations.setEmployeeId(Long.valueOf(paramFrontUser.getEmployeeId().longValue()));
        localFbpSitesRelations.setEnabledFlag("Y");
        localFbpSitesRelations.setSiteId(Long.valueOf(arrayOfString2[i]));
        this.frontUserDao.insertSitesRelation(localFbpSitesRelations);
      }
    }
    this.frontUserDao.delOldUsersRelations(Long.valueOf(paramFrontUser.getEmployeeId().longValue()));
    if ((!"".equals(paramFrontUser.getOperationTypeIds())) && (paramFrontUser.getOperationTypeIds() != null))
    {
      arrayOfString1 = paramFrontUser.getOperationTypeIds().split(",");
      for (String str : arrayOfString1)
      {
        FbpUsersRelations localFbpUsersRelations = new FbpUsersRelations();
        ObjectCopyUtils.setWho(localFbpUsersRelations);
        localFbpUsersRelations.setEmployeeId(Long.valueOf(paramFrontUser.getEmployeeId().longValue()));
        localFbpUsersRelations.setEnabledFlag("Y");
        localFbpUsersRelations.setOperationTypeId(Long.valueOf(str));
        this.frontUserDao.insertUsersRelation(localFbpUsersRelations);
      }
    }
    this.frontUserDao.updateFrontUser(localFrontUser);
  }
  
  public TableDataInfo findFrontUser(FrontUserV paramFrontUserV, Integer paramInteger1, Integer paramInteger2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.frontUserDao.findFrontUser(paramFrontUserV, paramInteger1, paramInteger2);
    List localList = (List)localPageInfo.getResult();
    localTableDataInfo.setData(localList);
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public Integer isExistsEmployeeId(Integer paramInteger)
  {
    String str = "FROM FrontUser u WHERE u.employeeId = " + paramInteger;
    return this.frontUserDao.getCount(str);
  }
  
  public String isExistsCompanyId(String paramString)
  {
    String str1 = "fail";
    String str2 = "select distinct s.company_id from eid.eid_sites s where s.company_id in (" + paramString + ")";
    List localList = this.frontUserDao.getCompanyId(str2);
    if (localList.size() > 0)
    {
      String[] arrayOfString = paramString.split(",");
      if (localList.size() == arrayOfString.length) {
        str1 = "succ";
      } else {
        str1 = "fail";
      }
    }
    return str1;
  }
  
  public IFrontUserDao getFrontUserDao()
  {
    return this.frontUserDao;
  }
  
  public void setFrontUserDao(IFrontUserDao paramIFrontUserDao)
  {
    this.frontUserDao = paramIFrontUserDao;
  }
  
  public CompanyInfo[] findCompanyInfos(Long paramLong, String paramString)
  {
    String str = "select rs.site_id, fc.company_code, fct.company_name from fbp_sites_relations rs, fbp_company fc, fbp_company_tl fct where rs.company_id = fc.company_id and fc.company_id = fct.company_id and fct.language = ? and rs.employee_id = ?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localArrayList.add(paramLong);
    List localList = this.frontUserDao.findObjectsBySql(str, localArrayList, null);
    if ((localList != null) && (!localList.isEmpty()))
    {
      CompanyInfo[] arrayOfCompanyInfo = new CompanyInfo[localList.size()];
      for (int i = 0; i < localList.size(); i++)
      {
        Object[] arrayOfObject = (Object[])localList.get(i);
        CompanyInfo localCompanyInfo = new CompanyInfo();
        localCompanyInfo.setSiteId(Long.valueOf((arrayOfObject[0] == null ? Integer.valueOf(0) : arrayOfObject[0]).toString()));
        localCompanyInfo.setCompanyCode((arrayOfObject[1] == null ? "" : arrayOfObject[1]).toString());
        localCompanyInfo.setCompanyName((arrayOfObject[2] == null ? "" : arrayOfObject[2]).toString());
        arrayOfCompanyInfo[i] = localCompanyInfo;
      }
      return arrayOfCompanyInfo;
    }
    return null;
  }
  
  public OperationTypeInfo[] findOperationTypeInfos(Long paramLong, String paramString)
  {
    String str = "select ot.operation_type_code, ott.operation_type_name from fbp_users_relations    ur, fbp_operation_types    ot, fbp_operation_types_tl ott where ur.operation_type_id = ot.operation_type_id and ot.operation_type_id = ott.operation_type_id and ott.language = ? and ur.employee_id = ?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localArrayList.add(paramLong);
    List localList = this.frontUserDao.findObjectsBySql(str, localArrayList, null);
    if ((localList != null) && (!localList.isEmpty()))
    {
      OperationTypeInfo[] arrayOfOperationTypeInfo = new OperationTypeInfo[localList.size()];
      for (int i = 0; i < localList.size(); i++)
      {
        Object[] arrayOfObject = (Object[])localList.get(i);
        OperationTypeInfo localOperationTypeInfo = new OperationTypeInfo();
        localOperationTypeInfo.setOperationTypeCode((arrayOfObject[0] == null ? "" : arrayOfObject[0]).toString());
        localOperationTypeInfo.setOperationTypeName((arrayOfObject[1] == null ? "" : arrayOfObject[1]).toString());
        arrayOfOperationTypeInfo[i] = localOperationTypeInfo;
      }
      return arrayOfOperationTypeInfo;
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.FrontUserService
 * JD-Core Version:    0.7.0.1
 */