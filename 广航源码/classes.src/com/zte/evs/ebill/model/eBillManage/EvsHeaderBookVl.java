package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsHeaderBookVl
  implements Serializable
{
  private Long headerId;
  private String mainType;
  private String source;
  private String ouName;
  private String periodName;
  private String invoiceType;
  private String userName;
  private Date createdDate;
  private String status;
  private String entry;
  private String setBookName;
  private Long journalNum;
  private String approver;
  private Date approverDate;
  private Long lastUpdateBy;
  private Date lastUpdateByDate;
  
  public EvsHeaderBookVl() {}
  
  public EvsHeaderBookVl(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Date paramDate1, Date paramDate2, String paramString7, String paramString8, String paramString9, String paramString10, Long paramLong2, Long paramLong3, Date paramDate3)
  {
    this.headerId = paramLong1;
    this.mainType = paramString1;
    this.source = paramString2;
    this.ouName = paramString3;
    this.periodName = paramString4;
    this.invoiceType = paramString5;
    this.userName = paramString6;
    this.createdDate = paramDate1;
    this.approverDate = paramDate2;
    this.status = paramString7;
    this.entry = paramString8;
    this.setBookName = paramString10;
    this.journalNum = paramLong2;
    this.lastUpdateBy = paramLong3;
    this.lastUpdateByDate = paramDate3;
  }
  
  public Long getHeaderId()
  {
    return this.headerId;
  }
  
  public void setHeaderId(Long paramLong)
  {
    this.headerId = paramLong;
  }
  
  public String getMainType()
  {
    return this.mainType;
  }
  
  public void setMainType(String paramString)
  {
    this.mainType = paramString;
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
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public String getEntry()
  {
    return this.entry;
  }
  
  public void setEntry(String paramString)
  {
    this.entry = paramString;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
  }
  
  public Long getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(Long paramLong)
  {
    this.journalNum = paramLong;
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
  
  public Long getLastUpdateBy()
  {
    return this.lastUpdateBy;
  }
  
  public void setLastUpdateBy(Long paramLong)
  {
    this.lastUpdateBy = paramLong;
  }
  
  public Date getLastUpdateByDate()
  {
    return this.lastUpdateByDate;
  }
  
  public void setLastUpdateByDate(Date paramDate)
  {
    this.lastUpdateByDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsHeaderBookVl
 * JD-Core Version:    0.7.0.1
 */