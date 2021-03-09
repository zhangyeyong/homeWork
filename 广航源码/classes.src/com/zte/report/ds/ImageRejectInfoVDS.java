package com.zte.report.ds;

import com.zte.report.dao.IImageRejectInfoVDAO;
import com.zte.report.model.ImageRejectInfoV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public class ImageRejectInfoVDS
  extends BaseDomainService
  implements IImageRejectInfoVDS
{
  private IImageRejectInfoVDAO imageRejectInfoVDAO;
  
  public void setImageRejectInfoVDAO(IImageRejectInfoVDAO paramIImageRejectInfoVDAO)
  {
    super.setDao(paramIImageRejectInfoVDAO);
    this.imageRejectInfoVDAO = paramIImageRejectInfoVDAO;
  }
  
  public List<ImageRejectInfoV> getImageRejectInfoVs(int paramInt1, int paramInt2)
  {
    return this.imageRejectInfoVDAO.getImageRejectInfoVs(paramInt1, paramInt2);
  }
  
  public List<ImageRejectInfoV> getImageRejectInfoVs()
  {
    return this.imageRejectInfoVDAO.getImageRejectInfoVs();
  }
  
  public void removeImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV)
  {
    this.imageRejectInfoVDAO.removeImageRejectInfoV(paramImageRejectInfoV);
  }
  
  public void insertImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV)
  {
    this.imageRejectInfoVDAO.insertImageRejectInfoV(paramImageRejectInfoV);
  }
  
  public void updateImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV)
  {
    this.imageRejectInfoVDAO.updateImageRejectInfoV(paramImageRejectInfoV);
  }
  
  public void insertImageRejectInfoVs(List<ImageRejectInfoV> paramList)
  {
    this.imageRejectInfoVDAO.insertImageRejectInfoVs(paramList);
  }
  
  public void removeImageRejectInfoVs(List<ImageRejectInfoV> paramList)
  {
    this.imageRejectInfoVDAO.removeImageRejectInfoVs(paramList);
  }
  
  public void updateImageRejectInfoVs(List<ImageRejectInfoV> paramList)
  {
    this.imageRejectInfoVDAO.updateImageRejectInfoVs(paramList);
  }
  
  public IImageRejectInfoVDAO getImageRejectInfoVDAO()
  {
    return this.imageRejectInfoVDAO;
  }
  
  public TableDataInfo findImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.imageRejectInfoVDAO.findImageRejectInfoV(paramImageRejectInfoV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.ds.ImageRejectInfoVDS
 * JD-Core Version:    0.7.0.1
 */