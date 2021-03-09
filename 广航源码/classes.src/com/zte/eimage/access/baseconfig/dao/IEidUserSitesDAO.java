package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidUserSites;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IEidUserSitesDAO
  extends DAO
{
  public abstract EidUserSites getEidUserSites(BigInteger paramBigInteger);
  
  public abstract List<EidUserSites> getEidUserSitess(int paramInt1, int paramInt2);
  
  public abstract List<EidUserSites> getEidUserSitess();
  
  public abstract void removeEidUserSites(BigInteger paramBigInteger);
  
  public abstract void removeEidUserSites(EidUserSites paramEidUserSites);
  
  public abstract void insertEidUserSites(EidUserSites paramEidUserSites);
  
  public abstract void updateEidUserSites(EidUserSites paramEidUserSites);
  
  public abstract void insertEidUserSitess(List<EidUserSites> paramList);
  
  public abstract void removeEidUserSitess(List<EidUserSites> paramList);
  
  public abstract void updateEidUserSitess(List<EidUserSites> paramList);
  
  public abstract void removeEidUserSitesByUserId(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IEidUserSitesDAO
 * JD-Core Version:    0.7.0.1
 */