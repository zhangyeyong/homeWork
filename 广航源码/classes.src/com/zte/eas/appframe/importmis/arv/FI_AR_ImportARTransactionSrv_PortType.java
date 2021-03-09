package com.zte.eas.appframe.importmis.arv;

import com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv.FiArImportARTransactionSrvRequest;
import com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv.FiArImportARTransactionSrvResponse;
import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface FI_AR_ImportARTransactionSrv_PortType
  extends Remote
{
  public abstract FiArImportARTransactionSrvResponse process(FiArImportARTransactionSrvRequest paramFiArImportARTransactionSrvRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arv.FI_AR_ImportARTransactionSrv_PortType
 * JD-Core Version:    0.7.0.1
 */