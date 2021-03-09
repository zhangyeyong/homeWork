package com.zte.web.service.client.createImage.client.bcc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface EIS_BCC_EAI_YXSoap_PortType
  extends Remote
{
  public abstract String createImage(ModEIS paramModEIS)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.createImage.client.bcc.EIS_BCC_EAI_YXSoap_PortType
 * JD-Core Version:    0.7.0.1
 */