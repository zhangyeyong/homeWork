package com.zte.eas.infomap.business.notice.service.client.sms;

import java.sql.Timestamp;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimestampAdapter
  extends XmlAdapter<Date, Timestamp>
{
  public Date marshal(Timestamp paramTimestamp)
    throws Exception
  {
    return new Date(paramTimestamp.getTime());
  }
  
  public Timestamp unmarshal(Date paramDate)
    throws Exception
  {
    return new Timestamp(paramDate.getTime());
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.client.sms.TimestampAdapter
 * JD-Core Version:    0.7.0.1
 */