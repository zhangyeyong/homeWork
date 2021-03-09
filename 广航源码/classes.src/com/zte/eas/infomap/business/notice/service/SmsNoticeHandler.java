package com.zte.eas.infomap.business.notice.service;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.zte.eas.infomap.business.common.service.ITemplateBuilder;
import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.eas.infomap.business.notice.service.client.SmsSendService;
import com.zte.eas.infomap.business.notice.service.client.sms.SmsEntity;
import com.zte.eas.infomap.business.sms.model.SmsItemV;
import com.zte.eas.infomap.business.sms.service.ISmsManager;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.context.ApplicationContext;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.web.service.client.sendMSMService.CoreSMSReplyType;
import com.zte.web.service.client.sendMSMService.CoreSMSType;
import com.zte.web.service.client.sendMSMService.MessageType;
import com.zte.web.service.proxy.ISendMSMClient;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsNoticeHandler
  implements INoticeHandler
{
  private ITemplateBuilder templateBuilder;
  private ISmsManager smsManager;
  IFbpEmployeesVDAO fbpEmployeesVDAO;
  private ISendMSMClient sendMSM;
  private static final String GDYD_INTERFACE = "connectBpel.proerties";
  private static final String DEPARTMENT_NO = "DEPARTMENT_NO";
  private static final String SMS_USERNAME = "SMS_USERNAME";
  private static final String SMS_PASSWORD = "SMS_PASSWORD";
  private static final String SMS_XML_PATH = "SMS_XML_PATH";
  Log log = SSBBus.getLog(SmsNoticeHandler.class);
  protected ApplicationContext appContext = null;
  private SmsSendService smsSendService;
  
  @Before
  public void diposeNotice(String paramString, FbpNoticesNew paramFbpNoticesNew)
  {
    this.log.error("SMS diposeNotice begin new");
    FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    localFbpNoticesNew = localIFbpNoticesNewDS.getFbpNoticesNew(paramFbpNoticesNew.getId());
    try
    {
      if ((paramString != null) && (paramString.indexOf("{sms}") != -1))
      {
        this.log.error("filteStr:" + paramString);
        if ("1".equals(paramFbpNoticesNew.getNoticeType()))
        {
          localFbpNoticesNew.setStatus(new Integer(-1));
          localFbpNoticesNew.setAttribute3("SMS: 短信被过滤");
          localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        }
        return;
      }
      int i = localFbpNoticesNew.getStatus().intValue();
      String str1 = null;
      if ((null == localFbpNoticesNew.getContent()) || ("".equals(localFbpNoticesNew.getContent()))) {
        str1 = this.templateBuilder.buildText("SMS", localFbpNoticesNew);
      } else {
        str1 = localFbpNoticesNew.getContent();
      }
      if ((null == str1) || ("".equals(str1)))
      {
        this.log.error("SMS 内容为空");
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute3("SMS: SMS 内容为空");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        return;
      }
      FbpEmployeesV localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesById(new BigInteger(localFbpNoticesNew.getToUserId()));
      SmsItemV localSmsItemV = new SmsItemV();
      localSmsItemV.setUserId(localFbpNoticesNew.getToUserId());
      if ((localFbpEmployeesV != null) && (!localFbpEmployeesV.equals("")) && (((localFbpEmployeesV.getMobilePhone() != null) && (!localFbpEmployeesV.getMobilePhone().equals(""))) || ((localFbpEmployeesV.getPhone() != null) && (!localFbpEmployeesV.getPhone().equals("")))))
      {
        if ((localFbpEmployeesV.getMobilePhone() != null) && (!localFbpEmployeesV.getMobilePhone().equals(""))) {
          localSmsItemV.setReceivers(localFbpEmployeesV.getMobilePhone());
        } else {
          localSmsItemV.setReceivers(localFbpEmployeesV.getPhone());
        }
      }
      else
      {
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute3("SMS: 收信人或手机号码为空");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        return;
      }
      localSmsItemV.setContent(str1);
      localSmsItemV.setBoeHeaderId(localFbpNoticesNew.getId());
      localFbpNoticesNew.setAttribute4("SMS:" + str1 + localFbpNoticesNew.getAttribute4());
      SmsEntity localSmsEntity = new SmsEntity();
      if ((localFbpEmployeesV.getMobilePhone() != null) && (!localFbpEmployeesV.getMobilePhone().equals(""))) {
        localSmsEntity.setMobile(localFbpEmployeesV.getMobilePhone());
      } else {
        localSmsEntity.setMobile(localFbpEmployeesV.getPhone());
      }
      localSmsEntity.setMsgContent(str1);
      this.log.error("sendMSM.sendMSM start:" + localSmsEntity.getMobile() + ";message:" + localSmsEntity.getMsgContent());
      String str2 = this.smsSendService.sendOneMessage(localSmsEntity.getMobile(), localSmsEntity.getMsgContent());
      if ("1000".equals(str2))
      {
        this.log.error("isSuccess 1 :" + str2);
        localFbpNoticesNew.setStatus(new Integer(1));
        localFbpNoticesNew.setAttribute3("SMS:" + str2);
        localFbpNoticesNew.setIsRuning("Y");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
      }
      else
      {
        this.log.error("isSuccess 2 :" + str2);
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute3("SMS:" + str2);
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
      }
    }
    catch (Exception localException)
    {
      this.log.error("SmsNoticeHandler ==> diposeNotice");
      localException.printStackTrace();
      this.log.error("SMS diposeNotice exception:", localException);
      localFbpNoticesNew.setStatus(new Integer(-1));
      localFbpNoticesNew.setAttribute3("SMS:" + localException.getMessage());
      localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
    }
  }
  
  public void diposeNoticeOld(String paramString, FbpNoticesNew paramFbpNoticesNew)
  {
    this.log.error("SMS diposeNotice begin new");
    FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    localFbpNoticesNew = localIFbpNoticesNewDS.getFbpNoticesNew(paramFbpNoticesNew.getId());
    try
    {
      if ((paramString != null) && (paramString.indexOf("{sms}") != -1))
      {
        this.log.error("filteStr:" + paramString);
        if ("1".equals(paramFbpNoticesNew.getNoticeType()))
        {
          localFbpNoticesNew.setStatus(new Integer(-1));
          localFbpNoticesNew.setAttribute3("SMS: 短信被过滤");
          localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        }
        return;
      }
      int i = localFbpNoticesNew.getStatus().intValue();
      String str1 = null;
      if ((null == localFbpNoticesNew.getContent()) || ("".equals(localFbpNoticesNew.getContent()))) {
        str1 = this.templateBuilder.buildText("SMS", localFbpNoticesNew);
      } else {
        str1 = localFbpNoticesNew.getContent();
      }
      if ((null == str1) || ("".equals(str1)))
      {
        this.log.error("SMS 内容为空");
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute3("SMS: SMS 内容为空");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        return;
      }
      FbpEmployeesV localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesById(new BigInteger(localFbpNoticesNew.getToUserId()));
      SmsItemV localSmsItemV = new SmsItemV();
      localSmsItemV.setUserId(localFbpNoticesNew.getToUserId());
      if ((localFbpEmployeesV != null) && (!localFbpEmployeesV.equals("")) && (((localFbpEmployeesV.getMobilePhone() != null) && (!localFbpEmployeesV.getMobilePhone().equals(""))) || ((localFbpEmployeesV.getPhone() != null) && (!localFbpEmployeesV.getPhone().equals("")))))
      {
        if ((localFbpEmployeesV.getMobilePhone() != null) && (!localFbpEmployeesV.getMobilePhone().equals(""))) {
          localSmsItemV.setReceivers(localFbpEmployeesV.getMobilePhone());
        } else {
          localSmsItemV.setReceivers(localFbpEmployeesV.getPhone());
        }
      }
      else
      {
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute3("SMS: 收信人或手机号码为空");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
        return;
      }
      localSmsItemV.setContent(str1);
      localSmsItemV.setBoeHeaderId(localFbpNoticesNew.getId());
      localFbpNoticesNew.setAttribute4("SMS:" + str1 + localFbpNoticesNew.getAttribute4());
      CoreSMSType localCoreSMSType = new CoreSMSType();
      this.log.error("input start:");
      String str2 = AccessPropertiesFile.getValue("DEPARTMENT_NO", "connectBpel.proerties");
      this.log.error("input departmentNO:" + str2);
      String str3 = AccessPropertiesFile.getValue("SMS_USERNAME", "connectBpel.proerties");
      this.log.error("input operID:" + str3);
      String str4 = AccessPropertiesFile.getValue("SMS_PASSWORD", "connectBpel.proerties");
      this.log.error("input operPass:" + str4);
      localCoreSMSType.setDepartmentNO(str2);
      localCoreSMSType.setConsumeSMSID(localFbpNoticesNew.getId().toString());
      localCoreSMSType.setOperID(str3);
      localCoreSMSType.setOperPass(str4);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
      localCoreSMSType.setSendTime(localSimpleDateFormat.format(new Date()));
      MessageType localMessageType = new MessageType();
      MessageType[] arrayOfMessageType = new MessageType[1];
      if ((localFbpEmployeesV.getMobilePhone() != null) && (!localFbpEmployeesV.getMobilePhone().equals(""))) {
        localMessageType.setDesMobile(localFbpEmployeesV.getMobilePhone());
      } else {
        localMessageType.setDesMobile(localFbpEmployeesV.getPhone());
      }
      localMessageType.setContent(str1);
      arrayOfMessageType[0] = localMessageType;
      localCoreSMSType.setMessage(arrayOfMessageType);
      this.log.error("sendMSM.sendMSM start:" + localMessageType.getDesMobile() + ";message:" + localMessageType.getContent());
      CoreSMSReplyType localCoreSMSReplyType = this.sendMSM.sendMSM(localCoreSMSType);
      this.log.error("out code:" + localCoreSMSReplyType.getCode());
      String str5 = null;
      if (localCoreSMSReplyType != null) {
        str5 = localCoreSMSReplyType.getCode();
      }
      if ((str5 != null) && (str5.equals("0")))
      {
        this.log.error("isSuccess 1 :" + str5);
        localFbpNoticesNew.setStatus(new Integer(1));
        localFbpNoticesNew.setAttribute3("SMS:" + str5);
        localFbpNoticesNew.setIsRuning("Y");
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
      }
      else
      {
        this.log.error("isSuccess 2 :" + str5);
        localFbpNoticesNew.setStatus(new Integer(-1));
        localFbpNoticesNew.setAttribute3("SMS:" + str5);
        localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
      }
    }
    catch (Exception localException)
    {
      this.log.error("SmsNoticeHandler ==> diposeNotice");
      localException.printStackTrace();
      this.log.error("SMS diposeNotice exception:", localException);
      localFbpNoticesNew.setStatus(new Integer(-1));
      localFbpNoticesNew.setAttribute3("SMS:" + localException.getMessage());
      localIFbpNoticesNewDS.updateFbpNoticesNew(localFbpNoticesNew);
    }
  }
  
  public ISmsManager getSmsManager()
  {
    return this.smsManager;
  }
  
  public void setSmsManager(ISmsManager paramISmsManager)
  {
    this.smsManager = paramISmsManager;
  }
  
  public void setTemplateBuilder(ITemplateBuilder paramITemplateBuilder)
  {
    this.templateBuilder = paramITemplateBuilder;
  }
  
  public ITemplateBuilder getTemplateBuilder()
  {
    return this.templateBuilder;
  }
  
  public IFbpEmployeesVDAO getFbpEmployeesVDAO()
  {
    return this.fbpEmployeesVDAO;
  }
  
  public void setFbpEmployeesVDAO(IFbpEmployeesVDAO paramIFbpEmployeesVDAO)
  {
    this.fbpEmployeesVDAO = paramIFbpEmployeesVDAO;
  }
  
  public ISendMSMClient getSendMSM()
  {
    return this.sendMSM;
  }
  
  public void setSendMSM(ISendMSMClient paramISendMSMClient)
  {
    this.sendMSM = paramISendMSMClient;
  }
  
  public SmsSendService getSmsSendService()
  {
    return this.smsSendService;
  }
  
  public void setSmsSendService(SmsSendService paramSmsSendService)
  {
    this.smsSendService = paramSmsSendService;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.SmsNoticeHandler
 * JD-Core Version:    0.7.0.1
 */