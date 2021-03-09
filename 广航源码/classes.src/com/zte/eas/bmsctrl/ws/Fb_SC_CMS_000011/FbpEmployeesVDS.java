package com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface FbpEmployeesVDS
  extends Remote
{
  public abstract FbpEmployee[] findFbpEmployees(String paramString1, String paramString2)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011.FbpEmployeesVDS
 * JD-Core Version:    0.7.0.1
 */