package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsSubDocType;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocTypeV;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocTypeVo;
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

public class EvsSubDocTypeDAO
  extends BaseDAO
  implements IEvsSubDocTypeDAO
{
  private static final Log log = LogFactory.getLog(EvsDocTypeDAO.class);
  
  public List<EvsSubDocType> findSubDocTypeForSelect()
  {
    return getSession().createQuery("FROM EvsSubDocType s WHERE s.enabledFlag='Y'").list();
  }
  
  public String save(EvsSubDocType paramEvsSubDocType)
  {
    int i = getCount(paramEvsSubDocType.getSubDocCode());
    if (i > 0)
    {
      log.error("该数据编号已经存在");
      return "1";
    }
    i = getCountName(paramEvsSubDocType.getSubDocName());
    if (i > 0)
    {
      log.error("该数据编号已经存在");
      return "2";
    }
    getSession().save(paramEvsSubDocType);
    return "0";
  }
  
  public int getCount(String paramString)
  {
    int i = 0;
    paramString = paramString.replace("'", "''");
    List localList = super.getSession().createSQLQuery("select count(*) from EVS_SUB_DOC_TYPE s where s.SUB_DOC_CODE ='" + paramString + "'").list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public int getCountByDocId(Long paramLong)
  {
    int i = 0;
    List localList = super.getSession().createSQLQuery("select count(*) from EVS_SUB_DOC_TYPE s where s.DOC_ID =" + paramLong).list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public int getCountName(String paramString)
  {
    int i = 0;
    paramString = paramString.replace("'", "''");
    List localList = super.getSession().createSQLQuery("select count(*) from EVS_SUB_DOC_TYPE s where s.SUB_DOC_NAME ='" + paramString + "'").list();
    if ((localList != null) && (localList.size() > 0)) {
      i = Integer.parseInt(localList.get(0).toString());
    }
    return i;
  }
  
  public void update(EvsSubDocType paramEvsSubDocType)
  {
    getSession().update(paramEvsSubDocType);
  }
  
  public EvsSubDocType findById(Long paramLong)
  {
    return (EvsSubDocType)super.getObject(EvsSubDocType.class, paramLong);
  }
  
  public Map findSubDocTypeByQry(EvsSubDocTypeVo paramEvsSubDocTypeVo, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append("from EvsSubDocTypeV as s where 1=1");
    if (!Util.isStrEmpty(paramEvsSubDocTypeVo.getSubDocName()))
    {
      localStringBuffer.append(" AND s.subDocName like ?");
      localArrayList.add("%" + paramEvsSubDocTypeVo.getSubDocName() + "%");
    }
    if (!Util.isStrEmpty(paramEvsSubDocTypeVo.getSubDocCode()))
    {
      localStringBuffer.append(" AND UPPER(s.subDocCode) like ?");
      localArrayList.add("%" + paramEvsSubDocTypeVo.getSubDocCode().toUpperCase() + "%");
    }
    if (!Util.isStrEmpty(paramEvsSubDocTypeVo.getDeadline()))
    {
      localStringBuffer.append(" AND s.deadline = ?");
      localArrayList.add(paramEvsSubDocTypeVo.getDeadline());
    }
    if (!Util.isStrEmpty(paramEvsSubDocTypeVo.getEnabledFlag()))
    {
      localStringBuffer.append(" AND s.enabledFlag = ?");
      localArrayList.add(paramEvsSubDocTypeVo.getEnabledFlag());
    }
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public String findSubDocTypeByNum(String paramString)
  {
    String str1 = null;
    String str2 = "from EvsSubDocType doc where doc.sequenceNumber = " + Long.parseLong(paramString) + "";
    List localList = getSession().createQuery(str2).list();
    if ((localList != null) && (localList.size() > 0)) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    return str1;
  }
  
  public String getMaxNumber()
  {
    String str1 = null;
    String str2 = " select max(doc.sequence_number) from evs_sub_doc_type doc";
    List localList = getSession().createSQLQuery(str2).list();
    if ((localList != null) && (localList.size() > 0)) {
      str1 = localList.get(0).toString();
    }
    return str1;
  }
  
  public EvsSubDocTypeV findSubDocTypeByNumber(String paramString)
  {
    EvsSubDocTypeV localEvsSubDocTypeV = null;
    String str = "from EvsSubDocTypeV doc where doc.sequenceNumber = " + Long.parseLong(paramString) + "";
    List localList = getSession().createQuery(str).list();
    localEvsSubDocTypeV = localList.size() > 0 ? (EvsSubDocTypeV)localList.get(0) : null;
    return localEvsSubDocTypeV;
  }
  
  public void updateSequenceNumberBySubDocId(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("update evs_sub_doc_type doc set doc.sequence_number = " + Long.parseLong(paramString1) + "");
    localStringBuffer.append(" where doc.sub_doc_id = " + Long.parseLong(paramString2) + "");
    getSession().createSQLQuery(localStringBuffer.toString()).executeUpdate();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsSubDocTypeDAO
 * JD-Core Version:    0.7.0.1
 */