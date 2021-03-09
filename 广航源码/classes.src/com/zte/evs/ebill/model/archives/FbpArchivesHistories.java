package com.zte.evs.ebill.model.archives;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpArchivesHistories
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long archivesHistoriesId;
  protected Long archivesHeaderId;
  protected Long employeeId;
  protected String employeeNumber;
  protected String employeeName;
  protected String approveCommand;
  protected String approveComment;
  protected String archivesStatus;
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
  protected Long processId;
  protected Long workItemId;
  
  public FbpArchivesHistories() {}
  
  public FbpArchivesHistories(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, Long paramLong5, Long paramLong6, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, Long paramLong7, Long paramLong8, Long paramLong9, Long paramLong10, Long paramLong11, Long paramLong12, Long paramLong13, Long paramLong14, Long paramLong15, Long paramLong16, Date paramDate3, Date paramDate4, Date paramDate5, Date paramDate6, Date paramDate7, Date paramDate8, Date paramDate9, Date paramDate10, Date paramDate11, Date paramDate12)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setArchivesHistoriesId(paramLong4);
    setArchivesHeaderId(paramLong5);
    setEmployeeId(paramLong6);
    setEmployeeNumber(paramString2);
    setEmployeeName(paramString3);
    setApproveCommand(paramString4);
    setApproveComment(paramString5);
    setArchivesStatus(paramString6);
    setAttribute1(paramString7);
    setAttribute2(paramString8);
    setAttribute3(paramString9);
    setAttribute4(paramString10);
    setAttribute5(paramString11);
    setAttribute6(paramString12);
    setAttribute7(paramString13);
    setAttribute8(paramString14);
    setAttribute9(paramString15);
    setAttribute10(paramString16);
    setNumberAttribute1(paramLong7);
    setNumberAttribute2(paramLong8);
    setNumberAttribute3(paramLong9);
    setNumberAttribute4(paramLong10);
    setNumberAttribute5(paramLong11);
    setNumberAttribute6(paramLong12);
    setNumberAttribute7(paramLong13);
    setNumberAttribute8(paramLong14);
    setNumberAttribute9(paramLong15);
    setNumberAttribute10(paramLong16);
    setDateAttribute1(paramDate3);
    setDateAttribute2(paramDate4);
    setDateAttribute3(paramDate5);
    setDateAttribute4(paramDate6);
    setDateAttribute5(paramDate7);
    setDateAttribute6(paramDate8);
    setDateAttribute7(paramDate9);
    setDateAttribute8(paramDate10);
    setDateAttribute9(paramDate11);
    setDateAttribute10(paramDate12);
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
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
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpArchivesHistories)) {
      return false;
    }
    FbpArchivesHistories localFbpArchivesHistories = (FbpArchivesHistories)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpArchivesHistories.lastUpdateDate).append(this.lastUpdatedBy, localFbpArchivesHistories.lastUpdatedBy).append(this.creationDate, localFbpArchivesHistories.creationDate).append(this.createdBy, localFbpArchivesHistories.createdBy).append(this.lastUpdateLogin, localFbpArchivesHistories.lastUpdateLogin).append(this.enabledFlag, localFbpArchivesHistories.enabledFlag).append(this.archivesHistoriesId, localFbpArchivesHistories.archivesHistoriesId).append(this.archivesHeaderId, localFbpArchivesHistories.archivesHeaderId).append(this.employeeId, localFbpArchivesHistories.employeeId).append(this.employeeNumber, localFbpArchivesHistories.employeeNumber).append(this.employeeName, localFbpArchivesHistories.employeeName).append(this.approveCommand, localFbpArchivesHistories.approveCommand).append(this.approveComment, localFbpArchivesHistories.approveComment).append(this.archivesStatus, localFbpArchivesHistories.archivesStatus).append(this.attribute1, localFbpArchivesHistories.attribute1).append(this.attribute2, localFbpArchivesHistories.attribute2).append(this.attribute3, localFbpArchivesHistories.attribute3).append(this.attribute4, localFbpArchivesHistories.attribute4).append(this.attribute5, localFbpArchivesHistories.attribute5).append(this.attribute6, localFbpArchivesHistories.attribute6).append(this.attribute7, localFbpArchivesHistories.attribute7).append(this.attribute8, localFbpArchivesHistories.attribute8).append(this.attribute9, localFbpArchivesHistories.attribute9).append(this.attribute10, localFbpArchivesHistories.attribute10).append(this.numberAttribute1, localFbpArchivesHistories.numberAttribute1).append(this.numberAttribute2, localFbpArchivesHistories.numberAttribute2).append(this.numberAttribute3, localFbpArchivesHistories.numberAttribute3).append(this.numberAttribute4, localFbpArchivesHistories.numberAttribute4).append(this.numberAttribute5, localFbpArchivesHistories.numberAttribute5).append(this.numberAttribute6, localFbpArchivesHistories.numberAttribute6).append(this.numberAttribute7, localFbpArchivesHistories.numberAttribute7).append(this.numberAttribute8, localFbpArchivesHistories.numberAttribute8).append(this.numberAttribute9, localFbpArchivesHistories.numberAttribute9).append(this.numberAttribute10, localFbpArchivesHistories.numberAttribute10).append(this.dateAttribute1, localFbpArchivesHistories.dateAttribute1).append(this.dateAttribute2, localFbpArchivesHistories.dateAttribute2).append(this.dateAttribute3, localFbpArchivesHistories.dateAttribute3).append(this.dateAttribute4, localFbpArchivesHistories.dateAttribute4).append(this.dateAttribute5, localFbpArchivesHistories.dateAttribute5).append(this.dateAttribute6, localFbpArchivesHistories.dateAttribute6).append(this.dateAttribute7, localFbpArchivesHistories.dateAttribute7).append(this.dateAttribute8, localFbpArchivesHistories.dateAttribute8).append(this.dateAttribute9, localFbpArchivesHistories.dateAttribute9).append(this.dateAttribute10, localFbpArchivesHistories.dateAttribute10).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.archivesHistoriesId).append(this.archivesHeaderId).append(this.employeeId).append(this.employeeNumber).append(this.employeeName).append(this.approveCommand).append(this.approveComment).append(this.archivesStatus).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.numberAttribute1).append(this.numberAttribute2).append(this.numberAttribute3).append(this.numberAttribute4).append(this.numberAttribute5).append(this.numberAttribute6).append(this.numberAttribute7).append(this.numberAttribute8).append(this.numberAttribute9).append(this.numberAttribute10).append(this.dateAttribute1).append(this.dateAttribute2).append(this.dateAttribute3).append(this.dateAttribute4).append(this.dateAttribute5).append(this.dateAttribute6).append(this.dateAttribute7).append(this.dateAttribute8).append(this.dateAttribute9).append(this.dateAttribute10).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("archivesHistoriesId", this.archivesHistoriesId).append("archivesHeaderId", this.archivesHeaderId).append("employeeId", this.employeeId).append("employeeNumber", this.employeeNumber).append("employeeName", this.employeeName).append("approveCommand", this.approveCommand).append("approveComment", this.approveComment).append("archivesStatus", this.archivesStatus).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("numberAttribute1", this.numberAttribute1).append("numberAttribute2", this.numberAttribute2).append("numberAttribute3", this.numberAttribute3).append("numberAttribute4", this.numberAttribute4).append("numberAttribute5", this.numberAttribute5).append("numberAttribute6", this.numberAttribute6).append("numberAttribute7", this.numberAttribute7).append("numberAttribute8", this.numberAttribute8).append("numberAttribute9", this.numberAttribute9).append("numberAttribute10", this.numberAttribute10).append("dateAttribute1", this.dateAttribute1).append("dateAttribute2", this.dateAttribute2).append("dateAttribute3", this.dateAttribute3).append("dateAttribute4", this.dateAttribute4).append("dateAttribute5", this.dateAttribute5).append("dateAttribute6", this.dateAttribute6).append("dateAttribute7", this.dateAttribute7).append("dateAttribute8", this.dateAttribute8).append("dateAttribute9", this.dateAttribute9).append("dateAttribute10", this.dateAttribute10).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "archivesHistoriesId";
  }
  
  public Long getProcessId()
  {
    return this.processId;
  }
  
  public void setProcessId(Long paramLong)
  {
    this.processId = paramLong;
  }
  
  public Long getWorkItemId()
  {
    return this.workItemId;
  }
  
  public void setWorkItemId(Long paramLong)
  {
    this.workItemId = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.archives.FbpArchivesHistories
 * JD-Core Version:    0.7.0.1
 */