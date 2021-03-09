package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class EidSites
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected BigInteger siteId;
  protected String siteName;
  protected String ftpSite;
  protected String webSite;
  protected BigInteger port;
  protected String ftpUserName;
  protected String ftpPassword;
  protected String ftpAbsolutePath;
  protected String rootDirectory;
  protected Long companyId;
  
  public EidSites() {}
  
  public EidSites(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, BigInteger paramBigInteger1, String paramString2, String paramString3, String paramString4, BigInteger paramBigInteger2, String paramString5, String paramString6, String paramString7, String paramString8, Long paramLong4)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setSiteId(paramBigInteger1);
    setSiteName(paramString2);
    setFtpSite(paramString3);
    setWebSite(paramString4);
    setPort(paramBigInteger2);
    setFtpUserName(paramString5);
    setFtpPassword(paramString6);
    setFtpAbsolutePath(paramString7);
    setRootDirectory(paramString8);
    setCompanyId(paramLong4);
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
  
  public BigInteger getSiteId()
  {
    return this.siteId;
  }
  
  public void setSiteId(BigInteger paramBigInteger)
  {
    this.siteId = paramBigInteger;
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
  
  public BigInteger getPort()
  {
    return this.port;
  }
  
  public void setPort(BigInteger paramBigInteger)
  {
    this.port = paramBigInteger;
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
  
  public String getFtpAbsolutePath()
  {
    return this.ftpAbsolutePath;
  }
  
  public void setFtpAbsolutePath(String paramString)
  {
    this.ftpAbsolutePath = paramString;
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
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidSites
 * JD-Core Version:    0.7.0.1
 */