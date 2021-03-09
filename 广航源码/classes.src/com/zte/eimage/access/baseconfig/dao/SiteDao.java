package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidSites;
import com.zte.eimage.business.baseconfig.model.Site;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.List;

public class SiteDao
  extends BaseDAO
  implements ISiteDao
{
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertSite(Site paramSite)
  {
    super.insertObject(paramSite);
  }
  
  public Site getSiteById(Integer paramInteger)
  {
    return (Site)super.getObject(Site.class, paramInteger);
  }
  
  public Object findSiteBySql(String paramString)
  {
    Session localSession = super.getSession();
    Query localQuery = localSession.createQuery(paramString);
    return localQuery.uniqueResult();
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateSite(Site paramSite)
  {
    super.updateObject(paramSite);
  }
  
  public List<Site> getAllSite()
  {
    String str = "FROM Site s WHERE s.enabledFlag = 'Y'";
    Session localSession = super.getSession();
    Query localQuery = localSession.createQuery(str);
    List localList = localQuery.list();
    return localList;
  }
  
  public List<Site> getAllSite(String paramString)
  {
    String str = "FROM Site s WHERE s.enabledFlag = 'Y' and s.companyId in(" + paramString + ")";
    Session localSession = super.getSession();
    Query localQuery = localSession.createQuery(str);
    List localList = localQuery.list();
    return localList;
  }
  
  public PageInfo findSite(Site paramSite, Integer paramInteger1, Integer paramInteger2)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "FROM SiteV s WHERE 1=1";
    if (paramSite != null)
    {
      if ((paramSite.getSiteName() != null) && (!"".equals(paramSite.getSiteName().trim())))
      {
        str = str + " AND s.siteName like ?";
        localArrayList.add("%" + paramSite.getSiteName() + "%");
      }
      if ((paramSite.getEnabledFlag() != null) && (!"".equals(paramSite.getEnabledFlag().trim())))
      {
        str = str + " AND s.enabledFlag = ?";
        localArrayList.add(paramSite.getEnabledFlag());
      }
    }
    str = str + " ORDER BY s.siteName";
    paramInteger1 = Integer.valueOf(paramInteger1.intValue() / paramInteger2.intValue() + 1);
    return super.PageInfoQuery(str, paramInteger1.intValue(), paramInteger2.intValue(), localArrayList.toArray());
  }
  
  public Integer getCount(String paramString)
  {
    Integer localInteger = Integer.valueOf(0);
    Session localSession = super.getSession();
    Query localQuery = localSession.createQuery(paramString);
    List localList = localQuery.list();
    if (localList == null) {
      return localInteger;
    }
    localInteger = Integer.valueOf(localList.size());
    return localInteger;
  }
  
  public Site findSiteByEmployeeId(Long paramLong)
  {
    String str = "select st from Site st,FrontUser fu where st.siteId=fu.siteId and fu.employeeId=" + paramLong + " and fu.enabledFlag='Y'";
    List localList = getSession().createQuery(str).list();
    if ((null == localList) || (localList.size() <= 0) || (localList.get(0) == null)) {
      return null;
    }
    return (Site)localList.get(0);
  }
  
  public EidSites findSiteByCompanyId(Long paramLong)
  {
    String str = " from EidSites st where st.companyId= " + paramLong;
    List localList = getSession().createQuery(str).list();
    if ((null == localList) || (localList.size() <= 0) || (localList.get(0) == null)) {
      return null;
    }
    return (EidSites)localList.get(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.SiteDao
 * JD-Core Version:    0.7.0.1
 */