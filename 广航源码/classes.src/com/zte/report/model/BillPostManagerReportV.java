package com.zte.report.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BillPostManagerReportV
  extends BaseObject
  implements Serializable
{
  protected BigInteger imageInfoId;
  protected Date journalDate;
  protected String journalNum;
  protected String taskNum;
  protected String imageNumber;
  protected Long companyId;
  protected String companyCode;
  protected String companyName;
  protected Long operationTypeId;
  protected String operationTypeCode;
  protected String operationTypeName;
  protected BigInteger uploadEmployeeId;
  protected String uploadEmployeeName;
  protected Date uploadDate;
  protected String imageStatus;
  protected String imageStatusName;
  protected BigInteger imageCount;
  protected BigInteger voucherId;
  protected String isLikeQuery;
  protected Date uploadDateBegin;
  protected Date uploadDateEnd;
  protected Date journalDateBegin;
  protected Date journalDateEnd;
  protected String journalNumBegin;
  protected String journalNumEnd;
  protected String boeNum;
  
  public String getJournalNumEnd()
  {
    return this.journalNumEnd;
  }
  
  public void setJournalNumEnd(String paramString)
  {
    this.journalNumEnd = paramString;
  }
  
  public Date getUploadDateBegin()
  {
    return this.uploadDateBegin;
  }
  
  public void setUploadDateBegin(Date paramDate)
  {
    this.uploadDateBegin = paramDate;
  }
  
  public Date getUploadDateEnd()
  {
    return this.uploadDateEnd;
  }
  
  public void setUploadDateEnd(Date paramDate)
  {
    this.uploadDateEnd = paramDate;
  }
  
  public Date getJournalDateBegin()
  {
    return this.journalDateBegin;
  }
  
  public void setJournalDateBegin(Date paramDate)
  {
    this.journalDateBegin = paramDate;
  }
  
  public BillPostManagerReportV() {}
  
  public BillPostManagerReportV(BigInteger paramBigInteger1, Date paramDate1, String paramString1, String paramString2, String paramString3, Long paramLong1, String paramString4, String paramString5, Long paramLong2, String paramString6, String paramString7, BigInteger paramBigInteger2, String paramString8, Date paramDate2, String paramString9, String paramString10, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
  {
    setImageInfoId(paramBigInteger1);
    setJournalDate(paramDate1);
    setJournalNum(paramString1);
    setTaskNum(paramString2);
    setImageNumber(paramString3);
    setCompanyId(paramLong1);
    setCompanyCode(paramString4);
    setCompanyName(paramString5);
    setOperationTypeId(paramLong2);
    setOperationTypeCode(paramString6);
    setOperationTypeName(paramString7);
    setUploadEmployeeId(paramBigInteger2);
    setUploadEmployeeName(paramString8);
    setUploadDate(paramDate2);
    setImageStatus(paramString9);
    setImageStatusName(paramString10);
    setImageCount(paramBigInteger3);
    setVoucherId(paramBigInteger4);
  }
  
  public BigInteger getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(BigInteger paramBigInteger)
  {
    this.imageInfoId = paramBigInteger;
  }
  
  public Date getJournalDate()
  {
    return this.journalDate;
  }
  
  public void setJournalDate(Date paramDate)
  {
    this.journalDate = paramDate;
  }
  
  public String getJournalNum()
  {
    if (this.journalNum == null) {
      return "";
    }
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public String getTaskNum()
  {
    return this.taskNum;
  }
  
  public void setTaskNum(String paramString)
  {
    this.taskNum = paramString;
  }
  
  public String getImageNumber()
  {
    return this.imageNumber;
  }
  
  public void setImageNumber(String paramString)
  {
    this.imageNumber = paramString;
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
  
  public BigInteger getUploadEmployeeId()
  {
    return this.uploadEmployeeId;
  }
  
  public void setUploadEmployeeId(BigInteger paramBigInteger)
  {
    this.uploadEmployeeId = paramBigInteger;
  }
  
  public String getUploadEmployeeName()
  {
    return this.uploadEmployeeName;
  }
  
  public void setUploadEmployeeName(String paramString)
  {
    this.uploadEmployeeName = paramString;
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
  
  public BigInteger getImageCount()
  {
    return this.imageCount;
  }
  
  public void setImageCount(BigInteger paramBigInteger)
  {
    this.imageCount = paramBigInteger;
  }
  
  public BigInteger getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(BigInteger paramBigInteger)
  {
    this.voucherId = paramBigInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BillPostManagerReportV)) {
      return false;
    }
    BillPostManagerReportV localBillPostManagerReportV = (BillPostManagerReportV)paramObject;
    return new EqualsBuilder().append(this.imageInfoId, localBillPostManagerReportV.imageInfoId).append(this.journalDate, localBillPostManagerReportV.journalDate).append(this.journalNum, localBillPostManagerReportV.journalNum).append(this.taskNum, localBillPostManagerReportV.taskNum).append(this.imageNumber, localBillPostManagerReportV.imageNumber).append(this.companyId, localBillPostManagerReportV.companyId).append(this.companyCode, localBillPostManagerReportV.companyCode).append(this.companyName, localBillPostManagerReportV.companyName).append(this.operationTypeId, localBillPostManagerReportV.operationTypeId).append(this.operationTypeCode, localBillPostManagerReportV.operationTypeCode).append(this.operationTypeName, localBillPostManagerReportV.operationTypeName).append(this.uploadEmployeeId, localBillPostManagerReportV.uploadEmployeeId).append(this.uploadEmployeeName, localBillPostManagerReportV.uploadEmployeeName).append(this.uploadDate, localBillPostManagerReportV.uploadDate).append(this.imageStatus, localBillPostManagerReportV.imageStatus).append(this.imageStatusName, localBillPostManagerReportV.imageStatusName).append(this.imageCount, localBillPostManagerReportV.imageCount).append(this.voucherId, localBillPostManagerReportV.voucherId).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.imageInfoId).append(this.journalDate).append(this.journalNum).append(this.taskNum).append(this.imageNumber).append(this.companyId).append(this.companyCode).append(this.companyName).append(this.operationTypeId).append(this.operationTypeCode).append(this.operationTypeName).append(this.uploadEmployeeId).append(this.uploadEmployeeName).append(this.uploadDate).append(this.imageStatus).append(this.imageStatusName).append(this.imageCount).append(this.voucherId).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("imageInfoId", this.imageInfoId).append("journalDate", this.journalDate).append("journalNum", this.journalNum).append("taskNum", this.taskNum).append("imageNumber", this.imageNumber).append("companyId", this.companyId).append("companyCode", this.companyCode).append("companyName", this.companyName).append("operationTypeId", this.operationTypeId).append("operationTypeCode", this.operationTypeCode).append("operationTypeName", this.operationTypeName).append("uploadEmployeeId", this.uploadEmployeeId).append("uploadEmployeeName", this.uploadEmployeeName).append("uploadDate", this.uploadDate).append("imageStatus", this.imageStatus).append("imageStatusName", this.imageStatusName).append("imageCount", this.imageCount).append("voucherId", this.voucherId).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getIsLikeQuery()
  {
    return this.isLikeQuery;
  }
  
  public void setIsLikeQuery(String paramString)
  {
    this.isLikeQuery = paramString;
  }
  
  public String getJournalNumBegin()
  {
    return this.journalNumBegin;
  }
  
  public void setJournalNumBegin(String paramString)
  {
    this.journalNumBegin = paramString;
  }
  
  public Date getJournalDateEnd()
  {
    return this.journalDateEnd;
  }
  
  public void setJournalDateEnd(Date paramDate)
  {
    this.journalDateEnd = paramDate;
  }
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.model.BillPostManagerReportV
 * JD-Core Version:    0.7.0.1
 */