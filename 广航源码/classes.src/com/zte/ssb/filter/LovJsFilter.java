package com.zte.ssb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class LovJsFilter
  extends HttpServlet
  implements Filter
{
  private FilterConfig filterConfig;
  private String targetEncoding = "UTF-8";
  
  public void destroy() {}
  
  public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain paramFilterChain)
    throws IOException, ServletException
  {
    try
    {
      paramServletRequest.setCharacterEncoding(this.targetEncoding);
      ((HttpServletResponse)paramServletResponse).setHeader("Pragma", "No-cache");
      ((HttpServletResponse)paramServletResponse).setHeader("Cache-Control", "no-cache");
      ((HttpServletResponse)paramServletResponse).setHeader("Expires", "0");
      paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
    }
    catch (ServletException localServletException)
    {
      this.filterConfig.getServletContext().log(localServletException.getMessage());
    }
    catch (IOException localIOException)
    {
      this.filterConfig.getServletContext().log(localIOException.getMessage());
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
    }
  }
  
  public void init(FilterConfig paramFilterConfig)
    throws ServletException
  {
    this.filterConfig = paramFilterConfig;
    String str = paramFilterConfig.getInitParameter("encoding");
    if (str != null) {
      this.targetEncoding = str;
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.ssb.filter.LovJsFilter
 * JD-Core Version:    0.7.0.1
 */