package com.zte.eas.eimage.business.video.proxy.runtime;

import java.util.Calendar;
import oracle.j2ee.ws.common.encoding.DeserializationException;
import oracle.j2ee.ws.common.encoding.SOAPInstanceBuilder;
import oracle.j2ee.ws.common.util.exception.LocalizableExceptionAdapter;

public class VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder
  implements SOAPInstanceBuilder
{
  private VideoStatusServiceSoapBinding_registerVideo_ReqS _instance;
  private String boeNum;
  private Calendar uploadDate;
  private static final int myboeNum_INDEX = 0;
  private static final int myuploadDate_INDEX = 1;
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
  
  public void setUploadDate(Calendar paramCalendar)
  {
    this.uploadDate = paramCalendar;
  }
  
  public int memberGateType(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
      return 6;
    case 1: 
      return 6;
    }
    throw new IllegalArgumentException();
  }
  
  public void construct() {}
  
  public void setMember(int paramInt, Object paramObject)
  {
    try
    {
      switch (paramInt)
      {
      case 0: 
        this._instance.setBoeNum((String)paramObject);
        break;
      case 1: 
        this._instance.setUploadDate((Calendar)paramObject);
        break;
      default: 
        throw new IllegalArgumentException();
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
      throw new DeserializationException(new LocalizableExceptionAdapter(localException));
    }
  }
  
  public void initialize() {}
  
  public void setInstance(Object paramObject)
  {
    this._instance = ((VideoStatusServiceSoapBinding_registerVideo_ReqS)paramObject);
  }
  
  public Object getInstance()
  {
    return this._instance;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.runtime.VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder
 * JD-Core Version:    0.7.0.1
 */