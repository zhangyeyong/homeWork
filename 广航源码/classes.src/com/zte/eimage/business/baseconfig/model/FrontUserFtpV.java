package com.zte.eimage.business.baseconfig.model;

import java.util.Date;

public class FrontUserFtpV
{
  private Date lastUpdateDate;
  private Long lastUpdatedBy;
  private Date creationDate;
  private Long createdBy;
  private Long lastUpdateLogin;
  private String enabledFlag;
  private Integer frontUserId;
  private Integer employeeId;
  private String uploadMode;
  private Integer siteId;
  private String ftpSite;
  private Integer port;
  private String ftpUserName;
  private String ftpPassword;
  private Integer startHour;
  private Integer startMinute;
  private Integer endHour;
  private Integer endMinute;
  private String userPurview;
  private String employeeName;
  private String employeeNum;
  private String rootDirectory;
  
  public FrontUserFtpV() {}
  
  public FrontUserFtpV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, String paramString3)
  {
    this.lastUpdateDate = paramDate1;
    this.lastUpdatedBy = paramLong1;
    this.creationDate = paramDate2;
    this.createdBy = paramLong2;
    this.lastUpdateLogin = paramLong3;
    this.enabledFlag = paramString1;
    this.frontUserId = paramInteger1;
    this.employeeId = paramInteger2;
    this.uploadMode = paramString2;
    this.siteId = paramInteger3;
    this.startHour = paramInteger4;
    this.startMinute = paramInteger5;
    this.endHour = paramInteger6;
    this.endMinute = paramInteger7;
    this.userPurview = paramString3;
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
  
  public Integer getFrontUserId()
  {
    return this.frontUserId;
  }
  
  public void setFrontUserId(Integer paramInteger)
  {
    this.frontUserId = paramInteger;
  }
  
  public Integer getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Integer paramInteger)
  {
    this.employeeId = paramInteger;
  }
  
  public String getUploadMode()
  {
    return this.uploadMode;
  }
  
  public void setUploadMode(String paramString)
  {
    this.uploadMode = paramString;
  }
  
  public Integer getSiteId()
  {
    return this.siteId;
  }
  
  public void setSiteId(Integer paramInteger)
  {
    this.siteId = paramInteger;
  }
  
  public Integer getStartHour()
  {
    return this.startHour;
  }
  
  public void setStartHour(Integer paramInteger)
  {
    this.startHour = paramInteger;
  }
  
  public Integer getStartMinute()
  {
    return this.startMinute;
  }
  
  public void setStartMinute(Integer paramInteger)
  {
    this.startMinute = paramInteger;
  }
  
  public Integer getEndHour()
  {
    return this.endHour;
  }
  
  public void setEndHour(Integer paramInteger)
  {
    this.endHour = paramInteger;
  }
  
  public Integer getEndMinute()
  {
    return this.endMinute;
  }
  
  public void setEndMinute(Integer paramInteger)
  {
    this.endMinute = paramInteger;
  }
  
  public String getUserPurview()
  {
    return this.userPurview;
  }
  
  public void setUserPurview(String paramString)
  {
    this.userPurview = paramString;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getEmployeeNum()
  {
    return this.employeeNum;
  }
  
  public void setEmployeeNum(String paramString)
  {
    this.employeeNum = paramString;
  }
  
  public String getFtpSite()
  {
    return this.ftpSite;
  }
  
  public void setFtpSite(String paramString)
  {
    this.ftpSite = paramString;
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
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.FrontUserFtpV
 * JD-Core Version:    0.7.0.1
 */