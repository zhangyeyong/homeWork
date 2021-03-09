package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.math.BigInteger;

public class FbpCreditAdjustmentsVDAO
  extends BaseDAO
  implements IFbpCreditAdjustmentsVDAO
{
  public PageInfo findCreditAdjustmentsByEmployeeId(BigInteger paramBigInteger, int paramInt1, int paramInt2)
  {
    String str = "FROM FbpCreditAdjustmentsV v WHERE v.entityId=?";
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramBigInteger;
    return super.PageInfoQuery(str, paramInt1, paramInt2, arrayOfObject);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.FbpCreditAdjustmentsVDAO
 * JD-Core Version:    0.7.0.1
 */