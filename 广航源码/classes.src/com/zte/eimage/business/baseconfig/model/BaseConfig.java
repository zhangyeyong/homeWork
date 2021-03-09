package com.zte.eimage.business.baseconfig.model;

import java.util.Date;

public class BaseConfig
{
  private Date lastUpdateDate;
  private Long lastUpdatedBy;
  private Date creationDate;
  private Long createdBy;
  private Long lastUpdateLogin;
  private String enabledFlag;
  private Integer baseConfigId;
  private String baseConfigName;
  private String picType;
  private Integer resRatio;
  private String color;
  private String sideType;
  private String isDefault;
  private Integer luminance;
  private Integer contrast;
  private Integer threshold;
  private Integer compressRatio;
  private String isDelBlankPage;
  
  public BaseConfig(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Integer paramInteger1, String paramString2, String paramString3, Integer paramInteger2, String paramString4, String paramString5, String paramString6, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, String paramString7)
  {
    this.lastUpdateDate = paramDate1;
    this.lastUpdatedBy = paramLong1;
    this.creationDate = paramDate2;
    this.createdBy = paramLong2;
    this.lastUpdateLogin = paramLong3;
    this.enabledFlag = paramString1;
    this.baseConfigId = paramInteger1;
    this.baseConfigName = paramString2;
    this.picType = paramString3;
    this.resRatio = paramInteger2;
    this.color = paramString4;
    this.sideType = paramString5;
    this.isDefault = paramString6;
    this.luminance = paramInteger3;
    this.contrast = paramInteger4;
    this.threshold = paramInteger5;
    this.compressRatio = paramInteger6;
    this.isDelBlankPage = paramString7;
  }
  
  public BaseConfig() {}
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
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
  
  public Integer getBaseConfigId()
  {
    return this.baseConfigId;
  }
  
  public void setBaseConfigId(Integer paramInteger)
  {
    this.baseConfigId = paramInteger;
  }
  
  public String getBaseConfigName()
  {
    return this.baseConfigName;
  }
  
  public void setBaseConfigName(String paramString)
  {
    this.baseConfigName = paramString;
  }
  
  public String getPicType()
  {
    return this.picType;
  }
  
  public void setPicType(String paramString)
  {
    this.picType = paramString;
  }
  
  public Integer getResRatio()
  {
    return this.resRatio;
  }
  
  public void setResRatio(Integer paramInteger)
  {
    this.resRatio = paramInteger;
  }
  
  public String getColor()
  {
    return this.color;
  }
  
  public void setColor(String paramString)
  {
    this.color = paramString;
  }
  
  public String getSideType()
  {
    return this.sideType;
  }
  
  public void setSideType(String paramString)
  {
    this.sideType = paramString;
  }
  
  public String getIsDefault()
  {
    return this.isDefault;
  }
  
  public void setIsDefault(String paramString)
  {
    this.isDefault = paramString;
  }
  
  public Integer getLuminance()
  {
    return this.luminance;
  }
  
  public void setLuminance(Integer paramInteger)
  {
    this.luminance = paramInteger;
  }
  
  public Integer getContrast()
  {
    return this.contrast;
  }
  
  public void setContrast(Integer paramInteger)
  {
    this.contrast = paramInteger;
  }
  
  public Integer getThreshold()
  {
    return this.threshold;
  }
  
  public void setThreshold(Integer paramInteger)
  {
    this.threshold = paramInteger;
  }
  
  public Integer getCompressRatio()
  {
    return this.compressRatio;
  }
  
  public void setCompressRatio(Integer paramInteger)
  {
    this.compressRatio = paramInteger;
  }
  
  public String getIsDelBlankPage()
  {
    return this.isDelBlankPage;
  }
  
  public void setIsDelBlankPage(String paramString)
  {
    this.isDelBlankPage = paramString;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.BaseConfig
 * JD-Core Version:    0.7.0.1
 */