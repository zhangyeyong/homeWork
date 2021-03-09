package com.zte.eas.infomap.business.notice.service.client;

import com.zte.eas.infomap.business.notice.service.client.email.MailDetailEntity;
import com.zte.eas.infomap.business.notice.service.client.email.SendUserEntity;
import com.zte.ssb.AccessPropertiesFile;
import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSendService
{
  private static final String GDYD_INTERFACE = "connectBpel.proerties";
  private static final String EMAIL_SERVER_HOST = "EMAIL_SERVER_HOST";
  private static final String EMAIL_SERVER_PORT = "EMAIL_SERVER_PORT";
  private static final String EMAIL_FROM_ADDRESS = "EMAIL_FROM_ADDRESS";
  private static final String EMAIL_USERNAME = "EMAIL_USERNAME";
  private static final String EMAIL_PASSWORD = "EMAIL_PASSWORD";
  
  public boolean sendMail(String paramString1, String paramString2, String paramString3)
  {
    String str1 = AccessPropertiesFile.getValue("EMAIL_SERVER_HOST", "connectBpel.proerties");
    String str2 = AccessPropertiesFile.getValue("EMAIL_SERVER_PORT", "connectBpel.proerties");
    String str3 = AccessPropertiesFile.getValue("EMAIL_FROM_ADDRESS", "connectBpel.proerties");
    String str4 = AccessPropertiesFile.getValue("EMAIL_USERNAME", "connectBpel.proerties");
    String str5 = AccessPropertiesFile.getValue("EMAIL_PASSWORD", "connectBpel.proerties");
    MailDetailEntity localMailDetailEntity = new MailDetailEntity();
    localMailDetailEntity.setMailServerHost(str1);
    localMailDetailEntity.setMailServerPort(str2);
    localMailDetailEntity.setValidate(true);
    localMailDetailEntity.setFromAddress(str3);
    localMailDetailEntity.setUserName(str4);
    localMailDetailEntity.setPassword(str5);
    localMailDetailEntity.setToAddress(paramString2);
    localMailDetailEntity.setSubject("邮件主题");
    localMailDetailEntity.setContent(paramString1);
    return sendHtmlMail(localMailDetailEntity);
  }
  
  public boolean sendTextMail(MailDetailEntity paramMailDetailEntity)
  {
    SendUserEntity localSendUserEntity = null;
    Properties localProperties = paramMailDetailEntity.getProperties();
    if (paramMailDetailEntity.isValidate()) {
      localSendUserEntity = new SendUserEntity(paramMailDetailEntity.getUserName(), paramMailDetailEntity.getPassword());
    }
    Session localSession = Session.getDefaultInstance(localProperties, localSendUserEntity);
    try
    {
      MimeMessage localMimeMessage = new MimeMessage(localSession);
      InternetAddress localInternetAddress1 = new InternetAddress(paramMailDetailEntity.getFromAddress());
      localMimeMessage.setFrom(localInternetAddress1);
      InternetAddress localInternetAddress2 = new InternetAddress(paramMailDetailEntity.getToAddress());
      localMimeMessage.setRecipient(Message.RecipientType.TO, localInternetAddress2);
      localMimeMessage.setSubject(paramMailDetailEntity.getSubject());
      localMimeMessage.setSentDate(new Date());
      String str = paramMailDetailEntity.getContent();
      localMimeMessage.setText(str);
      Transport.send(localMimeMessage);
      return true;
    }
    catch (MessagingException localMessagingException)
    {
      localMessagingException.printStackTrace();
    }
    return false;
  }
  
  public boolean sendHtmlMail(MailDetailEntity paramMailDetailEntity)
  {
    SendUserEntity localSendUserEntity = null;
    Properties localProperties = paramMailDetailEntity.getProperties();
    if (paramMailDetailEntity.isValidate()) {
      localSendUserEntity = new SendUserEntity(paramMailDetailEntity.getUserName(), paramMailDetailEntity.getPassword());
    }
    Session localSession = Session.getDefaultInstance(localProperties, localSendUserEntity);
    try
    {
      MimeMessage localMimeMessage = new MimeMessage(localSession);
      InternetAddress localInternetAddress1 = new InternetAddress(paramMailDetailEntity.getFromAddress());
      localMimeMessage.setFrom(localInternetAddress1);
      InternetAddress localInternetAddress2 = new InternetAddress(paramMailDetailEntity.getToAddress());
      localMimeMessage.setRecipient(Message.RecipientType.TO, localInternetAddress2);
      localMimeMessage.setSubject(paramMailDetailEntity.getSubject());
      localMimeMessage.setSentDate(new Date());
      MimeMultipart localMimeMultipart = new MimeMultipart();
      MimeBodyPart localMimeBodyPart = new MimeBodyPart();
      localMimeBodyPart.setContent(paramMailDetailEntity.getContent(), "text/html; charset=utf-8");
      localMimeMultipart.addBodyPart(localMimeBodyPart);
      localMimeMessage.setContent(localMimeMultipart);
      Transport.send(localMimeMessage);
      return true;
    }
    catch (MessagingException localMessagingException)
    {
      localMessagingException.printStackTrace();
    }
    return false;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.client.MailSendService
 * JD-Core Version:    0.7.0.1
 */