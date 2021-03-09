package com.zte.eas.getData;

import com.zte.eas.getData.EmployeeSync.services.Employees;
import com.zte.eas.getData.OranizationUnits.services.Depts;
import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.EmployeeDeptCollection;
import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.MessageCollection;

public abstract interface ISyncDataDS
{
  public abstract com.zte.eas.getData.EmployeeSync.services.Message[] syncEmployees(Employees[] paramArrayOfEmployees);
  
  public abstract com.zte.eas.getData.OranizationUnits.services.Message[] syncDepts(Depts[] paramArrayOfDepts);
  
  public abstract MessageCollection updateEmployeeDept(EmployeeDeptCollection paramEmployeeDeptCollection);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.ISyncDataDS
 * JD-Core Version:    0.7.0.1
 */