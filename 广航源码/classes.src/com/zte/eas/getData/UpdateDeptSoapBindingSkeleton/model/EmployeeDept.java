package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EmployeeDept
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String employeeNumber;
  private String deptCode;
  private Date syncDate;
  
  public String toString()
  {
    return new ToStringBuilder(this).append("employeeNumber", this.employeeNumber).append("deptCode", this.deptCode).append("syncDate", this.syncDate).toString();
  }
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public Date getSyncDate()
  {
    return this.syncDate;
  }
  
  public void setSyncDate(Date paramDate)
  {
    this.syncDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model.EmployeeDept
 * JD-Core Version:    0.7.0.1
 */