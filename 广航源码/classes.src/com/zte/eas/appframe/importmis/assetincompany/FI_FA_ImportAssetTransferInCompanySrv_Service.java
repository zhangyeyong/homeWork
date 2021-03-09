package com.zte.eas.appframe.importmis.assetincompany;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface FI_FA_ImportAssetTransferInCompanySrv_Service
  extends Service
{
  public abstract FI_FA_ImportAssetTransferInCompanySrv_PortType getFI_FA_ImportAssetTransferInCompanySrvPort()
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetincompany.FI_FA_ImportAssetTransferInCompanySrv_Service
 * JD-Core Version:    0.7.0.1
 */