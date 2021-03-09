package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IFbpApproveHistoryVDAO;
import com.zte.eimage.business.baseconfig.model.FbpApproveHistoryV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.ArrayList;
import java.util.List;

public class FbpApproveHistoryVDS
  extends BaseDomainService
  implements IFbpApproveHistoryVDS
{
  private IFbpApproveHistoryVDAO fbpApproveHistoryVDAO;
  
  public void setFbpApproveHistoryVDAO(IFbpApproveHistoryVDAO paramIFbpApproveHistoryVDAO)
  {
    super.setDao(paramIFbpApproveHistoryVDAO);
    this.fbpApproveHistoryVDAO = paramIFbpApproveHistoryVDAO;
  }
  
  public TableDataInfo getFbpApproveHistory(FbpApproveHistoryV paramFbpApproveHistoryV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    try
    {
      PageInfo localPageInfo = this.fbpApproveHistoryVDAO.getFbpApproveHistoryVs(paramInt1, paramInt2);
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
  
  public List<FbpApproveHistoryV> findHistoryVByApplyNum(String paramString)
  {
    Object localObject = new ArrayList();
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        localObject = this.fbpApproveHistoryVDAO.findHistoryVByApplyNum(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return localObject;
  }
  
  public List<FbpApproveHistoryV> getFbpApproveHistoryVs()
  {
    return this.fbpApproveHistoryVDAO.getFbpApproveHistoryVs();
  }
  
  public FbpApproveHistoryV getFbpApproveHistoryV(String paramString)
  {
    return this.fbpApproveHistoryVDAO.getFbpApproveHistoryV(paramString);
  }
  
  public void removeFbpApproveHistoryV(String paramString)
  {
    this.fbpApproveHistoryVDAO.removeFbpApproveHistoryV(paramString);
  }
  
  public void removeFbpApproveHistoryV(FbpApproveHistoryV paramFbpApproveHistoryV)
  {
    this.fbpApproveHistoryVDAO.removeFbpApproveHistoryV(paramFbpApproveHistoryV);
  }
  
  public void insertFbpApproveHistoryV(FbpApproveHistoryV paramFbpApproveHistoryV)
  {
    this.fbpApproveHistoryVDAO.insertFbpApproveHistoryV(paramFbpApproveHistoryV);
  }
  
  public void updateFbpApproveHistoryV(FbpApproveHistoryV paramFbpApproveHistoryV)
  {
    this.fbpApproveHistoryVDAO.updateFbpApproveHistoryV(paramFbpApproveHistoryV);
  }
  
  public void insertFbpApproveHistoryVs(List<FbpApproveHistoryV> paramList)
  {
    this.fbpApproveHistoryVDAO.insertFbpApproveHistoryVs(paramList);
  }
  
  public void removeFbpApproveHistoryVs(List<FbpApproveHistoryV> paramList)
  {
    this.fbpApproveHistoryVDAO.removeFbpApproveHistoryVs(paramList);
  }
  
  public void updateFbpApproveHistoryVs(List<FbpApproveHistoryV> paramList)
  {
    this.fbpApproveHistoryVDAO.updateFbpApproveHistoryVs(paramList);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.FbpApproveHistoryVDS
 * JD-Core Version:    0.7.0.1
 */