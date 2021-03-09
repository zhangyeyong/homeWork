package org.apache.axis.encoding.ser;

import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.xml.namespace.QName;
import org.apache.axis.encoding.SerializationContext;
import org.apache.axis.encoding.SimpleValueSerializer;
import org.apache.axis.wsdl.fromJava.Types;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;

public class CalendarSerializer
  implements SimpleValueSerializer
{
  private static SimpleDateFormat zulu;
  private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
  
  public CalendarSerializer()
  {
    System.err.println("CalendarSerializer");
  }
  
  public void serialize(QName paramQName, Attributes paramAttributes, Object paramObject, SerializationContext paramSerializationContext)
    throws IOException
  {
    paramSerializationContext.startElement(paramQName, paramAttributes);
    paramSerializationContext.writeString(getValueAsString(paramObject, paramSerializationContext));
    paramSerializationContext.endElement();
  }
  
  public String getValueAsString(Object paramObject, SerializationContext paramSerializationContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Date localDate = (paramObject instanceof Date) ? (Date)paramObject : ((Calendar)paramObject).getTime();
    localStringBuffer.append(df.format(localDate));
    TimeZone localTimeZone = TimeZone.getDefault();
    if (localTimeZone != null)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("'+'00':00'");
      int i = localTimeZone.getRawOffset() / 3600000;
    }
    return localStringBuffer.toString();
  }
  
  public String getMechanismType()
  {
    return "Axis SAX Mechanism";
  }
  
  public Element writeSchema(Class paramClass, Types paramTypes)
    throws Exception
  {
    return null;
  }
  
  static
  {
    zulu = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    zulu.setTimeZone(TimeZone.getTimeZone("GMT"));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     org.apache.axis.encoding.ser.CalendarSerializer
 * JD-Core Version:    0.7.0.1
 */