package com.zte.eas.appframe.importmis.arr;

import com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.FiArImportARReciptsSrvRequest;
import com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.FiArImportARReciptsSrvResponse;
import java.io.PrintStream;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import oracle.webservices.OracleStub;
import oracle.webservices.transport.ClientTransport;

public class FI_AR_ImportARReciptsSrvPortClient
{
  private FI_AR_ImportARReciptsSrv_PortType _port;
  
  public FI_AR_ImportARReciptsSrvPortClient()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this._port = ((FI_AR_ImportARReciptsSrv_Service)localServiceFactory.loadService(FI_AR_ImportARReciptsSrv_Service.class)).getFI_AR_ImportARReciptsSrvPort();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      FI_AR_ImportARReciptsSrvPortClient localFI_AR_ImportARReciptsSrvPortClient = new FI_AR_ImportARReciptsSrvPortClient();
      System.out.println("calling " + localFI_AR_ImportARReciptsSrvPortClient.getEndpoint());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public FiArImportARReciptsSrvResponse process(FiArImportARReciptsSrvRequest paramFiArImportARReciptsSrvRequest)
    throws RemoteException
  {
    return this._port.process(paramFiArImportARReciptsSrvRequest);
  }
  
  public FI_AR_ImportARReciptsSrv_PortType getPort()
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
 * Qualified Name:     com.zte.eas.appframe.importmis.arr.FI_AR_ImportARReciptsSrvPortClient
 * JD-Core Version:    0.7.0.1
 */