package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidAppraiseHistoriesV;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IEidAppraiseHistoriesVDAO
  extends DAO
{
  public abstract EidAppraiseHistoriesV getEidAppraiseHistoriesV(Long paramLong);
  
  public abstract List<EidAppraiseHistoriesV> getEidAppraiseHistoriesVs(int paramInt1, int paramInt2);
  
  public abstract List<EidAppraiseHistoriesV> getEidAppraiseHistoriesVs();
  
  public abstract void removeEidAppraiseHistoriesV(Long paramLong);
  
  public abstract void removeEidAppraiseHistoriesV(EidAppraiseHistoriesV paramEidAppraiseHistoriesV);
  
  public abstract void insertEidAppraiseHistoriesV(EidAppraiseHistoriesV paramEidAppraiseHistoriesV);
  
  public abstract void updateEidAppraiseHistoriesV(EidAppraiseHistoriesV paramEidAppraiseHistoriesV);
  
  public abstract void insertEidAppraiseHistoriesVs(List<EidAppraiseHistoriesV> paramList);
  
  public abstract void removeEidAppraiseHistoriesVs(List<EidAppraiseHistoriesV> paramList);
  
  public abstract void updateEidAppraiseHistoriesVs(List<EidAppraiseHistoriesV> paramList);
  
  public abstract List<EidAppraiseHistoriesV> findHistoryByImageInfoId(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IEidAppraiseHistoriesVDAO
 * JD-Core Version:    0.7.0.1
 */