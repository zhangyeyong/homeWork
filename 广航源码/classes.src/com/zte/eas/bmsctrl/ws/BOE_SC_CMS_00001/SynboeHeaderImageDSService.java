package com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00001;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface SynboeHeaderImageDSService
  extends Service
{
  public abstract String getsynboeHeaderImageDSAddress();
  
  public abstract SynboeHeaderImageDS getsynboeHeaderImageDS()
    throws ServiceException;
  
  public abstract SynboeHeaderImageDS getsynboeHeaderImageDS(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00001.SynboeHeaderImageDSService
 * JD-Core Version:    0.7.0.1
 */