package com.zte.web.service.client.sendMSMService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface SendMSMService_PortType
  extends Remote
{
  public abstract CoreSMSReplyType sendMSMService(CoreSMSType paramCoreSMSType)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.sendMSMService.SendMSMService_PortType
 * JD-Core Version:    0.7.0.1
 */