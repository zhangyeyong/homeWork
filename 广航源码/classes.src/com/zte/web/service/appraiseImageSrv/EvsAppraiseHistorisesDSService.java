package com.zte.web.service.appraiseImageSrv;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface EvsAppraiseHistorisesDSService
  extends Service
{
  public abstract String getEidImageHistoryServiceAddress();
  
  public abstract EvsAppraiseHistorisesDS getEidImageHistoryService()
    throws ServiceException;
  
  public abstract EvsAppraiseHistorisesDS getEidImageHistoryService(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.appraiseImageSrv.EvsAppraiseHistorisesDSService
 * JD-Core Version:    0.7.0.1
 */