package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpBankAccounts;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFbpBankAccountsDAO
  extends DAO
{
  public abstract void remove(FbpBankAccounts paramFbpBankAccounts);
  
  public abstract void insert(FbpBankAccounts paramFbpBankAccounts);
  
  public abstract void update(FbpBankAccounts paramFbpBankAccounts);
  
  public abstract FbpBankAccounts getfbpBankAccounts(BigInteger paramBigInteger);
  
  public abstract void removeFbpBankAccounts(BigInteger paramBigInteger);
  
  public abstract List<FbpBankAccounts> getfbpBankAccountInfo(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.IFbpBankAccountsDAO
 * JD-Core Version:    0.7.0.1
 */