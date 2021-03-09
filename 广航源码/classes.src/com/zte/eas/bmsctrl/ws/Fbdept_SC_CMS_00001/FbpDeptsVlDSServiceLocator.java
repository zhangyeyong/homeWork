package com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001;

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

public class FbpDeptsVlDSServiceLocator
  extends Service
  implements FbpDeptsVlDSService
{
  private String findDept_address = AccessPropertiesFile.getValue("dept_in");
  private String findDeptWSDDServiceName = "findDept";
  private HashSet ports = null;
  
  public FbpDeptsVlDSServiceLocator() {}
  
  public FbpDeptsVlDSServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public FbpDeptsVlDSServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getfindDeptAddress()
  {
    return this.findDept_address;
  }
  
  public String getfindDeptWSDDServiceName()
  {
    return this.findDeptWSDDServiceName;
  }
  
  public void setfindDeptWSDDServiceName(String paramString)
  {
    this.findDeptWSDDServiceName = paramString;
  }
  
  public FbpDeptsVlDS getfindDept()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.findDept_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getfindDept(localURL);
  }
  
  public FbpDeptsVlDS getfindDept(URL paramURL)
    throws ServiceException
  {
    try
    {
      FindDeptSoapBindingStub localFindDeptSoapBindingStub = new FindDeptSoapBindingStub(paramURL, this);
      localFindDeptSoapBindingStub.setPortName(getfindDeptWSDDServiceName());
      return localFindDeptSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setfindDeptEndpointAddress(String paramString)
  {
    this.findDept_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (FbpDeptsVlDS.class.isAssignableFrom(paramClass))
      {
        FindDeptSoapBindingStub localFindDeptSoapBindingStub = new FindDeptSoapBindingStub(new URL(this.findDept_address), this);
        localFindDeptSoapBindingStub.setPortName(getfindDeptWSDDServiceName());
        return localFindDeptSoapBindingStub;
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
    if ("findDept".equals(str)) {
      return getfindDept();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://localhost:8080/JSYDEAS/services/findDept", "FbpDeptsVlDSService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://localhost:8080/JSYDEAS/services/findDept", "findDept"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("findDept".equals(paramString1)) {
      setfindDeptEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001.FbpDeptsVlDSServiceLocator
 * JD-Core Version:    0.7.0.1
 */