package com.zte.eas.eimage.business.video.proxy;

import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.Calendar;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Stub;
import oracle.webservices.OracleStub;
import oracle.webservices.transport.ClientTransport;

public class VideoStatusServiceClient
{
  private EasBoeVideoStatusDS _port;
  
  public VideoStatusServiceClient()
    throws Exception
  {
    ServiceFactory localServiceFactory = ServiceFactory.newInstance();
    this._port = ((EasBoeVideoStatusDSService)localServiceFactory.loadService(EasBoeVideoStatusDSService.class)).getVideoStatusService();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      VideoStatusServiceClient localVideoStatusServiceClient = new VideoStatusServiceClient();
      System.out.println("calling " + localVideoStatusServiceClient.getEndpoint());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean cancelVideo(String paramString)
    throws RemoteException
  {
    return this._port.cancelVideo(paramString);
  }
  
  public boolean registerVideo(String paramString, Calendar paramCalendar)
    throws RemoteException
  {
    return this._port.registerVideo(paramString, paramCalendar);
  }
  
  public EasBoeVideoStatusDS getPort()
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
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.VideoStatusServiceClient
 * JD-Core Version:    0.7.0.1
 */