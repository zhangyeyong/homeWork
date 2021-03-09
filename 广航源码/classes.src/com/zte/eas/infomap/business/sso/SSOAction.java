package com.zte.eas.infomap.business.sso;

import edu.yale.its.tp.cas.client.IContextInit;
import java.io.Serializable;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SSOAction
  implements IContextInit, Serializable
{
  private static final long serialVersionUID = 1L;
  private String userName;
  
  public String getTranslatorUser(String paramString)
  {
    this.userName = paramString;
    return paramString;
  }
  
  public void initContext(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain paramFilterChain, String paramString)
  {
    if ((!(paramServletRequest instanceof HttpServletRequest)) || (!(paramServletResponse instanceof HttpServletResponse))) {
      try
      {
        throw new ServletException("CasFileter is protected http resources");
      }
      catch (ServletException localServletException)
      {
        localServletException.printStackTrace();
      }
    }
    HttpServletRequest localHttpServletRequest = (HttpServletRequest)paramServletRequest;
    HttpSession localHttpSession = localHttpServletRequest.getSession();
    String str = null;
    str = paramString;
    localHttpSession.setAttribute("userId", str);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.sso.SSOAction
 * JD-Core Version:    0.7.0.1
 */