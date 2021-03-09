package com.cmcc.mss.nc_itf_guanghj_service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface IHrServicePortType
  extends Remote
{
  public abstract String process(String paramString)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.nc_itf_guanghj_service.IHrServicePortType
 * JD-Core Version:    0.7.0.1
 */