package com.zte.eas.appframe.importmis.assetoutcompany;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface FI_FA_ImportAssetTransferIntercompanysSrv_Service
  extends Service
{
  public abstract FI_FA_ImportAssetTransferIntercompanysSrv_PortType getFI_FA_ImportAssetTransferIntercompanysSrvPort()
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetoutcompany.FI_FA_ImportAssetTransferIntercompanysSrv_Service
 * JD-Core Version:    0.7.0.1
 */