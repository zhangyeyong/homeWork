package com.zte.eas.resconfig.business.lookup.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpOperationStyleT
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long itemOperationTypeId;
  protected String itemClass;
  protected String itemType;
  protected Long opertionId;
  protected String oa;
  
  public FbpOperationStyleT() {}
  
  public FbpOperationStyleT(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, String paramString3, Long paramLong5)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setItemOperationTypeId(paramLong4);
    setItemClass(paramString2);
    setItemType(paramString3);
    setOpertionId(paramLong5);
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
  
  public Long getItemOperationTypeId()
  {
    return this.itemOperationTypeId;
  }
  
  public void setItemOperationTypeId(Long paramLong)
  {
    this.itemOperationTypeId = paramLong;
  }
  
  public String getItemClass()
  {
    return this.itemClass;
  }
  
  public void setItemClass(String paramString)
  {
    this.itemClass = paramString;
  }
  
  public String getItemType()
  {
    return this.itemType;
  }
  
  public void setItemType(String paramString)
  {
    this.itemType = paramString;
  }
  
  public Long getOpertionId()
  {
    return this.opertionId;
  }
  
  public void setOpertionId(Long paramLong)
  {
    this.opertionId = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpOperationStyleT)) {
      return false;
    }
    FbpOperationStyleT localFbpOperationStyleT = (FbpOperationStyleT)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpOperationStyleT.lastUpdateDate).append(this.lastUpdatedBy, localFbpOperationStyleT.lastUpdatedBy).append(this.creationDate, localFbpOperationStyleT.creationDate).append(this.createdBy, localFbpOperationStyleT.createdBy).append(this.lastUpdateLogin, localFbpOperationStyleT.lastUpdateLogin).append(this.enabledFlag, localFbpOperationStyleT.enabledFlag).append(this.itemOperationTypeId, localFbpOperationStyleT.itemOperationTypeId).append(this.itemClass, localFbpOperationStyleT.itemClass).append(this.itemType, localFbpOperationStyleT.itemType).append(this.opertionId, localFbpOperationStyleT.opertionId).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.itemOperationTypeId).append(this.itemClass).append(this.itemType).append(this.opertionId).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("itemOperationTypeId", this.itemOperationTypeId).append("itemClass", this.itemClass).append("itemType", this.itemType).append("opertionId", this.opertionId).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getOa()
  {
    return this.oa;
  }
  
  public void setOa(String paramString)
  {
    this.oa = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.lookup.model.FbpOperationStyleT
 * JD-Core Version:    0.7.0.1
 */