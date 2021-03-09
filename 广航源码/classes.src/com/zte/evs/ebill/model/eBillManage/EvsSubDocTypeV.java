package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;

public class EvsSubDocTypeV
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long subDocId;
  private String subDocCode;
  private String subDocName;
  private String docName;
  private String voucherType;
  private String deadline;
  private String enabledFlag;
  private String enabledFlagMeaning;
  private String status;
  private Long sequenceNumber;
  
  public EvsSubDocTypeV() {}
  
  public EvsSubDocTypeV(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Long paramLong2)
  {
    this.subDocId = paramLong1;
    this.subDocCode = paramString1;
    this.subDocName = paramString2;
    this.docName = paramString3;
    this.voucherType = paramString4;
    this.deadline = paramString5;
    this.enabledFlag = paramString6;
    this.sequenceNumber = paramLong2;
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
  
  public String getDocName()
  {
    return this.docName;
  }
  
  public void setDocName(String paramString)
  {
    this.docName = paramString;
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
  
  public String getStatus()
  {
    if ("Y".equals(this.enabledFlag)) {
      this.status = "启用";
    } else if ("N".equals(this.enabledFlag)) {
      this.status = "禁用";
    }
    return this.status;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public Long getSequenceNumber()
  {
    return this.sequenceNumber;
  }
  
  public void setSequenceNumber(Long paramLong)
  {
    this.sequenceNumber = paramLong;
  }
  
  public String getEnabledFlagMeaning()
  {
    return this.enabledFlagMeaning;
  }
  
  public void setEnabledFlagMeaning(String paramString)
  {
    this.enabledFlagMeaning = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsSubDocTypeV
 * JD-Core Version:    0.7.0.1
 */