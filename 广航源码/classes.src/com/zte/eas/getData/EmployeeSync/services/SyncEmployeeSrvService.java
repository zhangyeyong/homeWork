package com.zte.eas.getData.EmployeeSync.services;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface SyncEmployeeSrvService
  extends Service
{
  public abstract String getsyncEmployeeSrvAddress();
  
  public abstract SyncEmployeeSrv getsyncEmployeeSrv()
    throws ServiceException;
  
  public abstract SyncEmployeeSrv getsyncEmployeeSrv(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.EmployeeSync.services.SyncEmployeeSrvService
 * JD-Core Version:    0.7.0.1
 */