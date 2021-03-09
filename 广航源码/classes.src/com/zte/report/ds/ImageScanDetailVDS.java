package com.zte.report.ds;

import com.zte.report.dao.IImageScanDetailVDAO;
import com.zte.report.model.ImageScanDetailV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public class ImageScanDetailVDS
  extends BaseDomainService
  implements IImageScanDetailVDS
{
  private IImageScanDetailVDAO imageScanDetailVDAO;
  
  public void setImageScanDetailVDAO(IImageScanDetailVDAO paramIImageScanDetailVDAO)
  {
    super.setDao(paramIImageScanDetailVDAO);
    this.imageScanDetailVDAO = paramIImageScanDetailVDAO;
  }
  
  public List<ImageScanDetailV> getImageScanDetailVs(int paramInt1, int paramInt2)
  {
    return this.imageScanDetailVDAO.getImageScanDetailVs(paramInt1, paramInt2);
  }
  
  public List<ImageScanDetailV> getImageScanDetailVs()
  {
    return this.imageScanDetailVDAO.getImageScanDetailVs();
  }
  
  public void removeImageScanDetailV(ImageScanDetailV paramImageScanDetailV)
  {
    this.imageScanDetailVDAO.removeImageScanDetailV(paramImageScanDetailV);
  }
  
  public void insertImageScanDetailV(ImageScanDetailV paramImageScanDetailV)
  {
    this.imageScanDetailVDAO.insertImageScanDetailV(paramImageScanDetailV);
  }
  
  public void updateImageScanDetailV(ImageScanDetailV paramImageScanDetailV)
  {
    this.imageScanDetailVDAO.updateImageScanDetailV(paramImageScanDetailV);
  }
  
  public void insertImageScanDetailVs(List<ImageScanDetailV> paramList)
  {
    this.imageScanDetailVDAO.insertImageScanDetailVs(paramList);
  }
  
  public void removeImageScanDetailVs(List<ImageScanDetailV> paramList)
  {
    this.imageScanDetailVDAO.removeImageScanDetailVs(paramList);
  }
  
  public void updateImageScanDetailVs(List<ImageScanDetailV> paramList)
  {
    this.imageScanDetailVDAO.updateImageScanDetailVs(paramList);
  }
  
  public IImageScanDetailVDAO getImageScanDetailVDAO()
  {
    return this.imageScanDetailVDAO;
  }
  
  public TableDataInfo findImageScanDetailV(ImageScanDetailV paramImageScanDetailV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.imageScanDetailVDAO.findImageScanDetailV(paramImageScanDetailV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.ds.ImageScanDetailVDS
 * JD-Core Version:    0.7.0.1
 */