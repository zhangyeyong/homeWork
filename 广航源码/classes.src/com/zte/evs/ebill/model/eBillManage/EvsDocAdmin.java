package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsDocAdmin
  implements Serializable
{
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdatedBy;
  private Long lastUpdateLogin;
  private String enabledFlag;
  private Long docId;
  private Long docAdminId;
  private String docAdminCode;
  private String docAdminName;
  private Long storageId;
  
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
  
  public Long getDocId()
  {
    return this.docId;
  }
  
  public void setDocId(Long paramLong)
  {
    this.docId = paramLong;
  }
  
  public Long getDocAdminId()
  {
    return this.docAdminId;
  }
  
  public void setDocAdminId(Long paramLong)
  {
    this.docAdminId = paramLong;
  }
  
  public String getDocAdminCode()
  {
    return this.docAdminCode;
  }
  
  public void setDocAdminCode(String paramString)
  {
    this.docAdminCode = paramString;
  }
  
  public String getDocAdminName()
  {
    return this.docAdminName;
  }
  
  public void setDocAdminName(String paramString)
  {
    this.docAdminName = paramString;
  }
  
  public Long getStorageId()
  {
    return this.storageId;
  }
  
  public void setStorageId(Long paramLong)
  {
    this.storageId = paramLong;
  }
  
  public int hashCode()
  {
    int i = 1;
    i = 31 * i + (this.createdBy == null ? 0 : this.createdBy.hashCode());
    i = 31 * i + (this.creationDate == null ? 0 : this.creationDate.hashCode());
    i = 31 * i + (this.docAdminCode == null ? 0 : this.docAdminCode.hashCode());
    i = 31 * i + (this.docAdminId == null ? 0 : this.docAdminId.hashCode());
    i = 31 * i + (this.docAdminName == null ? 0 : this.docAdminName.hashCode());
    i = 31 * i + (this.docId == null ? 0 : this.docId.hashCode());
    i = 31 * i + (this.enabledFlag == null ? 0 : this.enabledFlag.hashCode());
    i = 31 * i + (this.lastUpdateDate == null ? 0 : this.lastUpdateDate.hashCode());
    i = 31 * i + (this.lastUpdateLogin == null ? 0 : this.lastUpdateLogin.hashCode());
    i = 31 * i + (this.lastUpdatedBy == null ? 0 : this.lastUpdatedBy.hashCode());
    i = 31 * i + (this.storageId == null ? 0 : this.storageId.hashCode());
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
    EvsDocAdmin localEvsDocAdmin = (EvsDocAdmin)paramObject;
    if (this.createdBy == null)
    {
      if (localEvsDocAdmin.createdBy != null) {
        return false;
      }
    }
    else if (!this.createdBy.equals(localEvsDocAdmin.createdBy)) {
      return false;
    }
    if (this.creationDate == null)
    {
      if (localEvsDocAdmin.creationDate != null) {
        return false;
      }
    }
    else if (!this.creationDate.equals(localEvsDocAdmin.creationDate)) {
      return false;
    }
    if (this.docAdminCode == null)
    {
      if (localEvsDocAdmin.docAdminCode != null) {
        return false;
      }
    }
    else if (!this.docAdminCode.equals(localEvsDocAdmin.docAdminCode)) {
      return false;
    }
    if (this.docAdminId == null)
    {
      if (localEvsDocAdmin.docAdminId != null) {
        return false;
      }
    }
    else if (!this.docAdminId.equals(localEvsDocAdmin.docAdminId)) {
      return false;
    }
    if (this.docAdminName == null)
    {
      if (localEvsDocAdmin.docAdminName != null) {
        return false;
      }
    }
    else if (!this.docAdminName.equals(localEvsDocAdmin.docAdminName)) {
      return false;
    }
    if (this.docId == null)
    {
      if (localEvsDocAdmin.docId != null) {
        return false;
      }
    }
    else if (!this.docId.equals(localEvsDocAdmin.docId)) {
      return false;
    }
    if (this.enabledFlag == null)
    {
      if (localEvsDocAdmin.enabledFlag != null) {
        return false;
      }
    }
    else if (!this.enabledFlag.equals(localEvsDocAdmin.enabledFlag)) {
      return false;
    }
    if (this.lastUpdateDate == null)
    {
      if (localEvsDocAdmin.lastUpdateDate != null) {
        return false;
      }
    }
    else if (!this.lastUpdateDate.equals(localEvsDocAdmin.lastUpdateDate)) {
      return false;
    }
    if (this.lastUpdateLogin == null)
    {
      if (localEvsDocAdmin.lastUpdateLogin != null) {
        return false;
      }
    }
    else if (!this.lastUpdateLogin.equals(localEvsDocAdmin.lastUpdateLogin)) {
      return false;
    }
    if (this.lastUpdatedBy == null)
    {
      if (localEvsDocAdmin.lastUpdatedBy != null) {
        return false;
      }
    }
    else if (!this.lastUpdatedBy.equals(localEvsDocAdmin.lastUpdatedBy)) {
      return false;
    }
    if (this.storageId == null)
    {
      if (localEvsDocAdmin.storageId != null) {
        return false;
      }
    }
    else if (!this.storageId.equals(localEvsDocAdmin.storageId)) {
      return false;
    }
    return true;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsDocAdmin
 * JD-Core Version:    0.7.0.1
 */