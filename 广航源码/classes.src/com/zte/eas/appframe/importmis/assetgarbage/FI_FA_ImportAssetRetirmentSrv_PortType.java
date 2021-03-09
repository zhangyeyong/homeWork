package com.zte.eas.appframe.importmis.assetgarbage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface FI_FA_ImportAssetRetirmentSrv_PortType
  extends Remote
{
  public abstract FI_FA_ImportAssetRetirmentSrvProcessResponse process(FI_FA_ImportAssetRetirmentSrvProcessRequest paramFI_FA_ImportAssetRetirmentSrvProcessRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetgarbage.FI_FA_ImportAssetRetirmentSrv_PortType
 * JD-Core Version:    0.7.0.1
 */