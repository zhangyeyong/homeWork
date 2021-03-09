package com.zte.esb.util;

import java.util.HashMap;
import java.util.Map;

public class VoucherExceptionConfig
{
  private static Map<String, String> propersMap = new HashMap();
  
  public static Map<String, String> getProperties()
  {
    return propersMap;
  }
  
  public static Map<String, String> getPropersMap()
  {
    return propersMap;
  }
  
  public static void setPropersMap(Map<String, String> paramMap)
  {
    propersMap = paramMap;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.VoucherExceptionConfig
 * JD-Core Version:    0.7.0.1
 */