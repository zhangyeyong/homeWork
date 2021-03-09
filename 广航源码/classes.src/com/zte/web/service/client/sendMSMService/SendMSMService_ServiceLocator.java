package com.zte.web.service.client.sendMSMService;

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

public class SendMSMService_ServiceLocator
  extends Service
  implements SendMSMService_Service
{
  private String SendMSMServiceSOAP_address;
  private String SendMSMServiceSOAPWSDDServiceName;
  private HashSet ports;
  
  public SendMSMService_ServiceLocator()
  {
    new AccessPropertiesFile();
    this.SendMSMServiceSOAP_address = AccessPropertiesFile.getValue("SendMSMService");
    this.SendMSMServiceSOAPWSDDServiceName = "SendMSMService";
    this.ports = null;
  }
  
  public SendMSMService_ServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
    new AccessPropertiesFile();
    this.SendMSMServiceSOAP_address = AccessPropertiesFile.getValue("SendMSMService");
    this.SendMSMServiceSOAPWSDDServiceName = "SendMSMService";
    this.ports = null;
  }
  
  public SendMSMService_ServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
    new AccessPropertiesFile();
    this.SendMSMServiceSOAP_address = AccessPropertiesFile.getValue("SendMSMService");
    this.SendMSMServiceSOAPWSDDServiceName = "SendMSMService";
    this.ports = null;
  }
  
  public String getSendMSMServiceSOAPAddress()
  {
    return this.SendMSMServiceSOAP_address;
  }
  
  public String getSendMSMServiceSOAPWSDDServiceName()
  {
    return this.SendMSMServiceSOAPWSDDServiceName;
  }
  
  public void setSendMSMServiceSOAPWSDDServiceName(String paramString)
  {
    this.SendMSMServiceSOAPWSDDServiceName = paramString;
  }
  
  public SendMSMService_PortType getSendMSMServiceSOAP()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.SendMSMServiceSOAP_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getSendMSMServiceSOAP(localURL);
  }
  
  public SendMSMService_PortType getSendMSMServiceSOAP(URL paramURL)
    throws ServiceException
  {
    try
    {
      SendMSMServiceSOAPStub localSendMSMServiceSOAPStub = new SendMSMServiceSOAPStub(paramURL, this);
      localSendMSMServiceSOAPStub.setPortName(getSendMSMServiceSOAPWSDDServiceName());
      return localSendMSMServiceSOAPStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setSendMSMServiceSOAPEndpointAddress(String paramString)
  {
    this.SendMSMServiceSOAP_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (SendMSMService_PortType.class.isAssignableFrom(paramClass))
      {
        SendMSMServiceSOAPStub localSendMSMServiceSOAPStub = new SendMSMServiceSOAPStub(new URL(this.SendMSMServiceSOAP_address), this);
        localSendMSMServiceSOAPStub.setPortName(getSendMSMServiceSOAPWSDDServiceName());
        return localSendMSMServiceSOAPStub;
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
    if ("SendMSMServiceSOAP".equals(str)) {
      return getSendMSMServiceSOAP();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://www.haier.eai/SendMSMService/", "SendMSMService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://www.haier.eai/SendMSMService/", "SendMSMServiceSOAP"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("SendMSMServiceSOAP".equals(paramString1)) {
      setSendMSMServiceSOAPEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.web.service.client.sendMSMService.SendMSMService_ServiceLocator
 * JD-Core Version:    0.7.0.1
 */