package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FbpVoucherBorrowV
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  protected Long archivesHeaderId;
  protected String applyNum;
  protected String applyNumEnd;
  protected Long employeeId;
  protected String employeeName;
  protected Long companyId;
  protected String companyName;
  protected Date useDate;
  protected Date useDateEnd;
  protected Date applyDate;
  protected Date applyDateEnd;
  protected Date giveBackDate;
  protected Date giveBackDateEnd;
  protected String giveBackDateStr;
  protected String attribute1;
  protected String attribute1Name;
  protected String attribute2;
  protected String meaning;
  protected String archivesStatus;
  protected String applyDesc;
  protected String checkFlags;
  
  public FbpVoucherBorrowV() {}
  
  public FbpVoucherBorrowV(Long paramLong1, String paramString1, Long paramLong2, Long paramLong3, String paramString2, Date paramDate1, Date paramDate2, String paramString3, String paramString4, String paramString5)
  {
    setArchivesHeaderId(paramLong1);
    setApplyNum(paramString1);
    setEmployeeId(paramLong2);
    setCompanyId(paramLong3);
    setCompanyName(paramString2);
    setApplyDate(paramDate1);
    setGiveBackDate(paramDate2);
    setAttribute1(paramString3);
    setMeaning(paramString4);
    setArchivesStatus(paramString5);
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
  
  public Date getApplyDate()
  {
    return this.applyDate;
  }
  
  public void setApplyDate(Date paramDate)
  {
    this.applyDate = paramDate;
  }
  
  public Date getGiveBackDate()
  {
    return this.giveBackDate;
  }
  
  public void setGiveBackDate(Date paramDate)
  {
    this.giveBackDate = paramDate;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
  }
  
  public String getMeaning()
  {
    return this.meaning;
  }
  
  public void setMeaning(String paramString)
  {
    this.meaning = paramString;
  }
  
  public String getArchivesStatus()
  {
    return this.archivesStatus;
  }
  
  public void setArchivesStatus(String paramString)
  {
    this.archivesStatus = paramString;
  }
  
  public String getApplyNumEnd()
  {
    return this.applyNumEnd;
  }
  
  public void setApplyNumEnd(String paramString)
  {
    this.applyNumEnd = paramString;
  }
  
  public Date getApplyDateEnd()
  {
    return this.applyDateEnd;
  }
  
  public void setApplyDateEnd(Date paramDate)
  {
    this.applyDateEnd = paramDate;
  }
  
  public Date getGiveBackDateEnd()
  {
    return this.giveBackDateEnd;
  }
  
  public void setGiveBackDateEnd(Date paramDate)
  {
    this.giveBackDateEnd = paramDate;
  }
  
  public String getAttribute2()
  {
    return this.attribute2;
  }
  
  public void setAttribute2(String paramString)
  {
    this.attribute2 = paramString;
  }
  
  public String getApplyDesc()
  {
    return this.applyDesc;
  }
  
  public void setApplyDesc(String paramString)
  {
    this.applyDesc = paramString;
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
  
  public Date getUseDateEnd()
  {
    return this.useDateEnd;
  }
  
  public void setUseDateEnd(Date paramDate)
  {
    this.useDateEnd = paramDate;
  }
  
  public Date getUseDate()
  {
    return this.useDate;
  }
  
  public void setUseDate(Date paramDate)
  {
    this.useDate = paramDate;
  }
  
  public String getCheckFlags()
  {
    return this.checkFlags;
  }
  
  public void setCheckFlags(String paramString)
  {
    this.checkFlags = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getAttribute1Name()
  {
    return this.attribute1Name;
  }
  
  public void setAttribute1Name(String paramString)
  {
    this.attribute1Name = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.FbpVoucherBorrowV
 * JD-Core Version:    0.7.0.1
 */