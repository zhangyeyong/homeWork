package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesSsologinV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public abstract interface IFbpEmployeesVDAO
  extends DAO
{
  public abstract PageInfo findEmployeesByDeptId(BigInteger paramBigInteger, int paramInt1, int paramInt2);
  
  public abstract Map findEmployeesByQry(FbpEmployeesV paramFbpEmployeesV, int paramInt1, int paramInt2);
  
  public abstract FbpEmployeesV findEmployeesById(BigInteger paramBigInteger);
  
  public abstract FbpEmployeesV findEmployeesByNumber(String paramString);
  
  public abstract List findEmployeesVByMobilePhone(String paramString);
  
  public abstract FbpEmployeesV findEmployeesByOaAddress(String paramString);
  
  public abstract FbpEmployeesTl getFbpEmployeesTl(String paramString);
  
  public abstract FbpEmployeesV findEmpByEmpNumber(String paramString);
  
  public abstract FbpEmployeesSsologinV getEmployeesSsologinV(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO
 * JD-Core Version:    0.7.0.1
 */