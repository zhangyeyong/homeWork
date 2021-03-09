package com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface FbpDeptsVlDS
  extends Remote
{
  public abstract FbpDeptsVll[] findFbpDeptsVl(String paramString1, String paramString2)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001.FbpDeptsVlDS
 * JD-Core Version:    0.7.0.1
 */