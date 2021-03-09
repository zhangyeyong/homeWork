package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;
import java.util.Date;

public class FbpVoucherApproveVL
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Long archivesHeaderId;
  protected String applyNum;
  protected Date creationDate;
  protected Date creationDateEnd;
  protected Date applyDate;
  protected Date applyDateEnd;
  protected String applyDesc;
  protected Date useDate;
  protected Date giveBackDate;
  protected String archivesStatus;
  protected Long companyId;
  protected String companyCode;
  protected String employeeNumber;
  protected String companyName;
  protected Long employeeId;
  protected String employeeName;
  protected String firstLineNo;
  protected String attribute1;
  protected String attribute2;
  protected String attribute3;
  protected String meaning;
  protected String takeBackDes;
  protected String approveCommand;
  protected String approveComment;
  protected String checkFlags;
  
  public FbpVoucherApproveVL() {}
  
  public FbpVoucherApproveVL(Long paramLong1, String paramString1, Date paramDate1, String paramString2, Date paramDate2, Date paramDate3, String paramString3, Long paramLong2, String paramString4, String paramString5, String paramString6, Long paramLong3, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    setArchivesHeaderId(paramLong1);
    setApplyNum(paramString1);
    setApplyDate(paramDate1);
    setApplyDesc(paramString2);
    setUseDate(paramDate2);
    setGiveBackDate(paramDate3);
    setArchivesStatus(paramString3);
    setCompanyId(paramLong2);
    setCompanyCode(paramString4);
    setEmployeeNumber(paramString5);
    setCompanyName(paramString6);
    setEmployeeId(paramLong3);
    setEmployeeName(paramString7);
    setFirstLineNo(paramString8);
    setAttribute1(paramString9);
    setAttribute2(paramString10);
    setMeaning(paramString11);
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
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
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
  
  public String getFirstLineNo()
  {
    return this.firstLineNo;
  }
  
  public void setFirstLineNo(String paramString)
  {
    this.firstLineNo = paramString;
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
  
  public String getMeaning()
  {
    return this.meaning;
  }
  
  public void setMeaning(String paramString)
  {
    this.meaning = paramString;
  }
  
  public Date getApplyDateEnd()
  {
    return this.applyDateEnd;
  }
  
  public void setApplyDateEnd(Date paramDate)
  {
    this.applyDateEnd = paramDate;
  }
  
  public String getApproveCommand()
  {
    return this.approveCommand;
  }
  
  public void setApproveCommand(String paramString)
  {
    this.approveCommand = paramString;
  }
  
  public String getApproveComment()
  {
    return this.approveComment;
  }
  
  public void setApproveComment(String paramString)
  {
    this.approveComment = paramString;
  }
  
  public String getCheckFlags()
  {
    return this.checkFlags;
  }
  
  public void setCheckFlags(String paramString)
  {
    this.checkFlags = paramString;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public void setAttribute3(String paramString)
  {
    this.attribute3 = paramString;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public String getTakeBackDes()
  {
    return this.takeBackDes;
  }
  
  public void setTakeBackDes(String paramString)
  {
    this.takeBackDes = paramString;
  }
  
  public Date getCreationDateEnd()
  {
    return this.creationDateEnd;
  }
  
  public void setCreationDateEnd(Date paramDate)
  {
    this.creationDateEnd = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.FbpVoucherApproveVL
 * JD-Core Version:    0.7.0.1
 */