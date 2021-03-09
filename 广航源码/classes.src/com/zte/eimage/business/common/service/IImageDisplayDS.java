package com.zte.eimage.business.common.service;

import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IImageDisplayDS
{
  public abstract List getImage(String paramString);
  
  public abstract PageInfo getImage(String paramString, int paramInt1, int paramInt2);
  
  public abstract EidImageInfos findEidImageInfos(String paramString);
  
  public abstract String getImageInfo(String paramString);
  
  public abstract String fillImageShow(String paramString1, String paramString2, String paramString3);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.common.service.IImageDisplayDS
 * JD-Core Version:    0.7.0.1
 */