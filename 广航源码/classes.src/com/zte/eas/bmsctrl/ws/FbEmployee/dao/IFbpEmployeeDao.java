package com.zte.eas.bmsctrl.ws.FbEmployee.dao;

import com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011.FbpEmployee;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;

public abstract interface IFbpEmployeeDao
{
  public abstract void insetEmployee(FbpEmployee[] paramArrayOfFbpEmployee);
  
  public abstract FbpEmployees getFbpEmployees(String paramString);
  
  public abstract void updateFbpEmployees(FbpEmployees paramFbpEmployees);
  
  public abstract void insertFbpEmployees(FbpEmployees paramFbpEmployees);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.FbEmployee.dao.IFbpEmployeeDao
 * JD-Core Version:    0.7.0.1
 */