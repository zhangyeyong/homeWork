package com.zte.web.service.mergeBoeSrv.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface MergeBoeSrv
  extends Remote
{
  public abstract MergeBoeResponse mergeBoeSrv(MergeBoeRequest paramMergeBoeRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.service.MergeBoeSrv
 * JD-Core Version:    0.7.0.1
 */