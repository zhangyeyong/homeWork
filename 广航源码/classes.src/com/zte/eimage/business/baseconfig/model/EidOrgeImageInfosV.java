package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EidOrgeImageInfosV
  extends BaseObject
  implements Serializable
{
  protected Long imageInfoId;
  protected String imageNumber;
  protected String taskNum;
  protected Long uploadEmployeeId;
  protected String employeeName;
  protected Long jobId;
  protected String jobName;
  protected Long deptId;
  protected String deptName;
  protected Date uploadDate;
  protected Long operationTypeId;
  protected String operationTypeName;
  protected Long companyId;
  protected String companyName;
  protected String imageStatus;
  protected String imageStatusName;
  protected String appraiseNode;
  protected String appraiseName;
  protected String memo;
  protected Long imageCount;
  protected String enabledFlag;
  protected String enabledFlagName;
  private Date beginDate;
  private Date endDate;
  private String uploadEmployee;
  private String blurQuery;
  
  public String getBlurQuery()
  {
    return this.blurQuery;
  }
  
  public void setBlurQuery(String paramString)
  {
    this.blurQuery = paramString;
  }
  
  public String getUploadEmployee()
  {
    return this.employeeName + "/" + this.deptName;
  }
  
  public EidOrgeImageInfosV() {}
  
  public EidOrgeImageInfosV(Long paramLong1, String paramString1, Long paramLong2, String paramString2, Long paramLong3, String paramString3, Long paramLong4, String paramString4, Date paramDate, Long paramLong5, String paramString5, Long paramLong6, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Long paramLong7, String paramString12, String paramString13)
  {
    setImageInfoId(paramLong1);
    setImageNumber(paramString1);
    setUploadEmployeeId(paramLong2);
    setEmployeeName(paramString2);
    setJobId(paramLong3);
    setJobName(paramString3);
    setDeptId(paramLong4);
    setDeptName(paramString4);
    setUploadDate(paramDate);
    setOperationTypeId(paramLong5);
    setOperationTypeName(paramString5);
    setCompanyId(paramLong6);
    setCompanyName(paramString6);
    setImageStatus(paramString7);
    setImageStatusName(paramString8);
    setAppraiseNode(paramString9);
    setAppraiseName(paramString10);
    setMemo(paramString11);
    setImageCount(paramLong7);
    setEnabledFlag(paramString12);
    setEnabledFlagName(paramString13);
  }
  
  public Long getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(Long paramLong)
  {
    this.imageInfoId = paramLong;
  }
  
  public String getImageNumber()
  {
    return this.imageNumber;
  }
  
  public void setImageNumber(String paramString)
  {
    this.imageNumber = paramString;
  }
  
  public Long getUploadEmployeeId()
  {
    return this.uploadEmployeeId;
  }
  
  public void setUploadEmployeeId(Long paramLong)
  {
    this.uploadEmployeeId = paramLong;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public Long getJobId()
  {
    return this.jobId;
  }
  
  public void setJobId(Long paramLong)
  {
    this.jobId = paramLong;
  }
  
  public String getJobName()
  {
    return this.jobName;
  }
  
  public void setJobName(String paramString)
  {
    if (null != paramString) {
      this.jobName = paramString;
    } else {
      this.jobName = " ";
    }
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
  
  public Date getUploadDate()
  {
    return this.uploadDate;
  }
  
  public void setUploadDate(Date paramDate)
  {
    this.uploadDate = paramDate;
  }
  
  public Long getOperationTypeId()
  {
    return this.operationTypeId;
  }
  
  public void setOperationTypeId(Long paramLong)
  {
    this.operationTypeId = paramLong;
  }
  
  public String getOperationTypeName()
  {
    return this.operationTypeName;
  }
  
  public void setOperationTypeName(String paramString)
  {
    this.operationTypeName = paramString;
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
  
  public String getImageStatus()
  {
    return this.imageStatus;
  }
  
  public void setImageStatus(String paramString)
  {
    this.imageStatus = paramString;
  }
  
  public String getImageStatusName()
  {
    return this.imageStatusName;
  }
  
  public void setImageStatusName(String paramString)
  {
    this.imageStatusName = paramString;
  }
  
  public String getAppraiseNode()
  {
    return this.appraiseNode;
  }
  
  public void setAppraiseNode(String paramString)
  {
    this.appraiseNode = paramString;
  }
  
  public String getAppraiseName()
  {
    return this.appraiseName;
  }
  
  public void setAppraiseName(String paramString)
  {
    this.appraiseName = paramString;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public Long getImageCount()
  {
    return this.imageCount;
  }
  
  public void setImageCount(Long paramLong)
  {
    this.imageCount = paramLong;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getEnabledFlagName()
  {
    return this.enabledFlagName;
  }
  
  public void setEnabledFlagName(String paramString)
  {
    this.enabledFlagName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EidOrgeImageInfosV)) {
      return false;
    }
    EidOrgeImageInfosV localEidOrgeImageInfosV = (EidOrgeImageInfosV)paramObject;
    return new EqualsBuilder().append(this.imageInfoId, localEidOrgeImageInfosV.imageInfoId).append(this.imageNumber, localEidOrgeImageInfosV.imageNumber).append(this.uploadEmployeeId, localEidOrgeImageInfosV.uploadEmployeeId).append(this.employeeName, localEidOrgeImageInfosV.employeeName).append(this.jobId, localEidOrgeImageInfosV.jobId).append(this.jobName, localEidOrgeImageInfosV.jobName).append(this.deptId, localEidOrgeImageInfosV.deptId).append(this.deptName, localEidOrgeImageInfosV.deptName).append(this.uploadDate, localEidOrgeImageInfosV.uploadDate).append(this.operationTypeId, localEidOrgeImageInfosV.operationTypeId).append(this.operationTypeName, localEidOrgeImageInfosV.operationTypeName).append(this.companyId, localEidOrgeImageInfosV.companyId).append(this.companyName, localEidOrgeImageInfosV.companyName).append(this.imageStatus, localEidOrgeImageInfosV.imageStatus).append(this.imageStatusName, localEidOrgeImageInfosV.imageStatusName).append(this.appraiseNode, localEidOrgeImageInfosV.appraiseNode).append(this.appraiseName, localEidOrgeImageInfosV.appraiseName).append(this.memo, localEidOrgeImageInfosV.memo).append(this.imageCount, localEidOrgeImageInfosV.imageCount).append(this.enabledFlag, localEidOrgeImageInfosV.enabledFlag).append(this.enabledFlagName, localEidOrgeImageInfosV.enabledFlagName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.imageInfoId).append(this.imageNumber).append(this.uploadEmployeeId).append(this.employeeName).append(this.jobId).append(this.jobName).append(this.deptId).append(this.deptName).append(this.uploadDate).append(this.operationTypeId).append(this.operationTypeName).append(this.companyId).append(this.companyName).append(this.imageStatus).append(this.imageStatusName).append(this.appraiseNode).append(this.appraiseName).append(this.memo).append(this.imageCount).append(this.enabledFlag).append(this.enabledFlagName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("imageInfoId", this.imageInfoId).append("imageNumber", this.imageNumber).append("uploadEmployeeId", this.uploadEmployeeId).append("employeeName", this.employeeName).append("jobId", this.jobId).append("jobName", this.jobName).append("deptId", this.deptId).append("deptName", this.deptName).append("uploadDate", this.uploadDate).append("operationTypeId", this.operationTypeId).append("operationTypeName", this.operationTypeName).append("companyId", this.companyId).append("companyName", this.companyName).append("imageStatus", this.imageStatus).append("imageStatusName", this.imageStatusName).append("appraiseNode", this.appraiseNode).append("appraiseName", this.appraiseName).append("memo", this.memo).append("imageCount", this.imageCount).append("enabledFlag", this.enabledFlag).append("enabledFlagName", this.enabledFlagName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public Date getBeginDate()
  {
    return this.beginDate;
  }
  
  public void setBeginDate(Date paramDate)
  {
    this.beginDate = paramDate;
  }
  
  public Date getEndDate()
  {
    return this.endDate;
  }
  
  public void setEndDate(Date paramDate)
  {
    this.endDate = paramDate;
  }
  
  public String getTaskNum()
  {
    return this.taskNum;
  }
  
  public void setTaskNum(String paramString)
  {
    this.taskNum = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidOrgeImageInfosV
 * JD-Core Version:    0.7.0.1
 */