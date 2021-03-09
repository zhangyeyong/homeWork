package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidSites;
import com.zte.eimage.business.baseconfig.model.Site;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface ISiteDao
{
  public abstract void insertSite(Site paramSite);
  
  public abstract Site getSiteById(Integer paramInteger);
  
  public abstract Object findSiteBySql(String paramString);
  
  public abstract void updateSite(Site paramSite);
  
  public abstract List<Site> getAllSite();
  
  public abstract List<Site> getAllSite(String paramString);
  
  public abstract PageInfo findSite(Site paramSite, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Integer getCount(String paramString);
  
  public abstract Site findSiteByEmployeeId(Long paramLong);
  
  public abstract EidSites findSiteByCompanyId(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.ISiteDao
 * JD-Core Version:    0.7.0.1
 */