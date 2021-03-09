package com.zte.eas.infomap.business.notice.service.client.sms;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class SmsEntity
  implements Serializable
{
  private static final long serialVersionUID = 502553723350839131L;
  private String mobile;
  private String msgContent;
  private String sendDept;
  private String sender;
  private String msgType;
  private String msgSource;
  private String unionId;
  private String waybillNo;
  private String serviceType;
  private Timestamp latestSendTime;
  private Timestamp sendTime;
  private int repeatState;
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public void setMobile(String paramString)
  {
    this.mobile = paramString;
  }
  
  public String getMsgContent()
  {
    return this.msgContent;
  }
  
  public void setMsgContent(String paramString)
  {
    this.msgContent = paramString;
  }
  
  public String getSendDept()
  {
    return this.sendDept;
  }
  
  public void setSendDept(String paramString)
  {
    this.sendDept = paramString;
  }
  
  public String getSender()
  {
    return this.sender;
  }
  
  public void setSender(String paramString)
  {
    this.sender = paramString;
  }
  
  public String getMsgType()
  {
    return this.msgType;
  }
  
  public void setMsgType(String paramString)
  {
    this.msgType = paramString;
  }
  
  public String getMsgSource()
  {
    return this.msgSource;
  }
  
  public void setMsgSource(String paramString)
  {
    this.msgSource = paramString;
  }
  
  public void setUnionId(String paramString)
  {
    this.unionId = paramString;
  }
  
  public String getUnionId()
  {
    return this.unionId;
  }
  
  public void setWaybillNo(String paramString)
  {
    this.waybillNo = paramString;
  }
  
  public String getWaybillNo()
  {
    return this.waybillNo;
  }
  
  public void setServiceType(String paramString)
  {
    this.serviceType = paramString;
  }
  
  public String getServiceType()
  {
    return this.serviceType;
  }
  
  @JsonDeserialize(using=TimestampDeserializer.class)
  public void setSendTime(Timestamp paramTimestamp)
  {
    this.sendTime = paramTimestamp;
  }
  
  @XmlJavaTypeAdapter(TimestampAdapter.class)
  @JsonSerialize(using=TimestampSerializer.class)
  public Timestamp getSendTime()
  {
    return this.sendTime;
  }
  
  @JsonDeserialize(using=TimestampDeserializer.class)
  public void setLatestSendTime(Timestamp paramTimestamp)
  {
    this.latestSendTime = paramTimestamp;
  }
  
  @XmlJavaTypeAdapter(TimestampAdapter.class)
  @JsonSerialize(using=TimestampSerializer.class)
  public Timestamp getLatestSendTime()
  {
    return this.latestSendTime;
  }
  
  public int getRepeatState()
  {
    return this.repeatState;
  }
  
  public void setRepeatState(int paramInt)
  {
    this.repeatState = paramInt;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.client.sms.SmsEntity
 * JD-Core Version:    0.7.0.1
 */