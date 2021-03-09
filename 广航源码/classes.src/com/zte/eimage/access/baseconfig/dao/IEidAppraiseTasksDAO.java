package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidAppraiseTasks;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IEidAppraiseTasksDAO
  extends DAO
{
  public abstract EidAppraiseTasks getEidAppraiseTasks(Long paramLong);
  
  public abstract List<EidAppraiseTasks> getEidAppraiseTaskss(int paramInt1, int paramInt2);
  
  public abstract List<EidAppraiseTasks> getEidAppraiseTaskss(String paramString);
  
  public abstract List<Object[]> findAppraiseTask(String paramString, Long paramLong1, Long paramLong2);
  
  public abstract List<EidAppraiseTasks> getEidAppraiseTaskss();
  
  public abstract void removeEidAppraiseTasks(Long paramLong);
  
  public abstract void removeEidAppraiseTasks(EidAppraiseTasks paramEidAppraiseTasks);
  
  public abstract void insertEidAppraiseTasks(EidAppraiseTasks paramEidAppraiseTasks);
  
  public abstract void updateEidAppraiseTasks(EidAppraiseTasks paramEidAppraiseTasks);
  
  public abstract void insertEidAppraiseTaskss(List<EidAppraiseTasks> paramList);
  
  public abstract void removeEidAppraiseTaskss(List<EidAppraiseTasks> paramList);
  
  public abstract void updateEidAppraiseTaskss(List<EidAppraiseTasks> paramList);
  
  public abstract EidAppraiseTasks findEidAppraiseTasksByImageNum(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IEidAppraiseTasksDAO
 * JD-Core Version:    0.7.0.1
 */