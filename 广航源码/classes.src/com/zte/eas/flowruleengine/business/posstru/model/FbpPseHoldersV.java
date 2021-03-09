package com.zte.eas.flowruleengine.business.posstru.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpPseHoldersV
  extends BaseObject
  implements Serializable
{
  protected String rowId;
  protected Long pseHolderId;
  protected Long posStruElementId;
  protected Long employeeId;
  protected String employeeNumber;
  protected String employeeName;
  protected Long deptId;
  protected String deptName;
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
  protected String operationTypeIds;
  protected String operationTypeNames;
  protected String updateFlag;
  
  public FbpPseHoldersV() {}
  
  public FbpPseHoldersV(String paramString1, Long paramLong1, Long paramLong2, Long paramLong3, String paramString2, String paramString3, Long paramLong4, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
  {
    setRowId(paramString1);
    setPseHolderId(paramLong1);
    setPosStruElementId(paramLong2);
    setEmployeeId(paramLong3);
    setEmployeeNumber(paramString2);
    setEmployeeName(paramString3);
    setDeptId(paramLong4);
    setDeptName(paramString4);
    setAttribute1(paramString5);
    setAttribute2(paramString6);
    setAttribute3(paramString7);
    setAttribute4(paramString8);
    setAttribute5(paramString9);
    setAttribute6(paramString10);
    setAttribute7(paramString11);
    setAttribute8(paramString12);
    setAttribute9(paramString13);
    setAttribute10(paramString14);
    setEnabledFlag(paramString15);
  }
  
  public String getRowId()
  {
    return this.rowId;
  }
  
  public void setRowId(String paramString)
  {
    this.rowId = paramString;
  }
  
  public Long getPseHolderId()
  {
    return this.pseHolderId;
  }
  
  public void setPseHolderId(Long paramLong)
  {
    this.pseHolderId = paramLong;
  }
  
  public Long getPosStruElementId()
  {
    return this.posStruElementId;
  }
  
  public void setPosStruElementId(Long paramLong)
  {
    this.posStruElementId = paramLong;
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
    if (!(paramObject instanceof FbpPseHoldersV)) {
      return false;
    }
    FbpPseHoldersV localFbpPseHoldersV = (FbpPseHoldersV)paramObject;
    return new EqualsBuilder().append(this.rowId, localFbpPseHoldersV.rowId).append(this.pseHolderId, localFbpPseHoldersV.pseHolderId).append(this.posStruElementId, localFbpPseHoldersV.posStruElementId).append(this.employeeId, localFbpPseHoldersV.employeeId).append(this.employeeNumber, localFbpPseHoldersV.employeeNumber).append(this.employeeName, localFbpPseHoldersV.employeeName).append(this.deptId, localFbpPseHoldersV.deptId).append(this.deptName, localFbpPseHoldersV.deptName).append(this.attribute1, localFbpPseHoldersV.attribute1).append(this.attribute2, localFbpPseHoldersV.attribute2).append(this.attribute3, localFbpPseHoldersV.attribute3).append(this.attribute4, localFbpPseHoldersV.attribute4).append(this.attribute5, localFbpPseHoldersV.attribute5).append(this.attribute6, localFbpPseHoldersV.attribute6).append(this.attribute7, localFbpPseHoldersV.attribute7).append(this.attribute8, localFbpPseHoldersV.attribute8).append(this.attribute9, localFbpPseHoldersV.attribute9).append(this.attribute10, localFbpPseHoldersV.attribute10).append(this.enabledFlag, localFbpPseHoldersV.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.rowId).append(this.pseHolderId).append(this.posStruElementId).append(this.employeeId).append(this.employeeNumber).append(this.employeeName).append(this.deptId).append(this.deptName).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("rowId", this.rowId).append("pseHolderId", this.pseHolderId).append("posStruElementId", this.posStruElementId).append("employeeId", this.employeeId).append("employeeNumber", this.employeeNumber).append("employeeName", this.employeeName).append("deptId", this.deptId).append("deptName", this.deptName).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getOperationTypeIds()
  {
    return this.operationTypeIds;
  }
  
  public void setOperationTypeIds(String paramString)
  {
    this.operationTypeIds = paramString;
  }
  
  public String getOperationTypeNames()
  {
    return this.operationTypeNames;
  }
  
  public void setOperationTypeNames(String paramString)
  {
    this.operationTypeNames = paramString;
  }
  
  public String getUpdateFlag()
  {
    return this.updateFlag;
  }
  
  public void setUpdateFlag(String paramString)
  {
    this.updateFlag = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.business.posstru.model.FbpPseHoldersV
 * JD-Core Version:    0.7.0.1
 */