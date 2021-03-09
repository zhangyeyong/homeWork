package com.zte.eas.appframe.sync;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface ALLBPELSYNC_Service
  extends Service
{
  public abstract ALLBPELSYNC_PortType getALLBPELSYNCPort()
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.sync.ALLBPELSYNC_Service
 * JD-Core Version:    0.7.0.1
 */