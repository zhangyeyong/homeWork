package com.zte.eas.boe.image.syn.model;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface SB_EAS_EAS_ImportImageOperationInfoSrv_Service
  extends Service
{
  public abstract String getSB_EAS_EAS_ImportImageOperationInfoSrvPortAddress();
  
  public abstract SB_EAS_EAS_ImportImageOperationInfoSrv_PortType getSB_EAS_EAS_ImportImageOperationInfoSrvPort()
    throws ServiceException;
  
  public abstract SB_EAS_EAS_ImportImageOperationInfoSrv_PortType getSB_EAS_EAS_ImportImageOperationInfoSrvPort(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.model.SB_EAS_EAS_ImportImageOperationInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */