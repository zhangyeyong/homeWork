package com.zte.eas.appframe.importmis.gl;

import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.Calendar;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import oracle.webservices.OracleStub;
import oracle.webservices.transport.ClientTransport;

public class GL_ImportGLInvoiceSrvPortClient
{
  private GL_ImportGLInvoiceSrv_PortType _port;
  
  public GL_ImportGLInvoiceSrvPortClient()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this._port = ((GL_ImportGLInvoiceSrv_Service)localServiceFactory.loadService(GL_ImportGLInvoiceSrv_Service.class)).getGL_ImportGLInvoiceSrvPort();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      GL_ImportGLInvoiceSrvPortClient localGL_ImportGLInvoiceSrvPortClient = new GL_ImportGLInvoiceSrvPortClient();
      System.out.println("calling " + localGL_ImportGLInvoiceSrvPortClient.getEndpoint());
      GL_ImportGLInvoiceSrvProcessRequest localGL_ImportGLInvoiceSrvProcessRequest = new GL_ImportGLInvoiceSrvProcessRequest();
      localGL_ImportGLInvoiceSrvProcessRequest.setInvoiceId("10026");
      localGL_ImportGLInvoiceSrvProcessRequest.setInvoicedate(Calendar.getInstance());
      localGL_ImportGLInvoiceSrvPortClient.process(localGL_ImportGLInvoiceSrvProcessRequest);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public GL_ImportGLInvoiceSrvProcessResponse process(GL_ImportGLInvoiceSrvProcessRequest paramGL_ImportGLInvoiceSrvProcessRequest)
    throws RemoteException
  {
    return this._port.process(paramGL_ImportGLInvoiceSrvProcessRequest);
  }
  
  public GL_ImportGLInvoiceSrv_PortType getPort()
  {
    return this._port;
  }
  
  public String getEndpoint()
  {
    return (String)((Stub)this._port)._getProperty("javax.xml.rpc.service.endpoint.address");
  }
  
  public void setEndpoint(String paramString)
  {
    ((Stub)this._port)._setProperty("javax.xml.rpc.service.endpoint.address", paramString);
  }
  
  public String getPassword()
  {
    return (String)((Stub)this._port)._getProperty("javax.xml.rpc.security.auth.password");
  }
  
  public void setPassword(String paramString)
  {
    ((Stub)this._port)._setProperty("javax.xml.rpc.security.auth.password", paramString);
  }
  
  public String getUsername()
  {
    return (String)((Stub)this._port)._getProperty("javax.xml.rpc.security.auth.username");
  }
  
  public void setUsername(String paramString)
  {
    ((Stub)this._port)._setProperty("javax.xml.rpc.security.auth.username", paramString);
  }
  
  public void setMaintainSession(boolean paramBoolean)
  {
    ((Stub)this._port)._setProperty("javax.xml.rpc.session.maintain", Boolean.valueOf(paramBoolean));
  }
  
  public boolean getMaintainSession()
  {
    return ((Boolean)((Stub)this._port)._getProperty("javax.xml.rpc.session.maintain")).booleanValue();
  }
  
  public ClientTransport getClientTransport()
  {
    return ((OracleStub)this._port).getClientTransport();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.gl.GL_ImportGLInvoiceSrvPortClient
 * JD-Core Version:    0.7.0.1
 */