package com.zte.eas.organization.business.employeemanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpEmployees
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger employeeId;
  protected String employeeNumber;
  protected BigInteger deptId;
  protected Long jobId;
  protected String checkUnit;
  protected BigInteger prodProjectId;
  protected Long costDeptId;
  protected BigInteger currentCredit;
  protected String password;
  protected String positionLevel;
  protected String employeeType;
  protected String sourceSystem;
  protected String shortName;
  protected String exchangePersonFlag;
  protected String employeeGuid;
  protected String synchFlag;
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
  protected String isSynchRequired;
  protected String enabledFlag;
  protected String newPassword;
  protected Integer scanPassErrorCount;
  protected Date scanPassErrorDate;
  protected String deptBenchMarkCode;
  protected String orgBenchMarkCode;
  protected String positionCode;
  protected String isTemp;
  protected String isActive;
  protected Date validDate;
  protected Date invalidDate;
  protected Date entryDate;
  protected Date departureDate;
  protected String docType;
  protected String docNumber;
  protected String degree;
  
  public FbpEmployees() {}
  
  public FbpEmployees(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger1, String paramString1, BigInteger paramBigInteger2, Long paramLong4, String paramString2, BigInteger paramBigInteger3, Long paramLong5, BigInteger paramBigInteger4, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, BigInteger paramBigInteger5, BigInteger paramBigInteger6, BigInteger paramBigInteger7, BigInteger paramBigInteger8, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35, String paramString36, String paramString37, String paramString38, Integer paramInteger, Date paramDate3, String paramString39, String paramString40, String paramString41, String paramString42, String paramString43, Date paramDate4, Date paramDate5, Date paramDate6, Date paramDate7, String paramString44, String paramString45)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEmployeeId(paramBigInteger1);
    setEmployeeNumber(paramString1);
    setDeptId(paramBigInteger2);
    setJobId(paramLong4);
    setCheckUnit(paramString2);
    setProdProjectId(paramBigInteger3);
    setCostDeptId(paramLong5);
    setCurrentCredit(paramBigInteger4);
    setPassword(paramString3);
    setPositionLevel(paramString4);
    setEmployeeType(paramString5);
    setSourceSystem(paramString6);
    setShortName(paramString7);
    setExchangePersonFlag(paramString8);
    setEmployeeGuid(paramString9);
    setSynchFlag(paramString10);
    setUseOaFlag(paramString11);
    setUseEmailFlag(paramString12);
    setUseSmsFlag(paramString13);
    setRejectSmsFlag(paramString14);
    setMonNoticeFlag(paramString15);
    setTueNoticeFlag(paramString16);
    setWedNoticeFlag(paramString17);
    setThuNoticeFlag(paramString18);
    setFriNoticeFlag(paramString19);
    setSatNoticeFlag(paramString20);
    setSunNoticeFlag(paramString21);
    setStartHour(paramBigInteger5);
    setStartMin(paramBigInteger6);
    setEndHour(paramBigInteger7);
    setEndMin(paramBigInteger8);
    setOaAddress(paramString22);
    setPhone(paramString23);
    setMobilePhone(paramString24);
    setEmailAddress(paramString25);
    setAttributeCategory(paramString26);
    setAttribute1(paramString27);
    setAttribute2(paramString28);
    setAttribute3(paramString29);
    setAttribute4(paramString30);
    setAttribute5(paramString31);
    setAttribute6(paramString32);
    setAttribute7(paramString33);
    setAttribute8(paramString34);
    setAttribute9(paramString35);
    setAttribute10(paramString36);
    setIsSynchRequired(paramString37);
    setEnabledFlag(paramString38);
    setScanPassErrorCount(paramInteger);
    setScanPassErrorDate(paramDate3);
    setDeptBenchMarkCode(paramString39);
    setOrgBenchMarkCode(paramString40);
    setPositionCode(paramString41);
    setIsTemp(paramString42);
    setIsActive(paramString43);
    setValidDate(paramDate4);
    setInvalidDate(paramDate5);
    setEntryDate(paramDate6);
    setDepartureDate(paramDate7);
    setDocType(paramString44);
    setDocNumber(paramString45);
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
  
  public BigInteger getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(BigInteger paramBigInteger)
  {
    this.deptId = paramBigInteger;
  }
  
  public Long getJobId()
  {
    return this.jobId;
  }
  
  public void setJobId(Long paramLong)
  {
    this.jobId = paramLong;
  }
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
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
  
  public BigInteger getCurrentCredit()
  {
    return this.currentCredit;
  }
  
  public void setCurrentCredit(BigInteger paramBigInteger)
  {
    this.currentCredit = paramBigInteger;
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
  
  public String getIsSynchRequired()
  {
    return this.isSynchRequired;
  }
  
  public void setIsSynchRequired(String paramString)
  {
    this.isSynchRequired = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Integer getScanPassErrorCount()
  {
    return this.scanPassErrorCount;
  }
  
  public void setScanPassErrorCount(Integer paramInteger)
  {
    this.scanPassErrorCount = paramInteger;
  }
  
  public Date getScanPassErrorDate()
  {
    return this.scanPassErrorDate;
  }
  
  public void setScanPassErrorDate(Date paramDate)
  {
    this.scanPassErrorDate = paramDate;
  }
  
  public String getDeptBenchMarkCode()
  {
    return this.deptBenchMarkCode;
  }
  
  public void setDeptBenchMarkCode(String paramString)
  {
    this.deptBenchMarkCode = paramString;
  }
  
  public String getOrgBenchMarkCode()
  {
    return this.orgBenchMarkCode;
  }
  
  public void setOrgBenchMarkCode(String paramString)
  {
    this.orgBenchMarkCode = paramString;
  }
  
  public String getPositionCode()
  {
    return this.positionCode;
  }
  
  public void setPositionCode(String paramString)
  {
    this.positionCode = paramString;
  }
  
  public String getIsTemp()
  {
    return this.isTemp;
  }
  
  public void setIsTemp(String paramString)
  {
    this.isTemp = paramString;
  }
  
  public String getIsActive()
  {
    return this.isActive;
  }
  
  public void setIsActive(String paramString)
  {
    this.isActive = paramString;
  }
  
  public Date getValidDate()
  {
    return this.validDate;
  }
  
  public void setValidDate(Date paramDate)
  {
    this.validDate = paramDate;
  }
  
  public Date getInvalidDate()
  {
    return this.invalidDate;
  }
  
  public void setInvalidDate(Date paramDate)
  {
    this.invalidDate = paramDate;
  }
  
  public Date getEntryDate()
  {
    return this.entryDate;
  }
  
  public void setEntryDate(Date paramDate)
  {
    this.entryDate = paramDate;
  }
  
  public Date getDepartureDate()
  {
    return this.departureDate;
  }
  
  public void setDepartureDate(Date paramDate)
  {
    this.departureDate = paramDate;
  }
  
  public String getDocType()
  {
    return this.docType;
  }
  
  public void setDocType(String paramString)
  {
    this.docType = paramString;
  }
  
  public String getDocNumber()
  {
    return this.docNumber;
  }
  
  public void setDocNumber(String paramString)
  {
    this.docNumber = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpEmployees)) {
      return false;
    }
    FbpEmployees localFbpEmployees = (FbpEmployees)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpEmployees.lastUpdateDate).append(this.lastUpdatedBy, localFbpEmployees.lastUpdatedBy).append(this.creationDate, localFbpEmployees.creationDate).append(this.createdBy, localFbpEmployees.createdBy).append(this.lastUpdateLogin, localFbpEmployees.lastUpdateLogin).append(this.employeeId, localFbpEmployees.employeeId).append(this.employeeNumber, localFbpEmployees.employeeNumber).append(this.deptId, localFbpEmployees.deptId).append(this.jobId, localFbpEmployees.jobId).append(this.checkUnit, localFbpEmployees.checkUnit).append(this.prodProjectId, localFbpEmployees.prodProjectId).append(this.costDeptId, localFbpEmployees.costDeptId).append(this.currentCredit, localFbpEmployees.currentCredit).append(this.password, localFbpEmployees.password).append(this.positionLevel, localFbpEmployees.positionLevel).append(this.employeeType, localFbpEmployees.employeeType).append(this.sourceSystem, localFbpEmployees.sourceSystem).append(this.shortName, localFbpEmployees.shortName).append(this.exchangePersonFlag, localFbpEmployees.exchangePersonFlag).append(this.employeeGuid, localFbpEmployees.employeeGuid).append(this.synchFlag, localFbpEmployees.synchFlag).append(this.useOaFlag, localFbpEmployees.useOaFlag).append(this.useEmailFlag, localFbpEmployees.useEmailFlag).append(this.useSmsFlag, localFbpEmployees.useSmsFlag).append(this.rejectSmsFlag, localFbpEmployees.rejectSmsFlag).append(this.monNoticeFlag, localFbpEmployees.monNoticeFlag).append(this.tueNoticeFlag, localFbpEmployees.tueNoticeFlag).append(this.wedNoticeFlag, localFbpEmployees.wedNoticeFlag).append(this.thuNoticeFlag, localFbpEmployees.thuNoticeFlag).append(this.friNoticeFlag, localFbpEmployees.friNoticeFlag).append(this.satNoticeFlag, localFbpEmployees.satNoticeFlag).append(this.sunNoticeFlag, localFbpEmployees.sunNoticeFlag).append(this.startHour, localFbpEmployees.startHour).append(this.startMin, localFbpEmployees.startMin).append(this.endHour, localFbpEmployees.endHour).append(this.endMin, localFbpEmployees.endMin).append(this.oaAddress, localFbpEmployees.oaAddress).append(this.phone, localFbpEmployees.phone).append(this.mobilePhone, localFbpEmployees.mobilePhone).append(this.emailAddress, localFbpEmployees.emailAddress).append(this.attributeCategory, localFbpEmployees.attributeCategory).append(this.attribute1, localFbpEmployees.attribute1).append(this.attribute2, localFbpEmployees.attribute2).append(this.attribute3, localFbpEmployees.attribute3).append(this.attribute4, localFbpEmployees.attribute4).append(this.attribute5, localFbpEmployees.attribute5).append(this.attribute6, localFbpEmployees.attribute6).append(this.attribute7, localFbpEmployees.attribute7).append(this.attribute8, localFbpEmployees.attribute8).append(this.attribute9, localFbpEmployees.attribute9).append(this.attribute10, localFbpEmployees.attribute10).append(this.isSynchRequired, localFbpEmployees.isSynchRequired).append(this.enabledFlag, localFbpEmployees.enabledFlag).append(this.scanPassErrorCount, localFbpEmployees.scanPassErrorCount).append(this.scanPassErrorDate, localFbpEmployees.scanPassErrorDate).append(this.deptBenchMarkCode, localFbpEmployees.deptBenchMarkCode).append(this.orgBenchMarkCode, localFbpEmployees.orgBenchMarkCode).append(this.positionCode, localFbpEmployees.positionCode).append(this.isTemp, localFbpEmployees.isTemp).append(this.isActive, localFbpEmployees.isActive).append(this.validDate, localFbpEmployees.validDate).append(this.invalidDate, localFbpEmployees.invalidDate).append(this.entryDate, localFbpEmployees.entryDate).append(this.departureDate, localFbpEmployees.departureDate).append(this.docType, localFbpEmployees.docType).append(this.docNumber, localFbpEmployees.docNumber).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.employeeId).append(this.employeeNumber).append(this.deptId).append(this.jobId).append(this.checkUnit).append(this.prodProjectId).append(this.costDeptId).append(this.currentCredit).append(this.password).append(this.positionLevel).append(this.employeeType).append(this.sourceSystem).append(this.shortName).append(this.exchangePersonFlag).append(this.employeeGuid).append(this.synchFlag).append(this.useOaFlag).append(this.useEmailFlag).append(this.useSmsFlag).append(this.rejectSmsFlag).append(this.monNoticeFlag).append(this.tueNoticeFlag).append(this.wedNoticeFlag).append(this.thuNoticeFlag).append(this.friNoticeFlag).append(this.satNoticeFlag).append(this.sunNoticeFlag).append(this.startHour).append(this.startMin).append(this.endHour).append(this.endMin).append(this.oaAddress).append(this.phone).append(this.mobilePhone).append(this.emailAddress).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.isSynchRequired).append(this.enabledFlag).append(this.scanPassErrorCount).append(this.scanPassErrorDate).append(this.deptBenchMarkCode).append(this.orgBenchMarkCode).append(this.positionCode).append(this.isTemp).append(this.isActive).append(this.validDate).append(this.invalidDate).append(this.entryDate).append(this.departureDate).append(this.docType).append(this.docNumber).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("employeeId", this.employeeId).append("employeeNumber", this.employeeNumber).append("deptId", this.deptId).append("jobId", this.jobId).append("checkUnit", this.checkUnit).append("prodProjectId", this.prodProjectId).append("costDeptId", this.costDeptId).append("currentCredit", this.currentCredit).append("password", this.password).append("positionLevel", this.positionLevel).append("employeeType", this.employeeType).append("sourceSystem", this.sourceSystem).append("shortName", this.shortName).append("exchangePersonFlag", this.exchangePersonFlag).append("employeeGuid", this.employeeGuid).append("synchFlag", this.synchFlag).append("useOaFlag", this.useOaFlag).append("useEmailFlag", this.useEmailFlag).append("useSmsFlag", this.useSmsFlag).append("rejectSmsFlag", this.rejectSmsFlag).append("monNoticeFlag", this.monNoticeFlag).append("tueNoticeFlag", this.tueNoticeFlag).append("wedNoticeFlag", this.wedNoticeFlag).append("thuNoticeFlag", this.thuNoticeFlag).append("friNoticeFlag", this.friNoticeFlag).append("satNoticeFlag", this.satNoticeFlag).append("sunNoticeFlag", this.sunNoticeFlag).append("startHour", this.startHour).append("startMin", this.startMin).append("endHour", this.endHour).append("endMin", this.endMin).append("oaAddress", this.oaAddress).append("phone", this.phone).append("mobilePhone", this.mobilePhone).append("emailAddress", this.emailAddress).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("isSynchRequired", this.isSynchRequired).append("enabledFlag", this.enabledFlag).append("scanPassErrorCount", this.scanPassErrorCount).append("scanPassErrorDate", this.scanPassErrorDate).append("deptBenchMarkCode", this.deptBenchMarkCode).append("orgBenchMarkCode", this.orgBenchMarkCode).append("positionCode", this.positionCode).append("isTemp", this.isTemp).append("isActive", this.isActive).append("validDate", this.validDate).append("invalidDate", this.invalidDate).append("entryDate", this.entryDate).append("departureDate", this.departureDate).append("docType", this.docType).append("docNumber", this.docNumber).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "employeeId";
  }
  
  public String getNewPassword()
  {
    return this.newPassword;
  }
  
  public void setNewPassword(String paramString)
  {
    this.newPassword = paramString;
  }
  
  public String getDegree()
  {
    return this.degree;
  }
  
  public void setDegree(String paramString)
  {
    this.degree = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpEmployees
 * JD-Core Version:    0.7.0.1
 */