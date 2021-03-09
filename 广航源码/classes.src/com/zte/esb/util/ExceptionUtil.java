package com.zte.esb.util;

import com.zte.esb.util.exception.CommonExceptionInfo;
import com.zte.esb.util.exception.ObjectFactory;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.jms.core.JmsTemplate;
import com.zte.ssb.jms.core.MessageCreator;
import java.io.StringWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExceptionUtil
{
  private static final String JMSTEMPLETENAME = "senderExcepReqMsgJmsTemplate";
  private static Log log = LogFactory.getLog(ExceptionUtil.class);
  private static final Class<CommonExceptionInfo> clzz = CommonExceptionInfo.class;
  private static JAXBContext context = initContext();
  
  public static void sendException(Message paramMessage, final CommonExceptionInfo paramCommonExceptionInfo)
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
        ExceptionUtil.generateHeader(this.val$msg, localTextMessage);
        try
        {
          localTextMessage.setText(ExceptionUtil.generateBody(paramCommonExceptionInfo));
        }
        catch (Exception localException) {}
        return localTextMessage;
      }
    });
  }
  
  public static JmsTemplate initJmsTemplate()
  {
    JmsTemplate localJmsTemplate = (JmsTemplate)SSBBus.findDomainService("senderExcepReqMsgJmsTemplate");
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
  
  public static String generateBody(CommonExceptionInfo paramCommonExceptionInfo)
    throws Exception
  {
    if (paramCommonExceptionInfo == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      Marshaller localMarshaller = context.createMarshaller();
      localMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
      localMarshaller.setProperty("jaxb.encoding", "UTF-8");
      JAXBElement localJAXBElement = new ObjectFactory().createCommonExceptionInfo(paramCommonExceptionInfo);
      localMarshaller.marshal(localJAXBElement, localStringWriter);
      localStringWriter.flush();
      return localStringWriter.toString();
    }
    catch (Exception localException)
    {
      throw new Exception("序列化" + paramCommonExceptionInfo.getClass().getName() + "时失败！", localException);
    }
  }
  
  public static CommonExceptionInfo toMessage(String paramString)
  {
    CommonExceptionInfo localCommonExceptionInfo = null;
    try
    {
      localCommonExceptionInfo = (CommonExceptionInfo)JavaObjectToXmlUtil.xmlToJavaObject(paramString, "com.zte.esb.util.exception.CommonExceptionInfo");
    }
    catch (Exception localException)
    {
      log.error("序列化CommonExceptionInfo时失败！", localException);
    }
    return localCommonExceptionInfo;
  }
  
  private static JAXBContext initContext()
  {
    JAXBContext localJAXBContext = null;
    try
    {
      localJAXBContext = JAXBContext.newInstance(new Class[] { clzz });
    }
    catch (JAXBException localJAXBException)
    {
      log.error(localJAXBException.getMessage(), localJAXBException);
    }
    return localJAXBContext;
  }
  
  public static void send(Message paramMessage, CommonExceptionInfo paramCommonExceptionInfo)
  {
    sendException(paramMessage, paramCommonExceptionInfo);
  }
  
  public static CommonExceptionInfo getCommonExceptionInfo(String paramString1, String paramString2)
  {
    CommonExceptionInfo localCommonExceptionInfo = new CommonExceptionInfo();
    try
    {
      localCommonExceptionInfo.setCreatedTime(DateUtil.getXMLGregorianCalendar(new Date()));
    }
    catch (Exception localException)
    {
      log.error("创建并封装异常信息失败", localException);
      localException.printStackTrace();
    }
    localCommonExceptionInfo.setDetailedInfo(paramString1);
    localCommonExceptionInfo.setExceptioncode("");
    localCommonExceptionInfo.setExceptiontype("SystemException");
    localCommonExceptionInfo.setMessage(paramString2);
    return localCommonExceptionInfo;
  }
  
  public static CommonExceptionInfo getCommonExceptionInfo(String paramString1, String paramString2, String paramString3)
  {
    CommonExceptionInfo localCommonExceptionInfo = new CommonExceptionInfo();
    try
    {
      localCommonExceptionInfo.setCreatedTime(DateUtil.getXMLGregorianCalendar(new Date()));
    }
    catch (Exception localException)
    {
      log.error("创建并封装异常信息失败", localException);
      localException.printStackTrace();
    }
    localCommonExceptionInfo.setDetailedInfo(paramString1);
    localCommonExceptionInfo.setExceptioncode(paramString3);
    localCommonExceptionInfo.setExceptiontype("SystemException");
    localCommonExceptionInfo.setMessage(paramString2);
    return localCommonExceptionInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.ExceptionUtil
 * JD-Core Version:    0.7.0.1
 */