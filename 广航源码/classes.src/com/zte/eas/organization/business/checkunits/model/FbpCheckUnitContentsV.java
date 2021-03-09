package com.zte.eas.organization.business.checkunits.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpCheckUnitContentsV
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected Long contentId;
  protected String checkUnit;
  protected String checkUnitName;
  protected Long orgId;
  protected String territoryCode;
  protected String currencyCode;
  protected String parentCheckUnit;
  protected String coCode;
  protected Long erpOrgId;
  protected String erpOrgName;
  protected String enabledFlag;
  protected String deptName;
  protected String setOfBooksName;
  protected Long setOfBooksId;
  protected String companyCode;
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
  
  public FbpCheckUnitContentsV() {}
  
  public FbpCheckUnitContentsV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, String paramString1, String paramString2, Long paramLong5, String paramString3, String paramString4, String paramString5, String paramString6, Long paramLong6, String paramString7, String paramString8, String paramString9, String paramString10, Long paramLong7, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setContentId(paramLong4);
    setCheckUnit(paramString1);
    setCheckUnitName(paramString2);
    setOrgId(paramLong5);
    setTerritoryCode(paramString3);
    setCurrencyCode(paramString4);
    setParentCheckUnit(paramString5);
    setCoCode(paramString6);
    setErpOrgId(paramLong6);
    setErpOrgName(paramString7);
    setEnabledFlag(paramString8);
    setDeptName(paramString9);
    setSetOfBooksName(paramString10);
    setSetOfBooksId(paramLong7);
    setCompanyCode(paramString11);
    setAttribute1(paramString12);
    setAttribute2(paramString13);
    setAttribute3(paramString14);
    setAttribute4(paramString15);
    setAttribute5(paramString16);
    setAttribute6(paramString17);
    setAttribute7(paramString18);
    setAttribute8(paramString19);
    setAttribute9(paramString20);
    setAttribute10(paramString21);
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
  
  public Long getContentId()
  {
    return this.contentId;
  }
  
  public void setContentId(Long paramLong)
  {
    this.contentId = paramLong;
  }
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
  
  public String getCheckUnitName()
  {
    return this.checkUnitName;
  }
  
  public void setCheckUnitName(String paramString)
  {
    this.checkUnitName = paramString;
  }
  
  public Long getOrgId()
  {
    return this.orgId;
  }
  
  public void setOrgId(Long paramLong)
  {
    this.orgId = paramLong;
  }
  
  public String getTerritoryCode()
  {
    return this.territoryCode;
  }
  
  public void setTerritoryCode(String paramString)
  {
    this.territoryCode = paramString;
  }
  
  public String getCurrencyCode()
  {
    return this.currencyCode;
  }
  
  public void setCurrencyCode(String paramString)
  {
    this.currencyCode = paramString;
  }
  
  public String getParentCheckUnit()
  {
    return this.parentCheckUnit;
  }
  
  public void setParentCheckUnit(String paramString)
  {
    this.parentCheckUnit = paramString;
  }
  
  public String getCoCode()
  {
    return this.coCode;
  }
  
  public void setCoCode(String paramString)
  {
    this.coCode = paramString;
  }
  
  public Long getErpOrgId()
  {
    return this.erpOrgId;
  }
  
  public void setErpOrgId(Long paramLong)
  {
    this.erpOrgId = paramLong;
  }
  
  public String getErpOrgName()
  {
    return this.erpOrgName;
  }
  
  public void setErpOrgName(String paramString)
  {
    this.erpOrgName = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
  }
  
  public String getSetOfBooksName()
  {
    return this.setOfBooksName;
  }
  
  public void setSetOfBooksName(String paramString)
  {
    this.setOfBooksName = paramString;
  }
  
  public Long getSetOfBooksId()
  {
    return this.setOfBooksId;
  }
  
  public void setSetOfBooksId(Long paramLong)
  {
    this.setOfBooksId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
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
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpCheckUnitContentsV)) {
      return false;
    }
    FbpCheckUnitContentsV localFbpCheckUnitContentsV = (FbpCheckUnitContentsV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpCheckUnitContentsV.lastUpdateDate).append(this.lastUpdatedBy, localFbpCheckUnitContentsV.lastUpdatedBy).append(this.creationDate, localFbpCheckUnitContentsV.creationDate).append(this.createdBy, localFbpCheckUnitContentsV.createdBy).append(this.lastUpdateLogin, localFbpCheckUnitContentsV.lastUpdateLogin).append(this.contentId, localFbpCheckUnitContentsV.contentId).append(this.checkUnit, localFbpCheckUnitContentsV.checkUnit).append(this.checkUnitName, localFbpCheckUnitContentsV.checkUnitName).append(this.orgId, localFbpCheckUnitContentsV.orgId).append(this.territoryCode, localFbpCheckUnitContentsV.territoryCode).append(this.currencyCode, localFbpCheckUnitContentsV.currencyCode).append(this.parentCheckUnit, localFbpCheckUnitContentsV.parentCheckUnit).append(this.coCode, localFbpCheckUnitContentsV.coCode).append(this.erpOrgId, localFbpCheckUnitContentsV.erpOrgId).append(this.erpOrgName, localFbpCheckUnitContentsV.erpOrgName).append(this.enabledFlag, localFbpCheckUnitContentsV.enabledFlag).append(this.deptName, localFbpCheckUnitContentsV.deptName).append(this.setOfBooksName, localFbpCheckUnitContentsV.setOfBooksName).append(this.setOfBooksId, localFbpCheckUnitContentsV.setOfBooksId).append(this.companyCode, localFbpCheckUnitContentsV.companyCode).append(this.attribute1, localFbpCheckUnitContentsV.attribute1).append(this.attribute2, localFbpCheckUnitContentsV.attribute2).append(this.attribute3, localFbpCheckUnitContentsV.attribute3).append(this.attribute4, localFbpCheckUnitContentsV.attribute4).append(this.attribute5, localFbpCheckUnitContentsV.attribute5).append(this.attribute6, localFbpCheckUnitContentsV.attribute6).append(this.attribute7, localFbpCheckUnitContentsV.attribute7).append(this.attribute8, localFbpCheckUnitContentsV.attribute8).append(this.attribute9, localFbpCheckUnitContentsV.attribute9).append(this.attribute10, localFbpCheckUnitContentsV.attribute10).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.contentId).append(this.checkUnit).append(this.checkUnitName).append(this.orgId).append(this.territoryCode).append(this.currencyCode).append(this.parentCheckUnit).append(this.coCode).append(this.erpOrgId).append(this.erpOrgName).append(this.enabledFlag).append(this.deptName).append(this.setOfBooksName).append(this.setOfBooksId).append(this.companyCode).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("contentId", this.contentId).append("checkUnit", this.checkUnit).append("checkUnitName", this.checkUnitName).append("orgId", this.orgId).append("territoryCode", this.territoryCode).append("currencyCode", this.currencyCode).append("parentCheckUnit", this.parentCheckUnit).append("coCode", this.coCode).append("erpOrgId", this.erpOrgId).append("erpOrgName", this.erpOrgName).append("enabledFlag", this.enabledFlag).append("deptName", this.deptName).append("setOfBooksName", this.setOfBooksName).append("setOfBooksId", this.setOfBooksId).append("companyCode", this.companyCode).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContentsV
 * JD-Core Version:    0.7.0.1
 */