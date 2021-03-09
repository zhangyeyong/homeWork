package com.zte.eas.appframe.importmis.assetadd;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface FI_FA_ImportAssetMassAddtionSrv_Service
  extends Service
{
  public abstract FI_FA_ImportAssetMassAddtionSrv_PortType getFI_FA_ImportAssetMassAddtionSrvPort()
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetadd.FI_FA_ImportAssetMassAddtionSrv_Service
 * JD-Core Version:    0.7.0.1
 */