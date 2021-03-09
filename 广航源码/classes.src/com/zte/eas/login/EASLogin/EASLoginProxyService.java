package com.zte.eas.login.EASLogin;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface EASLoginProxyService
  extends Service
{
  public abstract String getEASLoginAddress();
  
  public abstract EASLoginProxy getEASLogin()
    throws ServiceException;
  
  public abstract EASLoginProxy getEASLogin(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.login.EASLogin.EASLoginProxyService
 * JD-Core Version:    0.7.0.1
 */