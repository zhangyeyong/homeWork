package com.zte.web.service.proxy;

import com.zte.web.service.client.sendMSMService.CoreSMSReplyType;
import com.zte.web.service.client.sendMSMService.CoreSMSType;

public abstract interface ISendMSMClient
{
  public abstract CoreSMSReplyType sendMSM(CoreSMSType paramCoreSMSType);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.ISendMSMClient
 * JD-Core Version:    0.7.0.1
 */