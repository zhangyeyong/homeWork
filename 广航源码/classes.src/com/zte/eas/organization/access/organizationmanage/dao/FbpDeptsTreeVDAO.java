package com.zte.eas.organization.access.organizationmanage.dao;

import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.List;

public class FbpDeptsTreeVDAO
  extends BaseDAO
  implements IFbpDeptsTreeVDAO
{
  public List findDownDeptsVl(BigInteger paramBigInteger, String paramString)
  {
    if ("Y".equals(paramString)) {
      return getSession().createQuery("from FbpDeptsTreeV b where b.parentDeptId =:deptId order by b.deptCode").setBigInteger("deptId", paramBigInteger).list();
    }
    return getSession().createQuery("from FbpDeptsTreeV b where b.parentDeptId =:deptId and b.enabledFlag =:enabledFlag order by b.deptCode").setBigInteger("deptId", paramBigInteger).setString("enabledFlag", "Y").list();
  }
  
  public List findAllDeptsVl(String paramString)
  {
    if ("Y".equals(paramString)) {
      return getSession().createQuery("FROM FbpDeptsTreeV b order by b.deptCode ").list();
    }
    return getSession().createQuery("FROM FbpDeptsTreeV b WHERE b.enabledFlag =:enabledFlag order by b.deptCode ").setString("enabledFlag", "Y").list();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.organizationmanage.dao.FbpDeptsTreeVDAO
 * JD-Core Version:    0.7.0.1
 */