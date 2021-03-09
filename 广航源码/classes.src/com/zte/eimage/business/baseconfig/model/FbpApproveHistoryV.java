package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;
import java.util.Date;

public class FbpApproveHistoryV
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Long archivesHistoriesId;
  protected Long archivesHeaderId;
  protected Long employeeId;
  protected String employeeNumber;
  protected String approveEmployeeName;
  protected String employeeName;
  protected Date creationDate;
  protected String approveCommand;
  protected String attribute8;
  protected String approveComment;
  protected String applyNum;
  protected Date applyDate;
  protected Date useDate;
  protected Date giveBackDate;
  protected String attribute1;
  protected String attribute2;
  protected String companyName;
  protected String archivesStatus;
  protected String meaning;
  
  public FbpApproveHistoryV() {}
  
  public FbpApproveHistoryV(Long paramLong1, Long paramLong2, Long paramLong3, String paramString1, String paramString2, Date paramDate1, String paramString3, String paramString4, String paramString5, Date paramDate2, Date paramDate3, Date paramDate4, String paramString6, String paramString7, String paramString8)
  {
    setArchivesHistoriesId(paramLong1);
    setArchivesHeaderId(paramLong2);
    setEmployeeId(paramLong3);
    setEmployeeNumber(paramString1);
    setEmployeeName(paramString2);
    setCreationDate(paramDate1);
    setApproveCommand(paramString3);
    setApproveComment(paramString4);
    setApplyNum(paramString5);
    setApplyDate(paramDate2);
    setUseDate(paramDate3);
    setGiveBackDate(paramDate4);
    setCompanyName(paramString6);
    setArchivesStatus(paramString7);
    setMeaning(paramString8);
  }
  
  public Long getArchivesHistoriesId()
  {
    return this.archivesHistoriesId;
  }
  
  public void setArchivesHistoriesId(Long paramLong)
  {
    this.archivesHistoriesId = paramLong;
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
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
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
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getArchivesStatus()
  {
    return this.archivesStatus;
  }
  
  public void setArchivesStatus(String paramString)
  {
    this.archivesStatus = paramString;
  }
  
  public String getMeaning()
  {
    return this.meaning;
  }
  
  public void setMeaning(String paramString)
  {
    this.meaning = paramString;
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
  
  public String getAttribute8()
  {
    return this.attribute8;
  }
  
  public void setAttribute8(String paramString)
  {
    this.attribute8 = paramString;
  }
  
  public String getApproveEmployeeName()
  {
    return this.approveEmployeeName;
  }
  
  public void setApproveEmployeeName(String paramString)
  {
    this.approveEmployeeName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.FbpApproveHistoryV
 * JD-Core Version:    0.7.0.1
 */