package com.zte.eas.getData.OranizationUnits.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Message
{
  private String result;
  private String errCode;
  private String errInfos;
  
  public String toString()
  {
    return new ToStringBuilder(this).append("result", this.result).append("errCode", this.errCode).append("errInfos", this.errInfos).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Message)) {
      return false;
    }
    Message localMessage = (Message)paramObject;
    return new EqualsBuilder().append(this.result, localMessage.result).append(this.errCode, localMessage.errCode).append(this.errInfos, localMessage.errInfos).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(this.result).append(this.errCode).append(this.errInfos).toHashCode();
  }
  
  public String getErrCode()
  {
    return this.errCode;
  }
  
  public void setErrCode(String paramString)
  {
    this.errCode = paramString;
  }
  
  public String getErrInfos()
  {
    return this.errInfos;
  }
  
  public void setErrInfos(String paramString)
  {
    this.errInfos = paramString;
  }
  
  public String getResult()
  {
    return this.result;
  }
  
  public void setResult(String paramString)
  {
    this.result = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.model.Message
 * JD-Core Version:    0.7.0.1
 */