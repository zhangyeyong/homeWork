package com.zte.eas.appframe.sync;

import java.io.Serializable;

public class ALLBPELSYNCProcessRequest
  implements Serializable
{
  protected String syncType;
  
  public String getSyncType()
  {
    return this.syncType;
  }
  
  public void setSyncType(String paramString)
  {
    this.syncType = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.sync.ALLBPELSYNCProcessRequest
 * JD-Core Version:    0.7.0.1
 */