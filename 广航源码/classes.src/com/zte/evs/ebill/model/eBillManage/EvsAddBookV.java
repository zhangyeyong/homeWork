package com.zte.evs.ebill.model.eBillManage;

import com.zte.evs.ebill.common.EvsStatusUtil;
import java.io.Serializable;
import java.util.Date;

public class EvsAddBookV
  implements Serializable
{
  private String bookCode;
  private String setBookName;
  private String setBookCode;
  private String unitName;
  private String periodName;
  private String smaName;
  private String bookPeople;
  private Date bookDate;
  private String beginNum;
  private String endNum;
  private String bookBreakFlag;
  private String bookStatus;
  private Long packageId;
  private Long bookId;
  private String deadline;
  private String statusName;
  private String invoiceType;
  private String operateUserId;
  private String ouName;
  private String docName;
  private String bookBreakFlagName;
  private String archiveNumber;
  private String packageCode;
  
  public String getPackageCode()
  {
    return this.packageCode;
  }
  
  public void setPackageCode(String paramString)
  {
    this.packageCode = paramString;
  }
  
  public EvsAddBookV() {}
  
  public EvsAddBookV(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Date paramDate, String paramString6, String paramString7, String paramString8, String paramString9, Long paramLong, String paramString10, String paramString11, String paramString12)
  {
    this.bookCode = paramString1;
    this.unitName = paramString2;
    this.periodName = paramString3;
    this.smaName = paramString4;
    this.bookPeople = paramString5;
    this.bookDate = paramDate;
    this.beginNum = paramString6;
    this.endNum = paramString7;
    this.bookBreakFlag = paramString8;
    this.bookStatus = paramString9;
    this.packageId = paramLong;
    this.setBookName = paramString10;
    this.invoiceType = paramString11;
    this.invoiceType = paramString11;
    this.setBookName = paramString10;
    this.bookBreakFlagName = this.bookBreakFlagName;
    this.deadline = paramString12;
  }
  
  public String getBookCode()
  {
    return this.bookCode;
  }
  
  public void setBookCode(String paramString)
  {
    this.bookCode = paramString;
  }
  
  public String getUnitName()
  {
    return this.unitName;
  }
  
  public void setUnitName(String paramString)
  {
    this.unitName = paramString;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getSmaName()
  {
    return this.smaName;
  }
  
  public void setSmaName(String paramString)
  {
    this.smaName = paramString;
  }
  
  public String getBookPeople()
  {
    return this.bookPeople;
  }
  
  public void setBookPeople(String paramString)
  {
    this.bookPeople = paramString;
  }
  
  public Date getBookDate()
  {
    return this.bookDate;
  }
  
  public void setBookDate(Date paramDate)
  {
    this.bookDate = paramDate;
  }
  
  public String getBeginNum()
  {
    if ((this.beginNum != null) && (!"".equals(this.beginNum))) {
      return this.beginNum;
    }
    return "";
  }
  
  public void setBeginNum(String paramString)
  {
    this.beginNum = paramString;
  }
  
  public String getEndNum()
  {
    if ((this.endNum != null) && (!"".equals(this.endNum))) {
      return this.endNum;
    }
    return "";
  }
  
  public void setEndNum(String paramString)
  {
    this.endNum = paramString;
  }
  
  public String getBookBreakFlag()
  {
    return this.bookBreakFlag;
  }
  
  public void setBookBreakFlag(String paramString)
  {
    this.bookBreakFlag = paramString;
  }
  
  public String getBookStatus()
  {
    return this.bookStatus;
  }
  
  public void setBookStatus(String paramString)
  {
    this.bookStatus = paramString;
  }
  
  public Long getPackageId()
  {
    return this.packageId;
  }
  
  public void setPackageId(Long paramLong)
  {
    this.packageId = paramLong;
  }
  
  public String getStatusName()
  {
    if (this.bookStatus != null) {
      return EvsStatusUtil.getVoucherStatusName(this.bookStatus);
    }
    return this.bookStatus;
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public String getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public void setInvoiceType(String paramString)
  {
    this.invoiceType = paramString;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
  }
  
  public String getBookBreakFlagName()
  {
    return EvsStatusUtil.getbookBreakFlag(this.bookBreakFlag);
  }
  
  public void setBookBreakFlagName(String paramString)
  {
    this.bookBreakFlagName = paramString;
  }
  
  public String getSetBookCode()
  {
    return this.setBookCode;
  }
  
  public void setSetBookCode(String paramString)
  {
    this.setBookCode = paramString;
  }
  
  public String getOperateUserId()
  {
    return this.operateUserId;
  }
  
  public void setOperateUserId(String paramString)
  {
    this.operateUserId = paramString;
  }
  
  public Long getBookId()
  {
    return this.bookId;
  }
  
  public void setBookId(Long paramLong)
  {
    this.bookId = paramLong;
  }
  
  public String getOuName()
  {
    return this.ouName;
  }
  
  public void setOuName(String paramString)
  {
    this.ouName = paramString;
  }
  
  public String getDocName()
  {
    return this.docName;
  }
  
  public void setDocName(String paramString)
  {
    this.docName = paramString;
  }
  
  public String getDeadline()
  {
    return this.deadline;
  }
  
  public void setDeadline(String paramString)
  {
    this.deadline = paramString;
  }
  
  public String getArchiveNumber()
  {
    return this.archiveNumber;
  }
  
  public void setArchiveNumber(String paramString)
  {
    this.archiveNumber = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsAddBookV
 * JD-Core Version:    0.7.0.1
 */