package com.zte.evs.ebill.model.eBillManage;

import com.zte.evs.ebill.common.EvsStatusUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EvsVoucherV
  implements Serializable
{
  private Long voucherId;
  private String subDocName;
  private String source;
  private String periodName;
  private String invoiceType;
  private Long userId;
  private String userName;
  private Date createdDate;
  private Date approverDate;
  private Date journalDate;
  private String voucherStatus;
  private String voucherStatusName;
  private String statusName;
  private String barcode;
  private String barcodeName;
  private String barName;
  private String approver;
  private String approverId;
  private String setBookName;
  private String lastUpdateBy;
  private Date lastUpdateDate;
  private String journalNum;
  private String matchMode;
  private String matchModeName;
  private String batchName;
  private String journalSubName;
  private String invoiceNum;
  private String checkStatus;
  private String checkStatusName;
  private BigDecimal voucherAmount;
  private String abstracts;
  private String boeNum;
  private String apJournalNum;
  private String checkPersonId;
  private String submitPersonId;
  private Long companyId;
  private String companyCode;
  private String companyName;
  private String voucherMarker;
  private String imageNumber;
  private String taskNum;
  private String beginID;
  private String endID;
  private String begin_created_date;
  private String end_created_date;
  private String begin_approver_date;
  private String end_approver_date;
  private BigDecimal voucherAmountFrom;
  private BigDecimal voucherAmountTo;
  private String setOfBooksCode;
  private String deptCode;
  private String voucherSeqValue;
  private String invoiceTypeCode;
  private String deptName;
  private String blurQuery;
  private String serialNum;
  private String voucherMarkerStr;
  private String imageCount;
  private String invoiceType2;
  private String addVoucherFlag;
  
  public String getInvoiceType2()
  {
    return this.invoiceType2;
  }
  
  public void setInvoiceType2(String paramString)
  {
    this.invoiceType2 = paramString;
  }
  
  public String getAddVoucherFlag()
  {
    return this.addVoucherFlag;
  }
  
  public void setAddVoucherFlag(String paramString)
  {
    this.addVoucherFlag = paramString;
  }
  
  public String getImageCount()
  {
    return this.imageCount;
  }
  
  public void setImageCount(String paramString)
  {
    this.imageCount = paramString;
  }
  
  public String getSerialNum()
  {
    return this.serialNum;
  }
  
  public void setSerialNum(String paramString)
  {
    this.serialNum = paramString;
  }
  
  public String getVoucherMarker()
  {
    return this.voucherMarker;
  }
  
  public void setVoucherMarker(String paramString)
  {
    this.voucherMarker = paramString;
  }
  
  public String getBlurQuery()
  {
    return this.blurQuery;
  }
  
  public void setBlurQuery(String paramString)
  {
    this.blurQuery = paramString;
  }
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
  }
  
  public String getApJournalNum()
  {
    return this.apJournalNum;
  }
  
  public void setApJournalNum(String paramString)
  {
    this.apJournalNum = paramString;
  }
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
  
  public String getCheckStatus()
  {
    return this.checkStatus;
  }
  
  public void setCheckStatus(String paramString)
  {
    this.checkStatus = paramString;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public String getSubDocName()
  {
    return this.subDocName;
  }
  
  public void setSubDocName(String paramString)
  {
    this.subDocName = paramString;
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public void setSource(String paramString)
  {
    this.source = paramString;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public void setInvoiceType(String paramString)
  {
    this.invoiceType = paramString;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public Date getCreatedDate()
  {
    return this.createdDate;
  }
  
  public void setCreatedDate(Date paramDate)
  {
    this.createdDate = paramDate;
  }
  
  public String getVoucherStatus()
  {
    return this.voucherStatus;
  }
  
  public void setVoucherStatus(String paramString)
  {
    this.voucherStatus = paramString;
  }
  
  public String getBarcode()
  {
    return this.barcode;
  }
  
  public void setBarcode(String paramString)
  {
    this.barcode = paramString;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
  }
  
  public String getApprover()
  {
    return this.approver;
  }
  
  public void setApprover(String paramString)
  {
    this.approver = paramString;
  }
  
  public Date getApproverDate()
  {
    return this.approverDate;
  }
  
  public void setApproverDate(Date paramDate)
  {
    this.approverDate = paramDate;
  }
  
  public String getLastUpdateBy()
  {
    return this.lastUpdateBy;
  }
  
  public void setLastUpdateBy(String paramString)
  {
    this.lastUpdateBy = paramString;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public String getStatusName()
  {
    return EvsStatusUtil.getVoucherStatusName(this.voucherStatus);
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public String getBarName()
  {
    return EvsStatusUtil.getBarcode(this.voucherStatus, this.barcode);
  }
  
  public void setBarName(String paramString)
  {
    this.barName = paramString;
  }
  
  public String getJournalSubName()
  {
    return this.journalSubName;
  }
  
  public void setJournalSubName(String paramString)
  {
    this.journalSubName = paramString;
  }
  
  public String getInvoiceNum()
  {
    return this.invoiceNum;
  }
  
  public void setInvoiceNum(String paramString)
  {
    this.invoiceNum = paramString;
  }
  
  public String getMatchMode()
  {
    return this.matchMode;
  }
  
  public void setMatchMode(String paramString)
  {
    this.matchMode = paramString;
  }
  
  public String getBatchName()
  {
    return this.batchName;
  }
  
  public void setBatchName(String paramString)
  {
    this.batchName = paramString;
  }
  
  public String getCheckStatusName()
  {
    return this.checkStatusName;
  }
  
  public void setCheckStatusName(String paramString)
  {
    this.checkStatusName = paramString;
  }
  
  public BigDecimal getVoucherAmount()
  {
    return this.voucherAmount;
  }
  
  public void setVoucherAmount(BigDecimal paramBigDecimal)
  {
    this.voucherAmount = paramBigDecimal;
  }
  
  public String getAbstracts()
  {
    return this.abstracts;
  }
  
  public void setAbstracts(String paramString)
  {
    this.abstracts = paramString;
  }
  
  public String getCheckPersonId()
  {
    return this.checkPersonId;
  }
  
  public void setCheckPersonId(String paramString)
  {
    this.checkPersonId = paramString;
  }
  
  public String getSubmitPersonId()
  {
    return this.submitPersonId;
  }
  
  public void setSubmitPersonId(String paramString)
  {
    this.submitPersonId = paramString;
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
  
  public String getVoucherStatusName()
  {
    return this.voucherStatusName;
  }
  
  public void setVoucherStatusName(String paramString)
  {
    this.voucherStatusName = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getBeginID()
  {
    return this.beginID;
  }
  
  public void setBeginID(String paramString)
  {
    this.beginID = paramString;
  }
  
  public String getEndID()
  {
    return this.endID;
  }
  
  public void setEndID(String paramString)
  {
    this.endID = paramString;
  }
  
  public String getBegin_created_date()
  {
    return this.begin_created_date;
  }
  
  public void setBegin_created_date(String paramString)
  {
    this.begin_created_date = paramString;
  }
  
  public String getEnd_created_date()
  {
    return this.end_created_date;
  }
  
  public void setEnd_created_date(String paramString)
  {
    this.end_created_date = paramString;
  }
  
  public BigDecimal getVoucherAmountFrom()
  {
    return this.voucherAmountFrom;
  }
  
  public void setVoucherAmountFrom(BigDecimal paramBigDecimal)
  {
    this.voucherAmountFrom = paramBigDecimal;
  }
  
  public BigDecimal getVoucherAmountTo()
  {
    return this.voucherAmountTo;
  }
  
  public void setVoucherAmountTo(BigDecimal paramBigDecimal)
  {
    this.voucherAmountTo = paramBigDecimal;
  }
  
  public Long getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(Long paramLong)
  {
    this.userId = paramLong;
  }
  
  public Date getJournalDate()
  {
    return this.journalDate;
  }
  
  public void setJournalDate(Date paramDate)
  {
    this.journalDate = paramDate;
  }
  
  public String getInvoiceTypeCode()
  {
    return this.invoiceTypeCode;
  }
  
  public void setInvoiceTypeCode(String paramString)
  {
    this.invoiceTypeCode = paramString;
  }
  
  public String getMatchModeName()
  {
    return this.matchModeName;
  }
  
  public void setMatchModeName(String paramString)
  {
    this.matchModeName = paramString;
  }
  
  public String getSetOfBooksCode()
  {
    return this.setOfBooksCode;
  }
  
  public void setSetOfBooksCode(String paramString)
  {
    this.setOfBooksCode = paramString;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public String getVoucherSeqValue()
  {
    return this.voucherSeqValue;
  }
  
  public void setVoucherSeqValue(String paramString)
  {
    this.voucherSeqValue = paramString;
  }
  
  public String getBarcodeName()
  {
    return EvsStatusUtil.getBarcode(this.voucherStatus, this.barcode);
  }
  
  public String getVoucherMarkerStr()
  {
    return this.voucherMarkerStr;
  }
  
  public void setVoucherMarkerStr(String paramString)
  {
    this.voucherMarkerStr = paramString;
  }
  
  public void setBarcodeName(String paramString)
  {
    this.barcodeName = paramString;
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
  
  public String getApproverId()
  {
    return this.approverId;
  }
  
  public void setApproverId(String paramString)
  {
    this.approverId = paramString;
  }
  
  public String getBegin_approver_date()
  {
    return this.begin_approver_date;
  }
  
  public void setBegin_approver_date(String paramString)
  {
    this.begin_approver_date = paramString;
  }
  
  public String getEnd_approver_date()
  {
    return this.end_approver_date;
  }
  
  public void setEnd_approver_date(String paramString)
  {
    this.end_approver_date = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherV
 * JD-Core Version:    0.7.0.1
 */