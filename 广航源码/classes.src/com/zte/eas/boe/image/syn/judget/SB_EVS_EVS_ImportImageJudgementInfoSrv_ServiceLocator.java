package com.zte.eas.boe.image.syn.judget;

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

public class SB_EVS_EVS_ImportImageJudgementInfoSrv_ServiceLocator
  extends Service
  implements SB_EVS_EVS_ImportImageJudgementInfoSrv_Service
{
  private String SB_EVS_EVS_ImportImageJudgementInfoSrvPort_address = "http://localhost:8080/JS_YD/services";
  private String SB_EVS_EVS_ImportImageJudgementInfoSrvPortWSDDServiceName = "SB_EVS_EVS_ImportImageJudgementInfoSrvPort";
  private HashSet ports = null;
  
  public SB_EVS_EVS_ImportImageJudgementInfoSrv_ServiceLocator() {}
  
  public SB_EVS_EVS_ImportImageJudgementInfoSrv_ServiceLocator(EngineConfiguration paramEngineConfiguration)
  {
    super(paramEngineConfiguration);
  }
  
  public SB_EVS_EVS_ImportImageJudgementInfoSrv_ServiceLocator(String paramString, QName paramQName)
    throws ServiceException
  {
    super(paramString, paramQName);
  }
  
  public String getSB_EVS_EVS_ImportImageJudgementInfoSrvPortAddress()
  {
    return this.SB_EVS_EVS_ImportImageJudgementInfoSrvPort_address;
  }
  
  public String getSB_EVS_EVS_ImportImageJudgementInfoSrvPortWSDDServiceName()
  {
    return this.SB_EVS_EVS_ImportImageJudgementInfoSrvPortWSDDServiceName;
  }
  
  public void setSB_EVS_EVS_ImportImageJudgementInfoSrvPortWSDDServiceName(String paramString)
  {
    this.SB_EVS_EVS_ImportImageJudgementInfoSrvPortWSDDServiceName = paramString;
  }
  
  public SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType getSB_EVS_EVS_ImportImageJudgementInfoSrvPort()
    throws ServiceException
  {
    URL localURL;
    try
    {
      localURL = new URL(this.SB_EVS_EVS_ImportImageJudgementInfoSrvPort_address);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServiceException(localMalformedURLException);
    }
    return getSB_EVS_EVS_ImportImageJudgementInfoSrvPort(localURL);
  }
  
  public SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType getSB_EVS_EVS_ImportImageJudgementInfoSrvPort(URL paramURL)
    throws ServiceException
  {
    try
    {
      SB_EVS_EVS_ImportImageJudgementInfoSrvBindingStub localSB_EVS_EVS_ImportImageJudgementInfoSrvBindingStub = new SB_EVS_EVS_ImportImageJudgementInfoSrvBindingStub(paramURL, this);
      localSB_EVS_EVS_ImportImageJudgementInfoSrvBindingStub.setPortName(getSB_EVS_EVS_ImportImageJudgementInfoSrvPortWSDDServiceName());
      return localSB_EVS_EVS_ImportImageJudgementInfoSrvBindingStub;
    }
    catch (AxisFault localAxisFault) {}
    return null;
  }
  
  public void setSB_EVS_EVS_ImportImageJudgementInfoSrvPortEndpointAddress(String paramString)
  {
    this.SB_EVS_EVS_ImportImageJudgementInfoSrvPort_address = paramString;
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType.class.isAssignableFrom(paramClass))
      {
        SB_EVS_EVS_ImportImageJudgementInfoSrvBindingStub localSB_EVS_EVS_ImportImageJudgementInfoSrvBindingStub = new SB_EVS_EVS_ImportImageJudgementInfoSrvBindingStub(new URL(this.SB_EVS_EVS_ImportImageJudgementInfoSrvPort_address), this);
        localSB_EVS_EVS_ImportImageJudgementInfoSrvBindingStub.setPortName(getSB_EVS_EVS_ImportImageJudgementInfoSrvPortWSDDServiceName());
        return localSB_EVS_EVS_ImportImageJudgementInfoSrvBindingStub;
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
    if ("SB_EVS_EVS_ImportImageJudgementInfoSrvPort".equals(str)) {
      return getSB_EVS_EVS_ImportImageJudgementInfoSrvPort();
    }
    Remote localRemote = getPort(paramClass);
    ((Stub)localRemote).setPortName(paramQName);
    return localRemote;
  }
  
  public QName getServiceName()
  {
    return new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "SB_EVS_EVS_ImportImageJudgementInfoSrv");
  }
  
  public Iterator getPorts()
  {
    if (this.ports == null)
    {
      this.ports = new HashSet();
      this.ports.add(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "SB_EVS_EVS_ImportImageJudgementInfoSrvPort"));
    }
    return this.ports.iterator();
  }
  
  public void setEndpointAddress(String paramString1, String paramString2)
    throws ServiceException
  {
    if ("SB_EVS_EVS_ImportImageJudgementInfoSrvPort".equals(paramString1)) {
      setSB_EVS_EVS_ImportImageJudgementInfoSrvPortEndpointAddress(paramString2);
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
 * Qualified Name:     com.zte.eas.boe.image.syn.judget.SB_EVS_EVS_ImportImageJudgementInfoSrv_ServiceLocator
 * JD-Core Version:    0.7.0.1
 */