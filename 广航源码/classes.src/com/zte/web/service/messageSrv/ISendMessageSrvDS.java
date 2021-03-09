package com.zte.web.service.messageSrv;

import com.zte.web.service.messageSrv.services.SendMessageSrvRequest;
import com.zte.web.service.messageSrv.services.SendMessageSrvResponse;

public abstract interface ISendMessageSrvDS
{
  public abstract SendMessageSrvResponse[] process(SendMessageSrvRequest[] paramArrayOfSendMessageSrvRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.messageSrv.ISendMessageSrvDS
 * JD-Core Version:    0.7.0.1
 */