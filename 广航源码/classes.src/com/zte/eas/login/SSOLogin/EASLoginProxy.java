package com.zte.eas.login.SSOLogin;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface EASLoginProxy
  extends Remote
{
  public abstract WSContext login(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
    throws RemoteException;
  
  public abstract WSContext login(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.login.SSOLogin.EASLoginProxy
 * JD-Core Version:    0.7.0.1
 */