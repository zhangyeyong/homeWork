package com.zte.eas.appframe.importmis.assetgarbage;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface FI_FA_ImportAssetRetirmentSrv_Service
  extends Service
{
  public abstract FI_FA_ImportAssetRetirmentSrv_PortType getFI_FA_ImportAssetRetirmentSrvPort()
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetgarbage.FI_FA_ImportAssetRetirmentSrv_Service
 * JD-Core Version:    0.7.0.1
 */