package com.zte.report.dao;

import com.zte.report.model.ImageQueryInfoV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IImageQueryInfoVDAO
  extends DAO
{
  public abstract List<ImageQueryInfoV> getImageQueryInfoVs(int paramInt1, int paramInt2);
  
  public abstract List<ImageQueryInfoV> getImageQueryInfoVs();
  
  public abstract void removeImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV);
  
  public abstract void insertImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV);
  
  public abstract void updateImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV);
  
  public abstract void insertImageQueryInfoVs(List<ImageQueryInfoV> paramList);
  
  public abstract void removeImageQueryInfoVs(List<ImageQueryInfoV> paramList);
  
  public abstract void updateImageQueryInfoVs(List<ImageQueryInfoV> paramList);
  
  public abstract PageInfo findImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.dao.IImageQueryInfoVDAO
 * JD-Core Version:    0.7.0.1
 */