package com.zte.eas.appframe.importmis.ap;

import java.io.PrintStream;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import oracle.webservices.OracleStub;
import oracle.webservices.transport.ClientTransport;

public class AP_ImportApInvoiceSrvPortClient
{
  private AP_ImportApInvoiceSrv_PortType _port;
  
  public AP_ImportApInvoiceSrvPortClient()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this._port = ((AP_ImportApInvoiceSrv_Service)localServiceFactory.loadService(AP_ImportApInvoiceSrv_Service.class)).getAP_ImportApInvoiceSrvPort();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      AP_ImportApInvoiceSrvPortClient localAP_ImportApInvoiceSrvPortClient = new AP_ImportApInvoiceSrvPortClient();
      System.out.println("calling " + localAP_ImportApInvoiceSrvPortClient.getEndpoint());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public AP_ImportApInvoiceSrvProcessResponse process(AP_ImportApInvoiceSrvProcessRequest paramAP_ImportApInvoiceSrvProcessRequest)
    throws RemoteException
  {
    return this._port.process(paramAP_ImportApInvoiceSrvProcessRequest);
  }
  
  public AP_ImportApInvoiceSrv_PortType getPort()
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
 * Qualified Name:     com.zte.eas.appframe.importmis.ap.AP_ImportApInvoiceSrvPortClient
 * JD-Core Version:    0.7.0.1
 */