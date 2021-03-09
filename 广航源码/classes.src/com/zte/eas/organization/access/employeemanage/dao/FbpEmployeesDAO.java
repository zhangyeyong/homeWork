package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.List;

public class FbpEmployeesDAO
  extends BaseDAO
  implements IFbpEmployeesDAO
{
  public FbpEmployees getFbpEmployees(BigInteger paramBigInteger)
  {
    return (FbpEmployees)super.getObject(FbpEmployees.class, paramBigInteger);
  }
  
  public List getFbpEmployeess()
  {
    return super.getObjects(FbpEmployees.class);
  }
  
  public List<FbpEmployees> getFbpEmployeess(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpEmployees.class, paramInt1, paramInt2);
  }
  
  public List<FbpEmployees> getFbpEmployeesByOa(String paramString)
  {
    String str = "FROM FbpEmployees s WHERE s.oaAddress = '" + paramString + "'";
    return getSession().createQuery(str).list();
  }
  
  public BigInteger getDeptByNumber(String paramString)
  {
    BigInteger localBigInteger = BigInteger.valueOf(Long.valueOf(0L).longValue());
    String str = "FROM FbpEmployees s WHERE s.employeeNumber = '" + paramString + "'";
    List localList = getSession().createQuery(str).list();
    if (localList.size() > 0)
    {
      FbpEmployees localFbpEmployees = (FbpEmployees)localList.get(0);
      return localFbpEmployees.getDeptId();
    }
    return localBigInteger;
  }
  
  public void removeFbpEmployees(FbpEmployees paramFbpEmployees)
  {
    super.removeObject(paramFbpEmployees);
  }
  
  public void insertFbpEmployees(FbpEmployees paramFbpEmployees)
  {
    super.insertObject(paramFbpEmployees);
  }
  
  public void updateFbpEmployees(FbpEmployees paramFbpEmployees)
  {
    super.updateObject(paramFbpEmployees);
  }
  
  public void insertFbpEmployeess(List<FbpEmployees> paramList)
  {
    super.insertObjects(paramList);
  }
  
  public void removeFbpEmployeess(List<FbpEmployees> paramList)
  {
    super.removeObjects(paramList);
  }
  
  public void updateFbpEmployeess(List<FbpEmployees> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public void removeFbpEmployees(BigInteger paramBigInteger)
  {
    super.removeObject(FbpEmployees.class, paramBigInteger);
  }
  
  public FbpEmployees getFbpEmployees(String paramString)
  {
    String str = "from FbpEmployees where employeeNumber =?";
    return (FbpEmployees)super.getSession().createQuery(str).setString(0, paramString).uniqueResult();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.FbpEmployeesDAO
 * JD-Core Version:    0.7.0.1
 */