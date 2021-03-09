package com.zte.eas.infomap.business.notice.service;

import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;

public abstract interface INoticeFilter
{
  public abstract String doFilter(FbpNoticesNew paramFbpNoticesNew);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.INoticeFilter
 * JD-Core Version:    0.7.0.1
 */