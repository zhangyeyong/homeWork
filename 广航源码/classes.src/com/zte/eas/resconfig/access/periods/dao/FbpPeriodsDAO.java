package com.zte.eas.resconfig.access.periods.dao;

import com.zte.eas.resconfig.business.periods.model.FbpPeriods;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.zorm.Query;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

public class FbpPeriodsDAO
  extends BaseDAO
  implements IFbpPeriodsDAO
{
  public PageInfo findPeriodsByYear(String paramString1, String paramString2, String paramString3)
  {
    String str = "FROM FbpPeriods p WHERE p.periodYear=?";
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new BigInteger(paramString1);
    int i = Integer.parseInt(paramString2);
    int j = Integer.parseInt(paramString3);
    return super.PageInfoQuery(str, i / j + 1, j, arrayOfObject);
  }
  
  public void update(List<FbpPeriods> paramList)
  {
    String str = "UPDATE FbpPeriods p SET p.closingStatus=? WHERE p.periodName=? AND p.periodSetName=?";
    Object[] arrayOfObject = new Object[3];
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FbpPeriods localFbpPeriods = (FbpPeriods)localIterator.next();
      arrayOfObject[0] = localFbpPeriods.getClosingStatus();
      arrayOfObject[1] = localFbpPeriods.getPeriodName();
      arrayOfObject[2] = localFbpPeriods.getPeriodSetName();
      Query localQuery = super.createQuery(str, arrayOfObject);
      localQuery.executeUpdate();
    }
  }
  
  public List findPeriodYears()
  {
    String str = "SELECT p.periodYear FROM FbpPeriods p GROUP BY p.periodYear";
    Object[] arrayOfObject = new Object[0];
    return super.find(str, arrayOfObject);
  }
  
  public List<FbpPeriods> findOpenPeriod()
  {
    String str = "FROM FbpPeriods p WHERE p.closingStatus = 'O'";
    List localList = getZormTemplate().find(str);
    if (localList.size() > 0) {
      return localList;
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.periods.dao.FbpPeriodsDAO
 * JD-Core Version:    0.7.0.1
 */