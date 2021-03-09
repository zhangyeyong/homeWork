package com.zte.eas.infomap.business.sms.model;

public class SmsItemV
{
  private String content;
  private Long boeHeaderId;
  private String receivers;
  private String userId;
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
  
  public Long getBoeHeaderId()
  {
    return this.boeHeaderId;
  }
  
  public void setBoeHeaderId(Long paramLong)
  {
    this.boeHeaderId = paramLong;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public String getReceivers()
  {
    return this.receivers;
  }
  
  public void setReceivers(String paramString)
  {
    this.receivers = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.sms.model.SmsItemV
 * JD-Core Version:    0.7.0.1
 */