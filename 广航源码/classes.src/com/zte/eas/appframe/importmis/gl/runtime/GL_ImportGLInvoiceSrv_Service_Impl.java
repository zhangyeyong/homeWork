package com.zte.eas.appframe.importmis.gl.runtime;

import com.zte.eas.appframe.importmis.gl.GL_ImportGLInvoiceSrv_PortType;
import com.zte.eas.appframe.importmis.gl.GL_ImportGLInvoiceSrv_Service;
import java.rmi.Remote;
import javax.xml.namespace.QName;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.handler.HandlerRegistry;
import oracle.j2ee.ws.client.BasicService;
import oracle.j2ee.ws.client.HandlerChainImpl;
import oracle.j2ee.ws.client.ServiceExceptionImpl;
import oracle.j2ee.ws.common.util.exception.LocalizableExceptionAdapter;

public class GL_ImportGLInvoiceSrv_Service_Impl
  extends BasicService
  implements GL_ImportGLInvoiceSrv_Service
{
  private static final QName serviceName = new QName("http://eas.zte.com.cn/all/GL_ImportGLInvoiceSrv", "GL_ImportGLInvoiceSrv");
  private static final QName ns1_GL_ImportGLInvoiceSrvPort_QNAME = new QName("http://eas.zte.com.cn/all/GL_ImportGLInvoiceSrv", "GL_ImportGLInvoiceSrvPort");
  private static final Class GL_ImportGLInvoiceSrv_PortType_PortClass = GL_ImportGLInvoiceSrv_PortType.class;
  
  public GL_ImportGLInvoiceSrv_Service_Impl()
  {
    super(serviceName, new QName[] { ns1_GL_ImportGLInvoiceSrvPort_QNAME }, new GL_ImportGLInvoiceSrv_Service_SerializerRegistry().getRegistry());
  }
  
  public Remote getPort(QName paramQName, Class paramClass)
    throws ServiceException
  {
    try
    {
      if ((paramQName.equals(ns1_GL_ImportGLInvoiceSrvPort_QNAME)) && (paramClass.equals(GL_ImportGLInvoiceSrv_PortType_PortClass))) {
        return getGL_ImportGLInvoiceSrvPort();
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
      if (paramClass.equals(GL_ImportGLInvoiceSrv_PortType_PortClass)) {
        return getGL_ImportGLInvoiceSrvPort();
      }
    }
    catch (Exception localException)
    {
      throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(localException));
    }
    return super.getPort(paramClass);
  }
  
  public GL_ImportGLInvoiceSrv_PortType getGL_ImportGLInvoiceSrvPort()
  {
    String[] arrayOfString = new String[0];
    HandlerChainImpl localHandlerChainImpl = new HandlerChainImpl(getHandlerRegistry().getHandlerChain(ns1_GL_ImportGLInvoiceSrvPort_QNAME));
    localHandlerChainImpl.setRoles(arrayOfString);
    GL_ImportGLInvoiceSrvBinding_Stub localGL_ImportGLInvoiceSrvBinding_Stub = new GL_ImportGLInvoiceSrvBinding_Stub(localHandlerChainImpl);
    try
    {
      localGL_ImportGLInvoiceSrvBinding_Stub._initialize(this.internalTypeRegistry);
    }
    catch (JAXRPCException localJAXRPCException)
    {
      throw localJAXRPCException;
    }
    catch (Exception localException)
    {
      throw new JAXRPCException(localException.getMessage(), localException);
    }
    return localGL_ImportGLInvoiceSrvBinding_Stub;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.gl.runtime.GL_ImportGLInvoiceSrv_Service_Impl
 * JD-Core Version:    0.7.0.1
 */