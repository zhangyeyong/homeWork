package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class EmployeeDeptCollection
{
  private EmployeeDept[] employeeDeptList;
  
  public EmployeeDept[] getEmployeeDeptList()
  {
    return this.employeeDeptList;
  }
  
  public void setEmployeeDeptList(EmployeeDept[] paramArrayOfEmployeeDept)
  {
    this.employeeDeptList = paramArrayOfEmployeeDept;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("employeeDeptList", this.employeeDeptList).toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model.EmployeeDeptCollection
 * JD-Core Version:    0.7.0.1
 */