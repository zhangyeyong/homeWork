package com.zte.eas.appframe.access.currencies.dao;

import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.List;

public class FbpCurrenciesVDAO
  extends BaseDAO
  implements IFbpCurrenciesVDAO
{
  public List getFbpCurrencies()
  {
    String str = "select t.currency_code,t.currency_name from Fbp_Currencies_V t where to_char(current_timestamp,'YYYY-MM-DD hh:mm:ss') between nvl(to_char(t.start_Date_Active,'YYYY-MM-DD hh:mm:ss'), to_char(current_timestamp,'YYYY-MM-DD hh:mm:ss')) and nvl(to_char(t.end_Date_Active,'YYYY-MM-DD hh:mm:ss'), to_char(current_timestamp,'YYYY-MM-DD hh:mm:ss'))  and t.enabled_Flag = 'Y'";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    List localList = localSQLQuery.list();
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.currencies.dao.FbpCurrenciesVDAO
 * JD-Core Version:    0.7.0.1
 */