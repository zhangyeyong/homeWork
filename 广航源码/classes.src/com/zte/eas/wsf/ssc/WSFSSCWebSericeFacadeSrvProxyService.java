package com.zte.eas.wsf.ssc;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface WSFSSCWebSericeFacadeSrvProxyService
  extends Service
{
  public abstract String getWSFSSCWebSericeFacadeAddress();
  
  public abstract WSFSSCWebSericeFacadeSrvProxy getWSFSSCWebSericeFacade()
    throws ServiceException;
  
  public abstract WSFSSCWebSericeFacadeSrvProxy getWSFSSCWebSericeFacade(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.wsf.ssc.WSFSSCWebSericeFacadeSrvProxyService
 * JD-Core Version:    0.7.0.1
 */