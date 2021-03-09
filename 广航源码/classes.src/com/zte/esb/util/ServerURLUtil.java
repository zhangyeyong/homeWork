package com.zte.esb.util;

public class ServerURLUtil
{
  public static String getUrlIP(String paramString)
  {
    String str = "";
    try
    {
      str = paramString.substring(paramString.indexOf("//", paramString.indexOf("/")) + 2, paramString.lastIndexOf(":"));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.ServerURLUtil
 * JD-Core Version:    0.7.0.1
 */