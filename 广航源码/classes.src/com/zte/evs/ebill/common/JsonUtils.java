package com.zte.evs.ebill.common;

import net.sf.json.JSONObject;

public class JsonUtils
{
  public static <T> T jsonToBean(String paramString, T paramT)
  {
    JSONObject localJSONObject = JSONObject.fromObject(paramString);
    return JSONObject.toBean(localJSONObject, paramT.getClass());
  }
  
  public static String beanToJson(Object paramObject)
  {
    new JSONObject();
    JSONObject localJSONObject = JSONObject.fromObject(paramObject);
    return localJSONObject.toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.JsonUtils
 * JD-Core Version:    0.7.0.1
 */