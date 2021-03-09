package com.zte.eas.resconfig.business.lookup.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpLookupValuesV
  extends BaseObject
  implements Serializable
{
  protected Long lookupValueId;
  protected String lookupType;
  protected String lookupCode;
  protected String meaning;
  protected String description;
  protected String enabledFlag;
  
  public FbpLookupValuesV() {}
  
  public FbpLookupValuesV(Long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    setLookupValueId(paramLong);
    setLookupType(paramString1);
    setLookupCode(paramString2);
    setMeaning(paramString3);
    setDescription(paramString4);
    setEnabledFlag(paramString5);
  }
  
  public Long getLookupValueId()
  {
    return this.lookupValueId;
  }
  
  public void setLookupValueId(Long paramLong)
  {
    this.lookupValueId = paramLong;
  }
  
  public String getLookupType()
  {
    return this.lookupType;
  }
  
  public void setLookupType(String paramString)
  {
    this.lookupType = paramString;
  }
  
  public String getLookupCode()
  {
    return this.lookupCode;
  }
  
  public void setLookupCode(String paramString)
  {
    this.lookupCode = paramString;
  }
  
  public String getMeaning()
  {
    return this.meaning;
  }
  
  public void setMeaning(String paramString)
  {
    this.meaning = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpLookupValuesV)) {
      return false;
    }
    FbpLookupValuesV localFbpLookupValuesV = (FbpLookupValuesV)paramObject;
    return new EqualsBuilder().append(this.lookupValueId, localFbpLookupValuesV.lookupValueId).append(this.lookupType, localFbpLookupValuesV.lookupType).append(this.lookupCode, localFbpLookupValuesV.lookupCode).append(this.meaning, localFbpLookupValuesV.meaning).append(this.description, localFbpLookupValuesV.description).append(this.enabledFlag, localFbpLookupValuesV.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lookupValueId).append(this.lookupType).append(this.lookupCode).append(this.meaning).append(this.description).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lookupValueId", this.lookupValueId).append("lookupType", this.lookupType).append("lookupCode", this.lookupCode).append("meaning", this.meaning).append("description", this.description).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV
 * JD-Core Version:    0.7.0.1
 */