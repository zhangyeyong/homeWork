package com.zte.evs.ebill.business.archives;

import com.zte.evs.ebill.model.archives.FbpArchivesLines;
import com.zte.evs.ebill.model.archives.FbpArchivesLinesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpArchivesLinesDS
  extends DomainService
{
  public abstract TableDataInfo findFbpArchivesLinesV(FbpArchivesLinesV paramFbpArchivesLinesV, int paramInt1, int paramInt2);
  
  public abstract FbpArchivesLines getFbpArchivesLines(Long paramLong);
  
  public abstract List<FbpArchivesLines> getFbpArchivesLiness(int paramInt1, int paramInt2);
  
  public abstract List<FbpArchivesLines> getFbpArchivesLiness();
  
  public abstract void removeFbpArchivesLines(Long paramLong);
  
  public abstract void removeFbpArchivesLines(FbpArchivesLines paramFbpArchivesLines);
  
  public abstract void insertFbpArchivesLines(FbpArchivesLines paramFbpArchivesLines);
  
  public abstract void updateFbpArchivesLines(FbpArchivesLines paramFbpArchivesLines);
  
  public abstract void insertFbpArchivesLiness(List<FbpArchivesLines> paramList);
  
  public abstract void removeFbpArchivesLiness(List<FbpArchivesLines> paramList);
  
  public abstract void updateFbpArchivesLiness(List<FbpArchivesLines> paramList);
  
  public abstract List<FbpArchivesLinesV> findFbpArchivesLinessV(Long paramLong);
  
  public abstract TableDataInfo getFbpArchivesLinesByHeardId(FbpArchivesLinesV paramFbpArchivesLinesV, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.archives.IFbpArchivesLinesDS
 * JD-Core Version:    0.7.0.1
 */