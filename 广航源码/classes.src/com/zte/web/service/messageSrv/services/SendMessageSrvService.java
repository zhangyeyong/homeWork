package com.zte.web.service.messageSrv.services;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface SendMessageSrvService
  extends Service
{
  public abstract String getsendMessageSrvAddress();
  
  public abstract SendMessageSrv getsendMessageSrv()
    throws ServiceException;
  
  public abstract SendMessageSrv getsendMessageSrv(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.messageSrv.services.SendMessageSrvService
 * JD-Core Version:    0.7.0.1
 */