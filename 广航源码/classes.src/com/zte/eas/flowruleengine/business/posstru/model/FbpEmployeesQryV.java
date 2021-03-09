package com.zte.eas.flowruleengine.business.posstru.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpEmployeesQryV
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected Long employeeId;
  protected String employeeNumber;
  protected String employeeName;
  protected Long deptId;
  protected String deptName;
  protected Long jobId;
  protected String jobName;
  protected Long positionId;
  protected String positionCode;
  protected String positionName;
  protected String checkUnit;
  protected Long prodProjectId;
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
  
  public FbpEmployeesQryV() {}
  
  public FbpEmployeesQryV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, String paramString1, String paramString2, Long paramLong5, String paramString3, Long paramLong6, String paramString4, Long paramLong7, String paramString5, String paramString6, String paramString7, Long paramLong8, Long paramLong9, BigInteger paramBigInteger1, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35, String paramString36, String paramString37, String paramString38, String paramString39, String paramString40, String paramString41)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEmployeeId(paramLong4);
    setEmployeeNumber(paramString1);
    setEmployeeName(paramString2);
    setDeptId(paramLong5);
    setDeptName(paramString3);
    setJobId(paramLong6);
    setJobName(paramString4);
    setPositionId(paramLong7);
    setPositionCode(paramString5);
    setPositionName(paramString6);
    setCheckUnit(paramString7);
    setProdProjectId(paramLong8);
    setCostDeptId(paramLong9);
    setCurrentCredit(paramBigInteger1);
    setPassword(paramString8);
    setPositionLevel(paramString9);
    setEmployeeType(paramString10);
    setSourceSystem(paramString11);
    setShortName(paramString12);
    setExchangePersonFlag(paramString13);
    setEmployeeGuid(paramString14);
    setSynchFlag(paramString15);
    setUseOaFlag(paramString16);
    setUseEmailFlag(paramString17);
    setUseSmsFlag(paramString18);
    setRejectSmsFlag(paramString19);
    setMonNoticeFlag(paramString20);
    setTueNoticeFlag(paramString21);
    setWedNoticeFlag(paramString22);
    setThuNoticeFlag(paramString23);
    setFriNoticeFlag(paramString24);
    setSatNoticeFlag(paramString25);
    setSunNoticeFlag(paramString26);
    setStartHour(paramBigInteger2);
    setStartMin(paramBigInteger3);
    setEndHour(paramBigInteger4);
    setEndMin(paramBigInteger5);
    setOaAddress(paramString27);
    setPhone(paramString28);
    setMobilePhone(paramString29);
    setEmailAddress(paramString30);
    setAttribute1(paramString31);
    setAttribute2(paramString32);
    setAttribute3(paramString33);
    setAttribute4(paramString34);
    setAttribute5(paramString35);
    setAttribute6(paramString36);
    setAttribute7(paramString37);
    setAttribute8(paramString38);
    setAttribute9(paramString39);
    setAttribute10(paramString40);
    setEnabledFlag(paramString41);
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
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
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
  
  public Long getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(Long paramLong)
  {
    this.deptId = paramLong;
  }
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
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
  
  public Long getPositionId()
  {
    return this.positionId;
  }
  
  public void setPositionId(Long paramLong)
  {
    this.positionId = paramLong;
  }
  
  public String getPositionCode()
  {
    return this.positionCode;
  }
  
  public void setPositionCode(String paramString)
  {
    this.positionCode = paramString;
  }
  
  public String getPositionName()
  {
    return this.positionName;
  }
  
  public void setPositionName(String paramString)
  {
    this.positionName = paramString;
  }
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
  
  public Long getProdProjectId()
  {
    return this.prodProjectId;
  }
  
  public void setProdProjectId(Long paramLong)
  {
    this.prodProjectId = paramLong;
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
    if (!(paramObject instanceof FbpEmployeesQryV)) {
      return false;
    }
    FbpEmployeesQryV localFbpEmployeesQryV = (FbpEmployeesQryV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpEmployeesQryV.lastUpdateDate).append(this.lastUpdatedBy, localFbpEmployeesQryV.lastUpdatedBy).append(this.creationDate, localFbpEmployeesQryV.creationDate).append(this.createdBy, localFbpEmployeesQryV.createdBy).append(this.lastUpdateLogin, localFbpEmployeesQryV.lastUpdateLogin).append(this.employeeId, localFbpEmployeesQryV.employeeId).append(this.employeeNumber, localFbpEmployeesQryV.employeeNumber).append(this.employeeName, localFbpEmployeesQryV.employeeName).append(this.deptId, localFbpEmployeesQryV.deptId).append(this.deptName, localFbpEmployeesQryV.deptName).append(this.jobId, localFbpEmployeesQryV.jobId).append(this.jobName, localFbpEmployeesQryV.jobName).append(this.positionId, localFbpEmployeesQryV.positionId).append(this.positionCode, localFbpEmployeesQryV.positionCode).append(this.positionName, localFbpEmployeesQryV.positionName).append(this.checkUnit, localFbpEmployeesQryV.checkUnit).append(this.prodProjectId, localFbpEmployeesQryV.prodProjectId).append(this.costDeptId, localFbpEmployeesQryV.costDeptId).append(this.currentCredit, localFbpEmployeesQryV.currentCredit).append(this.password, localFbpEmployeesQryV.password).append(this.positionLevel, localFbpEmployeesQryV.positionLevel).append(this.employeeType, localFbpEmployeesQryV.employeeType).append(this.sourceSystem, localFbpEmployeesQryV.sourceSystem).append(this.shortName, localFbpEmployeesQryV.shortName).append(this.exchangePersonFlag, localFbpEmployeesQryV.exchangePersonFlag).append(this.employeeGuid, localFbpEmployeesQryV.employeeGuid).append(this.synchFlag, localFbpEmployeesQryV.synchFlag).append(this.useOaFlag, localFbpEmployeesQryV.useOaFlag).append(this.useEmailFlag, localFbpEmployeesQryV.useEmailFlag).append(this.useSmsFlag, localFbpEmployeesQryV.useSmsFlag).append(this.rejectSmsFlag, localFbpEmployeesQryV.rejectSmsFlag).append(this.monNoticeFlag, localFbpEmployeesQryV.monNoticeFlag).append(this.tueNoticeFlag, localFbpEmployeesQryV.tueNoticeFlag).append(this.wedNoticeFlag, localFbpEmployeesQryV.wedNoticeFlag).append(this.thuNoticeFlag, localFbpEmployeesQryV.thuNoticeFlag).append(this.friNoticeFlag, localFbpEmployeesQryV.friNoticeFlag).append(this.satNoticeFlag, localFbpEmployeesQryV.satNoticeFlag).append(this.sunNoticeFlag, localFbpEmployeesQryV.sunNoticeFlag).append(this.startHour, localFbpEmployeesQryV.startHour).append(this.startMin, localFbpEmployeesQryV.startMin).append(this.endHour, localFbpEmployeesQryV.endHour).append(this.endMin, localFbpEmployeesQryV.endMin).append(this.oaAddress, localFbpEmployeesQryV.oaAddress).append(this.phone, localFbpEmployeesQryV.phone).append(this.mobilePhone, localFbpEmployeesQryV.mobilePhone).append(this.emailAddress, localFbpEmployeesQryV.emailAddress).append(this.attribute1, localFbpEmployeesQryV.attribute1).append(this.attribute2, localFbpEmployeesQryV.attribute2).append(this.attribute3, localFbpEmployeesQryV.attribute3).append(this.attribute4, localFbpEmployeesQryV.attribute4).append(this.attribute5, localFbpEmployeesQryV.attribute5).append(this.attribute6, localFbpEmployeesQryV.attribute6).append(this.attribute7, localFbpEmployeesQryV.attribute7).append(this.attribute8, localFbpEmployeesQryV.attribute8).append(this.attribute9, localFbpEmployeesQryV.attribute9).append(this.attribute10, localFbpEmployeesQryV.attribute10).append(this.enabledFlag, localFbpEmployeesQryV.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.employeeId).append(this.employeeNumber).append(this.employeeName).append(this.deptId).append(this.deptName).append(this.jobId).append(this.jobName).append(this.positionId).append(this.positionCode).append(this.positionName).append(this.checkUnit).append(this.prodProjectId).append(this.costDeptId).append(this.currentCredit).append(this.password).append(this.positionLevel).append(this.employeeType).append(this.sourceSystem).append(this.shortName).append(this.exchangePersonFlag).append(this.employeeGuid).append(this.synchFlag).append(this.useOaFlag).append(this.useEmailFlag).append(this.useSmsFlag).append(this.rejectSmsFlag).append(this.monNoticeFlag).append(this.tueNoticeFlag).append(this.wedNoticeFlag).append(this.thuNoticeFlag).append(this.friNoticeFlag).append(this.satNoticeFlag).append(this.sunNoticeFlag).append(this.startHour).append(this.startMin).append(this.endHour).append(this.endMin).append(this.oaAddress).append(this.phone).append(this.mobilePhone).append(this.emailAddress).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("employeeId", this.employeeId).append("employeeNumber", this.employeeNumber).append("employeeName", this.employeeName).append("deptId", this.deptId).append("deptName", this.deptName).append("jobId", this.jobId).append("jobName", this.jobName).append("positionId", this.positionId).append("positionCode", this.positionCode).append("positionName", this.positionName).append("checkUnit", this.checkUnit).append("prodProjectId", this.prodProjectId).append("costDeptId", this.costDeptId).append("currentCredit", this.currentCredit).append("password", this.password).append("positionLevel", this.positionLevel).append("employeeType", this.employeeType).append("sourceSystem", this.sourceSystem).append("shortName", this.shortName).append("exchangePersonFlag", this.exchangePersonFlag).append("employeeGuid", this.employeeGuid).append("synchFlag", this.synchFlag).append("useOaFlag", this.useOaFlag).append("useEmailFlag", this.useEmailFlag).append("useSmsFlag", this.useSmsFlag).append("rejectSmsFlag", this.rejectSmsFlag).append("monNoticeFlag", this.monNoticeFlag).append("tueNoticeFlag", this.tueNoticeFlag).append("wedNoticeFlag", this.wedNoticeFlag).append("thuNoticeFlag", this.thuNoticeFlag).append("friNoticeFlag", this.friNoticeFlag).append("satNoticeFlag", this.satNoticeFlag).append("sunNoticeFlag", this.sunNoticeFlag).append("startHour", this.startHour).append("startMin", this.startMin).append("endHour", this.endHour).append("endMin", this.endMin).append("oaAddress", this.oaAddress).append("phone", this.phone).append("mobilePhone", this.mobilePhone).append("emailAddress", this.emailAddress).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.business.posstru.model.FbpEmployeesQryV
 * JD-Core Version:    0.7.0.1
 */