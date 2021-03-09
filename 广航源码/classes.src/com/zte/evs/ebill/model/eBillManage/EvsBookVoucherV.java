package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsBookVoucherV
  implements Serializable
{
  private static final long serialVersionUID = 4554642438861795845L;
  private String bookId;
  private String bookCode;
  private String voucherId;
  private String journalNum;
  private Date bookDate;
  private String beginNum;
  private String endNum;
  private String periodName;
  private String bookStatus;
  private String companyCode;
  private String invoiceType;
  private String bookBreakFlag;
  
  public String getBookId()
  {
    return this.bookId;
  }
  
  public void setBookId(String paramString)
  {
    this.bookId = paramString;
  }
  
  public String getBookCode()
  {
    return this.bookCode;
  }
  
  public void setBookCode(String paramString)
  {
    this.bookCode = paramString;
  }
  
  public String getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(String paramString)
  {
    this.voucherId = paramString;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
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
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getBookStatus()
  {
    return this.bookStatus;
  }
  
  public void setBookStatus(String paramString)
  {
    this.bookStatus = paramString;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public void setInvoiceType(String paramString)
  {
    this.invoiceType = paramString;
  }
  
  public String getBookBreakFlag()
  {
    return this.bookBreakFlag;
  }
  
  public void setBookBreakFlag(String paramString)
  {
    this.bookBreakFlag = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsBookVoucherV
 * JD-Core Version:    0.7.0.1
 */