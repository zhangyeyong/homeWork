package com.zte.evs.ebill.model.eBillManage;

public class EvsArchivesSitesV
{
  private Long archivesSiteId;
  private String archivesSiteCode;
  private String archivesSiteName;
  private String address;
  private Long propertyId;
  private String property;
  private String propertyName;
  private Long contentId;
  private String checkUnit;
  private String checkUnitName;
  private Long vendorId;
  private String vendorName;
  private String enabledFlag;
  private String enabledFlagName;
  private String description;
  
  public EvsArchivesSitesV() {}
  
  public EvsArchivesSitesV(Long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong2, String paramString4, String paramString5, Long paramLong3, String paramString6, String paramString7, Long paramLong4, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.archivesSiteId = paramLong1;
    this.archivesSiteCode = paramString1;
    this.archivesSiteName = paramString2;
    this.address = paramString3;
    this.propertyId = paramLong2;
    this.property = paramString4;
    this.propertyName = paramString5;
    this.contentId = paramLong3;
    this.checkUnit = paramString6;
    this.checkUnitName = paramString7;
    this.vendorId = paramLong4;
    this.vendorName = paramString8;
    this.enabledFlag = paramString9;
    this.enabledFlagName = paramString10;
    this.description = paramString11;
  }
  
  public Long getArchivesSiteId()
  {
    return this.archivesSiteId;
  }
  
  public void setArchivesSiteId(Long paramLong)
  {
    this.archivesSiteId = paramLong;
  }
  
  public String getArchivesSiteCode()
  {
    return this.archivesSiteCode;
  }
  
  public void setArchivesSiteCode(String paramString)
  {
    this.archivesSiteCode = paramString;
  }
  
  public String getArchivesSiteName()
  {
    return this.archivesSiteName;
  }
  
  public void setArchivesSiteName(String paramString)
  {
    this.archivesSiteName = paramString;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public Long getPropertyId()
  {
    return this.propertyId;
  }
  
  public void setPropertyId(Long paramLong)
  {
    this.propertyId = paramLong;
  }
  
  public String getProperty()
  {
    return this.property;
  }
  
  public void setProperty(String paramString)
  {
    this.property = paramString;
  }
  
  public String getPropertyName()
  {
    return this.propertyName;
  }
  
  public void setPropertyName(String paramString)
  {
    this.propertyName = paramString;
  }
  
  public Long getContentId()
  {
    return this.contentId;
  }
  
  public void setContentId(Long paramLong)
  {
    this.contentId = paramLong;
  }
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
  
  public String getCheckUnitName()
  {
    return this.checkUnitName;
  }
  
  public void setCheckUnitName(String paramString)
  {
    this.checkUnitName = paramString;
  }
  
  public Long getVendorId()
  {
    return this.vendorId;
  }
  
  public void setVendorId(Long paramLong)
  {
    this.vendorId = paramLong;
  }
  
  public String getVendorName()
  {
    return this.vendorName;
  }
  
  public void setVendorName(String paramString)
  {
    this.vendorName = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getEnabledFlagName()
  {
    return this.enabledFlagName;
  }
  
  public void setEnabledFlagName(String paramString)
  {
    this.enabledFlagName = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    if (paramString != null) {
      this.description = paramString;
    } else {
      this.description = "";
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsArchivesSitesV
 * JD-Core Version:    0.7.0.1
 */