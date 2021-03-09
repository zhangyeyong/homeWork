package com.zte.esb.services;

import com.zte.esb.bean.foss.SyncDistrictResponse;
import com.zte.esb.trans.AreaResponseSenderTrans;
import com.zte.esb.util.ExceptionUtil;
import com.zte.esb.util.HeaderUtil;
import com.zte.esb.util.exception.CommonExceptionInfo;
import com.zte.ssb.jms.core.JmsTemplate;
import com.zte.ssb.jms.core.MessageCreator;
import java.util.Map;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AreaResponseSender
{
  private static Log log = LogFactory.getLog(UserResponseSender.class);
  private JmsTemplate notificationSendJmsTemplate;
  
  public void send(final Object paramObject, final Map<String, Object> paramMap, String paramString, final boolean paramBoolean)
  {
    this.notificationSendJmsTemplate.send(new MessageCreator()
    {
      public Message createMessage(Session paramAnonymousSession)
        throws JMSException
      {
        TextMessage localTextMessage = paramAnonymousSession.createTextMessage();
        try
        {
          HeaderUtil.mapConverToHeader(localTextMessage, paramMap);
          String str = null;
          Object localObject;
          if (paramBoolean)
          {
            HeaderUtil.buildResponseHeader(localTextMessage, null, 1);
            localObject = (SyncDistrictResponse)paramObject;
            str = AreaResponseSenderTrans.fromMessage((SyncDistrictResponse)localObject);
          }
          else
          {
            HeaderUtil.buildResponseHeader(localTextMessage, null, 0);
            localObject = (CommonExceptionInfo)paramObject;
            str = ExceptionUtil.generateBody((CommonExceptionInfo)localObject);
          }
          AreaResponseSender.log.info("返回的报文:" + str);
          localTextMessage.clearBody();
          localTextMessage.setText(str);
        }
        catch (Exception localException)
        {
          AreaResponseSender.log.info("转化错误");
          localException.printStackTrace();
        }
        return localTextMessage;
      }
    });
  }
  
  public void setNotificationSendJmsTemplate(JmsTemplate paramJmsTemplate)
  {
    this.notificationSendJmsTemplate = paramJmsTemplate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.services.AreaResponseSender
 * JD-Core Version:    0.7.0.1
 */