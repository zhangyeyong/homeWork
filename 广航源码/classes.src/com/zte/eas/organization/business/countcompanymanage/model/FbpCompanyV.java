package com.zte.eas.organization.business.countcompanymanage.model;

import java.util.Date;

public class FbpCompanyV
{
  private static final long serialVersionUID = 1L;
  protected Date creationDate;
  protected Long createdBy;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected String enabledFlagMeaning;
  protected Long companyId;
  protected String companyCode;
  protected String setOfBooksCode;
  protected String employeeNumber;
  protected String isCheck;
  protected String isCheckMeaning;
  protected String companyName;
  protected String description;
  protected String language;
  protected String sourceLang;
  protected String employeeName;
  protected String setOfBooksName;
  protected String company;
  protected String superCompanyName;
  
  public String getCompany()
  {
    return this.company;
  }
  
  public void setCompany(String paramString)
  {
    this.company = paramString;
  }
  
  public FbpCompanyV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.creationDate = paramDate1;
    this.createdBy = paramLong1;
    this.lastUpdateDate = paramDate2;
    this.lastUpdatedBy = paramLong2;
    this.lastUpdateLogin = paramLong3;
    this.enabledFlag = paramString1;
    this.companyId = paramLong4;
    this.companyCode = paramString2;
    this.setOfBooksCode = paramString3;
    this.employeeNumber = paramString4;
    this.isCheck = paramString5;
    this.companyName = paramString6;
    this.description = paramString7;
    this.language = paramString8;
    this.sourceLang = paramString9;
    this.employeeName = paramString10;
    this.setOfBooksName = paramString11;
  }
  
  public String getSetOfBooksCode()
  {
    return this.setOfBooksCode;
  }
  
  public void setSetOfBooksCode(String paramString)
  {
    this.setOfBooksCode = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public FbpCompanyV(String paramString)
  {
    this.sourceLang = paramString;
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
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public String getIsCheck()
  {
    return this.isCheck;
  }
  
  public void setIsCheck(String paramString)
  {
    this.isCheck = paramString;
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
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public String getSourceLang()
  {
    return this.sourceLang;
  }
  
  public void setSourceLang(String paramString)
  {
    this.sourceLang = paramString;
  }
  
  public static long getSerialVersionUID()
  {
    return 1L;
  }
  
  public FbpCompanyV() {}
  
  public String getSetOfBooksName()
  {
    return this.setOfBooksName;
  }
  
  public void setSetOfBooksName(String paramString)
  {
    this.setOfBooksName = paramString;
  }
  
  public String getEnabledFlagMeaning()
  {
    return this.enabledFlagMeaning;
  }
  
  public void setEnabledFlagMeaning(String paramString)
  {
    this.enabledFlagMeaning = paramString;
  }
  
  public String getIsCheckMeaning()
  {
    return this.isCheckMeaning;
  }
  
  public void setIsCheckMeaning(String paramString)
  {
    this.isCheckMeaning = paramString;
  }
  
  public String getSuperCompanyName()
  {
    return this.superCompanyName;
  }
  
  public void setSuperCompanyName(String paramString)
  {
    this.superCompanyName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV
 * JD-Core Version:    0.7.0.1
 */