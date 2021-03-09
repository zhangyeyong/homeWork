package com.zte.eas.bmsctrl.ws.Fbdept;

import com.zte.eas.bmsctrl.ws.Fbdept.dao.IFbpDeptDao;
import com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001.FbpDeptsVlDS;
import com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001.FbpDeptsVlDSServiceLocator;
import com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001.FbpDeptsVll;
import com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001.FindDeptSoapBindingStub;
import com.zte.ssb.framework.SSBBus;
import java.io.PrintStream;

public class FbpDeptDS
  implements IFbpDeptDS
{
  IFbpDeptDao fbpDeptDao;
  static FbpDeptsVll[] fbs;
  static FindDeptSoapBindingStub fs;
  
  public String findDept(String paramString1, String paramString2)
  {
    FbpDeptsVlDSServiceLocator localFbpDeptsVlDSServiceLocator = new FbpDeptsVlDSServiceLocator();
    IFbpDeptDao localIFbpDeptDao = (IFbpDeptDao)SSBBus.findDomainService("fbpDeptDao");
    try
    {
      FbpDeptsVlDS localFbpDeptsVlDS = localFbpDeptsVlDSServiceLocator.getfindDept();
      FbpDeptsVll[] arrayOfFbpDeptsVll = localFbpDeptsVlDS.findFbpDeptsVl(paramString1, paramString2);
      System.out.println(arrayOfFbpDeptsVll[0].getDeptName());
      localIFbpDeptDao.insertDept(arrayOfFbpDeptsVll);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public IFbpDeptDao getFbpDeptDao()
  {
    return this.fbpDeptDao;
  }
  
  public void setFbpDeptDao(IFbpDeptDao paramIFbpDeptDao)
  {
    this.fbpDeptDao = paramIFbpDeptDao;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fbdept.FbpDeptDS
 * JD-Core Version:    0.7.0.1
 */