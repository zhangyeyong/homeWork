package com.zte.eas.getData.OranizationUnits.services;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface SyncDeptSrvService
  extends Service
{
  public abstract String getsyncDeptSrvAddress();
  
  public abstract SyncDeptSrv getsyncDeptSrv()
    throws ServiceException;
  
  public abstract SyncDeptSrv getsyncDeptSrv(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.services.SyncDeptSrvService
 * JD-Core Version:    0.7.0.1
 */