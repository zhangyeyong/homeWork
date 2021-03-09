package com.zte.eas.infomap.business.notice.service.client.sms;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class TimestampDeserializer
  extends JsonDeserializer<Timestamp>
{
  public Timestamp deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    String str = paramJsonParser.getText();
    Timestamp localTimestamp = stringToTimestamp(str, "yyyy-MM-dd HH:mm:ss");
    return localTimestamp;
  }
  
  private Timestamp stringToTimestamp(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || ("".equals(paramString1.trim()))) {
      return null;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString2);
    try
    {
      return new Timestamp(localSimpleDateFormat.parse(paramString1).getTime());
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.client.sms.TimestampDeserializer
 * JD-Core Version:    0.7.0.1
 */