package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EvsVoucher
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long voucherId;
  private String source;
  private String boeNum;
  private Date lastUpdateDate;
  private String logo;
  private String journalName;
  private String page;
  private String barcodeUrl;
  private String vendorNumber;
  private String vendorName;
  private String vendorLocation;
  private Date journalDate;
  private Date createdDate;
  private Date approverDate;
  private Date invoiceDate;
  private String invoiceDateStr;
  private String invoiceType;
  private String batchName;
  private String journalNum;
  private String eventTypeName;
  private String currencyCode;
  private Long invoiceId;
  private String invoiceNum;
  private String orgCharge;
  private String userName;
  private String approver;
  private String billNum;
  private String sourceCode;
  private String setBookName;
  private Long ouId;
  private String ouName;
  private String periodName;
  private String payNumber;
  private String chequeNumber;
  private Long checkNumber;
  private Long checkId;
  private String journalSubName;
  private String categoryName;
  private Long docSequenceValue;
  private String cashier;
  private String chamberlain;
  private String voucherStatus;
  private String updateStatus;
  private String updateHistoryStatus;
  private String barcode;
  private Date creationDate;
  private Long createdBy;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private String bookEndFlag;
  private String matchMode;
  private String checkStatus;
  private String abstracts;
  private String receiptNumber;
  private String apJournalNum;
  private String companyCode;
  private String invoiceTypeCode;
  private String userNumber;
  private BigDecimal convertRate;
  private BigDecimal totalCurrencyAmount;
  private BigDecimal totalAmount;
  private String unAccount;
  private String currencyUnit;
  private String batch;
  private String jdeNumber;
  private String accountingNo;
  private String settlementType;
  private String cashierNumber;
  private String year;
  private String month;
  private String voucherSeqValue;
  private String approverNumber;
  private String voucherMarker;
  protected String financeExecutive;
  protected String financeController;
  private String addVoucherFlag;
  
  public String getAddVoucherFlag()
  {
    return this.addVoucherFlag;
  }
  
  public void setAddVoucherFlag(String paramString)
  {
    this.addVoucherFlag = paramString;
  }
  
  public String getFinanceExecutive()
  {
    return this.financeExecutive;
  }
  
  public void setFinanceExecutive(String paramString)
  {
    this.financeExecutive = paramString;
  }
  
  public String getFinanceController()
  {
    return this.financeController;
  }
  
  public void setFinanceController(String paramString)
  {
    this.financeController = paramString;
  }
  
  public String getVoucherMarker()
  {
    return this.voucherMarker;
  }
  
  public void setVoucherMarker(String paramString)
  {
    this.voucherMarker = paramString;
  }
  
  public String getApJournalNum()
  {
    return this.apJournalNum;
  }
  
  public void setApJournalNum(String paramString)
  {
    this.apJournalNum = paramString;
  }
  
  public String getAbstracts()
  {
    return this.abstracts;
  }
  
  public void setAbstracts(String paramString)
  {
    this.abstracts = paramString;
  }
  
  public String getCheckStatus()
  {
    return this.checkStatus;
  }
  
  public void setCheckStatus(String paramString)
  {
    this.checkStatus = paramString;
  }
  
  public EvsVoucher() {}
  
  public EvsVoucher(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public EvsVoucher(Long paramLong1, String paramString1, String paramString2, Date paramDate1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Date paramDate2, Date paramDate3, Date paramDate4, Date paramDate5, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, Long paramLong2, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, Long paramLong3, String paramString22, String paramString23, String paramString24, String paramString25, Long paramLong4, Long paramLong5, String paramString26, String paramString27, Long paramLong6, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32, String paramString33, Date paramDate6, Long paramLong7, Long paramLong8, Long paramLong9, String paramString34, String paramString35)
  {
    this.voucherId = paramLong1;
    this.source = paramString1;
    this.boeNum = paramString2;
    this.lastUpdateDate = paramDate1;
    this.logo = paramString3;
    this.journalName = paramString4;
    this.page = paramString5;
    this.barcodeUrl = paramString6;
    this.vendorNumber = paramString7;
    this.vendorName = paramString8;
    this.vendorLocation = paramString9;
    this.journalDate = paramDate2;
    this.createdDate = paramDate3;
    this.approverDate = paramDate4;
    this.invoiceDate = paramDate5;
    this.invoiceType = paramString10;
    this.batchName = paramString11;
    this.journalNum = paramString12;
    this.eventTypeName = paramString13;
    this.currencyCode = paramString14;
    this.invoiceId = paramLong2;
    this.invoiceNum = paramString15;
    this.orgCharge = paramString16;
    this.userName = paramString17;
    this.approver = paramString18;
    this.billNum = paramString19;
    this.sourceCode = paramString20;
    this.setBookName = paramString21;
    this.ouId = paramLong3;
    this.ouName = paramString22;
    this.periodName = paramString23;
    this.payNumber = paramString24;
    this.chequeNumber = paramString25;
    this.checkNumber = paramLong4;
    this.checkId = paramLong5;
    this.journalSubName = paramString26;
    this.categoryName = paramString27;
    this.docSequenceValue = paramLong6;
    this.cashier = paramString28;
    this.chamberlain = paramString29;
    this.voucherStatus = paramString30;
    this.updateStatus = paramString31;
    this.updateHistoryStatus = paramString32;
    this.barcode = paramString33;
    this.creationDate = paramDate6;
    this.createdBy = paramLong7;
    this.lastUpdateBy = paramLong8;
    this.lastUpdateLogin = paramLong9;
    this.bookEndFlag = paramString34;
    this.matchMode = paramString35;
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public void setSource(String paramString)
  {
    this.source = paramString;
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
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (this.invoiceDateStr != null) {
      try
      {
        this.invoiceDate = localSimpleDateFormat.parse(this.invoiceDateStr);
      }
      catch (ParseException localParseException)
      {
        localParseException.printStackTrace();
      }
    }
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
  
  public Long getInvoiceId()
  {
    return this.invoiceId;
  }
  
  public void setInvoiceId(Long paramLong)
  {
    this.invoiceId = paramLong;
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
  
  public String getBillNum()
  {
    return this.billNum;
  }
  
  public void setBillNum(String paramString)
  {
    this.billNum = paramString;
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
  
  public Long getOuId()
  {
    return this.ouId;
  }
  
  public void setOuId(Long paramLong)
  {
    this.ouId = paramLong;
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
  
  public String getCategoryName()
  {
    return this.categoryName;
  }
  
  public void setCategoryName(String paramString)
  {
    this.categoryName = paramString;
  }
  
  public Long getDocSequenceValue()
  {
    return this.docSequenceValue;
  }
  
  public void setDocSequenceValue(Long paramLong)
  {
    this.docSequenceValue = paramLong;
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
  
  public String getUpdateStatus()
  {
    return this.updateStatus;
  }
  
  public void setUpdateStatus(String paramString)
  {
    this.updateStatus = paramString;
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
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
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
  
  public String getBookEndFlag()
  {
    return this.bookEndFlag;
  }
  
  public void setBookEndFlag(String paramString)
  {
    this.bookEndFlag = paramString;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public String getBarcodeUrl()
  {
    return this.barcodeUrl;
  }
  
  public void setBarcodeUrl(String paramString)
  {
    this.barcodeUrl = paramString;
  }
  
  public String getJournalSubName()
  {
    return this.journalSubName;
  }
  
  public void setJournalSubName(String paramString)
  {
    this.journalSubName = paramString;
  }
  
  public String getUpdateHistoryStatus()
  {
    return this.updateHistoryStatus;
  }
  
  public void setUpdateHistoryStatus(String paramString)
  {
    this.updateHistoryStatus = paramString;
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
  
  public String getInvoiceDateStr()
  {
    return this.invoiceDateStr;
  }
  
  public void setInvoiceDateStr(String paramString)
  {
    this.invoiceDateStr = paramString;
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
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
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
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucher
 * JD-Core Version:    0.7.0.1
 */