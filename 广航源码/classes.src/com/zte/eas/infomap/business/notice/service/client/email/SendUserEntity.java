package com.zte.eas.infomap.business.notice.service.client.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SendUserEntity
  extends Authenticator
{
  private String userName = null;
  private String password = null;
  
  public SendUserEntity() {}
  
  public SendUserEntity(String paramString1, String paramString2)
  {
    this.userName = paramString1;
    this.password = paramString2;
  }
  
  protected PasswordAuthentication getPasswordAuthentication()
  {
    return new PasswordAuthentication(this.userName, this.password);
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.client.email.SendUserEntity
 * JD-Core Version:    0.7.0.1
 */