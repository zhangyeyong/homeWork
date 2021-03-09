package com.zte.eas.organization.business.organizationmanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpDeptsVl
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger deptId;
  protected String deptCode;
  protected String deptName;
  protected String description;
  protected BigInteger parentDeptId;
  protected String deptClass;
  protected BigInteger orgId;
  protected String deptGuid;
  protected BigInteger costDeptId;
  protected BigInteger leaderPositionId;
  protected String defaultCheckUnit;
  protected String synchFlag;
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
  protected BigInteger childrendeptcount;
  protected String parentdeptenableflag;
  
  public BigInteger getChildrendeptcount()
  {
    return this.childrendeptcount;
  }
  
  public void setChildrendeptcount(BigInteger paramBigInteger)
  {
    this.childrendeptcount = paramBigInteger;
  }
  
  public String getParentdeptenableflag()
  {
    return this.parentdeptenableflag;
  }
  
  public void setParentdeptenableflag(String paramString)
  {
    this.parentdeptenableflag = paramString;
  }
  
  public FbpDeptsVl() {}
  
  public FbpDeptsVl(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger1, String paramString1, String paramString2, String paramString3, BigInteger paramBigInteger2, String paramString4, BigInteger paramBigInteger3, String paramString5, BigInteger paramBigInteger4, BigInteger paramBigInteger5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, BigInteger paramBigInteger6, String paramString20)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setDeptId(paramBigInteger1);
    setDeptCode(paramString1);
    setDeptName(paramString2);
    setDescription(paramString3);
    setParentDeptId(paramBigInteger2);
    setDeptClass(paramString4);
    setOrgId(paramBigInteger3);
    setDeptGuid(paramString5);
    setCostDeptId(paramBigInteger4);
    setLeaderPositionId(paramBigInteger5);
    setDefaultCheckUnit(paramString6);
    setSynchFlag(paramString7);
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
    setChildrendeptcount(paramBigInteger6);
    setParentdeptenableflag(paramString20);
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
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
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
    if (!(paramObject instanceof FbpDeptsVl)) {
      return false;
    }
    FbpDeptsVl localFbpDeptsVl = (FbpDeptsVl)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpDeptsVl.lastUpdateDate).append(this.lastUpdatedBy, localFbpDeptsVl.lastUpdatedBy).append(this.creationDate, localFbpDeptsVl.creationDate).append(this.createdBy, localFbpDeptsVl.createdBy).append(this.lastUpdateLogin, localFbpDeptsVl.lastUpdateLogin).append(this.deptId, localFbpDeptsVl.deptId).append(this.deptCode, localFbpDeptsVl.deptCode).append(this.deptName, localFbpDeptsVl.deptName).append(this.description, localFbpDeptsVl.description).append(this.parentDeptId, localFbpDeptsVl.parentDeptId).append(this.deptClass, localFbpDeptsVl.deptClass).append(this.orgId, localFbpDeptsVl.orgId).append(this.deptGuid, localFbpDeptsVl.deptGuid).append(this.costDeptId, localFbpDeptsVl.costDeptId).append(this.leaderPositionId, localFbpDeptsVl.leaderPositionId).append(this.defaultCheckUnit, localFbpDeptsVl.defaultCheckUnit).append(this.synchFlag, localFbpDeptsVl.synchFlag).append(this.attributeCategory, localFbpDeptsVl.attributeCategory).append(this.attribute1, localFbpDeptsVl.attribute1).append(this.attribute2, localFbpDeptsVl.attribute2).append(this.attribute3, localFbpDeptsVl.attribute3).append(this.attribute4, localFbpDeptsVl.attribute4).append(this.attribute5, localFbpDeptsVl.attribute5).append(this.attribute6, localFbpDeptsVl.attribute6).append(this.attribute7, localFbpDeptsVl.attribute7).append(this.attribute8, localFbpDeptsVl.attribute8).append(this.attribute9, localFbpDeptsVl.attribute9).append(this.attribute10, localFbpDeptsVl.attribute10).append(this.enabledFlag, localFbpDeptsVl.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.deptId).append(this.deptCode).append(this.deptName).append(this.description).append(this.parentDeptId).append(this.deptClass).append(this.orgId).append(this.deptGuid).append(this.costDeptId).append(this.leaderPositionId).append(this.defaultCheckUnit).append(this.synchFlag).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("deptId", this.deptId).append("deptCode", this.deptCode).append("deptName", this.deptName).append("description", this.description).append("parentDeptId", this.parentDeptId).append("deptClass", this.deptClass).append("orgId", this.orgId).append("deptGuid", this.deptGuid).append("costDeptId", this.costDeptId).append("leaderPositionId", this.leaderPositionId).append("defaultCheckUnit", this.defaultCheckUnit).append("synchFlag", this.synchFlag).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.organizationmanage.model.FbpDeptsVl
 * JD-Core Version:    0.7.0.1
 */