package com.zte.report.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ImageScanDetailV
  extends BaseObject
  implements Serializable
{
  protected BigInteger imageInfoId;
  protected String imageNumber;
  protected String taskNum;
  protected Long companyId;
  protected String companyCode;
  protected String companyName;
  protected Long operationTypeId;
  protected String operationTypeCode;
  protected String operationTypeName;
  protected String imageStatus;
  protected String imageStatusName;
  protected BigInteger imageCount;
  protected BigInteger uploadEmployeeId;
  protected String employeeName;
  protected Date uploadDate;
  protected String uploadDateStr;
  
  public ImageScanDetailV() {}
  
  public ImageScanDetailV(BigInteger paramBigInteger1, String paramString1, String paramString2, Long paramLong1, String paramString3, String paramString4, Long paramLong2, String paramString5, String paramString6, String paramString7, String paramString8, BigInteger paramBigInteger2, BigInteger paramBigInteger3, String paramString9)
  {
    setImageInfoId(paramBigInteger1);
    setImageNumber(paramString1);
    setTaskNum(paramString2);
    setCompanyId(paramLong1);
    setCompanyCode(paramString3);
    setCompanyName(paramString4);
    setOperationTypeId(paramLong2);
    setOperationTypeCode(paramString5);
    setOperationTypeName(paramString6);
    setImageStatus(paramString7);
    setImageStatusName(paramString8);
    setImageCount(paramBigInteger2);
    setUploadEmployeeId(paramBigInteger3);
    setEmployeeName(paramString9);
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
  
  public BigInteger getImageCount()
  {
    return this.imageCount;
  }
  
  public void setImageCount(BigInteger paramBigInteger)
  {
    this.imageCount = paramBigInteger;
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
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImageScanDetailV)) {
      return false;
    }
    ImageScanDetailV localImageScanDetailV = (ImageScanDetailV)paramObject;
    return new EqualsBuilder().append(this.imageInfoId, localImageScanDetailV.imageInfoId).append(this.imageNumber, localImageScanDetailV.imageNumber).append(this.taskNum, localImageScanDetailV.taskNum).append(this.companyId, localImageScanDetailV.companyId).append(this.companyCode, localImageScanDetailV.companyCode).append(this.companyName, localImageScanDetailV.companyName).append(this.operationTypeId, localImageScanDetailV.operationTypeId).append(this.operationTypeCode, localImageScanDetailV.operationTypeCode).append(this.operationTypeName, localImageScanDetailV.operationTypeName).append(this.imageStatus, localImageScanDetailV.imageStatus).append(this.imageStatusName, localImageScanDetailV.imageStatusName).append(this.imageCount, localImageScanDetailV.imageCount).append(this.uploadEmployeeId, localImageScanDetailV.uploadEmployeeId).append(this.employeeName, localImageScanDetailV.employeeName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.imageInfoId).append(this.imageNumber).append(this.taskNum).append(this.companyId).append(this.companyCode).append(this.companyName).append(this.operationTypeId).append(this.operationTypeCode).append(this.operationTypeName).append(this.imageStatus).append(this.imageStatusName).append(this.imageCount).append(this.uploadEmployeeId).append(this.employeeName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("imageInfoId", this.imageInfoId).append("imageNumber", this.imageNumber).append("taskNum", this.taskNum).append("companyId", this.companyId).append("companyCode", this.companyCode).append("companyName", this.companyName).append("operationTypeId", this.operationTypeId).append("operationTypeCode", this.operationTypeCode).append("operationTypeName", this.operationTypeName).append("imageStatus", this.imageStatus).append("imageStatusName", this.imageStatusName).append("imageCount", this.imageCount).append("uploadEmployeeId", this.uploadEmployeeId).append("employeeName", this.employeeName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getUploadDateStr()
  {
    return this.uploadDateStr;
  }
  
  public void setUploadDateStr(String paramString)
  {
    this.uploadDateStr = paramString;
  }
  
  public Date getUploadDate()
  {
    return this.uploadDate;
  }
  
  public void setUploadDate(Date paramDate)
  {
    this.uploadDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.model.ImageScanDetailV
 * JD-Core Version:    0.7.0.1
 */