package com.zte.eas.organization.business.employeemanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpBankAccounts
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger bankAccountId;
  protected String bankAccountNum;
  protected String bankAccountName;
  protected String bankAccountNameAlt;
  protected String bankName;
  protected String bankBranchName;
  protected String bankAccountType;
  protected String currencyCode;
  protected String country;
  protected String province;
  protected String city;
  protected String agencyLocationCode;
  protected String sourceSystem;
  protected BigInteger sourceBankAccountId;
  protected BigInteger orgId;
  protected Long setOfBooksId;
  protected String attributeCategory;
  protected String attribute1;
  protected String attribute2;
  protected String attribute3;
  protected String attribute4;
  protected String attribute5;
  protected String attribute6;
  protected String attribute7;
  protected String attribute8;
  protected String attribute9;
  protected String attribute10;
  protected String description;
  protected Date inactiveDate;
  protected String enabledFlag;
  
  public FbpBankAccounts() {}
  
  public FbpBankAccounts(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, BigInteger paramBigInteger2, BigInteger paramBigInteger3, Long paramLong4, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, Date paramDate3, String paramString25)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setBankAccountId(paramBigInteger1);
    setBankAccountNum(paramString1);
    setBankAccountName(paramString2);
    setBankAccountNameAlt(paramString3);
    setBankName(paramString4);
    setBankBranchName(paramString5);
    setBankAccountType(paramString6);
    setCurrencyCode(paramString7);
    setCountry(paramString8);
    setProvince(paramString9);
    setCity(paramString10);
    setAgencyLocationCode(paramString11);
    setSourceSystem(paramString12);
    setSourceBankAccountId(paramBigInteger2);
    setOrgId(paramBigInteger3);
    setSetOfBooksId(paramLong4);
    setAttributeCategory(paramString13);
    setAttribute1(paramString14);
    setAttribute2(paramString15);
    setAttribute3(paramString16);
    setAttribute4(paramString17);
    setAttribute5(paramString18);
    setAttribute6(paramString19);
    setAttribute7(paramString20);
    setAttribute8(paramString21);
    setAttribute9(paramString22);
    setAttribute10(paramString23);
    setDescription(paramString24);
    setInactiveDate(paramDate3);
    setEnabledFlag(paramString25);
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
  
  public BigInteger getBankAccountId()
  {
    return this.bankAccountId;
  }
  
  public void setBankAccountId(BigInteger paramBigInteger)
  {
    this.bankAccountId = paramBigInteger;
  }
  
  public String getBankAccountNum()
  {
    return this.bankAccountNum;
  }
  
  public void setBankAccountNum(String paramString)
  {
    this.bankAccountNum = paramString;
  }
  
  public String getBankAccountName()
  {
    return this.bankAccountName;
  }
  
  public void setBankAccountName(String paramString)
  {
    this.bankAccountName = paramString;
  }
  
  public String getBankAccountNameAlt()
  {
    return this.bankAccountNameAlt;
  }
  
  public void setBankAccountNameAlt(String paramString)
  {
    this.bankAccountNameAlt = paramString;
  }
  
  public String getBankName()
  {
    return this.bankName;
  }
  
  public void setBankName(String paramString)
  {
    this.bankName = paramString;
  }
  
  public String getBankBranchName()
  {
    return this.bankBranchName;
  }
  
  public void setBankBranchName(String paramString)
  {
    this.bankBranchName = paramString;
  }
  
  public String getBankAccountType()
  {
    return this.bankAccountType;
  }
  
  public void setBankAccountType(String paramString)
  {
    this.bankAccountType = paramString;
  }
  
  public String getCurrencyCode()
  {
    return this.currencyCode;
  }
  
  public void setCurrencyCode(String paramString)
  {
    this.currencyCode = paramString;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public void setCountry(String paramString)
  {
    this.country = paramString;
  }
  
  public String getProvince()
  {
    return this.province;
  }
  
  public void setProvince(String paramString)
  {
    this.province = paramString;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public void setCity(String paramString)
  {
    this.city = paramString;
  }
  
  public String getAgencyLocationCode()
  {
    return this.agencyLocationCode;
  }
  
  public void setAgencyLocationCode(String paramString)
  {
    this.agencyLocationCode = paramString;
  }
  
  public String getSourceSystem()
  {
    return this.sourceSystem;
  }
  
  public void setSourceSystem(String paramString)
  {
    this.sourceSystem = paramString;
  }
  
  public BigInteger getSourceBankAccountId()
  {
    return this.sourceBankAccountId;
  }
  
  public void setSourceBankAccountId(BigInteger paramBigInteger)
  {
    this.sourceBankAccountId = paramBigInteger;
  }
  
  public BigInteger getOrgId()
  {
    return this.orgId;
  }
  
  public void setOrgId(BigInteger paramBigInteger)
  {
    this.orgId = paramBigInteger;
  }
  
  public Long getSetOfBooksId()
  {
    return this.setOfBooksId;
  }
  
  public void setSetOfBooksId(Long paramLong)
  {
    this.setOfBooksId = paramLong;
  }
  
  public String getAttributeCategory()
  {
    return this.attributeCategory;
  }
  
  public void setAttributeCategory(String paramString)
  {
    this.attributeCategory = paramString;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
  }
  
  public String getAttribute2()
  {
    return this.attribute2;
  }
  
  public void setAttribute2(String paramString)
  {
    this.attribute2 = paramString;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public void setAttribute3(String paramString)
  {
    this.attribute3 = paramString;
  }
  
  public String getAttribute4()
  {
    return this.attribute4;
  }
  
  public void setAttribute4(String paramString)
  {
    this.attribute4 = paramString;
  }
  
  public String getAttribute5()
  {
    return this.attribute5;
  }
  
  public void setAttribute5(String paramString)
  {
    this.attribute5 = paramString;
  }
  
  public String getAttribute6()
  {
    return this.attribute6;
  }
  
  public void setAttribute6(String paramString)
  {
    this.attribute6 = paramString;
  }
  
  public String getAttribute7()
  {
    return this.attribute7;
  }
  
  public void setAttribute7(String paramString)
  {
    this.attribute7 = paramString;
  }
  
  public String getAttribute8()
  {
    return this.attribute8;
  }
  
  public void setAttribute8(String paramString)
  {
    this.attribute8 = paramString;
  }
  
  public String getAttribute9()
  {
    return this.attribute9;
  }
  
  public void setAttribute9(String paramString)
  {
    this.attribute9 = paramString;
  }
  
  public String getAttribute10()
  {
    return this.attribute10;
  }
  
  public void setAttribute10(String paramString)
  {
    this.attribute10 = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public Date getInactiveDate()
  {
    return this.inactiveDate;
  }
  
  public void setInactiveDate(Date paramDate)
  {
    this.inactiveDate = paramDate;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpBankAccounts)) {
      return false;
    }
    FbpBankAccounts localFbpBankAccounts = (FbpBankAccounts)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpBankAccounts.lastUpdateDate).append(this.lastUpdatedBy, localFbpBankAccounts.lastUpdatedBy).append(this.creationDate, localFbpBankAccounts.creationDate).append(this.createdBy, localFbpBankAccounts.createdBy).append(this.lastUpdateLogin, localFbpBankAccounts.lastUpdateLogin).append(this.bankAccountId, localFbpBankAccounts.bankAccountId).append(this.bankAccountNum, localFbpBankAccounts.bankAccountNum).append(this.bankAccountName, localFbpBankAccounts.bankAccountName).append(this.bankAccountNameAlt, localFbpBankAccounts.bankAccountNameAlt).append(this.bankName, localFbpBankAccounts.bankName).append(this.bankBranchName, localFbpBankAccounts.bankBranchName).append(this.bankAccountType, localFbpBankAccounts.bankAccountType).append(this.currencyCode, localFbpBankAccounts.currencyCode).append(this.country, localFbpBankAccounts.country).append(this.province, localFbpBankAccounts.province).append(this.city, localFbpBankAccounts.city).append(this.agencyLocationCode, localFbpBankAccounts.agencyLocationCode).append(this.sourceSystem, localFbpBankAccounts.sourceSystem).append(this.sourceBankAccountId, localFbpBankAccounts.sourceBankAccountId).append(this.orgId, localFbpBankAccounts.orgId).append(this.setOfBooksId, localFbpBankAccounts.setOfBooksId).append(this.attributeCategory, localFbpBankAccounts.attributeCategory).append(this.attribute1, localFbpBankAccounts.attribute1).append(this.attribute2, localFbpBankAccounts.attribute2).append(this.attribute3, localFbpBankAccounts.attribute3).append(this.attribute4, localFbpBankAccounts.attribute4).append(this.attribute5, localFbpBankAccounts.attribute5).append(this.attribute6, localFbpBankAccounts.attribute6).append(this.attribute7, localFbpBankAccounts.attribute7).append(this.attribute8, localFbpBankAccounts.attribute8).append(this.attribute9, localFbpBankAccounts.attribute9).append(this.attribute10, localFbpBankAccounts.attribute10).append(this.description, localFbpBankAccounts.description).append(this.inactiveDate, localFbpBankAccounts.inactiveDate).append(this.enabledFlag, localFbpBankAccounts.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.bankAccountId).append(this.bankAccountNum).append(this.bankAccountName).append(this.bankAccountNameAlt).append(this.bankName).append(this.bankBranchName).append(this.bankAccountType).append(this.currencyCode).append(this.country).append(this.province).append(this.city).append(this.agencyLocationCode).append(this.sourceSystem).append(this.sourceBankAccountId).append(this.orgId).append(this.setOfBooksId).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.description).append(this.inactiveDate).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("bankAccountId", this.bankAccountId).append("bankAccountNum", this.bankAccountNum).append("bankAccountName", this.bankAccountName).append("bankAccountNameAlt", this.bankAccountNameAlt).append("bankName", this.bankName).append("bankBranchName", this.bankBranchName).append("bankAccountType", this.bankAccountType).append("currencyCode", this.currencyCode).append("country", this.country).append("province", this.province).append("city", this.city).append("agencyLocationCode", this.agencyLocationCode).append("sourceSystem", this.sourceSystem).append("sourceBankAccountId", this.sourceBankAccountId).append("orgId", this.orgId).append("setOfBooksId", this.setOfBooksId).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("description", this.description).append("inactiveDate", this.inactiveDate).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "bankAccountId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpBankAccounts
 * JD-Core Version:    0.7.0.1
 */