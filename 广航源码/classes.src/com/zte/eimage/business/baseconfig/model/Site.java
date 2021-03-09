package com.zte.eimage.business.baseconfig.model;

import java.util.Date;

public class Site
{
  private Date lastUpdateDate;
  private Long lastUpdatedBy;
  private Date creationDate;
  private Long createdBy;
  private Long lastUpdateLogin;
  private String enabledFlag;
  private Integer siteId;
  private String siteName;
  private String ftpSite;
  private String webSite;
  private Integer port;
  private String ftpUserName;
  private String ftpPassword;
  private String ftpAbsolutePath;
  private String rootDirectory;
  private Long companyId;
  
  public Site() {}
  
  public Site(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Integer paramInteger1, String paramString2, String paramString3, String paramString4, Integer paramInteger2, String paramString5, String paramString6, String paramString7, String paramString8, Long paramLong4)
  {
    this.lastUpdateDate = paramDate1;
    this.lastUpdatedBy = paramLong1;
    this.creationDate = paramDate2;
    this.createdBy = paramLong2;
    this.lastUpdateLogin = paramLong3;
    this.enabledFlag = paramString1;
    this.siteId = paramInteger1;
    this.siteName = paramString2;
    this.ftpSite = paramString3;
    this.webSite = paramString4;
    this.port = paramInteger2;
    this.ftpUserName = paramString5;
    this.ftpPassword = paramString6;
    this.ftpAbsolutePath = paramString7;
    this.rootDirectory = paramString8;
    this.companyId = paramLong4;
  }
  
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
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
  }
  
  public String getFtpAbsolutePath()
  {
    return this.ftpAbsolutePath;
  }
  
  public void setFtpAbsolutePath(String paramString)
  {
    this.ftpAbsolutePath = paramString;
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
  
  public Integer getSiteId()
  {
    return this.siteId;
  }
  
  public void setSiteId(Integer paramInteger)
  {
    this.siteId = paramInteger;
  }
  
  public String getSiteName()
  {
    return this.siteName;
  }
  
  public void setSiteName(String paramString)
  {
    this.siteName = paramString;
  }
  
  public String getFtpSite()
  {
    return this.ftpSite;
  }
  
  public void setFtpSite(String paramString)
  {
    this.ftpSite = paramString;
  }
  
  public String getWebSite()
  {
    return this.webSite;
  }
  
  public void setWebSite(String paramString)
  {
    this.webSite = paramString;
  }
  
  public Integer getPort()
  {
    return this.port;
  }
  
  public void setPort(Integer paramInteger)
  {
    this.port = paramInteger;
  }
  
  public String getFtpUserName()
  {
    return this.ftpUserName;
  }
  
  public void setFtpUserName(String paramString)
  {
    this.ftpUserName = paramString;
  }
  
  public String getFtpPassword()
  {
    return this.ftpPassword;
  }
  
  public void setFtpPassword(String paramString)
  {
    this.ftpPassword = paramString;
  }
  
  public String getRootDirectory()
  {
    return this.rootDirectory;
  }
  
  public void setRootDirectory(String paramString)
  {
    this.rootDirectory = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.Site
 * JD-Core Version:    0.7.0.1
 */