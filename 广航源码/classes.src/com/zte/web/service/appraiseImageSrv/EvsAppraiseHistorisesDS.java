package com.zte.web.service.appraiseImageSrv;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface EvsAppraiseHistorisesDS
  extends Remote
{
  public abstract EidAppraiseHistories[] findHistoryByImageInfoId(String paramString)
    throws RemoteException;
  
  public abstract String remarkVideo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.appraiseImageSrv.EvsAppraiseHistorisesDS
 * JD-Core Version:    0.7.0.1
 */