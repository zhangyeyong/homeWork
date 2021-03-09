package com.zte.eas.appframe.importmis.assetoutcompany;

import java.io.PrintStream;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import oracle.webservices.OracleStub;
import oracle.webservices.transport.ClientTransport;

public class FI_FA_ImportAssetTransferIntercompanysSrvPortClient
{
  private FI_FA_ImportAssetTransferIntercompanysSrv_PortType _port;
  
  public FI_FA_ImportAssetTransferIntercompanysSrvPortClient()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this._port = ((FI_FA_ImportAssetTransferIntercompanysSrv_Service)localServiceFactory.loadService(FI_FA_ImportAssetTransferIntercompanysSrv_Service.class)).getFI_FA_ImportAssetTransferIntercompanysSrvPort();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      FI_FA_ImportAssetTransferIntercompanysSrvPortClient localFI_FA_ImportAssetTransferIntercompanysSrvPortClient = new FI_FA_ImportAssetTransferIntercompanysSrvPortClient();
      System.out.println("calling " + localFI_FA_ImportAssetTransferIntercompanysSrvPortClient.getEndpoint());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public FI_FA_ImportAssetTransferIntercompanysSrvProcessResponse process(FI_FA_ImportAssetTransferIntercompanysSrvProcessRequest paramFI_FA_ImportAssetTransferIntercompanysSrvProcessRequest)
    throws RemoteException
  {
    return this._port.process(paramFI_FA_ImportAssetTransferIntercompanysSrvProcessRequest);
  }
  
  public FI_FA_ImportAssetTransferIntercompanysSrv_PortType getPort()
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
 * Qualified Name:     com.zte.eas.appframe.importmis.assetoutcompany.FI_FA_ImportAssetTransferIntercompanysSrvPortClient
 * JD-Core Version:    0.7.0.1
 */