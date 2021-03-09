package com.zte.esb.bean;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="EmployeeInfo", propOrder={"employeeChangeId", "employeeCode", "employeeName", "gender", "deptName", "deptBenchmarkCode", "deptCode", "position", "degree", "docType", "docNumber", "withCode", "waistCode", "height", "weight", "birthday", "status", "entryDate", "departureDate", "officeTel", "officeAddress", "officeZipCode", "officeEmail", "mobile", "homeTel", "homeAddress", "homeZipCode", "personalEmail", "workexp", "remark", "changeType", "changeDate"})
public class EmployeeInfo
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String employeeChangeId;
  @XmlElement(required=true)
  protected String employeeCode;
  @XmlElement(required=true)
  protected String employeeName;
  @XmlElement(required=true)
  protected String gender;
  protected String deptName;
  @XmlElement(required=true)
  protected String deptBenchmarkCode;
  @XmlElement(required=true)
  protected String deptCode;
  @XmlElement(required=true)
  protected String position;
  @XmlElement(required=true)
  protected String degree;
  protected String docType;
  protected String docNumber;
  protected Double withCode;
  protected Double waistCode;
  protected Double height;
  protected Double weight;
  @XmlElement(type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date birthday;
  @XmlElement(required=true)
  protected String status;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date entryDate;
  @XmlElement(type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date departureDate;
  protected String officeTel;
  protected String officeAddress;
  protected String officeZipCode;
  protected String officeEmail;
  protected String mobile;
  protected String homeTel;
  protected String homeAddress;
  protected String homeZipCode;
  protected String personalEmail;
  protected String workexp;
  protected String remark;
  @XmlElement(required=true)
  protected String changeType;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date changeDate;
  
  public String getEmployeeChangeId()
  {
    return this.employeeChangeId;
  }
  
  public void setEmployeeChangeId(String paramString)
  {
    this.employeeChangeId = paramString;
  }
  
  public String getEmployeeCode()
  {
    return this.employeeCode;
  }
  
  public void setEmployeeCode(String paramString)
  {
    this.employeeCode = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public void setGender(String paramString)
  {
    this.gender = paramString;
  }
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
  }
  
  public String getDeptBenchmarkCode()
  {
    return this.deptBenchmarkCode;
  }
  
  public void setDeptBenchmarkCode(String paramString)
  {
    this.deptBenchmarkCode = paramString;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public String getPosition()
  {
    return this.position;
  }
  
  public void setPosition(String paramString)
  {
    this.position = paramString;
  }
  
  public String getDegree()
  {
    return this.degree;
  }
  
  public void setDegree(String paramString)
  {
    this.degree = paramString;
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
  
  public Double getWithCode()
  {
    return this.withCode;
  }
  
  public void setWithCode(Double paramDouble)
  {
    this.withCode = paramDouble;
  }
  
  public Double getWaistCode()
  {
    return this.waistCode;
  }
  
  public void setWaistCode(Double paramDouble)
  {
    this.waistCode = paramDouble;
  }
  
  public Double getHeight()
  {
    return this.height;
  }
  
  public void setHeight(Double paramDouble)
  {
    this.height = paramDouble;
  }
  
  public Double getWeight()
  {
    return this.weight;
  }
  
  public void setWeight(Double paramDouble)
  {
    this.weight = paramDouble;
  }
  
  public Date getBirthday()
  {
    return this.birthday;
  }
  
  public void setBirthday(Date paramDate)
  {
    this.birthday = paramDate;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
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
  
  public String getOfficeTel()
  {
    return this.officeTel;
  }
  
  public void setOfficeTel(String paramString)
  {
    this.officeTel = paramString;
  }
  
  public String getOfficeAddress()
  {
    return this.officeAddress;
  }
  
  public void setOfficeAddress(String paramString)
  {
    this.officeAddress = paramString;
  }
  
  public String getOfficeZipCode()
  {
    return this.officeZipCode;
  }
  
  public void setOfficeZipCode(String paramString)
  {
    this.officeZipCode = paramString;
  }
  
  public String getOfficeEmail()
  {
    return this.officeEmail;
  }
  
  public void setOfficeEmail(String paramString)
  {
    this.officeEmail = paramString;
  }
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public void setMobile(String paramString)
  {
    this.mobile = paramString;
  }
  
  public String getHomeTel()
  {
    return this.homeTel;
  }
  
  public void setHomeTel(String paramString)
  {
    this.homeTel = paramString;
  }
  
  public String getHomeAddress()
  {
    return this.homeAddress;
  }
  
  public void setHomeAddress(String paramString)
  {
    this.homeAddress = paramString;
  }
  
  public String getHomeZipCode()
  {
    return this.homeZipCode;
  }
  
  public void setHomeZipCode(String paramString)
  {
    this.homeZipCode = paramString;
  }
  
  public String getPersonalEmail()
  {
    return this.personalEmail;
  }
  
  public void setPersonalEmail(String paramString)
  {
    this.personalEmail = paramString;
  }
  
  public String getWorkexp()
  {
    return this.workexp;
  }
  
  public void setWorkexp(String paramString)
  {
    this.workexp = paramString;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public String getChangeType()
  {
    return this.changeType;
  }
  
  public void setChangeType(String paramString)
  {
    this.changeType = paramString;
  }
  
  public Date getChangeDate()
  {
    return this.changeDate;
  }
  
  public void setChangeDate(Date paramDate)
  {
    this.changeDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.EmployeeInfo
 * JD-Core Version:    0.7.0.1
 */