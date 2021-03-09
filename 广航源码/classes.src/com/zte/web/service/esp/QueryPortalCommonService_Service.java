package com.zte.web.service.esp;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface QueryPortalCommonService_Service
  extends Service
{
  public abstract String getQueryPortalCommonServiceSOAPAddress();
  
  public abstract QueryPortalCommonService_PortType getQueryPortalCommonServiceSOAP()
    throws ServiceException;
  
  public abstract QueryPortalCommonService_PortType getQueryPortalCommonServiceSOAP(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.esp.QueryPortalCommonService_Service
 * JD-Core Version:    0.7.0.1
 */