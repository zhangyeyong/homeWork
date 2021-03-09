package com.zte.web.service.client.sendMSMService;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface SendMSMService_Service
  extends Service
{
  public abstract String getSendMSMServiceSOAPAddress();
  
  public abstract SendMSMService_PortType getSendMSMServiceSOAP()
    throws ServiceException;
  
  public abstract SendMSMService_PortType getSendMSMServiceSOAP(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.sendMSMService.SendMSMService_Service
 * JD-Core Version:    0.7.0.1
 */