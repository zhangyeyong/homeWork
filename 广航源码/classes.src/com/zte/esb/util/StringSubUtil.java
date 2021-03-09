package com.zte.esb.util;

import java.util.Iterator;
import java.util.List;

public class StringSubUtil
{
  public static String getParam(List<String> paramList)
  {
    String str1 = "";
    if (!paramList.isEmpty())
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        str1 = str1 + str2 + ",";
      }
      localObject = str1;
      if ((-1 != ((String)localObject).lastIndexOf(",")) && (!"".equals(((String)localObject).replace(",", "").trim()))) {
        str1 = str1.substring(0, str1.lastIndexOf(","));
      }
    }
    return str1;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.StringSubUtil
 * JD-Core Version:    0.7.0.1
 */