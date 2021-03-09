package com.zte.eas.organization.business.employeemanage.service;

import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesLovV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesSsologinV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;
import java.util.Map;

public abstract interface IFbpEmployeesVDS
  extends DomainService
{
  public abstract String countEmployeeByName(String paramString);
  
  public abstract TableDataInfo findEmployeeByDeptId(FbpEmployeesLovV paramFbpEmployeesLovV, int paramInt1, int paramInt2);
  
  public abstract Map findEmployeesByDeptId(String paramString1, String paramString2, String paramString3);
  
  public abstract Map findEmployeesByQry(FbpEmployeesV paramFbpEmployeesV, String paramString1, String paramString2);
  
  public abstract FbpEmployeesV findEmployeesById(String paramString);
  
  public abstract FbpEmployeesV findEmployeesByNumber(String paramString);
  
  public abstract String saveEmployees(FbpEmployeesV paramFbpEmployeesV);
  
  public abstract Map findCreditAdjustmentsByEmployeeId(String paramString1, String paramString2, String paramString3);
  
  public abstract String resetPassword(FbpEmployeesV paramFbpEmployeesV);
  
  public abstract String resetPassword2(FbpEmployeesV paramFbpEmployeesV);
  
  public abstract FbpEmployees getempFbpEmployees(String paramString);
  
  public abstract FbpEmployeesLoginV findEmployeeByUserId(String paramString);
  
  public abstract List findEmployeeByErpOrgIdDeptId(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract FbpEmployeesV findEmpByEmpNumber(String paramString);
  
  public abstract FbpEmployeesV findEmployeesVInfo();
  
  public abstract FbpEmployeesSsologinV getEmployeesSsologinV(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.service.IFbpEmployeesVDS
 * JD-Core Version:    0.7.0.1
 */