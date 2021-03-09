package com.zte.eas.appframe.business.sysparm.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SieSysParm
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long sysParmId;
  protected String sysParmCode;
  protected String sysParmName;
  protected String sysParmDesc;
  protected String sysParmValue;
  protected String fromLookupType;
  
  public SieSysParm() {}
  
  public SieSysParm(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setSysParmId(paramLong4);
    setSysParmCode(paramString2);
    setSysParmName(paramString3);
    setSysParmDesc(paramString4);
    setSysParmValue(paramString5);
    setFromLookupType(paramString6);
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
  
  public Long getSysParmId()
  {
    return this.sysParmId;
  }
  
  public void setSysParmId(Long paramLong)
  {
    this.sysParmId = paramLong;
  }
  
  public String getSysParmCode()
  {
    return this.sysParmCode;
  }
  
  public void setSysParmCode(String paramString)
  {
    this.sysParmCode = paramString;
  }
  
  public String getSysParmName()
  {
    return this.sysParmName;
  }
  
  public void setSysParmName(String paramString)
  {
    this.sysParmName = paramString;
  }
  
  public String getSysParmDesc()
  {
    return this.sysParmDesc;
  }
  
  public void setSysParmDesc(String paramString)
  {
    this.sysParmDesc = paramString;
  }
  
  public String getSysParmValue()
  {
    return this.sysParmValue;
  }
  
  public void setSysParmValue(String paramString)
  {
    this.sysParmValue = paramString;
  }
  
  public String getFromLookupType()
  {
    return this.fromLookupType;
  }
  
  public void setFromLookupType(String paramString)
  {
    this.fromLookupType = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SieSysParm)) {
      return false;
    }
    SieSysParm localSieSysParm = (SieSysParm)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localSieSysParm.lastUpdateDate).append(this.lastUpdatedBy, localSieSysParm.lastUpdatedBy).append(this.creationDate, localSieSysParm.creationDate).append(this.createdBy, localSieSysParm.createdBy).append(this.lastUpdateLogin, localSieSysParm.lastUpdateLogin).append(this.enabledFlag, localSieSysParm.enabledFlag).append(this.sysParmId, localSieSysParm.sysParmId).append(this.sysParmCode, localSieSysParm.sysParmCode).append(this.sysParmName, localSieSysParm.sysParmName).append(this.sysParmDesc, localSieSysParm.sysParmDesc).append(this.sysParmValue, localSieSysParm.sysParmValue).append(this.fromLookupType, localSieSysParm.fromLookupType).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.sysParmId).append(this.sysParmCode).append(this.sysParmName).append(this.sysParmDesc).append(this.sysParmValue).append(this.fromLookupType).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("sysParmId", this.sysParmId).append("sysParmCode", this.sysParmCode).append("sysParmName", this.sysParmName).append("sysParmDesc", this.sysParmDesc).append("sysParmValue", this.sysParmValue).append("fromLookupType", this.fromLookupType).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "sysParmId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.sysparm.model.SieSysParm
 * JD-Core Version:    0.7.0.1
 */