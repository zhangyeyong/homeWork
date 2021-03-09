package com.zte.eas.appframe.business.synrequest.service;

import com.zte.eas.appframe.access.synrequest.dao.IFbpSynchRequestsDAO;
import com.zte.eas.appframe.access.synrequest.dao.IFbpSynchRequestsVDAO;
import com.zte.eas.appframe.access.synrequest.dao.SyncVoucherThread;
import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequests;
import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.appframe.sync.SyncClient;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.eas.organization.business.countcompanymanage.service.IFbpCompanyVDS;
import com.zte.eas.organization.org.syn.model.ds.IOrgSynDS;
import com.zte.eas.organization.user.syn.model.ds.IUserSynDS;
import com.zte.eas.resconfig.business.lookup.service.IFbpLookupTypesDS;
import com.zte.eas.wsf.ssc.SynBalanceCompany;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import java.io.PrintStream;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

public class FbpSynchRequestsDS
  extends BaseDomainService
  implements IFbpSynchRequestsDS
{
  private Logger log = Logger.getLogger(getClass());
  private IFbpSynchRequestsDAO fbpSynchRequestsDAO;
  private IFbpSynchRequestsVDAO fbpSynchRequestsVDAO;
  static final String YO = "启用";
  static final String NO = "暂挂";
  static final String SAVESUCESS = "savesucess";
  static final String SAVEFAILD = "savefaild";
  static final String SYNC_FALG_A = "aa";
  static final String SYNC_FALG_B = "bb";
  static final String SAVEFILED = "c";
  static final String INSERTSUCCEED = "insertsucceed";
  static final String SYNCHREQUESTIDVALUE = "0";
  static final String UPDATESUCEES = "updatesucess";
  static final String UPDATEFAILD = "updatefaild";
  static final String SAVEFILED_SAME_NO = "savefaildsameno";
  static final String EASLOGIN_USERINFO = "easloginuserinfo";
  IFbpLookupTypesDS lookupTypesDS = null;
  private String hour = null;
  private String minute = null;
  private String yearday = null;
  private String yearday1 = null;
  private String hour1 = null;
  private String minute1 = null;
  IOrgSynDS orgSynDS;
  
  public FbpSynchRequestsV findSynchRequestsVById(String paramString)
  {
    System.out.println("adfasfasfas");
    FbpSynchRequestsV localFbpSynchRequestsV = this.fbpSynchRequestsVDAO.findSynchRequestsVById(paramString);
    return localFbpSynchRequestsV;
  }
  
  public TableDataInfo findSynchRequestsVByCon(FbpSynchRequestsV paramFbpSynchRequestsV, String paramString1, String paramString2)
  {
    PageInfo localPageInfo = this.fbpSynchRequestsVDAO.findSynchRequestsVByCon(paramFbpSynchRequestsV, new Integer(paramString1).intValue(), new Integer(paramString2).intValue());
    List localList = (List)localPageInfo.getResult();
    for (int i = 0; i < localList.size(); i++)
    {
      FbpSynchRequestsV localFbpSynchRequestsV = (FbpSynchRequestsV)localList.get(i);
      if ((localFbpSynchRequestsV.getStatus() != null) && (!localFbpSynchRequestsV.getStatus().equals("")))
      {
        if (localFbpSynchRequestsV.getStatus().equals("Y")) {
          localFbpSynchRequestsV.setAttribute3("启用");
        }
        if (localFbpSynchRequestsV.getStatus().equals("N")) {
          localFbpSynchRequestsV.setAttribute3("暂挂");
        }
      }
    }
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public String startupSynchRequest(String paramString)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpSynchRequests localFbpSynchRequests = new FbpSynchRequests();
    FbpSynchRequestsV localFbpSynchRequestsV = this.fbpSynchRequestsVDAO.findSynchRequestsVById(paramString);
    localFbpSynchRequestsV.setLastUpdateDate(new Date());
    localFbpSynchRequestsV.setCreationDate(new Date());
    localFbpSynchRequestsV.setCreatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    localFbpSynchRequestsV.setLastUpdatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    if ((localFbpSynchRequestsV.getStatus() != null) && (localFbpSynchRequestsV.getStatus().equals("Y"))) {
      localFbpSynchRequestsV.setStatus("N");
    } else {
      localFbpSynchRequestsV.setStatus("Y");
    }
    ObjectCopyUtils.copy(localFbpSynchRequestsV, localFbpSynchRequests);
    this.fbpSynchRequestsDAO.update(localFbpSynchRequests);
    return null;
  }
  
  public String setHrServiceParaStr(String paramString, Date paramDate)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<EBusReq>");
    localStringBuffer.append("<fromSys></fromSys>");
    localStringBuffer.append("<loginPassword></loginPassword>");
    localStringBuffer.append("<loginUsername></loginUsername>");
    localStringBuffer.append("<txId></txId>");
    if (paramString.equals("DEPT_SYNCH_INF")) {
      localStringBuffer.append("<serviceId>EAS_IN_01</serviceId>");
    } else if (paramString.equals("SYNCH_EMPLOYEES_INFO")) {
      localStringBuffer.append("<serviceId>EAS_IN_02</serviceId>");
    }
    localStringBuffer.append("<data>");
    localStringBuffer.append("<LAST_UPDATE_DATE>" + paramDate + "</LAST_UPDATE_DATE>");
    localStringBuffer.append("</data>");
    localStringBuffer.append("</EBusReq>");
    return localStringBuffer.toString();
  }
  
  public static Date getBeforeDay(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(5, -1);
    paramDate = localCalendar.getTime();
    return paramDate;
  }
  
  public String runSynchRequest(String paramString)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpSynchRequests localFbpSynchRequests = new FbpSynchRequests();
    FbpSynchRequestsV localFbpSynchRequestsV = this.fbpSynchRequestsVDAO.findSynchRequestsVById(paramString);
    String str = "";
    try
    {
      boolean bool = false;
      if ((localFbpSynchRequestsV != null) && (localFbpSynchRequestsV.getSynchType() != null))
      {
        Object localObject;
        if (localFbpSynchRequestsV.getSynchType().equals("DEPT_SYNCH_INF"))
        {
          localObject = (IOrgSynDS)SSBBus.findDomainService("orgSynDS");
          str = setHrServiceParaStr("DEPT_SYNCH_INF", getBeforeDay(new Date()));
          ((IOrgSynDS)localObject).doSynchHRDeptsInfo(str);
        }
        else if (localFbpSynchRequestsV.getSynchType().equals("SYNCH_EMPLOYEES_INFO"))
        {
          localObject = (IUserSynDS)SSBBus.findDomainService("userSynDS");
          str = setHrServiceParaStr("SYNCH_EMPLOYEES_INFO", getBeforeDay(new Date()));
          ((IUserSynDS)localObject).synEmployeeFromHr(str);
        }
        else if ("SYNCH_BALANCE_COMPANY".equals(localFbpSynchRequestsV.getSynchType()))
        {
          localObject = localFbpSynchRequestsV.getLastRunTime();
          Date localDate = new Date();
          synBalanceCompany((Date)localObject, localDate);
          bool = true;
        }
        else if ("SYNC_VOUCHER".equals(localFbpSynchRequestsV.getSynchType()))
        {
          localObject = new SyncVoucherThread();
          ((SyncVoucherThread)localObject).setLastRunDate(localFbpSynchRequestsV.getLastRunTime());
          ((SyncVoucherThread)localObject).setSynchRequestId(Long.valueOf(paramString));
          ((SyncVoucherThread)localObject).start();
          bool = true;
        }
        else if ("SYNC_IMAGE_EID_TO_EVS".equals(localFbpSynchRequestsV.getSynchType()))
        {
          bool = this.fbpSynchRequestsDAO.syncImage();
        }
        else
        {
          bool = SyncClient.syncData(localFbpSynchRequestsV);
        }
      }
      if (bool)
      {
        localFbpSynchRequestsV.setLastUpdateDate(new Date());
        localFbpSynchRequestsV.setLastRunTime(new Date());
        localFbpSynchRequestsV.setLastUpdatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
        if ("N".equals(localFbpSynchRequestsV.getStatus())) {
          localFbpSynchRequestsV.setStatus("Y");
        }
        ObjectCopyUtils.copy(localFbpSynchRequestsV, localFbpSynchRequests);
        localFbpSynchRequests.setAttribute4("运行成功");
        this.fbpSynchRequestsDAO.update(localFbpSynchRequests);
      }
      else
      {
        if ("N".equals(localFbpSynchRequestsV.getStatus())) {
          localFbpSynchRequestsV.setStatus("Y");
        }
        localFbpSynchRequestsV.setLastUpdateDate(new Date());
        localFbpSynchRequestsV.setLastUpdatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
        ObjectCopyUtils.copy(localFbpSynchRequestsV, localFbpSynchRequests);
        localFbpSynchRequests.setAttribute4("运行超时");
        this.fbpSynchRequestsDAO.update(localFbpSynchRequests);
      }
    }
    catch (Exception localException)
    {
      this.log.error("Exception:", localException);
    }
    return null;
  }
  
  public String autoRunSynchRequest(FbpSynchRequestsV paramFbpSynchRequestsV)
  {
    FbpSynchRequests localFbpSynchRequests = new FbpSynchRequests();
    String str = "";
    try
    {
      boolean bool = false;
      if ((paramFbpSynchRequestsV != null) && (paramFbpSynchRequestsV.getSynchType() != null))
      {
        Object localObject;
        if (paramFbpSynchRequestsV.getSynchType().equals("DEPT_SYNCH_INF"))
        {
          localObject = (IOrgSynDS)SSBBus.findDomainService("orgSynDS");
          ((IOrgSynDS)localObject).doSynchHRDeptsInfo(str);
        }
        else if (paramFbpSynchRequestsV.getSynchType().equals("SYNCH_EMPLOYEES_INFO"))
        {
          localObject = (IUserSynDS)SSBBus.findDomainService("userSynDS");
          str = setHrServiceParaStr("SYNCH_EMPLOYEES_INFO", getBeforeDay(new Date()));
          ((IUserSynDS)localObject).synEmployeeFromHr(str);
        }
        else if (paramFbpSynchRequestsV.getSynchType().equals("SYNCH_BALANCE_COMPANY"))
        {
          localObject = paramFbpSynchRequestsV.getLastRunTime();
          Date localDate = new Date();
          synBalanceCompany((Date)localObject, localDate);
          bool = true;
        }
        else if (paramFbpSynchRequestsV.getSynchType().equals("SYNC_ATTACHMENT"))
        {
          this.fbpSynchRequestsDAO.syncAttachment();
        }
        else if ("SYNC_VOUCHER".equals(paramFbpSynchRequestsV.getSynchType()))
        {
          localObject = new SyncVoucherThread();
          ((SyncVoucherThread)localObject).setLastRunDate(paramFbpSynchRequestsV.getLastRunTime());
          ((SyncVoucherThread)localObject).setSynchRequestId(paramFbpSynchRequestsV.getSynchRequestId());
          ((SyncVoucherThread)localObject).start();
          bool = true;
        }
        else if ("SYNC_IMAGE_EID_TO_EVS".equals(paramFbpSynchRequestsV.getSynchType()))
        {
          bool = this.fbpSynchRequestsDAO.syncImage();
        }
        else
        {
          bool = SyncClient.syncData(paramFbpSynchRequestsV);
        }
      }
      if (bool)
      {
        paramFbpSynchRequestsV.setLastUpdateDate(new Date());
        paramFbpSynchRequestsV.setLastUpdatedBy(new Long(-1L));
        paramFbpSynchRequestsV.setLastRunTime(new Date());
        if ("N".equals(paramFbpSynchRequestsV.getStatus())) {
          paramFbpSynchRequestsV.setStatus("Y");
        }
        ObjectCopyUtils.copy(paramFbpSynchRequestsV, localFbpSynchRequests);
        localFbpSynchRequests.setAttribute4("运行成功");
        this.fbpSynchRequestsDAO.update(localFbpSynchRequests);
      }
      else
      {
        if ("N".equals(paramFbpSynchRequestsV.getStatus())) {
          paramFbpSynchRequestsV.setStatus("Y");
        }
        paramFbpSynchRequestsV.setLastUpdateDate(new Date());
        paramFbpSynchRequestsV.setLastUpdatedBy(new Long(-1L));
        ObjectCopyUtils.copy(paramFbpSynchRequestsV, localFbpSynchRequests);
        localFbpSynchRequests.setAttribute4("运行超时");
        this.fbpSynchRequestsDAO.update(localFbpSynchRequests);
      }
    }
    catch (Exception localException)
    {
      this.log.error("Exception:", localException);
    }
    return null;
  }
  
  private synchronized void synBalanceCompany(Date paramDate1, Date paramDate2)
    throws RemoteException
  {
    IFbpCompanyVDS localIFbpCompanyVDS = (IFbpCompanyVDS)SSBBus.findDomainService("fbpCompanyVDS");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String str1 = "";
    if (paramDate1 != null) {
      str1 = localSimpleDateFormat.format(paramDate1);
    } else {
      str1 = "1900-01-01 00:00:00";
    }
    String str2 = "";
    if (paramDate2 != null) {
      str2 = localSimpleDateFormat.format(paramDate2);
    } else {
      str2 = str1;
    }
    SynBalanceCompany localSynBalanceCompany = new SynBalanceCompany();
    List localList = localSynBalanceCompany.getFinCompany(str1, str2);
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FbpCompanyV localFbpCompanyV = (FbpCompanyV)localIterator.next();
        localIFbpCompanyVDS.saveFbpCompamyV(localFbpCompanyV);
      }
    }
  }
  
  public String saveSynchRequest(FbpSynchRequestsV paramFbpSynchRequestsV)
  {
    boolean bool = checkSynchRequestNumber(paramFbpSynchRequestsV.getSynchRequestNumber());
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpSynchRequests localFbpSynchRequests = new FbpSynchRequests();
    if (paramFbpSynchRequestsV.getSynchRequestId() == null)
    {
      localDate1 = new Date();
      localDate2 = new Date();
    }
    else
    {
      localFbpSynchRequests.setSynchRequestId(paramFbpSynchRequestsV.getSynchRequestId());
    }
    ObjectCopyUtils.setWho(localFbpSynchRequests);
    Date localDate1 = paramFbpSynchRequestsV.getStartDateActive();
    Date localDate2 = paramFbpSynchRequestsV.getEndDateActive();
    paramFbpSynchRequestsV.setLastUpdateDate(new Date());
    paramFbpSynchRequestsV.setCreationDate(new Date());
    paramFbpSynchRequestsV.setCreatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    paramFbpSynchRequestsV.setLastUpdatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    if ((paramFbpSynchRequestsV.getAttribute9() != null) && (!paramFbpSynchRequestsV.getAttribute9().equals(""))) {
      this.hour = paramFbpSynchRequestsV.getAttribute9();
    }
    if ((paramFbpSynchRequestsV.getAttribute8() != null) && (!paramFbpSynchRequestsV.getAttribute8().equals(""))) {
      this.hour1 = paramFbpSynchRequestsV.getAttribute8();
    }
    if ((paramFbpSynchRequestsV.getAttribute10() != null) && (!paramFbpSynchRequestsV.getAttribute10().equals(""))) {
      this.minute = paramFbpSynchRequestsV.getAttribute10();
    }
    if ((paramFbpSynchRequestsV.getAttribute7() != null) && (!paramFbpSynchRequestsV.getAttribute7().equals(""))) {
      this.minute1 = paramFbpSynchRequestsV.getAttribute7();
    }
    Date localDate3 = paramFbpSynchRequestsV.getStartDateActive();
    Date localDate4 = paramFbpSynchRequestsV.getEndDateActive();
    if ((localDate3 != null) && (!localDate3.equals(""))) {
      try
      {
        SimpleDateFormat localSimpleDateFormat1;
        SimpleDateFormat localSimpleDateFormat2;
        if ((this.hour != null) && (!this.hour.equals("")) && (this.minute != null) && (!this.minute.equals("")))
        {
          localSimpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
          localObject = localSimpleDateFormat1.format(localDate3);
          this.yearday = ((String)localObject + " " + this.hour + ":" + this.minute + ":00");
          localSimpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          localDate1 = localSimpleDateFormat2.parse(this.yearday);
        }
        if ((this.hour1 != null) && (!this.hour1.equals("")) && (this.minute1 != null) && (!this.minute1.equals("")))
        {
          localSimpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
          localObject = localSimpleDateFormat1.format(localDate4);
          this.yearday1 = ((String)localObject + " " + this.hour1 + ":" + this.minute1 + ":00");
          localSimpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          localDate2 = localSimpleDateFormat2.parse(this.yearday1);
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    paramFbpSynchRequestsV.setLastUpdateLogin(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    if (paramFbpSynchRequestsV.getStartDateActive() != null) {
      paramFbpSynchRequestsV.setStartDateActive(localDate1);
    }
    if (paramFbpSynchRequestsV.getEndDateActive() != null) {
      paramFbpSynchRequestsV.setEndDateActive(localDate2);
    }
    if (localFbpSynchRequests.getSynchRequestId() == null) {
      try
      {
        if (bool) {
          return "savefaildsameno";
        }
        ObjectCopyUtils.copy(paramFbpSynchRequestsV, localFbpSynchRequests);
        ObjectCopyUtils.setWho(localFbpSynchRequests);
        localFbpSynchRequests.setSynchType(paramFbpSynchRequestsV.getSynchType());
        localFbpSynchRequests.setLastRunTime(new Date());
        if ((paramFbpSynchRequestsV.getAttribute2() != null) && (paramFbpSynchRequestsV.getAttribute2().equals("Y"))) {
          localFbpSynchRequests.setAttribute4("运行成功");
        } else {
          localFbpSynchRequests.setAttribute4("计划运行");
        }
        this.fbpSynchRequestsDAO.insert(localFbpSynchRequests);
        return "insertsucceed";
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return "c";
      }
    }
    String str = String.valueOf(localFbpSynchRequests.getSynchRequestId());
    Object localObject = this.fbpSynchRequestsVDAO.findSynchRequestsVById(str);
    if ((bool) && (!paramFbpSynchRequestsV.getSynchRequestNumber().equals(((FbpSynchRequestsV)localObject).getSynchRequestNumber()))) {
      return "savefaildsameno";
    }
    ObjectCopyUtils.copy(paramFbpSynchRequestsV, localFbpSynchRequests);
    localFbpSynchRequests.setSynchType(paramFbpSynchRequestsV.getSynchType());
    try
    {
      if ((paramFbpSynchRequestsV.getAttribute2() != null) && (paramFbpSynchRequestsV.getAttribute2().equals("Y"))) {
        localFbpSynchRequests.setAttribute4("运行成功");
      } else {
        localFbpSynchRequests.setAttribute4("计划运行");
      }
      this.fbpSynchRequestsDAO.update(localFbpSynchRequests);
      return "updatesucess";
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
    }
    return "updatefaild";
  }
  
  private boolean checkSynchRequestNumber(String paramString)
  {
    FbpSynchRequestsV localFbpSynchRequestsV = this.fbpSynchRequestsVDAO.findSynchRequestsVByReqNum(paramString);
    return localFbpSynchRequestsV != null;
  }
  
  public String hangupSynchRequest(String paramString)
  {
    return null;
  }
  
  public IFbpSynchRequestsDAO getFbpSynchRequestsDAO()
  {
    return this.fbpSynchRequestsDAO;
  }
  
  public void setFbpSynchRequestsDAO(IFbpSynchRequestsDAO paramIFbpSynchRequestsDAO)
  {
    this.fbpSynchRequestsDAO = paramIFbpSynchRequestsDAO;
  }
  
  public IFbpSynchRequestsVDAO getFbpSynchRequestsVDAO()
  {
    return this.fbpSynchRequestsVDAO;
  }
  
  public void setFbpSynchRequestsVDAO(IFbpSynchRequestsVDAO paramIFbpSynchRequestsVDAO)
  {
    this.fbpSynchRequestsVDAO = paramIFbpSynchRequestsVDAO;
  }
  
  public IOrgSynDS getOrgSynDS()
  {
    return this.orgSynDS;
  }
  
  public void setOrgSynDS(IOrgSynDS paramIOrgSynDS)
  {
    this.orgSynDS = paramIOrgSynDS;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.synrequest.service.FbpSynchRequestsDS
 * JD-Core Version:    0.7.0.1
 */