package com.zte.web.service.esp;

public class EspMessage
{
  private String messageId;
  private String title;
  private String userName;
  private String actionTime;
  private String createDateTime;
  private String stateCode;
  
  public String getMessageId()
  {
    return this.messageId;
  }
  
  public void setMessageId(String paramString)
  {
    this.messageId = paramString;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getCreateDateTime()
  {
    return this.createDateTime;
  }
  
  public void setCreateDateTime(String paramString)
  {
    this.createDateTime = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public String getActionTime()
  {
    return this.actionTime;
  }
  
  public void setActionTime(String paramString)
  {
    this.actionTime = paramString;
  }
  
  public String getStateCode()
  {
    return this.stateCode;
  }
  
  public void setStateCode(String paramString)
  {
    this.stateCode = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.esp.EspMessage
 * JD-Core Version:    0.7.0.1
 */