package com.zte.eas.appframe.business.util;

public class SqlManageUtils
{
  public static String cleanUpSQL(String paramString)
  {
    String str = paramString;
    str = str.trim().replaceAll("'", "''");
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.util.SqlManageUtils
 * JD-Core Version:    0.7.0.1
 */