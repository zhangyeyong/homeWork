package com.zte.eas.appframe.business.bulletinmanager.service;

import com.zte.eas.appframe.business.accessory.model.FbpAccessoryV;
import com.zte.ssb.framework.base.DomainService;

public abstract interface ITemplateUpload
  extends DomainService
{
  public abstract String uploadTemplate(FbpAccessoryV paramFbpAccessoryV);
  
  public abstract String saveTemplate(FbpAccessoryV paramFbpAccessoryV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.bulletinmanager.service.ITemplateUpload
 * JD-Core Version:    0.7.0.1
 */