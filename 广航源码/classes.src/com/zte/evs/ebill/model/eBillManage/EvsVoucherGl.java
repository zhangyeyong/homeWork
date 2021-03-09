package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsVoucherGl
  implements Serializable
{
  private Long voucherId;
  private Date lastUpdateDate;
  private String sourceCode;
  private String journalNum;
  private Long reversedHeaderId;
  private String reversedJournalNum;
  private String setBookName;
  private Long ouId;
  private String ouName;
  private String periodName;
  private Date creationDate;
  private Long createdBy;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  
  public EvsVoucherGl() {}
  
  public EvsVoucherGl(Long paramLong1, Date paramDate1, String paramString1, String paramString2, Long paramLong2, String paramString3, String paramString4, Long paramLong3, String paramString5, String paramString6, Date paramDate2, Long paramLong4, Long paramLong5, Long paramLong6)
  {
    this.voucherId = paramLong1;
    this.lastUpdateDate = paramDate1;
    this.sourceCode = paramString1;
    this.journalNum = paramString2;
    this.reversedHeaderId = paramLong2;
    this.reversedJournalNum = paramString3;
    this.setBookName = paramString4;
    this.ouId = paramLong3;
    this.ouName = paramString5;
    this.periodName = paramString6;
    this.creationDate = paramDate2;
    this.createdBy = paramLong4;
    this.lastUpdateBy = paramLong5;
    this.lastUpdateLogin = paramLong6;
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
  
  public String getSourceCode()
  {
    return this.sourceCode;
  }
  
  public void setSourceCode(String paramString)
  {
    this.sourceCode = paramString;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public Long getReversedHeaderId()
  {
    return this.reversedHeaderId;
  }
  
  public void setReversedHeaderId(Long paramLong)
  {
    this.reversedHeaderId = paramLong;
  }
  
  public String getReversedJournalNum()
  {
    return this.reversedJournalNum;
  }
  
  public void setReversedJournalNum(String paramString)
  {
    this.reversedJournalNum = paramString;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
  }
  
  public Long getOuId()
  {
    return this.ouId;
  }
  
  public void setOuId(Long paramLong)
  {
    this.ouId = paramLong;
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
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherGl
 * JD-Core Version:    0.7.0.1
 */