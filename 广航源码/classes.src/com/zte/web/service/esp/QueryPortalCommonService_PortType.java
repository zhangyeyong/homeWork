package com.zte.web.service.esp;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface QueryPortalCommonService_PortType
  extends Remote
{
  public abstract OutputType portalQueryOperation(InputType paramInputType)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.esp.QueryPortalCommonService_PortType
 * JD-Core Version:    0.7.0.1
 */