package com.zte.web.service.esp;

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

public class QueryPortalCommonService_ServiceLocator
  extends Service
  implements QueryPortalCommonService_Service
{
  private String QueryPortalCommonServiceSOAP_address;
  private String QueryPortalCommonServiceSOAPWSDDServiceName;
  private HashSet ports;
  
  public QueryPortalCommonService_ServiceLocator()
  {
    new AccessPropertiesFile();
    this.QueryPortalCommonServiceSOAP_address = AccessPropertiesFile.getValue("QueryPortalCommonServiceSOAP_address");
    this.QueryPortalCommonServiceSOAPWSDDServiceName = "QueryPortalCommonServiceSOAP";
    this.ports = null;
  }
  
  public QueryPortalCommonService_ServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
    new AccessPropertiesFile();
    this.QueryPortalCommonServiceSOAP_address = AccessPropertiesFile.getValue("QueryPortalCommonServiceSOAP_address");
    this.QueryPortalCommonServiceSOAPWSDDServiceName = "QueryPortalCommonServiceSOAP";
    this.ports = null;
  }
  
  public QueryPortalCommonService_ServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
    new AccessPropertiesFile();
    this.QueryPortalCommonServiceSOAP_address = AccessPropertiesFile.getValue("QueryPortalCommonServiceSOAP_address");
    this.QueryPortalCommonServiceSOAPWSDDServiceName = "QueryPortalCommonServiceSOAP";
    this.ports = null;
  }
  
  public String getQueryPortalCommonServiceSOAPAddress()
  {
    return this.QueryPortalCommonServiceSOAP_address;
  }
  
  public String getQueryPortalCommonServiceSOAPWSDDServiceName()
  {
    return this.QueryPortalCommonServiceSOAPWSDDServiceName;
  }
  
  public void setQueryPortalCommonServiceSOAPWSDDServiceName(String paramString)
  {
    this.QueryPortalCommonServiceSOAPWSDDServiceName = paramString;
  }
  
  public QueryPortalCommonService_PortType getQueryPortalCommonServiceSOAP()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.QueryPortalCommonServiceSOAP_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getQueryPortalCommonServiceSOAP(localURL);
  }
  
  public QueryPortalCommonService_PortType getQueryPortalCommonServiceSOAP(URL paramURL)
    throws ServiceException
  {
    try
    {
      QueryPortalCommonServiceSOAPStub localQueryPortalCommonServiceSOAPStub = new QueryPortalCommonServiceSOAPStub(paramURL, this);
      localQueryPortalCommonServiceSOAPStub.setPortName(getQueryPortalCommonServiceSOAPWSDDServiceName());
      return localQueryPortalCommonServiceSOAPStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setQueryPortalCommonServiceSOAPEndpointAddress(String paramString)
  {
    this.QueryPortalCommonServiceSOAP_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (QueryPortalCommonService_PortType.class.isAssignableFrom(paramClass))
      {
        QueryPortalCommonServiceSOAPStub localQueryPortalCommonServiceSOAPStub = new QueryPortalCommonServiceSOAPStub(new URL(this.QueryPortalCommonServiceSOAP_address), this);
        localQueryPortalCommonServiceSOAPStub.setPortName(getQueryPortalCommonServiceSOAPWSDDServiceName());
        return localQueryPortalCommonServiceSOAPStub;
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
    if ("QueryPortalCommonServiceSOAP".equals(str)) {
      return getQueryPortalCommonServiceSOAP();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://eai.haier.com/QueryPortalCommonService/", "QueryPortalCommonService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://eai.haier.com/QueryPortalCommonService/", "QueryPortalCommonServiceSOAP"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("QueryPortalCommonServiceSOAP".equals(paramString1)) {
      setQueryPortalCommonServiceSOAPEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.web.service.esp.QueryPortalCommonService_ServiceLocator
 * JD-Core Version:    0.7.0.1
 */