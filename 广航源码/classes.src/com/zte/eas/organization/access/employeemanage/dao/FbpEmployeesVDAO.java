package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesSsologinV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FbpEmployeesVDAO
  extends BaseDAO
  implements IFbpEmployeesVDAO
{
  private static final String ENABELD = "有效";
  private static final String DISABELD = "无效";
  
  public PageInfo findEmployeesByDeptId(BigInteger paramBigInteger, int paramInt1, int paramInt2)
  {
    String str = "FROM FbpEmployeesV v WHERE v.deptId=? ORDER BY v.lastUpdateDate desc ";
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramBigInteger;
    paramInt1 = paramInt1 / paramInt2 + 1;
    return super.PageInfoQuery(str, paramInt1, paramInt2, arrayOfObject);
  }
  
  public List findDeptsVByEmployeeNumber(String paramString)
  {
    return getSession().createQuery("FROM FbpEmployeesV v WHERE v.employeeNumber =:employeeNumber").setString("employeeNumber", paramString).list();
  }
  
  public FbpEmployeesV findEmpByEmpNumber(String paramString)
  {
    String str = "FROM FbpEmployeesV v WHERE v.employeeNumber = '" + paramString + "'";
    List localList = getSession().createQuery(str).list();
    if (localList.size() > 0)
    {
      FbpEmployeesV localFbpEmployeesV = (FbpEmployeesV)localList.get(0);
      return localFbpEmployeesV;
    }
    return null;
  }
  
  public List findEmployeesVByMobilePhone(String paramString)
  {
    return getSession().createQuery("FROM FbpEmployeesV v WHERE v.mobilePhone =:mobilePhone").setString("mobilePhone", paramString).list();
  }
  
  public Map findEmployeesByQry(FbpEmployeesV paramFbpEmployeesV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(4);
    localStringBuffer.append("FROM FbpEmployeesV v WHERE 1=1");
    if (!Util.isStrEmpty(paramFbpEmployeesV.getEmployeeNumber()))
    {
      localStringBuffer.append(" AND v.employeeNumber like ?");
      localArrayList.add("%" + paramFbpEmployeesV.getEmployeeNumber().replace(" ", "").replace("'", "''") + '%');
    }
    if (!Util.isStrEmpty(paramFbpEmployeesV.getEmployeeName()))
    {
      localStringBuffer.append(" AND v.employeeName like ?");
      localArrayList.add("%" + paramFbpEmployeesV.getEmployeeName().replace(" ", "").replace("'", "''") + "%");
    }
    if (!Util.isStrEmpty(paramFbpEmployeesV.getEnabledFlag()))
    {
      localStringBuffer.append(" AND v.enabledFlag=?");
      localArrayList.add(paramFbpEmployeesV.getEnabledFlag());
    }
    if (!Util.isNullObject(paramFbpEmployeesV.getDeptId()))
    {
      localStringBuffer.append(" AND v.deptId=?");
      localArrayList.add(paramFbpEmployeesV.getDeptId());
    }
    if (!Util.isStrEmpty(paramFbpEmployeesV.getDeptName()))
    {
      localStringBuffer.append(" AND v.deptName like ?");
      localArrayList.add("%" + paramFbpEmployeesV.getDeptName().replace(" ", "").replace("'", "''") + "%");
    }
    localStringBuffer.append(" ORDER BY v.lastUpdateDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localPageInfo.getResult());
    localHashMap.put("totalCount", Long.valueOf(localPageInfo.getTotalCount()));
    return localHashMap;
  }
  
  private void setEnabled(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      FbpEmployeesV localFbpEmployeesV = null;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localFbpEmployeesV = (FbpEmployeesV)localIterator.next();
        if ((localFbpEmployeesV != null) && (localFbpEmployeesV.getEnabledFlag() != null)) {
          if (localFbpEmployeesV.getEnabledFlag().equalsIgnoreCase("Y")) {
            localFbpEmployeesV.setEnabledFlag("有效");
          } else if (localFbpEmployeesV.getEnabledFlag().equalsIgnoreCase("N")) {
            localFbpEmployeesV.setEnabledFlag("无效");
          }
        }
      }
    }
  }
  
  public FbpEmployeesV findEmployeesById(BigInteger paramBigInteger)
  {
    return (FbpEmployeesV)super.getObject(FbpEmployeesV.class, paramBigInteger);
  }
  
  public FbpEmployeesV findEmployeesByNumber(String paramString)
  {
    List localList = super.getZormTemplate().find("FROM FbpEmployeesV v WHERE v.employeeNumber=?", paramString);
    getSession().clear();
    FbpEmployeesV localFbpEmployeesV = null;
    if ((null != localList) && (localList.size() > 0)) {
      localFbpEmployeesV = (FbpEmployeesV)localList.get(0);
    }
    return localFbpEmployeesV;
  }
  
  public FbpEmployeesV findEmployeesByOaAddress(String paramString)
  {
    List localList = super.getZormTemplate().find("FROM FbpEmployeesV v WHERE v.oaAddress=?", paramString);
    getSession().clear();
    if ((null != localList) && (localList.size() > 0)) {
      return (FbpEmployeesV)localList.get(0);
    }
    return null;
  }
  
  public FbpEmployeesTl getFbpEmployeesTl(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return null;
    }
    String str = "select t.* from fbp.fbp_employees e,fbp.fbp_employees_tl t where e.employee_id = t.employee_id and t.language = userenv('LANG') and e.employee_number = ?";
    return (FbpEmployeesTl)super.getSession().createSQLQuery(str).addEntity(FbpEmployeesTl.class).setString(0, paramString).uniqueResult();
  }
  
  public FbpEmployeesSsologinV getEmployeesSsologinV(String paramString)
  {
    String str = "from FbpEmployeesSsologinV where employeeNumber = ?";
    return (FbpEmployeesSsologinV)super.getSession().createQuery(str).setString(0, paramString).uniqueResult();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.FbpEmployeesVDAO
 * JD-Core Version:    0.7.0.1
 */