package com.zte.eas.appframe.importmis.assetadd;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import oracle.webservices.OracleStub;
import oracle.webservices.transport.ClientTransport;

public class FI_FA_ImportAssetMassAddtionSrvPortClient
{
  private FI_FA_ImportAssetMassAddtionSrv_PortType _port;
  
  public FI_FA_ImportAssetMassAddtionSrvPortClient()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this._port = ((FI_FA_ImportAssetMassAddtionSrv_Service)localServiceFactory.loadService(FI_FA_ImportAssetMassAddtionSrv_Service.class)).getFI_FA_ImportAssetMassAddtionSrvPort();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      FI_FA_ImportAssetMassAddtionSrvPortClient localFI_FA_ImportAssetMassAddtionSrvPortClient = new FI_FA_ImportAssetMassAddtionSrvPortClient();
      FI_FA_ImportAssetMassAddtionSrvProcessRequest localFI_FA_ImportAssetMassAddtionSrvProcessRequest = new FI_FA_ImportAssetMassAddtionSrvProcessRequest();
      LineIDItem[] arrayOfLineIDItem1 = new LineIDItem[2];
      int i = 0;
      for (LineIDItem localLineIDItem : arrayOfLineIDItem1)
      {
        arrayOfLineIDItem1[i] = new LineIDItem();
        arrayOfLineIDItem1[i].setLineID("1");
        i++;
      }
      localFI_FA_ImportAssetMassAddtionSrvProcessRequest.setEmployeeNumber("1111");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public FI_FA_ImportAssetMassAddtionSrvProcessResponse process(FI_FA_ImportAssetMassAddtionSrvProcessRequest paramFI_FA_ImportAssetMassAddtionSrvProcessRequest)
    throws RemoteException
  {
    return this._port.process(paramFI_FA_ImportAssetMassAddtionSrvProcessRequest);
  }
  
  public FI_FA_ImportAssetMassAddtionSrv_PortType getPort()
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
 * Qualified Name:     com.zte.eas.appframe.importmis.assetadd.FI_FA_ImportAssetMassAddtionSrvPortClient
 * JD-Core Version:    0.7.0.1
 */