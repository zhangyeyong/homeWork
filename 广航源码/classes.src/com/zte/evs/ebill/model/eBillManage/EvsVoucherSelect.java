package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.math.BigDecimal;

public class EvsVoucherSelect
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long voucherId;
  private Long journalNum;
  private String beginID;
  private String endID;
  private String set_book_name;
  private String ou_id;
  private String period_name;
  private String invoiceFstType;
  private String invoiceType;
  private String source_code;
  private String voucherStatus;
  private String user_name;
  private Long userId;
  private String begin_created_date;
  private String end_created_date;
  private String approver;
  private String begin_approver_date;
  private String end_approver_date;
  private String barcode;
  private String lastUpdateBy;
  private String begin_last_update_date;
  private String end_last_update_date;
  private String invoiceFstTypeName;
  private String journalSubName;
  private String invoiceNum;
  private String matchModes;
  private String selectbarCode;
  private String scanVoucherNum;
  private BigDecimal voucherAmountFrom;
  private BigDecimal voucherAmountTo;
  private String abstracts;
  private String boeNum;
  private String companyId;
  private String companyCode;
  private String companyName;
  private String isLikeQuery;
  private String taskNum;
  private String imageNumber;
  private String numberType;
  private String number;
  private Long maxNum;
  private String addVoucherFlag;
  private String remark;
  private Long approverId;
  private String voucherMarker;
  private Long bookId;
  private Long bookSum;
  private Long bookCount;
  private String companyCode1;
  private String archiveNumber;
  private String beginNum;
  private String endNum;
  private String bookCode;
  private String serialNum;
  private String deptCode;
  private String subdoccode;
  private String periodDate;
  private String boeTypeCode;
  private String unitCode;
  private String doccode;
  
  public String getDoccode()
  {
    return this.doccode;
  }
  
  public void setDoccode(String paramString)
  {
    this.doccode = paramString;
  }
  
  public String getSerialNum()
  {
    return this.serialNum;
  }
  
  public void setSerialNum(String paramString)
  {
    this.serialNum = paramString;
  }
  
  public String getBeginNum()
  {
    return this.beginNum;
  }
  
  public void setBeginNum(String paramString)
  {
    this.beginNum = paramString;
  }
  
  public String getEndNum()
  {
    return this.endNum;
  }
  
  public void setEndNum(String paramString)
  {
    this.endNum = paramString;
  }
  
  public String getArchiveNumber()
  {
    return this.archiveNumber;
  }
  
  public void setArchiveNumber(String paramString)
  {
    this.archiveNumber = paramString;
  }
  
  public String getIsLikeQuery()
  {
    return this.isLikeQuery;
  }
  
  public String getVoucherMarker()
  {
    return this.voucherMarker;
  }
  
  public String getTaskNum()
  {
    return this.taskNum;
  }
  
  public void setTaskNum(String paramString)
  {
    this.taskNum = paramString;
  }
  
  public void setVoucherMarker(String paramString)
  {
    this.voucherMarker = paramString;
  }
  
  public void setIsLikeQuery(String paramString)
  {
    this.isLikeQuery = paramString;
  }
  
  public String getAbstracts()
  {
    return this.abstracts;
  }
  
  public void setAbstracts(String paramString)
  {
    this.abstracts = paramString;
  }
  
  public EvsVoucherSelect(Long paramLong1, Long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, Long paramLong3, Long paramLong4, Long paramLong5, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31)
  {
    this.voucherId = paramLong1;
    this.journalNum = paramLong2;
    this.beginID = paramString1;
    this.endID = paramString2;
    this.set_book_name = paramString3;
    this.ou_id = paramString4;
    this.period_name = paramString5;
    this.invoiceFstType = paramString6;
    this.invoiceType = paramString7;
    this.source_code = paramString8;
    this.voucherStatus = paramString9;
    this.user_name = paramString10;
    this.begin_created_date = paramString11;
    this.end_created_date = paramString12;
    this.approver = paramString13;
    this.begin_approver_date = paramString14;
    this.end_approver_date = paramString15;
    this.barcode = paramString16;
    this.lastUpdateBy = paramString17;
    this.begin_last_update_date = paramString18;
    this.end_last_update_date = paramString19;
    this.invoiceFstTypeName = paramString20;
    this.journalSubName = paramString21;
    this.invoiceNum = paramString22;
    this.matchModes = paramString23;
    this.selectbarCode = paramString24;
    this.scanVoucherNum = paramString25;
    this.bookId = paramLong3;
    this.bookSum = paramLong4;
    this.bookCount = paramLong5;
    this.companyCode1 = paramString26;
    this.archiveNumber = paramString27;
    this.beginNum = paramString28;
    this.endNum = paramString29;
    this.bookCode = paramString30;
    this.serialNum = paramString31;
  }
  
  public EvsVoucherSelect() {}
  
  public Long getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(Long paramLong)
  {
    this.journalNum = paramLong;
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
  
  public String getSet_book_name()
  {
    return this.set_book_name;
  }
  
  public void setSet_book_name(String paramString)
  {
    this.set_book_name = paramString;
  }
  
  public String getOu_id()
  {
    return this.ou_id;
  }
  
  public void setOu_id(String paramString)
  {
    this.ou_id = paramString;
  }
  
  public String getPeriod_name()
  {
    return this.period_name;
  }
  
  public void setPeriod_name(String paramString)
  {
    this.period_name = paramString;
  }
  
  public String getInvoiceFstType()
  {
    return this.invoiceFstType;
  }
  
  public void setInvoiceFstType(String paramString)
  {
    this.invoiceFstType = paramString;
  }
  
  public String getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public void setInvoiceType(String paramString)
  {
    this.invoiceType = paramString;
  }
  
  public String getSource_code()
  {
    return this.source_code;
  }
  
  public void setSource_code(String paramString)
  {
    this.source_code = paramString;
  }
  
  public String getVoucherStatus()
  {
    return this.voucherStatus;
  }
  
  public void setVoucherStatus(String paramString)
  {
    this.voucherStatus = paramString;
  }
  
  public String getUser_name()
  {
    return this.user_name;
  }
  
  public void setUser_name(String paramString)
  {
    this.user_name = paramString;
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
  
  public String getApprover()
  {
    return this.approver;
  }
  
  public void setApprover(String paramString)
  {
    this.approver = paramString;
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
  
  public String getBarcode()
  {
    return this.barcode;
  }
  
  public void setBarcode(String paramString)
  {
    this.barcode = paramString;
  }
  
  public String getLastUpdateBy()
  {
    return this.lastUpdateBy;
  }
  
  public void setLastUpdateBy(String paramString)
  {
    this.lastUpdateBy = paramString;
  }
  
  public String getBegin_last_update_date()
  {
    return this.begin_last_update_date;
  }
  
  public void setBegin_last_update_date(String paramString)
  {
    this.begin_last_update_date = paramString;
  }
  
  public String getEnd_last_update_date()
  {
    return this.end_last_update_date;
  }
  
  public void setEnd_last_update_date(String paramString)
  {
    this.end_last_update_date = paramString;
  }
  
  public static long getSerialVersionUID()
  {
    return 1L;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public String getInvoiceFstTypeName()
  {
    return this.invoiceFstTypeName;
  }
  
  public void setInvoiceFstTypeName(String paramString)
  {
    this.invoiceFstTypeName = paramString;
  }
  
  public String getMatchModes()
  {
    return this.matchModes;
  }
  
  public void setMatchModes(String paramString)
  {
    this.matchModes = paramString;
  }
  
  public String getSelectbarCode()
  {
    return this.selectbarCode;
  }
  
  public void setSelectbarCode(String paramString)
  {
    this.selectbarCode = paramString;
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
  
  public String getScanVoucherNum()
  {
    return this.scanVoucherNum;
  }
  
  public void setScanVoucherNum(String paramString)
  {
    this.scanVoucherNum = paramString;
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
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
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
  
  public Long getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(Long paramLong)
  {
    this.userId = paramLong;
  }
  
  public String getImageNumber()
  {
    return this.imageNumber;
  }
  
  public void setImageNumber(String paramString)
  {
    this.imageNumber = paramString;
  }
  
  public String getNumberType()
  {
    return this.numberType;
  }
  
  public void setNumberType(String paramString)
  {
    this.numberType = paramString;
  }
  
  public String getNumber()
  {
    return this.number;
  }
  
  public void setNumber(String paramString)
  {
    this.number = paramString;
  }
  
  public Long getMaxNum()
  {
    return this.maxNum;
  }
  
  public void setMaxNum(Long paramLong)
  {
    this.maxNum = paramLong;
  }
  
  public String getAddVoucherFlag()
  {
    return this.addVoucherFlag;
  }
  
  public void setAddVoucherFlag(String paramString)
  {
    this.addVoucherFlag = paramString;
  }
  
  public Long getBookSum()
  {
    return this.bookSum;
  }
  
  public void setBookSum(Long paramLong)
  {
    this.bookSum = paramLong;
  }
  
  public Long getBookCount()
  {
    return this.bookCount;
  }
  
  public void setBookCount(Long paramLong)
  {
    this.bookCount = paramLong;
  }
  
  public Long getBookId()
  {
    return this.bookId;
  }
  
  public void setBookId(Long paramLong)
  {
    this.bookId = paramLong;
  }
  
  public String getCompanyCode1()
  {
    return this.companyCode1;
  }
  
  public void setCompanyCode1(String paramString)
  {
    this.companyCode1 = this.companyCode;
  }
  
  public String getBookCode()
  {
    return this.bookCode;
  }
  
  public void setBookCode(String paramString)
  {
    this.bookCode = paramString;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public String getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(String paramString)
  {
    this.companyId = paramString;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public String getSubdoccode()
  {
    return this.subdoccode;
  }
  
  public void setSubdoccode(String paramString)
  {
    this.subdoccode = paramString;
  }
  
  public String getPeriodDate()
  {
    return this.periodDate;
  }
  
  public void setPeriodDate(String paramString)
  {
    this.periodDate = paramString;
  }
  
  public String getBoeTypeCode()
  {
    return this.boeTypeCode;
  }
  
  public void setBoeTypeCode(String paramString)
  {
    this.boeTypeCode = paramString;
  }
  
  public String getUnitCode()
  {
    return this.unitCode;
  }
  
  public void setUnitCode(String paramString)
  {
    this.unitCode = paramString;
  }
  
  public Long getApproverId()
  {
    return this.approverId;
  }
  
  public void setApproverId(Long paramLong)
  {
    this.approverId = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect
 * JD-Core Version:    0.7.0.1
 */