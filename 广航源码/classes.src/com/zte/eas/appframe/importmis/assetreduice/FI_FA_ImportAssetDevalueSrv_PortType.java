package com.zte.eas.appframe.importmis.assetreduice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface FI_FA_ImportAssetDevalueSrv_PortType
  extends Remote
{
  public abstract FI_FA_ImportAssetDevalueSrvProcessResponse process(FI_FA_ImportAssetDevalueSrvProcessRequest paramFI_FA_ImportAssetDevalueSrvProcessRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetreduice.FI_FA_ImportAssetDevalueSrv_PortType
 * JD-Core Version:    0.7.0.1
 */