package com.zte.eas.infomap.business.sms.service;

import com.zte.eas.infomap.business.sms.model.SmsItemV;

public abstract interface ISmsManager
{
  public abstract String sendSms(SmsItemV paramSmsItemV);
  
  public abstract String receive(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.sms.service.ISmsManager
 * JD-Core Version:    0.7.0.1
 */