package com.zte.eas.organization.business.employeemanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpEmployeesV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected String deptCode;
  protected String coCode;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Long erpOrgId;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger employeeId;
  protected String employeeNumber;
  protected String employeeName;
  protected BigInteger deptId;
  protected String deptName;
  protected String deptLongName;
  protected Long jobId;
  protected String jobName;
  protected String checkUnit;
  protected String checkUnitName;
  protected BigInteger prodProjectId;
  protected Long costDeptId;
  protected String costDeptName;
  protected BigInteger currentCredit;
  protected String gradeName;
  protected String password;
  protected String positionLevel;
  protected String positionName;
  protected String employeeType;
  protected String sourceSystem;
  protected String shortName;
  protected String exchangePersonFlag;
  protected String employeeGuid;
  protected String synchFlag;
  protected String isSynchRequired;
  protected String useOaFlag;
  protected String useEmailFlag;
  protected String useSmsFlag;
  protected String rejectSmsFlag;
  protected String monNoticeFlag;
  protected String tueNoticeFlag;
  protected String wedNoticeFlag;
  protected String thuNoticeFlag;
  protected String friNoticeFlag;
  protected String satNoticeFlag;
  protected String sunNoticeFlag;
  protected BigInteger startHour;
  protected BigInteger startMin;
  protected BigInteger endHour;
  protected BigInteger endMin;
  protected String oaAddress;
  protected String phone;
  protected String mobilePhone;
  protected String emailAddress;
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
  protected String enabledFlagMeaning;
  protected Long companyId;
  protected String companyCode;
  
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
  
  public FbpEmployeesV() {}
  
  public FbpEmployeesV(Date paramDate1, Long paramLong1, Long paramLong2, String paramString1, String paramString2, Date paramDate2, Long paramLong3, Long paramLong4, BigInteger paramBigInteger1, String paramString3, String paramString4, BigInteger paramBigInteger2, String paramString5, String paramString6, Long paramLong5, String paramString7, String paramString8, String paramString9, BigInteger paramBigInteger3, Long paramLong6, String paramString10, BigInteger paramBigInteger4, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32, BigInteger paramBigInteger5, BigInteger paramBigInteger6, BigInteger paramBigInteger7, BigInteger paramBigInteger8, String paramString33, String paramString34, String paramString35, String paramString36, String paramString37, String paramString38, String paramString39, String paramString40, String paramString41, String paramString42, String paramString43, String paramString44, String paramString45, String paramString46, String paramString47, String paramString48)
  {
    setLastUpdateDate(paramDate1);
    setDeptCode(paramString1);
    setCoCode(paramString2);
    setLastUpdatedBy(paramLong1);
    setErpOrgId(paramLong2);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong3);
    setLastUpdateLogin(paramLong4);
    setEmployeeId(paramBigInteger1);
    setEmployeeNumber(paramString3);
    setEmployeeName(paramString4);
    setDeptId(paramBigInteger2);
    setDeptName(paramString5);
    setDeptLongName(paramString6);
    setJobId(paramLong5);
    setJobName(paramString7);
    setCheckUnit(paramString8);
    setCheckUnitName(paramString9);
    setProdProjectId(paramBigInteger3);
    setCostDeptId(paramLong6);
    setCostDeptName(paramString10);
    setCurrentCredit(paramBigInteger4);
    setGradeName(paramString11);
    setPassword(paramString12);
    setPositionLevel(paramString13);
    setPositionName(paramString14);
    setEmployeeType(paramString15);
    setSourceSystem(paramString16);
    setShortName(paramString17);
    setExchangePersonFlag(paramString18);
    setEmployeeGuid(paramString19);
    setSynchFlag(paramString20);
    setIsSynchRequired(paramString21);
    setUseOaFlag(paramString22);
    setUseEmailFlag(paramString23);
    setUseSmsFlag(paramString24);
    setRejectSmsFlag(paramString25);
    setMonNoticeFlag(paramString26);
    setTueNoticeFlag(paramString27);
    setWedNoticeFlag(paramString28);
    setThuNoticeFlag(paramString29);
    setFriNoticeFlag(paramString30);
    setSatNoticeFlag(paramString31);
    setSunNoticeFlag(paramString32);
    setStartHour(paramBigInteger5);
    setStartMin(paramBigInteger6);
    setEndHour(paramBigInteger7);
    setEndMin(paramBigInteger8);
    setOaAddress(paramString33);
    setPhone(paramString34);
    setMobilePhone(paramString35);
    setEmailAddress(paramString36);
    setAttributeCategory(paramString37);
    setAttribute1(paramString38);
    setAttribute2(paramString39);
    setAttribute3(paramString40);
    setAttribute4(paramString41);
    setAttribute5(paramString42);
    setAttribute6(paramString43);
    setAttribute7(paramString44);
    setAttribute8(paramString45);
    setAttribute9(paramString46);
    setAttribute10(paramString47);
    setEnabledFlag(paramString48);
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
  
  public BigInteger getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(BigInteger paramBigInteger)
  {
    this.employeeId = paramBigInteger;
  }
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public BigInteger getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(BigInteger paramBigInteger)
  {
    this.deptId = paramBigInteger;
  }
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
  }
  
  public String getDeptLongName()
  {
    return this.deptLongName;
  }
  
  public void setDeptLongName(String paramString)
  {
    this.deptLongName = paramString;
  }
  
  public Long getJobId()
  {
    return this.jobId;
  }
  
  public void setJobId(Long paramLong)
  {
    this.jobId = paramLong;
  }
  
  public String getJobName()
  {
    return this.jobName;
  }
  
  public void setJobName(String paramString)
  {
    this.jobName = paramString;
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
  
  public BigInteger getProdProjectId()
  {
    return this.prodProjectId;
  }
  
  public void setProdProjectId(BigInteger paramBigInteger)
  {
    this.prodProjectId = paramBigInteger;
  }
  
  public Long getCostDeptId()
  {
    return this.costDeptId;
  }
  
  public void setCostDeptId(Long paramLong)
  {
    this.costDeptId = paramLong;
  }
  
  public String getCostDeptName()
  {
    return this.costDeptName;
  }
  
  public void setCostDeptName(String paramString)
  {
    this.costDeptName = paramString;
  }
  
  public BigInteger getCurrentCredit()
  {
    return this.currentCredit;
  }
  
  public void setCurrentCredit(BigInteger paramBigInteger)
  {
    this.currentCredit = paramBigInteger;
  }
  
  public String getGradeName()
  {
    return this.gradeName;
  }
  
  public void setGradeName(String paramString)
  {
    this.gradeName = paramString;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public String getPositionLevel()
  {
    return this.positionLevel;
  }
  
  public void setPositionLevel(String paramString)
  {
    this.positionLevel = paramString;
  }
  
  public String getPositionName()
  {
    return this.positionName;
  }
  
  public void setPositionName(String paramString)
  {
    this.positionName = paramString;
  }
  
  public String getEmployeeType()
  {
    return this.employeeType;
  }
  
  public void setEmployeeType(String paramString)
  {
    this.employeeType = paramString;
  }
  
  public String getSourceSystem()
  {
    return this.sourceSystem;
  }
  
  public void setSourceSystem(String paramString)
  {
    this.sourceSystem = paramString;
  }
  
  public String getShortName()
  {
    return this.shortName;
  }
  
  public void setShortName(String paramString)
  {
    this.shortName = paramString;
  }
  
  public String getExchangePersonFlag()
  {
    return this.exchangePersonFlag;
  }
  
  public void setExchangePersonFlag(String paramString)
  {
    this.exchangePersonFlag = paramString;
  }
  
  public String getEmployeeGuid()
  {
    return this.employeeGuid;
  }
  
  public void setEmployeeGuid(String paramString)
  {
    this.employeeGuid = paramString;
  }
  
  public String getSynchFlag()
  {
    return this.synchFlag;
  }
  
  public void setSynchFlag(String paramString)
  {
    this.synchFlag = paramString;
  }
  
  public String getUseOaFlag()
  {
    return this.useOaFlag;
  }
  
  public void setUseOaFlag(String paramString)
  {
    this.useOaFlag = paramString;
  }
  
  public String getUseEmailFlag()
  {
    return this.useEmailFlag;
  }
  
  public void setUseEmailFlag(String paramString)
  {
    this.useEmailFlag = paramString;
  }
  
  public String getUseSmsFlag()
  {
    return this.useSmsFlag;
  }
  
  public void setUseSmsFlag(String paramString)
  {
    this.useSmsFlag = paramString;
  }
  
  public String getRejectSmsFlag()
  {
    return this.rejectSmsFlag;
  }
  
  public void setRejectSmsFlag(String paramString)
  {
    this.rejectSmsFlag = paramString;
  }
  
  public String getMonNoticeFlag()
  {
    return this.monNoticeFlag;
  }
  
  public void setMonNoticeFlag(String paramString)
  {
    this.monNoticeFlag = paramString;
  }
  
  public String getTueNoticeFlag()
  {
    return this.tueNoticeFlag;
  }
  
  public void setTueNoticeFlag(String paramString)
  {
    this.tueNoticeFlag = paramString;
  }
  
  public String getWedNoticeFlag()
  {
    return this.wedNoticeFlag;
  }
  
  public void setWedNoticeFlag(String paramString)
  {
    this.wedNoticeFlag = paramString;
  }
  
  public String getThuNoticeFlag()
  {
    return this.thuNoticeFlag;
  }
  
  public void setThuNoticeFlag(String paramString)
  {
    this.thuNoticeFlag = paramString;
  }
  
  public String getFriNoticeFlag()
  {
    return this.friNoticeFlag;
  }
  
  public void setFriNoticeFlag(String paramString)
  {
    this.friNoticeFlag = paramString;
  }
  
  public String getSatNoticeFlag()
  {
    return this.satNoticeFlag;
  }
  
  public void setSatNoticeFlag(String paramString)
  {
    this.satNoticeFlag = paramString;
  }
  
  public String getSunNoticeFlag()
  {
    return this.sunNoticeFlag;
  }
  
  public void setSunNoticeFlag(String paramString)
  {
    this.sunNoticeFlag = paramString;
  }
  
  public BigInteger getStartHour()
  {
    return this.startHour;
  }
  
  public void setStartHour(BigInteger paramBigInteger)
  {
    this.startHour = paramBigInteger;
  }
  
  public BigInteger getStartMin()
  {
    return this.startMin;
  }
  
  public void setStartMin(BigInteger paramBigInteger)
  {
    this.startMin = paramBigInteger;
  }
  
  public BigInteger getEndHour()
  {
    return this.endHour;
  }
  
  public void setEndHour(BigInteger paramBigInteger)
  {
    this.endHour = paramBigInteger;
  }
  
  public BigInteger getEndMin()
  {
    return this.endMin;
  }
  
  public void setEndMin(BigInteger paramBigInteger)
  {
    this.endMin = paramBigInteger;
  }
  
  public String getOaAddress()
  {
    return this.oaAddress;
  }
  
  public void setOaAddress(String paramString)
  {
    this.oaAddress = paramString;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public String getMobilePhone()
  {
    return this.mobilePhone;
  }
  
  public void setMobilePhone(String paramString)
  {
    this.mobilePhone = paramString;
  }
  
  public String getEmailAddress()
  {
    return this.emailAddress;
  }
  
  public void setEmailAddress(String paramString)
  {
    this.emailAddress = paramString;
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
    if (!(paramObject instanceof FbpEmployeesV)) {
      return false;
    }
    FbpEmployeesV localFbpEmployeesV = (FbpEmployeesV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpEmployeesV.lastUpdateDate).append(this.lastUpdatedBy, localFbpEmployeesV.lastUpdatedBy).append(this.erpOrgId, localFbpEmployeesV.erpOrgId).append(this.creationDate, localFbpEmployeesV.creationDate).append(this.createdBy, localFbpEmployeesV.createdBy).append(this.lastUpdateLogin, localFbpEmployeesV.lastUpdateLogin).append(this.employeeId, localFbpEmployeesV.employeeId).append(this.employeeNumber, localFbpEmployeesV.employeeNumber).append(this.employeeName, localFbpEmployeesV.employeeName).append(this.deptId, localFbpEmployeesV.deptId).append(this.deptName, localFbpEmployeesV.deptName).append(this.deptLongName, localFbpEmployeesV.deptLongName).append(this.jobId, localFbpEmployeesV.jobId).append(this.jobName, localFbpEmployeesV.jobName).append(this.checkUnit, localFbpEmployeesV.checkUnit).append(this.checkUnitName, localFbpEmployeesV.checkUnitName).append(this.prodProjectId, localFbpEmployeesV.prodProjectId).append(this.costDeptId, localFbpEmployeesV.costDeptId).append(this.costDeptName, localFbpEmployeesV.costDeptName).append(this.currentCredit, localFbpEmployeesV.currentCredit).append(this.gradeName, localFbpEmployeesV.gradeName).append(this.password, localFbpEmployeesV.password).append(this.positionLevel, localFbpEmployeesV.positionLevel).append(this.positionName, localFbpEmployeesV.positionName).append(this.employeeType, localFbpEmployeesV.employeeType).append(this.sourceSystem, localFbpEmployeesV.sourceSystem).append(this.shortName, localFbpEmployeesV.shortName).append(this.exchangePersonFlag, localFbpEmployeesV.exchangePersonFlag).append(this.employeeGuid, localFbpEmployeesV.employeeGuid).append(this.synchFlag, localFbpEmployeesV.synchFlag).append(this.isSynchRequired, localFbpEmployeesV.isSynchRequired).append(this.useOaFlag, localFbpEmployeesV.useOaFlag).append(this.useEmailFlag, localFbpEmployeesV.useEmailFlag).append(this.useSmsFlag, localFbpEmployeesV.useSmsFlag).append(this.rejectSmsFlag, localFbpEmployeesV.rejectSmsFlag).append(this.monNoticeFlag, localFbpEmployeesV.monNoticeFlag).append(this.tueNoticeFlag, localFbpEmployeesV.tueNoticeFlag).append(this.wedNoticeFlag, localFbpEmployeesV.wedNoticeFlag).append(this.thuNoticeFlag, localFbpEmployeesV.thuNoticeFlag).append(this.friNoticeFlag, localFbpEmployeesV.friNoticeFlag).append(this.satNoticeFlag, localFbpEmployeesV.satNoticeFlag).append(this.sunNoticeFlag, localFbpEmployeesV.sunNoticeFlag).append(this.startHour, localFbpEmployeesV.startHour).append(this.startMin, localFbpEmployeesV.startMin).append(this.endHour, localFbpEmployeesV.endHour).append(this.endMin, localFbpEmployeesV.endMin).append(this.oaAddress, localFbpEmployeesV.oaAddress).append(this.phone, localFbpEmployeesV.phone).append(this.mobilePhone, localFbpEmployeesV.mobilePhone).append(this.emailAddress, localFbpEmployeesV.emailAddress).append(this.attributeCategory, localFbpEmployeesV.attributeCategory).append(this.attribute1, localFbpEmployeesV.attribute1).append(this.attribute2, localFbpEmployeesV.attribute2).append(this.attribute3, localFbpEmployeesV.attribute3).append(this.attribute4, localFbpEmployeesV.attribute4).append(this.attribute5, localFbpEmployeesV.attribute5).append(this.attribute6, localFbpEmployeesV.attribute6).append(this.attribute7, localFbpEmployeesV.attribute7).append(this.attribute8, localFbpEmployeesV.attribute8).append(this.attribute9, localFbpEmployeesV.attribute9).append(this.attribute10, localFbpEmployeesV.attribute10).append(this.enabledFlag, localFbpEmployeesV.enabledFlag).append(this.deptCode, localFbpEmployeesV.deptCode).append(this.coCode, localFbpEmployeesV.coCode).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.erpOrgId).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.employeeId).append(this.employeeNumber).append(this.employeeName).append(this.deptId).append(this.deptName).append(this.deptLongName).append(this.jobId).append(this.jobName).append(this.checkUnit).append(this.checkUnitName).append(this.prodProjectId).append(this.costDeptId).append(this.costDeptName).append(this.currentCredit).append(this.gradeName).append(this.password).append(this.positionLevel).append(this.positionName).append(this.employeeType).append(this.sourceSystem).append(this.shortName).append(this.exchangePersonFlag).append(this.employeeGuid).append(this.synchFlag).append(this.isSynchRequired).append(this.useOaFlag).append(this.useEmailFlag).append(this.useSmsFlag).append(this.rejectSmsFlag).append(this.monNoticeFlag).append(this.tueNoticeFlag).append(this.wedNoticeFlag).append(this.thuNoticeFlag).append(this.friNoticeFlag).append(this.satNoticeFlag).append(this.sunNoticeFlag).append(this.startHour).append(this.startMin).append(this.endHour).append(this.endMin).append(this.oaAddress).append(this.phone).append(this.mobilePhone).append(this.emailAddress).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).append(this.deptCode).append(this.coCode).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("erpOrgId", this.erpOrgId).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("employeeId", this.employeeId).append("employeeNumber", this.employeeNumber).append("employeeName", this.employeeName).append("deptId", this.deptId).append("deptName", this.deptName).append("deptLongName", this.deptLongName).append("jobId", this.jobId).append("jobName", this.jobName).append("checkUnit", this.checkUnit).append("checkUnitName", this.checkUnitName).append("prodProjectId", this.prodProjectId).append("costDeptId", this.costDeptId).append("costDeptName", this.costDeptName).append("currentCredit", this.currentCredit).append("gradeName", this.gradeName).append("password", this.password).append("positionLevel", this.positionLevel).append("positionName", this.positionName).append("employeeType", this.employeeType).append("sourceSystem", this.sourceSystem).append("shortName", this.shortName).append("exchangePersonFlag", this.exchangePersonFlag).append("employeeGuid", this.employeeGuid).append("synchFlag", this.synchFlag).append("isSynchRequired", this.isSynchRequired).append("useOaFlag", this.useOaFlag).append("useEmailFlag", this.useEmailFlag).append("useSmsFlag", this.useSmsFlag).append("rejectSmsFlag", this.rejectSmsFlag).append("monNoticeFlag", this.monNoticeFlag).append("tueNoticeFlag", this.tueNoticeFlag).append("wedNoticeFlag", this.wedNoticeFlag).append("thuNoticeFlag", this.thuNoticeFlag).append("friNoticeFlag", this.friNoticeFlag).append("satNoticeFlag", this.satNoticeFlag).append("sunNoticeFlag", this.sunNoticeFlag).append("startHour", this.startHour).append("startMin", this.startMin).append("endHour", this.endHour).append("endMin", this.endMin).append("oaAddress", this.oaAddress).append("phone", this.phone).append("mobilePhone", this.mobilePhone).append("emailAddress", this.emailAddress).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).append("deptCode", this.deptCode).append("coCode", this.coCode).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getCoCode()
  {
    return this.coCode;
  }
  
  public void setCoCode(String paramString)
  {
    this.coCode = paramString;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public String getIsSynchRequired()
  {
    return this.isSynchRequired;
  }
  
  public void setIsSynchRequired(String paramString)
  {
    this.isSynchRequired = paramString;
  }
  
  public Long getErpOrgId()
  {
    return this.erpOrgId;
  }
  
  public void setErpOrgId(Long paramLong)
  {
    this.erpOrgId = paramLong;
  }
  
  public String getEnabledFlagMeaning()
  {
    return this.enabledFlagMeaning;
  }
  
  public void setEnabledFlagMeaning(String paramString)
  {
    this.enabledFlagMeaning = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV
 * JD-Core Version:    0.7.0.1
 */