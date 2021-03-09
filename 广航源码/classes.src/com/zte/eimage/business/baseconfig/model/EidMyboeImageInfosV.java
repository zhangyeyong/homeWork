package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EidMyboeImageInfosV
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
  protected String checkUnit;
  protected String checkUnitName;
  protected String imageStatus;
  protected String imageStatusName;
  protected String appraiseNode;
  protected String appraiseName;
  protected Date appraiseDate;
  protected Long appraiseEmployeeId;
  protected String appraiseEmployeeName;
  protected String memo;
  protected Long imageCount;
  protected String enabledFlag;
  protected String enabledFlagName;
  protected String uploadGroup;
  private Date beginDate;
  private Date endDate;
  private Date fileBeginDate;
  private Date fileEndDate;
  private String uploadEmployee;
  private String blurQuery;
  private String appraiseType;
  private String appraiseTypeName;
  private String appraiseDesc;
  
  public String getAppraiseDesc()
  {
    return this.appraiseDesc;
  }
  
  public void setAppraiseDesc(String paramString)
  {
    this.appraiseDesc = paramString;
  }
  
  public String getAppraiseTypeName()
  {
    return this.appraiseTypeName;
  }
  
  public void setAppraiseTypeName(String paramString)
  {
    this.appraiseTypeName = paramString;
  }
  
  public String getAppraiseType()
  {
    return this.appraiseType;
  }
  
  public void setAppraiseType(String paramString)
  {
    this.appraiseType = paramString;
  }
  
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
  
  public EidMyboeImageInfosV() {}
  
  public EidMyboeImageInfosV(Long paramLong1, String paramString1, Long paramLong2, String paramString2, Long paramLong3, String paramString3, Long paramLong4, String paramString4, Date paramDate1, Long paramLong5, String paramString5, Long paramLong6, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, Date paramDate2, Long paramLong7, String paramString13, String paramString14, Long paramLong8, String paramString15, String paramString16)
  {
    setImageInfoId(paramLong1);
    setImageNumber(paramString1);
    setUploadEmployeeId(paramLong2);
    setEmployeeName(paramString2);
    setJobId(paramLong3);
    setJobName(paramString3);
    setDeptId(paramLong4);
    setDeptName(paramString4);
    setUploadDate(paramDate1);
    setOperationTypeId(paramLong5);
    setOperationTypeName(paramString5);
    setCompanyId(paramLong6);
    setCompanyName(paramString6);
    setCheckUnit(paramString7);
    setCheckUnitName(paramString8);
    setImageStatus(paramString9);
    setImageStatusName(paramString10);
    setAppraiseNode(paramString11);
    setAppraiseName(paramString12);
    setAppraiseDate(paramDate2);
    setAppraiseEmployeeId(paramLong7);
    setAppraiseEmployeeName(paramString13);
    setMemo(paramString14);
    setImageCount(paramLong8);
    setEnabledFlag(paramString15);
    setEnabledFlagName(paramString16);
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
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
  
  public String getCheckUnitName()
  {
    return this.checkUnitName;
  }
  
  public void setCheckUnitName(String paramString)
  {
    this.checkUnitName = paramString;
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
  
  public Date getAppraiseDate()
  {
    return this.appraiseDate;
  }
  
  public void setAppraiseDate(Date paramDate)
  {
    this.appraiseDate = paramDate;
  }
  
  public Long getAppraiseEmployeeId()
  {
    return this.appraiseEmployeeId;
  }
  
  public void setAppraiseEmployeeId(Long paramLong)
  {
    this.appraiseEmployeeId = paramLong;
  }
  
  public String getAppraiseEmployeeName()
  {
    return this.appraiseEmployeeName;
  }
  
  public void setAppraiseEmployeeName(String paramString)
  {
    this.appraiseEmployeeName = paramString;
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
    if (!(paramObject instanceof EidMyboeImageInfosV)) {
      return false;
    }
    EidMyboeImageInfosV localEidMyboeImageInfosV = (EidMyboeImageInfosV)paramObject;
    return new EqualsBuilder().append(this.imageInfoId, localEidMyboeImageInfosV.imageInfoId).append(this.imageNumber, localEidMyboeImageInfosV.imageNumber).append(this.uploadEmployeeId, localEidMyboeImageInfosV.uploadEmployeeId).append(this.employeeName, localEidMyboeImageInfosV.employeeName).append(this.jobId, localEidMyboeImageInfosV.jobId).append(this.jobName, localEidMyboeImageInfosV.jobName).append(this.deptId, localEidMyboeImageInfosV.deptId).append(this.deptName, localEidMyboeImageInfosV.deptName).append(this.uploadDate, localEidMyboeImageInfosV.uploadDate).append(this.operationTypeId, localEidMyboeImageInfosV.operationTypeId).append(this.operationTypeName, localEidMyboeImageInfosV.operationTypeName).append(this.companyId, localEidMyboeImageInfosV.companyId).append(this.companyName, localEidMyboeImageInfosV.companyName).append(this.checkUnit, localEidMyboeImageInfosV.checkUnit).append(this.checkUnitName, localEidMyboeImageInfosV.checkUnitName).append(this.imageStatus, localEidMyboeImageInfosV.imageStatus).append(this.imageStatusName, localEidMyboeImageInfosV.imageStatusName).append(this.appraiseNode, localEidMyboeImageInfosV.appraiseNode).append(this.appraiseName, localEidMyboeImageInfosV.appraiseName).append(this.appraiseDate, localEidMyboeImageInfosV.appraiseDate).append(this.appraiseEmployeeId, localEidMyboeImageInfosV.appraiseEmployeeId).append(this.appraiseEmployeeName, localEidMyboeImageInfosV.appraiseEmployeeName).append(this.memo, localEidMyboeImageInfosV.memo).append(this.imageCount, localEidMyboeImageInfosV.imageCount).append(this.enabledFlag, localEidMyboeImageInfosV.enabledFlag).append(this.enabledFlagName, localEidMyboeImageInfosV.enabledFlagName).append(this.appraiseType, localEidMyboeImageInfosV.appraiseType).append(this.appraiseTypeName, localEidMyboeImageInfosV.appraiseTypeName).append(this.appraiseDesc, localEidMyboeImageInfosV.appraiseDesc).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.imageInfoId).append(this.imageNumber).append(this.uploadEmployeeId).append(this.employeeName).append(this.jobId).append(this.jobName).append(this.deptId).append(this.deptName).append(this.uploadDate).append(this.operationTypeId).append(this.operationTypeName).append(this.companyId).append(this.companyName).append(this.checkUnit).append(this.checkUnitName).append(this.imageStatus).append(this.imageStatusName).append(this.appraiseNode).append(this.appraiseName).append(this.appraiseDate).append(this.appraiseEmployeeId).append(this.appraiseEmployeeName).append(this.memo).append(this.imageCount).append(this.enabledFlag).append(this.enabledFlagName).append(this.appraiseType).append(this.appraiseTypeName).append(this.appraiseDesc).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("imageInfoId", this.imageInfoId).append("imageNumber", this.imageNumber).append("uploadEmployeeId", this.uploadEmployeeId).append("employeeName", this.employeeName).append("jobId", this.jobId).append("jobName", this.jobName).append("deptId", this.deptId).append("deptName", this.deptName).append("uploadDate", this.uploadDate).append("operationTypeId", this.operationTypeId).append("operationTypeName", this.operationTypeName).append("companyId", this.companyId).append("companyName", this.companyName).append("checkUnit", this.checkUnit).append("checkUnitName", this.checkUnitName).append("imageStatus", this.imageStatus).append("imageStatusName", this.imageStatusName).append("appraiseNode", this.appraiseNode).append("appraiseName", this.appraiseName).append("appraiseDate", this.appraiseDate).append("appraiseEmployeeId", this.appraiseEmployeeId).append("appraiseEmployeeName", this.appraiseEmployeeName).append("memo", this.memo).append("imageCount", this.imageCount).append("enabledFlag", this.enabledFlag).append("enabledFlagName", this.enabledFlagName).append("appraiseType", this.appraiseType).append("appraiseTypeName", this.appraiseTypeName).append("appraiseDesc", this.appraiseDesc).toString();
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
  
  public Date getFileBeginDate()
  {
    return this.fileBeginDate;
  }
  
  public void setFileBeginDate(Date paramDate)
  {
    this.fileBeginDate = paramDate;
  }
  
  public Date getFileEndDate()
  {
    return this.fileEndDate;
  }
  
  public void setFileEndDate(Date paramDate)
  {
    this.fileEndDate = paramDate;
  }
  
  public String getUploadGroup()
  {
    return this.uploadGroup;
  }
  
  public void setUploadGroup(String paramString)
  {
    this.uploadGroup = paramString;
  }
  
  public String getTaskNum()
  {
    return this.taskNum;
  }
  
  public void setTaskNum(String paramString)
  {
    this.taskNum = paramString;
  }
  
  public void setUploadEmployee(String paramString)
  {
    this.uploadEmployee = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidMyboeImageInfosV
 * JD-Core Version:    0.7.0.1
 */