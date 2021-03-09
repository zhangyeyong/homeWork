package com.zte.evs.ebill.model.archives;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EvsFindVoucherV
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected BigInteger voucherId;
  protected String journalName;
  protected String journalNum;
  protected Date journalDate;
  protected String journalDateStr;
  protected String voucherStatus;
  protected String invoiceType;
  protected String bookCode;
  protected String packageCode;
  protected Long companyId;
  protected String periodName;
  protected String invoiceTypeCode;
  
  public EvsFindVoucherV() {}
  
  public EvsFindVoucherV(BigInteger paramBigInteger, String paramString1, String paramString2, Date paramDate, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    setVoucherId(paramBigInteger);
    setJournalName(paramString1);
    setJournalNum(paramString2);
    setJournalDate(paramDate);
    setVoucherStatus(paramString3);
    setInvoiceType(paramString4);
    setBookCode(paramString5);
    setPackageCode(paramString6);
  }
  
  public BigInteger getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(BigInteger paramBigInteger)
  {
    this.voucherId = paramBigInteger;
  }
  
  public String getJournalName()
  {
    return this.journalName;
  }
  
  public void setJournalName(String paramString)
  {
    this.journalName = paramString;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public Date getJournalDate()
  {
    return this.journalDate;
  }
  
  public void setJournalDate(Date paramDate)
  {
    this.journalDate = paramDate;
  }
  
  public String getVoucherStatus()
  {
    return this.voucherStatus;
  }
  
  public void setVoucherStatus(String paramString)
  {
    this.voucherStatus = paramString;
  }
  
  public String getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public void setInvoiceType(String paramString)
  {
    this.invoiceType = paramString;
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
  
  public String getJournalDateStr()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (this.journalDate != null) {
      this.journalDateStr = localSimpleDateFormat.format(this.journalDate);
    }
    return this.journalDateStr;
  }
  
  public void setJournalDateStr(String paramString)
  {
    this.journalDateStr = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getInvoiceTypeCode()
  {
    return this.invoiceTypeCode;
  }
  
  public void setInvoiceTypeCode(String paramString)
  {
    this.invoiceTypeCode = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.archives.EvsFindVoucherV
 * JD-Core Version:    0.7.0.1
 */