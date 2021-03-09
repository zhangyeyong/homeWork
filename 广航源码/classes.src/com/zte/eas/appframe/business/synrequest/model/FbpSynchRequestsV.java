package com.zte.eas.appframe.business.synrequest.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpSynchRequestsV
  extends BaseObject
  implements Serializable
{
  protected String rowId;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected String submiter;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected Long synchRequestId;
  protected String synchRequestNumber;
  protected String synchType;
  protected String synchRequestName;
  protected Date startDateActive;
  protected Date endDateActive;
  protected String repeatFlag;
  protected Long repeatInterval;
  protected Long maxRepeatTime;
  protected String activeProc;
  protected String memo;
  protected Long totalTime;
  protected Long failTime;
  protected String status;
  protected String statusName;
  protected Date lastRunTime;
  protected String enabledFlag;
  protected String successFlag;
  protected Date runDate;
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
  
  public FbpSynchRequestsV() {}
  
  public FbpSynchRequestsV(String paramString1, Date paramDate1, Long paramLong1, String paramString2, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, String paramString3, String paramString4, String paramString5, Date paramDate3, Date paramDate4, String paramString6, Long paramLong5, Long paramLong6, String paramString7, String paramString8, Long paramLong7, Long paramLong8, String paramString9, String paramString10, Date paramDate5, String paramString11, String paramString12, Date paramDate6, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
  {
    setRowId(paramString1);
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setSubmiter(paramString2);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setSynchRequestId(paramLong4);
    setSynchRequestNumber(paramString3);
    setSynchType(paramString4);
    setSynchRequestName(paramString5);
    setStartDateActive(paramDate3);
    setEndDateActive(paramDate4);
    setRepeatFlag(paramString6);
    setRepeatInterval(paramLong5);
    setMaxRepeatTime(paramLong6);
    setActiveProc(paramString7);
    setMemo(paramString8);
    setTotalTime(paramLong7);
    setFailTime(paramLong8);
    setStatus(paramString9);
    setStatusName(paramString10);
    setLastRunTime(paramDate5);
    setEnabledFlag(paramString11);
    setSuccessFlag(paramString12);
    setRunDate(paramDate6);
    setAttribute1(paramString13);
    setAttribute2(paramString14);
    setAttribute3(paramString15);
    setAttribute4(paramString16);
    setAttribute5(paramString17);
    setAttribute6(paramString18);
    setAttribute7(paramString19);
    setAttribute8(paramString20);
    setAttribute9(paramString21);
    setAttribute10(paramString22);
  }
  
  public String getRowId()
  {
    return this.rowId;
  }
  
  public void setRowId(String paramString)
  {
    this.rowId = paramString;
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
  
  public String getSubmiter()
  {
    return this.submiter;
  }
  
  public void setSubmiter(String paramString)
  {
    this.submiter = paramString;
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
  
  public Long getSynchRequestId()
  {
    return this.synchRequestId;
  }
  
  public void setSynchRequestId(Long paramLong)
  {
    this.synchRequestId = paramLong;
  }
  
  public String getSynchRequestNumber()
  {
    return this.synchRequestNumber;
  }
  
  public void setSynchRequestNumber(String paramString)
  {
    this.synchRequestNumber = paramString;
  }
  
  public String getSynchType()
  {
    return this.synchType;
  }
  
  public void setSynchType(String paramString)
  {
    this.synchType = paramString;
  }
  
  public String getSynchRequestName()
  {
    return this.synchRequestName;
  }
  
  public void setSynchRequestName(String paramString)
  {
    this.synchRequestName = paramString;
  }
  
  public Date getStartDateActive()
  {
    return this.startDateActive;
  }
  
  public void setStartDateActive(Date paramDate)
  {
    this.startDateActive = paramDate;
  }
  
  public Date getEndDateActive()
  {
    return this.endDateActive;
  }
  
  public void setEndDateActive(Date paramDate)
  {
    this.endDateActive = paramDate;
  }
  
  public String getRepeatFlag()
  {
    return this.repeatFlag;
  }
  
  public void setRepeatFlag(String paramString)
  {
    this.repeatFlag = paramString;
  }
  
  public Long getRepeatInterval()
  {
    return this.repeatInterval;
  }
  
  public void setRepeatInterval(Long paramLong)
  {
    this.repeatInterval = paramLong;
  }
  
  public Long getMaxRepeatTime()
  {
    return this.maxRepeatTime;
  }
  
  public void setMaxRepeatTime(Long paramLong)
  {
    this.maxRepeatTime = paramLong;
  }
  
  public String getActiveProc()
  {
    return this.activeProc;
  }
  
  public void setActiveProc(String paramString)
  {
    this.activeProc = paramString;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public Long getTotalTime()
  {
    return this.totalTime;
  }
  
  public void setTotalTime(Long paramLong)
  {
    this.totalTime = paramLong;
  }
  
  public Long getFailTime()
  {
    return this.failTime;
  }
  
  public void setFailTime(Long paramLong)
  {
    this.failTime = paramLong;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public String getStatusName()
  {
    return this.statusName;
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public Date getLastRunTime()
  {
    return this.lastRunTime;
  }
  
  public void setLastRunTime(Date paramDate)
  {
    this.lastRunTime = paramDate;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getSuccessFlag()
  {
    return this.successFlag;
  }
  
  public void setSuccessFlag(String paramString)
  {
    this.successFlag = paramString;
  }
  
  public Date getRunDate()
  {
    return this.runDate;
  }
  
  public void setRunDate(Date paramDate)
  {
    this.runDate = paramDate;
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
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpSynchRequestsV)) {
      return false;
    }
    FbpSynchRequestsV localFbpSynchRequestsV = (FbpSynchRequestsV)paramObject;
    return new EqualsBuilder().append(this.rowId, localFbpSynchRequestsV.rowId).append(this.lastUpdateDate, localFbpSynchRequestsV.lastUpdateDate).append(this.lastUpdatedBy, localFbpSynchRequestsV.lastUpdatedBy).append(this.submiter, localFbpSynchRequestsV.submiter).append(this.creationDate, localFbpSynchRequestsV.creationDate).append(this.createdBy, localFbpSynchRequestsV.createdBy).append(this.lastUpdateLogin, localFbpSynchRequestsV.lastUpdateLogin).append(this.synchRequestId, localFbpSynchRequestsV.synchRequestId).append(this.synchRequestNumber, localFbpSynchRequestsV.synchRequestNumber).append(this.synchType, localFbpSynchRequestsV.synchType).append(this.synchRequestName, localFbpSynchRequestsV.synchRequestName).append(this.startDateActive, localFbpSynchRequestsV.startDateActive).append(this.endDateActive, localFbpSynchRequestsV.endDateActive).append(this.repeatFlag, localFbpSynchRequestsV.repeatFlag).append(this.repeatInterval, localFbpSynchRequestsV.repeatInterval).append(this.maxRepeatTime, localFbpSynchRequestsV.maxRepeatTime).append(this.activeProc, localFbpSynchRequestsV.activeProc).append(this.memo, localFbpSynchRequestsV.memo).append(this.totalTime, localFbpSynchRequestsV.totalTime).append(this.failTime, localFbpSynchRequestsV.failTime).append(this.status, localFbpSynchRequestsV.status).append(this.statusName, localFbpSynchRequestsV.statusName).append(this.lastRunTime, localFbpSynchRequestsV.lastRunTime).append(this.enabledFlag, localFbpSynchRequestsV.enabledFlag).append(this.successFlag, localFbpSynchRequestsV.successFlag).append(this.runDate, localFbpSynchRequestsV.runDate).append(this.attribute1, localFbpSynchRequestsV.attribute1).append(this.attribute2, localFbpSynchRequestsV.attribute2).append(this.attribute3, localFbpSynchRequestsV.attribute3).append(this.attribute4, localFbpSynchRequestsV.attribute4).append(this.attribute5, localFbpSynchRequestsV.attribute5).append(this.attribute6, localFbpSynchRequestsV.attribute6).append(this.attribute7, localFbpSynchRequestsV.attribute7).append(this.attribute8, localFbpSynchRequestsV.attribute8).append(this.attribute9, localFbpSynchRequestsV.attribute9).append(this.attribute10, localFbpSynchRequestsV.attribute10).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.rowId).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.submiter).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.synchRequestId).append(this.synchRequestNumber).append(this.synchType).append(this.synchRequestName).append(this.startDateActive).append(this.endDateActive).append(this.repeatFlag).append(this.repeatInterval).append(this.maxRepeatTime).append(this.activeProc).append(this.memo).append(this.totalTime).append(this.failTime).append(this.status).append(this.statusName).append(this.lastRunTime).append(this.enabledFlag).append(this.successFlag).append(this.runDate).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("rowId", this.rowId).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("submiter", this.submiter).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("synchRequestId", this.synchRequestId).append("synchRequestNumber", this.synchRequestNumber).append("synchType", this.synchType).append("synchRequestName", this.synchRequestName).append("startDateActive", this.startDateActive).append("endDateActive", this.endDateActive).append("repeatFlag", this.repeatFlag).append("repeatInterval", this.repeatInterval).append("maxRepeatTime", this.maxRepeatTime).append("activeProc", this.activeProc).append("memo", this.memo).append("totalTime", this.totalTime).append("failTime", this.failTime).append("status", this.status).append("statusName", this.statusName).append("lastRunTime", this.lastRunTime).append("enabledFlag", this.enabledFlag).append("successFlag", this.successFlag).append("runDate", this.runDate).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV
 * JD-Core Version:    0.7.0.1
 */