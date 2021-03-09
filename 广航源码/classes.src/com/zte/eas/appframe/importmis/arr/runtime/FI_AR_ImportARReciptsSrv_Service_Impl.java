package com.zte.eas.appframe.importmis.arr.runtime;

import com.zte.eas.appframe.importmis.arr.FI_AR_ImportARReciptsSrv_PortType;
import com.zte.eas.appframe.importmis.arr.FI_AR_ImportARReciptsSrv_Service;
import java.rmi.Remote;
import javax.xml.namespace.QName;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerRegistry;
import oracle.j2ee.ws.client.BasicService;
import oracle.j2ee.ws.client.HandlerChainImpl;
import oracle.j2ee.ws.client.ServiceExceptionImpl;
import oracle.j2ee.ws.common.util.exception.LocalizableExceptionAdapter;

public class FI_AR_ImportARReciptsSrv_Service_Impl
  extends BasicService
  implements FI_AR_ImportARReciptsSrv_Service
{
  private static final QName serviceName = new QName("http://eas.zte.com/ArImport/FI_AR_ImportARReciptsSrv", "FI_AR_ImportARReciptsSrv");
  private static final QName ns1_FI_AR_ImportARReciptsSrvPort_QNAME = new QName("http://eas.zte.com/ArImport/FI_AR_ImportARReciptsSrv", "FI_AR_ImportARReciptsSrvPort");
  private static final Class FI_AR_ImportARReciptsSrv_PortType_PortClass = FI_AR_ImportARReciptsSrv_PortType.class;
  
  public FI_AR_ImportARReciptsSrv_Service_Impl()
  {
    super(serviceName, new QName[] { ns1_FI_AR_ImportARReciptsSrvPort_QNAME }, new FI_AR_ImportARReciptsSrv_Service_SerializerRegistry().getRegistry());
  }
  
  public Remote getPort(QName paramQName, Class paramClass)
    throws ServiceException
  {
    try
    {
      if ((paramQName.equals(ns1_FI_AR_ImportARReciptsSrvPort_QNAME)) && (paramClass.equals(FI_AR_ImportARReciptsSrv_PortType_PortClass))) {
        return getFI_AR_ImportARReciptsSrvPort();
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
      if (paramClass.equals(FI_AR_ImportARReciptsSrv_PortType_PortClass)) {
        return getFI_AR_ImportARReciptsSrvPort();
      }
    }
    catch (Exception localException)
    {
      throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(localException));
    }
    return super.getPort(paramClass);
  }
  
  public FI_AR_ImportARReciptsSrv_PortType getFI_AR_ImportARReciptsSrvPort()
  {
    String[] arrayOfString = new String[0];
    HandlerChainImpl localHandlerChainImpl = new HandlerChainImpl(getHandlerRegistry().getHandlerChain(ns1_FI_AR_ImportARReciptsSrvPort_QNAME));
    localHandlerChainImpl.setRoles(arrayOfString);
    FI_AR_ImportARReciptsSrvBinding_Stub localFI_AR_ImportARReciptsSrvBinding_Stub = new FI_AR_ImportARReciptsSrvBinding_Stub(localHandlerChainImpl);
    try
    {
      localFI_AR_ImportARReciptsSrvBinding_Stub._initialize(this.internalTypeRegistry);
    }
    catch (JAXRPCException localJAXRPCException)
    {
      throw localJAXRPCException;
    }
    catch (Exception localException)
    {
      throw new JAXRPCException(localException.getMessage(), localException);
    }
    return localFI_AR_ImportARReciptsSrvBinding_Stub;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arr.runtime.FI_AR_ImportARReciptsSrv_Service_Impl
 * JD-Core Version:    0.7.0.1
 */