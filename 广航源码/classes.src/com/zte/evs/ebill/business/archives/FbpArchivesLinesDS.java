package com.zte.evs.ebill.business.archives;

import com.zte.evs.ebill.access.archives.IFbpArchivesLinesDAO;
import com.zte.evs.ebill.model.archives.FbpArchivesLines;
import com.zte.evs.ebill.model.archives.FbpArchivesLinesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.ArrayList;
import java.util.List;

public class FbpArchivesLinesDS
  extends BaseDomainService
  implements IFbpArchivesLinesDS
{
  private IFbpArchivesLinesDAO fbpArchivesLinesDAO;
  
  public void setFbpArchivesLinesDAO(IFbpArchivesLinesDAO paramIFbpArchivesLinesDAO)
  {
    super.setDao(paramIFbpArchivesLinesDAO);
    this.fbpArchivesLinesDAO = paramIFbpArchivesLinesDAO;
  }
  
  public List<FbpArchivesLines> getFbpArchivesLiness(int paramInt1, int paramInt2)
  {
    return this.fbpArchivesLinesDAO.getFbpArchivesLiness(paramInt1, paramInt2);
  }
  
  public List<FbpArchivesLines> getFbpArchivesLiness()
  {
    return this.fbpArchivesLinesDAO.getFbpArchivesLiness();
  }
  
  public FbpArchivesLines getFbpArchivesLines(Long paramLong)
  {
    return this.fbpArchivesLinesDAO.getFbpArchivesLines(paramLong);
  }
  
  public TableDataInfo findFbpArchivesLinesV(FbpArchivesLinesV paramFbpArchivesLinesV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.fbpArchivesLinesDAO.findFbpArchivesLinesV(paramFbpArchivesLinesV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public void removeFbpArchivesLines(Long paramLong)
  {
    this.fbpArchivesLinesDAO.removeFbpArchivesLines(paramLong);
  }
  
  public void removeFbpArchivesLines(FbpArchivesLines paramFbpArchivesLines)
  {
    this.fbpArchivesLinesDAO.removeFbpArchivesLines(paramFbpArchivesLines);
  }
  
  public void insertFbpArchivesLines(FbpArchivesLines paramFbpArchivesLines)
  {
    this.fbpArchivesLinesDAO.insertFbpArchivesLines(paramFbpArchivesLines);
  }
  
  public void updateFbpArchivesLines(FbpArchivesLines paramFbpArchivesLines)
  {
    this.fbpArchivesLinesDAO.updateFbpArchivesLines(paramFbpArchivesLines);
  }
  
  public void insertFbpArchivesLiness(List<FbpArchivesLines> paramList)
  {
    this.fbpArchivesLinesDAO.insertFbpArchivesLiness(paramList);
  }
  
  public void removeFbpArchivesLiness(List<FbpArchivesLines> paramList)
  {
    this.fbpArchivesLinesDAO.removeFbpArchivesLiness(paramList);
  }
  
  public void updateFbpArchivesLiness(List<FbpArchivesLines> paramList)
  {
    this.fbpArchivesLinesDAO.updateFbpArchivesLiness(paramList);
  }
  
  public List<FbpArchivesLinesV> findFbpArchivesLinessV(Long paramLong)
  {
    Object localObject = new ArrayList();
    localObject = this.fbpArchivesLinesDAO.findFbpArchivesLinessV(paramLong);
    return localObject;
  }
  
  public TableDataInfo getFbpArchivesLinesByHeardId(FbpArchivesLinesV paramFbpArchivesLinesV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.fbpArchivesLinesDAO.findFbpArchivesLinesV(paramFbpArchivesLinesV, paramInt1, paramInt2);
      localTableDataInfo.setData((List)localPageInfo.getResult());
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    return localTableDataInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.archives.FbpArchivesLinesDS
 * JD-Core Version:    0.7.0.1
 */