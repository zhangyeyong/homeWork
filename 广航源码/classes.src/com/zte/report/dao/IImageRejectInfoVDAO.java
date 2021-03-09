package com.zte.report.dao;

import com.zte.report.model.ImageRejectInfoV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IImageRejectInfoVDAO
  extends DAO
{
  public abstract List<ImageRejectInfoV> getImageRejectInfoVs(int paramInt1, int paramInt2);
  
  public abstract List<ImageRejectInfoV> getImageRejectInfoVs();
  
  public abstract void removeImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV);
  
  public abstract void insertImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV);
  
  public abstract void updateImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV);
  
  public abstract void insertImageRejectInfoVs(List<ImageRejectInfoV> paramList);
  
  public abstract void removeImageRejectInfoVs(List<ImageRejectInfoV> paramList);
  
  public abstract void updateImageRejectInfoVs(List<ImageRejectInfoV> paramList);
  
  public abstract PageInfo findImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.dao.IImageRejectInfoVDAO
 * JD-Core Version:    0.7.0.1
 */