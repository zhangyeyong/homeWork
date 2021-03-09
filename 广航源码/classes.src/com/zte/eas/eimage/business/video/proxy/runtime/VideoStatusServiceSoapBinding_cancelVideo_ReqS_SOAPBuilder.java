package com.zte.eas.eimage.business.video.proxy.runtime;

import oracle.j2ee.ws.common.encoding.DeserializationException;
import oracle.j2ee.ws.common.encoding.SOAPInstanceBuilder;
import oracle.j2ee.ws.common.util.exception.LocalizableExceptionAdapter;

public class VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPBuilder
  implements SOAPInstanceBuilder
{
  private VideoStatusServiceSoapBinding_cancelVideo_ReqS _instance;
  private String boeNum;
  private static final int myboeNum_INDEX = 0;
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
  
  public int memberGateType(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
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
    this._instance = ((VideoStatusServiceSoapBinding_cancelVideo_ReqS)paramObject);
  }
  
  public Object getInstance()
  {
    return this._instance;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.runtime.VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPBuilder
 * JD-Core Version:    0.7.0.1
 */