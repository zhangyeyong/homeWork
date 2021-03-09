package com.zte.web.service.client.sendEmailPS;

import com.zte.ssb.AccessPropertiesFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;

public class SendEmailPS_ServiceLocator
  extends Service
  implements SendEmailPS_Service
{
  private String SendEmailPSSOAP_address;
  private String SendEmailPSSOAPWSDDServiceName;
  private HashSet ports;
  
  public SendEmailPS_ServiceLocator()
  {
    new AccessPropertiesFile();
    this.SendEmailPSSOAP_address = AccessPropertiesFile.getValue("SendEmailPS");
    this.SendEmailPSSOAPWSDDServiceName = "SendEmailPSSOAP";
    this.ports = null;
  }
  
  public SendEmailPS_ServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
    new AccessPropertiesFile();
    this.SendEmailPSSOAP_address = AccessPropertiesFile.getValue("SendEmailPS");
    this.SendEmailPSSOAPWSDDServiceName = "SendEmailPSSOAP";
    this.ports = null;
  }
  
  public SendEmailPS_ServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
    new AccessPropertiesFile();
    this.SendEmailPSSOAP_address = AccessPropertiesFile.getValue("SendEmailPS");
    this.SendEmailPSSOAPWSDDServiceName = "SendEmailPSSOAP";
    this.ports = null;
  }
  
  public String getSendEmailPSSOAPAddress()
  {
    return this.SendEmailPSSOAP_address;
  }
  
  public String getSendEmailPSSOAPWSDDServiceName()
  {
    return this.SendEmailPSSOAPWSDDServiceName;
  }
  
  public void setSendEmailPSSOAPWSDDServiceName(String paramString)
  {
    this.SendEmailPSSOAPWSDDServiceName = paramString;
  }
  
  public SendEmailPS_PortType getSendEmailPSSOAP()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.SendEmailPSSOAP_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getSendEmailPSSOAP(localURL);
  }
  
  public SendEmailPS_PortType getSendEmailPSSOAP(URL paramURL)
    throws ServiceException
  {
    try
    {
      SendEmailPSSOAPStub localSendEmailPSSOAPStub = new SendEmailPSSOAPStub(paramURL, this);
      localSendEmailPSSOAPStub.setPortName(getSendEmailPSSOAPWSDDServiceName());
      return localSendEmailPSSOAPStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setSendEmailPSSOAPEndpointAddress(String paramString)
  {
    this.SendEmailPSSOAP_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (SendEmailPS_PortType.class.isAssignableFrom(paramClass))
      {
        SendEmailPSSOAPStub localSendEmailPSSOAPStub = new SendEmailPSSOAPStub(new URL(this.SendEmailPSSOAP_address), this);
        localSendEmailPSSOAPStub.setPortName(getSendEmailPSSOAPWSDDServiceName());
        return localSendEmailPSSOAPStub;
      }
    }
    catch (Throwable localThrowable)
    {
      throw new ServiceException(localThrowable);
    }
    throw new ServiceException("There is no stub implementation for the interface:  " + (paramClass == null ? "null" : paramClass.getName()));
  }
  
  public Remote getPort(QName paramQName, Class paramClass)
    throws ServiceException
  {
    if (paramQName == null) {
      return getPort(paramClass);
    }
    String str = paramQName.getLocalPart();
    if ("SendEmailPSSOAP".equals(str)) {
      return getSendEmailPSSOAP();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://www.haier.eai.com/SendEmailPS", "SendEmailPS");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://www.haier.eai.com/SendEmailPS", "SendEmailPSSOAP"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("SendEmailPSSOAP".equals(paramString1)) {
      setSendEmailPSSOAPEndpointAddress(paramString2);
    } else {
      throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + paramString1);
    }
  }
  
  public void setEndpointAddress(QName paramQName, String paramString)
    throws ServiceException
  {
    setEndpointAddress(paramQName.getLocalPart(), paramString);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.sendEmailPS.SendEmailPS_ServiceLocator
 * JD-Core Version:    0.7.0.1
 */