package com.zte.evs.ebill.model.archives;

import com.zte.evs.ebill.common.EvsStatusUtil;
import java.io.Serializable;
import java.util.Date;

public class EvsVoucherCheckpersonV
  implements Serializable
{
  protected Long voucherId;
  protected String subDocName;
  protected String source;
  protected String ouName;
  protected String periodName;
  protected String invoiceType;
  protected String userName;
  protected Date createdDate;
  protected String voucherStatus;
  protected String statusName;
  protected String barcode;
  protected String barName;
  protected String setBookName;
  protected String approver;
  protected Date approverDate;
  protected String lastUpdateBy;
  protected Long ouId;
  protected Date lastUpdateDate;
  protected String journalNum;
  protected String invoiceNum;
  protected String journalSubName;
  protected String matchMode;
  protected String batchName;
  protected String checkStatus;
  protected String boeNum;
  protected String checkStatusName;
  protected Long voucherAmount;
  protected String abstracts;
  protected String apJournalNum;
  protected Long checkPersonId;
  
  public EvsVoucherCheckpersonV() {}
  
  public EvsVoucherCheckpersonV(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Date paramDate1, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, Date paramDate2, String paramString13, Long paramLong2, Date paramDate3, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, Long paramLong3, String paramString22, String paramString23, Long paramLong4)
  {
    setVoucherId(paramLong1);
    setSubDocName(paramString1);
    setSource(paramString2);
    setOuName(paramString3);
    setPeriodName(paramString4);
    setInvoiceType(paramString5);
    setUserName(paramString6);
    setCreatedDate(paramDate1);
    setVoucherStatus(paramString7);
    this.statusName = paramString8;
    setBarcode(paramString9);
    this.barName = paramString10;
    setSetBookName(paramString11);
    setApprover(paramString12);
    setApproverDate(paramDate2);
    setLastUpdateBy(paramString13);
    setOuId(paramLong2);
    setLastUpdateDate(paramDate3);
    setJournalNum(paramString14);
    setInvoiceNum(paramString15);
    setJournalSubName(paramString16);
    setMatchMode(paramString17);
    setBatchName(paramString18);
    setCheckStatus(paramString19);
    setBoeNum(paramString20);
    setCheckStatusName(paramString21);
    setVoucherAmount(paramLong3);
    setAbstracts(paramString22);
    setApJournalNum(paramString23);
    setCheckPersonId(paramLong4);
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public String getSubDocName()
  {
    return this.subDocName;
  }
  
  public void setSubDocName(String paramString)
  {
    this.subDocName = paramString;
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
  
  public String getVoucherStatus()
  {
    return this.voucherStatus;
  }
  
  public void setVoucherStatus(String paramString)
  {
    this.voucherStatus = paramString;
  }
  
  public String getBarcode()
  {
    return this.barcode;
  }
  
  public void setBarcode(String paramString)
  {
    this.barcode = paramString;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
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
  
  public String getLastUpdateBy()
  {
    return this.lastUpdateBy;
  }
  
  public void setLastUpdateBy(String paramString)
  {
    this.lastUpdateBy = paramString;
  }
  
  public Long getOuId()
  {
    return this.ouId;
  }
  
  public void setOuId(Long paramLong)
  {
    this.ouId = paramLong;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public String getInvoiceNum()
  {
    return this.invoiceNum;
  }
  
  public void setInvoiceNum(String paramString)
  {
    this.invoiceNum = paramString;
  }
  
  public String getJournalSubName()
  {
    return this.journalSubName;
  }
  
  public void setJournalSubName(String paramString)
  {
    this.journalSubName = paramString;
  }
  
  public String getMatchMode()
  {
    return this.matchMode;
  }
  
  public void setMatchMode(String paramString)
  {
    this.matchMode = paramString;
  }
  
  public String getBatchName()
  {
    return this.batchName;
  }
  
  public void setBatchName(String paramString)
  {
    this.batchName = paramString;
  }
  
  public String getCheckStatus()
  {
    return this.checkStatus;
  }
  
  public void setCheckStatus(String paramString)
  {
    this.checkStatus = paramString;
  }
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
  
  public String getCheckStatusName()
  {
    return this.checkStatusName;
  }
  
  public void setCheckStatusName(String paramString)
  {
    this.checkStatusName = paramString;
  }
  
  public Long getVoucherAmount()
  {
    return this.voucherAmount;
  }
  
  public void setVoucherAmount(Long paramLong)
  {
    this.voucherAmount = paramLong;
  }
  
  public String getAbstracts()
  {
    return this.abstracts;
  }
  
  public void setAbstracts(String paramString)
  {
    this.abstracts = paramString;
  }
  
  public String getApJournalNum()
  {
    return this.apJournalNum;
  }
  
  public void setApJournalNum(String paramString)
  {
    this.apJournalNum = paramString;
  }
  
  public Long getCheckPersonId()
  {
    return this.checkPersonId;
  }
  
  public void setCheckPersonId(Long paramLong)
  {
    this.checkPersonId = paramLong;
  }
  
  public String getStatusName()
  {
    return EvsStatusUtil.getVoucherStatusName(this.voucherStatus);
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public String getBarName()
  {
    return EvsStatusUtil.getBarcode(this.voucherStatus, this.barcode);
  }
  
  public void setBarName(String paramString)
  {
    this.barName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.archives.EvsVoucherCheckpersonV
 * JD-Core Version:    0.7.0.1
 */