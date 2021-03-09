package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;

public class EvsVoucherVo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String beginID;
  private String endID;
  private String beginBook;
  private String endBook;
  private String beginBox;
  private String endBox;
  private String set_book_name;
  private String ou_id;
  private String period_name;
  private String invoiceFstType;
  private String invoiceFstTypeName;
  private String invoiceType;
  private String invoiceTypeName;
  private String source_code;
  private String status;
  private String bookStatus;
  private String boxStatus;
  private String user_name;
  private String begin_created_date;
  private String end_created_date;
  private String approver;
  private String begin_approver_date;
  private String end_approver_date;
  private String bookId;
  private String companyCode;
  private String matchMode;
  private String deptId;
  private String boeNum;
  private String theMaxTotal;
  private String companyName;
  private String journalDatePeriod;
  private String userInfoPk;
  private String isLikeQuery;
  private Long userId;
  private Long approverId;
  private String bookCodeCount;
  private String voucherMarker;
  private String barcode;
  
  public String getBookCodeCount()
  {
    return this.bookCodeCount;
  }
  
  public void setBookCodeCount(String paramString)
  {
    this.bookCodeCount = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getTheMaxTotal()
  {
    return this.theMaxTotal;
  }
  
  public void setTheMaxTotal(String paramString)
  {
    this.theMaxTotal = paramString;
  }
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
  
  public String getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(String paramString)
  {
    this.deptId = paramString;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getInvoiceFstTypeName()
  {
    return this.invoiceFstTypeName;
  }
  
  public void setInvoiceFstTypeName(String paramString)
  {
    this.invoiceFstTypeName = paramString;
  }
  
  public String getInvoiceTypeName()
  {
    return this.invoiceTypeName;
  }
  
  public void setInvoiceTypeName(String paramString)
  {
    this.invoiceTypeName = paramString;
  }
  
  public static long getSerialVersionUID()
  {
    return 1L;
  }
  
  public EvsVoucherVo() {}
  
  public EvsVoucherVo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
  {
    this.endBox = paramString1;
    this.set_book_name = paramString2;
    this.ou_id = paramString3;
    this.period_name = paramString4;
    this.invoiceFstType = paramString5;
    this.invoiceType = paramString6;
    this.source_code = paramString7;
    this.status = paramString8;
    this.bookStatus = paramString9;
    this.boxStatus = paramString10;
    this.user_name = paramString11;
    this.begin_created_date = paramString12;
    this.end_created_date = paramString13;
    this.approver = paramString14;
    this.begin_approver_date = paramString15;
    this.end_approver_date = paramString16;
    this.invoiceTypeName = paramString17;
    this.invoiceFstTypeName = paramString18;
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
  
  public String getBeginBook()
  {
    return this.beginBook;
  }
  
  public void setBeginBook(String paramString)
  {
    this.beginBook = paramString;
  }
  
  public String getEndBook()
  {
    return this.endBook;
  }
  
  public void setEndBook(String paramString)
  {
    this.endBook = paramString;
  }
  
  public String getBeginBox()
  {
    return this.beginBox;
  }
  
  public void setBeginBox(String paramString)
  {
    this.beginBox = paramString;
  }
  
  public String getEndBox()
  {
    return this.endBox;
  }
  
  public void setEndBox(String paramString)
  {
    this.endBox = paramString;
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
  
  public String getSource_code()
  {
    return this.source_code;
  }
  
  public void setSource_code(String paramString)
  {
    this.source_code = paramString;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public String getBookStatus()
  {
    return this.bookStatus;
  }
  
  public void setBookStatus(String paramString)
  {
    this.bookStatus = paramString;
  }
  
  public String getBoxStatus()
  {
    return this.boxStatus;
  }
  
  public void setBoxStatus(String paramString)
  {
    this.boxStatus = paramString;
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
  
  public String getBookId()
  {
    return this.bookId;
  }
  
  public void setBookId(String paramString)
  {
    this.bookId = paramString;
  }
  
  public String getMatchMode()
  {
    return this.matchMode;
  }
  
  public void setMatchMode(String paramString)
  {
    this.matchMode = paramString;
  }
  
  public String getJournalDatePeriod()
  {
    return this.journalDatePeriod;
  }
  
  public void setJournalDatePeriod(String paramString)
  {
    this.journalDatePeriod = paramString;
  }
  
  public String getUserInfoPk()
  {
    return this.userInfoPk;
  }
  
  public void setUserInfoPk(String paramString)
  {
    this.userInfoPk = paramString;
  }
  
  public String getIsLikeQuery()
  {
    return this.isLikeQuery;
  }
  
  public void setIsLikeQuery(String paramString)
  {
    this.isLikeQuery = paramString;
  }
  
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
  
  public String getVoucherMarker()
  {
    return this.voucherMarker;
  }
  
  public void setVoucherMarker(String paramString)
  {
    this.voucherMarker = paramString;
  }
  
  public String getBarcode()
  {
    return this.barcode;
  }
  
  public void setBarcode(String paramString)
  {
    this.barcode = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherVo
 * JD-Core Version:    0.7.0.1
 */