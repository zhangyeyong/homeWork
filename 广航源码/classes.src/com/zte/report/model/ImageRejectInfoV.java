package com.zte.report.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ImageRejectInfoV
  extends BaseObject
  implements Serializable
{
  protected BigInteger appraiseHistoryId;
  protected BigInteger imageInfoId;
  protected String imageNumber;
  protected String taskNum;
  protected Long companyId;
  protected String companyCode;
  protected String companyName;
  protected Long operationTypeId;
  protected String operationTypeCode;
  protected String operationTypeName;
  protected String employeeName;
  protected Date uploadDate;
  protected String appraiseType;
  protected String appraiseTypeName;
  protected String appraiseDesc;
  protected String isLikeQuery;
  protected Date beginUploadDate;
  protected Date endUploadDate;
  protected Long uploadEmployeeId;
  
  public Long getUploadEmployeeId()
  {
    return this.uploadEmployeeId;
  }
  
  public void setUploadEmployeeId(Long paramLong)
  {
    this.uploadEmployeeId = paramLong;
  }
  
  public Date getBeginUploadDate()
  {
    return this.beginUploadDate;
  }
  
  public void setBeginUploadDate(Date paramDate)
  {
    this.beginUploadDate = paramDate;
  }
  
  public Date getEndUploadDate()
  {
    return this.endUploadDate;
  }
  
  public void setEndUploadDate(Date paramDate)
  {
    this.endUploadDate = paramDate;
  }
  
  public String getIsLikeQuery()
  {
    return this.isLikeQuery;
  }
  
  public void setIsLikeQuery(String paramString)
  {
    this.isLikeQuery = paramString;
  }
  
  public ImageRejectInfoV() {}
  
  public ImageRejectInfoV(BigInteger paramBigInteger1, BigInteger paramBigInteger2, String paramString1, String paramString2, Long paramLong1, String paramString3, String paramString4, Long paramLong2, String paramString5, String paramString6, String paramString7, Date paramDate, String paramString8, String paramString9, String paramString10)
  {
    setAppraiseHistoryId(paramBigInteger1);
    setImageInfoId(paramBigInteger2);
    setImageNumber(paramString1);
    setTaskNum(paramString2);
    setCompanyId(paramLong1);
    setCompanyCode(paramString3);
    setCompanyName(paramString4);
    setOperationTypeId(paramLong2);
    setOperationTypeCode(paramString5);
    setOperationTypeName(paramString6);
    setEmployeeName(paramString7);
    setUploadDate(paramDate);
    setAppraiseType(paramString8);
    setAppraiseTypeName(paramString9);
    setAppraiseDesc(paramString10);
  }
  
  public BigInteger getAppraiseHistoryId()
  {
    return this.appraiseHistoryId;
  }
  
  public void setAppraiseHistoryId(BigInteger paramBigInteger)
  {
    this.appraiseHistoryId = paramBigInteger;
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
  
  public String getTaskNum()
  {
    return this.taskNum;
  }
  
  public void setTaskNum(String paramString)
  {
    this.taskNum = paramString;
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
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
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
  
  public String getOperationTypeName()
  {
    return this.operationTypeName;
  }
  
  public void setOperationTypeName(String paramString)
  {
    this.operationTypeName = paramString;
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
  
  public String getAppraiseType()
  {
    return this.appraiseType;
  }
  
  public void setAppraiseType(String paramString)
  {
    this.appraiseType = paramString;
  }
  
  public String getAppraiseTypeName()
  {
    return this.appraiseTypeName;
  }
  
  public void setAppraiseTypeName(String paramString)
  {
    this.appraiseTypeName = paramString;
  }
  
  public String getAppraiseDesc()
  {
    return this.appraiseDesc;
  }
  
  public void setAppraiseDesc(String paramString)
  {
    this.appraiseDesc = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImageRejectInfoV)) {
      return false;
    }
    ImageRejectInfoV localImageRejectInfoV = (ImageRejectInfoV)paramObject;
    return new EqualsBuilder().append(this.appraiseHistoryId, localImageRejectInfoV.appraiseHistoryId).append(this.imageInfoId, localImageRejectInfoV.imageInfoId).append(this.imageNumber, localImageRejectInfoV.imageNumber).append(this.taskNum, localImageRejectInfoV.taskNum).append(this.companyId, localImageRejectInfoV.companyId).append(this.companyCode, localImageRejectInfoV.companyCode).append(this.companyName, localImageRejectInfoV.companyName).append(this.operationTypeId, localImageRejectInfoV.operationTypeId).append(this.operationTypeCode, localImageRejectInfoV.operationTypeCode).append(this.operationTypeName, localImageRejectInfoV.operationTypeName).append(this.employeeName, localImageRejectInfoV.employeeName).append(this.uploadDate, localImageRejectInfoV.uploadDate).append(this.appraiseType, localImageRejectInfoV.appraiseType).append(this.appraiseTypeName, localImageRejectInfoV.appraiseTypeName).append(this.appraiseDesc, localImageRejectInfoV.appraiseDesc).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.appraiseHistoryId).append(this.imageInfoId).append(this.imageNumber).append(this.taskNum).append(this.companyId).append(this.companyCode).append(this.companyName).append(this.operationTypeId).append(this.operationTypeCode).append(this.operationTypeName).append(this.employeeName).append(this.uploadDate).append(this.appraiseType).append(this.appraiseTypeName).append(this.appraiseDesc).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("appraiseHistoryId", this.appraiseHistoryId).append("imageInfoId", this.imageInfoId).append("imageNumber", this.imageNumber).append("taskNum", this.taskNum).append("companyId", this.companyId).append("companyCode", this.companyCode).append("companyName", this.companyName).append("operationTypeId", this.operationTypeId).append("operationTypeCode", this.operationTypeCode).append("operationTypeName", this.operationTypeName).append("employeeName", this.employeeName).append("uploadDate", this.uploadDate).append("appraiseType", this.appraiseType).append("appraiseTypeName", this.appraiseTypeName).append("appraiseDesc", this.appraiseDesc).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.model.ImageRejectInfoV
 * JD-Core Version:    0.7.0.1
 */