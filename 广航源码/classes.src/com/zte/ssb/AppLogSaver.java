package com.zte.ssb;

import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.logmanager.business.service.IAppLogInfoMgt;

public class AppLogSaver
{
  public void appLogSaveToDB()
  {
    IAppLogInfoMgt localIAppLogInfoMgt = (IAppLogInfoMgt)SSBBus.findDomainService("appLogMgtFacade");
    localIAppLogInfoMgt.saveToDB();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.ssb.AppLogSaver
 * JD-Core Version:    0.7.0.1
 */