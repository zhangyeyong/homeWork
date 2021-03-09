package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services;

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

public class SyncEmployeeDeptSrvServiceLocator
  extends Service
  implements SyncEmployeeDeptSrvService
{
  private String syncEmployeeDeptSrv_address = "http://localhost:8080/haier_eis/services/syncEmployeeDeptSrv";
  private String syncEmployeeDeptSrvWSDDServiceName = "syncEmployeeDeptSrv";
  private HashSet ports = null;
  
  public SyncEmployeeDeptSrvServiceLocator() {}
  
  public SyncEmployeeDeptSrvServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public SyncEmployeeDeptSrvServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getsyncEmployeeDeptSrvAddress()
  {
    return this.syncEmployeeDeptSrv_address;
  }
  
  public String getsyncEmployeeDeptSrvWSDDServiceName()
  {
    return this.syncEmployeeDeptSrvWSDDServiceName;
  }
  
  public void setsyncEmployeeDeptSrvWSDDServiceName(String paramString)
  {
    this.syncEmployeeDeptSrvWSDDServiceName = paramString;
  }
  
  public SyncEmployeeDeptSrv getsyncEmployeeDeptSrv()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.syncEmployeeDeptSrv_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getsyncEmployeeDeptSrv(localURL);
  }
  
  public SyncEmployeeDeptSrv getsyncEmployeeDeptSrv(URL paramURL)
    throws ServiceException
  {
    try
    {
      SyncEmployeeDeptSrvSoapBindingStub localSyncEmployeeDeptSrvSoapBindingStub = new SyncEmployeeDeptSrvSoapBindingStub(paramURL, this);
      localSyncEmployeeDeptSrvSoapBindingStub.setPortName(getsyncEmployeeDeptSrvWSDDServiceName());
      return localSyncEmployeeDeptSrvSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setsyncEmployeeDeptSrvEndpointAddress(String paramString)
  {
    this.syncEmployeeDeptSrv_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (SyncEmployeeDeptSrv.class.isAssignableFrom(paramClass))
      {
        SyncEmployeeDeptSrvSoapBindingStub localSyncEmployeeDeptSrvSoapBindingStub = new SyncEmployeeDeptSrvSoapBindingStub(new URL(this.syncEmployeeDeptSrv_address), this);
        localSyncEmployeeDeptSrvSoapBindingStub.setPortName(getsyncEmployeeDeptSrvWSDDServiceName());
        return localSyncEmployeeDeptSrvSoapBindingStub;
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
    if ("syncEmployeeDeptSrv".equals(str)) {
      return getsyncEmployeeDeptSrv();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://www.evs.com/services/syncEmployeeDeptSrv", "SyncEmployeeDeptSrvService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://www.evs.com/services/syncEmployeeDeptSrv", "syncEmployeeDeptSrv"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("syncEmployeeDeptSrv".equals(paramString1)) {
      setsyncEmployeeDeptSrvEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.SyncEmployeeDeptSrvServiceLocator
 * JD-Core Version:    0.7.0.1
 */