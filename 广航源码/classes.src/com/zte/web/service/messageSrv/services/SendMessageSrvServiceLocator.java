package com.zte.web.service.messageSrv.services;

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

public class SendMessageSrvServiceLocator
  extends Service
  implements SendMessageSrvService
{
  private String sendMessageSrv_address = "http://localhost:8088/EBILL_HAIER/services/sendMessageSrv";
  private String sendMessageSrvWSDDServiceName = "sendMessageSrv";
  private HashSet ports = null;
  
  public SendMessageSrvServiceLocator() {}
  
  public SendMessageSrvServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public SendMessageSrvServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getsendMessageSrvAddress()
  {
    return this.sendMessageSrv_address;
  }
  
  public String getsendMessageSrvWSDDServiceName()
  {
    return this.sendMessageSrvWSDDServiceName;
  }
  
  public void setsendMessageSrvWSDDServiceName(String paramString)
  {
    this.sendMessageSrvWSDDServiceName = paramString;
  }
  
  public SendMessageSrv getsendMessageSrv()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.sendMessageSrv_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getsendMessageSrv(localURL);
  }
  
  public SendMessageSrv getsendMessageSrv(URL paramURL)
    throws ServiceException
  {
    try
    {
      SendMessageSrvSoapBindingStub localSendMessageSrvSoapBindingStub = new SendMessageSrvSoapBindingStub(paramURL, this);
      localSendMessageSrvSoapBindingStub.setPortName(getsendMessageSrvWSDDServiceName());
      return localSendMessageSrvSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setsendMessageSrvEndpointAddress(String paramString)
  {
    this.sendMessageSrv_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (SendMessageSrv.class.isAssignableFrom(paramClass))
      {
        SendMessageSrvSoapBindingStub localSendMessageSrvSoapBindingStub = new SendMessageSrvSoapBindingStub(new URL(this.sendMessageSrv_address), this);
        localSendMessageSrvSoapBindingStub.setPortName(getsendMessageSrvWSDDServiceName());
        return localSendMessageSrvSoapBindingStub;
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
    if ("sendMessageSrv".equals(str)) {
      return getsendMessageSrv();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://eis.haier.com/services/sendMessageSrv", "SendMessageSrvService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://eis.haier.com/services/sendMessageSrv", "sendMessageSrv"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("sendMessageSrv".equals(paramString1)) {
      setsendMessageSrvEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.web.service.messageSrv.services.SendMessageSrvServiceLocator
 * JD-Core Version:    0.7.0.1
 */