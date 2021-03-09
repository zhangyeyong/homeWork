package com.zte.web.service.messageSrv.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface SendMessageSrv
  extends Remote
{
  public abstract SendMessageSrvResponse[] process(SendMessageSrvRequest[] paramArrayOfSendMessageSrvRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.messageSrv.services.SendMessageSrv
 * JD-Core Version:    0.7.0.1
 */