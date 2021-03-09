package com.zte.web.service.client.getUrlServiceSrv;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface GetFileAndContractUrlDSService
  extends Service
{
  public abstract String getGetUrlServiceAddress();
  
  public abstract GetFileAndContractUrlDS getGetUrlService()
    throws ServiceException;
  
  public abstract GetFileAndContractUrlDS getGetUrlService(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.getUrlServiceSrv.GetFileAndContractUrlDSService
 * JD-Core Version:    0.7.0.1
 */