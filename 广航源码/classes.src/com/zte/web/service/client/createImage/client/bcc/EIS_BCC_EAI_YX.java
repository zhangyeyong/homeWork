package com.zte.web.service.client.createImage.client.bcc;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface EIS_BCC_EAI_YX
  extends Service
{
  public abstract String getEIS_BCC_EAI_YXSoapAddress();
  
  public abstract EIS_BCC_EAI_YXSoap_PortType getEIS_BCC_EAI_YXSoap()
    throws ServiceException;
  
  public abstract EIS_BCC_EAI_YXSoap_PortType getEIS_BCC_EAI_YXSoap(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.createImage.client.bcc.EIS_BCC_EAI_YX
 * JD-Core Version:    0.7.0.1
 */