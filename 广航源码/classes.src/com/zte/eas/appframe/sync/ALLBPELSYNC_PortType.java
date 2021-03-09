package com.zte.eas.appframe.sync;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface ALLBPELSYNC_PortType
  extends Remote
{
  public abstract ALLBPELSYNCProcessResponse process(ALLBPELSYNCProcessRequest paramALLBPELSYNCProcessRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.sync.ALLBPELSYNC_PortType
 * JD-Core Version:    0.7.0.1
 */