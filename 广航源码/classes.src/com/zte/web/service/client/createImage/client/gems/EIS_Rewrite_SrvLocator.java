package com.zte.web.service.client.createImage.client.gems;

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

public class EIS_Rewrite_SrvLocator
  extends Service
  implements EIS_Rewrite_Srv
{
  private String EIS_RewritePort_address = AccessPropertiesFile.getValue("EIS_RewritePort_address");
  private String EIS_RewritePortWSDDServiceName = "EIS_RewritePort";
  private HashSet ports = null;
  
  public EIS_Rewrite_SrvLocator() {}
  
  public EIS_Rewrite_SrvLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public EIS_Rewrite_SrvLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getEIS_RewritePortAddress()
  {
    return this.EIS_RewritePort_address;
  }
  
  public String getEIS_RewritePortWSDDServiceName()
  {
    return this.EIS_RewritePortWSDDServiceName;
  }
  
  public void setEIS_RewritePortWSDDServiceName(String paramString)
  {
    this.EIS_RewritePortWSDDServiceName = paramString;
  }
  
  public EIS_Rewrite getEIS_RewritePort()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.EIS_RewritePort_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getEIS_RewritePort(localURL);
  }
  
  public EIS_Rewrite getEIS_RewritePort(URL paramURL)
    throws ServiceException
  {
    try
    {
      EIS_RewriteBindingStub localEIS_RewriteBindingStub = new EIS_RewriteBindingStub(paramURL, this);
      localEIS_RewriteBindingStub.setPortName(getEIS_RewritePortWSDDServiceName());
      return localEIS_RewriteBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setEIS_RewritePortEndpointAddress(String paramString)
  {
    this.EIS_RewritePort_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (EIS_Rewrite.class.isAssignableFrom(paramClass))
      {
        EIS_RewriteBindingStub localEIS_RewriteBindingStub = new EIS_RewriteBindingStub(new URL(this.EIS_RewritePort_address), this);
        localEIS_RewriteBindingStub.setPortName(getEIS_RewritePortWSDDServiceName());
        return localEIS_RewriteBindingStub;
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
    if ("EIS_RewritePort".equals(str)) {
      return getEIS_RewritePort();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://gems.haier.com/EIS_Rewrite_Srv", "EIS_Rewrite_Srv");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "EIS_RewritePort"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("EIS_RewritePort".equals(paramString1)) {
      setEIS_RewritePortEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.web.service.client.createImage.client.gems.EIS_Rewrite_SrvLocator
 * JD-Core Version:    0.7.0.1
 */