package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FbpBorrowFindVL
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  protected Long archivesHeaderId;
  protected String applyNum;
  protected Long employeeId;
  protected String employeeName;
  protected Long deptId;
  protected String deptName;
  protected Long companyId;
  protected String companyName;
  protected String emailAddress;
  protected String mobilePhone;
  protected Date creationDate;
  protected String creationDateStr;
  protected Date applyDate;
  protected String applyDateStr;
  protected String applyDesc;
  protected String attribute1;
  protected String archivesStatus;
  protected Date useDate;
  protected String useDateStr;
  protected Date giveBackDate;
  protected String giveBackDateStr;
  
  public FbpBorrowFindVL() {}
  
  public FbpBorrowFindVL(Long paramLong1, String paramString1, Long paramLong2, String paramString2, Long paramLong3, String paramString3, Long paramLong4, String paramString4, String paramString5, String paramString6, Date paramDate1, Date paramDate2, String paramString7, String paramString8, Date paramDate3, Date paramDate4)
  {
    setArchivesHeaderId(paramLong1);
    setApplyNum(paramString1);
    setEmployeeId(paramLong2);
    setEmployeeName(paramString2);
    setDeptId(paramLong3);
    setDeptName(paramString3);
    setCompanyId(paramLong4);
    setCompanyName(paramString4);
    setEmailAddress(paramString5);
    setMobilePhone(paramString6);
    setCreationDate(paramDate1);
    setApplyDate(paramDate2);
    setApplyDesc(paramString7);
    setAttribute1(paramString8);
    setUseDate(paramDate3);
    setGiveBackDate(paramDate4);
  }
  
  public Long getArchivesHeaderId()
  {
    return this.archivesHeaderId;
  }
  
  public void setArchivesHeaderId(Long paramLong)
  {
    this.archivesHeaderId = paramLong;
  }
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
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
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
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
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
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
  
  public String getApplyNum()
  {
    return this.applyNum;
  }
  
  public void setApplyNum(String paramString)
  {
    this.applyNum = paramString;
  }
  
  public String getCreationDateStr()
  {
    if (this.creationDate != null) {
      this.creationDateStr = this.sdf.format(this.creationDate);
    }
    return this.creationDateStr;
  }
  
  public void setCreationDateStr(String paramString)
  {
    this.creationDateStr = paramString;
  }
  
  public String getApplyDateStr()
  {
    if (this.applyDate != null) {
      this.applyDateStr = this.sdf.format(this.applyDate);
    }
    return this.applyDateStr;
  }
  
  public void setApplyDateStr(String paramString)
  {
    this.applyDateStr = paramString;
  }
  
  public String getUseDateStr()
  {
    if (this.useDate != null) {
      this.useDateStr = this.sdf.format(this.useDate);
    }
    return this.useDateStr;
  }
  
  public void setUseDateStr(String paramString)
  {
    this.useDateStr = paramString;
  }
  
  public String getGiveBackDateStr()
  {
    if (this.giveBackDate != null) {
      this.giveBackDateStr = this.sdf.format(this.giveBackDate);
    }
    return this.giveBackDateStr;
  }
  
  public void setGiveBackDateStr(String paramString)
  {
    this.giveBackDateStr = paramString;
  }
  
  public String getArchivesStatus()
  {
    return this.archivesStatus;
  }
  
  public void setArchivesStatus(String paramString)
  {
    this.archivesStatus = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.FbpBorrowFindVL
 * JD-Core Version:    0.7.0.1
 */