package com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00001;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface SynboeHeaderImageDS
  extends Remote
{
  public abstract boolean createImage(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract boolean deleteImage(String paramString)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00001.SynboeHeaderImageDS
 * JD-Core Version:    0.7.0.1
 */