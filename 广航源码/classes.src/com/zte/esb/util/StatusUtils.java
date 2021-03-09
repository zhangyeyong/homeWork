package com.zte.esb.util;

import com.zte.esb.util.header.StatusInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.jms.core.JmsTemplate;
import com.zte.ssb.jms.core.MessageCreator;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

public class StatusUtils
{
  private static final String JMSTEMPLETENAME = "senderStatusReqMsgJmsTemplate";
  private static HashMap tmpMap = new HashMap();
  
  public static HashMap getTmpMap()
  {
    return tmpMap;
  }
  
  public static void setTmpMap(Object paramObject1, Object paramObject2)
  {
    tmpMap.put(paramObject1, paramObject2);
  }
  
  public static void removeTmpMap(String paramString)
  {
    tmpMap.remove(paramString);
  }
  
  public static void sendStatus(Message paramMessage, final StatusInfo... paramVarArgs)
  {
    JmsTemplate localJmsTemplate = initJmsTemplate();
    if (localJmsTemplate == null) {
      initJmsTemplate();
    }
    localJmsTemplate.send(new MessageCreator()
    {
      public Message createMessage(Session paramAnonymousSession)
        throws JMSException
      {
        TextMessage localTextMessage = paramAnonymousSession.createTextMessage();
        StatusUtils.generateHeader(this.val$msg, localTextMessage);
        localTextMessage.setText(StatusUtils.generateBody(paramVarArgs));
        return localTextMessage;
      }
    });
  }
  
  public static JmsTemplate initJmsTemplate()
  {
    JmsTemplate localJmsTemplate = (JmsTemplate)SSBBus.findDomainService("senderStatusReqMsgJmsTemplate");
    return localJmsTemplate;
  }
  
  public static void generateHeader(Message paramMessage1, Message paramMessage2)
    throws JMSException
  {
    Enumeration localEnumeration = paramMessage1.getPropertyNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      paramMessage2.setObjectProperty(str, paramMessage1.getObjectProperty(str));
    }
  }
  
  public static String generateBody(StatusInfo... paramVarArgs)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = null;
    for (int i = 0; i < paramVarArgs.length; i++) {
      if ((paramVarArgs[i].getStatusId() != null) && (!"".equals(paramVarArgs[i].getStatusId()))) {
        if (i < paramVarArgs.length - 1) {
          localStringBuffer.append(paramVarArgs[i].getStatusId()).append("@").append(paramVarArgs[i].getTimeStamp()).append(":");
        } else {
          localStringBuffer.append(paramVarArgs[i].getStatusId()).append("@").append(paramVarArgs[i].getTimeStamp());
        }
      }
    }
    try
    {
      str = new String(localStringBuffer.toString().getBytes(), "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return str;
  }
  
  public static StatusInfo[] getStatusInfos(int paramInt)
  {
    StatusInfo[] arrayOfStatusInfo = new StatusInfo[paramInt];
    for (int i = 0; i < paramInt; i++)
    {
      StatusInfo localStatusInfo = new StatusInfo();
      arrayOfStatusInfo[i] = localStatusInfo;
    }
    return arrayOfStatusInfo;
  }
  
  public static void send(Message paramMessage, String paramString)
  {
    StatusInfo[] arrayOfStatusInfo = getStatusInfos(1);
    arrayOfStatusInfo[0].setStatusId(paramString);
    arrayOfStatusInfo[0].setTimeStamp(new Date().getTime());
    sendStatus(paramMessage, arrayOfStatusInfo);
  }
  
  public static void sendStatus(Message paramMessage, final String paramString, final StatusInfo... paramVarArgs)
  {
    JmsTemplate localJmsTemplate = initJmsTemplate();
    if (localJmsTemplate == null) {
      initJmsTemplate();
    }
    localJmsTemplate.send(new MessageCreator()
    {
      public Message createMessage(Session paramAnonymousSession)
        throws JMSException
      {
        TextMessage localTextMessage = paramAnonymousSession.createTextMessage();
        StatusUtils.generateHeader(this.val$msg, localTextMessage);
        localTextMessage.setStringProperty("responseId", paramString);
        localTextMessage.setText(StatusUtils.generateBody(paramVarArgs));
        return localTextMessage;
      }
    });
  }
  
  public static void send(Message paramMessage, String paramString1, String paramString2)
  {
    StatusInfo[] arrayOfStatusInfo = getStatusInfos(1);
    arrayOfStatusInfo[0].setStatusId(paramString1);
    arrayOfStatusInfo[0].setTimeStamp(new Date().getTime());
    sendStatus(paramMessage, paramString2, arrayOfStatusInfo);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.StatusUtils
 * JD-Core Version:    0.7.0.1
 */