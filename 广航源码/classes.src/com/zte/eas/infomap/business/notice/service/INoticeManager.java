package com.zte.eas.infomap.business.notice.service;

import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;

public abstract interface INoticeManager
{
  public abstract void sendNotice(FbpNoticesNew paramFbpNoticesNew);
  
  public abstract void receiveNotice(String paramString)
    throws Exception;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.INoticeManager
 * JD-Core Version:    0.7.0.1
 */