package com.zte.esb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtil
{
  public static String getFormatDateString(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString);
    String str = localSimpleDateFormat.format(localCalendar.getTime());
    return str;
  }
  
  public static Date getFormatStrToDate(String paramString1, String paramString2)
  {
    Date localDate = null;
    if ((paramString1 != null) && (paramString2 != null))
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString1);
      try
      {
        localDate = localSimpleDateFormat.parse(paramString2);
      }
      catch (ParseException localParseException)
      {
        localParseException.printStackTrace();
      }
    }
    if (localDate == null) {
      localDate = Calendar.getInstance().getTime();
    }
    return localDate;
  }
  
  public static Date getFormatStrToDate(String paramString1, String paramString2, String paramString3)
  {
    Date localDate = null;
    if ((paramString1 != null) && (paramString3 != null))
    {
      SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat(paramString1);
      try
      {
        localDate = localSimpleDateFormat1.parse(paramString3);
      }
      catch (ParseException localParseException1)
      {
        SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat(paramString1);
        try
        {
          localDate = localSimpleDateFormat2.parse(paramString3);
        }
        catch (ParseException localParseException2)
        {
          localParseException2.printStackTrace();
        }
        localParseException1.printStackTrace();
      }
    }
    return localDate;
  }
  
  public static Date getStartToDate(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.set(5, 1);
    return localCalendar.getTime();
  }
  
  public static Date getEndToDate(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = getMonth(localCalendar);
    localCalendar.set(5, i);
    return localCalendar.getTime();
  }
  
  public static int getMonth(Calendar paramCalendar)
  {
    int i = paramCalendar.get(2) + 1;
    int j = paramCalendar.get(1);
    int k = 0;
    switch (i)
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    case 10: 
    case 12: 
      k = 31;
      break;
    case 2: 
      if (((j % 4 == 0) && (j % 100 != 0)) || (j % 400 == 0)) {
        k = 29;
      } else {
        k = 28;
      }
      break;
    case 4: 
    case 6: 
    case 9: 
    case 11: 
      k = 30;
    }
    return k;
  }
  
  public static Date changeDateToEndDate(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = localCalendar.get(5);
    localCalendar.set(5, i + 1);
    return localCalendar.getTime();
  }
  
  public static XMLGregorianCalendar getXMLGregorianCalendar(Date paramDate)
    throws Exception
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    DatatypeFactory localDatatypeFactory = DatatypeFactory.newInstance();
    return localDatatypeFactory.newXMLGregorianCalendar(localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5), localCalendar.get(10), localCalendar.get(12), localCalendar.get(13), localCalendar.get(14), localCalendar.get(15) / 60000);
  }
  
  public static Date convertToDate(XMLGregorianCalendar paramXMLGregorianCalendar)
    throws Exception
  {
    GregorianCalendar localGregorianCalendar = paramXMLGregorianCalendar.toGregorianCalendar();
    return localGregorianCalendar.getTime();
  }
  
  public static Date nextDays(Date paramDate, int paramInt)
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    localGregorianCalendar1.setTime(paramDate);
    GregorianCalendar localGregorianCalendar2 = (GregorianCalendar)localGregorianCalendar1.clone();
    localGregorianCalendar2.add(5, paramInt);
    return localGregorianCalendar2.getTime();
  }
  
  public static Date preDays(Date paramDate, int paramInt)
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    localGregorianCalendar1.setTime(paramDate);
    GregorianCalendar localGregorianCalendar2 = (GregorianCalendar)localGregorianCalendar1.clone();
    localGregorianCalendar2.add(5, -paramInt);
    return localGregorianCalendar2.getTime();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.DateUtil
 * JD-Core Version:    0.7.0.1
 */