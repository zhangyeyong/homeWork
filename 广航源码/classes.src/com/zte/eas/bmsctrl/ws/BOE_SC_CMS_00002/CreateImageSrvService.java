package com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface CreateImageSrvService
  extends Service
{
  public abstract String getcreateImageSrvAddress();
  
  public abstract CreateImageSrv getcreateImageSrv()
    throws ServiceException;
  
  public abstract CreateImageSrv getcreateImageSrv(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002.CreateImageSrvService
 * JD-Core Version:    0.7.0.1
 */