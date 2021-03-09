package com.zte.eas.appframe.importmis.arv.runtime;

import com.zte.eas.appframe.importmis.arv.FI_AR_ImportARTransactionSrv_PortType;
import com.zte.eas.appframe.importmis.arv.FI_AR_ImportARTransactionSrv_Service;
import java.rmi.Remote;
import javax.xml.namespace.QName;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerRegistry;
import oracle.j2ee.ws.client.BasicService;
import oracle.j2ee.ws.client.HandlerChainImpl;
import oracle.j2ee.ws.client.ServiceExceptionImpl;
import oracle.j2ee.ws.common.util.exception.LocalizableExceptionAdapter;

public class FI_AR_ImportARTransactionSrv_Service_Impl
  extends BasicService
  implements FI_AR_ImportARTransactionSrv_Service
{
  private static final QName serviceName = new QName("http://xmlns.oracle.com/FI_AR_ImportARTransactionSrv", "FI_AR_ImportARTransactionSrv");
  private static final QName ns1_FI_AR_ImportARTransactionSrvPort_QNAME = new QName("http://xmlns.oracle.com/FI_AR_ImportARTransactionSrv", "FI_AR_ImportARTransactionSrvPort");
  private static final Class FI_AR_ImportARTransactionSrv_PortType_PortClass = FI_AR_ImportARTransactionSrv_PortType.class;
  
  public FI_AR_ImportARTransactionSrv_Service_Impl()
  {
    super(serviceName, new QName[] { ns1_FI_AR_ImportARTransactionSrvPort_QNAME }, new FI_AR_ImportARTransactionSrv_Service_SerializerRegistry().getRegistry());
  }
  
  public Remote getPort(QName paramQName, Class paramClass)
    throws ServiceException
  {
    try
    {
      if ((paramQName.equals(ns1_FI_AR_ImportARTransactionSrvPort_QNAME)) && (paramClass.equals(FI_AR_ImportARTransactionSrv_PortType_PortClass))) {
        return getFI_AR_ImportARTransactionSrvPort();
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
      if (paramClass.equals(FI_AR_ImportARTransactionSrv_PortType_PortClass)) {
        return getFI_AR_ImportARTransactionSrvPort();
      }
    }
    catch (Exception localException)
    {
      throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(localException));
    }
    return super.getPort(paramClass);
  }
  
  public FI_AR_ImportARTransactionSrv_PortType getFI_AR_ImportARTransactionSrvPort()
  {
    String[] arrayOfString = new String[0];
    HandlerChainImpl localHandlerChainImpl = new HandlerChainImpl(getHandlerRegistry().getHandlerChain(ns1_FI_AR_ImportARTransactionSrvPort_QNAME));
    localHandlerChainImpl.setRoles(arrayOfString);
    FI_AR_ImportARTransactionSrvBinding_Stub localFI_AR_ImportARTransactionSrvBinding_Stub = new FI_AR_ImportARTransactionSrvBinding_Stub(localHandlerChainImpl);
    try
    {
      localFI_AR_ImportARTransactionSrvBinding_Stub._initialize(this.internalTypeRegistry);
    }
    catch (JAXRPCException localJAXRPCException)
    {
      throw localJAXRPCException;
    }
    catch (Exception localException)
    {
      throw new JAXRPCException(localException.getMessage(), localException);
    }
    return localFI_AR_ImportARTransactionSrvBinding_Stub;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arv.runtime.FI_AR_ImportARTransactionSrv_Service_Impl
 * JD-Core Version:    0.7.0.1
 */