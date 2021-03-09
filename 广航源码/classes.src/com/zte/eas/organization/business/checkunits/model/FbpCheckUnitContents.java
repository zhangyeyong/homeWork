package com.zte.eas.organization.business.checkunits.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpCheckUnitContents
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
  protected String enabledFlag;
  protected String memo;
  
  public FbpCheckUnitContents() {}
  
  public FbpCheckUnitContents(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, String paramString1, String paramString2, Long paramLong5, String paramString3, String paramString4, String paramString5, String paramString6, Long paramLong6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20)
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
    setAttributeCategory(paramString8);
    setAttribute1(paramString9);
    setAttribute2(paramString10);
    setAttribute3(paramString11);
    setAttribute4(paramString12);
    setAttribute5(paramString13);
    setAttribute6(paramString14);
    setAttribute7(paramString15);
    setAttribute8(paramString16);
    setAttribute9(paramString17);
    setAttribute10(paramString18);
    setEnabledFlag(paramString19);
    setMemo(paramString20);
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
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpCheckUnitContents)) {
      return false;
    }
    FbpCheckUnitContents localFbpCheckUnitContents = (FbpCheckUnitContents)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpCheckUnitContents.lastUpdateDate).append(this.lastUpdatedBy, localFbpCheckUnitContents.lastUpdatedBy).append(this.creationDate, localFbpCheckUnitContents.creationDate).append(this.createdBy, localFbpCheckUnitContents.createdBy).append(this.lastUpdateLogin, localFbpCheckUnitContents.lastUpdateLogin).append(this.contentId, localFbpCheckUnitContents.contentId).append(this.checkUnit, localFbpCheckUnitContents.checkUnit).append(this.checkUnitName, localFbpCheckUnitContents.checkUnitName).append(this.orgId, localFbpCheckUnitContents.orgId).append(this.territoryCode, localFbpCheckUnitContents.territoryCode).append(this.currencyCode, localFbpCheckUnitContents.currencyCode).append(this.parentCheckUnit, localFbpCheckUnitContents.parentCheckUnit).append(this.coCode, localFbpCheckUnitContents.coCode).append(this.erpOrgId, localFbpCheckUnitContents.erpOrgId).append(this.erpOrgName, localFbpCheckUnitContents.erpOrgName).append(this.attributeCategory, localFbpCheckUnitContents.attributeCategory).append(this.attribute1, localFbpCheckUnitContents.attribute1).append(this.attribute2, localFbpCheckUnitContents.attribute2).append(this.attribute3, localFbpCheckUnitContents.attribute3).append(this.attribute4, localFbpCheckUnitContents.attribute4).append(this.attribute5, localFbpCheckUnitContents.attribute5).append(this.attribute6, localFbpCheckUnitContents.attribute6).append(this.attribute7, localFbpCheckUnitContents.attribute7).append(this.attribute8, localFbpCheckUnitContents.attribute8).append(this.attribute9, localFbpCheckUnitContents.attribute9).append(this.attribute10, localFbpCheckUnitContents.attribute10).append(this.enabledFlag, localFbpCheckUnitContents.enabledFlag).append(this.memo, localFbpCheckUnitContents.memo).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.contentId).append(this.checkUnit).append(this.checkUnitName).append(this.orgId).append(this.territoryCode).append(this.currencyCode).append(this.parentCheckUnit).append(this.coCode).append(this.erpOrgId).append(this.erpOrgName).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).append(this.memo).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("contentId", this.contentId).append("checkUnit", this.checkUnit).append("checkUnitName", this.checkUnitName).append("orgId", this.orgId).append("territoryCode", this.territoryCode).append("currencyCode", this.currencyCode).append("parentCheckUnit", this.parentCheckUnit).append("coCode", this.coCode).append("erpOrgId", this.erpOrgId).append("erpOrgName", this.erpOrgName).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).append("memo", this.memo).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "contentId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContents
 * JD-Core Version:    0.7.0.1
 */