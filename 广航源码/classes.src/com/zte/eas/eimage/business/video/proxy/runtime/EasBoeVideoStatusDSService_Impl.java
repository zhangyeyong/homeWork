package com.zte.eas.eimage.business.video.proxy.runtime;

import com.zte.eas.eimage.business.video.proxy.EasBoeVideoStatusDS;
import com.zte.eas.eimage.business.video.proxy.EasBoeVideoStatusDSService;
import java.rmi.Remote;
import javax.xml.namespace.QName;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerRegistry;
import oracle.j2ee.ws.client.BasicService;
import oracle.j2ee.ws.client.HandlerChainImpl;
import oracle.j2ee.ws.client.ServiceExceptionImpl;
import oracle.j2ee.ws.common.util.exception.LocalizableExceptionAdapter;

public class EasBoeVideoStatusDSService_Impl
  extends BasicService
  implements EasBoeVideoStatusDSService
{
  private static final QName serviceName = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "EasBoeVideoStatusDSService");
  private static final QName ns1_VideoStatusService_QNAME = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "VideoStatusService");
  private static final Class easBoeVideoStatusDS_PortClass = EasBoeVideoStatusDS.class;
  
  public EasBoeVideoStatusDSService_Impl()
  {
    super(serviceName, new QName[] { ns1_VideoStatusService_QNAME }, new EasBoeVideoStatusDSService_SerializerRegistry().getRegistry());
  }
  
  public Remote getPort(QName paramQName, Class paramClass)
    throws ServiceException
  {
    try
    {
      if ((paramQName.equals(ns1_VideoStatusService_QNAME)) && (paramClass.equals(easBoeVideoStatusDS_PortClass))) {
        return getVideoStatusService();
      }
    }
    catch (Exception localException)
    {
      throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(localException));
    }
    return super.getPort(paramQName, paramClass);
  }
  
  public Remote getPort(Class paramClass)
    throws ServiceException
  {
    try
    {
      if (paramClass.equals(easBoeVideoStatusDS_PortClass)) {
        return getVideoStatusService();
      }
    }
    catch (Exception localException)
    {
      throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(localException));
    }
    return super.getPort(paramClass);
  }
  
  public EasBoeVideoStatusDS getVideoStatusService()
  {
    String[] arrayOfString = new String[0];
    HandlerChainImpl localHandlerChainImpl = new HandlerChainImpl(getHandlerRegistry().getHandlerChain(ns1_VideoStatusService_QNAME));
    localHandlerChainImpl.setRoles(arrayOfString);
    VideoStatusServiceSoapBinding_Stub localVideoStatusServiceSoapBinding_Stub = new VideoStatusServiceSoapBinding_Stub(localHandlerChainImpl);
    try
    {
      localVideoStatusServiceSoapBinding_Stub._initialize(this.internalTypeRegistry);
    }
    catch (JAXRPCException localJAXRPCException)
    {
      throw localJAXRPCException;
    }
    catch (Exception localException)
    {
      throw new JAXRPCException(localException.getMessage(), localException);
    }
    return localVideoStatusServiceSoapBinding_Stub;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.runtime.EasBoeVideoStatusDSService_Impl
 * JD-Core Version:    0.7.0.1
 */