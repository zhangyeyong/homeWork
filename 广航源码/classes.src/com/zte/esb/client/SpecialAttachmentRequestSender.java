package com.zte.esb.client;

import com.zte.esb.bean.fssc.SpecialAttachmentRequest;
import com.zte.esb.trans.CommonRequestTrans;
import com.zte.esb.util.HeaderUtil;
import com.zte.esb.util.MsgHeader;
import com.zte.ssb.jms.core.JmsTemplate;
import com.zte.ssb.jms.core.MessageCreator;
import java.util.Date;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

public class SpecialAttachmentRequestSender
{
  private JmsTemplate senderReqMsgJmsTemplate;
  
  public void send(final SpecialAttachmentRequest paramSpecialAttachmentRequest)
  {
    this.senderReqMsgJmsTemplate.send(new MessageCreator()
    {
      public Message createMessage(Session paramAnonymousSession)
        throws JMSException
      {
        String str1 = CommonRequestTrans.fromMessage(paramSpecialAttachmentRequest);
        TextMessage localTextMessage = paramAnonymousSession.createTextMessage(str1);
        MsgHeader localMsgHeader = HeaderUtil.getMsgHeaderInfo("1.0", "ESB_EIS2ESB_SPECIAL_ATTACHMENT", 2, "XML", "EIS");
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
 * Qualified Name:     com.zte.esb.client.SpecialAttachmentRequestSender
 * JD-Core Version:    0.7.0.1
 */