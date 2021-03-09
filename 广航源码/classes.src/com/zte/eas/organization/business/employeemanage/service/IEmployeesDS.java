package com.zte.eas.organization.business.employeemanage.service;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeeBankAccountsV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import java.util.List;
import java.util.Map;

public abstract interface IEmployeesDS
{
  public abstract List<FbpEmployeeBankAccountsV> findEmployeeBankAccountsVByEmployeeId(String paramString);
  
  public abstract Map findEmployeeBankAccountsByEmployeeId(String paramString1, String paramString2, String paramString3);
  
  public abstract FbpEmployeeBankAccountsV saveEmployeeBankAccountsV(FbpEmployeeBankAccountsV paramFbpEmployeeBankAccountsV);
  
  public abstract String removeEmployeeBankAccountsV(FbpEmployeeBankAccountsV paramFbpEmployeeBankAccountsV);
  
  public abstract FbpEmployeesV getEmployeeById();
  
  public abstract List<FbpEmployeeBankAccountsV> getBankAccountById();
  
  public abstract String updateOrSave(FbpEmployeesV paramFbpEmployeesV, List<FbpEmployeeBankAccountsV> paramList);
  
  public abstract String updatePassword(FbpEmployees paramFbpEmployees, String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.service.IEmployeesDS
 * JD-Core Version:    0.7.0.1
 */