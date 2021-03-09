package com.zte.esb.util;

import java.sql.Date;

public class SimpleDataConvertor
{
  public static int stringToInt(String paramString)
  {
    Integer localInteger = Integer.valueOf(paramString);
    return localInteger.intValue();
  }
  
  public static String intToString(int paramInt)
  {
    Integer localInteger = new Integer(paramInt);
    return localInteger.toString();
  }
  
  public static float stringToFloat(String paramString)
  {
    Float localFloat = Float.valueOf(paramString);
    return localFloat.floatValue();
  }
  
  public static String floatToString(float paramFloat)
  {
    Float localFloat = new Float(paramFloat);
    return localFloat.toString();
  }
  
  public static Date stringToDate(String paramString)
  {
    return Date.valueOf(paramString);
  }
  
  public static String dateToString(Date paramDate)
  {
    return paramDate.toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.SimpleDataConvertor
 * JD-Core Version:    0.7.0.1
 */