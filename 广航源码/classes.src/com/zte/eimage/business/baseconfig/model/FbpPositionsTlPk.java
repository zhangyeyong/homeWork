package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;

public class FbpPositionsTlPk
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long positionId;
  private String language;
  
  public Long getPositionId()
  {
    return this.positionId;
  }
  
  public void setPositionId(Long paramLong)
  {
    this.positionId = paramLong;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.FbpPositionsTlPk
 * JD-Core Version:    0.7.0.1
 */