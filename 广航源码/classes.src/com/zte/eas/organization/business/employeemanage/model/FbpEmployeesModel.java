package com.zte.eas.organization.business.employeemanage.model;

import java.util.Date;

public class FbpEmployeesModel
{
  protected String employeeNumber;
  protected String employeeName;
  protected String mobilePhone;
  protected String phone;
  protected String emailAddress;
  protected Date lastUpdateDate;
  protected String positionLevel;
  protected String docNumber;
  protected String deptCode;
  
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
  
  public String getMobilePhone()
  {
    return this.mobilePhone;
  }
  
  public void setMobilePhone(String paramString)
  {
    this.mobilePhone = paramString;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public String getEmailAddress()
  {
    return this.emailAddress;
  }
  
  public void setEmailAddress(String paramString)
  {
    this.emailAddress = paramString;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public String getPositionLevel()
  {
    return this.positionLevel;
  }
  
  public void setPositionLevel(String paramString)
  {
    this.positionLevel = paramString;
  }
  
  public String getDocNumber()
  {
    return this.docNumber;
  }
  
  public void setDocNumber(String paramString)
  {
    this.docNumber = paramString;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public FbpEmployeesModel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Date paramDate, String paramString6, String paramString7, String paramString8)
  {
    this.employeeNumber = paramString1;
    this.employeeName = paramString2;
    this.mobilePhone = paramString3;
    this.phone = paramString4;
    this.emailAddress = paramString5;
    this.lastUpdateDate = paramDate;
    this.positionLevel = paramString6;
    this.docNumber = paramString7;
    this.deptCode = paramString8;
  }
  
  public FbpEmployeesModel() {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpEmployeesModel
 * JD-Core Version:    0.7.0.1
 */