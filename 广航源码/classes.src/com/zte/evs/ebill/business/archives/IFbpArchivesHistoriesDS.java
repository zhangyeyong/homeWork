package com.zte.evs.ebill.business.archives;

import com.zte.evs.ebill.model.archives.FbpArchivesHistories;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpArchivesHistoriesDS
  extends DomainService
{
  public abstract TableDataInfo findFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories, int paramInt1, int paramInt2);
  
  public abstract FbpArchivesHistories getFbpArchivesHistories(Long paramLong);
  
  public abstract List<FbpArchivesHistories> getFbpArchivesHistoriess(int paramInt1, int paramInt2);
  
  public abstract List<FbpArchivesHistories> getFbpArchivesHistoriess();
  
  public abstract void removeFbpArchivesHistories(Long paramLong);
  
  public abstract void removeFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories);
  
  public abstract void insertFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories);
  
  public abstract void updateFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories);
  
  public abstract void insertFbpArchivesHistoriess(List<FbpArchivesHistories> paramList);
  
  public abstract void removeFbpArchivesHistoriess(List<FbpArchivesHistories> paramList);
  
  public abstract void updateFbpArchivesHistoriess(List<FbpArchivesHistories> paramList);
  
  public abstract List<FbpArchivesHistories> findFbpArchivesHistories(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.archives.IFbpArchivesHistoriesDS
 * JD-Core Version:    0.7.0.1
 */