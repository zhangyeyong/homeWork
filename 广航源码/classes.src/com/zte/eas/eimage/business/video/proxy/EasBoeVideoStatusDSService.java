package com.zte.eas.eimage.business.video.proxy;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface EasBoeVideoStatusDSService
  extends Service
{
  public abstract EasBoeVideoStatusDS getVideoStatusService()
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.EasBoeVideoStatusDSService
 * JD-Core Version:    0.7.0.1
 */