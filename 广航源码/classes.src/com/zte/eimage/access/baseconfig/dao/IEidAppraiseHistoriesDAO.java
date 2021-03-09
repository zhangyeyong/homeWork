package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidAppraiseHistories;
import com.zte.eimage.business.baseconfig.model.EidAppraiseHistoryV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IEidAppraiseHistoriesDAO
  extends DAO
{
  public abstract EidAppraiseHistories getEidAppraiseHistories(Long paramLong);
  
  public abstract List<EidAppraiseHistories> getEidAppraiseHistoriess(int paramInt1, int paramInt2);
  
  public abstract List<EidAppraiseHistories> getEidAppraiseHistoriess();
  
  public abstract void removeEidAppraiseHistories(Long paramLong);
  
  public abstract void removeEidAppraiseHistories(EidAppraiseHistories paramEidAppraiseHistories);
  
  public abstract void insertEidAppraiseHistories(EidAppraiseHistories paramEidAppraiseHistories);
  
  public abstract void updateEidAppraiseHistories(EidAppraiseHistories paramEidAppraiseHistories);
  
  public abstract void insertEidAppraiseHistoriess(List<EidAppraiseHistories> paramList);
  
  public abstract void removeEidAppraiseHistoriess(List<EidAppraiseHistories> paramList);
  
  public abstract void updateEidAppraiseHistoriess(List<EidAppraiseHistories> paramList);
  
  public abstract Long findEmployeeByNum(String paramString);
  
  public abstract PageInfo findAppraiseHistoriesVLByQry(EidAppraiseHistoryV paramEidAppraiseHistoryV, int paramInt1, int paramInt2, String paramString);
  
  public abstract List<EidAppraiseHistoryV> findHistoryVByImageNumber(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IEidAppraiseHistoriesDAO
 * JD-Core Version:    0.7.0.1
 */