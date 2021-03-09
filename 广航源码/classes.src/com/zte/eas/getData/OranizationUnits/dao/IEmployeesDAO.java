package com.zte.eas.getData.OranizationUnits.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsVl;
import com.zte.ssb.framework.base.DAO;

public abstract interface IEmployeesDAO
  extends DAO
{
  public abstract String findEmployees(String paramString);
  
  public abstract FbpEmployees findEmployeesByEmployeeNumber(String paramString);
  
  public abstract FbpDeptsVl findDeptsVlByDeptCode(String paramString);
  
  public abstract FbpEmployeesTl findEmployeesTlByEmployeeId(Long paramLong);
  
  public abstract FbpEmployeesTl findEmployeesTlByEmployeeId(Long paramLong, String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.dao.IEmployeesDAO
 * JD-Core Version:    0.7.0.1
 */