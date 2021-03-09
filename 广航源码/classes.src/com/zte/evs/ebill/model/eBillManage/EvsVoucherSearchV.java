package com.zte.evs.ebill.model.eBillManage;

import com.zte.evs.ebill.common.EvsStatusUtil;
import java.io.Serializable;
import java.util.Date;

public class EvsVoucherSearchV
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long num;
  private Long voucherId;
  private String journalNum;
  private String bookCode;
  private String subDocName;
  private String setBookName;
  private String source;
  private Long ouId;
  private String ouName;
  private String periodName;
  private String invoiceType;
  private String userName;
  private String approver;
  private Date createdDate;
  private Date approverDate;
  private String barcode;
  private String voucherStatus;
  private String bookStatus;
  private String barName;
  private String voucherStatusName;
  private String archiveNumber;
  private Long bookId;
  private Date journalDate;
  private String boeNum;
  private String companyCode;
  private String invoiceTypeCode;
  private String deptName;
  private String companyName;
  private String matchMode;
  private Long companyId;
  private String abstracts;
  private String setOfBooksCode;
  private String voucherSeqValue;
  private String deptCode;
  private Long userId;
  private Long approverId;
  private String voucherMarker;
  private Long invCityId;
  private String invStorageCode;
  private String invArea;
  private String invRow;
  private String invColumn;
  private String invLevel;
  private String storeAddress;
  
  public Long getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(Long paramLong)
  {
    this.userId = paramLong;
  }
  
  public Long getApproverId()
  {
    return this.approverId;
  }
  
  public void setApproverId(Long paramLong)
  {
    this.approverId = paramLong;
  }
  
  public EvsVoucherSearchV() {}
  
  public EvsVoucherSearchV(Long paramLong1, Long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, Date paramDate1, Date paramDate2, String paramString11, String paramString12, String paramString13, Long paramLong3)
  {
    this.num = paramLong1;
    this.voucherId = paramLong2;
    this.journalNum = paramString1;
    this.bookCode = paramString2;
    this.subDocName = paramString3;
    this.setBookName = paramString4;
    this.source = paramString5;
    this.ouName = paramString6;
    this.periodName = paramString7;
    this.invoiceType = paramString8;
    this.userName = paramString9;
    this.approver = paramString10;
    this.createdDate = paramDate1;
    this.approverDate = paramDate2;
    this.barcode = paramString11;
    this.voucherStatus = paramString12;
    this.bookStatus = paramString13;
    this.ouId = paramLong3;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public String getBookCode()
  {
    return this.bookCode;
  }
  
  public void setBookCode(String paramString)
  {
    this.bookCode = paramString;
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public void setSource(String paramString)
  {
    this.source = paramString;
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
  
  public String getSubDocName()
  {
    return this.subDocName;
  }
  
  public void setSubDocName(String paramString)
  {
    this.subDocName = paramString;
  }
  
  public String getBarcode()
  {
    return this.barcode;
  }
  
  public void setBarcode(String paramString)
  {
    this.barcode = paramString;
  }
  
  public String getVoucherStatus()
  {
    return this.voucherStatus;
  }
  
  public void setVoucherStatus(String paramString)
  {
    this.voucherStatus = paramString;
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
  
  public String getBookStatus()
  {
    return this.bookStatus;
  }
  
  public void setBookStatus(String paramString)
  {
    this.bookStatus = paramString;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public String getVoucherStatusName()
  {
    if (this.voucherStatus != null) {
      return EvsStatusUtil.getVoucherStatusName(this.voucherStatus);
    }
    return this.voucherStatus;
  }
  
  public void setVoucherStatusName(String paramString)
  {
    this.voucherStatusName = this.voucherStatus;
  }
  
  public static long getSerialVersionUID()
  {
    return 1L;
  }
  
  public Long getOuId()
  {
    return this.ouId;
  }
  
  public void setOuId(Long paramLong)
  {
    this.ouId = paramLong;
  }
  
  public Long getNum()
  {
    return this.num;
  }
  
  public void setNum(Long paramLong)
  {
    this.num = paramLong;
  }
  
  public String getBarName()
  {
    return EvsStatusUtil.getBarcode(this.voucherStatus, this.barcode);
  }
  
  public void setBarName(String paramString)
  {
    this.barName = paramString;
  }
  
  public String getArchiveNumber()
  {
    return this.archiveNumber;
  }
  
  public void setArchiveNumber(String paramString)
  {
    this.archiveNumber = paramString;
  }
  
  public Long getBookId()
  {
    return this.bookId;
  }
  
  public void setBookId(Long paramLong)
  {
    this.bookId = paramLong;
  }
  
  public Date getJournalDate()
  {
    return this.journalDate;
  }
  
  public void setJournalDate(Date paramDate)
  {
    this.journalDate = paramDate;
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
  
  public String getInvoiceTypeCode()
  {
    return this.invoiceTypeCode;
  }
  
  public void setInvoiceTypeCode(String paramString)
  {
    this.invoiceTypeCode = paramString;
  }
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getMatchMode()
  {
    return this.matchMode;
  }
  
  public void setMatchMode(String paramString)
  {
    this.matchMode = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getAbstracts()
  {
    return this.abstracts;
  }
  
  public void setAbstracts(String paramString)
  {
    this.abstracts = paramString;
  }
  
  public String getSetOfBooksCode()
  {
    return this.setOfBooksCode;
  }
  
  public void setSetOfBooksCode(String paramString)
  {
    this.setOfBooksCode = paramString;
  }
  
  public String getVoucherSeqValue()
  {
    return this.voucherSeqValue;
  }
  
  public void setVoucherSeqValue(String paramString)
  {
    this.voucherSeqValue = paramString;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public String getVoucherMarker()
  {
    return this.voucherMarker;
  }
  
  public void setVoucherMarker(String paramString)
  {
    this.voucherMarker = paramString;
  }
  
  public Long getInvCityId()
  {
    return this.invCityId;
  }
  
  public void setInvCityId(Long paramLong)
  {
    this.invCityId = paramLong;
  }
  
  public String getInvStorageCode()
  {
    return this.invStorageCode;
  }
  
  public void setInvStorageCode(String paramString)
  {
    this.invStorageCode = paramString;
  }
  
  public String getInvArea()
  {
    return this.invArea;
  }
  
  public void setInvArea(String paramString)
  {
    this.invArea = paramString;
  }
  
  public String getInvRow()
  {
    return this.invRow;
  }
  
  public void setInvRow(String paramString)
  {
    this.invRow = paramString;
  }
  
  public String getInvColumn()
  {
    return this.invColumn;
  }
  
  public void setInvColumn(String paramString)
  {
    this.invColumn = paramString;
  }
  
  public String getInvLevel()
  {
    return this.invLevel;
  }
  
  public void setInvLevel(String paramString)
  {
    this.invLevel = paramString;
  }
  
  public String getStoreAddress()
  {
    return this.storeAddress;
  }
  
  public void setStoreAddress(String paramString)
  {
    this.storeAddress = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherSearchV
 * JD-Core Version:    0.7.0.1
 */