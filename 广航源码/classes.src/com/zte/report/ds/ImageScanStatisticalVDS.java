package com.zte.report.ds;

import com.zte.report.dao.IImageScanStatisticalVDAO;
import com.zte.report.model.ImageScanStatisticalV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public class ImageScanStatisticalVDS
  extends BaseDomainService
  implements IImageScanStatisticalVDS
{
  private IImageScanStatisticalVDAO imageScanStatisticalVDAO;
  
  public void setImageScanStatisticalVDAO(IImageScanStatisticalVDAO paramIImageScanStatisticalVDAO)
  {
    super.setDao(paramIImageScanStatisticalVDAO);
    this.imageScanStatisticalVDAO = paramIImageScanStatisticalVDAO;
  }
  
  public List<ImageScanStatisticalV> getImageScanStatisticalVs(int paramInt1, int paramInt2)
  {
    return this.imageScanStatisticalVDAO.getImageScanStatisticalVs(paramInt1, paramInt2);
  }
  
  public List<ImageScanStatisticalV> getImageScanStatisticalVs()
  {
    return this.imageScanStatisticalVDAO.getImageScanStatisticalVs();
  }
  
  public void removeImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV)
  {
    this.imageScanStatisticalVDAO.removeImageScanStatisticalV(paramImageScanStatisticalV);
  }
  
  public void insertImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV)
  {
    this.imageScanStatisticalVDAO.insertImageScanStatisticalV(paramImageScanStatisticalV);
  }
  
  public void updateImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV)
  {
    this.imageScanStatisticalVDAO.updateImageScanStatisticalV(paramImageScanStatisticalV);
  }
  
  public void insertImageScanStatisticalVs(List<ImageScanStatisticalV> paramList)
  {
    this.imageScanStatisticalVDAO.insertImageScanStatisticalVs(paramList);
  }
  
  public void removeImageScanStatisticalVs(List<ImageScanStatisticalV> paramList)
  {
    this.imageScanStatisticalVDAO.removeImageScanStatisticalVs(paramList);
  }
  
  public void updateImageScanStatisticalVs(List<ImageScanStatisticalV> paramList)
  {
    this.imageScanStatisticalVDAO.updateImageScanStatisticalVs(paramList);
  }
  
  public IImageScanStatisticalVDAO getImageScanStatisticalVDAO()
  {
    return this.imageScanStatisticalVDAO;
  }
  
  public TableDataInfo findImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.imageScanStatisticalVDAO.findImageScanStatisticalV(paramImageScanStatisticalV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.ds.ImageScanStatisticalVDS
 * JD-Core Version:    0.7.0.1
 */