package com.zte.eas.appframe.sync.runtime;

import com.zte.eas.appframe.sync.ALLBPELSYNC_PortType;
import com.zte.eas.appframe.sync.ALLBPELSYNC_Service;
import java.rmi.Remote;
import javax.xml.namespace.QName;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerRegistry;
import oracle.j2ee.ws.client.BasicService;
import oracle.j2ee.ws.client.HandlerChainImpl;
import oracle.j2ee.ws.client.ServiceExceptionImpl;
import oracle.j2ee.ws.common.util.exception.LocalizableExceptionAdapter;

public class ALLBPELSYNC_Service_Impl
  extends BasicService
  implements ALLBPELSYNC_Service
{
  private static final QName serviceName = new QName("http://eas.zte.com.cn/all/ALLBPELSYNC", "ALLBPELSYNC");
  private static final QName ns1_ALLBPELSYNCPort_QNAME = new QName("http://eas.zte.com.cn/all/ALLBPELSYNC", "ALLBPELSYNCPort");
  private static final Class ALLBPELSYNC_PortType_PortClass = ALLBPELSYNC_PortType.class;
  
  public ALLBPELSYNC_Service_Impl()
  {
    super(serviceName, new QName[] { ns1_ALLBPELSYNCPort_QNAME }, new ALLBPELSYNC_Service_SerializerRegistry().getRegistry());
  }
  
  public Remote getPort(QName paramQName, Class paramClass)
    throws ServiceException
  {
    try
    {
      if ((paramQName.equals(ns1_ALLBPELSYNCPort_QNAME)) && (paramClass.equals(ALLBPELSYNC_PortType_PortClass))) {
        return getALLBPELSYNCPort();
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
      if (paramClass.equals(ALLBPELSYNC_PortType_PortClass)) {
        return getALLBPELSYNCPort();
      }
    }
    catch (Exception localException)
    {
      throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(localException));
    }
    return super.getPort(paramClass);
  }
  
  public ALLBPELSYNC_PortType getALLBPELSYNCPort()
  {
    String[] arrayOfString = new String[0];
    HandlerChainImpl localHandlerChainImpl = new HandlerChainImpl(getHandlerRegistry().getHandlerChain(ns1_ALLBPELSYNCPort_QNAME));
    localHandlerChainImpl.setRoles(arrayOfString);
    ALLBPELSYNCBinding_Stub localALLBPELSYNCBinding_Stub = new ALLBPELSYNCBinding_Stub(localHandlerChainImpl);
    try
    {
      localALLBPELSYNCBinding_Stub._initialize(this.internalTypeRegistry);
    }
    catch (JAXRPCException localJAXRPCException)
    {
      throw localJAXRPCException;
    }
    catch (Exception localException)
    {
      throw new JAXRPCException(localException.getMessage(), localException);
    }
    return localALLBPELSYNCBinding_Stub;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.sync.runtime.ALLBPELSYNC_Service_Impl
 * JD-Core Version:    0.7.0.1
 */