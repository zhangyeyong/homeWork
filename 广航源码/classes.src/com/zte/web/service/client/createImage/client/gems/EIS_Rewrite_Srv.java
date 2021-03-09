package com.zte.web.service.client.createImage.client.gems;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface EIS_Rewrite_Srv
  extends Service
{
  public abstract String getEIS_RewritePortAddress();
  
  public abstract EIS_Rewrite getEIS_RewritePort()
    throws ServiceException;
  
  public abstract EIS_Rewrite getEIS_RewritePort(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.createImage.client.gems.EIS_Rewrite_Srv
 * JD-Core Version:    0.7.0.1
 */