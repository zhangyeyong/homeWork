package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsAllotRelations;
import com.zte.evs.ebill.model.eBillManage.EvsAllotRelationsV;
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

public class EvsAllotRelationsDAO
  extends BaseDAO
  implements IEvsAllotRelationsDAO
{
  private static final Log log = LogFactory.getLog(EvsBookDAO.class);
  
  public Map findAllotRelationsVByQry(EvsAllotRelationsV paramEvsAllotRelationsV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("FROM EvsAllotRelationsV a WHERE 1=1");
    if (!Util.isStrEmpty(paramEvsAllotRelationsV.getAllotTypeCode())) {
      localStringBuffer.append(" AND upper(a.allotTypeCode) LIKE '%" + paramEvsAllotRelationsV.getAllotTypeCode().toUpperCase() + "%'");
    }
    if (!Util.isStrEmpty(paramEvsAllotRelationsV.getAllotTypeName())) {
      localStringBuffer.append(" AND a.allotTypeName LIKE '%" + paramEvsAllotRelationsV.getAllotTypeName().trim() + "%'");
    }
    if (!Util.isStrEmpty(paramEvsAllotRelationsV.getSourceCheckUnit()))
    {
      localStringBuffer.append(" AND a.sourceCheckUnit = ?");
      localArrayList.add(paramEvsAllotRelationsV.getSourceCheckUnit());
    }
    if (!Util.isStrEmpty(paramEvsAllotRelationsV.getStoreCheckUnit()))
    {
      localStringBuffer.append(" AND a.storeCheckUnit = ?");
      localArrayList.add(paramEvsAllotRelationsV.getStoreCheckUnit());
    }
    if (!Util.isNullObject(paramEvsAllotRelationsV.getArchivesSiteId()))
    {
      localStringBuffer.append(" AND a.archivesSiteId = ?");
      localArrayList.add(paramEvsAllotRelationsV.getArchivesSiteId());
    }
    if (!Util.isStrEmpty(paramEvsAllotRelationsV.getAllotWay()))
    {
      localStringBuffer.append(" AND a.allotWay = ?");
      localArrayList.add(paramEvsAllotRelationsV.getAllotWay());
    }
    if (!Util.isStrEmpty(paramEvsAllotRelationsV.getEnabledFlag()))
    {
      localStringBuffer.append(" AND a.enabledFlag = ?");
      localArrayList.add(paramEvsAllotRelationsV.getEnabledFlag());
    }
    localStringBuffer.append(" ORDER BY a.allotTypeCode ASC");
    System.out.println(localStringBuffer.toString());
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public EvsAllotRelationsV findAllotRelationsVById(Long paramLong)
  {
    EvsAllotRelationsV localEvsAllotRelationsV = new EvsAllotRelationsV();
    log.debug("find EvsAllotRelations instance");
    try
    {
      String str = "FROM EvsAllotRelationsV e where e.allotRelationId = " + paramLong;
      Query localQuery = getSession().createQuery(str);
      List localList = localQuery.list();
      Iterator localIterator = localList.iterator();
      if ((localIterator != null) && (!"".equals(localIterator))) {
        while (localIterator.hasNext()) {
          localEvsAllotRelationsV = (EvsAllotRelationsV)localIterator.next();
        }
      }
      log.debug("find successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("find failed", localRuntimeException);
      throw localRuntimeException;
    }
    return localEvsAllotRelationsV;
  }
  
  public EvsAllotRelations findAllotRelationsById(Long paramLong)
  {
    EvsAllotRelations localEvsAllotRelations = new EvsAllotRelations();
    log.debug("find EvsAllotRelations instance");
    try
    {
      String str = "FROM EvsAllotRelations e where e.allotRelationId = " + paramLong;
      Query localQuery = getSession().createQuery(str);
      List localList = localQuery.list();
      Iterator localIterator = localList.iterator();
      if ((localIterator != null) && (!"".equals(localIterator))) {
        while (localIterator.hasNext()) {
          localEvsAllotRelations = (EvsAllotRelations)localIterator.next();
        }
      }
      log.debug("find successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("find failed", localRuntimeException);
      throw localRuntimeException;
    }
    return localEvsAllotRelations;
  }
  
  public int getCountByTerm(Long paramLong1, Long paramLong2, String paramString1, String paramString2, Long paramLong3)
  {
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    paramString1 = paramString1.replace("'", "''");
    paramString2 = paramString2.replace("'", "''");
    localStringBuffer.append("select count(s.ALLOT_RELATION_ID) from EVS_ALLOT_RELATIONS s WHERE s.ALLOT_TYPE_ID = " + paramLong2 + " AND s.SOURCE_CHECK_UNIT ='" + paramString1 + "'" + " AND s.STORE_CHECK_UNIT ='" + paramString2 + "'" + " AND s.ARCHIVES_SITE_ID =" + paramLong3);
    if ((paramLong1 != null) && (!paramLong1.equals(""))) {
      localStringBuffer.append(" AND s.ALLOT_RELATION_ID NOT IN " + paramLong1);
    }
    List localList = super.getSession().createSQLQuery(localStringBuffer.toString()).list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public int getCountByTypeId(Long paramLong)
  {
    int i = 0;
    String str = "select count(s.ALLOT_RELATION_ID) from EVS_ALLOT_RELATIONS s WHERE s.ALLOT_TYPE_ID = " + paramLong + " AND s.ENABLED_FLAG = 'Y'";
    List localList = super.getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public int getCountBySiteId(Long paramLong)
  {
    int i = 0;
    String str = "select count(s.ALLOT_RELATION_ID) from EVS_ALLOT_RELATIONS s WHERE s.ARCHIVES_SITE_ID = " + paramLong + " AND s.ENABLED_FLAG = 'Y'";
    List localList = super.getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public void update(EvsAllotRelations paramEvsAllotRelations)
  {
    log.debug("update EvsAllotRelations allotRelation");
    try
    {
      super.updateObject(paramEvsAllotRelations);
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void save(EvsAllotRelations paramEvsAllotRelations)
  {
    log.debug("saving EvsAllotRelations instance");
    try
    {
      super.insertObject(paramEvsAllotRelations);
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
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsAllotRelationsDAO
 * JD-Core Version:    0.7.0.1
 */