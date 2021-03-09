package com.zte.eas.organization.business.employeemanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpEmployeesLovV
  extends BaseObject
  implements Serializable
{
  protected Long myEmployeeId;
  protected Long orgId;
  protected Long employeeId;
  protected String employeeNumber;
  protected String employeeName;
  protected Long deptId;
  protected String deptName;
  protected String deptLongName;
  protected Long jobId;
  protected String jobName;
  protected Long positionId;
  protected String positionCode;
  protected String positionName;
  protected String checkUnit;
  protected String checkUnitName;
  protected Long erpOrgId;
  protected String erpOrgName;
  protected String oaAddress;
  protected String phone;
  protected String mobilePhone;
  protected String emailAddress;
  protected String positionLevel;
  protected String enabledFlag;
  protected String check;
  
  public FbpEmployeesLovV() {}
  
  public FbpEmployeesLovV(Long paramLong1, String paramString1, String paramString2, Long paramLong2, String paramString3, String paramString4, Long paramLong3, String paramString5, Long paramLong4, String paramString6, String paramString7, String paramString8, String paramString9, Long paramLong5, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, Long paramLong6)
  {
    setEmployeeId(paramLong1);
    setEmployeeNumber(paramString1);
    setEmployeeName(paramString2);
    setDeptId(paramLong2);
    setDeptName(paramString3);
    setDeptLongName(paramString4);
    setJobId(paramLong3);
    setJobName(paramString5);
    setPositionId(paramLong4);
    setPositionCode(paramString6);
    setPositionName(paramString7);
    setCheckUnit(paramString8);
    setCheckUnitName(paramString9);
    setErpOrgId(paramLong5);
    setErpOrgName(paramString10);
    setOaAddress(paramString11);
    setPhone(paramString12);
    setMobilePhone(paramString13);
    setEmailAddress(paramString14);
    setEnabledFlag(paramString15);
    setPositionLevel(paramString16);
    setOrgId(paramLong6);
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
  
  public String getCheckUnitName()
  {
    return this.checkUnitName;
  }
  
  public void setCheckUnitName(String paramString)
  {
    this.checkUnitName = paramString;
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
    if (!(paramObject instanceof FbpEmployeesLovV)) {
      return false;
    }
    FbpEmployeesLovV localFbpEmployeesLovV = (FbpEmployeesLovV)paramObject;
    return new EqualsBuilder().append(this.employeeId, localFbpEmployeesLovV.employeeId).append(this.employeeNumber, localFbpEmployeesLovV.employeeNumber).append(this.employeeName, localFbpEmployeesLovV.employeeName).append(this.deptId, localFbpEmployeesLovV.deptId).append(this.deptName, localFbpEmployeesLovV.deptName).append(this.deptLongName, localFbpEmployeesLovV.deptLongName).append(this.jobId, localFbpEmployeesLovV.jobId).append(this.jobName, localFbpEmployeesLovV.jobName).append(this.positionId, localFbpEmployeesLovV.positionId).append(this.positionCode, localFbpEmployeesLovV.positionCode).append(this.positionName, localFbpEmployeesLovV.positionName).append(this.checkUnit, localFbpEmployeesLovV.checkUnit).append(this.checkUnitName, localFbpEmployeesLovV.checkUnitName).append(this.erpOrgId, localFbpEmployeesLovV.erpOrgId).append(this.erpOrgName, localFbpEmployeesLovV.erpOrgName).append(this.oaAddress, localFbpEmployeesLovV.oaAddress).append(this.phone, localFbpEmployeesLovV.phone).append(this.mobilePhone, localFbpEmployeesLovV.mobilePhone).append(this.emailAddress, localFbpEmployeesLovV.emailAddress).append(this.enabledFlag, localFbpEmployeesLovV.enabledFlag).append(this.positionLevel, localFbpEmployeesLovV.positionLevel).append(this.orgId, localFbpEmployeesLovV.orgId).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.employeeId).append(this.employeeNumber).append(this.employeeName).append(this.deptId).append(this.deptName).append(this.deptLongName).append(this.jobId).append(this.jobName).append(this.positionId).append(this.positionCode).append(this.positionName).append(this.checkUnit).append(this.checkUnitName).append(this.erpOrgId).append(this.erpOrgName).append(this.oaAddress).append(this.phone).append(this.mobilePhone).append(this.emailAddress).append(this.enabledFlag).append(this.positionLevel).append(this.orgId).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("employeeId", this.employeeId).append("employeeNumber", this.employeeNumber).append("employeeName", this.employeeName).append("deptId", this.deptId).append("deptName", this.deptName).append("deptLongName", this.deptLongName).append("jobId", this.jobId).append("jobName", this.jobName).append("positionId", this.positionId).append("positionCode", this.positionCode).append("positionName", this.positionName).append("checkUnit", this.checkUnit).append("checkUnitName", this.checkUnitName).append("erpOrgId", this.erpOrgId).append("erpOrgName", this.erpOrgName).append("oaAddress", this.oaAddress).append("phone", this.phone).append("mobilePhone", this.mobilePhone).append("emailAddress", this.emailAddress).append("enabledFlag", this.enabledFlag).append("positionLevel", this.positionLevel).append("orgId", this.orgId).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public Long getOrgId()
  {
    return this.orgId;
  }
  
  public void setOrgId(Long paramLong)
  {
    this.orgId = paramLong;
  }
  
  public String getPositionLevel()
  {
    return this.positionLevel;
  }
  
  public void setPositionLevel(String paramString)
  {
    this.positionLevel = paramString;
  }
  
  public String getCheck()
  {
    if (this.employeeId != null) {
      return this.employeeId.toString() + '|' + this.employeeName + '|' + this.positionLevel;
    }
    return null;
  }
  
  public void setCheck(String paramString)
  {
    this.check = paramString;
  }
  
  public Long getMyEmployeeId()
  {
    return this.myEmployeeId;
  }
  
  public void setMyEmployeeId(Long paramLong)
  {
    this.myEmployeeId = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpEmployeesLovV
 * JD-Core Version:    0.7.0.1
 */