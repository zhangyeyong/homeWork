package com.zte.eas.appframe.importmis.assetoutcompany;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface FI_FA_ImportAssetTransferIntercompanysSrv_PortType
  extends Remote
{
  public abstract FI_FA_ImportAssetTransferIntercompanysSrvProcessResponse process(FI_FA_ImportAssetTransferIntercompanysSrvProcessRequest paramFI_FA_ImportAssetTransferIntercompanysSrvProcessRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetoutcompany.FI_FA_ImportAssetTransferIntercompanysSrv_PortType
 * JD-Core Version:    0.7.0.1
 */