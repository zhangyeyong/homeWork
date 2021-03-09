package com.cmcc.mss.nc_itf_guanghj_service;

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

public class IHrServiceLocator
  extends Service
  implements IHrService
{
  private String IHrServiceSOAP11port_http_address = AccessPropertiesFile.getValue("synEmpAndDept");
  private String IHrServiceSOAP11port_httpWSDDServiceName = "IHrServiceSOAP11port_http";
  private HashSet ports = null;
  
  public IHrServiceLocator() {}
  
  public IHrServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public IHrServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getIHrServiceSOAP11port_httpAddress()
  {
    return this.IHrServiceSOAP11port_http_address;
  }
  
  public String getIHrServiceSOAP11port_httpWSDDServiceName()
  {
    return this.IHrServiceSOAP11port_httpWSDDServiceName;
  }
  
  public void setIHrServiceSOAP11port_httpWSDDServiceName(String paramString)
  {
    this.IHrServiceSOAP11port_httpWSDDServiceName = paramString;
  }
  
  public IHrServicePortType getIHrServiceSOAP11port_http()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.IHrServiceSOAP11port_http_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getIHrServiceSOAP11port_http(localURL);
  }
  
  public IHrServicePortType getIHrServiceSOAP11port_http(URL paramURL)
    throws ServiceException
  {
    try
    {
      IHrServiceSOAP11BindingStub localIHrServiceSOAP11BindingStub = new IHrServiceSOAP11BindingStub(paramURL, this);
      localIHrServiceSOAP11BindingStub.setPortName(getIHrServiceSOAP11port_httpWSDDServiceName());
      return localIHrServiceSOAP11BindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setIHrServiceSOAP11port_httpEndpointAddress(String paramString)
  {
    this.IHrServiceSOAP11port_http_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (IHrServicePortType.class.isAssignableFrom(paramClass))
      {
        IHrServiceSOAP11BindingStub localIHrServiceSOAP11BindingStub = new IHrServiceSOAP11BindingStub(new URL(this.IHrServiceSOAP11port_http_address), this);
        localIHrServiceSOAP11BindingStub.setPortName(getIHrServiceSOAP11port_httpWSDDServiceName());
        return localIHrServiceSOAP11BindingStub;
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
    if ("IHrServiceSOAP11port_http".equals(str)) {
      return getIHrServiceSOAP11port_http();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://service.guanghj.itf.nc/IHrService", "IHrService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://service.guanghj.itf.nc/IHrService", "IHrServiceSOAP11port_http"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("IHrServiceSOAP11port_http".equals(paramString1)) {
      setIHrServiceSOAP11port_httpEndpointAddress(paramString2);
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
 * Qualified Name:     com.cmcc.mss.nc_itf_guanghj_service.IHrServiceLocator
 * JD-Core Version:    0.7.0.1
 */