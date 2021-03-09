package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;

public class Message
  implements Serializable
{
  private EidImageInfos eidImageInfo;
  private boolean flag;
  private String msg;
  
  public EidImageInfos getEidImageInfo()
  {
    return this.eidImageInfo;
  }
  
  public void setEidImageInfo(EidImageInfos paramEidImageInfos)
  {
    this.eidImageInfo = paramEidImageInfos;
  }
  
  public boolean isFlag()
  {
    return this.flag;
  }
  
  public void setFlag(boolean paramBoolean)
  {
    this.flag = paramBoolean;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.Message
 * JD-Core Version:    0.7.0.1
 */