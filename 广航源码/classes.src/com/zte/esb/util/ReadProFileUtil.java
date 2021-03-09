package com.zte.esb.util;

import java.util.HashMap;
import java.util.Map;

public class ReadProFileUtil
{
  private static Map<String, String> propersMap = null;
  
  public static Map<String, String> getPropersMap()
    throws Exception
  {
    if (null == propersMap) {
      propersMap = new HashMap();
    }
    return propersMap;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.ReadProFileUtil
 * JD-Core Version:    0.7.0.1
 */