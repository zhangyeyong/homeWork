package com.zte.eas.boe.image.syn.model;

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

public class SB_EAS_EAS_ImportImageOperationInfoSrv_ServiceLocator
  extends Service
  implements SB_EAS_EAS_ImportImageOperationInfoSrv_Service
{
  private String SB_EAS_EAS_ImportImageOperationInfoSrvPort_address = AccessPropertiesFile.getValue("image_in");
  private String SB_EAS_EAS_ImportImageOperationInfoSrvPortWSDDServiceName = "SB_EAS_EAS_ImportImageOperationInfoSrvPort";
  private HashSet ports = null;
  
  public SB_EAS_EAS_ImportImageOperationInfoSrv_ServiceLocator() {}
  
  public SB_EAS_EAS_ImportImageOperationInfoSrv_ServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public SB_EAS_EAS_ImportImageOperationInfoSrv_ServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getSB_EAS_EAS_ImportImageOperationInfoSrvPortAddress()
  {
    return this.SB_EAS_EAS_ImportImageOperationInfoSrvPort_address;
  }
  
  public String getSB_EAS_EAS_ImportImageOperationInfoSrvPortWSDDServiceName()
  {
    return this.SB_EAS_EAS_ImportImageOperationInfoSrvPortWSDDServiceName;
  }
  
  public void setSB_EAS_EAS_ImportImageOperationInfoSrvPortWSDDServiceName(String paramString)
  {
    this.SB_EAS_EAS_ImportImageOperationInfoSrvPortWSDDServiceName = paramString;
  }
  
  public SB_EAS_EAS_ImportImageOperationInfoSrv_PortType getSB_EAS_EAS_ImportImageOperationInfoSrvPort()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.SB_EAS_EAS_ImportImageOperationInfoSrvPort_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getSB_EAS_EAS_ImportImageOperationInfoSrvPort(localURL);
  }
  
  public SB_EAS_EAS_ImportImageOperationInfoSrv_PortType getSB_EAS_EAS_ImportImageOperationInfoSrvPort(URL paramURL)
    throws ServiceException
  {
    try
    {
      SB_EAS_EAS_ImportImageOperationInfoSrvBindingStub localSB_EAS_EAS_ImportImageOperationInfoSrvBindingStub = new SB_EAS_EAS_ImportImageOperationInfoSrvBindingStub(paramURL, this);
      localSB_EAS_EAS_ImportImageOperationInfoSrvBindingStub.setPortName(getSB_EAS_EAS_ImportImageOperationInfoSrvPortWSDDServiceName());
      return localSB_EAS_EAS_ImportImageOperationInfoSrvBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setSB_EAS_EAS_ImportImageOperationInfoSrvPortEndpointAddress(String paramString)
  {
    this.SB_EAS_EAS_ImportImageOperationInfoSrvPort_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (SB_EAS_EAS_ImportImageOperationInfoSrv_PortType.class.isAssignableFrom(paramClass))
      {
        SB_EAS_EAS_ImportImageOperationInfoSrvBindingStub localSB_EAS_EAS_ImportImageOperationInfoSrvBindingStub = new SB_EAS_EAS_ImportImageOperationInfoSrvBindingStub(new URL(this.SB_EAS_EAS_ImportImageOperationInfoSrvPort_address), this);
        localSB_EAS_EAS_ImportImageOperationInfoSrvBindingStub.setPortName(getSB_EAS_EAS_ImportImageOperationInfoSrvPortWSDDServiceName());
        return localSB_EAS_EAS_ImportImageOperationInfoSrvBindingStub;
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
    if ("SB_EAS_EAS_ImportImageOperationInfoSrvPort".equals(str)) {
      return getSB_EAS_EAS_ImportImageOperationInfoSrvPort();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "SB_EAS_EAS_ImportImageOperationInfoSrv");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "SB_EAS_EAS_ImportImageOperationInfoSrvPort"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("SB_EAS_EAS_ImportImageOperationInfoSrvPort".equals(paramString1)) {
      setSB_EAS_EAS_ImportImageOperationInfoSrvPortEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.boe.image.syn.model.SB_EAS_EAS_ImportImageOperationInfoSrv_ServiceLocator
 * JD-Core Version:    0.7.0.1
 */