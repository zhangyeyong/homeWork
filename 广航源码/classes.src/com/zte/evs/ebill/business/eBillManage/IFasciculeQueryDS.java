package com.zte.evs.ebill.business.eBillManage;

import java.util.List;

public abstract interface IFasciculeQueryDS
{
  public abstract List findPeriodsByThisYear(String paramString1, String paramString2);
  
  public abstract List findPeriodsByThisYear1(String paramString1, String paramString2);
  
  public abstract List findfasciculeQuaryInfoByContentId(String paramString1, String paramString2);
  
  public abstract List findfasciculeQuaryInfoByContentId1(Long paramLong);
  
  public abstract List findfasciculeQuaryInfo();
  
  public abstract List findfasciculeTree(String paramString);
  
  public abstract List findPeriodsByThisYear2(String paramString1, String paramString2, String paramString3);
  
  public abstract List findPeriodsByThisYear3(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract List findQuaryInfoByMonth(String paramString1, String paramString2, String paramString3);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IFasciculeQueryDS
 * JD-Core Version:    0.7.0.1
 */