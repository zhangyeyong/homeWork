package com.zte.eas.organization.access.organizationmanage.dao;

import com.zte.eas.appframe.business.util.CacheUtils;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsName;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsVl;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FbpDeptsVlDAO
  extends BaseDAO
  implements IFbpDeptsVlDAO
{
  public List findDeptsVl()
  {
    return super.getObjects(FbpDeptsVl.class);
  }
  
  public List findDownDeptsVl(String paramString)
  {
    return null;
  }
  
  private synchronized Map<BigInteger, FbpDeptsName> getFbpDeptsNameMap()
  {
    Object localObject1 = (Map)CacheUtils.getData("DEPTS_NAME");
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = new HashMap();
    Session localSession = getSession();
    try
    {
      Connection localConnection = localSession.connection();
      Statement localStatement = localConnection.createStatement();
      try
      {
        String str = "SELECT a.dept_id, a.parent_dept_id,\n  a.dept_code,b.dept_name,b.dept_long_name\nFROM  fbp_depts a, fbp_depts_tl b\nWHERE a.DEPT_ID = b.DEPT_ID  AND b.LANGUAGE = ZAS_ENV_PKG.getLang()";
        ResultSet localResultSet = localStatement.executeQuery(str);
        while (localResultSet.next())
        {
          FbpDeptsName localFbpDeptsName = new FbpDeptsName();
          localFbpDeptsName.setDeptId(BigInteger.valueOf(localResultSet.getLong(1)));
          localFbpDeptsName.setParentDeptId(BigInteger.valueOf(localResultSet.getLong(2)));
          localFbpDeptsName.setDeptCode(localResultSet.getString(3));
          localFbpDeptsName.setDeptName(localResultSet.getString(4));
          localFbpDeptsName.setDeptLongName(localResultSet.getString(5));
          ((Map)localObject1).put(localFbpDeptsName.getDeptId(), localFbpDeptsName);
        }
        CacheUtils.add("DEPTS_NAME", localObject1);
      }
      finally
      {
        localStatement.close();
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return localObject1;
  }
  
  public FbpDeptsName findFbpDeptsVl(Long paramLong)
  {
    Map localMap = getFbpDeptsNameMap();
    return (FbpDeptsName)localMap.get(BigInteger.valueOf(paramLong.longValue()));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.organizationmanage.dao.FbpDeptsVlDAO
 * JD-Core Version:    0.7.0.1
 */