package com.zte.eas.appframe.importmis.assetincompany;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface FI_FA_ImportAssetTransferInCompanySrv_PortType
  extends Remote
{
  public abstract FI_FA_ImportAssetTransferInCompanySrvProcessResponse process(FI_FA_ImportAssetTransferInCompanySrvProcessRequest paramFI_FA_ImportAssetTransferInCompanySrvProcessRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetincompany.FI_FA_ImportAssetTransferInCompanySrv_PortType
 * JD-Core Version:    0.7.0.1
 */