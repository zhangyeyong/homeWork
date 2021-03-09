package com.zte.eas.appframe.importmis.arr;

import com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.FiArImportARReciptsSrvRequest;
import com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.FiArImportARReciptsSrvResponse;
import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface FI_AR_ImportARReciptsSrv_PortType
  extends Remote
{
  public abstract FiArImportARReciptsSrvResponse process(FiArImportARReciptsSrvRequest paramFiArImportARReciptsSrvRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arr.FI_AR_ImportARReciptsSrv_PortType
 * JD-Core Version:    0.7.0.1
 */