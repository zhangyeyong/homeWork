package com.zte.eas.appframe.importmis.vendorimport;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface SC_PO_ImportVendorInfoSrv_PortType
  extends Remote
{
  public abstract SC_PO_ImportVendorInfoSrvProcessResponse process(SC_PO_ImportVendorInfoSrvProcessRequest paramSC_PO_ImportVendorInfoSrvProcessRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrv_PortType
 * JD-Core Version:    0.7.0.1
 */