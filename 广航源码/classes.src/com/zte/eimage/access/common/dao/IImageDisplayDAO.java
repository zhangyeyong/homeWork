package com.zte.eimage.access.common.dao;

import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.model.EidImages;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IImageDisplayDAO
{
  public abstract List findImageByImageNumer(String paramString);
  
  public abstract PageInfo findImageByImageNumer(String paramString, int paramInt1, int paramInt2);
  
  public abstract String getImageInfo(String paramString);
  
  public abstract EidImageInfos findEidImageInfos(String paramString);
  
  public abstract EidImages getImageShow(Long paramLong1, Long paramLong2);
  
  public abstract void updateEidImages(EidImages paramEidImages);
  
  public abstract String getRoleId();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.common.dao.IImageDisplayDAO
 * JD-Core Version:    0.7.0.1
 */