package com.zte.eas.resconfig.business.periods.service;

import com.zte.eas.resconfig.access.periods.dao.IFbpPeriodsDAO;
import com.zte.eas.resconfig.business.periods.model.FbpPeriods;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FbpPeriodsDS
  extends BaseDomainService
  implements IFbpPeriodsDS
{
  private IFbpPeriodsDAO fbpPeriodsDAO;
  
  public TableDataInfo findPeriodsByThisYear(String paramString1, String paramString2, String paramString3)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    if ((paramString1 != null) && (!"".equals(paramString1)))
    {
      PageInfo localPageInfo = this.fbpPeriodsDAO.findPeriodsByYear(paramString1, paramString2, paramString3);
      List localList = (List)localPageInfo.getResult();
      localTableDataInfo.setData(localList);
      localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    }
    return localTableDataInfo;
  }
  
  public String savePeriods(List<FbpPeriods> paramList)
  {
    try
    {
      this.fbpPeriodsDAO.update(paramList);
    }
    catch (Exception localException)
    {
      return "FALSE";
    }
    return "SUCCESS";
  }
  
  public IFbpPeriodsDAO getFbpPeriodsDAO()
  {
    return this.fbpPeriodsDAO;
  }
  
  public void setFbpPeriodsDAO(IFbpPeriodsDAO paramIFbpPeriodsDAO)
  {
    this.fbpPeriodsDAO = paramIFbpPeriodsDAO;
  }
  
  public HashMap findPeriodYears()
  {
    List localList = this.fbpPeriodsDAO.findPeriodYears();
    Collections.sort(localList);
    HashMap localHashMap = new HashMap();
    String str = "";
    Calendar localCalendar = Calendar.getInstance();
    int i = 100;
    for (int j = 0; j < localList.size(); j++)
    {
      Integer localInteger = Integer.valueOf(Integer.parseInt(localList.get(j).toString()));
      int k = Math.abs(localCalendar.get(1) - localInteger.intValue());
      if (k < i)
      {
        i = k;
        str = localInteger.toString();
      }
    }
    localHashMap.put("selectText", localList);
    localHashMap.put("selectValue", localList);
    localHashMap.put("selectDefault", str);
    return localHashMap;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.periods.service.FbpPeriodsDS
 * JD-Core Version:    0.7.0.1
 */