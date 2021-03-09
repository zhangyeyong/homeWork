package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFbpEmployeesDAO
  extends DAO
{
  public abstract BigInteger getDeptByNumber(String paramString);
  
  public abstract FbpEmployees getFbpEmployees(BigInteger paramBigInteger);
  
  public abstract List<FbpEmployees> getFbpEmployeess(int paramInt1, int paramInt2);
  
  public abstract List<FbpEmployees> getFbpEmployeess();
  
  public abstract void removeFbpEmployees(BigInteger paramBigInteger);
  
  public abstract void removeFbpEmployees(FbpEmployees paramFbpEmployees);
  
  public abstract void insertFbpEmployees(FbpEmployees paramFbpEmployees);
  
  public abstract void updateFbpEmployees(FbpEmployees paramFbpEmployees);
  
  public abstract void insertFbpEmployeess(List<FbpEmployees> paramList);
  
  public abstract void removeFbpEmployeess(List<FbpEmployees> paramList);
  
  public abstract void updateFbpEmployeess(List<FbpEmployees> paramList);
  
  public abstract List<FbpEmployees> getFbpEmployeesByOa(String paramString);
  
  public abstract FbpEmployees getFbpEmployees(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesDAO
 * JD-Core Version:    0.7.0.1
 */