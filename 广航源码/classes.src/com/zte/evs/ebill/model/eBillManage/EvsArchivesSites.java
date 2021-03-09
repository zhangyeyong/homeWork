package com.zte.evs.ebill.model.eBillManage;

import java.util.Date;

public class EvsArchivesSites
{
  private Long archivesSiteId;
  private String archivesSiteCode;
  private String archivesSiteName;
  private String address;
  private String property;
  private String checkUnit;
  private Long vendorId;
  private String enabledFlag;
  private String description;
  private Long createdBy;
  private Date creationDate;
  private Long lastUpdateLogin;
  private Long lastUpdatedBy;
  private Date lastUpdateDate;
  
  public EvsArchivesSites() {}
  
  public EvsArchivesSites(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong2, String paramString6, String paramString7, Long paramLong3, Date paramDate1, Long paramLong4, Long paramLong5, Date paramDate2)
  {
    this.archivesSiteId = paramLong1;
    this.archivesSiteCode = paramString1;
    this.archivesSiteName = paramString2;
    this.address = paramString3;
    this.property = paramString4;
    this.checkUnit = paramString5;
    this.vendorId = paramLong2;
    this.enabledFlag = paramString6;
    this.description = paramString7;
    this.createdBy = paramLong3;
    this.creationDate = paramDate1;
    this.lastUpdateLogin = paramLong4;
    this.lastUpdatedBy = paramLong5;
    this.lastUpdateDate = paramDate2;
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
  
  public String getProperty()
  {
    return this.property;
  }
  
  public void setProperty(String paramString)
  {
    this.property = paramString;
  }
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
  
  public Long getVendorId()
  {
    return this.vendorId;
  }
  
  public void setVendorId(Long paramLong)
  {
    this.vendorId = paramLong;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
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
  
  public Long getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(Long paramLong)
  {
    this.createdBy = paramLong;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsArchivesSites
 * JD-Core Version:    0.7.0.1
 */