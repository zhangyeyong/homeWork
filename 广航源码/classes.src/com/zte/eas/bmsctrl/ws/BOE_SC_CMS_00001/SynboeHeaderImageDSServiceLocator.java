package com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00001;

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

public class SynboeHeaderImageDSServiceLocator
  extends Service
  implements SynboeHeaderImageDSService
{
  private String synboeHeaderImageDS_address = "http://localhost:8080/JSYDEAS/services/synboeHeaderImageDS";
  private String synboeHeaderImageDSWSDDServiceName = "synboeHeaderImageDS";
  private HashSet ports = null;
  
  public SynboeHeaderImageDSServiceLocator() {}
  
  public SynboeHeaderImageDSServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public SynboeHeaderImageDSServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getsynboeHeaderImageDSAddress()
  {
    return this.synboeHeaderImageDS_address;
  }
  
  public String getsynboeHeaderImageDSWSDDServiceName()
  {
    return this.synboeHeaderImageDSWSDDServiceName;
  }
  
  public void setsynboeHeaderImageDSWSDDServiceName(String paramString)
  {
    this.synboeHeaderImageDSWSDDServiceName = paramString;
  }
  
  public SynboeHeaderImageDS getsynboeHeaderImageDS()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.synboeHeaderImageDS_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getsynboeHeaderImageDS(localURL);
  }
  
  public SynboeHeaderImageDS getsynboeHeaderImageDS(URL paramURL)
    throws ServiceException
  {
    try
    {
      SynboeHeaderImageDSSoapBindingStub localSynboeHeaderImageDSSoapBindingStub = new SynboeHeaderImageDSSoapBindingStub(paramURL, this);
      localSynboeHeaderImageDSSoapBindingStub.setPortName(getsynboeHeaderImageDSWSDDServiceName());
      return localSynboeHeaderImageDSSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setsynboeHeaderImageDSEndpointAddress(String paramString)
  {
    this.synboeHeaderImageDS_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (SynboeHeaderImageDS.class.isAssignableFrom(paramClass))
      {
        SynboeHeaderImageDSSoapBindingStub localSynboeHeaderImageDSSoapBindingStub = new SynboeHeaderImageDSSoapBindingStub(new URL(this.synboeHeaderImageDS_address), this);
        localSynboeHeaderImageDSSoapBindingStub.setPortName(getsynboeHeaderImageDSWSDDServiceName());
        return localSynboeHeaderImageDSSoapBindingStub;
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
    if ("synboeHeaderImageDS".equals(str)) {
      return getsynboeHeaderImageDS();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://localhost:8080/JSYDEAS/services/synboeHeaderImageDS", "SynboeHeaderImageDSService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://localhost:8080/JSYDEAS/services/synboeHeaderImageDS", "synboeHeaderImageDS"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("synboeHeaderImageDS".equals(paramString1)) {
      setsynboeHeaderImageDSEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00001.SynboeHeaderImageDSServiceLocator
 * JD-Core Version:    0.7.0.1
 */