package com.zte.eas.resconfig.business.lookup.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpLookupTypesV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String lookupType;
  protected String description;
  protected String customizationLevel;
  protected String enabledFlag;
  protected String enabledFlagMeaning;
  protected String lookupCode;
  protected String meaning;
  
  public FbpLookupTypesV() {}
  
  public FbpLookupTypesV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
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
    setLookupCode(paramString5);
    setMeaning(paramString6);
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
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpLookupTypesV)) {
      return false;
    }
    FbpLookupTypesV localFbpLookupTypesV = (FbpLookupTypesV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpLookupTypesV.lastUpdateDate).append(this.lastUpdatedBy, localFbpLookupTypesV.lastUpdatedBy).append(this.creationDate, localFbpLookupTypesV.creationDate).append(this.createdBy, localFbpLookupTypesV.createdBy).append(this.lastUpdateLogin, localFbpLookupTypesV.lastUpdateLogin).append(this.lookupType, localFbpLookupTypesV.lookupType).append(this.description, localFbpLookupTypesV.description).append(this.customizationLevel, localFbpLookupTypesV.customizationLevel).append(this.enabledFlag, localFbpLookupTypesV.enabledFlag).append(this.lookupCode, localFbpLookupTypesV.lookupCode).append(this.meaning, localFbpLookupTypesV.meaning).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.lookupType).append(this.description).append(this.customizationLevel).append(this.enabledFlag).append(this.lookupCode).append(this.meaning).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("lookupType", this.lookupType).append("description", this.description).append("customizationLevel", this.customizationLevel).append("enabledFlag", this.enabledFlag).append("lookupCode", this.lookupCode).append("meaning", this.meaning).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getEnabledFlagMeaning()
  {
    return this.enabledFlagMeaning;
  }
  
  public void setEnabledFlagMeaning(String paramString)
  {
    this.enabledFlagMeaning = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.lookup.model.FbpLookupTypesV
 * JD-Core Version:    0.7.0.1
 */