package com.zte.eas.organization.business.organizationmanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpDepts
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Date invalidDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger deptId;
  protected String deptCode;
  protected String orgBenchmarkCode;
  protected BigInteger parentDeptId;
  protected String deptClass;
  protected BigInteger orgId;
  protected String deptGuid;
  protected BigInteger costDeptId;
  protected BigInteger leaderPositionId;
  protected String defaultCheckUnit;
  protected String synchFlag;
  protected String orgAttribute;
  protected String orgManager;
  protected String orgPhone;
  protected String orgFax;
  protected String subCompname;
  protected String subCompcode;
  protected String costCentercode;
  protected String costCentername;
  protected String orgProvince;
  protected String orgCity;
  protected String orgCountry;
  protected String orgZipcode;
  protected String orgEmail;
  protected String orgAddress;
  protected Long iscareerDept;
  protected Long isbigArea;
  protected Long issmallArea;
  protected String areaCode;
  protected String canceledSystems;
  protected String ehrDeptcode;
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
  
  public FbpDepts() {}
  
  public FbpDepts(Date paramDate1, Long paramLong1, Date paramDate2, Date paramDate3, Long paramLong2, Long paramLong3, BigInteger paramBigInteger1, String paramString1, String paramString2, BigInteger paramBigInteger2, String paramString3, BigInteger paramBigInteger3, String paramString4, BigInteger paramBigInteger4, BigInteger paramBigInteger5, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, Long paramLong4, Long paramLong5, Long paramLong6, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setInvalidDate(paramDate3);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setDeptId(paramBigInteger1);
    setDeptCode(paramString1);
    setOrgBenchmarkCode(paramString2);
    setParentDeptId(paramBigInteger2);
    setDeptClass(paramString3);
    setOrgId(paramBigInteger3);
    setDeptGuid(paramString4);
    setCostDeptId(paramBigInteger4);
    setLeaderPositionId(paramBigInteger5);
    setDefaultCheckUnit(paramString5);
    setSynchFlag(paramString6);
    setOrgAttribute(paramString7);
    setOrgManager(paramString8);
    setOrgPhone(paramString9);
    setOrgFax(paramString10);
    setSubCompname(paramString11);
    setSubCompcode(paramString12);
    setCostCentercode(paramString13);
    setCostCentername(paramString14);
    setOrgProvince(paramString15);
    setOrgCity(paramString16);
    setOrgCountry(paramString17);
    setOrgZipcode(paramString18);
    setOrgEmail(paramString19);
    setOrgAddress(paramString20);
    setIscareerDept(paramLong4);
    setIsbigArea(paramLong5);
    setIssmallArea(paramLong6);
    setAreaCode(paramString21);
    setCanceledSystems(paramString22);
    setEhrDeptcode(paramString23);
    setAttributeCategory(paramString24);
    setAttribute1(paramString25);
    setAttribute2(paramString26);
    setAttribute3(paramString27);
    setAttribute4(paramString28);
    setAttribute5(paramString29);
    setAttribute6(paramString30);
    setAttribute7(paramString31);
    setAttribute8(paramString32);
    setAttribute9(paramString33);
    setAttribute10(paramString34);
    setEnabledFlag(paramString35);
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
  
  public Date getInvalidDate()
  {
    return this.invalidDate;
  }
  
  public void setInvalidDate(Date paramDate)
  {
    this.invalidDate = paramDate;
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
  
  public BigInteger getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(BigInteger paramBigInteger)
  {
    this.deptId = paramBigInteger;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public String getOrgBenchmarkCode()
  {
    return this.orgBenchmarkCode;
  }
  
  public void setOrgBenchmarkCode(String paramString)
  {
    this.orgBenchmarkCode = paramString;
  }
  
  public BigInteger getParentDeptId()
  {
    return this.parentDeptId;
  }
  
  public void setParentDeptId(BigInteger paramBigInteger)
  {
    this.parentDeptId = paramBigInteger;
  }
  
  public String getDeptClass()
  {
    return this.deptClass;
  }
  
  public void setDeptClass(String paramString)
  {
    this.deptClass = paramString;
  }
  
  public BigInteger getOrgId()
  {
    return this.orgId;
  }
  
  public void setOrgId(BigInteger paramBigInteger)
  {
    this.orgId = paramBigInteger;
  }
  
  public String getDeptGuid()
  {
    return this.deptGuid;
  }
  
  public void setDeptGuid(String paramString)
  {
    this.deptGuid = paramString;
  }
  
  public BigInteger getCostDeptId()
  {
    return this.costDeptId;
  }
  
  public void setCostDeptId(BigInteger paramBigInteger)
  {
    this.costDeptId = paramBigInteger;
  }
  
  public BigInteger getLeaderPositionId()
  {
    return this.leaderPositionId;
  }
  
  public void setLeaderPositionId(BigInteger paramBigInteger)
  {
    this.leaderPositionId = paramBigInteger;
  }
  
  public String getDefaultCheckUnit()
  {
    return this.defaultCheckUnit;
  }
  
  public void setDefaultCheckUnit(String paramString)
  {
    this.defaultCheckUnit = paramString;
  }
  
  public String getSynchFlag()
  {
    return this.synchFlag;
  }
  
  public void setSynchFlag(String paramString)
  {
    this.synchFlag = paramString;
  }
  
  public String getOrgAttribute()
  {
    return this.orgAttribute;
  }
  
  public void setOrgAttribute(String paramString)
  {
    this.orgAttribute = paramString;
  }
  
  public String getOrgManager()
  {
    return this.orgManager;
  }
  
  public void setOrgManager(String paramString)
  {
    this.orgManager = paramString;
  }
  
  public String getOrgPhone()
  {
    return this.orgPhone;
  }
  
  public void setOrgPhone(String paramString)
  {
    this.orgPhone = paramString;
  }
  
  public String getOrgFax()
  {
    return this.orgFax;
  }
  
  public void setOrgFax(String paramString)
  {
    this.orgFax = paramString;
  }
  
  public String getSubCompname()
  {
    return this.subCompname;
  }
  
  public void setSubCompname(String paramString)
  {
    this.subCompname = paramString;
  }
  
  public String getSubCompcode()
  {
    return this.subCompcode;
  }
  
  public void setSubCompcode(String paramString)
  {
    this.subCompcode = paramString;
  }
  
  public String getCostCentercode()
  {
    return this.costCentercode;
  }
  
  public void setCostCentercode(String paramString)
  {
    this.costCentercode = paramString;
  }
  
  public String getCostCentername()
  {
    return this.costCentername;
  }
  
  public void setCostCentername(String paramString)
  {
    this.costCentername = paramString;
  }
  
  public String getOrgProvince()
  {
    return this.orgProvince;
  }
  
  public void setOrgProvince(String paramString)
  {
    this.orgProvince = paramString;
  }
  
  public String getOrgCity()
  {
    return this.orgCity;
  }
  
  public void setOrgCity(String paramString)
  {
    this.orgCity = paramString;
  }
  
  public String getOrgCountry()
  {
    return this.orgCountry;
  }
  
  public void setOrgCountry(String paramString)
  {
    this.orgCountry = paramString;
  }
  
  public String getOrgZipcode()
  {
    return this.orgZipcode;
  }
  
  public void setOrgZipcode(String paramString)
  {
    this.orgZipcode = paramString;
  }
  
  public String getOrgEmail()
  {
    return this.orgEmail;
  }
  
  public void setOrgEmail(String paramString)
  {
    this.orgEmail = paramString;
  }
  
  public String getOrgAddress()
  {
    return this.orgAddress;
  }
  
  public void setOrgAddress(String paramString)
  {
    this.orgAddress = paramString;
  }
  
  public Long getIscareerDept()
  {
    return this.iscareerDept;
  }
  
  public void setIscareerDept(Long paramLong)
  {
    this.iscareerDept = paramLong;
  }
  
  public Long getIsbigArea()
  {
    return this.isbigArea;
  }
  
  public void setIsbigArea(Long paramLong)
  {
    this.isbigArea = paramLong;
  }
  
  public Long getIssmallArea()
  {
    return this.issmallArea;
  }
  
  public void setIssmallArea(Long paramLong)
  {
    this.issmallArea = paramLong;
  }
  
  public String getAreaCode()
  {
    return this.areaCode;
  }
  
  public void setAreaCode(String paramString)
  {
    this.areaCode = paramString;
  }
  
  public String getCanceledSystems()
  {
    return this.canceledSystems;
  }
  
  public void setCanceledSystems(String paramString)
  {
    this.canceledSystems = paramString;
  }
  
  public String getEhrDeptcode()
  {
    return this.ehrDeptcode;
  }
  
  public void setEhrDeptcode(String paramString)
  {
    this.ehrDeptcode = paramString;
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
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpDepts)) {
      return false;
    }
    FbpDepts localFbpDepts = (FbpDepts)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpDepts.lastUpdateDate).append(this.lastUpdatedBy, localFbpDepts.lastUpdatedBy).append(this.creationDate, localFbpDepts.creationDate).append(this.invalidDate, localFbpDepts.invalidDate).append(this.createdBy, localFbpDepts.createdBy).append(this.lastUpdateLogin, localFbpDepts.lastUpdateLogin).append(this.deptId, localFbpDepts.deptId).append(this.deptCode, localFbpDepts.deptCode).append(this.orgBenchmarkCode, localFbpDepts.orgBenchmarkCode).append(this.parentDeptId, localFbpDepts.parentDeptId).append(this.deptClass, localFbpDepts.deptClass).append(this.orgId, localFbpDepts.orgId).append(this.deptGuid, localFbpDepts.deptGuid).append(this.costDeptId, localFbpDepts.costDeptId).append(this.leaderPositionId, localFbpDepts.leaderPositionId).append(this.defaultCheckUnit, localFbpDepts.defaultCheckUnit).append(this.synchFlag, localFbpDepts.synchFlag).append(this.orgAttribute, localFbpDepts.orgAttribute).append(this.orgManager, localFbpDepts.orgManager).append(this.orgPhone, localFbpDepts.orgPhone).append(this.orgFax, localFbpDepts.orgFax).append(this.subCompname, localFbpDepts.subCompname).append(this.subCompcode, localFbpDepts.subCompcode).append(this.costCentercode, localFbpDepts.costCentercode).append(this.costCentername, localFbpDepts.costCentername).append(this.orgProvince, localFbpDepts.orgProvince).append(this.orgCity, localFbpDepts.orgCity).append(this.orgCountry, localFbpDepts.orgCountry).append(this.orgZipcode, localFbpDepts.orgZipcode).append(this.orgEmail, localFbpDepts.orgEmail).append(this.orgAddress, localFbpDepts.orgAddress).append(this.iscareerDept, localFbpDepts.iscareerDept).append(this.isbigArea, localFbpDepts.isbigArea).append(this.issmallArea, localFbpDepts.issmallArea).append(this.areaCode, localFbpDepts.areaCode).append(this.canceledSystems, localFbpDepts.canceledSystems).append(this.ehrDeptcode, localFbpDepts.ehrDeptcode).append(this.attributeCategory, localFbpDepts.attributeCategory).append(this.attribute1, localFbpDepts.attribute1).append(this.attribute2, localFbpDepts.attribute2).append(this.attribute3, localFbpDepts.attribute3).append(this.attribute4, localFbpDepts.attribute4).append(this.attribute5, localFbpDepts.attribute5).append(this.attribute6, localFbpDepts.attribute6).append(this.attribute7, localFbpDepts.attribute7).append(this.attribute8, localFbpDepts.attribute8).append(this.attribute9, localFbpDepts.attribute9).append(this.attribute10, localFbpDepts.attribute10).append(this.enabledFlag, localFbpDepts.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.invalidDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.deptId).append(this.deptCode).append(this.orgBenchmarkCode).append(this.parentDeptId).append(this.deptClass).append(this.orgId).append(this.deptGuid).append(this.costDeptId).append(this.leaderPositionId).append(this.defaultCheckUnit).append(this.synchFlag).append(this.orgAttribute).append(this.orgManager).append(this.orgPhone).append(this.orgFax).append(this.subCompname).append(this.subCompcode).append(this.costCentercode).append(this.costCentername).append(this.orgProvince).append(this.orgCity).append(this.orgCountry).append(this.orgZipcode).append(this.orgEmail).append(this.orgAddress).append(this.iscareerDept).append(this.isbigArea).append(this.issmallArea).append(this.areaCode).append(this.canceledSystems).append(this.ehrDeptcode).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("invalidDate", this.invalidDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("deptId", this.deptId).append("deptCode", this.deptCode).append("orgBenchmarkCode", this.orgBenchmarkCode).append("parentDeptId", this.parentDeptId).append("deptClass", this.deptClass).append("orgId", this.orgId).append("deptGuid", this.deptGuid).append("costDeptId", this.costDeptId).append("leaderPositionId", this.leaderPositionId).append("defaultCheckUnit", this.defaultCheckUnit).append("synchFlag", this.synchFlag).append("orgAttribute", this.orgAttribute).append("orgManager", this.orgManager).append("orgPhone", this.orgPhone).append("orgFax", this.orgFax).append("subCompname", this.subCompname).append("subCompcode", this.subCompcode).append("costCentercode", this.costCentercode).append("costCentername", this.costCentername).append("orgProvince", this.orgProvince).append("orgCity", this.orgCity).append("orgCountry", this.orgCountry).append("orgZipcode", this.orgZipcode).append("orgEmail", this.orgEmail).append("orgAddress", this.orgAddress).append("iscareerDept", this.iscareerDept).append("isbigArea", this.isbigArea).append("issmallArea", this.issmallArea).append("areaCode", this.areaCode).append("canceledSystems", this.canceledSystems).append("ehrDeptcode", this.ehrDeptcode).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "deptId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.organizationmanage.model.FbpDepts
 * JD-Core Version:    0.7.0.1
 */