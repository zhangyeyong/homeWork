package org.apache.axis.encoding.ser;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.xml.namespace.QName;

public class CalendarDeserializer
  extends SimpleDeserializer
{
  private static SimpleDateFormat zulu = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
  
  public CalendarDeserializer(Class paramClass, QName paramQName)
  {
    super(paramClass, paramQName);
    System.err.println("CalendarDeserializer");
  }
  
  public Object makeValue(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.trim();
    if (paramString.length() == 0) {
      return null;
    }
    if ((paramString.indexOf("+") < 0) && (paramString.indexOf("Z") < 0))
    {
      localObject1 = TimeZone.getDefault();
      if (localObject1 != null)
      {
        DecimalFormat localDecimalFormat = new DecimalFormat("'+'00':00'");
        int j = ((TimeZone)localObject1).getRawOffset() / 3600000;
        paramString = paramString.concat(localDecimalFormat.format(j));
      }
    }
    Object localObject1 = Calendar.getInstance();
    int i = 0;
    if (paramString.charAt(0) == '+') {
      paramString = paramString.substring(1);
    }
    if (paramString.charAt(0) == '-')
    {
      paramString = paramString.substring(1);
      i = 1;
    }
    if (paramString.length() < 19) {
      return null;
    }
    if ((paramString.charAt(4) != '-') || (paramString.charAt(7) != '-') || (paramString.charAt(10) != 'T')) {
      return null;
    }
    if ((paramString.charAt(13) != ':') || (paramString.charAt(16) != ':')) {
      return null;
    }
    Date localDate;
    try
    {
      synchronized (zulu)
      {
        localDate = zulu.parse(paramString.substring(0, 19) + ".000Z");
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    int k = 19;
    int m;
    int n;
    if ((k < paramString.length()) && (paramString.charAt(k) == '.'))
    {
      m = 0;
      k++;
      n = k;
      while ((k < paramString.length()) && (Character.isDigit(paramString.charAt(k)))) {
        k++;
      }
      String str = paramString.substring(n, k);
      if (str.length() == 3)
      {
        m = Integer.parseInt(str);
      }
      else if (str.length() < 3)
      {
        m = Integer.parseInt((str + "000").substring(0, 3));
      }
      else
      {
        m = Integer.parseInt(str.substring(0, 3));
        if (str.charAt(3) >= '5') {
          m++;
        }
      }
      localDate.setTime(localDate.getTime() + m);
    }
    if ((k + 5 < paramString.length()) && ((paramString.charAt(k) == '+') || (paramString.charAt(k) == '-')))
    {
      if ((!Character.isDigit(paramString.charAt(k + 1))) || (!Character.isDigit(paramString.charAt(k + 2))) || (paramString.charAt(k + 3) != ':') || (!Character.isDigit(paramString.charAt(k + 4))) || (!Character.isDigit(paramString.charAt(k + 5)))) {
        return null;
      }
      m = (paramString.charAt(k + 1) - '0') * 10 + paramString.charAt(k + 2) - 48;
      n = (paramString.charAt(k + 4) - '0') * 10 + paramString.charAt(k + 5) - 48;
      int i1 = (m * 60 + n) * 60 * 1000;
      if (paramString.charAt(k) == '+') {
        i1 = -i1;
      }
      localDate.setTime(localDate.getTime() + i1);
      k += 6;
    }
    if ((k < paramString.length()) && (paramString.charAt(k) == 'Z'))
    {
      k++;
      ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone("GMT"));
    }
    if (k < paramString.length()) {
      return null;
    }
    ((Calendar)localObject1).setTime(localDate);
    if (i != 0) {
      ((Calendar)localObject1).set(0, 0);
    }
    if (this.javaType == Date.class) {
      return localDate;
    }
    return localObject1;
  }
  
  static
  {
    zulu.setTimeZone(TimeZone.getTimeZone("GMT"));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     org.apache.axis.encoding.ser.CalendarDeserializer
 * JD-Core Version:    0.7.0.1
 */