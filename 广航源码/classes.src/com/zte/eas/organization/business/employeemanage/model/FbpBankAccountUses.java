package com.zte.eas.organization.business.employeemanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpBankAccountUses
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger accountUsesId;
  protected Long bankAccountId;
  protected String useType;
  protected Long vendorId;
  protected Long vendorSiteId;
  protected Long employeeId;
  protected Long customerId;
  protected Long customerSiteId;
  protected Date startDate;
  protected Date endDate;
  protected String primaryFlag;
  protected BigInteger orgId;
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
  protected Long erpAccountUsesId;
  protected String enabledFlag;
  
  public FbpBankAccountUses() {}
  
  public FbpBankAccountUses(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger1, Long paramLong4, String paramString1, Long paramLong5, Long paramLong6, Long paramLong7, Long paramLong8, Long paramLong9, Date paramDate3, Date paramDate4, String paramString2, BigInteger paramBigInteger2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, Long paramLong10, String paramString14)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setAccountUsesId(paramBigInteger1);
    setBankAccountId(paramLong4);
    setUseType(paramString1);
    setVendorId(paramLong5);
    setVendorSiteId(paramLong6);
    setEmployeeId(paramLong7);
    setCustomerId(paramLong8);
    setCustomerSiteId(paramLong9);
    setStartDate(paramDate3);
    setEndDate(paramDate4);
    setPrimaryFlag(paramString2);
    setOrgId(paramBigInteger2);
    setAttributeCategory(paramString3);
    setAttribute1(paramString4);
    setAttribute2(paramString5);
    setAttribute3(paramString6);
    setAttribute4(paramString7);
    setAttribute5(paramString8);
    setAttribute6(paramString9);
    setAttribute7(paramString10);
    setAttribute8(paramString11);
    setAttribute9(paramString12);
    setAttribute10(paramString13);
    setErpAccountUsesId(paramLong10);
    setEnabledFlag(paramString14);
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
  
  public BigInteger getAccountUsesId()
  {
    return this.accountUsesId;
  }
  
  public void setAccountUsesId(BigInteger paramBigInteger)
  {
    this.accountUsesId = paramBigInteger;
  }
  
  public Long getBankAccountId()
  {
    return this.bankAccountId;
  }
  
  public void setBankAccountId(Long paramLong)
  {
    this.bankAccountId = paramLong;
  }
  
  public String getUseType()
  {
    return this.useType;
  }
  
  public void setUseType(String paramString)
  {
    this.useType = paramString;
  }
  
  public Long getVendorId()
  {
    return this.vendorId;
  }
  
  public void setVendorId(Long paramLong)
  {
    this.vendorId = paramLong;
  }
  
  public Long getVendorSiteId()
  {
    return this.vendorSiteId;
  }
  
  public void setVendorSiteId(Long paramLong)
  {
    this.vendorSiteId = paramLong;
  }
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
  }
  
  public Long getCustomerId()
  {
    return this.customerId;
  }
  
  public void setCustomerId(Long paramLong)
  {
    this.customerId = paramLong;
  }
  
  public Long getCustomerSiteId()
  {
    return this.customerSiteId;
  }
  
  public void setCustomerSiteId(Long paramLong)
  {
    this.customerSiteId = paramLong;
  }
  
  public Date getStartDate()
  {
    return this.startDate;
  }
  
  public void setStartDate(Date paramDate)
  {
    this.startDate = paramDate;
  }
  
  public Date getEndDate()
  {
    return this.endDate;
  }
  
  public void setEndDate(Date paramDate)
  {
    this.endDate = paramDate;
  }
  
  public String getPrimaryFlag()
  {
    return this.primaryFlag;
  }
  
  public void setPrimaryFlag(String paramString)
  {
    this.primaryFlag = paramString;
  }
  
  public BigInteger getOrgId()
  {
    return this.orgId;
  }
  
  public void setOrgId(BigInteger paramBigInteger)
  {
    this.orgId = paramBigInteger;
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
  
  public Long getErpAccountUsesId()
  {
    return this.erpAccountUsesId;
  }
  
  public void setErpAccountUsesId(Long paramLong)
  {
    this.erpAccountUsesId = paramLong;
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
    if (!(paramObject instanceof FbpBankAccountUses)) {
      return false;
    }
    FbpBankAccountUses localFbpBankAccountUses = (FbpBankAccountUses)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpBankAccountUses.lastUpdateDate).append(this.lastUpdatedBy, localFbpBankAccountUses.lastUpdatedBy).append(this.creationDate, localFbpBankAccountUses.creationDate).append(this.createdBy, localFbpBankAccountUses.createdBy).append(this.lastUpdateLogin, localFbpBankAccountUses.lastUpdateLogin).append(this.accountUsesId, localFbpBankAccountUses.accountUsesId).append(this.bankAccountId, localFbpBankAccountUses.bankAccountId).append(this.useType, localFbpBankAccountUses.useType).append(this.vendorId, localFbpBankAccountUses.vendorId).append(this.vendorSiteId, localFbpBankAccountUses.vendorSiteId).append(this.employeeId, localFbpBankAccountUses.employeeId).append(this.customerId, localFbpBankAccountUses.customerId).append(this.customerSiteId, localFbpBankAccountUses.customerSiteId).append(this.startDate, localFbpBankAccountUses.startDate).append(this.endDate, localFbpBankAccountUses.endDate).append(this.primaryFlag, localFbpBankAccountUses.primaryFlag).append(this.orgId, localFbpBankAccountUses.orgId).append(this.attributeCategory, localFbpBankAccountUses.attributeCategory).append(this.attribute1, localFbpBankAccountUses.attribute1).append(this.attribute2, localFbpBankAccountUses.attribute2).append(this.attribute3, localFbpBankAccountUses.attribute3).append(this.attribute4, localFbpBankAccountUses.attribute4).append(this.attribute5, localFbpBankAccountUses.attribute5).append(this.attribute6, localFbpBankAccountUses.attribute6).append(this.attribute7, localFbpBankAccountUses.attribute7).append(this.attribute8, localFbpBankAccountUses.attribute8).append(this.attribute9, localFbpBankAccountUses.attribute9).append(this.attribute10, localFbpBankAccountUses.attribute10).append(this.erpAccountUsesId, localFbpBankAccountUses.erpAccountUsesId).append(this.enabledFlag, localFbpBankAccountUses.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.accountUsesId).append(this.bankAccountId).append(this.useType).append(this.vendorId).append(this.vendorSiteId).append(this.employeeId).append(this.customerId).append(this.customerSiteId).append(this.startDate).append(this.endDate).append(this.primaryFlag).append(this.orgId).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.erpAccountUsesId).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("accountUsesId", this.accountUsesId).append("bankAccountId", this.bankAccountId).append("useType", this.useType).append("vendorId", this.vendorId).append("vendorSiteId", this.vendorSiteId).append("employeeId", this.employeeId).append("customerId", this.customerId).append("customerSiteId", this.customerSiteId).append("startDate", this.startDate).append("endDate", this.endDate).append("primaryFlag", this.primaryFlag).append("orgId", this.orgId).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("erpAccountUsesId", this.erpAccountUsesId).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "accountUsesId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpBankAccountUses
 * JD-Core Version:    0.7.0.1
 */