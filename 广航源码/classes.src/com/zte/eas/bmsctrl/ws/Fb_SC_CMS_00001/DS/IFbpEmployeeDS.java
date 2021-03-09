package com.zte.eas.bmsctrl.ws.Fb_SC_CMS_00001.DS;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;

public abstract interface IFbpEmployeeDS
{
  public abstract String findEmployee(String paramString1, String paramString2);
  
  public abstract FbpEmployees getFbpEmployees(String paramString);
  
  public abstract void updateFbpEmployees(FbpEmployees paramFbpEmployees);
  
  public abstract void insertFbpEmployees(FbpEmployees paramFbpEmployees);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fb_SC_CMS_00001.DS.IFbpEmployeeDS
 * JD-Core Version:    0.7.0.1
 */