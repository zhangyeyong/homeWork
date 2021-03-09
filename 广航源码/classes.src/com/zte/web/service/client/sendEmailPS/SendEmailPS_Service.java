package com.zte.web.service.client.sendEmailPS;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface SendEmailPS_Service
  extends Service
{
  public abstract String getSendEmailPSSOAPAddress();
  
  public abstract SendEmailPS_PortType getSendEmailPSSOAP()
    throws ServiceException;
  
  public abstract SendEmailPS_PortType getSendEmailPSSOAP(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.sendEmailPS.SendEmailPS_Service
 * JD-Core Version:    0.7.0.1
 */