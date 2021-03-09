package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface SyncEmployeeDeptSrvService
  extends Service
{
  public abstract String getsyncEmployeeDeptSrvAddress();
  
  public abstract SyncEmployeeDeptSrv getsyncEmployeeDeptSrv()
    throws ServiceException;
  
  public abstract SyncEmployeeDeptSrv getsyncEmployeeDeptSrv(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.SyncEmployeeDeptSrvService
 * JD-Core Version:    0.7.0.1
 */