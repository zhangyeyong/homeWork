package com.zte.web.service.client.adjustCreditSrv;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface AdjustCreditSrv
  extends Remote
{
  public abstract AdjustCreditSrvResponse adjustCredit(AdjustCreditSrvRequest paramAdjustCreditSrvRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.adjustCreditSrv.AdjustCreditSrv
 * JD-Core Version:    0.7.0.1
 */