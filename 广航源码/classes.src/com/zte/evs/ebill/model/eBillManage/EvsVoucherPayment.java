package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsVoucherPayment
  implements Serializable
{
  private Long voucherId;
  private Date lastUpdateDate;
  private Long checkId;
  private Long journalNum;
  private String sourceCode;
  private Long reversedJournalNum;
  private Long invoiceId;
  private String setBookName;
  private String ouName;
  private String periodName;
  private Date creationDate;
  private Long createdBy;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  
  public EvsVoucherPayment() {}
  
  public EvsVoucherPayment(Long paramLong1, Date paramDate1, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, Long paramLong5, String paramString2, String paramString3, String paramString4, Date paramDate2, Long paramLong6, Long paramLong7, Long paramLong8)
  {
    this.voucherId = paramLong1;
    this.lastUpdateDate = paramDate1;
    this.checkId = paramLong2;
    this.journalNum = paramLong3;
    this.sourceCode = paramString1;
    this.reversedJournalNum = paramLong4;
    this.invoiceId = paramLong5;
    this.setBookName = paramString2;
    this.ouName = paramString3;
    this.periodName = paramString4;
    this.creationDate = paramDate2;
    this.createdBy = paramLong6;
    this.lastUpdateBy = paramLong7;
    this.lastUpdateLogin = paramLong8;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getCheckId()
  {
    return this.checkId;
  }
  
  public void setCheckId(Long paramLong)
  {
    this.checkId = paramLong;
  }
  
  public Long getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(Long paramLong)
  {
    this.journalNum = paramLong;
  }
  
  public String getSourceCode()
  {
    return this.sourceCode;
  }
  
  public void setSourceCode(String paramString)
  {
    this.sourceCode = paramString;
  }
  
  public Long getReversedJournalNum()
  {
    return this.reversedJournalNum;
  }
  
  public void setReversedJournalNum(Long paramLong)
  {
    this.reversedJournalNum = paramLong;
  }
  
  public Long getInvoiceId()
  {
    return this.invoiceId;
  }
  
  public void setInvoiceId(Long paramLong)
  {
    this.invoiceId = paramLong;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
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
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherPayment
 * JD-Core Version:    0.7.0.1
 */