package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpEmployeeBankAccountsVDAO
  extends DAO
{
  public abstract List findEmployeeBankAccountsVByEmployeeId(Long paramLong);
  
  public abstract PageInfo findEmployeeBankAccountsByEmployeeId(Long paramLong, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeeBankAccountsVDAO
 * JD-Core Version:    0.7.0.1
 */