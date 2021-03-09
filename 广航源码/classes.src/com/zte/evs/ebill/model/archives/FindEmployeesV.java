package com.zte.evs.ebill.model.archives;

import java.io.Serializable;

public class FindEmployeesV
  implements Serializable
{
  protected Long employeeId;
  protected String employeeNumber;
  protected String employeeName;
  protected String emailAddress;
  protected String mobilePhone;
  protected String phone;
  protected Long deptId;
  protected String deptCode;
  protected String deptName;
  protected Long companyId;
  protected String companyName;
  
  public FindEmployeesV() {}
  
  public FindEmployeesV(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong2, String paramString6, Long paramLong3, String paramString7, String paramString8)
  {
    setEmployeeId(paramLong1);
    setEmployeeNumber(paramString1);
    setEmployeeName(paramString2);
    setEmailAddress(paramString3);
    setMobilePhone(paramString4);
    setCompanyId(paramLong3);
    setCompanyName(paramString7);
    setPhone(paramString5);
    setDeptId(paramLong2);
    setDeptCode(paramString6);
    setDeptName(paramString8);
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
  
  public String getEmailAddress()
  {
    return this.emailAddress;
  }
  
  public void setEmailAddress(String paramString)
  {
    this.emailAddress = paramString;
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
  
  public Long getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(Long paramLong)
  {
    this.deptId = paramLong;
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
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.archives.FindEmployeesV
 * JD-Core Version:    0.7.0.1
 */