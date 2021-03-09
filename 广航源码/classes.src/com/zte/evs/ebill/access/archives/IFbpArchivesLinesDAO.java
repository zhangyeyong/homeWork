package com.zte.evs.ebill.access.archives;

import com.zte.evs.ebill.model.archives.FbpArchivesLines;
import com.zte.evs.ebill.model.archives.FbpArchivesLinesV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpArchivesLinesDAO
  extends DAO
{
  public abstract PageInfo findFbpArchivesLinesV(FbpArchivesLinesV paramFbpArchivesLinesV, int paramInt1, int paramInt2);
  
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
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.archives.IFbpArchivesLinesDAO
 * JD-Core Version:    0.7.0.1
 */