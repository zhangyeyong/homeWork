package com.zte.web.service.appraiseImageSrv;

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

public class EvsAppraiseHistorisesDSServiceLocator
  extends Service
  implements EvsAppraiseHistorisesDSService
{
  private String EidImageHistoryService_address = "http://localhost:8080/EBILL_HAIER/services/EidImageHistoryService";
  private String EidImageHistoryServiceWSDDServiceName = "EidImageHistoryService";
  private HashSet ports = null;
  
  public EvsAppraiseHistorisesDSServiceLocator() {}
  
  public EvsAppraiseHistorisesDSServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public EvsAppraiseHistorisesDSServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getEidImageHistoryServiceAddress()
  {
    return this.EidImageHistoryService_address;
  }
  
  public String getEidImageHistoryServiceWSDDServiceName()
  {
    return this.EidImageHistoryServiceWSDDServiceName;
  }
  
  public void setEidImageHistoryServiceWSDDServiceName(String paramString)
  {
    this.EidImageHistoryServiceWSDDServiceName = paramString;
  }
  
  public EvsAppraiseHistorisesDS getEidImageHistoryService()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.EidImageHistoryService_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getEidImageHistoryService(localURL);
  }
  
  public EvsAppraiseHistorisesDS getEidImageHistoryService(URL paramURL)
    throws ServiceException
  {
    try
    {
      EidImageHistoryServiceSoapBindingStub localEidImageHistoryServiceSoapBindingStub = new EidImageHistoryServiceSoapBindingStub(paramURL, this);
      localEidImageHistoryServiceSoapBindingStub.setPortName(getEidImageHistoryServiceWSDDServiceName());
      return localEidImageHistoryServiceSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setEidImageHistoryServiceEndpointAddress(String paramString)
  {
    this.EidImageHistoryService_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (EvsAppraiseHistorisesDS.class.isAssignableFrom(paramClass))
      {
        EidImageHistoryServiceSoapBindingStub localEidImageHistoryServiceSoapBindingStub = new EidImageHistoryServiceSoapBindingStub(new URL(this.EidImageHistoryService_address), this);
        localEidImageHistoryServiceSoapBindingStub.setPortName(getEidImageHistoryServiceWSDDServiceName());
        return localEidImageHistoryServiceSoapBindingStub;
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
    if ("EidImageHistoryService".equals(str)) {
      return getEidImageHistoryService();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://localhost:8080/EBILL_HAIER/services/EidImageHistoryService", "EvsAppraiseHistorisesDSService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://localhost:8080/EBILL_HAIER/services/EidImageHistoryService", "EidImageHistoryService"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("EidImageHistoryService".equals(paramString1)) {
      setEidImageHistoryServiceEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.web.service.appraiseImageSrv.EvsAppraiseHistorisesDSServiceLocator
 * JD-Core Version:    0.7.0.1
 */