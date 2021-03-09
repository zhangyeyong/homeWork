package com.zte.eas.appframe.business.syscommon;

import com.zte.ssb.servicecontainer.business.server.IRIAContextFactory;
import com.zte.ssb.servicecontainer.business.server.RIAConfiguration;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RIASessionFilter
  implements Filter
{
  private static RIAConfiguration _configuration = null;
  private FilterConfig config = null;
  Log log = LogFactory.getLog(getClass());
  
  public void destroy()
  {
    if (_configuration != null)
    {
      _configuration.destroy();
      _configuration = null;
    }
  }
  
  public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain paramFilterChain)
    throws IOException, ServletException
  {
    try
    {
      if (RIAContext.getCurrentInstance() == null)
      {
        RIAConfiguration localRIAConfiguration = getRIAConfiguration();
        if (localRIAConfiguration != null)
        {
          IRIAContextFactory localIRIAContextFactory = getRIAConfiguration().getRiaContextFactory();
          localIRIAContextFactory.getRIAContext(this.config.getServletContext(), paramServletRequest, paramServletResponse);
        }
      }
    }
    finally
    {
      paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
    }
  }
  
  private synchronized RIAConfiguration getRIAConfiguration()
  {
    if (_configuration == null) {
      try
      {
        InputStream localInputStream = RIASessionFilter.class.getResourceAsStream("/ria-config.config");
        try
        {
          _configuration = new RIAConfiguration(localInputStream);
        }
        finally
        {
          localInputStream.close();
        }
      }
      catch (Exception localException)
      {
        this.log.error("initialization RIAConfiguration failed: " + localException.getMessage(), localException);
      }
    }
    return _configuration;
  }
  
  public void init(FilterConfig paramFilterConfig)
    throws ServletException
  {
    this.config = paramFilterConfig;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.syscommon.RIASessionFilter
 * JD-Core Version:    0.7.0.1
 */