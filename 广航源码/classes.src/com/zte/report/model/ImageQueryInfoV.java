package com.zte.report.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ImageQueryInfoV
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
  protected String employeeName;
  protected Date uploadDate;
  protected String imageStatus;
  protected String imageStatusName;
  protected String appraiseNode;
  protected String appraiseNodeName;
  protected BigInteger appraiseEmployeeId;
  protected String appraiseEmployeeName;
  protected Date appraiseDate;
  protected Date beginUploadDate;
  protected Date endUploadDate;
  protected Date beginAppraiseDate;
  protected Date endAppraiseDate;
  protected String isLikeQuery;
  protected Long uploadEmployeeId;
  
  public Long getUploadEmployeeId()
  {
    return this.uploadEmployeeId;
  }
  
  public void setUploadEmployeeId(Long paramLong)
  {
    this.uploadEmployeeId = paramLong;
  }
  
  public String getIsLikeQuery()
  {
    return this.isLikeQuery;
  }
  
  public void setIsLikeQuery(String paramString)
  {
    this.isLikeQuery = paramString;
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
  
  public Date getBeginAppraiseDate()
  {
    return this.beginAppraiseDate;
  }
  
  public void setBeginAppraiseDate(Date paramDate)
  {
    this.beginAppraiseDate = paramDate;
  }
  
  public Date getEndAppraiseDate()
  {
    return this.endAppraiseDate;
  }
  
  public void setEndAppraiseDate(Date paramDate)
  {
    this.endAppraiseDate = paramDate;
  }
  
  public ImageQueryInfoV() {}
  
  public ImageQueryInfoV(BigInteger paramBigInteger1, String paramString1, String paramString2, Long paramLong1, String paramString3, String paramString4, Long paramLong2, String paramString5, String paramString6, String paramString7, Date paramDate1, String paramString8, String paramString9, String paramString10, String paramString11, BigInteger paramBigInteger2, String paramString12, Date paramDate2)
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
    setEmployeeName(paramString7);
    setUploadDate(paramDate1);
    setImageStatus(paramString8);
    setImageStatusName(paramString9);
    setAppraiseNode(paramString10);
    setAppraiseNodeName(paramString11);
    setAppraiseEmployeeId(paramBigInteger2);
    setAppraiseEmployeeName(paramString12);
    setAppraiseDate(paramDate2);
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
  
  public String getAppraiseNodeName()
  {
    return this.appraiseNodeName;
  }
  
  public void setAppraiseNodeName(String paramString)
  {
    this.appraiseNodeName = paramString;
  }
  
  public BigInteger getAppraiseEmployeeId()
  {
    return this.appraiseEmployeeId;
  }
  
  public void setAppraiseEmployeeId(BigInteger paramBigInteger)
  {
    this.appraiseEmployeeId = paramBigInteger;
  }
  
  public String getAppraiseEmployeeName()
  {
    return this.appraiseEmployeeName;
  }
  
  public void setAppraiseEmployeeName(String paramString)
  {
    this.appraiseEmployeeName = paramString;
  }
  
  public Date getAppraiseDate()
  {
    return this.appraiseDate;
  }
  
  public void setAppraiseDate(Date paramDate)
  {
    this.appraiseDate = paramDate;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImageQueryInfoV)) {
      return false;
    }
    ImageQueryInfoV localImageQueryInfoV = (ImageQueryInfoV)paramObject;
    return new EqualsBuilder().append(this.imageInfoId, localImageQueryInfoV.imageInfoId).append(this.imageNumber, localImageQueryInfoV.imageNumber).append(this.taskNum, localImageQueryInfoV.taskNum).append(this.companyId, localImageQueryInfoV.companyId).append(this.companyCode, localImageQueryInfoV.companyCode).append(this.companyName, localImageQueryInfoV.companyName).append(this.operationTypeId, localImageQueryInfoV.operationTypeId).append(this.operationTypeCode, localImageQueryInfoV.operationTypeCode).append(this.operationTypeName, localImageQueryInfoV.operationTypeName).append(this.employeeName, localImageQueryInfoV.employeeName).append(this.uploadDate, localImageQueryInfoV.uploadDate).append(this.imageStatus, localImageQueryInfoV.imageStatus).append(this.imageStatusName, localImageQueryInfoV.imageStatusName).append(this.appraiseNode, localImageQueryInfoV.appraiseNode).append(this.appraiseNodeName, localImageQueryInfoV.appraiseNodeName).append(this.appraiseEmployeeId, localImageQueryInfoV.appraiseEmployeeId).append(this.appraiseEmployeeName, localImageQueryInfoV.appraiseEmployeeName).append(this.appraiseDate, localImageQueryInfoV.appraiseDate).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.imageInfoId).append(this.imageNumber).append(this.taskNum).append(this.companyId).append(this.companyCode).append(this.companyName).append(this.operationTypeId).append(this.operationTypeCode).append(this.operationTypeName).append(this.employeeName).append(this.uploadDate).append(this.imageStatus).append(this.imageStatusName).append(this.appraiseNode).append(this.appraiseNodeName).append(this.appraiseEmployeeId).append(this.appraiseEmployeeName).append(this.appraiseDate).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("imageInfoId", this.imageInfoId).append("imageNumber", this.imageNumber).append("taskNum", this.taskNum).append("companyId", this.companyId).append("companyCode", this.companyCode).append("companyName", this.companyName).append("operationTypeId", this.operationTypeId).append("operationTypeCode", this.operationTypeCode).append("operationTypeName", this.operationTypeName).append("employeeName", this.employeeName).append("uploadDate", this.uploadDate).append("imageStatus", this.imageStatus).append("imageStatusName", this.imageStatusName).append("appraiseNode", this.appraiseNode).append("appraiseNodeName", this.appraiseNodeName).append("appraiseEmployeeId", this.appraiseEmployeeId).append("appraiseEmployeeName", this.appraiseEmployeeName).append("appraiseDate", this.appraiseDate).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.model.ImageQueryInfoV
 * JD-Core Version:    0.7.0.1
 */