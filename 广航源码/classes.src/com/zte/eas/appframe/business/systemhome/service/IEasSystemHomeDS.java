package com.zte.eas.appframe.business.systemhome.service;

import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

public abstract interface IEasSystemHomeDS
{
  public abstract TableDataInfo findBulletins(String paramString1, String paramString2, String paramString3);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.systemhome.service.IEasSystemHomeDS
 * JD-Core Version:    0.7.0.1
 */