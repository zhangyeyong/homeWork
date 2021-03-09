package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.FbpApproveHistoryV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpApproveHistoryVDAO
  extends DAO
{
  public abstract FbpApproveHistoryV getFbpApproveHistoryV(String paramString);
  
  public abstract PageInfo getFbpApproveHistoryVs(int paramInt1, int paramInt2);
  
  public abstract List<FbpApproveHistoryV> getFbpApproveHistoryVs();
  
  public abstract void removeFbpApproveHistoryV(String paramString);
  
  public abstract void removeFbpApproveHistoryV(FbpApproveHistoryV paramFbpApproveHistoryV);
  
  public abstract void insertFbpApproveHistoryV(FbpApproveHistoryV paramFbpApproveHistoryV);
  
  public abstract void updateFbpApproveHistoryV(FbpApproveHistoryV paramFbpApproveHistoryV);
  
  public abstract void insertFbpApproveHistoryVs(List<FbpApproveHistoryV> paramList);
  
  public abstract void removeFbpApproveHistoryVs(List<FbpApproveHistoryV> paramList);
  
  public abstract void updateFbpApproveHistoryVs(List<FbpApproveHistoryV> paramList);
  
  public abstract List<FbpApproveHistoryV> findHistoryVByApplyNum(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IFbpApproveHistoryVDAO
 * JD-Core Version:    0.7.0.1
 */