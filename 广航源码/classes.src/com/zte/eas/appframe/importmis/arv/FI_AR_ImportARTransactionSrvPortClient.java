package com.zte.eas.appframe.importmis.arv;

import com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv.FiArImportARTransactionSrvRequest;
import com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv.FiArImportARTransactionSrvResponse;
import java.io.PrintStream;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import oracle.webservices.OracleStub;
import oracle.webservices.transport.ClientTransport;

public class FI_AR_ImportARTransactionSrvPortClient
{
  private FI_AR_ImportARTransactionSrv_PortType _port;
  
  public FI_AR_ImportARTransactionSrvPortClient()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this._port = ((FI_AR_ImportARTransactionSrv_Service)localServiceFactory.loadService(FI_AR_ImportARTransactionSrv_Service.class)).getFI_AR_ImportARTransactionSrvPort();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      FI_AR_ImportARTransactionSrvPortClient localFI_AR_ImportARTransactionSrvPortClient = new FI_AR_ImportARTransactionSrvPortClient();
      System.out.println("calling " + localFI_AR_ImportARTransactionSrvPortClient.getEndpoint());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public FiArImportARTransactionSrvResponse process(FiArImportARTransactionSrvRequest paramFiArImportARTransactionSrvRequest)
    throws RemoteException
  {
    return this._port.process(paramFiArImportARTransactionSrvRequest);
  }
  
  public FI_AR_ImportARTransactionSrv_PortType getPort()
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
 * Qualified Name:     com.zte.eas.appframe.importmis.arv.FI_AR_ImportARTransactionSrvPortClient
 * JD-Core Version:    0.7.0.1
 */