package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsStorageDoc
  implements Serializable
{
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdatedBy;
  private Long lastUpdateLogin;
  private String enabledFlag;
  private Long storageId;
  private String storageCode;
  private String storageName;
  private String state;
  private Long companyId;
  private Long cityId;
  
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
  
  public Long getStorageId()
  {
    return this.storageId;
  }
  
  public void setStorageId(Long paramLong)
  {
    this.storageId = paramLong;
  }
  
  public String getStorageCode()
  {
    return this.storageCode;
  }
  
  public void setStorageCode(String paramString)
  {
    this.storageCode = paramString;
  }
  
  public String getStorageName()
  {
    return this.storageName;
  }
  
  public void setStorageName(String paramString)
  {
    this.storageName = paramString;
  }
  
  public String getState()
  {
    return this.state;
  }
  
  public void setState(String paramString)
  {
    this.state = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public Long getCityId()
  {
    return this.cityId;
  }
  
  public void setCityId(Long paramLong)
  {
    this.cityId = paramLong;
  }
  
  public int hashCode()
  {
    int i = 1;
    i = 31 * i + (this.cityId == null ? 0 : this.cityId.hashCode());
    i = 31 * i + (this.companyId == null ? 0 : this.companyId.hashCode());
    i = 31 * i + (this.createdBy == null ? 0 : this.createdBy.hashCode());
    i = 31 * i + (this.creationDate == null ? 0 : this.creationDate.hashCode());
    i = 31 * i + (this.enabledFlag == null ? 0 : this.enabledFlag.hashCode());
    i = 31 * i + (this.lastUpdateDate == null ? 0 : this.lastUpdateDate.hashCode());
    i = 31 * i + (this.lastUpdateLogin == null ? 0 : this.lastUpdateLogin.hashCode());
    i = 31 * i + (this.lastUpdatedBy == null ? 0 : this.lastUpdatedBy.hashCode());
    i = 31 * i + (this.state == null ? 0 : this.state.hashCode());
    i = 31 * i + (this.storageCode == null ? 0 : this.storageCode.hashCode());
    i = 31 * i + (this.storageId == null ? 0 : this.storageId.hashCode());
    i = 31 * i + (this.storageName == null ? 0 : this.storageName.hashCode());
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    EvsStorageDoc localEvsStorageDoc = (EvsStorageDoc)paramObject;
    if (this.cityId == null)
    {
      if (localEvsStorageDoc.cityId != null) {
        return false;
      }
    }
    else if (!this.cityId.equals(localEvsStorageDoc.cityId)) {
      return false;
    }
    if (this.companyId == null)
    {
      if (localEvsStorageDoc.companyId != null) {
        return false;
      }
    }
    else if (!this.companyId.equals(localEvsStorageDoc.companyId)) {
      return false;
    }
    if (this.createdBy == null)
    {
      if (localEvsStorageDoc.createdBy != null) {
        return false;
      }
    }
    else if (!this.createdBy.equals(localEvsStorageDoc.createdBy)) {
      return false;
    }
    if (this.creationDate == null)
    {
      if (localEvsStorageDoc.creationDate != null) {
        return false;
      }
    }
    else if (!this.creationDate.equals(localEvsStorageDoc.creationDate)) {
      return false;
    }
    if (this.enabledFlag == null)
    {
      if (localEvsStorageDoc.enabledFlag != null) {
        return false;
      }
    }
    else if (!this.enabledFlag.equals(localEvsStorageDoc.enabledFlag)) {
      return false;
    }
    if (this.lastUpdateDate == null)
    {
      if (localEvsStorageDoc.lastUpdateDate != null) {
        return false;
      }
    }
    else if (!this.lastUpdateDate.equals(localEvsStorageDoc.lastUpdateDate)) {
      return false;
    }
    if (this.lastUpdateLogin == null)
    {
      if (localEvsStorageDoc.lastUpdateLogin != null) {
        return false;
      }
    }
    else if (!this.lastUpdateLogin.equals(localEvsStorageDoc.lastUpdateLogin)) {
      return false;
    }
    if (this.lastUpdatedBy == null)
    {
      if (localEvsStorageDoc.lastUpdatedBy != null) {
        return false;
      }
    }
    else if (!this.lastUpdatedBy.equals(localEvsStorageDoc.lastUpdatedBy)) {
      return false;
    }
    if (this.state == null)
    {
      if (localEvsStorageDoc.state != null) {
        return false;
      }
    }
    else if (!this.state.equals(localEvsStorageDoc.state)) {
      return false;
    }
    if (this.storageCode == null)
    {
      if (localEvsStorageDoc.storageCode != null) {
        return false;
      }
    }
    else if (!this.storageCode.equals(localEvsStorageDoc.storageCode)) {
      return false;
    }
    if (this.storageId == null)
    {
      if (localEvsStorageDoc.storageId != null) {
        return false;
      }
    }
    else if (!this.storageId.equals(localEvsStorageDoc.storageId)) {
      return false;
    }
    if (this.storageName == null)
    {
      if (localEvsStorageDoc.storageName != null) {
        return false;
      }
    }
    else if (!this.storageName.equals(localEvsStorageDoc.storageName)) {
      return false;
    }
    return true;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsStorageDoc
 * JD-Core Version:    0.7.0.1
 */