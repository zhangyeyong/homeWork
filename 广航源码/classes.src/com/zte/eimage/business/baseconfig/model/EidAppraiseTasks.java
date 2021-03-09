package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EidAppraiseTasks
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long appraiseTaskId;
  protected String taskType;
  protected String imageNum;
  protected Long imageCount;
  protected String ftpPath;
  protected String imageMemo;
  protected String taskDesc;
  protected Long ftpId;
  protected String taskStatus;
  
  public EidAppraiseTasks() {}
  
  public EidAppraiseTasks(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, String paramString3, Long paramLong5, String paramString4, String paramString5, String paramString6, Long paramLong6, String paramString7)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setAppraiseTaskId(paramLong4);
    setTaskType(paramString2);
    setImageNum(paramString3);
    setImageCount(paramLong5);
    setFtpPath(paramString4);
    setImageMemo(paramString5);
    setTaskDesc(paramString6);
    setFtpId(paramLong6);
    setTaskStatus(paramString7);
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
  
  public Long getAppraiseTaskId()
  {
    return this.appraiseTaskId;
  }
  
  public void setAppraiseTaskId(Long paramLong)
  {
    this.appraiseTaskId = paramLong;
  }
  
  public String getTaskType()
  {
    return this.taskType;
  }
  
  public void setTaskType(String paramString)
  {
    this.taskType = paramString;
  }
  
  public String getImageNum()
  {
    return this.imageNum;
  }
  
  public void setImageNum(String paramString)
  {
    this.imageNum = paramString;
  }
  
  public Long getImageCount()
  {
    return this.imageCount;
  }
  
  public void setImageCount(Long paramLong)
  {
    this.imageCount = paramLong;
  }
  
  public String getFtpPath()
  {
    return this.ftpPath;
  }
  
  public void setFtpPath(String paramString)
  {
    this.ftpPath = paramString;
  }
  
  public String getImageMemo()
  {
    return this.imageMemo;
  }
  
  public void setImageMemo(String paramString)
  {
    this.imageMemo = paramString;
  }
  
  public String getTaskDesc()
  {
    return this.taskDesc;
  }
  
  public void setTaskDesc(String paramString)
  {
    this.taskDesc = paramString;
  }
  
  public Long getFtpId()
  {
    return this.ftpId;
  }
  
  public void setFtpId(Long paramLong)
  {
    this.ftpId = paramLong;
  }
  
  public String getTaskStatus()
  {
    return this.taskStatus;
  }
  
  public void setTaskStatus(String paramString)
  {
    this.taskStatus = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EidAppraiseTasks)) {
      return false;
    }
    EidAppraiseTasks localEidAppraiseTasks = (EidAppraiseTasks)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localEidAppraiseTasks.lastUpdateDate).append(this.lastUpdatedBy, localEidAppraiseTasks.lastUpdatedBy).append(this.creationDate, localEidAppraiseTasks.creationDate).append(this.createdBy, localEidAppraiseTasks.createdBy).append(this.lastUpdateLogin, localEidAppraiseTasks.lastUpdateLogin).append(this.enabledFlag, localEidAppraiseTasks.enabledFlag).append(this.appraiseTaskId, localEidAppraiseTasks.appraiseTaskId).append(this.taskType, localEidAppraiseTasks.taskType).append(this.imageNum, localEidAppraiseTasks.imageNum).append(this.imageCount, localEidAppraiseTasks.imageCount).append(this.ftpPath, localEidAppraiseTasks.ftpPath).append(this.imageMemo, localEidAppraiseTasks.imageMemo).append(this.taskDesc, localEidAppraiseTasks.taskDesc).append(this.ftpId, localEidAppraiseTasks.ftpId).append(this.taskStatus, localEidAppraiseTasks.taskStatus).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.appraiseTaskId).append(this.taskType).append(this.imageNum).append(this.imageCount).append(this.ftpPath).append(this.imageMemo).append(this.taskDesc).append(this.ftpId).append(this.taskStatus).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("appraiseTaskId", this.appraiseTaskId).append("taskType", this.taskType).append("imageNum", this.imageNum).append("imageCount", this.imageCount).append("ftpPath", this.ftpPath).append("imageMemo", this.imageMemo).append("taskDesc", this.taskDesc).append("ftpId", this.ftpId).append("taskStatus", this.taskStatus).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "appraiseTaskId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidAppraiseTasks
 * JD-Core Version:    0.7.0.1
 */