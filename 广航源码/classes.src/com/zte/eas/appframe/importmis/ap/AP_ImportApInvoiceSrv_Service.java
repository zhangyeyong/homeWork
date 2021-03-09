package com.zte.eas.appframe.importmis.ap;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface AP_ImportApInvoiceSrv_Service
  extends Service
{
  public abstract AP_ImportApInvoiceSrv_PortType getAP_ImportApInvoiceSrvPort()
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.ap.AP_ImportApInvoiceSrv_Service
 * JD-Core Version:    0.7.0.1
 */