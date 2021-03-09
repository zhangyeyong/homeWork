package com.zte.web.service.client.getUrlServiceSrv;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface GetFileAndContractUrlDS
  extends Remote
{
  public abstract ResponseModel getUrl(RequestModel paramRequestModel)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.getUrlServiceSrv.GetFileAndContractUrlDS
 * JD-Core Version:    0.7.0.1
 */