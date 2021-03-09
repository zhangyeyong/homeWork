package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsInventory
  implements Serializable
{
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdatedBy;
  private Long lastUpdateLogin;
  private String enabledFlag;
  private Long inventoryId;
  private Long bookId;
  private String invBatchNum;
  private String invCityId;
  private String invCityName;
  private Long invStorageId;
  private String invStorageCode;
  private String invStorageName;
  private String invArea;
  private String invRow;
  private String invColumn;
  private String invLevel;
  private String bookCodes;
  
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
  
  public Long getInventoryId()
  {
    return this.inventoryId;
  }
  
  public void setInventoryId(Long paramLong)
  {
    this.inventoryId = paramLong;
  }
  
  public Long getBookId()
  {
    return this.bookId;
  }
  
  public void setBookId(Long paramLong)
  {
    this.bookId = paramLong;
  }
  
  public String getInvBatchNum()
  {
    return this.invBatchNum;
  }
  
  public void setInvBatchNum(String paramString)
  {
    this.invBatchNum = paramString;
  }
  
  public String getInvCityId()
  {
    return this.invCityId;
  }
  
  public void setInvCityId(String paramString)
  {
    this.invCityId = paramString;
  }
  
  public String getInvCityName()
  {
    return this.invCityName;
  }
  
  public void setInvCityName(String paramString)
  {
    this.invCityName = paramString;
  }
  
  public Long getInvStorageId()
  {
    return this.invStorageId;
  }
  
  public void setInvStorageId(Long paramLong)
  {
    this.invStorageId = paramLong;
  }
  
  public String getInvStorageCode()
  {
    return this.invStorageCode;
  }
  
  public void setInvStorageCode(String paramString)
  {
    this.invStorageCode = paramString;
  }
  
  public String getInvStorageName()
  {
    return this.invStorageName;
  }
  
  public void setInvStorageName(String paramString)
  {
    this.invStorageName = paramString;
  }
  
  public String getInvArea()
  {
    return this.invArea;
  }
  
  public void setInvArea(String paramString)
  {
    this.invArea = paramString;
  }
  
  public String getInvRow()
  {
    return this.invRow;
  }
  
  public void setInvRow(String paramString)
  {
    this.invRow = paramString;
  }
  
  public String getInvColumn()
  {
    return this.invColumn;
  }
  
  public void setInvColumn(String paramString)
  {
    this.invColumn = paramString;
  }
  
  public String getInvLevel()
  {
    return this.invLevel;
  }
  
  public void setInvLevel(String paramString)
  {
    this.invLevel = paramString;
  }
  
  public int hashCode()
  {
    int i = 1;
    i = 31 * i + (this.bookId == null ? 0 : this.bookId.hashCode());
    i = 31 * i + (this.createdBy == null ? 0 : this.createdBy.hashCode());
    i = 31 * i + (this.creationDate == null ? 0 : this.creationDate.hashCode());
    i = 31 * i + (this.enabledFlag == null ? 0 : this.enabledFlag.hashCode());
    i = 31 * i + (this.invArea == null ? 0 : this.invArea.hashCode());
    i = 31 * i + (this.invBatchNum == null ? 0 : this.invBatchNum.hashCode());
    i = 31 * i + (this.invCityId == null ? 0 : this.invCityId.hashCode());
    i = 31 * i + (this.invCityName == null ? 0 : this.invCityName.hashCode());
    i = 31 * i + (this.invColumn == null ? 0 : this.invColumn.hashCode());
    i = 31 * i + (this.invLevel == null ? 0 : this.invLevel.hashCode());
    i = 31 * i + (this.invRow == null ? 0 : this.invRow.hashCode());
    i = 31 * i + (this.invStorageCode == null ? 0 : this.invStorageCode.hashCode());
    i = 31 * i + (this.invStorageId == null ? 0 : this.invStorageId.hashCode());
    i = 31 * i + (this.invStorageName == null ? 0 : this.invStorageName.hashCode());
    i = 31 * i + (this.inventoryId == null ? 0 : this.inventoryId.hashCode());
    i = 31 * i + (this.lastUpdateDate == null ? 0 : this.lastUpdateDate.hashCode());
    i = 31 * i + (this.lastUpdateLogin == null ? 0 : this.lastUpdateLogin.hashCode());
    i = 31 * i + (this.lastUpdatedBy == null ? 0 : this.lastUpdatedBy.hashCode());
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
    EvsInventory localEvsInventory = (EvsInventory)paramObject;
    if (this.bookId == null)
    {
      if (localEvsInventory.bookId != null) {
        return false;
      }
    }
    else if (!this.bookId.equals(localEvsInventory.bookId)) {
      return false;
    }
    if (this.createdBy == null)
    {
      if (localEvsInventory.createdBy != null) {
        return false;
      }
    }
    else if (!this.createdBy.equals(localEvsInventory.createdBy)) {
      return false;
    }
    if (this.creationDate == null)
    {
      if (localEvsInventory.creationDate != null) {
        return false;
      }
    }
    else if (!this.creationDate.equals(localEvsInventory.creationDate)) {
      return false;
    }
    if (this.enabledFlag == null)
    {
      if (localEvsInventory.enabledFlag != null) {
        return false;
      }
    }
    else if (!this.enabledFlag.equals(localEvsInventory.enabledFlag)) {
      return false;
    }
    if (this.invArea == null)
    {
      if (localEvsInventory.invArea != null) {
        return false;
      }
    }
    else if (!this.invArea.equals(localEvsInventory.invArea)) {
      return false;
    }
    if (this.invBatchNum == null)
    {
      if (localEvsInventory.invBatchNum != null) {
        return false;
      }
    }
    else if (!this.invBatchNum.equals(localEvsInventory.invBatchNum)) {
      return false;
    }
    if (this.invCityId == null)
    {
      if (localEvsInventory.invCityId != null) {
        return false;
      }
    }
    else if (!this.invCityId.equals(localEvsInventory.invCityId)) {
      return false;
    }
    if (this.invCityName == null)
    {
      if (localEvsInventory.invCityName != null) {
        return false;
      }
    }
    else if (!this.invCityName.equals(localEvsInventory.invCityName)) {
      return false;
    }
    if (this.invColumn == null)
    {
      if (localEvsInventory.invColumn != null) {
        return false;
      }
    }
    else if (!this.invColumn.equals(localEvsInventory.invColumn)) {
      return false;
    }
    if (this.invLevel == null)
    {
      if (localEvsInventory.invLevel != null) {
        return false;
      }
    }
    else if (!this.invLevel.equals(localEvsInventory.invLevel)) {
      return false;
    }
    if (this.invRow == null)
    {
      if (localEvsInventory.invRow != null) {
        return false;
      }
    }
    else if (!this.invRow.equals(localEvsInventory.invRow)) {
      return false;
    }
    if (this.invStorageCode == null)
    {
      if (localEvsInventory.invStorageCode != null) {
        return false;
      }
    }
    else if (!this.invStorageCode.equals(localEvsInventory.invStorageCode)) {
      return false;
    }
    if (this.invStorageId == null)
    {
      if (localEvsInventory.invStorageId != null) {
        return false;
      }
    }
    else if (!this.invStorageId.equals(localEvsInventory.invStorageId)) {
      return false;
    }
    if (this.invStorageName == null)
    {
      if (localEvsInventory.invStorageName != null) {
        return false;
      }
    }
    else if (!this.invStorageName.equals(localEvsInventory.invStorageName)) {
      return false;
    }
    if (this.inventoryId == null)
    {
      if (localEvsInventory.inventoryId != null) {
        return false;
      }
    }
    else if (!this.inventoryId.equals(localEvsInventory.inventoryId)) {
      return false;
    }
    if (this.lastUpdateDate == null)
    {
      if (localEvsInventory.lastUpdateDate != null) {
        return false;
      }
    }
    else if (!this.lastUpdateDate.equals(localEvsInventory.lastUpdateDate)) {
      return false;
    }
    if (this.lastUpdateLogin == null)
    {
      if (localEvsInventory.lastUpdateLogin != null) {
        return false;
      }
    }
    else if (!this.lastUpdateLogin.equals(localEvsInventory.lastUpdateLogin)) {
      return false;
    }
    if (this.lastUpdatedBy == null)
    {
      if (localEvsInventory.lastUpdatedBy != null) {
        return false;
      }
    }
    else if (!this.lastUpdatedBy.equals(localEvsInventory.lastUpdatedBy)) {
      return false;
    }
    return true;
  }
  
  public String getBookCodes()
  {
    return this.bookCodes;
  }
  
  public void setBookCodes(String paramString)
  {
    this.bookCodes = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsInventory
 * JD-Core Version:    0.7.0.1
 */