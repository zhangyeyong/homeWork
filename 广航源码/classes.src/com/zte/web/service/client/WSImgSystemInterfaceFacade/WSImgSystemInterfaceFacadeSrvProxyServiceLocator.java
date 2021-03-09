package com.zte.web.service.client.WSImgSystemInterfaceFacade;

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

public class WSImgSystemInterfaceFacadeSrvProxyServiceLocator
  extends Service
  implements WSImgSystemInterfaceFacadeSrvProxyService
{
  private String WSImgSystemInterfaceFacade_address = AccessPropertiesFile.getValue("imgSystemInterfaceFacade_address");
  private String WSImgSystemInterfaceFacadeWSDDServiceName = "WSImgSystemInterfaceFacade";
  private HashSet ports = null;
  
  public WSImgSystemInterfaceFacadeSrvProxyServiceLocator() {}
  
  public WSImgSystemInterfaceFacadeSrvProxyServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public WSImgSystemInterfaceFacadeSrvProxyServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getWSImgSystemInterfaceFacadeAddress()
  {
    return this.WSImgSystemInterfaceFacade_address;
  }
  
  public String getWSImgSystemInterfaceFacadeWSDDServiceName()
  {
    return this.WSImgSystemInterfaceFacadeWSDDServiceName;
  }
  
  public void setWSImgSystemInterfaceFacadeWSDDServiceName(String paramString)
  {
    this.WSImgSystemInterfaceFacadeWSDDServiceName = paramString;
  }
  
  public WSImgSystemInterfaceFacadeSrvProxy getWSImgSystemInterfaceFacade()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.WSImgSystemInterfaceFacade_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getWSImgSystemInterfaceFacade(localURL);
  }
  
  public WSImgSystemInterfaceFacadeSrvProxy getWSImgSystemInterfaceFacade(URL paramURL)
    throws ServiceException
  {
    try
    {
      WSImgSystemInterfaceFacadeSoapBindingStub localWSImgSystemInterfaceFacadeSoapBindingStub = new WSImgSystemInterfaceFacadeSoapBindingStub(paramURL, this);
      localWSImgSystemInterfaceFacadeSoapBindingStub.setPortName(getWSImgSystemInterfaceFacadeWSDDServiceName());
      return localWSImgSystemInterfaceFacadeSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setWSImgSystemInterfaceFacadeEndpointAddress(String paramString)
  {
    this.WSImgSystemInterfaceFacade_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (WSImgSystemInterfaceFacadeSrvProxy.class.isAssignableFrom(paramClass))
      {
        WSImgSystemInterfaceFacadeSoapBindingStub localWSImgSystemInterfaceFacadeSoapBindingStub = new WSImgSystemInterfaceFacadeSoapBindingStub(new URL(this.WSImgSystemInterfaceFacade_address), this);
        localWSImgSystemInterfaceFacadeSoapBindingStub.setPortName(getWSImgSystemInterfaceFacadeWSDDServiceName());
        return localWSImgSystemInterfaceFacadeSoapBindingStub;
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
    if ("WSImgSystemInterfaceFacade".equals(str)) {
      return getWSImgSystemInterfaceFacade();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://192.168.17.194:9888/ormrpc/services/WSImgSystemInterfaceFacade", "WSImgSystemInterfaceFacadeSrvProxyService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://192.168.17.194:9888/ormrpc/services/WSImgSystemInterfaceFacade", "WSImgSystemInterfaceFacade"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("WSImgSystemInterfaceFacade".equals(paramString1)) {
      setWSImgSystemInterfaceFacadeEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.web.service.client.WSImgSystemInterfaceFacade.WSImgSystemInterfaceFacadeSrvProxyServiceLocator
 * JD-Core Version:    0.7.0.1
 */