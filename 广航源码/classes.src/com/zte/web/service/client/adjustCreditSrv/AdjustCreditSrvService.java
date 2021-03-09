package com.zte.web.service.client.adjustCreditSrv;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface AdjustCreditSrvService
  extends Service
{
  public abstract String getadjustCreditSrvAddress();
  
  public abstract AdjustCreditSrv getadjustCreditSrv()
    throws ServiceException;
  
  public abstract AdjustCreditSrv getadjustCreditSrv(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.adjustCreditSrv.AdjustCreditSrvService
 * JD-Core Version:    0.7.0.1
 */