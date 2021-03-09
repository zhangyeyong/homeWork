package com.zte.esb.util;

import java.io.PrintStream;
import java.math.BigDecimal;
import org.apache.commons.lang.StringUtils;

public class ConverUtil
{
  public static BigDecimal getFormatStrToBigDecimal(String paramString, Integer paramInteger)
  {
    BigDecimal localBigDecimal = null;
    if ((!StringUtils.isBlank(paramString)) && (paramString.matches("^(-?\\d+)(\\.\\d+)?$")))
    {
      localBigDecimal = new BigDecimal(paramString);
      if (paramInteger != null) {
        localBigDecimal = localBigDecimal.setScale(paramInteger.intValue(), 4);
      }
    }
    return localBigDecimal;
  }
  
  public static String getFormatBigDecimalToStr(BigDecimal paramBigDecimal, Integer paramInteger)
  {
    if ((paramBigDecimal != null) && (paramInteger != null)) {
      paramBigDecimal = paramBigDecimal.setScale(paramInteger.intValue(), 4);
    }
    return paramBigDecimal == null ? "" : paramBigDecimal.toString();
  }
  
  public static boolean StringtoBoolean(String paramString)
  {
    return (paramString != null) && (paramString.equalsIgnoreCase("true"));
  }
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println(getFormatStrToBigDecimal(null, null));
    System.out.println(getFormatStrToBigDecimal("", null));
    System.out.println(getFormatStrToBigDecimal("11.1234567891", null));
    System.out.println(getFormatStrToBigDecimal("123.12345", Integer.valueOf(5)));
    System.out.println(getFormatStrToBigDecimal("123456789.1234567891", Integer.valueOf(5)));
    System.out.println(getFormatStrToBigDecimal("1asd.asd、", Integer.valueOf(5)));
    System.out.println(getFormatBigDecimalToStr(null, null));
    System.out.println(getFormatBigDecimalToStr(new BigDecimal(123.56D), null));
    System.out.println(getFormatBigDecimalToStr(new BigDecimal(123.56D), Integer.valueOf(1)));
    System.out.println(getFormatBigDecimalToStr(new BigDecimal(123.563D), Integer.valueOf(2)));
    System.out.println(getFormatBigDecimalToStr(new BigDecimal(123.56699999999999D), Integer.valueOf(2)));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.ConverUtil
 * JD-Core Version:    0.7.0.1
 */