package com.zte.eas.appframe.importmis.vendorimport;

import java.io.PrintStream;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import oracle.webservices.OracleStub;
import oracle.webservices.transport.ClientTransport;

public class SC_PO_ImportVendorInfoSrvPortClient
{
  private SC_PO_ImportVendorInfoSrv_PortType _port;
  
  public SC_PO_ImportVendorInfoSrvPortClient()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this._port = ((SC_PO_ImportVendorInfoSrv_Service)localServiceFactory.loadService(SC_PO_ImportVendorInfoSrv_Service.class)).getSC_PO_ImportVendorInfoSrvPort();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      SC_PO_ImportVendorInfoSrvPortClient localSC_PO_ImportVendorInfoSrvPortClient = new SC_PO_ImportVendorInfoSrvPortClient();
      System.out.println("calling " + localSC_PO_ImportVendorInfoSrvPortClient.getEndpoint());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public SC_PO_ImportVendorInfoSrvProcessResponse process(SC_PO_ImportVendorInfoSrvProcessRequest paramSC_PO_ImportVendorInfoSrvProcessRequest)
    throws RemoteException
  {
    return this._port.process(paramSC_PO_ImportVendorInfoSrvProcessRequest);
  }
  
  public SC_PO_ImportVendorInfoSrv_PortType getPort()
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
 * Qualified Name:     com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrvPortClient
 * JD-Core Version:    0.7.0.1
 */