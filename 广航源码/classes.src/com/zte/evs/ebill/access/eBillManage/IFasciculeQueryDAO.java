package com.zte.evs.ebill.access.eBillManage;

import java.math.BigInteger;
import java.util.List;

public abstract interface IFasciculeQueryDAO
{
  public abstract List quary(String paramString1, String paramString2);
  
  public abstract List quary1(String paramString1, String paramString2);
  
  public abstract List findList1(String paramString1, String paramString2);
  
  public abstract List findList2(String paramString1, String paramString2);
  
  public abstract List findList3(String paramString1, String paramString2);
  
  public abstract List findList4(Long paramLong);
  
  public abstract List search(Long paramLong1, Long paramLong2);
  
  public abstract List findList5(Long paramLong);
  
  public abstract List findList6(Long paramLong);
  
  public abstract List findList7(Long paramLong);
  
  public abstract List findList8(Long paramLong);
  
  public abstract List findList9(Long paramLong);
  
  public abstract List findList10(Long paramLong);
  
  public abstract List searchDate(String paramString1, String paramString2);
  
  public abstract List searchDate1(Long paramLong);
  
  public abstract List find();
  
  public abstract List find1();
  
  public abstract List find2();
  
  public abstract List quaryDate();
  
  public abstract List findTree(BigInteger paramBigInteger);
  
  public abstract List findPeriodsByThisYear2(String paramString1, String paramString2, String paramString3);
  
  public abstract List findPeriodsByThisYear3(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract List findQuaryInfoByMonth(String paramString1, String paramString2, String paramString3);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IFasciculeQueryDAO
 * JD-Core Version:    0.7.0.1
 */