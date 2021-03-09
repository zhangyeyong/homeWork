package com.zte.esb.client;

import com.zte.eimage.business.baseconfig.service.ISyncSpecialAttachmentDS;
import com.zte.esb.bean.fssc.SpecialAttachmentResponse;
import com.zte.esb.trans.CommonRequestTrans;
import com.zte.esb.util.ExceptionUtil;
import com.zte.esb.util.StatusUtils;
import com.zte.ssb.framework.SSBBus;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class SpecialAttachmentResponseListener
{
  public void onMessage(Message paramMessage)
  {
    TextMessage localTextMessage = (TextMessage)paramMessage;
    StatusUtils.send(paramMessage, "ST_502");
    String str = null;
    SpecialAttachmentResponse localSpecialAttachmentResponse = null;
    try
    {
      str = localTextMessage.getText();
      Object localObject;
      if (paramMessage.getIntProperty("resultCode") == 0) {
        localObject = ExceptionUtil.toMessage(str);
      }
      if (paramMessage.getIntProperty("resultCode") == 1)
      {
        localSpecialAttachmentResponse = (SpecialAttachmentResponse)CommonRequestTrans.toMessage(str, SpecialAttachmentResponse.class.getName());
        StatusUtils.send(paramMessage, "ST_505");
        if (localSpecialAttachmentResponse != null)
        {
          localObject = (ISyncSpecialAttachmentDS)SSBBus.findDomainService("syncSpecialAttachmentDS");
          ((ISyncSpecialAttachmentDS)localObject).updateSpecialAttachmenFlag(localSpecialAttachmentResponse.getClaimBillNumber(), localSpecialAttachmentResponse.getSuccessMark().booleanValue() ? "Y" : "N", localSpecialAttachmentResponse.getFailtureReason());
        }
        StatusUtils.send(paramMessage, "ST_999");
      }
    }
    catch (JMSException localJMSException)
    {
      localJMSException.printStackTrace();
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.client.SpecialAttachmentResponseListener
 * JD-Core Version:    0.7.0.1
 */