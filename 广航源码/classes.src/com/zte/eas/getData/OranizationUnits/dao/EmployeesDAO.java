package com.zte.eas.getData.OranizationUnits.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsVl;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;

public class EmployeesDAO
  extends EasBaseDAO
  implements IEmployeesDAO
{
  public FbpEmployees findEmployeesByEmployeeNumber(String paramString)
  {
    FbpEmployees localFbpEmployees = (FbpEmployees)findUniqueByHql("from FbpEmployees fou where fou.employeeNumber=?", new Object[] { paramString });
    return localFbpEmployees;
  }
  
  public FbpDeptsVl findDeptsVlByDeptCode(String paramString)
  {
    FbpDeptsVl localFbpDeptsVl = (FbpDeptsVl)findUniqueByHql("from FbpDeptsVl a where a.deptCode=?", new Object[] { paramString });
    return localFbpDeptsVl;
  }
  
  public FbpEmployeesTl findEmployeesTlByEmployeeId(Long paramLong)
  {
    FbpEmployeesTl localFbpEmployeesTl = (FbpEmployeesTl)findUniqueByHql("from FbpEmployeesTl a where a.employeePkTl.employeeId=?", new Object[] { paramLong });
    return localFbpEmployeesTl;
  }
  
  public FbpEmployeesTl findEmployeesTlByEmployeeId(Long paramLong, String paramString)
  {
    FbpEmployeesTl localFbpEmployeesTl = (FbpEmployeesTl)findUniqueByHql("from FbpEmployeesTl a where a.employeePkTl.employeeId=? and a.employeePkTl.language = ?", new Object[] { BigInteger.valueOf(paramLong.longValue()), paramString });
    return localFbpEmployeesTl;
  }
  
  public String findEmployees(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("select wmsys.wm_concat(d.employee_number) from fbp_employees e,(");
    localStringBuffer.append(" SELECT l_count,");
    localStringBuffer.append("                          REGEXP_SUBSTR(?,");
    localStringBuffer.append("                                        '[^,]+',");
    localStringBuffer.append("                                        1,");
    localStringBuffer.append("                                        l_count) AS employee_number");
    localStringBuffer.append("                     FROM dual,");
    localStringBuffer.append("                          (SELECT LEVEL l_count");
    localStringBuffer.append("                             FROM DUAL");
    localStringBuffer.append("                           CONNECT BY LEVEL <= 100000)");
    localStringBuffer.append("                    WHERE l_count <=");
    localStringBuffer.append("                          LENGTH(?) -");
    localStringBuffer.append("                          LENGTH(REPLACE(?, ',')) + 1");
    localStringBuffer.append("                          ) d");
    localStringBuffer.append(" where e.employee_number(+)=d.employee_number");
    localStringBuffer.append(" and e.employee_number is null");
    SQLQuery localSQLQuery = getSession().createSQLQuery(localStringBuffer.toString());
    localSQLQuery.setString(0, paramString);
    localSQLQuery.setString(1, paramString);
    localSQLQuery.setString(2, paramString);
    Object localObject = localSQLQuery.uniqueResult();
    if (localObject != null) {
      return localObject.toString().trim();
    }
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.dao.EmployeesDAO
 * JD-Core Version:    0.7.0.1
 */