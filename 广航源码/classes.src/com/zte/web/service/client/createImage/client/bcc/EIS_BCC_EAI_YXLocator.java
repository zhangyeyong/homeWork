package com.zte.web.service.client.createImage.client.bcc;

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

public class EIS_BCC_EAI_YXLocator
  extends Service
  implements EIS_BCC_EAI_YX
{
  private String EIS_BCC_EAI_YXSoap_address = AccessPropertiesFile.getValue("EIS_BCC_EAI_YXSoap_address");
  private String EIS_BCC_EAI_YXSoapWSDDServiceName = "EIS_BCC_EAI_YXSoap";
  private HashSet ports = null;
  
  public EIS_BCC_EAI_YXLocator() {}
  
  public EIS_BCC_EAI_YXLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public EIS_BCC_EAI_YXLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getEIS_BCC_EAI_YXSoapAddress()
  {
    return this.EIS_BCC_EAI_YXSoap_address;
  }
  
  public String getEIS_BCC_EAI_YXSoapWSDDServiceName()
  {
    return this.EIS_BCC_EAI_YXSoapWSDDServiceName;
  }
  
  public void setEIS_BCC_EAI_YXSoapWSDDServiceName(String paramString)
  {
    this.EIS_BCC_EAI_YXSoapWSDDServiceName = paramString;
  }
  
  public EIS_BCC_EAI_YXSoap_PortType getEIS_BCC_EAI_YXSoap()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.EIS_BCC_EAI_YXSoap_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getEIS_BCC_EAI_YXSoap(localURL);
  }
  
  public EIS_BCC_EAI_YXSoap_PortType getEIS_BCC_EAI_YXSoap(URL paramURL)
    throws ServiceException
  {
    try
    {
      EIS_BCC_EAI_YXSoap_BindingStub localEIS_BCC_EAI_YXSoap_BindingStub = new EIS_BCC_EAI_YXSoap_BindingStub(paramURL, this);
      localEIS_BCC_EAI_YXSoap_BindingStub.setPortName(getEIS_BCC_EAI_YXSoapWSDDServiceName());
      return localEIS_BCC_EAI_YXSoap_BindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setEIS_BCC_EAI_YXSoapEndpointAddress(String paramString)
  {
    this.EIS_BCC_EAI_YXSoap_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (EIS_BCC_EAI_YXSoap_PortType.class.isAssignableFrom(paramClass))
      {
        EIS_BCC_EAI_YXSoap_BindingStub localEIS_BCC_EAI_YXSoap_BindingStub = new EIS_BCC_EAI_YXSoap_BindingStub(new URL(this.EIS_BCC_EAI_YXSoap_address), this);
        localEIS_BCC_EAI_YXSoap_BindingStub.setPortName(getEIS_BCC_EAI_YXSoapWSDDServiceName());
        return localEIS_BCC_EAI_YXSoap_BindingStub;
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
    if ("EIS_BCC_EAI_YXSoap".equals(str)) {
      return getEIS_BCC_EAI_YXSoap();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://tempuri.org/", "EIS_BCC_EAI_YX");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://tempuri.org/", "EIS_BCC_EAI_YXSoap"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("EIS_BCC_EAI_YXSoap".equals(paramString1)) {
      setEIS_BCC_EAI_YXSoapEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.web.service.client.createImage.client.bcc.EIS_BCC_EAI_YXLocator
 * JD-Core Version:    0.7.0.1
 */