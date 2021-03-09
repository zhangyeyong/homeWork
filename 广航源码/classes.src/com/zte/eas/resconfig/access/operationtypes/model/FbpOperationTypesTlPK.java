package com.zte.eas.resconfig.access.operationtypes.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpOperationTypesTlPK
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Long operationTypeId;
  protected String language;
  
  public FbpOperationTypesTlPK() {}
  
  public FbpOperationTypesTlPK(Long paramLong, String paramString)
  {
    this.operationTypeId = paramLong;
    this.language = paramString;
  }
  
  public Long getOperationTypeId()
  {
    return this.operationTypeId;
  }
  
  public void setOperationTypeId(Long paramLong)
  {
    this.operationTypeId = paramLong;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpOperationTypesTlPK)) {
      return false;
    }
    FbpOperationTypesTlPK localFbpOperationTypesTlPK = (FbpOperationTypesTlPK)paramObject;
    return new EqualsBuilder().append(this.operationTypeId, localFbpOperationTypesTlPK.operationTypeId).append(this.language, localFbpOperationTypesTlPK.language).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.operationTypeId).append(this.language).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("operationTypeId", this.operationTypeId).append("language", this.language).toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.operationtypes.model.FbpOperationTypesTlPK
 * JD-Core Version:    0.7.0.1
 */