package com.zte.eas.bmsctrl.ws.Fb_SC_CMS_00001.DS;

import com.zte.eas.bmsctrl.ws.FbEmployee.dao.IFbpEmployeeDao;
import com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011.FbpEmployee;
import com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011.FbpEmployeesVDS;
import com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011.FbpEmployeesVDSServiceLocator;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.ssb.framework.SSBBus;
import java.io.PrintStream;

public class FbpEmployeeDS
  implements IFbpEmployeeDS
{
  private IFbpEmployeeDao fbpEmployeeDao;
  
  public IFbpEmployeeDao getFbpEmployeeDao()
  {
    return this.fbpEmployeeDao;
  }
  
  public void setFbpEmployeeDao(IFbpEmployeeDao paramIFbpEmployeeDao)
  {
    this.fbpEmployeeDao = paramIFbpEmployeeDao;
  }
  
  public String findEmployee(String paramString1, String paramString2)
  {
    IFbpEmployeeDao localIFbpEmployeeDao = (IFbpEmployeeDao)SSBBus.findDomainService("fbpEmployeeDao");
    FbpEmployeesVDSServiceLocator localFbpEmployeesVDSServiceLocator = new FbpEmployeesVDSServiceLocator();
    try
    {
      FbpEmployeesVDS localFbpEmployeesVDS = localFbpEmployeesVDSServiceLocator.getfindemployee();
      FbpEmployee[] arrayOfFbpEmployee = localFbpEmployeesVDS.findFbpEmployees(paramString1, paramString2);
      System.out.println(arrayOfFbpEmployee[2].getEmployeeName());
      System.out.println(arrayOfFbpEmployee[2].getEmployeeNum());
      localIFbpEmployeeDao.insetEmployee(arrayOfFbpEmployee);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public FbpEmployees getFbpEmployees(String paramString)
  {
    return this.fbpEmployeeDao.getFbpEmployees(paramString);
  }
  
  public void updateFbpEmployees(FbpEmployees paramFbpEmployees)
  {
    this.fbpEmployeeDao.updateFbpEmployees(paramFbpEmployees);
  }
  
  public void insertFbpEmployees(FbpEmployees paramFbpEmployees)
  {
    this.fbpEmployeeDao.insertFbpEmployees(paramFbpEmployees);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fb_SC_CMS_00001.DS.FbpEmployeeDS
 * JD-Core Version:    0.7.0.1
 */