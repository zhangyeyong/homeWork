package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsVoucherAp
  implements Serializable
{
  private String invoiceNum;
  private Long invoiceId;
  private Date lastUpdateDate;
  private Long voucherId;
  private Long journalNum;
  private String eventTypeName;
  private Date creationDate;
  private Long createdBy;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  
  public EvsVoucherAp() {}
  
  public EvsVoucherAp(String paramString1, Long paramLong1, Date paramDate1, Long paramLong2, Long paramLong3, String paramString2, Date paramDate2, Long paramLong4, Long paramLong5, Long paramLong6)
  {
    this.invoiceNum = paramString1;
    this.invoiceId = paramLong1;
    this.lastUpdateDate = paramDate1;
    this.voucherId = paramLong2;
    this.journalNum = paramLong3;
    this.eventTypeName = paramString2;
    this.creationDate = paramDate2;
    this.createdBy = paramLong4;
    this.lastUpdateBy = paramLong5;
    this.lastUpdateLogin = paramLong6;
  }
  
  public String getInvoiceNum()
  {
    return this.invoiceNum;
  }
  
  public void setInvoiceNum(String paramString)
  {
    this.invoiceNum = paramString;
  }
  
  public Long getInvoiceId()
  {
    return this.invoiceId;
  }
  
  public void setInvoiceId(Long paramLong)
  {
    this.invoiceId = paramLong;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public Long getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(Long paramLong)
  {
    this.journalNum = paramLong;
  }
  
  public String getEventTypeName()
  {
    return this.eventTypeName;
  }
  
  public void setEventTypeName(String paramString)
  {
    this.eventTypeName = paramString;
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
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherAp
 * JD-Core Version:    0.7.0.1
 */