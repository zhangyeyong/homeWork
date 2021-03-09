package com.zte.web.service.client.getUrlServiceSrv;

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

public class GetFileAndContractUrlDSServiceLocator
  extends Service
  implements GetFileAndContractUrlDSService
{
  private String GetUrlService_address = AccessPropertiesFile.getValue("GetUrlService_address");
  private String GetUrlServiceWSDDServiceName = "GetUrlService";
  private HashSet ports = null;
  
  public GetFileAndContractUrlDSServiceLocator() {}
  
  public GetFileAndContractUrlDSServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public GetFileAndContractUrlDSServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getGetUrlServiceAddress()
  {
    return this.GetUrlService_address;
  }
  
  public String getGetUrlServiceWSDDServiceName()
  {
    return this.GetUrlServiceWSDDServiceName;
  }
  
  public void setGetUrlServiceWSDDServiceName(String paramString)
  {
    this.GetUrlServiceWSDDServiceName = paramString;
  }
  
  public GetFileAndContractUrlDS getGetUrlService()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.GetUrlService_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getGetUrlService(localURL);
  }
  
  public GetFileAndContractUrlDS getGetUrlService(URL paramURL)
    throws ServiceException
  {
    try
    {
      GetUrlServiceSoapBindingStub localGetUrlServiceSoapBindingStub = new GetUrlServiceSoapBindingStub(paramURL, this);
      localGetUrlServiceSoapBindingStub.setPortName(getGetUrlServiceWSDDServiceName());
      return localGetUrlServiceSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setGetUrlServiceEndpointAddress(String paramString)
  {
    this.GetUrlService_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (GetFileAndContractUrlDS.class.isAssignableFrom(paramClass))
      {
        GetUrlServiceSoapBindingStub localGetUrlServiceSoapBindingStub = new GetUrlServiceSoapBindingStub(new URL(this.GetUrlService_address), this);
        localGetUrlServiceSoapBindingStub.setPortName(getGetUrlServiceWSDDServiceName());
        return localGetUrlServiceSoapBindingStub;
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
    if ("GetUrlService".equals(str)) {
      return getGetUrlService();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("com.zte.eas.workrequest.bean", "GetFileAndContractUrlDSService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("com.zte.eas.workrequest.bean", "GetUrlService"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("GetUrlService".equals(paramString1)) {
      setGetUrlServiceEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.web.service.client.getUrlServiceSrv.GetFileAndContractUrlDSServiceLocator
 * JD-Core Version:    0.7.0.1
 */