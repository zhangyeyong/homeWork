package com.zte.eas.boe.image.syn.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface SB_EAS_EAS_ImportImageOperationInfoSrv_PortType
  extends Remote
{
  public abstract ImportSrvResponse process(SB_EAS_EAS_ImportImageOperationInfoSrvRequest paramSB_EAS_EAS_ImportImageOperationInfoSrvRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.model.SB_EAS_EAS_ImportImageOperationInfoSrv_PortType
 * JD-Core Version:    0.7.0.1
 */