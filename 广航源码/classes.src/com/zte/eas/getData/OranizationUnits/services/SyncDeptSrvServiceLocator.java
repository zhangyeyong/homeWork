package com.zte.eas.getData.OranizationUnits.services;

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

public class SyncDeptSrvServiceLocator
  extends Service
  implements SyncDeptSrvService
{
  private String syncDeptSrv_address = "http://localhost:8080/haier_eis/services/syncDeptSrv";
  private String syncDeptSrvWSDDServiceName = "syncDeptSrv";
  private HashSet ports = null;
  
  public SyncDeptSrvServiceLocator() {}
  
  public SyncDeptSrvServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public SyncDeptSrvServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getsyncDeptSrvAddress()
  {
    return this.syncDeptSrv_address;
  }
  
  public String getsyncDeptSrvWSDDServiceName()
  {
    return this.syncDeptSrvWSDDServiceName;
  }
  
  public void setsyncDeptSrvWSDDServiceName(String paramString)
  {
    this.syncDeptSrvWSDDServiceName = paramString;
  }
  
  public SyncDeptSrv getsyncDeptSrv()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.syncDeptSrv_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getsyncDeptSrv(localURL);
  }
  
  public SyncDeptSrv getsyncDeptSrv(URL paramURL)
    throws ServiceException
  {
    try
    {
      SyncDeptSrvSoapBindingStub localSyncDeptSrvSoapBindingStub = new SyncDeptSrvSoapBindingStub(paramURL, this);
      localSyncDeptSrvSoapBindingStub.setPortName(getsyncDeptSrvWSDDServiceName());
      return localSyncDeptSrvSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setsyncDeptSrvEndpointAddress(String paramString)
  {
    this.syncDeptSrv_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (SyncDeptSrv.class.isAssignableFrom(paramClass))
      {
        SyncDeptSrvSoapBindingStub localSyncDeptSrvSoapBindingStub = new SyncDeptSrvSoapBindingStub(new URL(this.syncDeptSrv_address), this);
        localSyncDeptSrvSoapBindingStub.setPortName(getsyncDeptSrvWSDDServiceName());
        return localSyncDeptSrvSoapBindingStub;
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
    if ("syncDeptSrv".equals(str)) {
      return getsyncDeptSrv();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://www.evs.com/services/syncDeptSrv", "SyncDeptSrvService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://www.evs.com/services/syncDeptSrv", "syncDeptSrv"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("syncDeptSrv".equals(paramString1)) {
      setsyncDeptSrvEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.services.SyncDeptSrvServiceLocator
 * JD-Core Version:    0.7.0.1
 */