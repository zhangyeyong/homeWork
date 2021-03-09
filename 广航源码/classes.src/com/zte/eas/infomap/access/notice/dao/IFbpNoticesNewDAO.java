package com.zte.eas.infomap.access.notice.dao;

import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpNoticesNewDAO
  extends DAO
{
  public abstract FbpNoticesNew getFbpNoticesNew(Long paramLong);
  
  public abstract List<FbpNoticesNew> findFbpNoticesNews();
  
  public abstract List<FbpNoticesNew> getFbpNoticesNews(int paramInt1, int paramInt2);
  
  public abstract List<FbpNoticesNew> getFbpNoticesNews();
  
  public abstract void removeFbpNoticesNew(Long paramLong);
  
  public abstract void removeFbpNoticesNew(FbpNoticesNew paramFbpNoticesNew);
  
  public abstract void insertFbpNoticesNew(FbpNoticesNew paramFbpNoticesNew);
  
  public abstract void updateFbpNoticesNew(FbpNoticesNew paramFbpNoticesNew);
  
  public abstract void insertFbpNoticesNews(List<FbpNoticesNew> paramList);
  
  public abstract void removeFbpNoticesNews(List<FbpNoticesNew> paramList);
  
  public abstract void updateFbpNoticesNews(List<FbpNoticesNew> paramList);
  
  public abstract List<FbpNoticesNew> getTestFbpNoticesNews(String paramString);
  
  public abstract List<Long> getFbpNoticesNewEmpId(Long paramLong, String paramString);
  
  public abstract List<FbpNoticesNew> findFbpNoticesNewsPw();
  
  public abstract List<FbpNoticesNew> findFbpNoticesNewsPerson();
  
  public abstract List<FbpNoticesNew> findFbpNoticesNewsApprove();
  
  public abstract List<FbpNoticesNew> findFbpNoticesNewsErpImpError();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.access.notice.dao.IFbpNoticesNewDAO
 * JD-Core Version:    0.7.0.1
 */