package com.zte.eas.resconfig.business.lookup.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpLookupValues
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long lookupValueId;
  protected String lookupType;
  protected String lookupCode;
  protected String meaning;
  protected String description;
  protected Date startDateActive;
  protected Date endDateActive;
  protected String language;
  protected String sourceLang;
  
  public FbpLookupValues() {}
  
  public FbpLookupValues(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5, Date paramDate3, Date paramDate4, String paramString6, String paramString7)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setLookupValueId(paramLong4);
    setLookupType(paramString2);
    setLookupCode(paramString3);
    setMeaning(paramString4);
    setDescription(paramString5);
    setStartDateActive(paramDate3);
    setEndDateActive(paramDate4);
    setLanguage(paramString6);
    setSourceLang(paramString7);
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
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
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
  
  public Date getStartDateActive()
  {
    return this.startDateActive;
  }
  
  public void setStartDateActive(Date paramDate)
  {
    this.startDateActive = paramDate;
  }
  
  public Date getEndDateActive()
  {
    return this.endDateActive;
  }
  
  public void setEndDateActive(Date paramDate)
  {
    this.endDateActive = paramDate;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public String getSourceLang()
  {
    return this.sourceLang;
  }
  
  public void setSourceLang(String paramString)
  {
    this.sourceLang = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpLookupValues)) {
      return false;
    }
    FbpLookupValues localFbpLookupValues = (FbpLookupValues)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpLookupValues.lastUpdateDate).append(this.lastUpdatedBy, localFbpLookupValues.lastUpdatedBy).append(this.creationDate, localFbpLookupValues.creationDate).append(this.createdBy, localFbpLookupValues.createdBy).append(this.lastUpdateLogin, localFbpLookupValues.lastUpdateLogin).append(this.enabledFlag, localFbpLookupValues.enabledFlag).append(this.lookupValueId, localFbpLookupValues.lookupValueId).append(this.lookupType, localFbpLookupValues.lookupType).append(this.lookupCode, localFbpLookupValues.lookupCode).append(this.meaning, localFbpLookupValues.meaning).append(this.description, localFbpLookupValues.description).append(this.startDateActive, localFbpLookupValues.startDateActive).append(this.endDateActive, localFbpLookupValues.endDateActive).append(this.language, localFbpLookupValues.language).append(this.sourceLang, localFbpLookupValues.sourceLang).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.lookupValueId).append(this.lookupType).append(this.lookupCode).append(this.meaning).append(this.description).append(this.startDateActive).append(this.endDateActive).append(this.language).append(this.sourceLang).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("lookupValueId", this.lookupValueId).append("lookupType", this.lookupType).append("lookupCode", this.lookupCode).append("meaning", this.meaning).append("description", this.description).append("startDateActive", this.startDateActive).append("endDateActive", this.endDateActive).append("language", this.language).append("sourceLang", this.sourceLang).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "lookupValueId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.lookup.model.FbpLookupValues
 * JD-Core Version:    0.7.0.1
 */