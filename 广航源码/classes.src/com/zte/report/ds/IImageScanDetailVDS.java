package com.zte.report.ds;

import com.zte.report.model.ImageScanDetailV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IImageScanDetailVDS
  extends DomainService
{
  public abstract List<ImageScanDetailV> getImageScanDetailVs(int paramInt1, int paramInt2);
  
  public abstract List<ImageScanDetailV> getImageScanDetailVs();
  
  public abstract void removeImageScanDetailV(ImageScanDetailV paramImageScanDetailV);
  
  public abstract void insertImageScanDetailV(ImageScanDetailV paramImageScanDetailV);
  
  public abstract void updateImageScanDetailV(ImageScanDetailV paramImageScanDetailV);
  
  public abstract void insertImageScanDetailVs(List<ImageScanDetailV> paramList);
  
  public abstract void removeImageScanDetailVs(List<ImageScanDetailV> paramList);
  
  public abstract void updateImageScanDetailVs(List<ImageScanDetailV> paramList);
  
  public abstract TableDataInfo findImageScanDetailV(ImageScanDetailV paramImageScanDetailV, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.ds.IImageScanDetailVDS
 * JD-Core Version:    0.7.0.1
 */