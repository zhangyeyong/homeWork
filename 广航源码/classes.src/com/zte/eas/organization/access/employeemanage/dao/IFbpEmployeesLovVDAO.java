package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesLovV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpEmployeesLovVDAO
  extends DAO
{
  public abstract String countEmployeeByName(FbpEmployeesLovV paramFbpEmployeesLovV);
  
  public abstract PageInfo findEmployeeByDeptId(FbpEmployeesLovV paramFbpEmployeesLovV, int paramInt1, int paramInt2);
  
  public abstract FbpEmployeesLovV findEmployeesLovVByEmployeeId(Long paramLong);
  
  public abstract List<FbpEmployeesLovV> findEmployeeByErpOrgIdDeptId(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract FbpEmployeesLovV findEmployeesLovVByEmployeeNumber(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesLovVDAO
 * JD-Core Version:    0.7.0.1
 */