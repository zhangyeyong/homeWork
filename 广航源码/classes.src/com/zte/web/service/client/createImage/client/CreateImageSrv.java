package com.zte.web.service.client.createImage.client;

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
 * Qualified Name:     com.zte.web.service.client.createImage.client.CreateImageSrv
 * JD-Core Version:    0.7.0.1
 */