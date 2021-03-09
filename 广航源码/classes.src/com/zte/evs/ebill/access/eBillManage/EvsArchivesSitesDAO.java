package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsArchivesSites;
import com.zte.evs.ebill.model.eBillManage.EvsArchivesSitesV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EvsArchivesSitesDAO
  extends BaseDAO
  implements IEvsArchivesSitesDAO
{
  private static final Log log = LogFactory.getLog(EvsBookDAO.class);
  
  public Map findArchivesSitesVByQry(EvsArchivesSitesV paramEvsArchivesSitesV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("FROM EvsArchivesSitesV a WHERE 1=1");
    if (!Util.isStrEmpty(paramEvsArchivesSitesV.getArchivesSiteCode())) {
      localStringBuffer.append(" AND upper(a.archivesSiteCode) LIKE '%" + paramEvsArchivesSitesV.getArchivesSiteCode().toUpperCase() + "%'");
    }
    if (!Util.isStrEmpty(paramEvsArchivesSitesV.getArchivesSiteName())) {
      localStringBuffer.append(" AND a.archivesSiteName LIKE '%" + paramEvsArchivesSitesV.getArchivesSiteName() + "%'");
    }
    if (!Util.isStrEmpty(paramEvsArchivesSitesV.getCheckUnit()))
    {
      localStringBuffer.append(" AND a.checkUnit = ?");
      localArrayList.add(paramEvsArchivesSitesV.getCheckUnit());
    }
    if (!Util.isStrEmpty(paramEvsArchivesSitesV.getEnabledFlag()))
    {
      localStringBuffer.append(" AND a.enabledFlag = ?");
      localArrayList.add(paramEvsArchivesSitesV.getEnabledFlag());
    }
    localStringBuffer.append(" ORDER BY a.archivesSiteCode ASC");
    System.out.println(localStringBuffer.toString());
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public EvsArchivesSitesV findArchivesSitesVById(Long paramLong)
  {
    EvsArchivesSitesV localEvsArchivesSitesV = null;
    log.debug("find EvsArchivesSites instance");
    try
    {
      String str = "FROM EvsArchivesSitesV e where e.archivesSiteId = " + paramLong;
      Query localQuery = getSession().createQuery(str);
      List localList = localQuery.list();
      Iterator localIterator = localList.iterator();
      if ((localIterator != null) && (!"".equals(localIterator))) {
        while (localIterator.hasNext()) {
          localEvsArchivesSitesV = (EvsArchivesSitesV)localIterator.next();
        }
      }
      log.debug("find successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("find failed", localRuntimeException);
      throw localRuntimeException;
    }
    return localEvsArchivesSitesV;
  }
  
  public EvsArchivesSites findArchivesSitesById(Long paramLong)
  {
    EvsArchivesSites localEvsArchivesSites = null;
    log.debug("find EvsArchivesSites instance");
    try
    {
      String str = "FROM EvsArchivesSites e where e.archivesSiteId = " + paramLong;
      Query localQuery = getSession().createQuery(str);
      List localList = localQuery.list();
      Iterator localIterator = localList.iterator();
      if ((localIterator != null) && (!"".equals(localIterator))) {
        while (localIterator.hasNext()) {
          localEvsArchivesSites = (EvsArchivesSites)localIterator.next();
        }
      }
      log.debug("find successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("find failed", localRuntimeException);
      throw localRuntimeException;
    }
    return localEvsArchivesSites;
  }
  
  public int getCountByCode(String paramString)
  {
    int i = 0;
    paramString = paramString.replace("'", "''");
    String str = "select count(s.ARCHIVES_SITE_ID) from EVS_ARCHIVES_SITES s where s.ARCHIVES_SITE_CODE ='" + paramString + "'";
    List localList = super.getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public int getCountByName(String paramString)
  {
    int i = 0;
    paramString = paramString.replace("'", "''");
    String str = "select count(s.ARCHIVES_SITE_ID) from EVS_ARCHIVES_SITES s where s.ARCHIVES_SITE_NAME ='" + paramString + "'";
    List localList = super.getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public boolean canEmploySiteById(Long paramLong)
  {
    boolean bool = false;
    String str = "select s.ARCHIVES_SITE_ID from EVS_ARCHIVES_SITES s where s.ENABLED_FLAG = 'Y' AND s.ARCHIVES_SITE_ID = " + paramLong;
    List localList = super.getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      bool = true;
    }
    return bool;
  }
  
  public void update(EvsArchivesSites paramEvsArchivesSites)
  {
    log.debug("update EvsArchivesSites archivesSites");
    try
    {
      super.updateObject(paramEvsArchivesSites);
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void save(EvsArchivesSites paramEvsArchivesSites)
  {
    log.debug("saving EvsArchivesSites instance");
    try
    {
      super.insertObject(paramEvsArchivesSites);
      log.debug("save successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("save failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsArchivesSitesDAO
 * JD-Core Version:    0.7.0.1
 */