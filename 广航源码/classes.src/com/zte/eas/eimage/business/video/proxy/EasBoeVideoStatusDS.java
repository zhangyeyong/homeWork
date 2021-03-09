package com.zte.eas.eimage.business.video.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;

public abstract interface EasBoeVideoStatusDS
  extends Remote
{
  public abstract boolean cancelVideo(String paramString)
    throws RemoteException;
  
  public abstract boolean registerVideo(String paramString, Calendar paramCalendar)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.EasBoeVideoStatusDS
 * JD-Core Version:    0.7.0.1
 */