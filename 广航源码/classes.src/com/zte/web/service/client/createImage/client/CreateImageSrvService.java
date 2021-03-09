package com.zte.web.service.client.createImage.client;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface CreateImageSrvService
  extends Service
{
  public abstract String getcreateImageSrvAddress();
  
  public abstract CreateImageSrv getcreateImageSrv()
    throws ServiceException;
  
  public abstract CreateImageSrv getcreateImageSrv(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.createImage.client.CreateImageSrvService
 * JD-Core Version:    0.7.0.1
 */