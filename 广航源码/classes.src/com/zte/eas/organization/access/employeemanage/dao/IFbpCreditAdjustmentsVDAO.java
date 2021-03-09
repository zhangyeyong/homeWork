package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.math.BigInteger;

public abstract interface IFbpCreditAdjustmentsVDAO
  extends DAO
{
  public abstract PageInfo findCreditAdjustmentsByEmployeeId(BigInteger paramBigInteger, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.IFbpCreditAdjustmentsVDAO
 * JD-Core Version:    0.7.0.1
 */