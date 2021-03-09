package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsAllotTypes;
import com.zte.evs.ebill.model.eBillManage.EvsAllotTypesV;
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

public class EvsAllotTypesDAO
  extends BaseDAO
  implements IEvsAllotTypesDAO
{
  private static final Log log = LogFactory.getLog(EvsBookDAO.class);
  
  public Map findAllotTypesVByQry(EvsAllotTypesV paramEvsAllotTypesV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("FROM EvsAllotTypesV a WHERE 1=1");
    if (!Util.isStrEmpty(paramEvsAllotTypesV.getAllotTypeCode())) {
      localStringBuffer.append(" AND upper(a.allotTypeCode) LIKE '%" + paramEvsAllotTypesV.getAllotTypeCode().toUpperCase() + "%'");
    }
    if (!Util.isStrEmpty(paramEvsAllotTypesV.getAllotTypeName())) {
      localStringBuffer.append(" AND a.allotTypeName LIKE '%" + paramEvsAllotTypesV.getAllotTypeName() + "%'");
    }
    if (!Util.isStrEmpty(paramEvsAllotTypesV.getAllotWay()))
    {
      localStringBuffer.append(" AND a.allotWay = ?");
      localArrayList.add(paramEvsAllotTypesV.getAllotWay());
    }
    if (!Util.isStrEmpty(paramEvsAllotTypesV.getEnabledFlag()))
    {
      localStringBuffer.append(" AND a.enabledFlag = ?");
      localArrayList.add(paramEvsAllotTypesV.getEnabledFlag());
    }
    localStringBuffer.append(" ORDER BY a.allotTypeCode ASC");
    System.out.println(localStringBuffer.toString());
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public EvsAllotTypesV findAllotTypeVById(Long paramLong)
  {
    EvsAllotTypesV localEvsAllotTypesV = null;
    log.debug("find EvsAllotTypes instance");
    try
    {
      String str = "FROM EvsAllotTypesV e where e.allotTypeId = " + paramLong;
      Query localQuery = getSession().createQuery(str);
      List localList = localQuery.list();
      Iterator localIterator = localList.iterator();
      if ((localIterator != null) && (!"".equals(localIterator))) {
        while (localIterator.hasNext()) {
          localEvsAllotTypesV = (EvsAllotTypesV)localIterator.next();
        }
      }
      log.debug("find successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("find failed", localRuntimeException);
      throw localRuntimeException;
    }
    return localEvsAllotTypesV;
  }
  
  public EvsAllotTypes findAllotTypeById(Long paramLong)
  {
    EvsAllotTypes localEvsAllotTypes = null;
    log.debug("find EvsAllotTypes instance");
    try
    {
      String str = "FROM EvsAllotTypes e where e.allotTypeId = " + paramLong;
      Query localQuery = getSession().createQuery(str);
      List localList = localQuery.list();
      Iterator localIterator = localList.iterator();
      if ((localIterator != null) && (!"".equals(localIterator))) {
        while (localIterator.hasNext()) {
          localEvsAllotTypes = (EvsAllotTypes)localIterator.next();
        }
      }
      log.debug("find successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("find failed", localRuntimeException);
      throw localRuntimeException;
    }
    return localEvsAllotTypes;
  }
  
  public EvsAllotTypes findAllotTypeByCode(String paramString1, String paramString2)
  {
    EvsAllotTypes localEvsAllotTypes = null;
    if ((paramString1 != null) && (!paramString1.trim().equals("")))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      log.debug("find EvsAllotTypes instance");
      try
      {
        localStringBuffer.append("FROM EvsAllotTypes e where e.allotTypeCode = '" + paramString1.trim() + "'");
        if ((paramString2 != null) && (!paramString2.trim().equals("")))
        {
          localObject = Long.valueOf(Long.parseLong(paramString2.trim()));
          localStringBuffer.append(" AND e.allotTypeId != " + localObject);
        }
        Object localObject = getSession().createQuery(localStringBuffer.toString());
        List localList = ((Query)localObject).list();
        Iterator localIterator = localList.iterator();
        if ((localIterator != null) && (!"".equals(localIterator))) {
          while (localIterator.hasNext()) {
            localEvsAllotTypes = (EvsAllotTypes)localIterator.next();
          }
        }
        log.debug("find successful");
      }
      catch (RuntimeException localRuntimeException)
      {
        log.error("find failed", localRuntimeException);
        throw localRuntimeException;
      }
      return localEvsAllotTypes;
    }
    return null;
  }
  
  public EvsAllotTypes findAllotTypeByName(String paramString1, String paramString2)
  {
    EvsAllotTypes localEvsAllotTypes = null;
    if ((paramString1 != null) && (!paramString1.trim().equals("")))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      log.debug("find EvsAllotTypes instance");
      try
      {
        localStringBuffer.append("FROM EvsAllotTypes e where e.allotTypeCode = '" + paramString1.trim() + "'");
        if ((paramString2 != null) && (!paramString2.trim().equals("")))
        {
          localObject = Long.valueOf(Long.parseLong(paramString2.trim()));
          localStringBuffer.append(" AND e.allotTypeId != " + localObject);
        }
        Object localObject = getSession().createQuery(localStringBuffer.toString());
        List localList = ((Query)localObject).list();
        Iterator localIterator = localList.iterator();
        if ((localIterator != null) && (!"".equals(localIterator))) {
          while (localIterator.hasNext()) {
            localEvsAllotTypes = (EvsAllotTypes)localIterator.next();
          }
        }
        log.debug("find successful");
      }
      catch (RuntimeException localRuntimeException)
      {
        log.error("find failed", localRuntimeException);
        throw localRuntimeException;
      }
      return localEvsAllotTypes;
    }
    return null;
  }
  
  public int getCountByName(String paramString)
  {
    int i = 0;
    paramString = paramString.replace("'", "''");
    String str = "select count(s.ALLOT_TYPE_ID) from EVS_ALLOT_TYPES s where s.ALLOT_TYPE_NAME ='" + paramString + "'";
    List localList = super.getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public int getCountByCode(String paramString)
  {
    int i = 0;
    paramString = paramString.replace("'", "''");
    String str = "select count(s.ALLOT_TYPE_ID) from EVS_ALLOT_TYPES s where s.ALLOT_TYPE_CODE ='" + paramString + "'";
    List localList = super.getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public boolean canEmployTypeById(Long paramLong)
  {
    boolean bool = false;
    String str = "select s.ALLOT_TYPE_ID from EVS_ALLOT_TYPES s where s.ENABLED_FLAG = 'Y' AND s.ALLOT_TYPE_ID = " + paramLong;
    List localList = super.getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      bool = true;
    }
    return bool;
  }
  
  public void update(EvsAllotTypes paramEvsAllotTypes)
  {
    log.debug("update EvsAllotTypes allotType");
    try
    {
      super.updateObject(paramEvsAllotTypes);
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public void save(EvsAllotTypes paramEvsAllotTypes)
  {
    log.debug("saving EvsAllotTypes instance");
    try
    {
      super.insertObject(paramEvsAllotTypes);
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
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsAllotTypesDAO
 * JD-Core Version:    0.7.0.1
 */