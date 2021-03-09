package com.zte.eas.infomap.business.notice.service.client.sms;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class TimestampSerializer
  extends JsonSerializer<Timestamp>
{
  public void serialize(Timestamp paramTimestamp, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String str = localSimpleDateFormat.format(new Date(paramTimestamp.getTime()));
    paramJsonGenerator.writeString(str);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.client.sms.TimestampSerializer
 * JD-Core Version:    0.7.0.1
 */