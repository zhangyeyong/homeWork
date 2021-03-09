package com.zte.eas.resconfig.access.periods.dao;

import com.zte.eas.resconfig.business.periods.model.FbpPeriods;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpPeriodsDAO
  extends DAO
{
  public abstract PageInfo findPeriodsByYear(String paramString1, String paramString2, String paramString3);
  
  public abstract void update(List<FbpPeriods> paramList);
  
  public abstract List findPeriodYears();
  
  public abstract List<FbpPeriods> findOpenPeriod();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.periods.dao.IFbpPeriodsDAO
 * JD-Core Version:    0.7.0.1
 */