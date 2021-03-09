package com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011;

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

public class FbpEmployeesVDSServiceLocator
  extends Service
  implements FbpEmployeesVDSService
{
  private String findemployee_address = AccessPropertiesFile.getValue("employee_in");
  private String findemployeeWSDDServiceName = "findemployee";
  private HashSet ports = null;
  
  public FbpEmployeesVDSServiceLocator() {}
  
  public FbpEmployeesVDSServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public FbpEmployeesVDSServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getfindemployeeAddress()
  {
    return this.findemployee_address;
  }
  
  public String getfindemployeeWSDDServiceName()
  {
    return this.findemployeeWSDDServiceName;
  }
  
  public void setfindemployeeWSDDServiceName(String paramString)
  {
    this.findemployeeWSDDServiceName = paramString;
  }
  
  public FbpEmployeesVDS getfindemployee()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.findemployee_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getfindemployee(localURL);
  }
  
  public FbpEmployeesVDS getfindemployee(URL paramURL)
    throws ServiceException
  {
    try
    {
      FindemployeeSoapBindingStub localFindemployeeSoapBindingStub = new FindemployeeSoapBindingStub(paramURL, this);
      localFindemployeeSoapBindingStub.setPortName(getfindemployeeWSDDServiceName());
      return localFindemployeeSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setfindemployeeEndpointAddress(String paramString)
  {
    this.findemployee_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (FbpEmployeesVDS.class.isAssignableFrom(paramClass))
      {
        FindemployeeSoapBindingStub localFindemployeeSoapBindingStub = new FindemployeeSoapBindingStub(new URL(this.findemployee_address), this);
        localFindemployeeSoapBindingStub.setPortName(getfindemployeeWSDDServiceName());
        return localFindemployeeSoapBindingStub;
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
    if ("findemployee".equals(str)) {
      return getfindemployee();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://localhost:8080/JSYDEAS/services/findemployee", "FbpEmployeesVDSService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://localhost:8080/JSYDEAS/services/findemployee", "findemployee"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("findemployee".equals(paramString1)) {
      setfindemployeeEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011.FbpEmployeesVDSServiceLocator
 * JD-Core Version:    0.7.0.1
 */