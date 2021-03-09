package com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface FbpEmployeesVDSService
  extends Service
{
  public abstract String getfindemployeeAddress();
  
  public abstract FbpEmployeesVDS getfindemployee()
    throws ServiceException;
  
  public abstract FbpEmployeesVDS getfindemployee(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011.FbpEmployeesVDSService
 * JD-Core Version:    0.7.0.1
 */