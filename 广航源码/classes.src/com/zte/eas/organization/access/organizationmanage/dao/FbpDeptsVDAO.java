package com.zte.eas.organization.access.organizationmanage.dao;

import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.List;

public class FbpDeptsVDAO
  extends BaseDAO
  implements IFbpDeptsVDAO
{
  public FbpDeptsV findDeptsVById(BigInteger paramBigInteger)
  {
    return (FbpDeptsV)super.getObject(FbpDeptsV.class, paramBigInteger);
  }
  
  public List findDownDeptsV(BigInteger paramBigInteger, String paramString)
  {
    return getSession().createQuery("from FbpDeptsV b where b.parentDeptId =:deptId and b.deptName =:deptName").setBigInteger("deptId", paramBigInteger).setString("deptName", paramString).list();
  }
  
  public List findDownDeptsV(BigInteger paramBigInteger)
  {
    return getSession().createQuery("from FbpDeptsV b where b.parentDeptId =:deptId").setBigInteger("deptId", paramBigInteger).list();
  }
  
  public FbpDeptsV findDeptByCompId(String paramString)
  {
    List localList = getSession().createQuery("from FbpDeptsV b where b.attribute7 =:compId").setString("compId", paramString).list();
    if (localList.size() > 0)
    {
      FbpDeptsV localFbpDeptsV = (FbpDeptsV)localList.get(0);
      return localFbpDeptsV;
    }
    return null;
  }
  
  public List findDeptsVByCode(String paramString)
  {
    return getSession().createQuery("from FbpDeptsV b where b.deptCode =:deptCode").setString("deptCode", paramString).list();
  }
  
  public List findDeptVByCon(FbpDeptsV paramFbpDeptsV)
  {
    String str = "from FbpDeptsV b where 1=1 ";
    if (null != paramFbpDeptsV.getDeptId()) {
      str = str + " and b.deptId<>" + paramFbpDeptsV.getDeptId();
    }
    if (!Util.isStrEmpty(paramFbpDeptsV.getAttribute7())) {
      str = str + " and b.attribute7= '" + paramFbpDeptsV.getAttribute7() + "'";
    }
    return super.createQuery(str, new Object[0]).list();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.organizationmanage.dao.FbpDeptsVDAO
 * JD-Core Version:    0.7.0.1
 */