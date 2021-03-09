package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;

public class OperationTypeInfo
  implements Serializable
{
  private String operationTypeCode;
  private String operationTypeName;
  
  public String getOperationTypeCode()
  {
    return this.operationTypeCode;
  }
  
  public void setOperationTypeCode(String paramString)
  {
    this.operationTypeCode = paramString;
  }
  
  public String getOperationTypeName()
  {
    return this.operationTypeName;
  }
  
  public void setOperationTypeName(String paramString)
  {
    this.operationTypeName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.OperationTypeInfo
 * JD-Core Version:    0.7.0.1
 */