package com.zte.eas.resconfig.business.lookup.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpLookupTypes
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String lookupType;
  protected String description;
  protected String customizationLevel;
  protected String enabledFlag;
  
  public FbpLookupTypes() {}
  
  public FbpLookupTypes(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setLookupType(paramString1);
    setDescription(paramString2);
    setCustomizationLevel(paramString3);
    setEnabledFlag(paramString4);
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public Long getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(Long paramLong)
  {
    this.createdBy = paramLong;
  }
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public String getLookupType()
  {
    return this.lookupType;
  }
  
  public void setLookupType(String paramString)
  {
    this.lookupType = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public String getCustomizationLevel()
  {
    return this.customizationLevel;
  }
  
  public void setCustomizationLevel(String paramString)
  {
    this.customizationLevel = paramString;
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
    if (!(paramObject instanceof FbpLookupTypes)) {
      return false;
    }
    FbpLookupTypes localFbpLookupTypes = (FbpLookupTypes)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpLookupTypes.lastUpdateDate).append(this.lastUpdatedBy, localFbpLookupTypes.lastUpdatedBy).append(this.creationDate, localFbpLookupTypes.creationDate).append(this.createdBy, localFbpLookupTypes.createdBy).append(this.lastUpdateLogin, localFbpLookupTypes.lastUpdateLogin).append(this.lookupType, localFbpLookupTypes.lookupType).append(this.description, localFbpLookupTypes.description).append(this.customizationLevel, localFbpLookupTypes.customizationLevel).append(this.enabledFlag, localFbpLookupTypes.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.lookupType).append(this.description).append(this.customizationLevel).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("lookupType", this.lookupType).append("description", this.description).append("customizationLevel", this.customizationLevel).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.lookup.model.FbpLookupTypes
 * JD-Core Version:    0.7.0.1
 */