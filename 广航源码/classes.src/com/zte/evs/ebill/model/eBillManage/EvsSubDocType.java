package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsSubDocType
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private Long subDocId;
  private String subDocCode;
  private String subDocName;
  private Long docId;
  private String docName;
  private String voucherType;
  private String deadline;
  private String enabledFlag;
  private String subDocMemo;
  private String voucherTypeCode;
  private Long sequenceNumber;
  
  public EvsSubDocType() {}
  
  public EvsSubDocType(Long paramLong1, String paramString1, String paramString2, Long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, Long paramLong3)
  {
    this.subDocId = paramLong1;
    this.subDocCode = paramString1;
    this.subDocName = paramString2;
    this.docId = paramLong2;
    this.docName = paramString3;
    this.voucherType = paramString4;
    this.deadline = paramString5;
    this.enabledFlag = paramString6;
    this.subDocMemo = paramString7;
    this.voucherTypeCode = paramString8;
    this.sequenceNumber = paramLong3;
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
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
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
  
  public Long getSubDocId()
  {
    return this.subDocId;
  }
  
  public void setSubDocId(Long paramLong)
  {
    this.subDocId = paramLong;
  }
  
  public String getSubDocCode()
  {
    return this.subDocCode;
  }
  
  public void setSubDocCode(String paramString)
  {
    this.subDocCode = paramString;
  }
  
  public String getSubDocName()
  {
    return this.subDocName;
  }
  
  public void setSubDocName(String paramString)
  {
    this.subDocName = paramString;
  }
  
  public Long getDocId()
  {
    return this.docId;
  }
  
  public void setDocId(Long paramLong)
  {
    this.docId = paramLong;
  }
  
  public String getVoucherType()
  {
    return this.voucherType;
  }
  
  public void setVoucherType(String paramString)
  {
    this.voucherType = paramString;
  }
  
  public String getDeadline()
  {
    return this.deadline;
  }
  
  public void setDeadline(String paramString)
  {
    this.deadline = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getSubDocMemo()
  {
    return this.subDocMemo;
  }
  
  public void setSubDocMemo(String paramString)
  {
    this.subDocMemo = paramString;
  }
  
  public String getDocName()
  {
    return this.docName;
  }
  
  public void setDocName(String paramString)
  {
    this.docName = paramString;
  }
  
  public String getVoucherTypeCode()
  {
    return this.voucherTypeCode;
  }
  
  public void setVoucherTypeCode(String paramString)
  {
    this.voucherTypeCode = paramString;
  }
  
  public Long getSequenceNumber()
  {
    return this.sequenceNumber;
  }
  
  public void setSequenceNumber(Long paramLong)
  {
    this.sequenceNumber = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsSubDocType
 * JD-Core Version:    0.7.0.1
 */