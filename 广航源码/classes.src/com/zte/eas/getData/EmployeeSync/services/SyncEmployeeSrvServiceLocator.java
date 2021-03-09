package com.zte.eas.getData.EmployeeSync.services;

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

public class SyncEmployeeSrvServiceLocator
  extends Service
  implements SyncEmployeeSrvService
{
  private String syncEmployeeSrv_address = "http://localhost:8080/haier_eis/services/syncEmployeeSrv";
  private String syncEmployeeSrvWSDDServiceName = "syncEmployeeSrv";
  private HashSet ports = null;
  
  public SyncEmployeeSrvServiceLocator() {}
  
  public SyncEmployeeSrvServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public SyncEmployeeSrvServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getsyncEmployeeSrvAddress()
  {
    return this.syncEmployeeSrv_address;
  }
  
  public String getsyncEmployeeSrvWSDDServiceName()
  {
    return this.syncEmployeeSrvWSDDServiceName;
  }
  
  public void setsyncEmployeeSrvWSDDServiceName(String paramString)
  {
    this.syncEmployeeSrvWSDDServiceName = paramString;
  }
  
  public SyncEmployeeSrv getsyncEmployeeSrv()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.syncEmployeeSrv_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getsyncEmployeeSrv(localURL);
  }
  
  public SyncEmployeeSrv getsyncEmployeeSrv(URL paramURL)
    throws ServiceException
  {
    try
    {
      SyncEmployeeSrvSoapBindingStub localSyncEmployeeSrvSoapBindingStub = new SyncEmployeeSrvSoapBindingStub(paramURL, this);
      localSyncEmployeeSrvSoapBindingStub.setPortName(getsyncEmployeeSrvWSDDServiceName());
      return localSyncEmployeeSrvSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setsyncEmployeeSrvEndpointAddress(String paramString)
  {
    this.syncEmployeeSrv_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (SyncEmployeeSrv.class.isAssignableFrom(paramClass))
      {
        SyncEmployeeSrvSoapBindingStub localSyncEmployeeSrvSoapBindingStub = new SyncEmployeeSrvSoapBindingStub(new URL(this.syncEmployeeSrv_address), this);
        localSyncEmployeeSrvSoapBindingStub.setPortName(getsyncEmployeeSrvWSDDServiceName());
        return localSyncEmployeeSrvSoapBindingStub;
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
    if ("syncEmployeeSrv".equals(str)) {
      return getsyncEmployeeSrv();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://www.evs.com/services/syncEmployeeSrv", "SyncEmployeeSrvService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://www.evs.com/services/syncEmployeeSrv", "syncEmployeeSrv"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("syncEmployeeSrv".equals(paramString1)) {
      setsyncEmployeeSrvEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.getData.EmployeeSync.services.SyncEmployeeSrvServiceLocator
 * JD-Core Version:    0.7.0.1
 */