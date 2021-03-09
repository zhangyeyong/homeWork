package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsDocTypeMap;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.List;

public class EvsDocTypeMapDAO
  extends BaseDAO
  implements IEvsDocTypeMapDAO
{
  public void save(EvsDocTypeMap paramEvsDocTypeMap)
  {
    super.getSession().save(paramEvsDocTypeMap);
  }
  
  public List findEvsDocTypeMapBySubDocId(Long paramLong)
  {
    return super.getSession().createQuery(" from EvsDocTypeMap s where s.subDocId =" + paramLong + " order by s.typeCode").list();
  }
  
  public void remove(Long paramLong)
  {
    super.getSession().createSQLQuery("delete from EVS_DOC_TYPE_MAP s where s.SUB_DOC_ID =" + paramLong).executeUpdate();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsDocTypeMapDAO
 * JD-Core Version:    0.7.0.1
 */