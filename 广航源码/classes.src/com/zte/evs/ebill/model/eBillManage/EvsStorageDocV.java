package com.zte.evs.ebill.model.eBillManage;

public class EvsStorageDocV
{
  private Long storageId;
  private String storageCode;
  private String storageName;
  private String state;
  private String enabledFlagMeaning;
  private Long companyId;
  private String companyCode;
  private String companyName;
  private Long cityId;
  private String cityCode;
  private String cityName;
  private String docAdminId;
  private String docAdminIds;
  private String docAdminCode;
  private String docAdminName;
  private Long libraryId;
  private String libraryCode;
  private String libraryName;
  private String libraryAtt;
  private String validity;
  private String rtnString;
  
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
  
  public String getEnabledFlagMeaning()
  {
    return this.enabledFlagMeaning;
  }
  
  public void setEnabledFlagMeaning(String paramString)
  {
    this.enabledFlagMeaning = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public Long getCityId()
  {
    return this.cityId;
  }
  
  public void setCityId(Long paramLong)
  {
    this.cityId = paramLong;
  }
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public String getCityName()
  {
    return this.cityName;
  }
  
  public void setCityName(String paramString)
  {
    this.cityName = paramString;
  }
  
  public String getDocAdminId()
  {
    return this.docAdminId;
  }
  
  public void setDocAdminId(String paramString)
  {
    this.docAdminId = paramString;
  }
  
  public String getDocAdminIds()
  {
    return this.docAdminIds;
  }
  
  public void setDocAdminIds(String paramString)
  {
    this.docAdminIds = paramString;
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
  
  public Long getLibraryId()
  {
    return this.libraryId;
  }
  
  public void setLibraryId(Long paramLong)
  {
    this.libraryId = paramLong;
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
  
  public String getRtnString()
  {
    return this.rtnString;
  }
  
  public void setRtnString(String paramString)
  {
    this.rtnString = paramString;
  }
  
  public int hashCode()
  {
    int i = 1;
    i = 31 * i + (this.cityCode == null ? 0 : this.cityCode.hashCode());
    i = 31 * i + (this.cityId == null ? 0 : this.cityId.hashCode());
    i = 31 * i + (this.cityName == null ? 0 : this.cityName.hashCode());
    i = 31 * i + (this.companyCode == null ? 0 : this.companyCode.hashCode());
    i = 31 * i + (this.companyId == null ? 0 : this.companyId.hashCode());
    i = 31 * i + (this.companyName == null ? 0 : this.companyName.hashCode());
    i = 31 * i + (this.docAdminCode == null ? 0 : this.docAdminCode.hashCode());
    i = 31 * i + (this.docAdminId == null ? 0 : this.docAdminId.hashCode());
    i = 31 * i + (this.docAdminIds == null ? 0 : this.docAdminIds.hashCode());
    i = 31 * i + (this.docAdminName == null ? 0 : this.docAdminName.hashCode());
    i = 31 * i + (this.enabledFlagMeaning == null ? 0 : this.enabledFlagMeaning.hashCode());
    i = 31 * i + (this.libraryAtt == null ? 0 : this.libraryAtt.hashCode());
    i = 31 * i + (this.libraryCode == null ? 0 : this.libraryCode.hashCode());
    i = 31 * i + (this.libraryId == null ? 0 : this.libraryId.hashCode());
    i = 31 * i + (this.libraryName == null ? 0 : this.libraryName.hashCode());
    i = 31 * i + (this.rtnString == null ? 0 : this.rtnString.hashCode());
    i = 31 * i + (this.state == null ? 0 : this.state.hashCode());
    i = 31 * i + (this.storageCode == null ? 0 : this.storageCode.hashCode());
    i = 31 * i + (this.storageId == null ? 0 : this.storageId.hashCode());
    i = 31 * i + (this.storageName == null ? 0 : this.storageName.hashCode());
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
    EvsStorageDocV localEvsStorageDocV = (EvsStorageDocV)paramObject;
    if (this.cityCode == null)
    {
      if (localEvsStorageDocV.cityCode != null) {
        return false;
      }
    }
    else if (!this.cityCode.equals(localEvsStorageDocV.cityCode)) {
      return false;
    }
    if (this.cityId == null)
    {
      if (localEvsStorageDocV.cityId != null) {
        return false;
      }
    }
    else if (!this.cityId.equals(localEvsStorageDocV.cityId)) {
      return false;
    }
    if (this.cityName == null)
    {
      if (localEvsStorageDocV.cityName != null) {
        return false;
      }
    }
    else if (!this.cityName.equals(localEvsStorageDocV.cityName)) {
      return false;
    }
    if (this.companyCode == null)
    {
      if (localEvsStorageDocV.companyCode != null) {
        return false;
      }
    }
    else if (!this.companyCode.equals(localEvsStorageDocV.companyCode)) {
      return false;
    }
    if (this.companyId == null)
    {
      if (localEvsStorageDocV.companyId != null) {
        return false;
      }
    }
    else if (!this.companyId.equals(localEvsStorageDocV.companyId)) {
      return false;
    }
    if (this.companyName == null)
    {
      if (localEvsStorageDocV.companyName != null) {
        return false;
      }
    }
    else if (!this.companyName.equals(localEvsStorageDocV.companyName)) {
      return false;
    }
    if (this.docAdminCode == null)
    {
      if (localEvsStorageDocV.docAdminCode != null) {
        return false;
      }
    }
    else if (!this.docAdminCode.equals(localEvsStorageDocV.docAdminCode)) {
      return false;
    }
    if (this.docAdminId == null)
    {
      if (localEvsStorageDocV.docAdminId != null) {
        return false;
      }
    }
    else if (!this.docAdminId.equals(localEvsStorageDocV.docAdminId)) {
      return false;
    }
    if (this.docAdminIds == null)
    {
      if (localEvsStorageDocV.docAdminIds != null) {
        return false;
      }
    }
    else if (!this.docAdminIds.equals(localEvsStorageDocV.docAdminIds)) {
      return false;
    }
    if (this.docAdminName == null)
    {
      if (localEvsStorageDocV.docAdminName != null) {
        return false;
      }
    }
    else if (!this.docAdminName.equals(localEvsStorageDocV.docAdminName)) {
      return false;
    }
    if (this.enabledFlagMeaning == null)
    {
      if (localEvsStorageDocV.enabledFlagMeaning != null) {
        return false;
      }
    }
    else if (!this.enabledFlagMeaning.equals(localEvsStorageDocV.enabledFlagMeaning)) {
      return false;
    }
    if (this.libraryAtt == null)
    {
      if (localEvsStorageDocV.libraryAtt != null) {
        return false;
      }
    }
    else if (!this.libraryAtt.equals(localEvsStorageDocV.libraryAtt)) {
      return false;
    }
    if (this.libraryCode == null)
    {
      if (localEvsStorageDocV.libraryCode != null) {
        return false;
      }
    }
    else if (!this.libraryCode.equals(localEvsStorageDocV.libraryCode)) {
      return false;
    }
    if (this.libraryId == null)
    {
      if (localEvsStorageDocV.libraryId != null) {
        return false;
      }
    }
    else if (!this.libraryId.equals(localEvsStorageDocV.libraryId)) {
      return false;
    }
    if (this.libraryName == null)
    {
      if (localEvsStorageDocV.libraryName != null) {
        return false;
      }
    }
    else if (!this.libraryName.equals(localEvsStorageDocV.libraryName)) {
      return false;
    }
    if (this.rtnString == null)
    {
      if (localEvsStorageDocV.rtnString != null) {
        return false;
      }
    }
    else if (!this.rtnString.equals(localEvsStorageDocV.rtnString)) {
      return false;
    }
    if (this.state == null)
    {
      if (localEvsStorageDocV.state != null) {
        return false;
      }
    }
    else if (!this.state.equals(localEvsStorageDocV.state)) {
      return false;
    }
    if (this.storageCode == null)
    {
      if (localEvsStorageDocV.storageCode != null) {
        return false;
      }
    }
    else if (!this.storageCode.equals(localEvsStorageDocV.storageCode)) {
      return false;
    }
    if (this.storageId == null)
    {
      if (localEvsStorageDocV.storageId != null) {
        return false;
      }
    }
    else if (!this.storageId.equals(localEvsStorageDocV.storageId)) {
      return false;
    }
    if (this.storageName == null)
    {
      if (localEvsStorageDocV.storageName != null) {
        return false;
      }
    }
    else if (!this.storageName.equals(localEvsStorageDocV.storageName)) {
      return false;
    }
    if (this.validity == null)
    {
      if (localEvsStorageDocV.validity != null) {
        return false;
      }
    }
    else if (!this.validity.equals(localEvsStorageDocV.validity)) {
      return false;
    }
    return true;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsStorageDocV
 * JD-Core Version:    0.7.0.1
 */