package com.zte.evs.ebill.model.archives;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpArchivesHeadandhistorV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Long id;
  protected String enabledFlag;
  protected String archivesStatusCode;
  protected Long archivesHeaderId;
  protected String applyNum;
  protected Long employeeId;
  protected String emailAddress;
  protected String mobilePhone;
  protected Long deptId;
  protected String checkUnit;
  protected Date applyDate;
  protected String applyDesc;
  protected Date useDate;
  protected Date giveBackDate;
  protected String archivesStatus;
  protected String employeeNumber;
  protected String employeeName;
  protected String deptCode;
  protected String deptName;
  protected String approveCommand;
  private Date beginDate1;
  private Date endDate1;
  private Date beginDate2;
  private Date endDate2;
  private Date beginDate3;
  private Date endDate3;
  protected Long companyId;
  protected String companyName;
  
  public FbpArchivesHeadandhistorV(Long paramLong1, String paramString1, String paramString2, Long paramLong2, String paramString3, Long paramLong3, String paramString4, String paramString5, Long paramLong4, String paramString6, Date paramDate1, String paramString7, Date paramDate2, Date paramDate3, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, Date paramDate4, Date paramDate5, Date paramDate6, Date paramDate7, Date paramDate8, Date paramDate9, Long paramLong5, String paramString14)
  {
    this.id = paramLong1;
    this.enabledFlag = paramString1;
    this.archivesStatusCode = paramString2;
    this.archivesHeaderId = paramLong2;
    this.applyNum = paramString3;
    this.employeeId = paramLong3;
    this.emailAddress = paramString4;
    this.mobilePhone = paramString5;
    this.deptId = paramLong4;
    this.checkUnit = paramString6;
    this.applyDate = paramDate1;
    this.applyDesc = paramString7;
    this.useDate = paramDate2;
    this.giveBackDate = paramDate3;
    this.archivesStatus = paramString8;
    this.employeeNumber = paramString9;
    this.employeeName = paramString10;
    this.deptCode = paramString11;
    this.deptName = paramString12;
    this.approveCommand = paramString13;
    this.beginDate1 = paramDate4;
    this.endDate1 = paramDate5;
    this.beginDate2 = paramDate6;
    this.endDate2 = paramDate7;
    this.beginDate3 = paramDate8;
    this.endDate3 = paramDate9;
    this.companyId = paramLong5;
    this.companyName = paramString14;
  }
  
  public FbpArchivesHeadandhistorV() {}
  
  public FbpArchivesHeadandhistorV(Long paramLong1, String paramString1, Long paramLong2, String paramString2, Long paramLong3, String paramString3, String paramString4, Long paramLong4, String paramString5, Date paramDate1, String paramString6, Date paramDate2, Date paramDate3, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, Date paramDate4, Date paramDate5, Date paramDate6, Date paramDate7, Date paramDate8, Date paramDate9)
  {
    setId(paramLong1);
    setEnabledFlag(paramString1);
    setArchivesHeaderId(paramLong2);
    setApplyNum(paramString2);
    setEmployeeId(paramLong3);
    setEmailAddress(paramString3);
    setMobilePhone(paramString4);
    setDeptId(paramLong4);
    setCheckUnit(paramString5);
    setApplyDate(paramDate1);
    setApplyDesc(paramString6);
    setUseDate(paramDate2);
    setGiveBackDate(paramDate3);
    setArchivesStatus(paramString7);
    setEmployeeNumber(paramString8);
    setEmployeeName(paramString9);
    setDeptCode(paramString10);
    setDeptName(paramString11);
    setApproveCommand(paramString12);
    setBeginDate1(paramDate4);
    setBeginDate2(paramDate6);
    setBeginDate3(paramDate8);
    setEndDate1(paramDate5);
    setEndDate2(paramDate7);
    setEndDate3(paramDate9);
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Long getArchivesHeaderId()
  {
    return this.archivesHeaderId;
  }
  
  public void setArchivesHeaderId(Long paramLong)
  {
    this.archivesHeaderId = paramLong;
  }
  
  public String getApplyNum()
  {
    return this.applyNum;
  }
  
  public void setApplyNum(String paramString)
  {
    this.applyNum = paramString;
  }
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
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
  
  public Long getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(Long paramLong)
  {
    this.deptId = paramLong;
  }
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
  
  public Date getApplyDate()
  {
    return this.applyDate;
  }
  
  public void setApplyDate(Date paramDate)
  {
    this.applyDate = paramDate;
  }
  
  public String getApplyDesc()
  {
    return this.applyDesc;
  }
  
  public void setApplyDesc(String paramString)
  {
    this.applyDesc = paramString;
  }
  
  public Date getUseDate()
  {
    return this.useDate;
  }
  
  public void setUseDate(Date paramDate)
  {
    this.useDate = paramDate;
  }
  
  public Date getGiveBackDate()
  {
    return this.giveBackDate;
  }
  
  public void setGiveBackDate(Date paramDate)
  {
    this.giveBackDate = paramDate;
  }
  
  public String getArchivesStatus()
  {
    return this.archivesStatus;
  }
  
  public void setArchivesStatus(String paramString)
  {
    this.archivesStatus = paramString;
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
  
  public String getApproveCommand()
  {
    return this.approveCommand;
  }
  
  public void setApproveCommand(String paramString)
  {
    this.approveCommand = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!equals(paramObject)) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    FbpArchivesHeadandhistorV localFbpArchivesHeadandhistorV = (FbpArchivesHeadandhistorV)paramObject;
    if (this.applyDate == null)
    {
      if (localFbpArchivesHeadandhistorV.applyDate != null) {
        return false;
      }
    }
    else if (!this.applyDate.equals(localFbpArchivesHeadandhistorV.applyDate)) {
      return false;
    }
    if (this.applyDesc == null)
    {
      if (localFbpArchivesHeadandhistorV.applyDesc != null) {
        return false;
      }
    }
    else if (!this.applyDesc.equals(localFbpArchivesHeadandhistorV.applyDesc)) {
      return false;
    }
    if (this.applyNum == null)
    {
      if (localFbpArchivesHeadandhistorV.applyNum != null) {
        return false;
      }
    }
    else if (!this.applyNum.equals(localFbpArchivesHeadandhistorV.applyNum)) {
      return false;
    }
    if (this.approveCommand == null)
    {
      if (localFbpArchivesHeadandhistorV.approveCommand != null) {
        return false;
      }
    }
    else if (!this.approveCommand.equals(localFbpArchivesHeadandhistorV.approveCommand)) {
      return false;
    }
    if (this.archivesHeaderId == null)
    {
      if (localFbpArchivesHeadandhistorV.archivesHeaderId != null) {
        return false;
      }
    }
    else if (!this.archivesHeaderId.equals(localFbpArchivesHeadandhistorV.archivesHeaderId)) {
      return false;
    }
    if (this.archivesStatus == null)
    {
      if (localFbpArchivesHeadandhistorV.archivesStatus != null) {
        return false;
      }
    }
    else if (!this.archivesStatus.equals(localFbpArchivesHeadandhistorV.archivesStatus)) {
      return false;
    }
    if (this.archivesStatusCode == null)
    {
      if (localFbpArchivesHeadandhistorV.archivesStatusCode != null) {
        return false;
      }
    }
    else if (!this.archivesStatusCode.equals(localFbpArchivesHeadandhistorV.archivesStatusCode)) {
      return false;
    }
    if (this.beginDate1 == null)
    {
      if (localFbpArchivesHeadandhistorV.beginDate1 != null) {
        return false;
      }
    }
    else if (!this.beginDate1.equals(localFbpArchivesHeadandhistorV.beginDate1)) {
      return false;
    }
    if (this.beginDate2 == null)
    {
      if (localFbpArchivesHeadandhistorV.beginDate2 != null) {
        return false;
      }
    }
    else if (!this.beginDate2.equals(localFbpArchivesHeadandhistorV.beginDate2)) {
      return false;
    }
    if (this.beginDate3 == null)
    {
      if (localFbpArchivesHeadandhistorV.beginDate3 != null) {
        return false;
      }
    }
    else if (!this.beginDate3.equals(localFbpArchivesHeadandhistorV.beginDate3)) {
      return false;
    }
    if (this.checkUnit == null)
    {
      if (localFbpArchivesHeadandhistorV.checkUnit != null) {
        return false;
      }
    }
    else if (!this.checkUnit.equals(localFbpArchivesHeadandhistorV.checkUnit)) {
      return false;
    }
    if (this.companyId == null)
    {
      if (localFbpArchivesHeadandhistorV.companyId != null) {
        return false;
      }
    }
    else if (!this.companyId.equals(localFbpArchivesHeadandhistorV.companyId)) {
      return false;
    }
    if (this.companyName == null)
    {
      if (localFbpArchivesHeadandhistorV.companyName != null) {
        return false;
      }
    }
    else if (!this.companyName.equals(localFbpArchivesHeadandhistorV.companyName)) {
      return false;
    }
    if (this.deptCode == null)
    {
      if (localFbpArchivesHeadandhistorV.deptCode != null) {
        return false;
      }
    }
    else if (!this.deptCode.equals(localFbpArchivesHeadandhistorV.deptCode)) {
      return false;
    }
    if (this.deptId == null)
    {
      if (localFbpArchivesHeadandhistorV.deptId != null) {
        return false;
      }
    }
    else if (!this.deptId.equals(localFbpArchivesHeadandhistorV.deptId)) {
      return false;
    }
    if (this.deptName == null)
    {
      if (localFbpArchivesHeadandhistorV.deptName != null) {
        return false;
      }
    }
    else if (!this.deptName.equals(localFbpArchivesHeadandhistorV.deptName)) {
      return false;
    }
    if (this.emailAddress == null)
    {
      if (localFbpArchivesHeadandhistorV.emailAddress != null) {
        return false;
      }
    }
    else if (!this.emailAddress.equals(localFbpArchivesHeadandhistorV.emailAddress)) {
      return false;
    }
    if (this.employeeId == null)
    {
      if (localFbpArchivesHeadandhistorV.employeeId != null) {
        return false;
      }
    }
    else if (!this.employeeId.equals(localFbpArchivesHeadandhistorV.employeeId)) {
      return false;
    }
    if (this.employeeName == null)
    {
      if (localFbpArchivesHeadandhistorV.employeeName != null) {
        return false;
      }
    }
    else if (!this.employeeName.equals(localFbpArchivesHeadandhistorV.employeeName)) {
      return false;
    }
    if (this.employeeNumber == null)
    {
      if (localFbpArchivesHeadandhistorV.employeeNumber != null) {
        return false;
      }
    }
    else if (!this.employeeNumber.equals(localFbpArchivesHeadandhistorV.employeeNumber)) {
      return false;
    }
    if (this.enabledFlag == null)
    {
      if (localFbpArchivesHeadandhistorV.enabledFlag != null) {
        return false;
      }
    }
    else if (!this.enabledFlag.equals(localFbpArchivesHeadandhistorV.enabledFlag)) {
      return false;
    }
    if (this.endDate1 == null)
    {
      if (localFbpArchivesHeadandhistorV.endDate1 != null) {
        return false;
      }
    }
    else if (!this.endDate1.equals(localFbpArchivesHeadandhistorV.endDate1)) {
      return false;
    }
    if (this.endDate2 == null)
    {
      if (localFbpArchivesHeadandhistorV.endDate2 != null) {
        return false;
      }
    }
    else if (!this.endDate2.equals(localFbpArchivesHeadandhistorV.endDate2)) {
      return false;
    }
    if (this.endDate3 == null)
    {
      if (localFbpArchivesHeadandhistorV.endDate3 != null) {
        return false;
      }
    }
    else if (!this.endDate3.equals(localFbpArchivesHeadandhistorV.endDate3)) {
      return false;
    }
    if (this.giveBackDate == null)
    {
      if (localFbpArchivesHeadandhistorV.giveBackDate != null) {
        return false;
      }
    }
    else if (!this.giveBackDate.equals(localFbpArchivesHeadandhistorV.giveBackDate)) {
      return false;
    }
    if (this.id == null)
    {
      if (localFbpArchivesHeadandhistorV.id != null) {
        return false;
      }
    }
    else if (!this.id.equals(localFbpArchivesHeadandhistorV.id)) {
      return false;
    }
    if (this.mobilePhone == null)
    {
      if (localFbpArchivesHeadandhistorV.mobilePhone != null) {
        return false;
      }
    }
    else if (!this.mobilePhone.equals(localFbpArchivesHeadandhistorV.mobilePhone)) {
      return false;
    }
    if (this.useDate == null)
    {
      if (localFbpArchivesHeadandhistorV.useDate != null) {
        return false;
      }
    }
    else if (!this.useDate.equals(localFbpArchivesHeadandhistorV.useDate)) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = hashCode();
    i = 31 * i + (this.applyDate == null ? 0 : this.applyDate.hashCode());
    i = 31 * i + (this.applyDesc == null ? 0 : this.applyDesc.hashCode());
    i = 31 * i + (this.applyNum == null ? 0 : this.applyNum.hashCode());
    i = 31 * i + (this.approveCommand == null ? 0 : this.approveCommand.hashCode());
    i = 31 * i + (this.archivesHeaderId == null ? 0 : this.archivesHeaderId.hashCode());
    i = 31 * i + (this.archivesStatus == null ? 0 : this.archivesStatus.hashCode());
    i = 31 * i + (this.archivesStatusCode == null ? 0 : this.archivesStatusCode.hashCode());
    i = 31 * i + (this.beginDate1 == null ? 0 : this.beginDate1.hashCode());
    i = 31 * i + (this.beginDate2 == null ? 0 : this.beginDate2.hashCode());
    i = 31 * i + (this.beginDate3 == null ? 0 : this.beginDate3.hashCode());
    i = 31 * i + (this.checkUnit == null ? 0 : this.checkUnit.hashCode());
    i = 31 * i + (this.companyId == null ? 0 : this.companyId.hashCode());
    i = 31 * i + (this.companyName == null ? 0 : this.companyName.hashCode());
    i = 31 * i + (this.deptCode == null ? 0 : this.deptCode.hashCode());
    i = 31 * i + (this.deptId == null ? 0 : this.deptId.hashCode());
    i = 31 * i + (this.deptName == null ? 0 : this.deptName.hashCode());
    i = 31 * i + (this.emailAddress == null ? 0 : this.emailAddress.hashCode());
    i = 31 * i + (this.employeeId == null ? 0 : this.employeeId.hashCode());
    i = 31 * i + (this.employeeName == null ? 0 : this.employeeName.hashCode());
    i = 31 * i + (this.employeeNumber == null ? 0 : this.employeeNumber.hashCode());
    i = 31 * i + (this.enabledFlag == null ? 0 : this.enabledFlag.hashCode());
    i = 31 * i + (this.endDate1 == null ? 0 : this.endDate1.hashCode());
    i = 31 * i + (this.endDate2 == null ? 0 : this.endDate2.hashCode());
    i = 31 * i + (this.endDate3 == null ? 0 : this.endDate3.hashCode());
    i = 31 * i + (this.giveBackDate == null ? 0 : this.giveBackDate.hashCode());
    i = 31 * i + (this.id == null ? 0 : this.id.hashCode());
    i = 31 * i + (this.mobilePhone == null ? 0 : this.mobilePhone.hashCode());
    i = 31 * i + (this.useDate == null ? 0 : this.useDate.hashCode());
    return i;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("id", this.id).append("enabledFlag", this.enabledFlag).append("archivesHeaderId", this.archivesHeaderId).append("applyNum", this.applyNum).append("employeeId", this.employeeId).append("emailAddress", this.emailAddress).append("mobilePhone", this.mobilePhone).append("deptId", this.deptId).append("checkUnit", this.checkUnit).append("applyDate", this.applyDate).append("applyDesc", this.applyDesc).append("useDate", this.useDate).append("giveBackDate", this.giveBackDate).append("archivesStatus", this.archivesStatus).append("employeeNumber", this.employeeNumber).append("employeeName", this.employeeName).append("deptCode", this.deptCode).append("deptName", this.deptName).append("approveCommand", this.approveCommand).append("beginDate1", this.beginDate1).append("beginDate2", this.beginDate2).append("beginDate3", this.beginDate3).append("endDate1", this.endDate1).append("endDate2", this.endDate2).append("endDate3", this.endDate3).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public Date getBeginDate1()
  {
    return this.beginDate1;
  }
  
  public void setBeginDate1(Date paramDate)
  {
    this.beginDate1 = paramDate;
  }
  
  public Date getEndDate1()
  {
    return this.endDate1;
  }
  
  public void setEndDate1(Date paramDate)
  {
    this.endDate1 = paramDate;
  }
  
  public Date getBeginDate2()
  {
    return this.beginDate2;
  }
  
  public void setBeginDate2(Date paramDate)
  {
    this.beginDate2 = paramDate;
  }
  
  public Date getEndDate2()
  {
    return this.endDate2;
  }
  
  public void setEndDate2(Date paramDate)
  {
    this.endDate2 = paramDate;
  }
  
  public Date getBeginDate3()
  {
    return this.beginDate3;
  }
  
  public void setBeginDate3(Date paramDate)
  {
    this.beginDate3 = paramDate;
  }
  
  public Date getEndDate3()
  {
    return this.endDate3;
  }
  
  public void setEndDate3(Date paramDate)
  {
    this.endDate3 = paramDate;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public String getArchivesStatusCode()
  {
    return this.archivesStatusCode;
  }
  
  public void setArchivesStatusCode(String paramString)
  {
    this.archivesStatusCode = paramString;
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
 * Qualified Name:     com.zte.evs.ebill.model.archives.FbpArchivesHeadandhistorV
 * JD-Core Version:    0.7.0.1
 */