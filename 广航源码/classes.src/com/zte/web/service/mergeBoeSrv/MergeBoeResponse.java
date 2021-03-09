package com.zte.web.service.mergeBoeSrv;

import java.io.Serializable;

public class MergeBoeResponse
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String ERROR_FLAG;
  private String ERROR_MESSAGE;
  
  public String getERROR_FLAG()
  {
    return this.ERROR_FLAG;
  }
  
  public void setERROR_FLAG(String paramString)
  {
    this.ERROR_FLAG = paramString;
  }
  
  public String getERROR_MESSAGE()
  {
    return this.ERROR_MESSAGE;
  }
  
  public void setERROR_MESSAGE(String paramString)
  {
    this.ERROR_MESSAGE = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.MergeBoeResponse
 * JD-Core Version:    0.7.0.1
 */