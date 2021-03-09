package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidImages;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IEidImagesDAO
  extends DAO
{
  public abstract EidImages getEidImages(Long paramLong);
  
  public abstract List<EidImages> getEidImagess(int paramInt1, int paramInt2);
  
  public abstract List<EidImages> getEidImagess();
  
  public abstract void removeEidImages(Long paramLong);
  
  public abstract void removeEidImages(EidImages paramEidImages);
  
  public abstract void insertEidImages(EidImages paramEidImages);
  
  public abstract void updateEidImages(EidImages paramEidImages);
  
  public abstract void insertEidImagess(List<EidImages> paramList);
  
  public abstract void removeEidImagess(List<EidImages> paramList);
  
  public abstract void updateEidImagess(List<EidImages> paramList);
  
  public abstract List<EidImages> findEidImagesByImageInfoId(Long paramLong);
  
  public abstract List<EidImages> findImageByTif();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IEidImagesDAO
 * JD-Core Version:    0.7.0.1
 */