package com.zte.web.service.client.WSImgSystemInterfaceFacade;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface WSImgSystemInterfaceFacadeSrvProxy
  extends Remote
{
  public abstract String[] imgCreateOrUpdate(String paramString)
    throws RemoteException, WSInvokeException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.WSImgSystemInterfaceFacade.WSImgSystemInterfaceFacadeSrvProxy
 * JD-Core Version:    0.7.0.1
 */