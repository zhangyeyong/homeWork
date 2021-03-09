package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EidApprovalImageInfosV
  extends BaseObject
  implements Serializable
{
  protected BigInteger imageInfoId;
  protected Date lastUpdateDate;
  protected String imageNumber;
  protected String taskNum;
  protected BigInteger uploadEmployeeId;
  protected String employeeName;
  protected BigInteger deptId;
  protected String deptName;
  protected Date uploadDate;
  protected Long operationTypeId;
  protected String operationTypeCode;
  protected String typeFlag;
  protected String operationTypeName;
  protected Long companyId;
  protected String companyCode;
  protected String setOfBooksCode;
  protected String companyName;
  protected String imageStatus;
  protected String imageStatusName;
  protected String appraiseNode;
  protected String appraiseName;
  protected String memo;
  protected BigInteger imageCount;
  protected String enabledFlag;
  protected Date signDate;
  protected String appraiseDesc;
  protected String enabledFlagName;
  protected String signDateStr;
  private Date beginDate;
  private Date endDate;
  private String uploadEmployee;
  private String blurQuery;
  
  public String getSignDateStr()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    if (this.signDate != null) {
      return localSimpleDateFormat.format(this.signDate);
    }
    return null;
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
  
  public EidApprovalImageInfosV() {}
  
  public EidApprovalImageInfosV(BigInteger paramBigInteger1, String paramString1, BigInteger paramBigInteger2, String paramString2, BigInteger paramBigInteger3, String paramString3, Date paramDate1, Long paramLong1, String paramString4, String paramString5, String paramString6, Long paramLong2, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, BigInteger paramBigInteger4, String paramString15, Date paramDate2, String paramString16, String paramString17)
  {
    setImageInfoId(paramBigInteger1);
    setImageNumber(paramString1);
    setUploadEmployeeId(paramBigInteger2);
    setEmployeeName(paramString2);
    setDeptId(paramBigInteger3);
    setDeptName(paramString3);
    setUploadDate(paramDate1);
    setOperationTypeId(paramLong1);
    setOperationTypeCode(paramString4);
    setTypeFlag(paramString5);
    setOperationTypeName(paramString6);
    setCompanyId(paramLong2);
    setCompanyCode(paramString7);
    setSetOfBooksCode(paramString8);
    setCompanyName(paramString9);
    setImageStatus(paramString10);
    setImageStatusName(paramString11);
    setAppraiseNode(paramString12);
    setAppraiseName(paramString13);
    setMemo(paramString14);
    setImageCount(paramBigInteger4);
    setEnabledFlag(paramString15);
    setSignDate(paramDate2);
    setAppraiseDesc(paramString16);
    setEnabledFlagName(paramString17);
  }
  
  public BigInteger getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(BigInteger paramBigInteger)
  {
    this.imageInfoId = paramBigInteger;
  }
  
  public String getImageNumber()
  {
    return this.imageNumber;
  }
  
  public void setImageNumber(String paramString)
  {
    this.imageNumber = paramString;
  }
  
  public BigInteger getUploadEmployeeId()
  {
    return this.uploadEmployeeId;
  }
  
  public void setUploadEmployeeId(BigInteger paramBigInteger)
  {
    this.uploadEmployeeId = paramBigInteger;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public BigInteger getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(BigInteger paramBigInteger)
  {
    this.deptId = paramBigInteger;
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
  
  public String getOperationTypeCode()
  {
    return this.operationTypeCode;
  }
  
  public void setOperationTypeCode(String paramString)
  {
    this.operationTypeCode = paramString;
  }
  
  public String getTypeFlag()
  {
    return this.typeFlag;
  }
  
  public void setTypeFlag(String paramString)
  {
    this.typeFlag = paramString;
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
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getSetOfBooksCode()
  {
    return this.setOfBooksCode;
  }
  
  public void setSetOfBooksCode(String paramString)
  {
    this.setOfBooksCode = paramString;
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
  
  public BigInteger getImageCount()
  {
    return this.imageCount;
  }
  
  public void setImageCount(BigInteger paramBigInteger)
  {
    this.imageCount = paramBigInteger;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Date getSignDate()
  {
    return this.signDate;
  }
  
  public void setSignDate(Date paramDate)
  {
    this.signDate = paramDate;
  }
  
  public String getAppraiseDesc()
  {
    return this.appraiseDesc;
  }
  
  public void setAppraiseDesc(String paramString)
  {
    this.appraiseDesc = paramString;
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
    if (!(paramObject instanceof EidApprovalImageInfosV)) {
      return false;
    }
    EidApprovalImageInfosV localEidApprovalImageInfosV = (EidApprovalImageInfosV)paramObject;
    return new EqualsBuilder().append(this.imageInfoId, localEidApprovalImageInfosV.imageInfoId).append(this.imageNumber, localEidApprovalImageInfosV.imageNumber).append(this.uploadEmployeeId, localEidApprovalImageInfosV.uploadEmployeeId).append(this.employeeName, localEidApprovalImageInfosV.employeeName).append(this.deptId, localEidApprovalImageInfosV.deptId).append(this.deptName, localEidApprovalImageInfosV.deptName).append(this.uploadDate, localEidApprovalImageInfosV.uploadDate).append(this.operationTypeId, localEidApprovalImageInfosV.operationTypeId).append(this.operationTypeCode, localEidApprovalImageInfosV.operationTypeCode).append(this.typeFlag, localEidApprovalImageInfosV.typeFlag).append(this.operationTypeName, localEidApprovalImageInfosV.operationTypeName).append(this.companyId, localEidApprovalImageInfosV.companyId).append(this.companyCode, localEidApprovalImageInfosV.companyCode).append(this.setOfBooksCode, localEidApprovalImageInfosV.setOfBooksCode).append(this.companyName, localEidApprovalImageInfosV.companyName).append(this.imageStatus, localEidApprovalImageInfosV.imageStatus).append(this.imageStatusName, localEidApprovalImageInfosV.imageStatusName).append(this.appraiseNode, localEidApprovalImageInfosV.appraiseNode).append(this.appraiseName, localEidApprovalImageInfosV.appraiseName).append(this.memo, localEidApprovalImageInfosV.memo).append(this.imageCount, localEidApprovalImageInfosV.imageCount).append(this.enabledFlag, localEidApprovalImageInfosV.enabledFlag).append(this.signDate, localEidApprovalImageInfosV.signDate).append(this.appraiseDesc, localEidApprovalImageInfosV.appraiseDesc).append(this.enabledFlagName, localEidApprovalImageInfosV.enabledFlagName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.imageInfoId).append(this.imageNumber).append(this.uploadEmployeeId).append(this.employeeName).append(this.deptId).append(this.deptName).append(this.uploadDate).append(this.operationTypeId).append(this.operationTypeCode).append(this.typeFlag).append(this.operationTypeName).append(this.companyId).append(this.companyCode).append(this.setOfBooksCode).append(this.companyName).append(this.imageStatus).append(this.imageStatusName).append(this.appraiseNode).append(this.appraiseName).append(this.memo).append(this.imageCount).append(this.enabledFlag).append(this.signDate).append(this.appraiseDesc).append(this.enabledFlagName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("imageInfoId", this.imageInfoId).append("imageNumber", this.imageNumber).append("uploadEmployeeId", this.uploadEmployeeId).append("employeeName", this.employeeName).append("deptId", this.deptId).append("deptName", this.deptName).append("uploadDate", this.uploadDate).append("operationTypeId", this.operationTypeId).append("operationTypeCode", this.operationTypeCode).append("typeFlag", this.typeFlag).append("operationTypeName", this.operationTypeName).append("companyId", this.companyId).append("companyCode", this.companyCode).append("setOfBooksCode", this.setOfBooksCode).append("companyName", this.companyName).append("imageStatus", this.imageStatus).append("imageStatusName", this.imageStatusName).append("appraiseNode", this.appraiseNode).append("appraiseName", this.appraiseName).append("memo", this.memo).append("imageCount", this.imageCount).append("enabledFlag", this.enabledFlag).append("signDate", this.signDate).append("appraiseDesc", this.appraiseDesc).append("enabledFlagName", this.enabledFlagName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getTaskNum()
  {
    return this.taskNum;
  }
  
  public void setTaskNum(String paramString)
  {
    this.taskNum = paramString;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidApprovalImageInfosV
 * JD-Core Version:    0.7.0.1
 */