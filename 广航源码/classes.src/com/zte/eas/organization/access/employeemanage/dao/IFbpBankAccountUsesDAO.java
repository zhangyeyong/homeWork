package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpBankAccountUses;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;

public abstract interface IFbpBankAccountUsesDAO
  extends DAO
{
  public abstract void remove(FbpBankAccountUses paramFbpBankAccountUses);
  
  public abstract void insert(FbpBankAccountUses paramFbpBankAccountUses);
  
  public abstract void update(FbpBankAccountUses paramFbpBankAccountUses);
  
  public abstract FbpBankAccountUses getfbpBankAccountUses(BigInteger paramBigInteger);
  
  public abstract void removeBankAccountUses(BigInteger paramBigInteger);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.IFbpBankAccountUsesDAO
 * JD-Core Version:    0.7.0.1
 */