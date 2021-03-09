package com.zte.web.service.mergeBoeSrv;

import java.io.Serializable;

public class MergeBoeRequest
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String operationType;
  private String BOE_NUM;
  private String[] DETAIL_BOE_NUM;
  
  public String getBOE_NUM()
  {
    return this.BOE_NUM;
  }
  
  public void setBOE_NUM(String paramString)
  {
    this.BOE_NUM = paramString;
  }
  
  public String[] getDETAIL_BOE_NUM()
  {
    return this.DETAIL_BOE_NUM;
  }
  
  public void setDETAIL_BOE_NUM(String[] paramArrayOfString)
  {
    this.DETAIL_BOE_NUM = paramArrayOfString;
  }
  
  public String getOperationType()
  {
    return this.operationType;
  }
  
  public void setOperationType(String paramString)
  {
    this.operationType = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.MergeBoeRequest
 * JD-Core Version:    0.7.0.1
 */