package com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface FbpDeptsVlDSService
  extends Service
{
  public abstract String getfindDeptAddress();
  
  public abstract FbpDeptsVlDS getfindDept()
    throws ServiceException;
  
  public abstract FbpDeptsVlDS getfindDept(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001.FbpDeptsVlDSService
 * JD-Core Version:    0.7.0.1
 */