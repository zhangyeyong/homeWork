package com.zte.eimage.business.baseconfig.service;

import com.zte.evs.ebill.model.archives.FbpArchivesHeadandhistorV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

public abstract interface IEidFileProccessDS
{
  public abstract TableDataInfo queryImageInfosV(FbpArchivesHeadandhistorV paramFbpArchivesHeadandhistorV, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IEidFileProccessDS
 * JD-Core Version:    0.7.0.1
 */