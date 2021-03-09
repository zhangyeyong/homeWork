package com.zte.eas.getData.EmployeeSync.model;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Employees
  implements Serializable
{
  private static final long serialVersionUID = 3948940738258431589L;
  private String employeeNumber;
  private String employeeName;
  private String deptCode;
  private String enabledFlag;
  private String oaAddress;
  private String mobilePhone;
  private String emailAddress;
  private String dataType;
  private String sourceType;
  private String sourceReference;
  private String attribute3;
  private String attribute5;
  private String attribute8;
  private Date sysnceDate;
  private String idCard;
  
  public String toString()
  {
    return new ToStringBuilder(this).append("employeeNumber", this.employeeNumber).append("employeeName", this.employeeName).append("deptName", this.deptCode).append("oaAddress", this.oaAddress).append("enabledFlag", this.enabledFlag).append("dataType", this.dataType).append("oaAddress", this.oaAddress).append("emailAddress", this.emailAddress).append("dataType", this.dataType).append("sourceType", this.sourceType).append("sourceReference", this.sourceReference).append("attribute3", this.attribute3).append("attribute5", this.attribute5).append("attribute8", this.attribute8).append("sysnceDate", this.sysnceDate).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Employees)) {
      return false;
    }
    Employees localEmployees = (Employees)paramObject;
    return new EqualsBuilder().append(this.employeeNumber, localEmployees.employeeNumber).append(this.employeeName, localEmployees.employeeName).append(this.deptCode, localEmployees.deptCode).append(this.oaAddress, localEmployees.oaAddress).append(this.enabledFlag, localEmployees.enabledFlag).append(this.dataType, localEmployees.dataType).append(this.oaAddress, localEmployees.oaAddress).append(this.emailAddress, localEmployees.emailAddress).append(this.dataType, localEmployees.dataType).append(this.sourceType, localEmployees.sourceType).append(this.sourceReference, localEmployees.sourceReference).append(this.attribute3, localEmployees.attribute3).append(this.attribute5, localEmployees.attribute5).append(this.attribute8, localEmployees.attribute8).append(this.sysnceDate, localEmployees.sysnceDate).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(this.employeeNumber).append(this.employeeName).append(this.deptCode).append(this.enabledFlag).append(this.oaAddress).append(this.mobilePhone).append(this.emailAddress).append(this.dataType).append(this.sourceType).append(this.sourceReference).append(this.attribute3).append(this.attribute5).append(this.attribute8).append(this.sysnceDate).toHashCode();
  }
  
  public static long getSerialVersionUID()
  {
    return 3948940738258431589L;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public String getEmailAddress()
  {
    return this.emailAddress;
  }
  
  public void setEmailAddress(String paramString)
  {
    this.emailAddress = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getMobilePhone()
  {
    return this.mobilePhone;
  }
  
  public void setMobilePhone(String paramString)
  {
    this.mobilePhone = paramString;
  }
  
  public String getOaAddress()
  {
    return this.oaAddress;
  }
  
  public void setOaAddress(String paramString)
  {
    this.oaAddress = paramString;
  }
  
  public String getDataType()
  {
    return this.dataType;
  }
  
  public void setDataType(String paramString)
  {
    this.dataType = paramString;
  }
  
  public String getSourceReference()
  {
    return this.sourceReference;
  }
  
  public void setSourceReference(String paramString)
  {
    this.sourceReference = paramString;
  }
  
  public String getSourceType()
  {
    return this.sourceType;
  }
  
  public void setSourceType(String paramString)
  {
    this.sourceType = paramString;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public void setAttribute3(String paramString)
  {
    this.attribute3 = paramString;
  }
  
  public String getAttribute5()
  {
    return this.attribute5;
  }
  
  public void setAttribute5(String paramString)
  {
    this.attribute5 = paramString;
  }
  
  public String getAttribute8()
  {
    return this.attribute8;
  }
  
  public void setAttribute8(String paramString)
  {
    this.attribute8 = paramString;
  }
  
  public Date getSysnceDate()
  {
    return this.sysnceDate;
  }
  
  public void setSysnceDate(Date paramDate)
  {
    this.sysnceDate = paramDate;
  }
  
  public String getIdCard()
  {
    return this.idCard;
  }
  
  public void setIdCard(String paramString)
  {
    this.idCard = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.EmployeeSync.model.Employees
 * JD-Core Version:    0.7.0.1
 */