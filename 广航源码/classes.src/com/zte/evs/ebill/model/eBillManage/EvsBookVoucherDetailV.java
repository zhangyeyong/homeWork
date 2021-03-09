package com.zte.evs.ebill.model.eBillManage;

import com.zte.evs.ebill.common.EvsStatusUtil;
import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsBookVoucherDetailV
  extends BaseObject
  implements Serializable
{
  protected BigInteger num;
  protected BigInteger voucherId;
  protected String bookCode;
  protected String packageCode;
  protected String journalNum;
  protected String subDocName;
  protected String setBookName;
  protected String source;
  protected String ouId;
  protected String ouName;
  protected String periodName;
  protected String invoiceType;
  protected String userName;
  protected String approver;
  protected Date createdDate;
  protected Date approverDate;
  protected String barcode;
  protected String voucherStatus;
  protected String bookStatus;
  protected String boxStatus;
  protected String archiveNumber;
  protected String beginNum;
  protected String endNum;
  protected Date bookDate;
  protected String bookEmployeeId;
  protected String matchMode;
  protected String beginID;
  protected String endID;
  protected String beginBook;
  protected String endBook;
  protected String beginBox;
  protected String endBox;
  protected String begin_Created_Date;
  protected String end_Created_Date;
  protected String begin_Approver_Date;
  protected String end_Approver_Date;
  protected String begin_Book_Date;
  protected String end_Book_Date;
  private String barName;
  private String voucherStatusName;
  private String invoiceFstTypeName;
  
  public EvsBookVoucherDetailV() {}
  
  public EvsBookVoucherDetailV(BigInteger paramBigInteger1, BigInteger paramBigInteger2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, Date paramDate1, Date paramDate2, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, Date paramDate3, String paramString20)
  {
    setNum(paramBigInteger1);
    setVoucherId(paramBigInteger2);
    setBookCode(paramString1);
    setPackageCode(paramString2);
    setJournalNum(paramString3);
    setSubDocName(paramString4);
    setSetBookName(paramString5);
    setSource(paramString6);
    setOuId(paramString7);
    setOuName(paramString8);
    setPeriodName(paramString9);
    setInvoiceType(paramString10);
    setUserName(paramString11);
    setApprover(paramString12);
    setCreatedDate(paramDate1);
    setApproverDate(paramDate2);
    setBarcode(paramString13);
    setVoucherStatus(paramString14);
    setBookStatus(this.bookStatus);
    setBoxStatus(this.boxStatus);
    setArchiveNumber(paramString17);
    setBeginNum(paramString18);
    setEndNum(paramString19);
    setBookDate(paramDate3);
    setBookEmployeeId(paramString20);
  }
  
  public BigInteger getNum()
  {
    return this.num;
  }
  
  public void setNum(BigInteger paramBigInteger)
  {
    this.num = paramBigInteger;
  }
  
  public BigInteger getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(BigInteger paramBigInteger)
  {
    this.voucherId = paramBigInteger;
  }
  
  public String getBookCode()
  {
    return this.bookCode;
  }
  
  public void setBookCode(String paramString)
  {
    this.bookCode = paramString;
  }
  
  public String getPackageCode()
  {
    return this.packageCode;
  }
  
  public void setPackageCode(String paramString)
  {
    this.packageCode = paramString;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public String getSubDocName()
  {
    return this.subDocName;
  }
  
  public void setSubDocName(String paramString)
  {
    this.subDocName = paramString;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
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
  
  public String getApprover()
  {
    return this.approver;
  }
  
  public void setApprover(String paramString)
  {
    this.approver = paramString;
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
  
  public String getArchiveNumber()
  {
    return this.archiveNumber;
  }
  
  public void setArchiveNumber(String paramString)
  {
    this.archiveNumber = paramString;
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
  
  public Date getBookDate()
  {
    return this.bookDate;
  }
  
  public void setBookDate(Date paramDate)
  {
    this.bookDate = paramDate;
  }
  
  public String getBookEmployeeId()
  {
    return this.bookEmployeeId;
  }
  
  public void setBookEmployeeId(String paramString)
  {
    this.bookEmployeeId = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsBookVoucherDetailV)) {
      return false;
    }
    EvsBookVoucherDetailV localEvsBookVoucherDetailV = (EvsBookVoucherDetailV)paramObject;
    return new EqualsBuilder().append(this.num, localEvsBookVoucherDetailV.num).append(this.voucherId, localEvsBookVoucherDetailV.voucherId).append(this.bookCode, localEvsBookVoucherDetailV.bookCode).append(this.packageCode, localEvsBookVoucherDetailV.packageCode).append(this.journalNum, localEvsBookVoucherDetailV.journalNum).append(this.subDocName, localEvsBookVoucherDetailV.subDocName).append(this.setBookName, localEvsBookVoucherDetailV.setBookName).append(this.source, localEvsBookVoucherDetailV.source).append(this.ouId, localEvsBookVoucherDetailV.ouId).append(this.ouName, localEvsBookVoucherDetailV.ouName).append(this.periodName, localEvsBookVoucherDetailV.periodName).append(this.invoiceType, localEvsBookVoucherDetailV.invoiceType).append(this.userName, localEvsBookVoucherDetailV.userName).append(this.approver, localEvsBookVoucherDetailV.approver).append(this.createdDate, localEvsBookVoucherDetailV.createdDate).append(this.approverDate, localEvsBookVoucherDetailV.approverDate).append(this.barcode, localEvsBookVoucherDetailV.barcode).append(this.voucherStatus, localEvsBookVoucherDetailV.voucherStatus).append(this.bookStatus, localEvsBookVoucherDetailV.bookStatus).append(this.boxStatus, localEvsBookVoucherDetailV.boxStatus).append(this.archiveNumber, localEvsBookVoucherDetailV.archiveNumber).append(this.beginNum, localEvsBookVoucherDetailV.beginNum).append(this.endNum, localEvsBookVoucherDetailV.endNum).append(this.bookDate, localEvsBookVoucherDetailV.bookDate).append(this.bookEmployeeId, localEvsBookVoucherDetailV.bookEmployeeId).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.num).append(this.voucherId).append(this.bookCode).append(this.packageCode).append(this.journalNum).append(this.subDocName).append(this.setBookName).append(this.source).append(this.ouId).append(this.ouName).append(this.periodName).append(this.invoiceType).append(this.userName).append(this.approver).append(this.createdDate).append(this.approverDate).append(this.barcode).append(this.voucherStatus).append(this.bookStatus).append(this.boxStatus).append(this.archiveNumber).append(this.beginNum).append(this.endNum).append(this.bookDate).append(this.bookEmployeeId).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("num", this.num).append("voucherId", this.voucherId).append("bookCode", this.bookCode).append("packageCode", this.packageCode).append("journalNum", this.journalNum).append("subDocName", this.subDocName).append("setBookName", this.setBookName).append("source", this.source).append("ouId", this.ouId).append("ouName", this.ouName).append("periodName", this.periodName).append("invoiceType", this.invoiceType).append("userName", this.userName).append("approver", this.approver).append("createdDate", this.createdDate).append("approverDate", this.approverDate).append("barcode", this.barcode).append("voucherStatus", this.voucherStatus).append("bookStatus", this.bookStatus).append("boxStatus", this.boxStatus).append("archiveNumber", this.archiveNumber).append("beginNum", this.beginNum).append("endNum", this.endNum).append("bookDate", this.bookDate).append("bookEmployeeId", this.bookEmployeeId).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
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
  
  public String getBegin_Created_Date()
  {
    return this.begin_Created_Date;
  }
  
  public void setBegin_Created_Date(String paramString)
  {
    this.begin_Created_Date = paramString;
  }
  
  public String getEnd_Created_Date()
  {
    return this.end_Created_Date;
  }
  
  public void setEnd_Created_Date(String paramString)
  {
    this.end_Created_Date = paramString;
  }
  
  public String getBegin_Approver_Date()
  {
    return this.begin_Approver_Date;
  }
  
  public void setBegin_Approver_Date(String paramString)
  {
    this.begin_Approver_Date = paramString;
  }
  
  public String getEnd_Approver_Date()
  {
    return this.end_Approver_Date;
  }
  
  public void setEnd_Approver_Date(String paramString)
  {
    this.end_Approver_Date = paramString;
  }
  
  public String getBegin_Book_Date()
  {
    return this.begin_Book_Date;
  }
  
  public void setBegin_Book_Date(String paramString)
  {
    this.begin_Book_Date = paramString;
  }
  
  public String getEnd_Book_Date()
  {
    return this.end_Book_Date;
  }
  
  public void setEnd_Book_Date(String paramString)
  {
    this.end_Book_Date = paramString;
  }
  
  public String getMatchMode()
  {
    return this.matchMode;
  }
  
  public void setMatchMode(String paramString)
  {
    this.matchMode = paramString;
  }
  
  public String getBarName()
  {
    return EvsStatusUtil.getBarcode(this.voucherStatus, this.barcode);
  }
  
  public void setBarName(String paramString)
  {
    this.barName = paramString;
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
    this.voucherStatusName = paramString;
  }
  
  public String getInvoiceFstTypeName()
  {
    return this.invoiceFstTypeName;
  }
  
  public void setInvoiceFstTypeName(String paramString)
  {
    this.invoiceFstTypeName = paramString;
  }
  
  public String getOuId()
  {
    return this.ouId;
  }
  
  public void setOuId(String paramString)
  {
    this.ouId = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsBookVoucherDetailV
 * JD-Core Version:    0.7.0.1
 */