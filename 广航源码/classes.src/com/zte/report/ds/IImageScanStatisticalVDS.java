package com.zte.report.ds;

import com.zte.report.model.ImageScanStatisticalV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IImageScanStatisticalVDS
  extends DomainService
{
  public abstract List<ImageScanStatisticalV> getImageScanStatisticalVs(int paramInt1, int paramInt2);
  
  public abstract List<ImageScanStatisticalV> getImageScanStatisticalVs();
  
  public abstract void removeImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV);
  
  public abstract void insertImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV);
  
  public abstract void updateImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV);
  
  public abstract void insertImageScanStatisticalVs(List<ImageScanStatisticalV> paramList);
  
  public abstract void removeImageScanStatisticalVs(List<ImageScanStatisticalV> paramList);
  
  public abstract void updateImageScanStatisticalVs(List<ImageScanStatisticalV> paramList);
  
  public abstract TableDataInfo findImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.ds.IImageScanStatisticalVDS
 * JD-Core Version:    0.7.0.1
 */