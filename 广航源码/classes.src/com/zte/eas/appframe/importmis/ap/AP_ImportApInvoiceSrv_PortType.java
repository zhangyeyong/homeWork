package com.zte.eas.appframe.importmis.ap;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface AP_ImportApInvoiceSrv_PortType
  extends Remote
{
  public abstract AP_ImportApInvoiceSrvProcessResponse process(AP_ImportApInvoiceSrvProcessRequest paramAP_ImportApInvoiceSrvProcessRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.ap.AP_ImportApInvoiceSrv_PortType
 * JD-Core Version:    0.7.0.1
 */