package com.zte.eas.infomap.business.notice.service.client;

import com.zte.eas.infomap.business.notice.service.client.sms.MD5Encrypt;
import com.zte.eas.infomap.business.notice.service.client.sms.SmsEntity;
import com.zte.eas.infomap.business.notice.service.client.sms.SmsReturn;
import com.zte.ssb.AccessPropertiesFile;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SmsSendService
{
  private static final Logger log = Logger.getLogger(SmsSendService.class);
  private static final String GDYD_INTERFACE = "connectBpel.proerties";
  private static final String NEW_SMS_MSG_TYPE = "NEW_SMS_MSG_TYPE";
  private static final String NEW_SMS_MSG_SOURCE = "NEW_SMS_MSG_SOURCE";
  private static final String NEW_SMS_USERNAME = "NEW_SMS_USERNAME";
  private static final String NEW_SMS_PASSWORD = "NEW_SMS_PASSWORD";
  private static final String NEW_SMS_HTTP_URL = "NEW_SMS_HTTP_URL";
  
  public String sendOneMessage(String paramString1, String paramString2)
  {
    SmsEntity localSmsEntity = new SmsEntity();
    HttpClient localHttpClient = new HttpClient();
    String str1 = AccessPropertiesFile.getValue("NEW_SMS_MSG_TYPE", "connectBpel.proerties");
    String str2 = AccessPropertiesFile.getValue("NEW_SMS_MSG_SOURCE", "connectBpel.proerties");
    String str3 = AccessPropertiesFile.getValue("NEW_SMS_USERNAME", "connectBpel.proerties");
    String str4 = AccessPropertiesFile.getValue("NEW_SMS_PASSWORD", "connectBpel.proerties");
    String str5 = AccessPropertiesFile.getValue("NEW_SMS_HTTP_URL", "connectBpel.proerties");
    PostMethod localPostMethod = new PostMethod(str5);
    ArrayList localArrayList = new ArrayList();
    localSmsEntity.setMobile(paramString1);
    localSmsEntity.setMsgContent(paramString2);
    localSmsEntity.setMsgSource(str2);
    localSmsEntity.setMsgType(str1);
    localSmsEntity.setSendTime(new Timestamp(new Date().getTime()));
    localSmsEntity.setServiceType("1");
    localSmsEntity.setUnionId(str2 + new Date().getTime());
    localArrayList.add(localSmsEntity);
    ObjectMapper localObjectMapper = new ObjectMapper();
    StringWriter localStringWriter = new StringWriter();
    try
    {
      localObjectMapper.writeValue(localStringWriter, localArrayList);
    }
    catch (JsonGenerationException localJsonGenerationException)
    {
      log.error(localJsonGenerationException.getMessage());
    }
    catch (JsonMappingException localJsonMappingException)
    {
      log.error(localJsonMappingException.getMessage());
    }
    catch (IOException localIOException1)
    {
      log.error(localIOException1.getMessage());
    }
    String str6 = MD5Encrypt.encrypt(str3 + str4);
    localPostMethod.getParams().setContentCharset("UTF-8");
    localPostMethod.setRequestBody(new NameValuePair[] { new NameValuePair("data_digest", str6), new NameValuePair("smsInfo", localStringWriter.getBuffer().toString()) });
    int i = 0;
    String str7 = "";
    try
    {
      i = localHttpClient.executeMethod(localPostMethod);
      if (i == 200)
      {
        SmsReturn localSmsReturn = (SmsReturn)localObjectMapper.readValue(localPostMethod.getResponseBody(), SmsReturn.class);
        str7 = localSmsReturn.getResultCode();
      }
      log.info("短信发送状态返回：" + str7);
    }
    catch (HttpException localHttpException)
    {
      log.error(localHttpException.getMessage(), localHttpException);
      str7 = "3000";
    }
    catch (IOException localIOException2)
    {
      log.error(localIOException2.getMessage(), localIOException2);
      str7 = "4000";
    }
    return str7;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.client.SmsSendService
 * JD-Core Version:    0.7.0.1
 */