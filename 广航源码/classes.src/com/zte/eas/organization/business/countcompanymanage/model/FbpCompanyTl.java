package com.zte.eas.organization.business.countcompanymanage.model;

import java.util.Date;

public class FbpCompanyTl
{
  private static final long serialVersionUID = 1L;
  protected Date creationDate;
  protected Long createdBy;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected String companyName;
  protected String description;
  protected FbpCompanyTlPk fbpCompanyTlPk = new FbpCompanyTlPk();
  protected String sourceLang;
  
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
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public String getSourceLang()
  {
    return this.sourceLang;
  }
  
  public void setSourceLang(String paramString)
  {
    this.sourceLang = paramString;
  }
  
  public FbpCompanyTl() {}
  
  public FbpCompanyTlPk getFbpCompanyTlPk()
  {
    return this.fbpCompanyTlPk;
  }
  
  public void setFbpCompanyTlPk(FbpCompanyTlPk paramFbpCompanyTlPk)
  {
    this.fbpCompanyTlPk = paramFbpCompanyTlPk;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
  }
  
  public FbpCompanyTl(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, String paramString2, String paramString3, FbpCompanyTlPk paramFbpCompanyTlPk, String paramString4)
  {
    this.creationDate = paramDate1;
    this.createdBy = paramLong1;
    this.lastUpdateDate = paramDate2;
    this.lastUpdatedBy = paramLong2;
    this.lastUpdateLogin = paramLong3;
    this.enabledFlag = paramString1;
    this.companyName = paramString2;
    this.description = paramString3;
    this.fbpCompanyTlPk = paramFbpCompanyTlPk;
    this.sourceLang = paramString4;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyTl
 * JD-Core Version:    0.7.0.1
 */