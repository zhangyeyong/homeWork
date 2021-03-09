package com.zte.web.service.client.createImage.client.gems;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface EIS_Rewrite
  extends Remote
{
  public abstract EIS_Rewrite_SrvResponse rewriteImageURL(EIS_Rewrite_SrvRequest paramEIS_Rewrite_SrvRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.createImage.client.gems.EIS_Rewrite
 * JD-Core Version:    0.7.0.1
 */