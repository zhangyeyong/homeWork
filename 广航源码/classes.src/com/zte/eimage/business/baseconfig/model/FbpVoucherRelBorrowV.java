package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FbpVoucherRelBorrowV
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Long archivesLineId;
  protected Long archivesHeaderId;
  protected BigInteger voucherId;
  protected String journalNum;
  protected String userName;
  protected Date createdDate;
  protected Date journalDate;
  protected String journalDateStr;
  protected String invoiceType;
  protected String setBookName;
  protected String voucherStatus;
  protected String periodName;
  protected String barcodeUrl;
  protected String journalName;
  protected String page;
  protected Long companyId;
  protected String companyName;
  protected String meaning;
  protected Date startDate;
  protected Date endDate;
  
  public FbpVoucherRelBorrowV(Long paramLong1, Long paramLong2, BigInteger paramBigInteger, String paramString1, String paramString2, Date paramDate1, Date paramDate2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, Long paramLong3, String paramString11, String paramString12, Date paramDate3, Date paramDate4)
  {
    this.archivesLineId = paramLong1;
    this.archivesHeaderId = paramLong2;
    this.voucherId = paramBigInteger;
    this.journalNum = paramString1;
    this.userName = paramString2;
    this.createdDate = paramDate1;
    this.journalDate = paramDate2;
    this.journalDateStr = paramString3;
    this.invoiceType = paramString4;
    this.setBookName = paramString5;
    this.voucherStatus = paramString6;
    this.periodName = paramString7;
    this.barcodeUrl = paramString8;
    this.journalName = paramString9;
    this.page = paramString10;
    this.companyId = paramLong3;
    this.companyName = paramString11;
    this.meaning = paramString12;
    this.startDate = paramDate3;
    this.endDate = paramDate4;
  }
  
  public FbpVoucherRelBorrowV() {}
  
  public Long getArchivesLineId()
  {
    return this.archivesLineId;
  }
  
  public void setArchivesLineId(Long paramLong)
  {
    this.archivesLineId = paramLong;
  }
  
  public Long getArchivesHeaderId()
  {
    return this.archivesHeaderId;
  }
  
  public void setArchivesHeaderId(Long paramLong)
  {
    this.archivesHeaderId = paramLong;
  }
  
  public BigInteger getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(BigInteger paramBigInteger)
  {
    this.voucherId = paramBigInteger;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
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
  
  public Date getJournalDate()
  {
    return this.journalDate;
  }
  
  public void setJournalDate(Date paramDate)
  {
    this.journalDate = paramDate;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
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
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getVoucherStatus()
  {
    return this.voucherStatus;
  }
  
  public void setVoucherStatus(String paramString)
  {
    this.voucherStatus = paramString;
  }
  
  public String getMeaning()
  {
    return this.meaning;
  }
  
  public void setMeaning(String paramString)
  {
    this.meaning = paramString;
  }
  
  public String getBarcodeUrl()
  {
    return this.barcodeUrl;
  }
  
  public void setBarcodeUrl(String paramString)
  {
    this.barcodeUrl = paramString;
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
  
  public Date getStartDate()
  {
    return this.startDate;
  }
  
  public void setStartDate(Date paramDate)
  {
    this.startDate = paramDate;
  }
  
  public Date getEndDate()
  {
    return this.endDate;
  }
  
  public void setEndDate(Date paramDate)
  {
    this.endDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.FbpVoucherRelBorrowV
 * JD-Core Version:    0.7.0.1
 */