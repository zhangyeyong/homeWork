package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;
import java.util.Date;

public class EidImageInfosV
  implements Serializable
{
  private Long imageInfoId;
  private String imageNumber;
  private String taskNum;
  private Long uploadEmployeeId;
  private String employeeName;
  private Long jobId;
  private String jobName;
  private Long deptId;
  private String deptName;
  private Date uploadDate;
  private String checkUnit;
  private String checkUnitName;
  private String imageStatus;
  private String imageStatusName;
  private String appraiseNode;
  private String appraiseName;
  private String memo;
  private Long imageCount;
  private String enabledFlag;
  private String enabledFlagName;
  private Long operationTypeId;
  private String operationTypeName;
  private Long companyId;
  private String companyName;
  private Date beginDate;
  private Date endDate;
  private String uploadEmployee;
  private String blurQuery;
  private String AppraiseType;
  private String appraiseTypeName;
  private String orderBy;
  
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
  
  public String getOrderBy()
  {
    return this.orderBy;
  }
  
  public void setOrderBy(String paramString)
  {
    this.orderBy = paramString;
  }
  
  public EidImageInfosV() {}
  
  public EidImageInfosV(Long paramLong1, String paramString1, Long paramLong2, String paramString2, Long paramLong3, String paramString3, Long paramLong4, String paramString4, Date paramDate1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Long paramLong5, String paramString12, String paramString13, Date paramDate2, Date paramDate3)
  {
    this.imageInfoId = paramLong1;
    this.imageNumber = paramString1;
    this.uploadEmployeeId = paramLong2;
    this.employeeName = paramString2;
    this.jobId = paramLong3;
    this.jobName = paramString3;
    this.deptId = paramLong4;
    this.deptName = paramString4;
    this.uploadDate = paramDate1;
    this.checkUnit = paramString5;
    this.checkUnitName = paramString6;
    this.imageStatus = paramString7;
    this.imageStatusName = paramString8;
    this.appraiseNode = paramString9;
    this.appraiseName = paramString10;
    this.memo = paramString11;
    this.imageCount = paramLong5;
    this.enabledFlag = paramString12;
    this.enabledFlagName = paramString13;
    this.beginDate = paramDate2;
    this.endDate = paramDate3;
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
  
  public Date getUploadDate()
  {
    return this.uploadDate;
  }
  
  public void setUploadDate(Date paramDate)
  {
    this.uploadDate = paramDate;
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
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String paramString)
  {
    if (paramString != null) {
      this.memo = paramString;
    } else {
      this.memo = "";
    }
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
    if (null != paramString) {
      this.deptName = paramString;
    } else {
      this.deptName = "";
    }
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
  
  public String getAppraiseType()
  {
    return this.AppraiseType;
  }
  
  public void setAppraiseType(String paramString)
  {
    this.AppraiseType = paramString;
  }
  
  public String getAppraiseTypeName()
  {
    return this.appraiseTypeName;
  }
  
  public void setAppraiseTypeName(String paramString)
  {
    this.appraiseTypeName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidImageInfosV
 * JD-Core Version:    0.7.0.1
 */