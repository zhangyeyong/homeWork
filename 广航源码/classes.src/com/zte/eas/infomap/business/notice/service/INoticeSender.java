package com.zte.eas.infomap.business.notice.service;

import com.zte.ssb.framework.base.DomainService;

public abstract interface INoticeSender
  extends DomainService
{
  public abstract void sendNotices();
  
  public abstract String testsendNotices();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.INoticeSender
 * JD-Core Version:    0.7.0.1
 */