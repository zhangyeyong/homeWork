package com.zte.eas.getData.EmployeeSync.validator;

import com.zte.eas.getData.EmployeeSync.model.Employees;
import com.zte.eas.getData.OranizationUnits.model.Message;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;

public abstract interface IEmployeesServiceValidatorImpl
{
  public abstract Message validator(Employees paramEmployees);
  
  public abstract FbpEmployees saveOrUpdate(Employees paramEmployees);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.EmployeeSync.validator.IEmployeesServiceValidatorImpl
 * JD-Core Version:    0.7.0.1
 */