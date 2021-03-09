package com.zte.esb.client;

import com.zte.eas.getData.util.EisConsts;
import com.zte.esb.bean.fssc.GetEisRequest;
import com.zte.esb.trans.CommonRequestTrans;
import com.zte.esb.util.HeaderUtil;
import com.zte.esb.util.MsgHeader;
import com.zte.ssb.jms.core.JmsTemplate;
import com.zte.ssb.jms.core.MessageCreator;
import java.util.Date;
import java.util.UUID;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;

public class FsscNewImageRequestSender
{
  private JmsTemplate senderReqMsgJmsTemplate;
  Logger logger = Logger.getLogger(getClass());
  
  public void send(final GetEisRequest paramGetEisRequest)
  {
    this.senderReqMsgJmsTemplate.send(new MessageCreator()
    {
      public Message createMessage(Session paramAnonymousSession)
        throws JMSException
      {
        EisConsts.printMsg(paramGetEisRequest, FsscNewImageRequestSender.this.logger);
        String str1 = CommonRequestTrans.fromMessage(paramGetEisRequest);
        TextMessage localTextMessage = paramAnonymousSession.createTextMessage(str1);
        FsscNewImageRequestSender.this.logger.error("FsscNewImageRequestSender.send(message)=" + str1);
        MsgHeader localMsgHeader = HeaderUtil.getMsgHeaderInfo("1.0", "ESB_EIS2ESB_CREATE_IMAGES", 2, "XML", UUID.randomUUID().toString());
        HeaderUtil.buildRequestJMSProperties(localTextMessage, localMsgHeader);
        String str2 = "ST_108";
        localTextMessage.setLongProperty(str2, new Date().getTime());
        return localTextMessage;
      }
    });
  }
  
  public JmsTemplate getSenderReqMsgJmsTemplate()
  {
    return this.senderReqMsgJmsTemplate;
  }
  
  public void setSenderReqMsgJmsTemplate(JmsTemplate paramJmsTemplate)
  {
    this.senderReqMsgJmsTemplate = paramJmsTemplate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.client.FsscNewImageRequestSender
 * JD-Core Version:    0.7.0.1
 */