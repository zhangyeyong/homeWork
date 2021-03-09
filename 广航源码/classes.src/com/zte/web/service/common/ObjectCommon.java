package com.zte.web.service.common;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class ObjectCommon
{
  public static Date strToDate(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = new Integer(paramString.substring(0, 4)).intValue();
    int j = new Integer(paramString.substring(5, 7)).intValue() - 1;
    int k = new Integer(paramString.substring(8, 10)).intValue();
    int m = new Integer(paramString.substring(11, 13)).intValue();
    int n = new Integer(paramString.substring(14, 16)).intValue();
    int i1 = new Integer(paramString.substring(17, 19)).intValue();
    localCalendar.set(1, i);
    localCalendar.set(2, j);
    localCalendar.set(5, k);
    localCalendar.set(11, m);
    localCalendar.set(12, n);
    localCalendar.set(13, i1);
    return localCalendar.getTime();
  }
  
  public static Calendar dateToCalendar(Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar;
  }
  
  public static String dateToString(Date paramDate)
  {
    Calendar localCalendar = dateToCalendar(paramDate);
    String str = localCalendar.get(1) + "-" + (localCalendar.get(2) + 1) + "-" + localCalendar.get(5) + " " + localCalendar.get(11) + ":" + localCalendar.get(12) + ":" + localCalendar.get(13);
    return str;
  }
  
  public static String CalendarToString(Calendar paramCalendar)
  {
    String str = paramCalendar.get(1) + "-" + (paramCalendar.get(2) + 1) + "-" + paramCalendar.get(5) + " " + paramCalendar.get(11) + ":" + paramCalendar.get(12) + ":" + paramCalendar.get(13);
    return str;
  }
  
  public static void copy(Object paramObject1, Object paramObject2)
    throws SecurityException, NoSuchFieldException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    Class localClass1 = paramObject1.getClass();
    Class localClass2 = paramObject2.getClass();
    Field[] arrayOfField1 = localClass1.getDeclaredFields();
    for (Field localField : arrayOfField1)
    {
      String str1 = localField.getName();
      String str2 = "get" + str1.substring(0, 1).toUpperCase() + str1.substring(1, str1.length());
      String str3 = "set" + str1.substring(0, 1).toUpperCase() + str1.substring(1, str1.length());
      System.out.println(str2);
      System.out.println(str3);
      if ((isExistField(localClass2, str1)) && (localField.getType().toString().equals(localClass2.getDeclaredField(str1).getType().toString())))
      {
        Method localMethod1 = localClass1.getMethod(str2, new Class[0]);
        Method localMethod2 = localClass2.getMethod(str3, new Class[] { localField.getType() });
        Object localObject = localMethod1.invoke(paramObject1, new Object[0]);
        localMethod2.invoke(paramObject2, new Object[] { localObject });
      }
    }
  }
  
  public static boolean isExistField(Class paramClass, String paramString)
  {
    boolean bool = false;
    try
    {
      paramClass.getDeclaredField(paramString);
      bool = true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return bool;
  }
  
  public static boolean isArray(Object paramObject)
  {
    boolean bool = false;
    try
    {
      Array.getLength(paramObject);
      bool = true;
    }
    catch (Exception localException) {}
    return bool;
  }
  
  public static void main(String[] paramArrayOfString) {}
  
  public static String dateToPeriod(Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy/MM");
    String str1 = localSimpleDateFormat.format(paramDate);
    String str2 = str1.substring(0, 2);
    String str3 = str1.substring(3, 5);
    if ("01".equals(str3)) {
      str3 = "JAN";
    }
    if ("02".equals(str3)) {
      str3 = "FEB";
    }
    if ("03".equals(str3)) {
      str3 = "MAR";
    }
    if ("04".equals(str3)) {
      str3 = "APR";
    }
    if ("05".equals(str3)) {
      str3 = "MAY";
    }
    if ("06".equals(str3)) {
      str3 = "JUN";
    }
    if ("07".equals(str3)) {
      str3 = "JUL";
    }
    if ("08".equals(str3)) {
      str3 = "AUG";
    }
    if ("09".equals(str3)) {
      str3 = "SEP";
    }
    if ("10".equals(str3)) {
      str3 = "OCT";
    }
    if ("11".equals(str3)) {
      str3 = "NOV";
    }
    if ("12".equals(str3)) {
      str3 = "DEC";
    }
    return str3 + "-" + str2;
  }
  
  public static XMLGregorianCalendar calendarToXmlCalendar(Calendar paramCalendar)
  {
    try
    {
      DatatypeFactory localDatatypeFactory = DatatypeFactory.newInstance();
      return localDatatypeFactory.newXMLGregorianCalendar(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5), paramCalendar.get(10), paramCalendar.get(12), paramCalendar.get(13), paramCalendar.get(14), paramCalendar.get(15) / 60000);
    }
    catch (DatatypeConfigurationException localDatatypeConfigurationException)
    {
      localDatatypeConfigurationException.printStackTrace();
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.common.ObjectCommon
 * JD-Core Version:    0.7.0.1
 */