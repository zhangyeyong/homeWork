package com.zte.eas.organization.business.organizationmanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpDeptsV
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
  protected String parentDeptName;
  protected String deptClass;
  protected String deptClassName;
  protected BigInteger orgId;
  protected String deptGuid;
  protected BigInteger costDeptId;
  protected String costDeptName;
  protected BigInteger leaderPositionId;
  protected String positionName;
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
  protected String hasSubDept;
  protected String parentEnabledFlag;
  protected String hasValidEmployee;
  
  public FbpDeptsV() {}
  
  public FbpDeptsV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger1, String paramString1, String paramString2, String paramString3, BigInteger paramBigInteger2, String paramString4, String paramString5, String paramString6, BigInteger paramBigInteger3, String paramString7, BigInteger paramBigInteger4, String paramString8, BigInteger paramBigInteger5, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26)
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
    setParentDeptName(paramString4);
    setDeptClass(paramString5);
    setDeptClassName(paramString6);
    setOrgId(paramBigInteger3);
    setDeptGuid(paramString7);
    setCostDeptId(paramBigInteger4);
    setCostDeptName(paramString8);
    setLeaderPositionId(paramBigInteger5);
    setPositionName(paramString9);
    setDefaultCheckUnit(paramString10);
    setSynchFlag(paramString11);
    setAttributeCategory(paramString12);
    setAttribute1(paramString13);
    setAttribute2(paramString14);
    setAttribute3(paramString15);
    setAttribute4(paramString16);
    setAttribute5(paramString17);
    setAttribute6(paramString18);
    setAttribute7(paramString19);
    setAttribute8(paramString20);
    setAttribute9(paramString21);
    setAttribute10(paramString22);
    setEnabledFlag(paramString23);
    setHasSubDept(paramString24);
    setParentEnabledFlag(paramString25);
    setHasValidEmployee(paramString26);
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
  
  public String getParentDeptName()
  {
    return this.parentDeptName;
  }
  
  public void setParentDeptName(String paramString)
  {
    this.parentDeptName = paramString;
  }
  
  public String getDeptClass()
  {
    return this.deptClass;
  }
  
  public void setDeptClass(String paramString)
  {
    this.deptClass = paramString;
  }
  
  public String getDeptClassName()
  {
    return this.deptClassName;
  }
  
  public void setDeptClassName(String paramString)
  {
    this.deptClassName = paramString;
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
  
  public String getCostDeptName()
  {
    return this.costDeptName;
  }
  
  public void setCostDeptName(String paramString)
  {
    this.costDeptName = paramString;
  }
  
  public BigInteger getLeaderPositionId()
  {
    return this.leaderPositionId;
  }
  
  public void setLeaderPositionId(BigInteger paramBigInteger)
  {
    this.leaderPositionId = paramBigInteger;
  }
  
  public String getPositionName()
  {
    return this.positionName;
  }
  
  public void setPositionName(String paramString)
  {
    this.positionName = paramString;
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
  
  public String getHasSubDept()
  {
    return this.hasSubDept;
  }
  
  public void setHasSubDept(String paramString)
  {
    this.hasSubDept = paramString;
  }
  
  public String getParentEnabledFlag()
  {
    return this.parentEnabledFlag;
  }
  
  public void setParentEnabledFlag(String paramString)
  {
    this.parentEnabledFlag = paramString;
  }
  
  public String getHasValidEmployee()
  {
    return this.hasValidEmployee;
  }
  
  public void setHasValidEmployee(String paramString)
  {
    this.hasValidEmployee = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpDeptsV)) {
      return false;
    }
    FbpDeptsV localFbpDeptsV = (FbpDeptsV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpDeptsV.lastUpdateDate).append(this.lastUpdatedBy, localFbpDeptsV.lastUpdatedBy).append(this.creationDate, localFbpDeptsV.creationDate).append(this.createdBy, localFbpDeptsV.createdBy).append(this.lastUpdateLogin, localFbpDeptsV.lastUpdateLogin).append(this.deptId, localFbpDeptsV.deptId).append(this.deptCode, localFbpDeptsV.deptCode).append(this.deptName, localFbpDeptsV.deptName).append(this.description, localFbpDeptsV.description).append(this.parentDeptId, localFbpDeptsV.parentDeptId).append(this.parentDeptName, localFbpDeptsV.parentDeptName).append(this.deptClass, localFbpDeptsV.deptClass).append(this.deptClassName, localFbpDeptsV.deptClassName).append(this.orgId, localFbpDeptsV.orgId).append(this.deptGuid, localFbpDeptsV.deptGuid).append(this.costDeptId, localFbpDeptsV.costDeptId).append(this.costDeptName, localFbpDeptsV.costDeptName).append(this.leaderPositionId, localFbpDeptsV.leaderPositionId).append(this.positionName, localFbpDeptsV.positionName).append(this.defaultCheckUnit, localFbpDeptsV.defaultCheckUnit).append(this.synchFlag, localFbpDeptsV.synchFlag).append(this.attributeCategory, localFbpDeptsV.attributeCategory).append(this.attribute1, localFbpDeptsV.attribute1).append(this.attribute2, localFbpDeptsV.attribute2).append(this.attribute3, localFbpDeptsV.attribute3).append(this.attribute4, localFbpDeptsV.attribute4).append(this.attribute5, localFbpDeptsV.attribute5).append(this.attribute6, localFbpDeptsV.attribute6).append(this.attribute7, localFbpDeptsV.attribute7).append(this.attribute8, localFbpDeptsV.attribute8).append(this.attribute9, localFbpDeptsV.attribute9).append(this.attribute10, localFbpDeptsV.attribute10).append(this.enabledFlag, localFbpDeptsV.enabledFlag).append(this.hasSubDept, localFbpDeptsV.hasSubDept).append(this.parentEnabledFlag, localFbpDeptsV.parentEnabledFlag).append(this.hasValidEmployee, localFbpDeptsV.hasValidEmployee).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.deptId).append(this.deptCode).append(this.deptName).append(this.description).append(this.parentDeptId).append(this.parentDeptName).append(this.deptClass).append(this.deptClassName).append(this.orgId).append(this.deptGuid).append(this.costDeptId).append(this.costDeptName).append(this.leaderPositionId).append(this.positionName).append(this.defaultCheckUnit).append(this.synchFlag).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).append(this.hasSubDept).append(this.parentEnabledFlag).append(this.hasValidEmployee).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("deptId", this.deptId).append("deptCode", this.deptCode).append("deptName", this.deptName).append("description", this.description).append("parentDeptId", this.parentDeptId).append("parentDeptName", this.parentDeptName).append("deptClass", this.deptClass).append("deptClassName", this.deptClassName).append("orgId", this.orgId).append("deptGuid", this.deptGuid).append("costDeptId", this.costDeptId).append("costDeptName", this.costDeptName).append("leaderPositionId", this.leaderPositionId).append("positionName", this.positionName).append("defaultCheckUnit", this.defaultCheckUnit).append("synchFlag", this.synchFlag).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).append("hasSubDept", this.hasSubDept).append("parentEnabledFlag", this.parentEnabledFlag).append("hasValidEmployee", this.hasValidEmployee).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.organizationmanage.model.FbpDeptsV
 * JD-Core Version:    0.7.0.1
 */