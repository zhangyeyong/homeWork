package com.zte.eas.wsf.ssc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface WSFSSCWebSericeFacadeSrvProxy
  extends Remote
{
  public abstract String[][] getFinCompany(String paramString1, String paramString2)
    throws RemoteException, WSInvokeException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.wsf.ssc.WSFSSCWebSericeFacadeSrvProxy
 * JD-Core Version:    0.7.0.1
 */