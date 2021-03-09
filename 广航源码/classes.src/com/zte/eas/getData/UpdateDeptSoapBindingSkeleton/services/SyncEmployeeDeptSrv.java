package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface SyncEmployeeDeptSrv
  extends Remote
{
  public abstract MessageCollection updateEmployeeDept(EmployeeDeptCollection paramEmployeeDeptCollection)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.SyncEmployeeDeptSrv
 * JD-Core Version:    0.7.0.1
 */