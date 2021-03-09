package com.zte.esb.util;

import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;

public final class DataTypeAdapter
{
  public static Date parseDate(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return DatatypeConverter.parseDate(paramString).getTime();
  }
  
  public static String printDate(Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return DatatypeConverter.printDate(localCalendar);
  }
  
  public static Date parseTime(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return DatatypeConverter.parseTime(paramString).getTime();
  }
  
  public static String printTime(Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return DatatypeConverter.printTime(localCalendar);
  }
  
  public static Date parseDateTime(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return DatatypeConverter.parseDateTime(paramString).getTime();
  }
  
  public static String printDateTime(Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return DatatypeConverter.printDateTime(localCalendar);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.DataTypeAdapter
 * JD-Core Version:    0.7.0.1
 */