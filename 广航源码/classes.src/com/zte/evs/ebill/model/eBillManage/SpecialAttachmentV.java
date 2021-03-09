package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SpecialAttachmentV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = -1239871065235564887L;
  protected Date journalDate;
  protected String journalNum;
  protected String uploadEmployeeName;
  protected String appraiseEmployeeName;
  protected String specialattachmentPage;
  protected Long imageCount;
  protected Long imageInfoId;
  protected String taskNum;
  protected String imageNumber;
  protected Long companyId;
  protected String companyCode;
  protected String companyName;
  protected Long operationTypeId;
  protected String operationTypeCode;
  protected String operationTypeName;
  protected Long uploadEmployeeId;
  protected Date uploadDate;
  protected String imageStatus;
  protected String imageStatusName;
  protected Long attachmentCount;
  protected Long voucherId;
  protected Long appraiseEmployeeId;
  protected Date appraiseDate;
  private String uploadDateBegin;
  private String uploadDateEnd;
  private String journalDateBegin;
  private String journalDateEnd;
  private String appraiseDateBegin;
  private String appraiseDateEnd;
  private String blurQuery;
  
  public String getUploadDateBegin()
  {
    return this.uploadDateBegin;
  }
  
  public void setUploadDateBegin(String paramString)
  {
    this.uploadDateBegin = paramString;
  }
  
  public String getUploadDateEnd()
  {
    return this.uploadDateEnd;
  }
  
  public void setUploadDateEnd(String paramString)
  {
    this.uploadDateEnd = paramString;
  }
  
  public String getJournalDateBegin()
  {
    return this.journalDateBegin;
  }
  
  public void setJournalDateBegin(String paramString)
  {
    this.journalDateBegin = paramString;
  }
  
  public String getJournalDateEnd()
  {
    return this.journalDateEnd;
  }
  
  public void setJournalDateEnd(String paramString)
  {
    this.journalDateEnd = paramString;
  }
  
  public String getBlurQuery()
  {
    return this.blurQuery;
  }
  
  public void setBlurQuery(String paramString)
  {
    this.blurQuery = paramString;
  }
  
  public String getAppraiseDateBegin()
  {
    return this.appraiseDateBegin;
  }
  
  public void setAppraiseDateBegin(String paramString)
  {
    this.appraiseDateBegin = paramString;
  }
  
  public String getAppraiseDateEnd()
  {
    return this.appraiseDateEnd;
  }
  
  public void setAppraiseDateEnd(String paramString)
  {
    this.appraiseDateEnd = paramString;
  }
  
  public SpecialAttachmentV() {}
  
  public SpecialAttachmentV(Date paramDate1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, Long paramLong2, String paramString5, String paramString6, Long paramLong3, String paramString7, String paramString8, Long paramLong4, String paramString9, String paramString10, Long paramLong5, Date paramDate2, String paramString11, String paramString12, Long paramLong6, Long paramLong7, Long paramLong8, Date paramDate3)
  {
    setJournalDate(paramDate1);
    setJournalNum(paramString1);
    setUploadEmployeeName(paramString2);
    setAppraiseEmployeeName(paramString3);
    setSpecialattachmentPage(paramString4);
    setImageCount(paramLong1);
    setImageInfoId(paramLong2);
    setTaskNum(paramString5);
    setImageNumber(paramString6);
    setCompanyId(paramLong3);
    setCompanyCode(paramString7);
    setCompanyName(paramString8);
    setOperationTypeId(paramLong4);
    setOperationTypeCode(paramString9);
    setOperationTypeName(paramString10);
    setUploadEmployeeId(paramLong5);
    setUploadDate(paramDate2);
    setImageStatus(paramString11);
    setImageStatusName(paramString12);
    setAttachmentCount(paramLong6);
    setVoucherId(paramLong7);
    setAppraiseEmployeeId(paramLong8);
    setAppraiseDate(paramDate3);
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
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public String getUploadEmployeeName()
  {
    return this.uploadEmployeeName;
  }
  
  public void setUploadEmployeeName(String paramString)
  {
    this.uploadEmployeeName = paramString;
  }
  
  public String getAppraiseEmployeeName()
  {
    return this.appraiseEmployeeName;
  }
  
  public void setAppraiseEmployeeName(String paramString)
  {
    this.appraiseEmployeeName = paramString;
  }
  
  public String getSpecialattachmentPage()
  {
    return this.specialattachmentPage;
  }
  
  public void setSpecialattachmentPage(String paramString)
  {
    this.specialattachmentPage = paramString;
  }
  
  public Long getImageCount()
  {
    return this.imageCount;
  }
  
  public void setImageCount(Long paramLong)
  {
    this.imageCount = paramLong;
  }
  
  public Long getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(Long paramLong)
  {
    this.imageInfoId = paramLong;
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
  
  public Long getUploadEmployeeId()
  {
    return this.uploadEmployeeId;
  }
  
  public void setUploadEmployeeId(Long paramLong)
  {
    this.uploadEmployeeId = paramLong;
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
  
  public Long getAttachmentCount()
  {
    return this.attachmentCount;
  }
  
  public void setAttachmentCount(Long paramLong)
  {
    this.attachmentCount = paramLong;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
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
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SpecialAttachmentV)) {
      return false;
    }
    SpecialAttachmentV localSpecialAttachmentV = (SpecialAttachmentV)paramObject;
    return new EqualsBuilder().append(this.journalDate, localSpecialAttachmentV.journalDate).append(this.journalNum, localSpecialAttachmentV.journalNum).append(this.uploadEmployeeName, localSpecialAttachmentV.uploadEmployeeName).append(this.appraiseEmployeeName, localSpecialAttachmentV.appraiseEmployeeName).append(this.specialattachmentPage, localSpecialAttachmentV.specialattachmentPage).append(this.imageCount, localSpecialAttachmentV.imageCount).append(this.imageInfoId, localSpecialAttachmentV.imageInfoId).append(this.taskNum, localSpecialAttachmentV.taskNum).append(this.imageNumber, localSpecialAttachmentV.imageNumber).append(this.companyId, localSpecialAttachmentV.companyId).append(this.companyCode, localSpecialAttachmentV.companyCode).append(this.companyName, localSpecialAttachmentV.companyName).append(this.operationTypeId, localSpecialAttachmentV.operationTypeId).append(this.operationTypeCode, localSpecialAttachmentV.operationTypeCode).append(this.operationTypeName, localSpecialAttachmentV.operationTypeName).append(this.uploadEmployeeId, localSpecialAttachmentV.uploadEmployeeId).append(this.uploadDate, localSpecialAttachmentV.uploadDate).append(this.imageStatus, localSpecialAttachmentV.imageStatus).append(this.imageStatusName, localSpecialAttachmentV.imageStatusName).append(this.attachmentCount, localSpecialAttachmentV.attachmentCount).append(this.voucherId, localSpecialAttachmentV.voucherId).append(this.appraiseEmployeeId, localSpecialAttachmentV.appraiseEmployeeId).append(this.appraiseDate, localSpecialAttachmentV.appraiseDate).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.journalDate).append(this.journalNum).append(this.uploadEmployeeName).append(this.appraiseEmployeeName).append(this.specialattachmentPage).append(this.imageCount).append(this.imageInfoId).append(this.taskNum).append(this.imageNumber).append(this.companyId).append(this.companyCode).append(this.companyName).append(this.operationTypeId).append(this.operationTypeCode).append(this.operationTypeName).append(this.uploadEmployeeId).append(this.uploadDate).append(this.imageStatus).append(this.imageStatusName).append(this.attachmentCount).append(this.voucherId).append(this.appraiseEmployeeId).append(this.appraiseDate).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("journalDate", this.journalDate).append("journalNum", this.journalNum).append("uploadEmployeeName", this.uploadEmployeeName).append("appraiseEmployeeName", this.appraiseEmployeeName).append("specialattachmentPage", this.specialattachmentPage).append("imageCount", this.imageCount).append("imageInfoId", this.imageInfoId).append("taskNum", this.taskNum).append("imageNumber", this.imageNumber).append("companyId", this.companyId).append("companyCode", this.companyCode).append("companyName", this.companyName).append("operationTypeId", this.operationTypeId).append("operationTypeCode", this.operationTypeCode).append("operationTypeName", this.operationTypeName).append("uploadEmployeeId", this.uploadEmployeeId).append("uploadDate", this.uploadDate).append("imageStatus", this.imageStatus).append("imageStatusName", this.imageStatusName).append("attachmentCount", this.attachmentCount).append("voucherId", this.voucherId).append("appraiseEmployeeId", this.appraiseEmployeeId).append("appraiseDate", this.appraiseDate).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.SpecialAttachmentV
 * JD-Core Version:    0.7.0.1
 */