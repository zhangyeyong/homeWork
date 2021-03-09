package com.zte.eas.appframe.business.syscommon.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpEmployeesLoginV
  extends BaseObject
  implements Serializable
{
  protected BigInteger employeeId;
  protected String employeeNumber;
  protected String employeeName;
  protected String password;
  protected BigInteger deptId;
  protected String deptCode;
  protected String deptName;
  protected String deptLongName;
  protected String attribute7;
  protected String companyName;
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getAttribute7()
  {
    return this.attribute7;
  }
  
  public void setAttribute7(String paramString)
  {
    this.attribute7 = paramString;
  }
  
  public FbpEmployeesLoginV() {}
  
  public FbpEmployeesLoginV(BigInteger paramBigInteger1, String paramString1, String paramString2, String paramString3, BigInteger paramBigInteger2, String paramString4, String paramString5, String paramString6)
  {
    setEmployeeId(paramBigInteger1);
    setEmployeeNumber(paramString1);
    setEmployeeName(paramString2);
    setPassword(paramString3);
    setDeptId(paramBigInteger2);
    setDeptCode(paramString4);
    setDeptName(paramString5);
    setDeptLongName(paramString6);
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
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public BigInteger getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(BigInteger paramBigInteger)
  {
    this.deptId = paramBigInteger;
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
    if (!(paramObject instanceof FbpEmployeesLoginV)) {
      return false;
    }
    FbpEmployeesLoginV localFbpEmployeesLoginV = (FbpEmployeesLoginV)paramObject;
    return new EqualsBuilder().append(this.employeeId, localFbpEmployeesLoginV.employeeId).append(this.employeeNumber, localFbpEmployeesLoginV.employeeNumber).append(this.employeeName, localFbpEmployeesLoginV.employeeName).append(this.password, localFbpEmployeesLoginV.password).append(this.deptId, localFbpEmployeesLoginV.deptId).append(this.deptCode, localFbpEmployeesLoginV.deptCode).append(this.deptName, localFbpEmployeesLoginV.deptName).append(this.deptLongName, localFbpEmployeesLoginV.deptLongName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.employeeId).append(this.employeeNumber).append(this.employeeName).append(this.password).append(this.deptId).append(this.deptCode).append(this.deptName).append(this.deptLongName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("employeeId", this.employeeId).append("employeeNumber", this.employeeNumber).append("employeeName", this.employeeName).append("password", this.password).append("deptId", this.deptId).append("deptCode", this.deptCode).append("deptName", this.deptName).append("deptLongName", this.deptLongName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV
 * JD-Core Version:    0.7.0.1
 */