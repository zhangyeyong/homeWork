package com.zte.eas.getData.EmployeeSync.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface SyncEmployeeSrv
  extends Remote
{
  public abstract Message[] syncEmployees(Employees[] paramArrayOfEmployees)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.EmployeeSync.services.SyncEmployeeSrv
 * JD-Core Version:    0.7.0.1
 */