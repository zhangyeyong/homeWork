package com.zte.eas.appframe.business.util;

import com.zte.ssb.ssbext.lang.LangUtil;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CacheUtils
{
  private static Map map = new HashMap();
  private static Map<String, Date> timeMap = new HashMap();
  private static final long SAPCE_TIME = 86400000L;
  private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  public static synchronized <T> void add(String paramString, T paramT)
  {
    try
    {
      String str = paramString + "_" + LangUtil.getLocale();
      Date localDate = null;
      try
      {
        localDate = df.parse(new Date().toLocaleString());
      }
      catch (Exception localException2)
      {
        localDate = new Date();
      }
      map.put(str, paramT);
      timeMap.put(str, localDate);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
  }
  
  public static synchronized <T> T getData(String paramString)
  {
    try
    {
      String str = paramString + "_" + LangUtil.getLocale();
      if (map.containsKey(str))
      {
        Date localDate = null;
        try
        {
          localDate = df.parse(new Date().toLocaleString());
        }
        catch (Exception localException2)
        {
          localDate = new Date();
        }
        long l = localDate.getTime() - ((Date)timeMap.get(str)).getTime();
        if (l - 86400000L > 0L)
        {
          map.remove(str);
          return null;
        }
        return map.get(str);
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    return null;
  }
  
  public static synchronized void remove(String paramString)
  {
    String str = paramString + "_" + LangUtil.getLocale();
    if (map.containsKey(str)) {
      map.remove(str);
    }
  }
  
  public static synchronized void flush()
  {
    map = new HashMap();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try
    {
      Date localDate1 = localSimpleDateFormat.parse(new Date().toLocaleString());
      Date localDate2 = localSimpleDateFormat.parse("2009-02-11 16:30:24");
      System.out.println(localDate1.getTime() + "  " + localDate2.getTime());
      long l1 = localDate1.getTime() - localDate2.getTime();
      long l2 = l1 - 86400000L;
      System.out.println(l2);
    }
    catch (Exception localException) {}
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.util.CacheUtils
 * JD-Core Version:    0.7.0.1
 */