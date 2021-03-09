package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsDocType;
import com.zte.evs.ebill.model.eBillManage.EvsDocTypeVo;
import com.zte.evs.ebill.model.eBillManage.FbfLookupValues;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EvsDocTypeDAO
  extends BaseDAO
  implements IEvsDocTypeDAO
{
  private static final Log log = LogFactory.getLog(EvsDocTypeDAO.class);
  
  public String save(EvsDocType paramEvsDocType)
  {
    log.debug("saving EvsDocType instance");
    try
    {
      int i = getCount(paramEvsDocType.getDocCode());
      if (i > 0)
      {
        log.error("该数据编号已经存在");
        return "1";
      }
      i = getCountName(paramEvsDocType.getDocName());
      if (i > 0)
      {
        log.error("该名称已经存在");
        return "2";
      }
      getSession().save(paramEvsDocType);
      log.debug("save successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("save failed", localRuntimeException);
      throw localRuntimeException;
    }
    return "0";
  }
  
  public void update(EvsDocType paramEvsDocType)
  {
    log.debug("update EvsDocType evsDocType");
    try
    {
      getSession().update(paramEvsDocType);
      log.debug("update successful");
    }
    catch (RuntimeException localRuntimeException)
    {
      log.error("update failed", localRuntimeException);
      throw localRuntimeException;
    }
  }
  
  public EvsDocType findById(Long paramLong)
  {
    log.debug("getting EvsDocType instance with id: " + paramLong);
    return (EvsDocType)super.getObject(EvsDocType.class, paramLong);
  }
  
  public int getCount(String paramString)
  {
    int i = 0;
    paramString = paramString.replace("'", "''");
    List localList = super.getSession().createSQLQuery("select count(*) from EVS_DOC_TYPE s where s.DOC_CODE ='" + paramString + "'").list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public int getCountName(String paramString)
  {
    int i = 0;
    paramString = paramString.replace("'", "''");
    List localList = super.getSession().createSQLQuery("select count(*) from EVS_DOC_TYPE s where s.DOC_NAME ='" + paramString + "'").list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public Map findDocTypeByQry(EvsDocTypeVo paramEvsDocTypeVo, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsDocTypeV as b where 1=1");
    if (!Util.isStrEmpty(paramEvsDocTypeVo.getDocCode()))
    {
      localStringBuffer.append(" AND UPPER(b.docCode) like ?");
      localArrayList.add("%" + paramEvsDocTypeVo.getDocCode().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsDocTypeVo.getDocName()))
    {
      localStringBuffer.append(" AND b.docName like ?");
      localArrayList.add("%" + paramEvsDocTypeVo.getDocName() + "%");
    }
    if (!Util.isStrEmpty(paramEvsDocTypeVo.getDocDeadline()))
    {
      localStringBuffer.append(" AND b.docDeadline = ?");
      localArrayList.add(paramEvsDocTypeVo.getDocDeadline());
    }
    if (!Util.isStrEmpty(paramEvsDocTypeVo.getEnabledFlag()))
    {
      localStringBuffer.append(" AND b.enabledFlag = ?");
      localArrayList.add(paramEvsDocTypeVo.getEnabledFlag());
    }
    localStringBuffer.append("  order by docId");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public List<EvsDocType> findDocTypeForSelect()
  {
    return getSession().createQuery("FROM EvsDocType b WHERE b.enabledFlag='Y'").list();
  }
  
  public List findDocTypeForDeadline()
  {
    List localList = super.getSession().createSQLQuery("select t.lookup_code || ',' || t.meaning from  FBP_LOOKUP_VALUES t where t.LOOKUP_TYPE='EVS_DOC_DEADLINE' and t.language=ZAS_ENV_PKG.getLang() and t.enabled_flag='Y'").list();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {
      for (int i = 0; i < localList.size(); i++)
      {
        FbfLookupValues localFbfLookupValues = new FbfLookupValues();
        String str = localList.get(i).toString();
        localFbfLookupValues.setLookupCode(str.split(",")[0]);
        localFbfLookupValues.setMeaning(str.split(",")[1]);
        localArrayList.add(localFbfLookupValues);
      }
    }
    return localArrayList;
  }
  
  public String findDeadline(String paramString)
  {
    String str = paramString;
    List localList1 = super.getSession().createSQLQuery("select t.meaning from  FBP_LOOKUP_VALUES t where t.LOOKUP_TYPE='EVS_DOC_DEADLINE' and t.language=ZAS_ENV_PKG.getLang() and t.enabled_flag='Y'" + (!"".equals(paramString) ? " and t.lookup_code='" + paramString + "'" : "")).list();
    if ((localList1 != null) && (localList1.size() > 0))
    {
      str = localList1.get(0).toString();
    }
    else
    {
      List localList2 = super.getSession().createSQLQuery("select t.meaning from  FBP_LOOKUP_VALUES t where t.LOOKUP_TYPE='EVS_DOC_DEADLINE' and t.language=ZAS_ENV_PKG.getLang() and t.enabled_flag='N'" + (!"".equals(paramString) ? " and t.lookup_code='" + paramString + "'" : "")).list();
      if ((localList2 != null) && (localList2.size() > 0)) {
        str = localList2.get(0).toString();
      }
    }
    return str;
  }
  
  private List<FbfLookupValues> List()
  {
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsDocTypeDAO
 * JD-Core Version:    0.7.0.1
 */