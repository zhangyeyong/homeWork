package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesLovV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FbpEmployeesLovVDAO
  extends BaseDAO
  implements IFbpEmployeesLovVDAO
{
  public FbpEmployeesLovV findEmployeesLovVByEmployeeId(Long paramLong)
  {
    return (FbpEmployeesLovV)super.getObject(FbpEmployeesLovV.class, paramLong);
  }
  
  public FbpEmployeesLovV findEmployeesLovVByEmployeeNumber(String paramString)
  {
    String str = "from FbpEmployeesLovV v where v.employeeNumber = '" + paramString + "'";
    Query localQuery = getSession().createQuery(str);
    List localList = localQuery.list();
    if ((localList != null) && (localList.size() != 0)) {
      return (FbpEmployeesLovV)localList.get(0);
    }
    return null;
  }
  
  public List<FbpEmployeesLovV> findEmployeeByErpOrgIdDeptId(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("  from FbpEmployeesLovV v where 1=1 ");
    if ((paramString1 != null) && (!"".equals(paramString1.trim())))
    {
      localStringBuffer.append(" and v.checkUnit=? ");
      localArrayList.add(paramString1);
    }
    if ((paramString2 != null) && (!"".equals(paramString2.trim())))
    {
      paramString2 = "%" + paramString2 + "%";
      localStringBuffer.append(" and v.employeeNumber like ? ");
      localArrayList.add(paramString2);
    }
    if ((paramString3 != null) && (!"".equals(paramString3.trim())))
    {
      paramString3 = "%" + paramString3 + "%";
      localStringBuffer.append(" and v.employeeName like ? ");
      localArrayList.add(paramString3);
    }
    if ((paramString4 != null) && (!"".equals(paramString4.trim()))) {
      localStringBuffer.append(" and v.deptId in(").append(paramString4).append(")");
    }
    localStringBuffer.append(" order by v.employeeName ");
    Query localQuery = getSession().createQuery(localStringBuffer.toString());
    for (int i = 0; i < localArrayList.size(); i++) {
      localQuery.setParameter(i, localArrayList.get(i));
    }
    return localQuery.setFirstResult(0).setMaxResults(1000).list();
  }
  
  public String countEmployeeByName(FbpEmployeesLovV paramFbpEmployeesLovV)
  {
    String str1 = "from FbpEmployeesLovV v where v.employeeName like '%" + paramFbpEmployeesLovV.getEmployeeName() + "%'";
    if ((paramFbpEmployeesLovV.getCheckUnit() != null) && (!paramFbpEmployeesLovV.getCheckUnit().equals(""))) {
      str1 = str1 + " and v.checkUnit='" + paramFbpEmployeesLovV.getCheckUnit() + "'";
    }
    Query localQuery = getSession().createQuery(str1);
    List localList = localQuery.list();
    int i = localList.size();
    if ((localList == null) || (i == 0)) {
      return "0";
    }
    if (i == 1)
    {
      FbpEmployeesLovV localFbpEmployeesLovV = (FbpEmployeesLovV)localList.get(0);
      String str2 = localFbpEmployeesLovV.getEmployeeId() + ";;" + localFbpEmployeesLovV.getEmployeeName() + ";;" + localFbpEmployeesLovV.getEmployeeNumber() + ";;" + localFbpEmployeesLovV.getDeptLongName();
      return str2;
    }
    if ((i > 1) && (i < 10)) {
      return "lessTen";
    }
    return "moreTen";
  }
  
  public PageInfo findEmployeeByDeptId(FbpEmployeesLovV paramFbpEmployeesLovV, int paramInt1, int paramInt2)
  {
    String str = "from FbpEmployeesLovV v where 1=1";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramFbpEmployeesLovV != null)
    {
      if ((paramFbpEmployeesLovV.getEmployeeName() != null) && (!paramFbpEmployeesLovV.getEmployeeName().equals(""))) {
        str = str + " and v.employeeName like '%" + paramFbpEmployeesLovV.getEmployeeName() + "%'";
      }
      if ((paramFbpEmployeesLovV.getEmployeeNumber() != null) && (!paramFbpEmployeesLovV.getEmployeeNumber().equals(""))) {
        str = str + " and v.employeeNumber like '%" + paramFbpEmployeesLovV.getEmployeeNumber() + "%'";
      }
      if (paramFbpEmployeesLovV.getEmployeeId() != null) {
        str = str + " and v.employeeId =" + paramFbpEmployeesLovV.getEmployeeId();
      }
      if ((paramFbpEmployeesLovV.getDeptName() != null) && (!paramFbpEmployeesLovV.getDeptName().equals(""))) {
        str = str + " and v.deptName like '%" + paramFbpEmployeesLovV.getDeptName() + "%'";
      }
      if ((paramFbpEmployeesLovV.getCheckUnit() != null) && (!paramFbpEmployeesLovV.getCheckUnit().equals(""))) {
        str = str + " and v.checkUnit ='" + paramFbpEmployeesLovV.getCheckUnit() + "'";
      }
    }
    int i = paramInt1;
    int j = paramInt2;
    return super.PageInfoQuery(str, i / j + 1, j, localArrayList1.toArray());
  }
  
  private List<Long> getDeptIds(Long paramLong)
  {
    String str = "select distinct fd.dept_id AS dept_id";
    str = str + " from (select pse.pos_stru_element_id,";
    str = str + " pse.parent_pos_stru_element_id,pse.determiner";
    str = str + " from fbp_pos_stru_elements pse";
    str = str + " where pse.pos_structure_code = 'DEPT_HIERARCHY'";
    str = str + " and pse.enabled_flag = 'Y'";
    str = str + " start with pse.pos_stru_element_id in";
    str = str + " (select pos_stru_element_id";
    str = str + " from fbp_pse_holders fph";
    str = str + " where fph.employee_id = ?";
    str = str + " AND fph.enabled_flag = 'Y') CONNECT BY prior";
    str = str + " pse.pos_stru_element_id = pse.parent_pos_stru_element_id) pse,";
    str = str + " fbp_depts fd  where fd.dept_code = pse.determiner";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int[] arrayOfInt = { -1 };
    if (null != paramLong) {
      localArrayList1.add(paramLong);
    } else {
      return localArrayList2;
    }
    try
    {
      String[][] arrayOfString = execQuery(str, localArrayList1.toArray(), arrayOfInt);
      if (null != arrayOfString) {
        for (int i = 1; i < arrayOfString.length; i++) {
          if ((null != arrayOfString[i]) && (arrayOfString[i].length == 1)) {
            localArrayList2.add(Long.valueOf(arrayOfString[i][0]));
          }
        }
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return localArrayList2;
  }
  
  private void selectDepts(List<Long> paramList, FbpEmployeesLovV paramFbpEmployeesLovV)
  {
    if (paramFbpEmployeesLovV.getDeptId() == null) {
      return;
    }
    try
    {
      Statement localStatement = getSession().connection().createStatement();
      try
      {
        HashMap localHashMap = new HashMap();
        Object localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Long)((Iterator)localObject1).next();
          localHashMap.put(localObject2, localObject2);
        }
        paramList.clear();
        localObject1 = "select DEPT_ID from fbp_depts_vl dfv\nstart with dfv.dept_id=" + paramFbpEmployeesLovV.getDeptId() + "\n" + "connect by prior dfv.dept_id=dfv.parent_dept_id";
        Object localObject2 = localStatement.executeQuery((String)localObject1);
        while (((ResultSet)localObject2).next())
        {
          Long localLong = Long.valueOf(((ResultSet)localObject2).getLong(1));
          if (localHashMap.get(localLong) != null) {
            paramList.add(localLong);
          }
        }
        localHashMap.clear();
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
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.FbpEmployeesLovVDAO
 * JD-Core Version:    0.7.0.1
 */