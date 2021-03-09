package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;
import java.util.Date;

public class EidAppraiseHistoryV
  implements Serializable
{
  protected Long appraiseHistoryId;
  protected Long imageInfoId;
  protected String imageNumber;
  protected String taskNum;
  protected Long uploadEmployeeId;
  protected String uploadEmployeeName;
  protected Long uploadJobId;
  protected String uploadJobName;
  protected Long uploadDeptId;
  protected String uploadDeptName;
  protected Date uploadDate;
  protected String checkUnit;
  protected String checkUnitName;
  protected Long appraiseEmployeeId;
  protected String appraiseEmployeeName;
  protected Long appraiseJobId;
  protected String appraiseJobName;
  protected Date appraiseDate;
  protected String appraiseNode;
  protected String appraiseNodeName;
  protected String formerAppraiseNode;
  protected String formerAppraiseNodeName;
  protected String appraiseType;
  protected String appraiseTypeName;
  protected String imageStatus;
  protected String imageStatusName;
  protected String formerImageStatus;
  protected String formerImageStatusName;
  protected String actionCode;
  protected String actionCodeName;
  protected String appraiseDesc;
  protected String memo;
  protected String enabledFlag;
  protected Long imageCount;
  protected Long companyId;
  protected String companyName;
  protected Long operationTypeId;
  protected String operationTypeName;
  protected String blurQuery;
  protected Date uploadBeginDate;
  protected Date uploadEndDate;
  protected Date appraiseBeginDate;
  protected Date appraiseEndDate;
  protected String uploadEmployee;
  
  public Long getOperationTypeId()
  {
    return this.operationTypeId;
  }
  
  public void setOperationTypeId(Long paramLong)
  {
    this.operationTypeId = paramLong;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
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
    return this.uploadEmployeeName + "/" + this.uploadJobName + "/" + this.uploadDeptName;
  }
  
  public String getTaskNum()
  {
    return this.taskNum;
  }
  
  public void setTaskNum(String paramString)
  {
    this.taskNum = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getOperationTypeName()
  {
    return this.operationTypeName;
  }
  
  public void setOperationTypeName(String paramString)
  {
    this.operationTypeName = paramString;
  }
  
  public EidAppraiseHistoryV() {}
  
  public EidAppraiseHistoryV(Long paramLong1, Long paramLong2, String paramString1, String paramString2, Long paramLong3, Long paramLong4, String paramString3, String paramString4, Long paramLong5, String paramString5, Date paramDate1, String paramString6, String paramString7, Long paramLong6, String paramString8, Long paramLong7, String paramString9, Date paramDate2, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, Long paramLong8, String paramString25, String paramString26, Long paramLong9, Long paramLong10)
  {
    setAppraiseHistoryId(paramLong1);
    setImageInfoId(paramLong2);
    setImageNumber(paramString1);
    setTaskNum(paramString2);
    setUploadEmployeeId(paramLong3);
    setUploadEmployeeName(paramString4);
    setUploadJobId(paramLong4);
    setUploadJobName(paramString3);
    setUploadDeptId(paramLong5);
    setUploadDeptName(paramString5);
    setUploadDate(paramDate1);
    setCheckUnit(paramString6);
    setCheckUnitName(paramString7);
    setAppraiseEmployeeId(paramLong6);
    setAppraiseEmployeeName(paramString8);
    setAppraiseJobId(paramLong7);
    setAppraiseJobName(paramString9);
    setAppraiseDate(paramDate2);
    setAppraiseNode(paramString10);
    setAppraiseNodeName(paramString11);
    setFormerAppraiseNode(paramString12);
    setFormerAppraiseNodeName(paramString13);
    setAppraiseType(paramString14);
    setAppraiseTypeName(paramString15);
    setImageStatus(paramString16);
    setImageStatusName(paramString17);
    setFormerImageStatus(paramString18);
    setFormerImageStatusName(paramString19);
    setActionCode(paramString20);
    setActionCodeName(paramString21);
    setAppraiseDesc(paramString22);
    setMemo(paramString23);
    setEnabledFlag(paramString24);
    setImageCount(paramLong8);
    setCompanyName(paramString25);
    setOperationTypeName(paramString26);
    setCompanyId(paramLong9);
    setOperationTypeId(paramLong10);
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Long getAppraiseHistoryId()
  {
    return this.appraiseHistoryId;
  }
  
  public void setAppraiseHistoryId(Long paramLong)
  {
    this.appraiseHistoryId = paramLong;
  }
  
  public Long getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(Long paramLong)
  {
    this.imageInfoId = paramLong;
  }
  
  public Long getAppraiseEmployeeId()
  {
    return this.appraiseEmployeeId;
  }
  
  public void setAppraiseEmployeeId(Long paramLong)
  {
    this.appraiseEmployeeId = paramLong;
  }
  
  public Date getAppraiseDate()
  {
    return this.appraiseDate;
  }
  
  public void setAppraiseDate(Date paramDate)
  {
    this.appraiseDate = paramDate;
  }
  
  public String getAppraiseNode()
  {
    return this.appraiseNode;
  }
  
  public void setAppraiseNode(String paramString)
  {
    this.appraiseNode = paramString;
  }
  
  public String getAppraiseType()
  {
    return this.appraiseType;
  }
  
  public void setAppraiseType(String paramString)
  {
    this.appraiseType = paramString;
  }
  
  public String getAppraiseDesc()
  {
    return this.appraiseDesc;
  }
  
  public void setAppraiseDesc(String paramString)
  {
    if (paramString != null) {
      this.appraiseDesc = paramString;
    } else {
      this.appraiseDesc = "";
    }
  }
  
  public String getImageStatus()
  {
    return this.imageStatus;
  }
  
  public void setImageStatus(String paramString)
  {
    this.imageStatus = paramString;
  }
  
  public String getActionCode()
  {
    return this.actionCode;
  }
  
  public void setActionCode(String paramString)
  {
    this.actionCode = paramString;
  }
  
  public Long getUploadEmployeeId()
  {
    return this.uploadEmployeeId;
  }
  
  public void setUploadEmployeeId(Long paramLong)
  {
    this.uploadEmployeeId = paramLong;
  }
  
  public String getUploadEmployeeName()
  {
    return this.uploadEmployeeName;
  }
  
  public void setUploadEmployeeName(String paramString)
  {
    this.uploadEmployeeName = paramString;
  }
  
  public Long getUploadDeptId()
  {
    return this.uploadDeptId;
  }
  
  public void setUploadDeptId(Long paramLong)
  {
    this.uploadDeptId = paramLong;
  }
  
  public String getUploadDeptName()
  {
    return this.uploadDeptName;
  }
  
  public void setUploadDeptName(String paramString)
  {
    if (null != paramString) {
      this.uploadDeptName = paramString;
    } else {
      this.uploadDeptName = "";
    }
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
  
  public String getAppraiseEmployeeName()
  {
    return this.appraiseEmployeeName;
  }
  
  public void setAppraiseEmployeeName(String paramString)
  {
    this.appraiseEmployeeName = paramString;
  }
  
  public String getAppraiseNodeName()
  {
    return this.appraiseNodeName;
  }
  
  public void setAppraiseNodeName(String paramString)
  {
    this.appraiseNodeName = paramString;
  }
  
  public String getFormerAppraiseNode()
  {
    return this.formerAppraiseNode;
  }
  
  public void setFormerAppraiseNode(String paramString)
  {
    this.formerAppraiseNode = paramString;
  }
  
  public String getFormerAppraiseNodeName()
  {
    return this.formerAppraiseNodeName;
  }
  
  public void setFormerAppraiseNodeName(String paramString)
  {
    this.formerAppraiseNodeName = paramString;
  }
  
  public String getAppraiseTypeName()
  {
    return this.appraiseTypeName;
  }
  
  public void setAppraiseTypeName(String paramString)
  {
    this.appraiseTypeName = paramString;
  }
  
  public String getImageStatusName()
  {
    return this.imageStatusName;
  }
  
  public void setImageStatusName(String paramString)
  {
    this.imageStatusName = paramString;
  }
  
  public String getFormerImageStatus()
  {
    return this.formerImageStatus;
  }
  
  public void setFormerImageStatus(String paramString)
  {
    this.formerImageStatus = paramString;
  }
  
  public String getFormerImageStatusName()
  {
    return this.formerImageStatusName;
  }
  
  public void setFormerImageStatusName(String paramString)
  {
    this.formerImageStatusName = paramString;
  }
  
  public String getActionCodeName()
  {
    return this.actionCodeName;
  }
  
  public void setActionCodeName(String paramString)
  {
    this.actionCodeName = paramString;
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
  
  public String getImageNumber()
  {
    return this.imageNumber;
  }
  
  public void setImageNumber(String paramString)
  {
    this.imageNumber = paramString;
  }
  
  public Long getAppraiseJobId()
  {
    return this.appraiseJobId;
  }
  
  public void setAppraiseJobId(Long paramLong)
  {
    this.appraiseJobId = paramLong;
  }
  
  public String getAppraiseJobName()
  {
    return this.appraiseJobName;
  }
  
  public void setAppraiseJobName(String paramString)
  {
    this.appraiseJobName = paramString;
  }
  
  public Date getUploadBeginDate()
  {
    return this.uploadBeginDate;
  }
  
  public void setUploadBeginDate(Date paramDate)
  {
    this.uploadBeginDate = paramDate;
  }
  
  public Date getUploadEndDate()
  {
    return this.uploadEndDate;
  }
  
  public void setUploadEndDate(Date paramDate)
  {
    this.uploadEndDate = paramDate;
  }
  
  public Date getAppraiseBeginDate()
  {
    return this.appraiseBeginDate;
  }
  
  public void setAppraiseBeginDate(Date paramDate)
  {
    this.appraiseBeginDate = paramDate;
  }
  
  public Date getAppraiseEndDate()
  {
    return this.appraiseEndDate;
  }
  
  public void setAppraiseEndDate(Date paramDate)
  {
    this.appraiseEndDate = paramDate;
  }
  
  public Long getUploadJobId()
  {
    return this.uploadJobId;
  }
  
  public void setUploadJobId(Long paramLong)
  {
    this.uploadJobId = paramLong;
  }
  
  public String getUploadJobName()
  {
    return this.uploadJobName;
  }
  
  public void setUploadJobName(String paramString)
  {
    if (null != paramString) {
      this.uploadJobName = paramString;
    } else {
      this.uploadJobName = " ";
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidAppraiseHistoryV
 * JD-Core Version:    0.7.0.1
 */