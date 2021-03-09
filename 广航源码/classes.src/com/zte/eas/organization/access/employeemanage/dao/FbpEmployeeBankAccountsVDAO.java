package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.List;

public class FbpEmployeeBankAccountsVDAO
  extends BaseDAO
  implements IFbpEmployeeBankAccountsVDAO
{
  public List findEmployeeBankAccountsVByEmployeeId(Long paramLong)
  {
    return super.getZormTemplate().find("from FbpEmployeeBankAccountsV v where v.employeeId=?  order by v.lastUpdateDate  ", paramLong);
  }
  
  public PageInfo findEmployeeBankAccountsByEmployeeId(Long paramLong, int paramInt1, int paramInt2)
  {
    String str = "from FbpEmployeeBankAccountsV v where v.employeeId=?  order by v.lastUpdateDate desc ";
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramLong;
    paramInt1 = paramInt1 / paramInt2 + 1;
    return super.PageInfoQuery(str, paramInt1, paramInt2, arrayOfObject);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.FbpEmployeeBankAccountsVDAO
 * JD-Core Version:    0.7.0.1
 */