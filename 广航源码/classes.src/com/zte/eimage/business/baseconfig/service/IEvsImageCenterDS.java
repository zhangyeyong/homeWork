package com.zte.eimage.business.baseconfig.service;

import java.util.Date;

public abstract interface IEvsImageCenterDS
{
  public abstract boolean registerVideo(String paramString, Date paramDate);
  
  public abstract boolean cancelVideo(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IEvsImageCenterDS
 * JD-Core Version:    0.7.0.1
 */