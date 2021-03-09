package com.zte.web.service.mergeBoeSrv.service;

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

public class MergeBoeSrvServiceLocator
  extends Service
  implements MergeBoeSrvService
{
  private String mergeBoeSrv_address = "http://localhost:8080/EBILL_HAIER/services/mergeBoeSrv";
  private String mergeBoeSrvWSDDServiceName = "mergeBoeSrv";
  private HashSet ports = null;
  
  public MergeBoeSrvServiceLocator() {}
  
  public MergeBoeSrvServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public MergeBoeSrvServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getmergeBoeSrvAddress()
  {
    return this.mergeBoeSrv_address;
  }
  
  public String getmergeBoeSrvWSDDServiceName()
  {
    return this.mergeBoeSrvWSDDServiceName;
  }
  
  public void setmergeBoeSrvWSDDServiceName(String paramString)
  {
    this.mergeBoeSrvWSDDServiceName = paramString;
  }
  
  public MergeBoeSrv getmergeBoeSrv()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.mergeBoeSrv_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getmergeBoeSrv(localURL);
  }
  
  public MergeBoeSrv getmergeBoeSrv(URL paramURL)
    throws ServiceException
  {
    try
    {
      MergeBoeSrvSoapBindingStub localMergeBoeSrvSoapBindingStub = new MergeBoeSrvSoapBindingStub(paramURL, this);
      localMergeBoeSrvSoapBindingStub.setPortName(getmergeBoeSrvWSDDServiceName());
      return localMergeBoeSrvSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setmergeBoeSrvEndpointAddress(String paramString)
  {
    this.mergeBoeSrv_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (MergeBoeSrv.class.isAssignableFrom(paramClass))
      {
        MergeBoeSrvSoapBindingStub localMergeBoeSrvSoapBindingStub = new MergeBoeSrvSoapBindingStub(new URL(this.mergeBoeSrv_address), this);
        localMergeBoeSrvSoapBindingStub.setPortName(getmergeBoeSrvWSDDServiceName());
        return localMergeBoeSrvSoapBindingStub;
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
    if ("mergeBoeSrv".equals(str)) {
      return getmergeBoeSrv();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://127.0.0.1/deppon", "MergeBoeSrvService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://127.0.0.1/deppon", "mergeBoeSrv"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("mergeBoeSrv".equals(paramString1)) {
      setmergeBoeSrvEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.service.MergeBoeSrvServiceLocator
 * JD-Core Version:    0.7.0.1
 */