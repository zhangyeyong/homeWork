package com.zte.eas.organization.business.employeemanage.service;

import com.zte.eas.appframe.business.syscommon.InfoMapEncrypt;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.organization.access.employeemanage.dao.IFbpBankAccountUsesDAO;
import com.zte.eas.organization.access.employeemanage.dao.IFbpBankAccountsDAO;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeeBankAccountsVDAO;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesDAO;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeeBankAccountsV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.eas.resconfig.business.lookup.service.IFbpLookupTypesDS;
import com.zte.ssb.exportExcel.tableModel.optionsModel;
import com.zte.ssb.exportExcel.tableModel.selectModel;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.ui.uiloader.model.UserInfo;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeesVDS
  implements IEmployeesDS
{
  private IFbpEmployeeBankAccountsVDAO fbpEmployeeBankAccountsVDAO;
  private IFbpEmployeesVDAO fbpEmployeesVDAO;
  private IFbpBankAccountsDAO fbpBankAccountsDAO;
  private IFbpEmployeesDAO fbpEmployeesDAO;
  private IFbpBankAccountUsesDAO fbpBankAccountUsesDAO;
  private IFbpLookupTypesDS lookupTypesDS;
  static final String LOGIN_USERINFO = "loginuserinfo";
  private static final String SUCC = "SUCC";
  private static final String NOCREDIT = "没有对应的等级";
  
  public IFbpEmployeeBankAccountsVDAO getFbpEmployeeBankAccountsVDAO()
  {
    return this.fbpEmployeeBankAccountsVDAO;
  }
  
  public FbpEmployeesV getEmployeeById()
  {
    FbpEmployeesV localFbpEmployeesV = new FbpEmployeesV();
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    UserInfo localUserInfo = (UserInfo)localISession.getSessionAttribute("loginuserinfo");
    String str = localUserInfo.getUserId();
    if ((str != null) && (!"".equals(str)))
    {
      localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesByNumber(str);
      if ((localFbpEmployeesV != null) && (localFbpEmployeesV.getGradeName() == null)) {
        localFbpEmployeesV.setGradeName("没有对应的等级");
      }
    }
    return localFbpEmployeesV;
  }
  
  public List<FbpEmployeeBankAccountsV> getBankAccountById()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    UserInfo localUserInfo = (UserInfo)localISession.getSessionAttribute("loginuserinfo");
    String str = localUserInfo.getUserId();
    BigInteger localBigInteger = this.fbpEmployeesVDAO.findEmployeesByNumber(str).getEmployeeId();
    if ((localBigInteger != null) && (!"".equals(localBigInteger)))
    {
      List localList1 = findEmployeeBankAccountsVByEmployeeId(localBigInteger.toString());
      for (int i = 0; i < localList1.size(); i++)
      {
        FbpEmployeeBankAccountsV localFbpEmployeeBankAccountsV1 = (FbpEmployeeBankAccountsV)localList1.get(i);
        selectModel localselectModel = new selectModel();
        localselectModel.setSelectValue(localFbpEmployeeBankAccountsV1.getCurrencyCode());
        ArrayList localArrayList = new ArrayList();
        List localList2 = this.lookupTypesDS.findLookupValuesByType("CNY");
        FbpLookupValuesV localFbpLookupValuesV = new FbpLookupValuesV();
        for (int j = 0; j < localList2.size(); j++)
        {
          optionsModel localoptionsModel = new optionsModel();
          localFbpLookupValuesV = (FbpLookupValuesV)localList2.get(j);
          localoptionsModel.setValue(localFbpLookupValuesV.getLookupCode());
          localoptionsModel.setText(localFbpLookupValuesV.getMeaning());
          localArrayList.add(localoptionsModel);
        }
        localselectModel.setOptions(localArrayList);
        localFbpEmployeeBankAccountsV1.setCNYSelect(localselectModel);
        FbpEmployeeBankAccountsV localFbpEmployeeBankAccountsV2 = (FbpEmployeeBankAccountsV)localList1.get(i);
        if ((localFbpEmployeeBankAccountsV2.getPrimaryFlag() != null) && (localFbpEmployeeBankAccountsV2.getPrimaryFlag().equals("Y"))) {
          localFbpEmployeeBankAccountsV2.setBankAccountNameAlt("1");
        }
      }
      return localList1;
    }
    return null;
  }
  
  public String updateOrSave(FbpEmployeesV paramFbpEmployeesV, List<FbpEmployeeBankAccountsV> paramList)
  {
    String str = "SUCCESS";
    int i = 0;
    try
    {
      FbpEmployees localFbpEmployees = this.fbpEmployeesDAO.getFbpEmployees(paramFbpEmployeesV.getEmployeeId());
      ObjectCopyUtils.copy(paramFbpEmployeesV, localFbpEmployees);
      ObjectCopyUtils.setWho(localFbpEmployees);
      this.fbpEmployeesDAO.updateFbpEmployees(localFbpEmployees);
    }
    catch (Exception localException)
    {
      str = "FAIL";
      localException.printStackTrace();
    }
    return str;
  }
  
  public String updatePassword(FbpEmployees paramFbpEmployees, String paramString)
  {
    String str1 = "success";
    try
    {
      String str2 = paramFbpEmployees.getPassword();
      String str3 = paramFbpEmployees.getNewPassword();
      if ((null != str2) && (!"".equals(str2))) {
        str2 = InfoMapEncrypt.encrypt(str2);
      }
      if ((null != str3) && (!"".equals(str3))) {
        str3 = InfoMapEncrypt.encrypt(str3);
      }
      FbpEmployees localFbpEmployees = this.fbpEmployeesDAO.getFbpEmployees(new BigInteger(paramString));
      if ((localFbpEmployees.getPassword() != null) && (localFbpEmployees.getPassword().equals(str2)))
      {
        localFbpEmployees.setPassword(str3);
        this.fbpEmployeesDAO.updateFbpEmployees(localFbpEmployees);
      }
      else
      {
        str1 = "different";
      }
    }
    catch (Exception localException)
    {
      str1 = "fail";
      localException.printStackTrace();
    }
    return str1;
  }
  
  public void setFbpEmployeeBankAccountsVDAO(IFbpEmployeeBankAccountsVDAO paramIFbpEmployeeBankAccountsVDAO)
  {
    this.fbpEmployeeBankAccountsVDAO = paramIFbpEmployeeBankAccountsVDAO;
  }
  
  public List<FbpEmployeeBankAccountsV> findEmployeeBankAccountsVByEmployeeId(String paramString)
  {
    List localList1 = this.fbpEmployeeBankAccountsVDAO.findEmployeeBankAccountsVByEmployeeId(new Long(paramString));
    List localList2 = localList1;
    return localList2;
  }
  
  public Map findEmployeeBankAccountsByEmployeeId(String paramString1, String paramString2, String paramString3)
  {
    PageInfo localPageInfo = this.fbpEmployeeBankAccountsVDAO.findEmployeeBankAccountsByEmployeeId(new Long(paramString1), new Integer(paramString2).intValue(), new Integer(paramString3).intValue());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public String removeEmployeeBankAccountsV(FbpEmployeeBankAccountsV paramFbpEmployeeBankAccountsV)
  {
    return null;
  }
  
  public FbpEmployeeBankAccountsV saveEmployeeBankAccountsV(FbpEmployeeBankAccountsV paramFbpEmployeeBankAccountsV)
  {
    return null;
  }
  
  public IFbpEmployeesVDAO getFbpEmployeesVDAO()
  {
    return this.fbpEmployeesVDAO;
  }
  
  public void setFbpEmployeesVDAO(IFbpEmployeesVDAO paramIFbpEmployeesVDAO)
  {
    this.fbpEmployeesVDAO = paramIFbpEmployeesVDAO;
  }
  
  public IFbpBankAccountsDAO getFbpBankAccountsDAO()
  {
    return this.fbpBankAccountsDAO;
  }
  
  public void setFbpBankAccountsDAO(IFbpBankAccountsDAO paramIFbpBankAccountsDAO)
  {
    this.fbpBankAccountsDAO = paramIFbpBankAccountsDAO;
  }
  
  public IFbpEmployeesDAO getFbpEmployeesDAO()
  {
    return this.fbpEmployeesDAO;
  }
  
  public void setFbpEmployeesDAO(IFbpEmployeesDAO paramIFbpEmployeesDAO)
  {
    this.fbpEmployeesDAO = paramIFbpEmployeesDAO;
  }
  
  public IFbpBankAccountUsesDAO getFbpBankAccountUsesDAO()
  {
    return this.fbpBankAccountUsesDAO;
  }
  
  public void setFbpBankAccountUsesDAO(IFbpBankAccountUsesDAO paramIFbpBankAccountUsesDAO)
  {
    this.fbpBankAccountUsesDAO = paramIFbpBankAccountUsesDAO;
  }
  
  public IFbpLookupTypesDS getLookupTypesDS()
  {
    return this.lookupTypesDS;
  }
  
  public void setLookupTypesDS(IFbpLookupTypesDS paramIFbpLookupTypesDS)
  {
    this.lookupTypesDS = paramIFbpLookupTypesDS;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.service.EmployeesVDS
 * JD-Core Version:    0.7.0.1
 */