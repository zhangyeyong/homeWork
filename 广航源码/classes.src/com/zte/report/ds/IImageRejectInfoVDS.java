package com.zte.report.ds;

import com.zte.report.model.ImageRejectInfoV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IImageRejectInfoVDS
  extends DomainService
{
  public abstract List<ImageRejectInfoV> getImageRejectInfoVs(int paramInt1, int paramInt2);
  
  public abstract List<ImageRejectInfoV> getImageRejectInfoVs();
  
  public abstract void removeImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV);
  
  public abstract void insertImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV);
  
  public abstract void updateImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV);
  
  public abstract void insertImageRejectInfoVs(List<ImageRejectInfoV> paramList);
  
  public abstract void removeImageRejectInfoVs(List<ImageRejectInfoV> paramList);
  
  public abstract void updateImageRejectInfoVs(List<ImageRejectInfoV> paramList);
  
  public abstract TableDataInfo findImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.ds.IImageRejectInfoVDS
 * JD-Core Version:    0.7.0.1
 */