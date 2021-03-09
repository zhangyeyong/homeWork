package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IEidAppraiseHistoriesDAO;
import com.zte.eimage.access.baseconfig.dao.IEidFileProccessDAO;
import com.zte.eimage.access.baseconfig.dao.IEidImageInfosDAO;
import com.zte.eimage.access.baseconfig.dao.IEidImagesDAO;
import com.zte.evs.ebill.model.archives.FbpArchivesHeadandhistorV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public class EidFileProccessDS
  implements IEidFileProccessDS
{
  private IEidFileProccessDAO fileProccessDAO;
  private IEidImageInfosDAO imageInfosDAO;
  private IEidAppraiseHistoriesDAO appraiseHistoriesDAO;
  private IEidImagesDAO imagesDAO;
  
  public IEidFileProccessDAO getFileProccessDAO()
  {
    return this.fileProccessDAO;
  }
  
  public void setFileProccessDAO(IEidFileProccessDAO paramIEidFileProccessDAO)
  {
    this.fileProccessDAO = paramIEidFileProccessDAO;
  }
  
  public IEidImageInfosDAO getImageInfosDAO()
  {
    return this.imageInfosDAO;
  }
  
  public void setImageInfosDAO(IEidImageInfosDAO paramIEidImageInfosDAO)
  {
    this.imageInfosDAO = paramIEidImageInfosDAO;
  }
  
  public TableDataInfo queryImageInfosV(FbpArchivesHeadandhistorV paramFbpArchivesHeadandhistorV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.fileProccessDAO.findImageInfosVByQry(paramFbpArchivesHeadandhistorV, paramInt1, paramInt2, "");
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
      return localTableDataInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localTableDataInfo;
  }
  
  public IEidAppraiseHistoriesDAO getAppraiseHistoriesDAO()
  {
    return this.appraiseHistoriesDAO;
  }
  
  public void setAppraiseHistoriesDAO(IEidAppraiseHistoriesDAO paramIEidAppraiseHistoriesDAO)
  {
    this.appraiseHistoriesDAO = paramIEidAppraiseHistoriesDAO;
  }
  
  public IEidImagesDAO getImagesDAO()
  {
    return this.imagesDAO;
  }
  
  public void setImagesDAO(IEidImagesDAO paramIEidImagesDAO)
  {
    this.imagesDAO = paramIEidImagesDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.EidFileProccessDS
 * JD-Core Version:    0.7.0.1
 */