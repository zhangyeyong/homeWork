package com.zte.eas.appframe.importmis.assetincompany;

import java.io.PrintStream;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import oracle.webservices.OracleStub;
import oracle.webservices.transport.ClientTransport;

public class FI_FA_ImportAssetTransferInCompanySrvPortClient
{
  private FI_FA_ImportAssetTransferInCompanySrv_PortType _port;
  
  public FI_FA_ImportAssetTransferInCompanySrvPortClient()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this._port = ((FI_FA_ImportAssetTransferInCompanySrv_Service)localServiceFactory.loadService(FI_FA_ImportAssetTransferInCompanySrv_Service.class)).getFI_FA_ImportAssetTransferInCompanySrvPort();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      FI_FA_ImportAssetTransferInCompanySrvPortClient localFI_FA_ImportAssetTransferInCompanySrvPortClient = new FI_FA_ImportAssetTransferInCompanySrvPortClient();
      System.out.println("calling " + localFI_FA_ImportAssetTransferInCompanySrvPortClient.getEndpoint());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public FI_FA_ImportAssetTransferInCompanySrvProcessResponse process(FI_FA_ImportAssetTransferInCompanySrvProcessRequest paramFI_FA_ImportAssetTransferInCompanySrvProcessRequest)
    throws RemoteException
  {
    return this._port.process(paramFI_FA_ImportAssetTransferInCompanySrvProcessRequest);
  }
  
  public FI_FA_ImportAssetTransferInCompanySrv_PortType getPort()
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
 * Qualified Name:     com.zte.eas.appframe.importmis.assetincompany.FI_FA_ImportAssetTransferInCompanySrvPortClient
 * JD-Core Version:    0.7.0.1
 */