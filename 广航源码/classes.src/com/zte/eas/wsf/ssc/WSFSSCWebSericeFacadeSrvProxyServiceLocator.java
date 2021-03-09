package com.zte.eas.wsf.ssc;

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

public class WSFSSCWebSericeFacadeSrvProxyServiceLocator
  extends Service
  implements WSFSSCWebSericeFacadeSrvProxyService
{
  private String WSFSSCWebSericeFacade_address = AccessPropertiesFile.getValue("WSFSSCWebSericeFacade_address");
  private String WSFSSCWebSericeFacadeWSDDServiceName = "WSFSSCWebSericeFacade";
  private HashSet ports = null;
  
  public WSFSSCWebSericeFacadeSrvProxyServiceLocator() {}
  
  public WSFSSCWebSericeFacadeSrvProxyServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public WSFSSCWebSericeFacadeSrvProxyServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getWSFSSCWebSericeFacadeAddress()
  {
    return this.WSFSSCWebSericeFacade_address;
  }
  
  public String getWSFSSCWebSericeFacadeWSDDServiceName()
  {
    return this.WSFSSCWebSericeFacadeWSDDServiceName;
  }
  
  public void setWSFSSCWebSericeFacadeWSDDServiceName(String paramString)
  {
    this.WSFSSCWebSericeFacadeWSDDServiceName = paramString;
  }
  
  public WSFSSCWebSericeFacadeSrvProxy getWSFSSCWebSericeFacade()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.WSFSSCWebSericeFacade_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getWSFSSCWebSericeFacade(localURL);
  }
  
  public WSFSSCWebSericeFacadeSrvProxy getWSFSSCWebSericeFacade(URL paramURL)
    throws ServiceException
  {
    try
    {
      WSFSSCWebSericeFacadeSoapBindingStub localWSFSSCWebSericeFacadeSoapBindingStub = new WSFSSCWebSericeFacadeSoapBindingStub(paramURL, this);
      localWSFSSCWebSericeFacadeSoapBindingStub.setPortName(getWSFSSCWebSericeFacadeWSDDServiceName());
      return localWSFSSCWebSericeFacadeSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setWSFSSCWebSericeFacadeEndpointAddress(String paramString)
  {
    this.WSFSSCWebSericeFacade_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (WSFSSCWebSericeFacadeSrvProxy.class.isAssignableFrom(paramClass))
      {
        WSFSSCWebSericeFacadeSoapBindingStub localWSFSSCWebSericeFacadeSoapBindingStub = new WSFSSCWebSericeFacadeSoapBindingStub(new URL(this.WSFSSCWebSericeFacade_address), this);
        localWSFSSCWebSericeFacadeSoapBindingStub.setPortName(getWSFSSCWebSericeFacadeWSDDServiceName());
        return localWSFSSCWebSericeFacadeSoapBindingStub;
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
    if ("WSFSSCWebSericeFacade".equals(str)) {
      return getWSFSSCWebSericeFacade();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://localhost:6888/ormrpc/services/WSFSSCWebSericeFacade", "WSFSSCWebSericeFacadeSrvProxyService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://localhost:6888/ormrpc/services/WSFSSCWebSericeFacade", "WSFSSCWebSericeFacade"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("WSFSSCWebSericeFacade".equals(paramString1)) {
      setWSFSSCWebSericeFacadeEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.wsf.ssc.WSFSSCWebSericeFacadeSrvProxyServiceLocator
 * JD-Core Version:    0.7.0.1
 */