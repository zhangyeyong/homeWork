package com.zte.eas.appframe.importmis.vendorimport;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface SC_PO_ImportVendorInfoSrv_Service
  extends Service
{
  public abstract SC_PO_ImportVendorInfoSrv_PortType getSC_PO_ImportVendorInfoSrvPort()
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrv_Service
 * JD-Core Version:    0.7.0.1
 */