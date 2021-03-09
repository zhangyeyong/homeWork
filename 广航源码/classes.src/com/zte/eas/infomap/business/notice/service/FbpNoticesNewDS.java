package com.zte.eas.infomap.business.notice.service;

import com.zte.eas.infomap.access.notice.dao.IFbpNoticesNewDAO;
import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.ssb.framework.base.BaseDomainService;
import java.util.List;

public class FbpNoticesNewDS
  extends BaseDomainService
  implements IFbpNoticesNewDS
{
  private IFbpNoticesNewDAO fbpNoticesNewDAO;
  
  public List<FbpNoticesNew> getFbpNoticesNews(int paramInt1, int paramInt2)
  {
    return this.fbpNoticesNewDAO.getFbpNoticesNews(paramInt1, paramInt2);
  }
  
  public List<FbpNoticesNew> getTestFbpNoticesNews(String paramString)
  {
    return this.fbpNoticesNewDAO.getTestFbpNoticesNews(paramString);
  }
  
  public List<FbpNoticesNew> findFbpNoticesNews()
  {
    return this.fbpNoticesNewDAO.findFbpNoticesNews();
  }
  
  public List<FbpNoticesNew> getFbpNoticesNews()
  {
    return this.fbpNoticesNewDAO.getFbpNoticesNews();
  }
  
  public FbpNoticesNew getFbpNoticesNew(Long paramLong)
  {
    return this.fbpNoticesNewDAO.getFbpNoticesNew(paramLong);
  }
  
  public void removeFbpNoticesNew(Long paramLong)
  {
    this.fbpNoticesNewDAO.removeFbpNoticesNew(paramLong);
  }
  
  public void removeFbpNoticesNew(FbpNoticesNew paramFbpNoticesNew)
  {
    this.fbpNoticesNewDAO.removeFbpNoticesNew(paramFbpNoticesNew);
  }
  
  public void insertFbpNoticesNew(FbpNoticesNew paramFbpNoticesNew)
  {
    this.fbpNoticesNewDAO.insertFbpNoticesNew(paramFbpNoticesNew);
  }
  
  public void updateFbpNoticesNew(FbpNoticesNew paramFbpNoticesNew)
  {
    this.fbpNoticesNewDAO.updateFbpNoticesNew(paramFbpNoticesNew);
  }
  
  public void insertFbpNoticesNews(List<FbpNoticesNew> paramList)
  {
    this.fbpNoticesNewDAO.insertFbpNoticesNews(paramList);
  }
  
  public void removeFbpNoticesNews(List<FbpNoticesNew> paramList)
  {
    this.fbpNoticesNewDAO.removeFbpNoticesNews(paramList);
  }
  
  public void updateFbpNoticesNews(List<FbpNoticesNew> paramList)
  {
    this.fbpNoticesNewDAO.updateFbpNoticesNews(paramList);
  }
  
  public IFbpNoticesNewDAO getFbpNoticesNewDAO()
  {
    return this.fbpNoticesNewDAO;
  }
  
  public void setFbpNoticesNewDAO(IFbpNoticesNewDAO paramIFbpNoticesNewDAO)
  {
    this.fbpNoticesNewDAO = paramIFbpNoticesNewDAO;
  }
  
  public List<Long> getFbpNoticesNewEmpId(Long paramLong, String paramString)
  {
    return this.fbpNoticesNewDAO.getFbpNoticesNewEmpId(paramLong, paramString);
  }
  
  public List<FbpNoticesNew> findFbpNoticesNewsPw()
  {
    return this.fbpNoticesNewDAO.findFbpNoticesNewsPw();
  }
  
  public List<FbpNoticesNew> findFbpNoticesNewsPerson()
  {
    return this.fbpNoticesNewDAO.findFbpNoticesNewsPerson();
  }
  
  public List<FbpNoticesNew> findFbpNoticesNewsApprove()
  {
    return this.fbpNoticesNewDAO.findFbpNoticesNewsApprove();
  }
  
  public List<FbpNoticesNew> findFbpNoticesNewsErpImpError()
  {
    return this.fbpNoticesNewDAO.findFbpNoticesNewsErpImpError();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.FbpNoticesNewDS
 * JD-Core Version:    0.7.0.1
 */