package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsVoucherImageV
  extends BaseObject
  implements Serializable
{
  protected BigInteger imageId;
  protected BigInteger voucherId;
  protected String source;
  protected String boeNum;
  protected String deptCode;
  protected Date lastUpdateDate;
  protected String logo;
  protected String journalName;
  protected String page;
  protected String barcodeUrl;
  protected String vendorNumber;
  protected String vendorName;
  protected String vendorLocation;
  protected Date journalDate;
  protected Date createdDate;
  protected Date approverDate;
  protected Date invoiceDate;
  protected String invoiceType;
  protected String batchName;
  protected String journalNum;
  protected String eventTypeName;
  protected String currencyCode;
  protected BigInteger invoiceId;
  protected String invoiceNum;
  protected String orgCharge;
  protected String userName;
  protected String approver;
  protected BigInteger billNum;
  protected String sourceCode;
  protected String setBookName;
  protected BigInteger ouId;
  protected String ouName;
  protected String periodName;
  protected String payNumber;
  protected String chequeNumber;
  protected Long checkNumber;
  protected Long checkId;
  protected String journalSubName;
  protected String categoryName;
  protected BigInteger docSequenceValue;
  protected String cashier;
  protected String chamberlain;
  protected String voucherStatus;
  protected String updateStatus;
  protected String barcode;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateBy;
  protected Long lastUpdateLogin;
  protected String bookEndFlag;
  protected String originVoucherId;
  protected String historyUpdateStatus;
  protected String matchMode;
  protected String receiptNumber;
  protected String apJournalNum;
  protected String checkStatus;
  protected String voucherAbstract;
  protected Long checkPersonId;
  protected Long submitPersonId;
  protected String companyCode;
  protected String invoiceTypeCode;
  protected String userNumber;
  protected BigDecimal convertRate;
  protected BigDecimal totalCurrencyAmount;
  protected BigDecimal totalAmount;
  protected String unAccount;
  protected String currencyUnit;
  protected String batch;
  protected String jdeNumber;
  protected String accountingNo;
  protected String settlementType;
  protected String cashierNumber;
  protected String year;
  protected String month;
  protected String voucherSeqValue;
  protected String approverNumber;
  protected String operationTypeCode;
  protected String webhostUrl;
  protected String imageUrl;
  protected String localPath;
  protected String imageBarcode;
  protected BigInteger originImageId;
  protected String isShowImage;
  
  public EvsVoucherImageV() {}
  
  public EvsVoucherImageV(BigInteger paramBigInteger1, BigInteger paramBigInteger2, String paramString1, String paramString2, Date paramDate1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Date paramDate2, Date paramDate3, Date paramDate4, Date paramDate5, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, BigInteger paramBigInteger3, String paramString15, String paramString16, String paramString17, String paramString18, BigInteger paramBigInteger4, String paramString19, String paramString20, BigInteger paramBigInteger5, String paramString21, String paramString22, String paramString23, String paramString24, Long paramLong1, Long paramLong2, String paramString25, String paramString26, BigInteger paramBigInteger6, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, Date paramDate6, Long paramLong3, Long paramLong4, Long paramLong5, String paramString32, String paramString33, String paramString34, String paramString35, String paramString36, String paramString37, String paramString38, String paramString39, Long paramLong6, Long paramLong7, String paramString40, String paramString41, String paramString42, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, String paramString43, String paramString44, String paramString45, String paramString46, String paramString47, String paramString48, String paramString49, String paramString50, String paramString51, String paramString52, String paramString53, String paramString54, String paramString55, String paramString56, String paramString57, String paramString58, BigInteger paramBigInteger7, String paramString59)
  {
    setImageId(paramBigInteger1);
    setVoucherId(paramBigInteger2);
    setSource(paramString1);
    setBoeNum(paramString2);
    setLastUpdateDate(paramDate1);
    setLogo(paramString3);
    setJournalName(paramString4);
    setPage(paramString5);
    setBarcodeUrl(paramString6);
    setVendorNumber(paramString7);
    setVendorName(paramString8);
    setVendorLocation(paramString9);
    setJournalDate(paramDate2);
    setCreatedDate(paramDate3);
    setApproverDate(paramDate4);
    setInvoiceDate(paramDate5);
    setInvoiceType(paramString10);
    setBatchName(paramString11);
    setJournalNum(paramString12);
    setEventTypeName(paramString13);
    setCurrencyCode(paramString14);
    setInvoiceId(paramBigInteger3);
    setInvoiceNum(paramString15);
    setOrgCharge(paramString16);
    setUserName(paramString17);
    setApprover(paramString18);
    setBillNum(paramBigInteger4);
    setSourceCode(paramString19);
    setSetBookName(paramString20);
    setOuId(paramBigInteger5);
    setOuName(paramString21);
    setPeriodName(paramString22);
    setPayNumber(paramString23);
    setChequeNumber(paramString24);
    setCheckNumber(paramLong1);
    setCheckId(paramLong2);
    setJournalSubName(paramString25);
    setCategoryName(paramString26);
    setDocSequenceValue(paramBigInteger6);
    setCashier(paramString27);
    setChamberlain(paramString28);
    setVoucherStatus(paramString29);
    setUpdateStatus(paramString30);
    setBarcode(paramString31);
    setCreationDate(paramDate6);
    setCreatedBy(paramLong3);
    setLastUpdateBy(paramLong4);
    setLastUpdateLogin(paramLong5);
    setBookEndFlag(paramString32);
    setOriginVoucherId(paramString33);
    setHistoryUpdateStatus(paramString34);
    setMatchMode(paramString35);
    setReceiptNumber(paramString36);
    setApJournalNum(paramString37);
    setCheckStatus(paramString38);
    setvoucherAbstract(paramString39);
    setCheckPersonId(paramLong6);
    setSubmitPersonId(paramLong7);
    setCompanyCode(paramString40);
    setInvoiceTypeCode(paramString41);
    setUserNumber(paramString42);
    setConvertRate(paramBigDecimal1);
    setTotalCurrencyAmount(paramBigDecimal2);
    setTotalAmount(paramBigDecimal3);
    setUnAccount(paramString43);
    setCurrencyUnit(paramString44);
    setBatch(paramString45);
    setJdeNumber(paramString46);
    setAccountingNo(paramString47);
    setSettlementType(paramString48);
    setCashierNumber(paramString49);
    setYear(paramString50);
    setMonth(paramString51);
    setVoucherSeqValue(paramString52);
    setApproverNumber(paramString53);
    setOperationTypeCode(paramString54);
    setWebhostUrl(paramString55);
    setImageUrl(paramString56);
    setLocalPath(paramString57);
    setImageBarcode(paramString58);
    setOriginImageId(paramBigInteger7);
    setIsShowImage(paramString59);
  }
  
  public BigInteger getImageId()
  {
    return this.imageId;
  }
  
  public void setImageId(BigInteger paramBigInteger)
  {
    this.imageId = paramBigInteger;
  }
  
  public BigInteger getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(BigInteger paramBigInteger)
  {
    this.voucherId = paramBigInteger;
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public void setSource(String paramString)
  {
    this.source = paramString;
  }
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public String getLogo()
  {
    return this.logo;
  }
  
  public void setLogo(String paramString)
  {
    this.logo = paramString;
  }
  
  public String getJournalName()
  {
    return this.journalName;
  }
  
  public void setJournalName(String paramString)
  {
    this.journalName = paramString;
  }
  
  public String getPage()
  {
    return this.page;
  }
  
  public void setPage(String paramString)
  {
    this.page = paramString;
  }
  
  public String getBarcodeUrl()
  {
    return this.barcodeUrl;
  }
  
  public void setBarcodeUrl(String paramString)
  {
    this.barcodeUrl = paramString;
  }
  
  public String getVendorNumber()
  {
    return this.vendorNumber;
  }
  
  public void setVendorNumber(String paramString)
  {
    this.vendorNumber = paramString;
  }
  
  public String getVendorName()
  {
    return this.vendorName;
  }
  
  public void setVendorName(String paramString)
  {
    this.vendorName = paramString;
  }
  
  public String getVendorLocation()
  {
    return this.vendorLocation;
  }
  
  public void setVendorLocation(String paramString)
  {
    this.vendorLocation = paramString;
  }
  
  public Date getJournalDate()
  {
    return this.journalDate;
  }
  
  public void setJournalDate(Date paramDate)
  {
    this.journalDate = paramDate;
  }
  
  public Date getCreatedDate()
  {
    return this.createdDate;
  }
  
  public void setCreatedDate(Date paramDate)
  {
    this.createdDate = paramDate;
  }
  
  public Date getApproverDate()
  {
    return this.approverDate;
  }
  
  public void setApproverDate(Date paramDate)
  {
    this.approverDate = paramDate;
  }
  
  public Date getInvoiceDate()
  {
    return this.invoiceDate;
  }
  
  public void setInvoiceDate(Date paramDate)
  {
    this.invoiceDate = paramDate;
  }
  
  public String getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public void setInvoiceType(String paramString)
  {
    this.invoiceType = paramString;
  }
  
  public String getBatchName()
  {
    return this.batchName;
  }
  
  public void setBatchName(String paramString)
  {
    this.batchName = paramString;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public String getEventTypeName()
  {
    return this.eventTypeName;
  }
  
  public void setEventTypeName(String paramString)
  {
    this.eventTypeName = paramString;
  }
  
  public String getCurrencyCode()
  {
    return this.currencyCode;
  }
  
  public void setCurrencyCode(String paramString)
  {
    this.currencyCode = paramString;
  }
  
  public BigInteger getInvoiceId()
  {
    return this.invoiceId;
  }
  
  public void setInvoiceId(BigInteger paramBigInteger)
  {
    this.invoiceId = paramBigInteger;
  }
  
  public String getInvoiceNum()
  {
    return this.invoiceNum;
  }
  
  public void setInvoiceNum(String paramString)
  {
    this.invoiceNum = paramString;
  }
  
  public String getOrgCharge()
  {
    return this.orgCharge;
  }
  
  public void setOrgCharge(String paramString)
  {
    this.orgCharge = paramString;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public String getApprover()
  {
    return this.approver;
  }
  
  public void setApprover(String paramString)
  {
    this.approver = paramString;
  }
  
  public BigInteger getBillNum()
  {
    return this.billNum;
  }
  
  public void setBillNum(BigInteger paramBigInteger)
  {
    this.billNum = paramBigInteger;
  }
  
  public String getSourceCode()
  {
    return this.sourceCode;
  }
  
  public void setSourceCode(String paramString)
  {
    this.sourceCode = paramString;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
  }
  
  public BigInteger getOuId()
  {
    return this.ouId;
  }
  
  public void setOuId(BigInteger paramBigInteger)
  {
    this.ouId = paramBigInteger;
  }
  
  public String getOuName()
  {
    return this.ouName;
  }
  
  public void setOuName(String paramString)
  {
    this.ouName = paramString;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getPayNumber()
  {
    return this.payNumber;
  }
  
  public void setPayNumber(String paramString)
  {
    this.payNumber = paramString;
  }
  
  public String getChequeNumber()
  {
    return this.chequeNumber;
  }
  
  public void setChequeNumber(String paramString)
  {
    this.chequeNumber = paramString;
  }
  
  public Long getCheckNumber()
  {
    return this.checkNumber;
  }
  
  public void setCheckNumber(Long paramLong)
  {
    this.checkNumber = paramLong;
  }
  
  public Long getCheckId()
  {
    return this.checkId;
  }
  
  public void setCheckId(Long paramLong)
  {
    this.checkId = paramLong;
  }
  
  public String getJournalSubName()
  {
    return this.journalSubName;
  }
  
  public void setJournalSubName(String paramString)
  {
    this.journalSubName = paramString;
  }
  
  public String getCategoryName()
  {
    return this.categoryName;
  }
  
  public void setCategoryName(String paramString)
  {
    this.categoryName = paramString;
  }
  
  public BigInteger getDocSequenceValue()
  {
    return this.docSequenceValue;
  }
  
  public void setDocSequenceValue(BigInteger paramBigInteger)
  {
    this.docSequenceValue = paramBigInteger;
  }
  
  public String getCashier()
  {
    return this.cashier;
  }
  
  public void setCashier(String paramString)
  {
    this.cashier = paramString;
  }
  
  public String getChamberlain()
  {
    return this.chamberlain;
  }
  
  public void setChamberlain(String paramString)
  {
    this.chamberlain = paramString;
  }
  
  public String getVoucherStatus()
  {
    return this.voucherStatus;
  }
  
  public void setVoucherStatus(String paramString)
  {
    this.voucherStatus = paramString;
  }
  
  public String getUpdateStatus()
  {
    return this.updateStatus;
  }
  
  public void setUpdateStatus(String paramString)
  {
    this.updateStatus = paramString;
  }
  
  public String getBarcode()
  {
    return this.barcode;
  }
  
  public void setBarcode(String paramString)
  {
    this.barcode = paramString;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public Long getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(Long paramLong)
  {
    this.createdBy = paramLong;
  }
  
  public Long getLastUpdateBy()
  {
    return this.lastUpdateBy;
  }
  
  public void setLastUpdateBy(Long paramLong)
  {
    this.lastUpdateBy = paramLong;
  }
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public String getBookEndFlag()
  {
    return this.bookEndFlag;
  }
  
  public void setBookEndFlag(String paramString)
  {
    this.bookEndFlag = paramString;
  }
  
  public String getOriginVoucherId()
  {
    return this.originVoucherId;
  }
  
  public void setOriginVoucherId(String paramString)
  {
    this.originVoucherId = paramString;
  }
  
  public String getHistoryUpdateStatus()
  {
    return this.historyUpdateStatus;
  }
  
  public void setHistoryUpdateStatus(String paramString)
  {
    this.historyUpdateStatus = paramString;
  }
  
  public String getMatchMode()
  {
    return this.matchMode;
  }
  
  public void setMatchMode(String paramString)
  {
    this.matchMode = paramString;
  }
  
  public String getReceiptNumber()
  {
    return this.receiptNumber;
  }
  
  public void setReceiptNumber(String paramString)
  {
    this.receiptNumber = paramString;
  }
  
  public String getApJournalNum()
  {
    return this.apJournalNum;
  }
  
  public void setApJournalNum(String paramString)
  {
    this.apJournalNum = paramString;
  }
  
  public String getCheckStatus()
  {
    return this.checkStatus;
  }
  
  public void setCheckStatus(String paramString)
  {
    this.checkStatus = paramString;
  }
  
  public String getvoucherAbstract()
  {
    return this.voucherAbstract;
  }
  
  public void setvoucherAbstract(String paramString)
  {
    this.voucherAbstract = paramString;
  }
  
  public Long getCheckPersonId()
  {
    return this.checkPersonId;
  }
  
  public void setCheckPersonId(Long paramLong)
  {
    this.checkPersonId = paramLong;
  }
  
  public Long getSubmitPersonId()
  {
    return this.submitPersonId;
  }
  
  public void setSubmitPersonId(Long paramLong)
  {
    this.submitPersonId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getInvoiceTypeCode()
  {
    return this.invoiceTypeCode;
  }
  
  public void setInvoiceTypeCode(String paramString)
  {
    this.invoiceTypeCode = paramString;
  }
  
  public String getUserNumber()
  {
    return this.userNumber;
  }
  
  public void setUserNumber(String paramString)
  {
    this.userNumber = paramString;
  }
  
  public BigDecimal getConvertRate()
  {
    return this.convertRate;
  }
  
  public void setConvertRate(BigDecimal paramBigDecimal)
  {
    this.convertRate = paramBigDecimal;
  }
  
  public BigDecimal getTotalCurrencyAmount()
  {
    return this.totalCurrencyAmount;
  }
  
  public void setTotalCurrencyAmount(BigDecimal paramBigDecimal)
  {
    this.totalCurrencyAmount = paramBigDecimal;
  }
  
  public BigDecimal getTotalAmount()
  {
    return this.totalAmount;
  }
  
  public void setTotalAmount(BigDecimal paramBigDecimal)
  {
    this.totalAmount = paramBigDecimal;
  }
  
  public String getUnAccount()
  {
    return this.unAccount;
  }
  
  public void setUnAccount(String paramString)
  {
    this.unAccount = paramString;
  }
  
  public String getCurrencyUnit()
  {
    return this.currencyUnit;
  }
  
  public void setCurrencyUnit(String paramString)
  {
    this.currencyUnit = paramString;
  }
  
  public String getBatch()
  {
    return this.batch;
  }
  
  public void setBatch(String paramString)
  {
    this.batch = paramString;
  }
  
  public String getJdeNumber()
  {
    return this.jdeNumber;
  }
  
  public void setJdeNumber(String paramString)
  {
    this.jdeNumber = paramString;
  }
  
  public String getAccountingNo()
  {
    return this.accountingNo;
  }
  
  public void setAccountingNo(String paramString)
  {
    this.accountingNo = paramString;
  }
  
  public String getSettlementType()
  {
    return this.settlementType;
  }
  
  public void setSettlementType(String paramString)
  {
    this.settlementType = paramString;
  }
  
  public String getCashierNumber()
  {
    return this.cashierNumber;
  }
  
  public void setCashierNumber(String paramString)
  {
    this.cashierNumber = paramString;
  }
  
  public String getYear()
  {
    return this.year;
  }
  
  public void setYear(String paramString)
  {
    this.year = paramString;
  }
  
  public String getMonth()
  {
    return this.month;
  }
  
  public void setMonth(String paramString)
  {
    this.month = paramString;
  }
  
  public String getVoucherSeqValue()
  {
    return this.voucherSeqValue;
  }
  
  public void setVoucherSeqValue(String paramString)
  {
    this.voucherSeqValue = paramString;
  }
  
  public String getApproverNumber()
  {
    return this.approverNumber;
  }
  
  public void setApproverNumber(String paramString)
  {
    this.approverNumber = paramString;
  }
  
  public String getOperationTypeCode()
  {
    return this.operationTypeCode;
  }
  
  public void setOperationTypeCode(String paramString)
  {
    this.operationTypeCode = paramString;
  }
  
  public String getWebhostUrl()
  {
    return this.webhostUrl;
  }
  
  public void setWebhostUrl(String paramString)
  {
    this.webhostUrl = paramString;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public void setImageUrl(String paramString)
  {
    this.imageUrl = paramString;
  }
  
  public String getLocalPath()
  {
    return this.localPath;
  }
  
  public void setLocalPath(String paramString)
  {
    this.localPath = paramString;
  }
  
  public String getImageBarcode()
  {
    return this.imageBarcode;
  }
  
  public void setImageBarcode(String paramString)
  {
    this.imageBarcode = paramString;
  }
  
  public BigInteger getOriginImageId()
  {
    return this.originImageId;
  }
  
  public void setOriginImageId(BigInteger paramBigInteger)
  {
    this.originImageId = paramBigInteger;
  }
  
  public String getIsShowImage()
  {
    return this.isShowImage;
  }
  
  public void setIsShowImage(String paramString)
  {
    this.isShowImage = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsVoucherImageV)) {
      return false;
    }
    EvsVoucherImageV localEvsVoucherImageV = (EvsVoucherImageV)paramObject;
    return new EqualsBuilder().append(this.imageId, localEvsVoucherImageV.imageId).append(this.voucherId, localEvsVoucherImageV.voucherId).append(this.source, localEvsVoucherImageV.source).append(this.boeNum, localEvsVoucherImageV.boeNum).append(this.lastUpdateDate, localEvsVoucherImageV.lastUpdateDate).append(this.logo, localEvsVoucherImageV.logo).append(this.journalName, localEvsVoucherImageV.journalName).append(this.page, localEvsVoucherImageV.page).append(this.barcodeUrl, localEvsVoucherImageV.barcodeUrl).append(this.vendorNumber, localEvsVoucherImageV.vendorNumber).append(this.vendorName, localEvsVoucherImageV.vendorName).append(this.vendorLocation, localEvsVoucherImageV.vendorLocation).append(this.journalDate, localEvsVoucherImageV.journalDate).append(this.createdDate, localEvsVoucherImageV.createdDate).append(this.approverDate, localEvsVoucherImageV.approverDate).append(this.invoiceDate, localEvsVoucherImageV.invoiceDate).append(this.invoiceType, localEvsVoucherImageV.invoiceType).append(this.batchName, localEvsVoucherImageV.batchName).append(this.journalNum, localEvsVoucherImageV.journalNum).append(this.eventTypeName, localEvsVoucherImageV.eventTypeName).append(this.currencyCode, localEvsVoucherImageV.currencyCode).append(this.invoiceId, localEvsVoucherImageV.invoiceId).append(this.invoiceNum, localEvsVoucherImageV.invoiceNum).append(this.orgCharge, localEvsVoucherImageV.orgCharge).append(this.userName, localEvsVoucherImageV.userName).append(this.approver, localEvsVoucherImageV.approver).append(this.billNum, localEvsVoucherImageV.billNum).append(this.sourceCode, localEvsVoucherImageV.sourceCode).append(this.setBookName, localEvsVoucherImageV.setBookName).append(this.ouId, localEvsVoucherImageV.ouId).append(this.ouName, localEvsVoucherImageV.ouName).append(this.periodName, localEvsVoucherImageV.periodName).append(this.payNumber, localEvsVoucherImageV.payNumber).append(this.chequeNumber, localEvsVoucherImageV.chequeNumber).append(this.checkNumber, localEvsVoucherImageV.checkNumber).append(this.checkId, localEvsVoucherImageV.checkId).append(this.journalSubName, localEvsVoucherImageV.journalSubName).append(this.categoryName, localEvsVoucherImageV.categoryName).append(this.docSequenceValue, localEvsVoucherImageV.docSequenceValue).append(this.cashier, localEvsVoucherImageV.cashier).append(this.chamberlain, localEvsVoucherImageV.chamberlain).append(this.voucherStatus, localEvsVoucherImageV.voucherStatus).append(this.updateStatus, localEvsVoucherImageV.updateStatus).append(this.barcode, localEvsVoucherImageV.barcode).append(this.creationDate, localEvsVoucherImageV.creationDate).append(this.createdBy, localEvsVoucherImageV.createdBy).append(this.lastUpdateBy, localEvsVoucherImageV.lastUpdateBy).append(this.lastUpdateLogin, localEvsVoucherImageV.lastUpdateLogin).append(this.bookEndFlag, localEvsVoucherImageV.bookEndFlag).append(this.originVoucherId, localEvsVoucherImageV.originVoucherId).append(this.historyUpdateStatus, localEvsVoucherImageV.historyUpdateStatus).append(this.matchMode, localEvsVoucherImageV.matchMode).append(this.receiptNumber, localEvsVoucherImageV.receiptNumber).append(this.apJournalNum, localEvsVoucherImageV.apJournalNum).append(this.checkStatus, localEvsVoucherImageV.checkStatus).append(this.voucherAbstract, localEvsVoucherImageV.voucherAbstract).append(this.checkPersonId, localEvsVoucherImageV.checkPersonId).append(this.submitPersonId, localEvsVoucherImageV.submitPersonId).append(this.companyCode, localEvsVoucherImageV.companyCode).append(this.invoiceTypeCode, localEvsVoucherImageV.invoiceTypeCode).append(this.userNumber, localEvsVoucherImageV.userNumber).append(this.convertRate, localEvsVoucherImageV.convertRate).append(this.totalCurrencyAmount, localEvsVoucherImageV.totalCurrencyAmount).append(this.totalAmount, localEvsVoucherImageV.totalAmount).append(this.unAccount, localEvsVoucherImageV.unAccount).append(this.currencyUnit, localEvsVoucherImageV.currencyUnit).append(this.batch, localEvsVoucherImageV.batch).append(this.jdeNumber, localEvsVoucherImageV.jdeNumber).append(this.accountingNo, localEvsVoucherImageV.accountingNo).append(this.settlementType, localEvsVoucherImageV.settlementType).append(this.cashierNumber, localEvsVoucherImageV.cashierNumber).append(this.year, localEvsVoucherImageV.year).append(this.month, localEvsVoucherImageV.month).append(this.voucherSeqValue, localEvsVoucherImageV.voucherSeqValue).append(this.approverNumber, localEvsVoucherImageV.approverNumber).append(this.operationTypeCode, localEvsVoucherImageV.operationTypeCode).append(this.webhostUrl, localEvsVoucherImageV.webhostUrl).append(this.imageUrl, localEvsVoucherImageV.imageUrl).append(this.localPath, localEvsVoucherImageV.localPath).append(this.imageBarcode, localEvsVoucherImageV.imageBarcode).append(this.originImageId, localEvsVoucherImageV.originImageId).append(this.isShowImage, localEvsVoucherImageV.isShowImage).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.imageId).append(this.voucherId).append(this.source).append(this.boeNum).append(this.lastUpdateDate).append(this.logo).append(this.journalName).append(this.page).append(this.barcodeUrl).append(this.vendorNumber).append(this.vendorName).append(this.vendorLocation).append(this.journalDate).append(this.createdDate).append(this.approverDate).append(this.invoiceDate).append(this.invoiceType).append(this.batchName).append(this.journalNum).append(this.eventTypeName).append(this.currencyCode).append(this.invoiceId).append(this.invoiceNum).append(this.orgCharge).append(this.userName).append(this.approver).append(this.billNum).append(this.sourceCode).append(this.setBookName).append(this.ouId).append(this.ouName).append(this.periodName).append(this.payNumber).append(this.chequeNumber).append(this.checkNumber).append(this.checkId).append(this.journalSubName).append(this.categoryName).append(this.docSequenceValue).append(this.cashier).append(this.chamberlain).append(this.voucherStatus).append(this.updateStatus).append(this.barcode).append(this.creationDate).append(this.createdBy).append(this.lastUpdateBy).append(this.lastUpdateLogin).append(this.bookEndFlag).append(this.originVoucherId).append(this.historyUpdateStatus).append(this.matchMode).append(this.receiptNumber).append(this.apJournalNum).append(this.checkStatus).append(this.voucherAbstract).append(this.checkPersonId).append(this.submitPersonId).append(this.companyCode).append(this.invoiceTypeCode).append(this.userNumber).append(this.convertRate).append(this.totalCurrencyAmount).append(this.totalAmount).append(this.unAccount).append(this.currencyUnit).append(this.batch).append(this.jdeNumber).append(this.accountingNo).append(this.settlementType).append(this.cashierNumber).append(this.year).append(this.month).append(this.voucherSeqValue).append(this.approverNumber).append(this.operationTypeCode).append(this.webhostUrl).append(this.imageUrl).append(this.localPath).append(this.imageBarcode).append(this.originImageId).append(this.isShowImage).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("imageId", this.imageId).append("voucherId", this.voucherId).append("source", this.source).append("boeNum", this.boeNum).append("lastUpdateDate", this.lastUpdateDate).append("logo", this.logo).append("journalName", this.journalName).append("page", this.page).append("barcodeUrl", this.barcodeUrl).append("vendorNumber", this.vendorNumber).append("vendorName", this.vendorName).append("vendorLocation", this.vendorLocation).append("journalDate", this.journalDate).append("createdDate", this.createdDate).append("approverDate", this.approverDate).append("invoiceDate", this.invoiceDate).append("invoiceType", this.invoiceType).append("batchName", this.batchName).append("journalNum", this.journalNum).append("eventTypeName", this.eventTypeName).append("currencyCode", this.currencyCode).append("invoiceId", this.invoiceId).append("invoiceNum", this.invoiceNum).append("orgCharge", this.orgCharge).append("userName", this.userName).append("approver", this.approver).append("billNum", this.billNum).append("sourceCode", this.sourceCode).append("setBookName", this.setBookName).append("ouId", this.ouId).append("ouName", this.ouName).append("periodName", this.periodName).append("payNumber", this.payNumber).append("chequeNumber", this.chequeNumber).append("checkNumber", this.checkNumber).append("checkId", this.checkId).append("journalSubName", this.journalSubName).append("categoryName", this.categoryName).append("docSequenceValue", this.docSequenceValue).append("cashier", this.cashier).append("chamberlain", this.chamberlain).append("voucherStatus", this.voucherStatus).append("updateStatus", this.updateStatus).append("barcode", this.barcode).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateBy", this.lastUpdateBy).append("lastUpdateLogin", this.lastUpdateLogin).append("bookEndFlag", this.bookEndFlag).append("originVoucherId", this.originVoucherId).append("historyUpdateStatus", this.historyUpdateStatus).append("matchMode", this.matchMode).append("receiptNumber", this.receiptNumber).append("apJournalNum", this.apJournalNum).append("checkStatus", this.checkStatus).append("voucherAbstract", this.voucherAbstract).append("checkPersonId", this.checkPersonId).append("submitPersonId", this.submitPersonId).append("companyCode", this.companyCode).append("invoiceTypeCode", this.invoiceTypeCode).append("userNumber", this.userNumber).append("convertRate", this.convertRate).append("totalCurrencyAmount", this.totalCurrencyAmount).append("totalAmount", this.totalAmount).append("unAccount", this.unAccount).append("currencyUnit", this.currencyUnit).append("batch", this.batch).append("jdeNumber", this.jdeNumber).append("accountingNo", this.accountingNo).append("settlementType", this.settlementType).append("cashierNumber", this.cashierNumber).append("year", this.year).append("month", this.month).append("voucherSeqValue", this.voucherSeqValue).append("approverNumber", this.approverNumber).append("operationTypeCode", this.operationTypeCode).append("webhostUrl", this.webhostUrl).append("imageUrl", this.imageUrl).append("localPath", this.localPath).append("imageBarcode", this.imageBarcode).append("originImageId", this.originImageId).append("isShowImage", this.isShowImage).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getVoucherAbstract()
  {
    return this.voucherAbstract;
  }
  
  public void setVoucherAbstract(String paramString)
  {
    this.voucherAbstract = paramString;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherImageV
 * JD-Core Version:    0.7.0.1
 */