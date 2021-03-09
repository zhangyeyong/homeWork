package com.zte.eas.infomap.business.notice.service.client.email;

import com.zte.ssb.stereotype.Repository;
import java.util.Properties;

@Repository
public class MailDetailEntity
{
  private String mailServerHost;
  private String mailServerPort;
  private String fromAddress;
  private String toAddress;
  private String userName;
  private String password;
  private boolean validate = false;
  private String subject;
  private String content;
  private String[] attachFileNames;
  
  public Properties getProperties()
  {
    Properties localProperties = new Properties();
    localProperties.put("mail.smtp.host", this.mailServerHost);
    localProperties.put("mail.smtp.port", this.mailServerPort);
    localProperties.put("mail.smtp.auth", this.validate ? "true" : "false");
    localProperties.put("mail.smtp.connectiontimeout", Integer.valueOf(6000));
    localProperties.put("mail.smtp.timeout", Integer.valueOf(6000));
    return localProperties;
  }
  
  public String getMailServerHost()
  {
    return this.mailServerHost;
  }
  
  public void setMailServerHost(String paramString)
  {
    this.mailServerHost = paramString;
  }
  
  public String getMailServerPort()
  {
    return this.mailServerPort;
  }
  
  public void setMailServerPort(String paramString)
  {
    this.mailServerPort = paramString;
  }
  
  public boolean isValidate()
  {
    return this.validate;
  }
  
  public void setValidate(boolean paramBoolean)
  {
    this.validate = paramBoolean;
  }
  
  public String[] getAttachFileNames()
  {
    return this.attachFileNames;
  }
  
  public void setAttachFileNames(String[] paramArrayOfString)
  {
    this.attachFileNames = paramArrayOfString;
  }
  
  public String getFromAddress()
  {
    return this.fromAddress;
  }
  
  public void setFromAddress(String paramString)
  {
    this.fromAddress = paramString;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public String getToAddress()
  {
    return this.toAddress;
  }
  
  public void setToAddress(String paramString)
  {
    this.toAddress = paramString;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.client.email.MailDetailEntity
 * JD-Core Version:    0.7.0.1
 */