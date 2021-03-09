package com.zte.esb.util.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="StatusInfo", propOrder={"statusId", "timeStamp"})
public class StatusInfo
{
  @XmlElement(required=true)
  protected String statusId;
  protected long timeStamp;
  
  public String getStatusId()
  {
    return this.statusId;
  }
  
  public void setStatusId(String paramString)
  {
    this.statusId = paramString;
  }
  
  public long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.header.StatusInfo
 * JD-Core Version:    0.7.0.1
 */