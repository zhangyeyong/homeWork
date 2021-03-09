package com.zte.evs.ebill.model.archives;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FbpArchivesHeadersV
  implements Serializable
{
  protected Date lastUpdateDate;
  protected String attribute1;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  private String creationDateStr;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long archivesHeaderId;
  protected String applyNum;
  protected Long employeeId;
  protected String emailAddress;
  protected String mobilePhone;
  protected Long deptId;
  protected String checkUnit;
  protected Date applyDate;
  private String applyDateStr;
  protected String applyDesc;
  protected Date useDate;
  protected Date giveBackDate;
  protected String archivesStatus;
  protected String archivesStatusName;
  protected String attribute2;
  protected String attribute3;
  protected String attribute4;
  protected String attribute5;
  protected String attribute6;
  protected String attribute7;
  protected String attribute8;
  protected String attribute9;
  protected String attribute10;
  protected Long numberAttribute1;
  protected Long numberAttribute2;
  protected Long numberAttribute3;
  protected Long numberAttribute4;
  protected Long numberAttribute5;
  protected Long numberAttribute6;
  protected Long numberAttribute7;
  protected Long numberAttribute8;
  protected Long numberAttribute9;
  protected Long numberAttribute10;
  protected Date dateAttribute1;
  protected Date dateAttribute2;
  protected Date dateAttribute3;
  protected Date dateAttribute4;
  protected Date dateAttribute5;
  protected Date dateAttribute6;
  protected Date dateAttribute7;
  protected Date dateAttribute8;
  protected Date dateAttribute9;
  protected Date dateAttribute10;
  protected String employeeNumber;
  protected String employeeName;
  protected String deptCode;
  protected String deptName;
  protected Long companyId;
  protected String companyName;
  
  public FbpArchivesHeadersV(Date paramDate1, String paramString1, Long paramLong1, Date paramDate2, String paramString2, Long paramLong2, Long paramLong3, String paramString3, Long paramLong4, String paramString4, Long paramLong5, String paramString5, String paramString6, Long paramLong6, String paramString7, Date paramDate3, String paramString8, String paramString9, Date paramDate4, Date paramDate5, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, Long paramLong7, Long paramLong8, Long paramLong9, Long paramLong10, Long paramLong11, Long paramLong12, Long paramLong13, Long paramLong14, Long paramLong15, Long paramLong16, Date paramDate6, Date paramDate7, Date paramDate8, Date paramDate9, Date paramDate10, Date paramDate11, Date paramDate12, Date paramDate13, Date paramDate14, Date paramDate15, String paramString21, String paramString22, String paramString23, String paramString24, Long paramLong17, String paramString25)
  {
    this.lastUpdateDate = paramDate1;
    this.attribute1 = paramString1;
    this.lastUpdatedBy = paramLong1;
    this.creationDate = paramDate2;
    this.creationDateStr = paramString2;
    this.createdBy = paramLong2;
    this.lastUpdateLogin = paramLong3;
    this.enabledFlag = paramString3;
    this.archivesHeaderId = paramLong4;
    this.applyNum = paramString4;
    this.employeeId = paramLong5;
    this.emailAddress = paramString5;
    this.mobilePhone = paramString6;
    this.deptId = paramLong6;
    this.checkUnit = paramString7;
    this.applyDate = paramDate3;
    this.applyDateStr = paramString8;
    this.applyDesc = paramString9;
    this.useDate = paramDate4;
    this.giveBackDate = paramDate5;
    this.archivesStatus = paramString10;
    this.archivesStatusName = paramString11;
    this.attribute2 = paramString12;
    this.attribute3 = paramString13;
    this.attribute4 = paramString14;
    this.attribute5 = paramString15;
    this.attribute6 = paramString16;
    this.attribute7 = paramString17;
    this.attribute8 = paramString18;
    this.attribute9 = paramString19;
    this.attribute10 = paramString20;
    this.numberAttribute1 = paramLong7;
    this.numberAttribute2 = paramLong8;
    this.numberAttribute3 = paramLong9;
    this.numberAttribute4 = paramLong10;
    this.numberAttribute5 = paramLong11;
    this.numberAttribute6 = paramLong12;
    this.numberAttribute7 = paramLong13;
    this.numberAttribute8 = paramLong14;
    this.numberAttribute9 = paramLong15;
    this.numberAttribute10 = paramLong16;
    this.dateAttribute1 = paramDate6;
    this.dateAttribute2 = paramDate7;
    this.dateAttribute3 = paramDate8;
    this.dateAttribute4 = paramDate9;
    this.dateAttribute5 = paramDate10;
    this.dateAttribute6 = paramDate11;
    this.dateAttribute7 = paramDate12;
    this.dateAttribute8 = paramDate13;
    this.dateAttribute9 = paramDate14;
    this.dateAttribute10 = paramDate15;
    this.employeeNumber = paramString21;
    this.employeeName = paramString22;
    this.deptCode = paramString23;
    this.deptName = paramString24;
    this.companyId = paramLong17;
    this.companyName = paramString25;
  }
  
  public FbpArchivesHeadersV() {}
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public String getAttribute7()
  {
    return this.attribute7;
  }
  
  public void setAttribute7(String paramString)
  {
    this.attribute7 = paramString;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public Long getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(Long paramLong)
  {
    this.createdBy = paramLong;
  }
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
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
  
  public String getAttribute1()
  {
    if (("Y".equals(this.attribute1)) || ("电子档案借阅".equals(this.attribute1))) {
      this.attribute1 = "Y";
    } else {
      this.attribute1 = "N";
    }
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
  
  public Long getNumberAttribute1()
  {
    return this.numberAttribute1;
  }
  
  public void setNumberAttribute1(Long paramLong)
  {
    this.numberAttribute1 = paramLong;
  }
  
  public Long getNumberAttribute2()
  {
    return this.numberAttribute2;
  }
  
  public void setNumberAttribute2(Long paramLong)
  {
    this.numberAttribute2 = paramLong;
  }
  
  public Long getNumberAttribute3()
  {
    return this.numberAttribute3;
  }
  
  public void setNumberAttribute3(Long paramLong)
  {
    this.numberAttribute3 = paramLong;
  }
  
  public Long getNumberAttribute4()
  {
    return this.numberAttribute4;
  }
  
  public void setNumberAttribute4(Long paramLong)
  {
    this.numberAttribute4 = paramLong;
  }
  
  public Long getNumberAttribute5()
  {
    return this.numberAttribute5;
  }
  
  public void setNumberAttribute5(Long paramLong)
  {
    this.numberAttribute5 = paramLong;
  }
  
  public Long getNumberAttribute6()
  {
    return this.numberAttribute6;
  }
  
  public void setNumberAttribute6(Long paramLong)
  {
    this.numberAttribute6 = paramLong;
  }
  
  public Long getNumberAttribute7()
  {
    return this.numberAttribute7;
  }
  
  public void setNumberAttribute7(Long paramLong)
  {
    this.numberAttribute7 = paramLong;
  }
  
  public Long getNumberAttribute8()
  {
    return this.numberAttribute8;
  }
  
  public void setNumberAttribute8(Long paramLong)
  {
    this.numberAttribute8 = paramLong;
  }
  
  public Long getNumberAttribute9()
  {
    return this.numberAttribute9;
  }
  
  public void setNumberAttribute9(Long paramLong)
  {
    this.numberAttribute9 = paramLong;
  }
  
  public Long getNumberAttribute10()
  {
    return this.numberAttribute10;
  }
  
  public void setNumberAttribute10(Long paramLong)
  {
    this.numberAttribute10 = paramLong;
  }
  
  public Date getDateAttribute1()
  {
    return this.dateAttribute1;
  }
  
  public void setDateAttribute1(Date paramDate)
  {
    this.dateAttribute1 = paramDate;
  }
  
  public Date getDateAttribute2()
  {
    return this.dateAttribute2;
  }
  
  public void setDateAttribute2(Date paramDate)
  {
    this.dateAttribute2 = paramDate;
  }
  
  public Date getDateAttribute3()
  {
    return this.dateAttribute3;
  }
  
  public void setDateAttribute3(Date paramDate)
  {
    this.dateAttribute3 = paramDate;
  }
  
  public Date getDateAttribute4()
  {
    return this.dateAttribute4;
  }
  
  public void setDateAttribute4(Date paramDate)
  {
    this.dateAttribute4 = paramDate;
  }
  
  public Date getDateAttribute5()
  {
    return this.dateAttribute5;
  }
  
  public void setDateAttribute5(Date paramDate)
  {
    this.dateAttribute5 = paramDate;
  }
  
  public Date getDateAttribute6()
  {
    return this.dateAttribute6;
  }
  
  public void setDateAttribute6(Date paramDate)
  {
    this.dateAttribute6 = paramDate;
  }
  
  public Date getDateAttribute7()
  {
    return this.dateAttribute7;
  }
  
  public void setDateAttribute7(Date paramDate)
  {
    this.dateAttribute7 = paramDate;
  }
  
  public Date getDateAttribute8()
  {
    return this.dateAttribute8;
  }
  
  public void setDateAttribute8(Date paramDate)
  {
    this.dateAttribute8 = paramDate;
  }
  
  public Date getDateAttribute9()
  {
    return this.dateAttribute9;
  }
  
  public void setDateAttribute9(Date paramDate)
  {
    this.dateAttribute9 = paramDate;
  }
  
  public Date getDateAttribute10()
  {
    return this.dateAttribute10;
  }
  
  public void setDateAttribute10(Date paramDate)
  {
    this.dateAttribute10 = paramDate;
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
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getApplyDateStr()
  {
    if (null != this.applyDate) {
      this.applyDateStr = new SimpleDateFormat("yyyy-MM-dd").format(this.applyDate);
    }
    return this.applyDateStr;
  }
  
  public String getCreationDateStr()
  {
    if (null != this.creationDate) {
      this.applyDateStr = new SimpleDateFormat("yyyy-MM-dd").format(this.creationDate);
    }
    return this.applyDateStr;
  }
  
  public String getArchivesStatusName()
  {
    return this.archivesStatusName;
  }
  
  public void setArchivesStatusName(String paramString)
  {
    this.archivesStatusName = paramString;
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
 * Qualified Name:     com.zte.evs.ebill.model.archives.FbpArchivesHeadersV
 * JD-Core Version:    0.7.0.1
 */