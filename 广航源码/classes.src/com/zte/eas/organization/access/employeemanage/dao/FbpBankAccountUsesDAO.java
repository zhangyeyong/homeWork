package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpBankAccountUses;
import com.zte.ssb.framework.base.BaseDAO;
import java.math.BigInteger;

public class FbpBankAccountUsesDAO
  extends BaseDAO
  implements IFbpBankAccountUsesDAO
{
  public void remove(FbpBankAccountUses paramFbpBankAccountUses)
  {
    super.removeObject(paramFbpBankAccountUses);
  }
  
  public void insert(FbpBankAccountUses paramFbpBankAccountUses)
  {
    super.insertObject(paramFbpBankAccountUses);
  }
  
  public void update(FbpBankAccountUses paramFbpBankAccountUses)
  {
    super.updateObject(paramFbpBankAccountUses);
  }
  
  public FbpBankAccountUses getfbpBankAccountUses(BigInteger paramBigInteger)
  {
    return (FbpBankAccountUses)super.getObject(FbpBankAccountUses.class, paramBigInteger);
  }
  
  public void removeBankAccountUses(BigInteger paramBigInteger)
  {
    super.removeObject(FbpBankAccountUses.class, paramBigInteger);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.FbpBankAccountUsesDAO
 * JD-Core Version:    0.7.0.1
 */