package com.zte.eas.infomap.business.sso;

import com.zte.eas.infomap.business.sso.model.SSOLoginResult;
import com.zte.ssb.AccessPropertiesFile;
import java.net.URLDecoder;
import javax.servlet.http.Cookie;

public class SSOLoginDS
  implements ISSOLoginDS
{
  public String getToken(Cookie[] paramArrayOfCookie, String paramString)
  {
    int i = 0;
    String str = "";
    if (paramArrayOfCookie != null) {
      i = paramArrayOfCookie.length;
    }
    for (int j = 0; j < i; j++)
    {
      Cookie localCookie = paramArrayOfCookie[j];
      if (localCookie.getName().equals(AccessPropertiesFile.getValue("SSO_COOKIE_NAME", "ssoLogin.properties")))
      {
        str = localCookie.getValue();
        break;
      }
    }
    str = URLDecoder.decode(str);
    return str;
  }
  
  public SSOLoginResult validateToken(String paramString)
  {
    String str = AccessPropertiesFile.getValue("SSO_SYSTEM_NAME", "ssoLogin.properties");
    SSOLoginResult localSSOLoginResult = new SSOLoginResult();
    localSSOLoginResult.setAccount("002");
    localSSOLoginResult.setFlag("true");
    return localSSOLoginResult;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.sso.SSOLoginDS
 * JD-Core Version:    0.7.0.1
 */