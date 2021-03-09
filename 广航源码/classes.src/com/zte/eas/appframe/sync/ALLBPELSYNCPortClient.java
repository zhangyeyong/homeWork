package com.zte.eas.appframe.sync;

import java.io.PrintStream;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import oracle.webservices.OracleStub;
import oracle.webservices.transport.ClientTransport;

public class ALLBPELSYNCPortClient
{
  private ALLBPELSYNC_PortType _port;
  
  public ALLBPELSYNCPortClient()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this._port = ((ALLBPELSYNC_Service)localServiceFactory.loadService(ALLBPELSYNC_Service.class)).getALLBPELSYNCPort();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      ALLBPELSYNCPortClient localALLBPELSYNCPortClient = new ALLBPELSYNCPortClient();
      System.out.println("calling " + localALLBPELSYNCPortClient.getEndpoint());
      ALLBPELSYNCProcessRequest localALLBPELSYNCProcessRequest = new ALLBPELSYNCProcessRequest();
      localALLBPELSYNCProcessRequest.setSyncType("MIS");
      localALLBPELSYNCPortClient.process(localALLBPELSYNCProcessRequest);
      System.out.println("calling end ");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public ALLBPELSYNCProcessResponse process(ALLBPELSYNCProcessRequest paramALLBPELSYNCProcessRequest)
    throws RemoteException
  {
    return this._port.process(paramALLBPELSYNCProcessRequest);
  }
  
  public ALLBPELSYNC_PortType getPort()
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
 * Qualified Name:     com.zte.eas.appframe.sync.ALLBPELSYNCPortClient
 * JD-Core Version:    0.7.0.1
 */