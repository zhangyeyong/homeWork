package com.zte.web.service.client.WSImgSystemInterfaceFacade;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface WSImgSystemInterfaceFacadeSrvProxyService
  extends Service
{
  public abstract String getWSImgSystemInterfaceFacadeAddress();
  
  public abstract WSImgSystemInterfaceFacadeSrvProxy getWSImgSystemInterfaceFacade()
    throws ServiceException;
  
  public abstract WSImgSystemInterfaceFacadeSrvProxy getWSImgSystemInterfaceFacade(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.WSImgSystemInterfaceFacade.WSImgSystemInterfaceFacadeSrvProxyService
 * JD-Core Version:    0.7.0.1
 */