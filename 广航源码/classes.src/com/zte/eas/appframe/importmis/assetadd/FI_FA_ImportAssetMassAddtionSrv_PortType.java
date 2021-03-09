package com.zte.eas.appframe.importmis.assetadd;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface FI_FA_ImportAssetMassAddtionSrv_PortType
  extends Remote
{
  public abstract FI_FA_ImportAssetMassAddtionSrvProcessResponse process(FI_FA_ImportAssetMassAddtionSrvProcessRequest paramFI_FA_ImportAssetMassAddtionSrvProcessRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetadd.FI_FA_ImportAssetMassAddtionSrv_PortType
 * JD-Core Version:    0.7.0.1
 */