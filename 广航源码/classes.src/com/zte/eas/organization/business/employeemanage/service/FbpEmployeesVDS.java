package com.zte.eas.organization.business.employeemanage.service;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.access.syscommon.dao.IFbpEmployeesLoginVDAO;
import com.zte.eas.appframe.business.syscommon.InfoMapEncrypt;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.organization.access.employeemanage.dao.IFbpCreditAdjustmentsVDAO;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesDAO;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesLovVDAO;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesTlDAO;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.countcompanymanage.service.DataSourceU;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesLovV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesSsologinV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTlPk;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.ssbext.lang.LangType;
import com.zte.ssb.ssbext.lang.LangUtil;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FbpEmployeesVDS
  extends BaseDomainService
  implements IFbpEmployeesVDS
{
  private IFbpEmployeesVDAO fbpEmployeesVDAO;
  private IFbpEmployeesDAO fbpEmployeesDAO;
  private IFbpEmployeesTlDAO fbpEmployeesTlDAO;
  private IFbpEmployeesLoginVDAO fbpEmployeesLoginVDAO;
  private IFbpEmployeesLovVDAO fbpEmployeesLovVDAO;
  private IFbpCreditAdjustmentsVDAO fbpCreditAdjustmentsVDAO;
  protected Log log = LogFactory.getLog(getClass());
  private static String SAVE_FAILED = "FAIL";
  private static String SAVE_SUCCEED = "SUCC";
  protected static final String EASLOGIN_USERINFO = "easloginuserinfo";
  private static final String SAME_EMPLOYEE_NUMBER = "SAME_EMPLOYEE_NUMBER";
  private static final String ENABELD = "有效";
  private static final String DISABELD = "无效";
  private static final String NOCREDIT = "没有对应的等级";
  
  public String countEmployeeByName(String paramString)
  {
    FbpEmployees localFbpEmployees = new FbpEmployees();
    ObjectCopyUtils.setWho(localFbpEmployees);
    Long localLong = localFbpEmployees.getLastUpdatedBy();
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpEmployeesLovV localFbpEmployeesLovV = new FbpEmployeesLovV();
    localFbpEmployeesLovV.setMyEmployeeId(localLong);
    localFbpEmployeesLovV.setEmployeeName(paramString);
    localFbpEmployeesLovV.setCheckUnit(localEasUserInfo.getCheckUnit());
    return this.fbpEmployeesLovVDAO.countEmployeeByName(localFbpEmployeesLovV);
  }
  
  public FbpEmployeesV findEmpByEmpNumber(String paramString)
  {
    FbpEmployeesV localFbpEmployeesV = this.fbpEmployeesVDAO.findEmpByEmpNumber(paramString);
    return localFbpEmployeesV;
  }
  
  public Map findEmployeesByDeptId(String paramString1, String paramString2, String paramString3)
  {
    PageInfo localPageInfo = this.fbpEmployeesVDAO.findEmployeesByDeptId(new BigInteger(paramString1), new Integer(paramString2).intValue(), new Integer(paramString3).intValue());
    if (localPageInfo != null) {
      setEnabled((List)localPageInfo.getResult());
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  private void setEnabled(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      FbpEmployeesV localFbpEmployeesV = null;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localFbpEmployeesV = (FbpEmployeesV)localIterator.next();
        if ((localFbpEmployeesV != null) && (localFbpEmployeesV.getEnabledFlag() != null)) {
          if (localFbpEmployeesV.getEnabledFlag().equalsIgnoreCase("Y")) {
            localFbpEmployeesV.setEnabledFlag("有效");
          } else if (localFbpEmployeesV.getEnabledFlag().equalsIgnoreCase("N")) {
            localFbpEmployeesV.setEnabledFlag("无效");
          }
        }
      }
    }
  }
  
  public Map findEmployeesByQry(FbpEmployeesV paramFbpEmployeesV, String paramString1, String paramString2)
  {
    Map localMap = this.fbpEmployeesVDAO.findEmployeesByQry(paramFbpEmployeesV, new Integer(paramString1).intValue(), new Integer(paramString2).intValue());
    List localList = (List)localMap.get("data");
    if (localList != null) {
      setEnabled(localList);
    }
    localMap.put("data", localList);
    return localMap;
  }
  
  public FbpEmployeesV findEmployeesById(String paramString)
  {
    FbpEmployeesV localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesById(new BigInteger(paramString));
    if ((localFbpEmployeesV != null) && (localFbpEmployeesV.getCurrentCredit() == null)) {
      localFbpEmployeesV.setCurrentCredit(new BigInteger("0"));
    }
    if ((localFbpEmployeesV != null) && (localFbpEmployeesV.getGradeName() == null)) {
      localFbpEmployeesV.setGradeName("没有对应的等级");
    }
    return localFbpEmployeesV;
  }
  
  public String saveEmployees(FbpEmployeesV paramFbpEmployeesV)
  {
    String str1 = "";
    FbpEmployeesV localFbpEmployeesV = null;
    FbpEmployees localFbpEmployees = new FbpEmployees();
    ObjectCopyUtils.copy(paramFbpEmployeesV, localFbpEmployees);
    ObjectCopyUtils.setWho(localFbpEmployees);
    String str2 = "";
    Object localObject;
    if ((paramFbpEmployeesV.getEmployeeId() == null) || (paramFbpEmployeesV.getEmployeeId().longValue() <= 0L))
    {
      if ((paramFbpEmployeesV != null) && (paramFbpEmployeesV.getEmployeeNumber() != null))
      {
        localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesByNumber(paramFbpEmployeesV.getEmployeeNumber());
        if (localFbpEmployeesV != null) {
          return "SAME_EMPLOYEE_NUMBER";
        }
      }
      localFbpEmployees.setPassword("Su8I2nxLXVqBA+54oSHO1OUuE8xWyDqY");
      this.fbpEmployeesDAO.insertFbpEmployees(localFbpEmployees);
      if ((localFbpEmployees != null) && (localFbpEmployees.getEmployeeId() != null)) {
        str2 = localFbpEmployees.getEmployeeId().toString();
      }
      List localList = LangUtil.listLangTypes();
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        LangType localLangType = (LangType)((Iterator)localObject).next();
        FbpEmployeesTl localFbpEmployeesTl2 = new FbpEmployeesTl();
        ObjectCopyUtils.copy(paramFbpEmployeesV, localFbpEmployeesTl2);
        ObjectCopyUtils.setWho(localFbpEmployeesTl2);
        FbpEmployeesTlPk localFbpEmployeesTlPk = new FbpEmployeesTlPk();
        localFbpEmployeesTlPk.setEmployeeId(localFbpEmployees.getEmployeeId());
        localFbpEmployeesTlPk.setLanguage(DataSourceU.getLang(localLangType.getCode()));
        localFbpEmployeesTl2.setEmployeePkTl(localFbpEmployeesTlPk);
        localFbpEmployeesTl2.setSourceLang(DataSourceU.getLang(localLangType.getCode()));
        try
        {
          this.fbpEmployeesTlDAO.insertFbpEmployeesTl(localFbpEmployeesTl2);
        }
        catch (Exception localException3)
        {
          this.log.error(SAVE_FAILED, localException3);
          return SAVE_FAILED;
        }
      }
    }
    else
    {
      if ((paramFbpEmployeesV != null) && (paramFbpEmployeesV.getEmployeeId() != null))
      {
        localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesById(paramFbpEmployeesV.getEmployeeId());
        if ((localFbpEmployeesV != null) && (!localFbpEmployeesV.getEmployeeNumber().equals(paramFbpEmployeesV.getEmployeeNumber())))
        {
          localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesByNumber(paramFbpEmployeesV.getEmployeeNumber());
          if (localFbpEmployeesV != null) {
            return "SAME_EMPLOYEE_NUMBER";
          }
        }
      }
      if ((null != localFbpEmployees.getPassword()) && (!"".equals(localFbpEmployees.getPassword())))
      {
        try
        {
          str1 = InfoMapEncrypt.decrypt(localFbpEmployees.getPassword());
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        localFbpEmployees.setPassword(InfoMapEncrypt.encrypt(str1));
      }
      this.fbpEmployeesDAO.updateFbpEmployees(localFbpEmployees);
      if ((localFbpEmployees != null) && (localFbpEmployees.getEmployeeId() != null)) {
        str2 = localFbpEmployees.getEmployeeId().toString();
      }
      FbpEmployeesTl localFbpEmployeesTl1 = new FbpEmployeesTl();
      ObjectCopyUtils.copy(paramFbpEmployeesV, localFbpEmployeesTl1);
      ObjectCopyUtils.setWho(localFbpEmployeesTl1);
      localObject = new FbpEmployeesTlPk();
      ((FbpEmployeesTlPk)localObject).setEmployeeId(localFbpEmployees.getEmployeeId());
      ((FbpEmployeesTlPk)localObject).setLanguage(DataSourceU.getLang(LangUtil.getLocale()));
      localFbpEmployeesTl1.setEmployeePkTl((FbpEmployeesTlPk)localObject);
      localFbpEmployeesTl1.setSourceLang(DataSourceU.getLang(LangUtil.getLocale()));
      try
      {
        this.fbpEmployeesTlDAO.updateFbpEmployeesTl(localFbpEmployeesTl1);
      }
      catch (Exception localException2)
      {
        this.log.error(SAVE_FAILED, localException2);
        return SAVE_FAILED;
      }
    }
    return SAVE_SUCCEED + "," + str2;
  }
  
  public Map findCreditAdjustmentsByEmployeeId(String paramString1, String paramString2, String paramString3)
  {
    int i = Integer.parseInt(paramString2);
    int j = Integer.parseInt(paramString3);
    int k = i / j + 1;
    PageInfo localPageInfo = this.fbpCreditAdjustmentsVDAO.findCreditAdjustmentsByEmployeeId(new BigInteger(paramString1), k, j);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public String resetPassword(FbpEmployeesV paramFbpEmployeesV)
  {
    String str = null;
    try
    {
      FbpEmployees localFbpEmployees = null;
      if ((paramFbpEmployeesV != null) && (paramFbpEmployeesV.getEmployeeId() != null))
      {
        localFbpEmployees = this.fbpEmployeesDAO.getFbpEmployees(paramFbpEmployeesV.getEmployeeId());
        str = getNewPassPord();
        if (str != null) {
          localFbpEmployees.setPassword(str);
        } else {
          str = "";
        }
        if ((null != localFbpEmployees.getPassword()) && (!"".equals(localFbpEmployees.getPassword()))) {
          localFbpEmployees.setPassword(InfoMapEncrypt.encrypt(localFbpEmployees.getPassword()));
        }
        this.fbpEmployeesDAO.updateFbpEmployees(localFbpEmployees);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return SAVE_FAILED;
    }
    return SAVE_SUCCEED + "," + str;
  }
  
  public String resetPassword2(FbpEmployeesV paramFbpEmployeesV)
  {
    String str1 = "";
    FbpEmployeesV localFbpEmployeesV1 = null;
    FbpEmployees localFbpEmployees = new FbpEmployees();
    FbpEmployeesTl localFbpEmployeesTl = new FbpEmployeesTl();
    ObjectCopyUtils.copy(paramFbpEmployeesV, localFbpEmployees);
    ObjectCopyUtils.copy(paramFbpEmployeesV, localFbpEmployeesTl);
    ObjectCopyUtils.setWho(localFbpEmployees);
    ObjectCopyUtils.setWho(localFbpEmployeesTl);
    FbpEmployeesTlPk localFbpEmployeesTlPk = null;
    String str2 = "";
    if ((paramFbpEmployeesV.getEmployeeId() == null) || (paramFbpEmployeesV.getEmployeeId().longValue() <= 0L))
    {
      if ((paramFbpEmployeesV != null) && (paramFbpEmployeesV.getEmployeeNumber() != null))
      {
        localFbpEmployeesV1 = this.fbpEmployeesVDAO.findEmployeesByNumber(paramFbpEmployeesV.getEmployeeNumber());
        if (localFbpEmployeesV1 != null) {
          return "SAME_EMPLOYEE_NUMBER";
        }
      }
      localFbpEmployees.setPassword("Su8I2nxLXVqBA+54oSHO1OUuE8xWyDqY");
      this.fbpEmployeesDAO.insertFbpEmployees(localFbpEmployees);
      if ((localFbpEmployees != null) && (localFbpEmployees.getEmployeeId() != null)) {
        str2 = localFbpEmployees.getEmployeeId().toString();
      }
      localFbpEmployeesTlPk = new FbpEmployeesTlPk();
      localFbpEmployeesTlPk.setEmployeeId(localFbpEmployees.getEmployeeId());
      localFbpEmployeesTlPk.setLanguage("ZHS");
      localFbpEmployeesTl.setEmployeePkTl(localFbpEmployeesTlPk);
      localFbpEmployeesTl.setSourceLang("ZHS");
      try
      {
        this.fbpEmployeesTlDAO.insertFbpEmployeesTl(localFbpEmployeesTl);
      }
      catch (Exception localException)
      {
        this.log.error(SAVE_FAILED, localException);
        return SAVE_FAILED;
      }
    }
    System.out.println(paramFbpEmployeesV.getEmployeeNumber());
    String str3 = paramFbpEmployeesV.getEmployeeNumber();
    FbpEmployeesV localFbpEmployeesV2 = this.fbpEmployeesVDAO.findEmpByEmpNumber(str3);
    return resetPassword(localFbpEmployeesV2);
  }
  
  public FbpEmployees getempFbpEmployees(String paramString)
  {
    return this.fbpEmployeesDAO.getFbpEmployees(paramString);
  }
  
  private String getNewPassPord()
  {
    String str = "";
    int i = 0;
    for (int j = 1; j <= 6; j++)
    {
      Random localRandom = new Random();
      i = Math.abs(localRandom.nextInt()) % 10;
      str = str + i;
    }
    return str;
  }
  
  public List findEmployeeByErpOrgIdDeptId(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return this.fbpEmployeesLovVDAO.findEmployeeByErpOrgIdDeptId(paramString1, paramString2, paramString3, paramString4);
  }
  
  public TableDataInfo findEmployeeByDeptId(FbpEmployeesLovV paramFbpEmployeesLovV, int paramInt1, int paramInt2)
  {
    FbpEmployees localFbpEmployees = new FbpEmployees();
    ObjectCopyUtils.setWho(localFbpEmployees);
    Long localLong = localFbpEmployees.getLastUpdatedBy();
    paramFbpEmployeesLovV.setMyEmployeeId(localLong);
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    paramFbpEmployeesLovV.setCheckUnit(localEasUserInfo.getCheckUnit());
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.fbpEmployeesLovVDAO.findEmployeeByDeptId(paramFbpEmployeesLovV, paramInt1, paramInt2);
    List localList = (List)localPageInfo.getResult();
    localTableDataInfo.setData(localList);
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public FbpEmployeesV findEmployeesVInfo()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    return this.fbpEmployeesVDAO.findEmployeesById(localEasUserInfo.getUserInfoPk());
  }
  
  public IFbpEmployeesVDAO getFbpEmployeesVDAO()
  {
    return this.fbpEmployeesVDAO;
  }
  
  public void setFbpEmployeesVDAO(IFbpEmployeesVDAO paramIFbpEmployeesVDAO)
  {
    this.fbpEmployeesVDAO = paramIFbpEmployeesVDAO;
  }
  
  public IFbpEmployeesDAO getFbpEmployeesDAO()
  {
    return this.fbpEmployeesDAO;
  }
  
  public void setFbpEmployeesDAO(IFbpEmployeesDAO paramIFbpEmployeesDAO)
  {
    this.fbpEmployeesDAO = paramIFbpEmployeesDAO;
  }
  
  public IFbpEmployeesTlDAO getFbpEmployeesTlDAO()
  {
    return this.fbpEmployeesTlDAO;
  }
  
  public void setFbpEmployeesTlDAO(IFbpEmployeesTlDAO paramIFbpEmployeesTlDAO)
  {
    this.fbpEmployeesTlDAO = paramIFbpEmployeesTlDAO;
  }
  
  public IFbpCreditAdjustmentsVDAO getFbpCreditAdjustmentsVDAO()
  {
    return this.fbpCreditAdjustmentsVDAO;
  }
  
  public void setFbpCreditAdjustmentsVDAO(IFbpCreditAdjustmentsVDAO paramIFbpCreditAdjustmentsVDAO)
  {
    this.fbpCreditAdjustmentsVDAO = paramIFbpCreditAdjustmentsVDAO;
  }
  
  public FbpEmployeesV findEmployeesByNumber(String paramString)
  {
    return this.fbpEmployeesVDAO.findEmployeesByNumber(paramString);
  }
  
  public FbpEmployeesLoginV findEmployeeByUserId(String paramString)
  {
    return this.fbpEmployeesLoginVDAO.findEmployeeByUserId(paramString);
  }
  
  public IFbpEmployeesLoginVDAO getFbpEmployeesLoginVDAO()
  {
    return this.fbpEmployeesLoginVDAO;
  }
  
  public void setFbpEmployeesLoginVDAO(IFbpEmployeesLoginVDAO paramIFbpEmployeesLoginVDAO)
  {
    this.fbpEmployeesLoginVDAO = paramIFbpEmployeesLoginVDAO;
  }
  
  public IFbpEmployeesLovVDAO getFbpEmployeesLovVDAO()
  {
    return this.fbpEmployeesLovVDAO;
  }
  
  public void setFbpEmployeesLovVDAO(IFbpEmployeesLovVDAO paramIFbpEmployeesLovVDAO)
  {
    this.fbpEmployeesLovVDAO = paramIFbpEmployeesLovVDAO;
  }
  
  public FbpEmployeesSsologinV getEmployeesSsologinV(String paramString)
  {
    return this.fbpEmployeesVDAO.getEmployeesSsologinV(paramString);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.service.FbpEmployeesVDS
 * JD-Core Version:    0.7.0.1
 */