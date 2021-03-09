package com.zte.evs.ebill.model.eBillManage;

import com.zte.evs.ebill.common.EvsStatusUtil;
import java.io.Serializable;
import java.util.Date;

public class EvsHeaderBookV
  implements Serializable
{
  private Long voucherId;
  private String mainType;
  private String source;
  private String ouName;
  private String periodName;
  private String invoiceType;
  private String userName;
  private Date createdDate;
  private String voucherStatus;
  private String barcode;
  private String setBookName;
  private String journalNum;
  private String approver;
  private Date approverDate;
  private String lastUpdateBy;
  private Date lastUpdateDate;
  private String statusName;
  
  public EvsHeaderBookV() {}
  
  public EvsHeaderBookV(Long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Date paramDate1, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Date paramDate2, String paramString12, Date paramDate3)
  {
    this.voucherId = paramLong;
    this.mainType = paramString1;
    this.source = paramString2;
    this.ouName = paramString3;
    this.periodName = paramString4;
    this.invoiceType = paramString5;
    this.userName = paramString6;
    this.createdDate = paramDate1;
    this.voucherStatus = paramString7;
    this.barcode = paramString8;
    this.setBookName = paramString9;
    this.journalNum = paramString10;
    this.approver = paramString11;
    this.approverDate = paramDate2;
    this.lastUpdateBy = paramString12;
    this.lastUpdateDate = paramDate3;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
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
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
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
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public String getStatusName()
  {
    if (this.voucherStatus != null) {
      return EvsStatusUtil.getVoucherStatusName(this.voucherStatus);
    }
    return this.voucherStatus;
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsHeaderBookV
 * JD-Core Version:    0.7.0.1
 */