package com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002;

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

public class CreateImageSrvServiceLocator
  extends Service
  implements CreateImageSrvService
{
  private String createImageSrv_address = AccessPropertiesFile.getValue("createImageSrv");
  private String createImageSrvWSDDServiceName = "createImageSrv";
  private HashSet ports = null;
  
  public CreateImageSrvServiceLocator() {}
  
  public CreateImageSrvServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public CreateImageSrvServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getcreateImageSrvAddress()
  {
    return this.createImageSrv_address;
  }
  
  public String getcreateImageSrvWSDDServiceName()
  {
    return this.createImageSrvWSDDServiceName;
  }
  
  public void setcreateImageSrvWSDDServiceName(String paramString)
  {
    this.createImageSrvWSDDServiceName = paramString;
  }
  
  public CreateImageSrv getcreateImageSrv()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.createImageSrv_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getcreateImageSrv(localURL);
  }
  
  public CreateImageSrv getcreateImageSrv(URL paramURL)
    throws ServiceException
  {
    try
    {
      CreateImageSrvSoapBindingStub localCreateImageSrvSoapBindingStub = new CreateImageSrvSoapBindingStub(paramURL, this);
      localCreateImageSrvSoapBindingStub.setPortName(getcreateImageSrvWSDDServiceName());
      return localCreateImageSrvSoapBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setcreateImageSrvEndpointAddress(String paramString)
  {
    this.createImageSrv_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (CreateImageSrv.class.isAssignableFrom(paramClass))
      {
        CreateImageSrvSoapBindingStub localCreateImageSrvSoapBindingStub = new CreateImageSrvSoapBindingStub(new URL(this.createImageSrv_address), this);
        localCreateImageSrvSoapBindingStub.setPortName(getcreateImageSrvWSDDServiceName());
        return localCreateImageSrvSoapBindingStub;
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
    if ("createImageSrv".equals(str)) {
      return getcreateImageSrv();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://127.0.0.1/evs_ydzd", "CreateImageSrvService");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://127.0.0.1/evs_ydzd", "createImageSrv"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("createImageSrv".equals(paramString1)) {
      setcreateImageSrvEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002.CreateImageSrvServiceLocator
 * JD-Core Version:    0.7.0.1
 */