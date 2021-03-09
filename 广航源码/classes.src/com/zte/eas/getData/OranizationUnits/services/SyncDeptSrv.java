package com.zte.eas.getData.OranizationUnits.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface SyncDeptSrv
  extends Remote
{
  public abstract Message[] syncDepts(Depts[] paramArrayOfDepts)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.services.SyncDeptSrv
 * JD-Core Version:    0.7.0.1
 */