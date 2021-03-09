package com.zte.esb.client;

import com.zte.eas.getData.util.EisConsts;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;

public class CommonClientListener
  implements MessageListener
{
  private FsscNewImageResponseListener fsscNewImageResponseListener;
  private SpecialAttachmentResponseListener specialAttachmentResponseListener;
  Logger logger = Logger.getLogger(getClass());
  
  public void onMessage(Message paramMessage)
  {
    try
    {
      this.logger.error("公共客户端监听begin....");
      String str = paramMessage.getStringProperty("esbServiceCode");
      try
      {
        this.logger.error("esbServiceCode=" + str);
        this.logger.error("请求报文=" + ((TextMessage)paramMessage).getText());
      }
      catch (Exception localException2)
      {
        this.logger.error(localException2.getMessage(), localException2);
      }
      EisConsts.printMsg(paramMessage, this.logger);
      if ("ESB_EIS2ESB_CREATE_IMAGES".equals(str)) {
        this.fsscNewImageResponseListener.onMessage(paramMessage);
      } else if ("ESB_EIS2ESB_SPECIAL_ATTACHMENT".equals(str)) {
        this.specialAttachmentResponseListener.onMessage(paramMessage);
      }
    }
    catch (Exception localException1)
    {
      this.logger.error("公共客户端监听异常:" + localException1.getMessage(), localException1);
    }
    this.logger.error("公共客户端监听end....");
  }
  
  public FsscNewImageResponseListener getFsscNewImageResponseListener()
  {
    return this.fsscNewImageResponseListener;
  }
  
  public void setFsscNewImageResponseListener(FsscNewImageResponseListener paramFsscNewImageResponseListener)
  {
    this.fsscNewImageResponseListener = paramFsscNewImageResponseListener;
  }
  
  public SpecialAttachmentResponseListener getSpecialAttachmentResponseListener()
  {
    return this.specialAttachmentResponseListener;
  }
  
  public void setSpecialAttachmentResponseListener(SpecialAttachmentResponseListener paramSpecialAttachmentResponseListener)
  {
    this.specialAttachmentResponseListener = paramSpecialAttachmentResponseListener;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.client.CommonClientListener
 * JD-Core Version:    0.7.0.1
 */