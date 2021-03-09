package com.zte.eas.infomap.business.notice.service;

import com.zte.eas.infomap.business.common.service.ITemplateBuilder;
import com.zte.eas.infomap.business.email.model.EmailItemV;
import com.zte.eas.infomap.business.email.service.IEmailManager;
import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.eas.infomap.business.notice.service.client.MailSendService;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.ssb.context.ApplicationContext;
import com.zte.ssb.framework.SSBBus;
import com.zte.web.service.client.sendEmailPS.InputMessageType;
import com.zte.web.service.client.sendEmailPS.OutputMessageType;
import com.zte.web.service.proxy.ISendEmailClient;
import java.io.PrintStream;
import java.math.BigInteger;

public class EmailNoticeHandler
  implements INoticeHandler
{
  private ITemplateBuilder templateBuilder;
  private IEmailManager emailManager;
  private INoticeConfigurator noticeConfigurator;
  IFbpEmployeesVDAO fbpEmployeesVDAO;
  private ISendEmailClient sendEmail;
  protected ApplicationContext appContext = null;
  private MailSendService mailSendService;
  private static final String GDYD_INTERFACE = "connectBpel.proerties";
  private static final String EMAIL_XML_PATH = "SMS_XML_PATH";
  
  public void diposeNotice(String paramString, FbpNoticesNew paramFbpNoticesNew)
  {
    FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    localFbpNoticesNew = localIFbpNoticesNewDS.getFbpNoticesNew(paramFbpNoticesNew.getId());
    try
    {
      if ((paramString != null) && (paramString.indexOf("{email}") != -1))
      {
        if ("2".equals(paramFbpNoticesNew.getNoticeType()))
        {
          localFbpNoticesNew.setStatus(new Integer(-1));
          localFbpNoticesNew.setAttribute2("EMAIL: 邮件被过滤");
          localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        }
        return;
      }
      localFbpNoticesNew.getStatus().intValue();
      String str = null;
      if ((null == localFbpNoticesNew.getContent()) || ("".equals(localFbpNoticesNew.getContent()))) {
        str = this.templateBuilder.buildText("EMAIL", localFbpNoticesNew);
      } else {
        str = localFbpNoticesNew.getContent();
      }
      if ((null == str) || ("".equals(str)))
      {
        System.out.println("EMAIL 内容为空");
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute2("EMAIL: EMAIL 内容为空");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        return;
      }
      FbpEmployeesV localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesById(new BigInteger(localFbpNoticesNew.getToUserId()));
      EmailItemV localEmailItemV = new EmailItemV();
      if ((localFbpEmployeesV != null) && (localFbpEmployeesV.getEmailAddress() != null) && (!"".equals(localFbpEmployeesV.getEmailAddress())))
      {
        localEmailItemV.setReceiver(localFbpEmployeesV.getEmailAddress());
      }
      else
      {
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute2("EMAIL: 收件人或EMAIL地址为空");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        return;
      }
      localEmailItemV.setSender("eas@yd.com");
      localFbpNoticesNew.setAttribute4("Email:" + str + localFbpNoticesNew.getAttribute4());
      boolean bool = this.mailSendService.sendMail(str, localFbpEmployeesV.getEmailAddress(), localFbpEmployeesV.getEmployeeName());
      if (bool)
      {
        localFbpNoticesNew.setStatus(Integer.valueOf(1));
        localFbpNoticesNew.setAttribute2("EMAIL:" + bool);
        localFbpNoticesNew.setIsRuning("Y");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
      }
      else
      {
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute2("EMAIL:" + bool);
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
      }
    }
    catch (Exception localException)
    {
      System.out.println("EmailNoticeHandler ==> diposeNotice");
      localException.printStackTrace();
      localFbpNoticesNew.setStatus(new Integer(-1));
      localFbpNoticesNew.setAttribute2("EMAIL:" + localException.getMessage());
      localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
    }
  }
  
  public void diposeNoticeOld(String paramString, FbpNoticesNew paramFbpNoticesNew)
  {
    FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    localFbpNoticesNew = localIFbpNoticesNewDS.getFbpNoticesNew(paramFbpNoticesNew.getId());
    try
    {
      if ((paramString != null) && (paramString.indexOf("{email}") != -1))
      {
        if ("2".equals(paramFbpNoticesNew.getNoticeType()))
        {
          localFbpNoticesNew.setStatus(new Integer(-1));
          localFbpNoticesNew.setAttribute2("EMAIL: 邮件被过滤");
          localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        }
        return;
      }
      int i = localFbpNoticesNew.getStatus().intValue();
      String str1 = null;
      if ((null == localFbpNoticesNew.getContent()) || ("".equals(localFbpNoticesNew.getContent()))) {
        str1 = this.templateBuilder.buildText("EMAIL", localFbpNoticesNew);
      } else {
        str1 = localFbpNoticesNew.getContent();
      }
      if ((null == str1) || ("".equals(str1)))
      {
        System.out.println("EMAIL 内容为空");
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute2("EMAIL: EMAIL 内容为空");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        return;
      }
      FbpEmployeesV localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesById(new BigInteger(localFbpNoticesNew.getToUserId()));
      EmailItemV localEmailItemV = new EmailItemV();
      if ((localFbpEmployeesV != null) && (localFbpEmployeesV.getEmailAddress() != null) && (!"".equals(localFbpEmployeesV.getEmailAddress())))
      {
        localEmailItemV.setReceiver(localFbpEmployeesV.getEmailAddress());
      }
      else
      {
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute2("EMAIL: 收件人或EMAIL地址为空");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        return;
      }
      localEmailItemV.setSender("eas@yd.com");
      localFbpNoticesNew.setAttribute4("Email:" + str1 + localFbpNoticesNew.getAttribute4());
      InputMessageType localInputMessageType = new InputMessageType();
      localInputMessageType.setConsumerEmailID(localFbpNoticesNew.getId().toString());
      localInputMessageType.setMailTo(localFbpEmployeesV.getEmailAddress());
      localInputMessageType.setMailSubject(str1);
      localInputMessageType.setMailContent("");
      localInputMessageType.setMailCC(null);
      OutputMessageType localOutputMessageType = this.sendEmail.sendEmail(localInputMessageType);
      String str2 = null;
      if (localOutputMessageType != null) {
        str2 = localOutputMessageType.getResultFlag();
      }
      if ("S".equals(str2))
      {
        localFbpNoticesNew.setStatus(Integer.valueOf(1));
        localFbpNoticesNew.setAttribute2("EMAIL:" + str2);
        localFbpNoticesNew.setIsRuning("Y");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
      }
      else
      {
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute2("EMAIL:" + str2);
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
      }
    }
    catch (Exception localException)
    {
      System.out.println("EmailNoticeHandler ==> diposeNotice");
      localException.printStackTrace();
      localFbpNoticesNew.setStatus(new Integer(-1));
      localFbpNoticesNew.setAttribute2("EMAIL:" + localException.getMessage());
      localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
    }
  }
  
  public ITemplateBuilder getTemplateBuilder()
  {
    return this.templateBuilder;
  }
  
  public void setTemplateBuilder(ITemplateBuilder paramITemplateBuilder)
  {
    this.templateBuilder = paramITemplateBuilder;
  }
  
  public IEmailManager getEmailManager()
  {
    return this.emailManager;
  }
  
  public void setEmailManager(IEmailManager paramIEmailManager)
  {
    this.emailManager = paramIEmailManager;
  }
  
  public IFbpEmployeesVDAO getFbpEmployeesVDAO()
  {
    return this.fbpEmployeesVDAO;
  }
  
  public void setFbpEmployeesVDAO(IFbpEmployeesVDAO paramIFbpEmployeesVDAO)
  {
    this.fbpEmployeesVDAO = paramIFbpEmployeesVDAO;
  }
  
  public INoticeConfigurator getNoticeConfigurator()
  {
    return this.noticeConfigurator;
  }
  
  public void setNoticeConfigurator(INoticeConfigurator paramINoticeConfigurator)
  {
    this.noticeConfigurator = paramINoticeConfigurator;
  }
  
  public ISendEmailClient getSendEmail()
  {
    return this.sendEmail;
  }
  
  public void setSendEmail(ISendEmailClient paramISendEmailClient)
  {
    this.sendEmail = paramISendEmailClient;
  }
  
  public MailSendService getMailSendService()
  {
    return this.mailSendService;
  }
  
  public void setMailSendService(MailSendService paramMailSendService)
  {
    this.mailSendService = paramMailSendService;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.EmailNoticeHandler
 * JD-Core Version:    0.7.0.1
 */