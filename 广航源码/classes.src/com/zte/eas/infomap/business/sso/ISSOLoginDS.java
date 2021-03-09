package com.zte.eas.infomap.business.sso;

import com.zte.eas.infomap.business.sso.model.SSOLoginResult;
import javax.servlet.http.Cookie;

public abstract interface ISSOLoginDS
{
  public abstract SSOLoginResult validateToken(String paramString);
  
  public abstract String getToken(Cookie[] paramArrayOfCookie, String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.sso.ISSOLoginDS
 * JD-Core Version:    0.7.0.1
 */