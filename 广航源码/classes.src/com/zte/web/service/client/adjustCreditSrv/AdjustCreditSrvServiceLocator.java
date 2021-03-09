package com.zte.web.service.client.adjustCreditSrv;

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

public class AdjustCreditSrvServiceLocator
  extends Service
  implements AdjustCreditSrvService
{
  private String adjustCreditSrv_address = AccessPropertiesFile.getValue("adjustCreditSrv_address");
  private String adjustCreditSrvWSDDServiceName = "adjustCreditSrv";
  private HashSet ports = null;
  
  public AdjustCreditSrvServiceLocator() {}
  
  public AdjustCreditSrvServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public AdjustCreditSrvServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getadjustCreditSrvAddress()
  {
    return this.adjustCreditSrv_address;
  }
  
  public String getadjustCreditSrvWSDDServiceName()
  {
    return this.adjustCreditSrvWSDDServiceName;
  }
  
  public void setadjustCreditSrvWSDDServiceName(String paramString)
  {
    this.adjustCreditSrvWSDDServiceName = paramString;
  }
  
  public AdjustCreditSrv getadjustCreditSrv()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.adjustCreditSrv_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getadjustCreditSrv(localURL);
  }
  
  public AdjustCreditSrv getadjustCreditSrv(URL paramURL)
    throws ServiceException
  {
    try
    {
      AdjustCreditSrvSoapBindingStub localAdjustCreditSrvSoapBindingStub = new AdjustCreditSrvSoapBindingStub(paramURL, this);
      localAdjustCreditSrvSoapBindingStub.setPortName(getadjustCreditSrvWSDDServiceName());
      return localAdjustCreditSrvSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setadjustCreditSrvEndpointAddress(String paramString)
  {
    this.adjustCreditSrv_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (AdjustCreditSrv.class.isAssignableFrom(paramClass))
      {
        AdjustCreditSrvSoapBindingStub localAdjustCreditSrvSoapBindingStub = new AdjustCreditSrvSoapBindingStub(new URL(this.adjustCreditSrv_address), this);
        localAdjustCreditSrvSoapBindingStub.setPortName(getadjustCreditSrvWSDDServiceName());
        return localAdjustCreditSrvSoapBindingStub;
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
    if ("adjustCreditSrv".equals(str)) {
      return getadjustCreditSrv();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://localhost:8080/haier/services/adjustCreditSrv", "AdjustCreditSrvService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://localhost:8080/haier/services/adjustCreditSrv", "adjustCreditSrv"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("adjustCreditSrv".equals(paramString1)) {
      setadjustCreditSrvEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.web.service.client.adjustCreditSrv.AdjustCreditSrvServiceLocator
 * JD-Core Version:    0.7.0.1
 */