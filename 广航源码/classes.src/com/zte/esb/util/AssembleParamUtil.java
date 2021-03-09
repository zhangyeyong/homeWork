package com.zte.esb.util;

import java.util.Iterator;
import java.util.List;

public class AssembleParamUtil
{
  public static <T> String getParam(List<T> paramList)
  {
    String str = "";
    if (!paramList.isEmpty())
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        str = str + localObject.toString() + ",";
      }
      if ((str.contains(",")) && (str.trim().length() > 2)) {
        str = str.substring(0, str.lastIndexOf(","));
      }
    }
    return str;
  }
  
  public static String getParam(String... paramVarArgs)
  {
    String str1 = "";
    if ((null != paramVarArgs) && (paramVarArgs.length > 0))
    {
      for (String str2 : paramVarArgs) {
        str1 = str1 + "'" + str2 + "='" + str2 + ",";
      }
      if ((str1.contains(",")) && (str1.trim().length() > 2)) {
        str1 = str1.substring(0, str1.lastIndexOf(","));
      }
    }
    return str1;
  }
  
  public static <T> String getParam(String[][] paramArrayOfString)
  {
    String str = "";
    for (int i = 0; i < paramArrayOfString.length; i++) {
      for (int j = 0; j < paramArrayOfString[i].length; j++) {
        str = str + paramArrayOfString[i][j] + ",";
      }
    }
    if (str.contains(",")) {
      str = str.substring(0, str.lastIndexOf(","));
    }
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.AssembleParamUtil
 * JD-Core Version:    0.7.0.1
 */