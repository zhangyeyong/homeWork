package com.zte.eas.appframe.importmis.vendorimport.runtime;

import com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrv_PortType;
import com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrv_Service;
import java.rmi.Remote;
import javax.xml.namespace.QName;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerRegistry;
import oracle.j2ee.ws.client.BasicService;
import oracle.j2ee.ws.client.HandlerChainImpl;
import oracle.j2ee.ws.client.ServiceExceptionImpl;
import oracle.j2ee.ws.common.util.exception.LocalizableExceptionAdapter;

public class SC_PO_ImportVendorInfoSrv_Service_Impl
  extends BasicService
  implements SC_PO_ImportVendorInfoSrv_Service
{
  private static final QName serviceName = new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "SC_PO_ImportVendorInfoSrv");
  private static final QName ns1_SC_PO_ImportVendorInfoSrvPort_QNAME = new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "SC_PO_ImportVendorInfoSrvPort");
  private static final Class SC_PO_ImportVendorInfoSrv_PortType_PortClass = SC_PO_ImportVendorInfoSrv_PortType.class;
  
  public SC_PO_ImportVendorInfoSrv_Service_Impl()
  {
    super(serviceName, new QName[] { ns1_SC_PO_ImportVendorInfoSrvPort_QNAME }, new SC_PO_ImportVendorInfoSrv_Service_SerializerRegistry().getRegistry());
  }
  
  public Remote getPort(QName paramQName, Class paramClass)
    throws ServiceException
  {
    try
    {
      if ((paramQName.equals(ns1_SC_PO_ImportVendorInfoSrvPort_QNAME)) && (paramClass.equals(SC_PO_ImportVendorInfoSrv_PortType_PortClass))) {
        return getSC_PO_ImportVendorInfoSrvPort();
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
      if (paramClass.equals(SC_PO_ImportVendorInfoSrv_PortType_PortClass)) {
        return getSC_PO_ImportVendorInfoSrvPort();
      }
    }
    catch (Exception localException)
    {
      throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(localException));
    }
    return super.getPort(paramClass);
  }
  
  public SC_PO_ImportVendorInfoSrv_PortType getSC_PO_ImportVendorInfoSrvPort()
  {
    String[] arrayOfString = new String[0];
    HandlerChainImpl localHandlerChainImpl = new HandlerChainImpl(getHandlerRegistry().getHandlerChain(ns1_SC_PO_ImportVendorInfoSrvPort_QNAME));
    localHandlerChainImpl.setRoles(arrayOfString);
    SC_PO_ImportVendorInfoSrvBinding_Stub localSC_PO_ImportVendorInfoSrvBinding_Stub = new SC_PO_ImportVendorInfoSrvBinding_Stub(localHandlerChainImpl);
    try
    {
      localSC_PO_ImportVendorInfoSrvBinding_Stub._initialize(this.internalTypeRegistry);
    }
    catch (JAXRPCException localJAXRPCException)
    {
      throw localJAXRPCException;
    }
    catch (Exception localException)
    {
      throw new JAXRPCException(localException.getMessage(), localException);
    }
    return localSC_PO_ImportVendorInfoSrvBinding_Stub;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.vendorimport.runtime.SC_PO_ImportVendorInfoSrv_Service_Impl
 * JD-Core Version:    0.7.0.1
 */