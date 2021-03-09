package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EidUserSites
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long userSiteId;
  protected Long frontUserId;
  protected Long siteId;
  
  public EidUserSites() {}
  
  public EidUserSites(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString, Long paramLong4, Long paramLong5, Long paramLong6)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString);
    setUserSiteId(paramLong4);
    setFrontUserId(paramLong5);
    setSiteId(paramLong6);
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
  
  public Long getUserSiteId()
  {
    return this.userSiteId;
  }
  
  public void setUserSiteId(Long paramLong)
  {
    this.userSiteId = paramLong;
  }
  
  public Long getFrontUserId()
  {
    return this.frontUserId;
  }
  
  public void setFrontUserId(Long paramLong)
  {
    this.frontUserId = paramLong;
  }
  
  public Long getSiteId()
  {
    return this.siteId;
  }
  
  public void setSiteId(Long paramLong)
  {
    this.siteId = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EidUserSites)) {
      return false;
    }
    EidUserSites localEidUserSites = (EidUserSites)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localEidUserSites.lastUpdateDate).append(this.lastUpdatedBy, localEidUserSites.lastUpdatedBy).append(this.creationDate, localEidUserSites.creationDate).append(this.createdBy, localEidUserSites.createdBy).append(this.lastUpdateLogin, localEidUserSites.lastUpdateLogin).append(this.enabledFlag, localEidUserSites.enabledFlag).append(this.userSiteId, localEidUserSites.userSiteId).append(this.frontUserId, localEidUserSites.frontUserId).append(this.siteId, localEidUserSites.siteId).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.userSiteId).append(this.frontUserId).append(this.siteId).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("userSiteId", this.userSiteId).append("frontUserId", this.frontUserId).append("siteId", this.siteId).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "userSiteId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidUserSites
 * JD-Core Version:    0.7.0.1
 */