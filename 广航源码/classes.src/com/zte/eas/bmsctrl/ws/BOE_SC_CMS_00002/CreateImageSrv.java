package com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface CreateImageSrv
  extends Remote
{
  public abstract String createImage(CreateImageRequest paramCreateImageRequest)
    throws RemoteException;
  
  public abstract String deleteImage(CreateImageRequest paramCreateImageRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002.CreateImageSrv
 * JD-Core Version:    0.7.0.1
 */