package com.zte.eas.infomap.business.email.model;

public class EmailItemV
{
  private String sender;
  private String receiver;
  private String title;
  private String content;
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public String getReceiver()
  {
    return this.receiver;
  }
  
  public void setReceiver(String paramString)
  {
    this.receiver = paramString;
  }
  
  public String getSender()
  {
    return this.sender;
  }
  
  public void setSender(String paramString)
  {
    this.sender = paramString;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.email.model.EmailItemV
 * JD-Core Version:    0.7.0.1
 */