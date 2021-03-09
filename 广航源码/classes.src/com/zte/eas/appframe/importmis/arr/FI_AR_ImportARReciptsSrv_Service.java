package com.zte.eas.appframe.importmis.arr;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface FI_AR_ImportARReciptsSrv_Service
  extends Service
{
  public abstract FI_AR_ImportARReciptsSrv_PortType getFI_AR_ImportARReciptsSrvPort()
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arr.FI_AR_ImportARReciptsSrv_Service
 * JD-Core Version:    0.7.0.1
 */