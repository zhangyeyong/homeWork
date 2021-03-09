package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpBankAccounts;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FbpBankAccountsDAO
  extends BaseDAO
  implements IFbpBankAccountsDAO
{
  public void remove(FbpBankAccounts paramFbpBankAccounts)
  {
    super.removeObject(paramFbpBankAccounts);
  }
  
  public void insert(FbpBankAccounts paramFbpBankAccounts)
  {
    super.insertObject(paramFbpBankAccounts);
  }
  
  public void update(FbpBankAccounts paramFbpBankAccounts)
  {
    super.updateObject(paramFbpBankAccounts);
  }
  
  public FbpBankAccounts getfbpBankAccounts(BigInteger paramBigInteger)
  {
    return (FbpBankAccounts)super.getObject(FbpBankAccounts.class, paramBigInteger);
  }
  
  public void removeFbpBankAccounts(BigInteger paramBigInteger)
  {
    super.removeObject(FbpBankAccounts.class, paramBigInteger);
  }
  
  public List<FbpBankAccounts> getfbpBankAccountInfo(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "from FbpBankAccounts fba where 1 = 1";
    if ((paramString != null) && (!"".equals(paramString)))
    {
      str = str + "and fba.bankAccountName = ? ";
      localArrayList.add(paramString);
    }
    else
    {
      str = str + " AND 1=2";
    }
    return getZormTemplate().find(str, localArrayList.toArray());
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.FbpBankAccountsDAO
 * JD-Core Version:    0.7.0.1
 */