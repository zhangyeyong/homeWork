package com.zte.eas.login.EASLogin;

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

public class EASLoginProxyServiceLocator
  extends Service
  implements EASLoginProxyService
{
  private String EASLogin_address = AccessPropertiesFile.getValue("EASLogin_address");
  private String EASLoginWSDDServiceName = "EASLogin";
  private HashSet ports = null;
  
  public EASLoginProxyServiceLocator() {}
  
  public EASLoginProxyServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public EASLoginProxyServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getEASLoginAddress()
  {
    return this.EASLogin_address;
  }
  
  public String getEASLoginWSDDServiceName()
  {
    return this.EASLoginWSDDServiceName;
  }
  
  public void setEASLoginWSDDServiceName(String paramString)
  {
    this.EASLoginWSDDServiceName = paramString;
  }
  
  public EASLoginProxy getEASLogin()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.EASLogin_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getEASLogin(localURL);
  }
  
  public EASLoginProxy getEASLogin(URL paramURL)
    throws ServiceException
  {
    try
    {
      EASLoginSoapBindingStub localEASLoginSoapBindingStub = new EASLoginSoapBindingStub(paramURL, this);
      localEASLoginSoapBindingStub.setPortName(getEASLoginWSDDServiceName());
      return localEASLoginSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setEASLoginEndpointAddress(String paramString)
  {
    this.EASLogin_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (EASLoginProxy.class.isAssignableFrom(paramClass))
      {
        EASLoginSoapBindingStub localEASLoginSoapBindingStub = new EASLoginSoapBindingStub(new URL(this.EASLogin_address), this);
        localEASLoginSoapBindingStub.setPortName(getEASLoginWSDDServiceName());
        return localEASLoginSoapBindingStub;
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
    if ("EASLogin".equals(str)) {
      return getEASLogin();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://localhost:6888/ormrpc/services/EASLogin", "EASLoginProxyService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://localhost:6888/ormrpc/services/EASLogin", "EASLogin"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("EASLogin".equals(paramString1)) {
      setEASLoginEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.login.EASLogin.EASLoginProxyServiceLocator
 * JD-Core Version:    0.7.0.1
 */