package com.zte.eas.appframe.importmis.ap.runtime;

import com.zte.eas.appframe.importmis.ap.AP_ImportApInvoiceSrv_PortType;
import com.zte.eas.appframe.importmis.ap.AP_ImportApInvoiceSrv_Service;
import java.rmi.Remote;
import javax.xml.namespace.QName;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerRegistry;
import oracle.j2ee.ws.client.BasicService;
import oracle.j2ee.ws.client.HandlerChainImpl;
import oracle.j2ee.ws.client.ServiceExceptionImpl;
import oracle.j2ee.ws.common.util.exception.LocalizableExceptionAdapter;

public class AP_ImportApInvoiceSrv_Service_Impl
  extends BasicService
  implements AP_ImportApInvoiceSrv_Service
{
  private static final QName serviceName = new QName("http://eas.zte.com.cn/all/AP_ImportApInvoiceSrv", "AP_ImportApInvoiceSrv");
  private static final QName ns1_AP_ImportApInvoiceSrvPort_QNAME = new QName("http://eas.zte.com.cn/all/AP_ImportApInvoiceSrv", "AP_ImportApInvoiceSrvPort");
  private static final Class AP_ImportApInvoiceSrv_PortType_PortClass = AP_ImportApInvoiceSrv_PortType.class;
  
  public AP_ImportApInvoiceSrv_Service_Impl()
  {
    super(serviceName, new QName[] { ns1_AP_ImportApInvoiceSrvPort_QNAME }, new AP_ImportApInvoiceSrv_Service_SerializerRegistry().getRegistry());
  }
  
  public Remote getPort(QName paramQName, Class paramClass)
    throws ServiceException
  {
    try
    {
      if ((paramQName.equals(ns1_AP_ImportApInvoiceSrvPort_QNAME)) && (paramClass.equals(AP_ImportApInvoiceSrv_PortType_PortClass))) {
        return getAP_ImportApInvoiceSrvPort();
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
      if (paramClass.equals(AP_ImportApInvoiceSrv_PortType_PortClass)) {
        return getAP_ImportApInvoiceSrvPort();
      }
    }
    catch (Exception localException)
    {
      throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(localException));
    }
    return super.getPort(paramClass);
  }
  
  public AP_ImportApInvoiceSrv_PortType getAP_ImportApInvoiceSrvPort()
  {
    String[] arrayOfString = new String[0];
    HandlerChainImpl localHandlerChainImpl = new HandlerChainImpl(getHandlerRegistry().getHandlerChain(ns1_AP_ImportApInvoiceSrvPort_QNAME));
    localHandlerChainImpl.setRoles(arrayOfString);
    AP_ImportApInvoiceSrvBinding_Stub localAP_ImportApInvoiceSrvBinding_Stub = new AP_ImportApInvoiceSrvBinding_Stub(localHandlerChainImpl);
    try
    {
      localAP_ImportApInvoiceSrvBinding_Stub._initialize(this.internalTypeRegistry);
    }
    catch (JAXRPCException localJAXRPCException)
    {
      throw localJAXRPCException;
    }
    catch (Exception localException)
    {
      throw new JAXRPCException(localException.getMessage(), localException);
    }
    return localAP_ImportApInvoiceSrvBinding_Stub;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.ap.runtime.AP_ImportApInvoiceSrv_Service_Impl
 * JD-Core Version:    0.7.0.1
 */