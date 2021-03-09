package com.zte.esb.trans;

import com.zte.esb.util.JavaObjectToXmlUtil;

public class CommonRequestTrans
{
  public static String fromMessage(Object paramObject)
  {
    String str = null;
    try
    {
      str = JavaObjectToXmlUtil.javaObjectToXmlStr(paramObject.getClass().getName(), paramObject);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }
  
  public static Object toMessage(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      localObject = JavaObjectToXmlUtil.xmlToJavaObject(paramString1, paramString2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.trans.CommonRequestTrans
 * JD-Core Version:    0.7.0.1
 */