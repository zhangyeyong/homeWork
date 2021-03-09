package com.zte.eas.organization.business.employeemanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpEmployeesSsologinV
  extends BaseObject
  implements Serializable
{
  protected Long employeeId;
  protected String employeeNumber;
  protected String employeeName;
  protected Long deptId;
  protected String deptName;
  protected String deptLongName;
  
  public FbpEmployeesSsologinV() {}
  
  public FbpEmployeesSsologinV(Long paramLong1, String paramString1, String paramString2, Long paramLong2, String paramString3, String paramString4)
  {
    setEmployeeId(paramLong1);
    setEmployeeNumber(paramString1);
    setEmployeeName(paramString2);
    setDeptId(paramLong2);
    setDeptName(paramString3);
    setDeptLongName(paramString4);
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
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpEmployeesSsologinV)) {
      return false;
    }
    FbpEmployeesSsologinV localFbpEmployeesSsologinV = (FbpEmployeesSsologinV)paramObject;
    return new EqualsBuilder().append(this.employeeId, localFbpEmployeesSsologinV.employeeId).append(this.employeeNumber, localFbpEmployeesSsologinV.employeeNumber).append(this.employeeName, localFbpEmployeesSsologinV.employeeName).append(this.deptId, localFbpEmployeesSsologinV.deptId).append(this.deptName, localFbpEmployeesSsologinV.deptName).append(this.deptLongName, localFbpEmployeesSsologinV.deptLongName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.employeeId).append(this.employeeNumber).append(this.employeeName).append(this.deptId).append(this.deptName).append(this.deptLongName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("employeeId", this.employeeId).append("employeeNumber", this.employeeNumber).append("employeeName", this.employeeName).append("deptId", this.deptId).append("deptName", this.deptName).append("deptLongName", this.deptLongName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpEmployeesSsologinV
 * JD-Core Version:    0.7.0.1
 */