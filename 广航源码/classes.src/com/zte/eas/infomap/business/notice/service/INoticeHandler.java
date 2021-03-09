package com.zte.eas.infomap.business.notice.service;

import com.zte.eas.infomap.business.common.service.ITemplateBuilder;
import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;

public abstract interface INoticeHandler
{
  public abstract void diposeNotice(String paramString, FbpNoticesNew paramFbpNoticesNew);
  
  public abstract void setTemplateBuilder(ITemplateBuilder paramITemplateBuilder);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.INoticeHandler
 * JD-Core Version:    0.7.0.1
 */