package com.zte.eas.eimage.business.video.proxy.runtime;

import java.io.Serializable;
import java.util.Calendar;

public class VideoStatusServiceSoapBinding_registerVideo_ReqS
  implements Serializable
{
  protected String boeNum;
  protected Calendar uploadDate;
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
  
  public Calendar getUploadDate()
  {
    return this.uploadDate;
  }
  
  public void setUploadDate(Calendar paramCalendar)
  {
    this.uploadDate = paramCalendar;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.runtime.VideoStatusServiceSoapBinding_registerVideo_ReqS
 * JD-Core Version:    0.7.0.1
 */