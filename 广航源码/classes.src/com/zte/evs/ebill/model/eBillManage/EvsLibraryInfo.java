package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsLibraryInfo
  implements Serializable
{
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdatedBy;
  private Long lastUpdateLogin;
  private String enabledFlag;
  private Long libraryId;
  private Long storageId;
  private String libraryCode;
  private String libraryName;
  private String libraryAtt;
  private String validity;
  
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
  
  public Long getLibraryId()
  {
    return this.libraryId;
  }
  
  public void setLibraryId(Long paramLong)
  {
    this.libraryId = paramLong;
  }
  
  public Long getStorageId()
  {
    return this.storageId;
  }
  
  public void setStorageId(Long paramLong)
  {
    this.storageId = paramLong;
  }
  
  public String getLibraryCode()
  {
    return this.libraryCode;
  }
  
  public void setLibraryCode(String paramString)
  {
    this.libraryCode = paramString;
  }
  
  public String getLibraryName()
  {
    return this.libraryName;
  }
  
  public void setLibraryName(String paramString)
  {
    this.libraryName = paramString;
  }
  
  public String getLibraryAtt()
  {
    return this.libraryAtt;
  }
  
  public void setLibraryAtt(String paramString)
  {
    this.libraryAtt = paramString;
  }
  
  public String getValidity()
  {
    return this.validity;
  }
  
  public void setValidity(String paramString)
  {
    this.validity = paramString;
  }
  
  public int hashCode()
  {
    int i = 1;
    i = 31 * i + (this.createdBy == null ? 0 : this.createdBy.hashCode());
    i = 31 * i + (this.creationDate == null ? 0 : this.creationDate.hashCode());
    i = 31 * i + (this.enabledFlag == null ? 0 : this.enabledFlag.hashCode());
    i = 31 * i + (this.lastUpdateDate == null ? 0 : this.lastUpdateDate.hashCode());
    i = 31 * i + (this.lastUpdateLogin == null ? 0 : this.lastUpdateLogin.hashCode());
    i = 31 * i + (this.lastUpdatedBy == null ? 0 : this.lastUpdatedBy.hashCode());
    i = 31 * i + (this.libraryAtt == null ? 0 : this.libraryAtt.hashCode());
    i = 31 * i + (this.libraryCode == null ? 0 : this.libraryCode.hashCode());
    i = 31 * i + (this.libraryId == null ? 0 : this.libraryId.hashCode());
    i = 31 * i + (this.libraryName == null ? 0 : this.libraryName.hashCode());
    i = 31 * i + (this.storageId == null ? 0 : this.storageId.hashCode());
    i = 31 * i + (this.validity == null ? 0 : this.validity.hashCode());
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
    EvsLibraryInfo localEvsLibraryInfo = (EvsLibraryInfo)paramObject;
    if (this.createdBy == null)
    {
      if (localEvsLibraryInfo.createdBy != null) {
        return false;
      }
    }
    else if (!this.createdBy.equals(localEvsLibraryInfo.createdBy)) {
      return false;
    }
    if (this.creationDate == null)
    {
      if (localEvsLibraryInfo.creationDate != null) {
        return false;
      }
    }
    else if (!this.creationDate.equals(localEvsLibraryInfo.creationDate)) {
      return false;
    }
    if (this.enabledFlag == null)
    {
      if (localEvsLibraryInfo.enabledFlag != null) {
        return false;
      }
    }
    else if (!this.enabledFlag.equals(localEvsLibraryInfo.enabledFlag)) {
      return false;
    }
    if (this.lastUpdateDate == null)
    {
      if (localEvsLibraryInfo.lastUpdateDate != null) {
        return false;
      }
    }
    else if (!this.lastUpdateDate.equals(localEvsLibraryInfo.lastUpdateDate)) {
      return false;
    }
    if (this.lastUpdateLogin == null)
    {
      if (localEvsLibraryInfo.lastUpdateLogin != null) {
        return false;
      }
    }
    else if (!this.lastUpdateLogin.equals(localEvsLibraryInfo.lastUpdateLogin)) {
      return false;
    }
    if (this.lastUpdatedBy == null)
    {
      if (localEvsLibraryInfo.lastUpdatedBy != null) {
        return false;
      }
    }
    else if (!this.lastUpdatedBy.equals(localEvsLibraryInfo.lastUpdatedBy)) {
      return false;
    }
    if (this.libraryAtt == null)
    {
      if (localEvsLibraryInfo.libraryAtt != null) {
        return false;
      }
    }
    else if (!this.libraryAtt.equals(localEvsLibraryInfo.libraryAtt)) {
      return false;
    }
    if (this.libraryCode == null)
    {
      if (localEvsLibraryInfo.libraryCode != null) {
        return false;
      }
    }
    else if (!this.libraryCode.equals(localEvsLibraryInfo.libraryCode)) {
      return false;
    }
    if (this.libraryId == null)
    {
      if (localEvsLibraryInfo.libraryId != null) {
        return false;
      }
    }
    else if (!this.libraryId.equals(localEvsLibraryInfo.libraryId)) {
      return false;
    }
    if (this.libraryName == null)
    {
      if (localEvsLibraryInfo.libraryName != null) {
        return false;
      }
    }
    else if (!this.libraryName.equals(localEvsLibraryInfo.libraryName)) {
      return false;
    }
    if (this.storageId == null)
    {
      if (localEvsLibraryInfo.storageId != null) {
        return false;
      }
    }
    else if (!this.storageId.equals(localEvsLibraryInfo.storageId)) {
      return false;
    }
    if (this.validity == null)
    {
      if (localEvsLibraryInfo.validity != null) {
        return false;
      }
    }
    else if (!this.validity.equals(localEvsLibraryInfo.validity)) {
      return false;
    }
    return true;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsLibraryInfo
 * JD-Core Version:    0.7.0.1
 */