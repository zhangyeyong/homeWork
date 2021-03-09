package com.zte.eas.resconfig.business.periods.service;

import com.zte.eas.resconfig.business.periods.model.FbpPeriods;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.HashMap;
import java.util.List;

public abstract interface IFbpPeriodsDS
  extends DomainService
{
  public abstract TableDataInfo findPeriodsByThisYear(String paramString1, String paramString2, String paramString3);
  
  public abstract String savePeriods(List<FbpPeriods> paramList);
  
  public abstract HashMap findPeriodYears();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.periods.service.IFbpPeriodsDS
 * JD-Core Version:    0.7.0.1
 */