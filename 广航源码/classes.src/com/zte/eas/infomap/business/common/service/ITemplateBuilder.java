package com.zte.eas.infomap.business.common.service;

import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;

public abstract interface ITemplateBuilder
{
  public abstract String buildText(String paramString, FbpNoticesNew paramFbpNoticesNew);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.common.service.ITemplateBuilder
 * JD-Core Version:    0.7.0.1
 */