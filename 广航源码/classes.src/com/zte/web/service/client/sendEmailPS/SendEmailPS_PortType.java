package com.zte.web.service.client.sendEmailPS;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface SendEmailPS_PortType
  extends Remote
{
  public abstract OutputMessageType sendEmail(InputMessageType paramInputMessageType)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.sendEmailPS.SendEmailPS_PortType
 * JD-Core Version:    0.7.0.1
 */