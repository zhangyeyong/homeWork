package com.zte.web.service.proxy;

import com.zte.web.service.client.sendEmailPS.InputMessageType;
import com.zte.web.service.client.sendEmailPS.OutputMessageType;

public abstract interface ISendEmailClient
{
  public abstract OutputMessageType sendEmail(InputMessageType paramInputMessageType);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.ISendEmailClient
 * JD-Core Version:    0.7.0.1
 */