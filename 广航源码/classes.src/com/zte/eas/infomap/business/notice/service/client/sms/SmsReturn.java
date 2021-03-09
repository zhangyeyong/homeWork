package com.zte.eas.infomap.business.notice.service.client.sms;

import java.io.Serializable;
import java.util.List;

public class SmsReturn
  implements Serializable
{
  private static final long serialVersionUID = 2139626220844221695L;
  private List<String> failList;
  private String reason;
  private String resultCode;
  
  public List<String> getFailList()
  {
    return this.failList;
  }
  
  public void setFailList(List<String> paramList)
  {
    this.failList = paramList;
  }
  
  public String getReason()
  {
    return this.reason;
  }
  
  public void setReason(String paramString)
  {
    this.reason = paramString;
  }
  
  public String getResultCode()
  {
    return this.resultCode;
  }
  
  public void setResultCode(String paramString)
  {
    this.resultCode = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.client.sms.SmsReturn
 * JD-Core Version:    0.7.0.1
 */