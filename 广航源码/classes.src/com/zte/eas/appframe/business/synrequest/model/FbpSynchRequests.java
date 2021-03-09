package com.zte.eas.appframe.business.synrequest.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpSynchRequests
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected Long synchRequestId;
  protected String synchRequestNumber;
  protected String synchType;
  protected Date startDateActive;
  protected Date endDateActive;
  protected String repeatFlag;
  protected Long repeatInterval;
  protected Long maxRepeatTime;
  protected String activeProc;
  protected Long totalTime;
  protected Long failTime;
  protected String status;
  protected Date lastRunTime;
  protected String memo;
  protected String enabledFlag;
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
  
  public FbpSynchRequests() {}
  
  public FbpSynchRequests(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, String paramString1, String paramString2, Date paramDate3, Date paramDate4, String paramString3, Long paramLong5, Long paramLong6, String paramString4, Long paramLong7, Long paramLong8, String paramString5, Date paramDate5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setSynchRequestId(paramLong4);
    setSynchRequestNumber(paramString1);
    setSynchType(paramString2);
    setStartDateActive(paramDate3);
    setEndDateActive(paramDate4);
    setRepeatFlag(paramString3);
    setRepeatInterval(paramLong5);
    setMaxRepeatTime(paramLong6);
    setActiveProc(paramString4);
    setTotalTime(paramLong7);
    setFailTime(paramLong8);
    setStatus(paramString5);
    setLastRunTime(paramDate5);
    setMemo(paramString6);
    setEnabledFlag(paramString7);
    setAttribute1(paramString8);
    setAttribute2(paramString9);
    setAttribute3(paramString10);
    setAttribute4(paramString11);
    setAttribute5(paramString12);
    setAttribute6(paramString13);
    setAttribute7(paramString14);
    setAttribute8(paramString15);
    setAttribute9(paramString16);
    setAttribute10(paramString17);
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
  
  public Date getLastRunTime()
  {
    return this.lastRunTime;
  }
  
  public void setLastRunTime(Date paramDate)
  {
    this.lastRunTime = paramDate;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
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
    if (!(paramObject instanceof FbpSynchRequests)) {
      return false;
    }
    FbpSynchRequests localFbpSynchRequests = (FbpSynchRequests)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpSynchRequests.lastUpdateDate).append(this.lastUpdatedBy, localFbpSynchRequests.lastUpdatedBy).append(this.creationDate, localFbpSynchRequests.creationDate).append(this.createdBy, localFbpSynchRequests.createdBy).append(this.lastUpdateLogin, localFbpSynchRequests.lastUpdateLogin).append(this.synchRequestId, localFbpSynchRequests.synchRequestId).append(this.synchRequestNumber, localFbpSynchRequests.synchRequestNumber).append(this.synchType, localFbpSynchRequests.synchType).append(this.startDateActive, localFbpSynchRequests.startDateActive).append(this.endDateActive, localFbpSynchRequests.endDateActive).append(this.repeatFlag, localFbpSynchRequests.repeatFlag).append(this.repeatInterval, localFbpSynchRequests.repeatInterval).append(this.maxRepeatTime, localFbpSynchRequests.maxRepeatTime).append(this.activeProc, localFbpSynchRequests.activeProc).append(this.totalTime, localFbpSynchRequests.totalTime).append(this.failTime, localFbpSynchRequests.failTime).append(this.status, localFbpSynchRequests.status).append(this.lastRunTime, localFbpSynchRequests.lastRunTime).append(this.memo, localFbpSynchRequests.memo).append(this.enabledFlag, localFbpSynchRequests.enabledFlag).append(this.attribute1, localFbpSynchRequests.attribute1).append(this.attribute2, localFbpSynchRequests.attribute2).append(this.attribute3, localFbpSynchRequests.attribute3).append(this.attribute4, localFbpSynchRequests.attribute4).append(this.attribute5, localFbpSynchRequests.attribute5).append(this.attribute6, localFbpSynchRequests.attribute6).append(this.attribute7, localFbpSynchRequests.attribute7).append(this.attribute8, localFbpSynchRequests.attribute8).append(this.attribute9, localFbpSynchRequests.attribute9).append(this.attribute10, localFbpSynchRequests.attribute10).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.synchRequestId).append(this.synchRequestNumber).append(this.synchType).append(this.startDateActive).append(this.endDateActive).append(this.repeatFlag).append(this.repeatInterval).append(this.maxRepeatTime).append(this.activeProc).append(this.totalTime).append(this.failTime).append(this.status).append(this.lastRunTime).append(this.memo).append(this.enabledFlag).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("synchRequestId", this.synchRequestId).append("synchRequestNumber", this.synchRequestNumber).append("synchType", this.synchType).append("startDateActive", this.startDateActive).append("endDateActive", this.endDateActive).append("repeatFlag", this.repeatFlag).append("repeatInterval", this.repeatInterval).append("maxRepeatTime", this.maxRepeatTime).append("activeProc", this.activeProc).append("totalTime", this.totalTime).append("failTime", this.failTime).append("status", this.status).append("lastRunTime", this.lastRunTime).append("memo", this.memo).append("enabledFlag", this.enabledFlag).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "synchRequestId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.synrequest.model.FbpSynchRequests
 * JD-Core Version:    0.7.0.1
 */