package com.zte.web.service.mergeBoeSrv.service;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface MergeBoeSrvService
  extends Service
{
  public abstract String getmergeBoeSrvAddress();
  
  public abstract MergeBoeSrv getmergeBoeSrv()
    throws ServiceException;
  
  public abstract MergeBoeSrv getmergeBoeSrv(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.service.MergeBoeSrvService
 * JD-Core Version:    0.7.0.1
 */