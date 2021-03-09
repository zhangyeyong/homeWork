package com.zte.eas.organization.business.employeemanage.model;

import com.zte.ssb.exportExcel.tableModel.selectModel;
import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpEmployeeBankAccountsV
  extends BaseObject
  implements Serializable
{
  private selectModel CNYSelect;
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger accountUsesId;
  protected Long employeeId;
  protected Date startDate;
  protected Date endDate;
  protected String primaryFlag;
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
  
  public FbpEmployeeBankAccountsV() {}
  
  public FbpEmployeeBankAccountsV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger1, Long paramLong4, Date paramDate3, Date paramDate4, String paramString1, BigInteger paramBigInteger2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setAccountUsesId(paramBigInteger1);
    setEmployeeId(paramLong4);
    setStartDate(paramDate3);
    setEndDate(paramDate4);
    setPrimaryFlag(paramString1);
    setBankAccountId(paramBigInteger2);
    setBankAccountNum(paramString2);
    setBankAccountName(paramString3);
    setBankAccountNameAlt(paramString4);
    setBankName(paramString5);
    setBankBranchName(paramString6);
    setBankAccountType(paramString7);
    setCurrencyCode(paramString8);
    setCountry(paramString9);
    setProvince(paramString10);
    setCity(paramString11);
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
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
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
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpEmployeeBankAccountsV)) {
      return false;
    }
    FbpEmployeeBankAccountsV localFbpEmployeeBankAccountsV = (FbpEmployeeBankAccountsV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpEmployeeBankAccountsV.lastUpdateDate).append(this.lastUpdatedBy, localFbpEmployeeBankAccountsV.lastUpdatedBy).append(this.creationDate, localFbpEmployeeBankAccountsV.creationDate).append(this.createdBy, localFbpEmployeeBankAccountsV.createdBy).append(this.lastUpdateLogin, localFbpEmployeeBankAccountsV.lastUpdateLogin).append(this.accountUsesId, localFbpEmployeeBankAccountsV.accountUsesId).append(this.employeeId, localFbpEmployeeBankAccountsV.employeeId).append(this.startDate, localFbpEmployeeBankAccountsV.startDate).append(this.endDate, localFbpEmployeeBankAccountsV.endDate).append(this.primaryFlag, localFbpEmployeeBankAccountsV.primaryFlag).append(this.bankAccountId, localFbpEmployeeBankAccountsV.bankAccountId).append(this.bankAccountNum, localFbpEmployeeBankAccountsV.bankAccountNum).append(this.bankAccountName, localFbpEmployeeBankAccountsV.bankAccountName).append(this.bankAccountNameAlt, localFbpEmployeeBankAccountsV.bankAccountNameAlt).append(this.bankName, localFbpEmployeeBankAccountsV.bankName).append(this.bankBranchName, localFbpEmployeeBankAccountsV.bankBranchName).append(this.bankAccountType, localFbpEmployeeBankAccountsV.bankAccountType).append(this.currencyCode, localFbpEmployeeBankAccountsV.currencyCode).append(this.country, localFbpEmployeeBankAccountsV.country).append(this.province, localFbpEmployeeBankAccountsV.province).append(this.city, localFbpEmployeeBankAccountsV.city).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.accountUsesId).append(this.employeeId).append(this.startDate).append(this.endDate).append(this.primaryFlag).append(this.bankAccountId).append(this.bankAccountNum).append(this.bankAccountName).append(this.bankAccountNameAlt).append(this.bankName).append(this.bankBranchName).append(this.bankAccountType).append(this.currencyCode).append(this.country).append(this.province).append(this.city).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("accountUsesId", this.accountUsesId).append("employeeId", this.employeeId).append("startDate", this.startDate).append("endDate", this.endDate).append("primaryFlag", this.primaryFlag).append("bankAccountId", this.bankAccountId).append("bankAccountNum", this.bankAccountNum).append("bankAccountName", this.bankAccountName).append("bankAccountNameAlt", this.bankAccountNameAlt).append("bankName", this.bankName).append("bankBranchName", this.bankBranchName).append("bankAccountType", this.bankAccountType).append("currencyCode", this.currencyCode).append("country", this.country).append("province", this.province).append("city", this.city).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public selectModel getCNYSelect()
  {
    return this.CNYSelect;
  }
  
  public void setCNYSelect(selectModel paramselectModel)
  {
    this.CNYSelect = paramselectModel;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpEmployeeBankAccountsV
 * JD-Core Version:    0.7.0.1
 */