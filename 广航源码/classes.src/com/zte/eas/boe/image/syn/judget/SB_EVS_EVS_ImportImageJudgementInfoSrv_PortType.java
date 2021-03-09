package com.zte.eas.boe.image.syn.judget;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType
  extends Remote
{
  public abstract ImportSrvResponse process(SB_EVS_EVS_ImportImageJudgementInfoSrvRequest paramSB_EVS_EVS_ImportImageJudgementInfoSrvRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.judget.SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType
 * JD-Core Version:    0.7.0.1
 */