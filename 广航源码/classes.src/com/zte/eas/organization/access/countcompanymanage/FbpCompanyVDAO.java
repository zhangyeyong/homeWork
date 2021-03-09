package com.zte.eas.organization.access.countcompanymanage;

import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FbpCompanyVDAO
  extends BaseDAO
  implements IFbpCompanyVDAO
{
  public Map findCompanyByQry(FbpCompanyV paramFbpCompanyV, int paramInt1, int paramInt2)
  {
    System.out.println(paramFbpCompanyV.getEmployeeNumber());
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(4);
    localStringBuffer.append("FROM FbpCompanyV v WHERE 1=1");
    if (!Util.isStrEmpty(paramFbpCompanyV.getCompanyCode()))
    {
      localStringBuffer.append(" AND v.companyCode like ?");
      localArrayList.add("%" + paramFbpCompanyV.getCompanyCode().replace(" ", "").replace("'", "''") + "%");
    }
    if (!Util.isStrEmpty(paramFbpCompanyV.getCompanyName()))
    {
      localStringBuffer.append(" AND v.companyName like ?");
      localArrayList.add("%" + paramFbpCompanyV.getCompanyName().replace(" ", "").replace("'", "''") + "%");
    }
    if (!Util.isStrEmpty(paramFbpCompanyV.getEnabledFlag()))
    {
      localStringBuffer.append(" AND v.enabledFlag=?");
      localArrayList.add(paramFbpCompanyV.getEnabledFlag());
    }
    if (!Util.isNullObject(paramFbpCompanyV.getSetOfBooksCode()))
    {
      localStringBuffer.append(" AND v.setOfBooksCode=?");
      localArrayList.add(paramFbpCompanyV.getSetOfBooksCode());
    }
    if (!Util.isNullObject(paramFbpCompanyV.getEmployeeNumber()))
    {
      localStringBuffer.append(" AND v.employeeNumber=?");
      localArrayList.add(paramFbpCompanyV.getEmployeeNumber());
    }
    if (!Util.isNullObject(paramFbpCompanyV.getIsCheck()))
    {
      localStringBuffer.append(" AND v.isCheck=?");
      localArrayList.add(paramFbpCompanyV.getIsCheck());
    }
    localStringBuffer.append(" ORDER BY v.lastUpdateDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  public FbpCompanyV findByCompId(Long paramLong)
  {
    return (FbpCompanyV)super.getObject(FbpCompanyV.class, paramLong);
  }
  
  public FbpCompanyV findByCompCode(String paramString)
  {
    String str = "FROM FbpCompanyV v WHERE v.companyCode = '" + paramString + "'";
    List localList = getSession().createQuery(str).list();
    if (localList.size() > 0)
    {
      FbpCompanyV localFbpCompanyV = (FbpCompanyV)localList.get(0);
      return localFbpCompanyV;
    }
    return null;
  }
  
  public FbpCompanyV findByCompName(String paramString)
  {
    String str = "FROM FbpCompanyV v WHERE v.companyName = '" + paramString + "'";
    List localList = getSession().createQuery(str).list();
    if (localList.size() > 0)
    {
      FbpCompanyV localFbpCompanyV = (FbpCompanyV)localList.get(0);
      return localFbpCompanyV;
    }
    return null;
  }
  
  public FbpCompanyV findByEmpNumber(String paramString)
  {
    String str = "FROM FbpCompanyV v WHERE v.employeeNumber = '" + paramString + "'";
    List localList = getSession().createQuery(str).list();
    if (localList.size() > 0)
    {
      FbpCompanyV localFbpCompanyV = (FbpCompanyV)localList.get(0);
      return localFbpCompanyV;
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.countcompanymanage.FbpCompanyVDAO
 * JD-Core Version:    0.7.0.1
 */