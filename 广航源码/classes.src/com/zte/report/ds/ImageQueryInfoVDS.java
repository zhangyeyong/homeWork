package com.zte.report.ds;

import com.zte.report.dao.IImageQueryInfoVDAO;
import com.zte.report.model.ImageQueryInfoV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public class ImageQueryInfoVDS
  extends BaseDomainService
  implements IImageQueryInfoVDS
{
  private IImageQueryInfoVDAO imageQueryInfoVDAO;
  
  public void setImageQueryInfoVDAO(IImageQueryInfoVDAO paramIImageQueryInfoVDAO)
  {
    super.setDao(paramIImageQueryInfoVDAO);
    this.imageQueryInfoVDAO = paramIImageQueryInfoVDAO;
  }
  
  public List<ImageQueryInfoV> getImageQueryInfoVs(int paramInt1, int paramInt2)
  {
    return this.imageQueryInfoVDAO.getImageQueryInfoVs(paramInt1, paramInt2);
  }
  
  public List<ImageQueryInfoV> getImageQueryInfoVs()
  {
    return this.imageQueryInfoVDAO.getImageQueryInfoVs();
  }
  
  public void removeImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV)
  {
    this.imageQueryInfoVDAO.removeImageQueryInfoV(paramImageQueryInfoV);
  }
  
  public void insertImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV)
  {
    this.imageQueryInfoVDAO.insertImageQueryInfoV(paramImageQueryInfoV);
  }
  
  public void updateImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV)
  {
    this.imageQueryInfoVDAO.updateImageQueryInfoV(paramImageQueryInfoV);
  }
  
  public void insertImageQueryInfoVs(List<ImageQueryInfoV> paramList)
  {
    this.imageQueryInfoVDAO.insertImageQueryInfoVs(paramList);
  }
  
  public void removeImageQueryInfoVs(List<ImageQueryInfoV> paramList)
  {
    this.imageQueryInfoVDAO.removeImageQueryInfoVs(paramList);
  }
  
  public void updateImageQueryInfoVs(List<ImageQueryInfoV> paramList)
  {
    this.imageQueryInfoVDAO.updateImageQueryInfoVs(paramList);
  }
  
  public IImageQueryInfoVDAO getImageQueryInfoVDAO()
  {
    return this.imageQueryInfoVDAO;
  }
  
  public TableDataInfo findImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.imageQueryInfoVDAO.findImageQueryInfoV(paramImageQueryInfoV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.ds.ImageQueryInfoVDS
 * JD-Core Version:    0.7.0.1
 */