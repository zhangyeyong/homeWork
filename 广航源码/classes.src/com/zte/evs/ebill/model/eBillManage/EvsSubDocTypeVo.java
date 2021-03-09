package com.zte.evs.ebill.model.eBillManage;

public class EvsSubDocTypeVo
{
  private String subDocId;
  private String subDocCode;
  private String subDocName;
  private String docId;
  private String voucherType;
  private String voucherTypeCode;
  private String deadline;
  private String enabledFlag;
  private String subDocMemo;
  private String sequenceNumber;
  
  public EvsSubDocTypeVo() {}
  
  public EvsSubDocTypeVo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    this.subDocId = paramString1;
    this.subDocCode = paramString2;
    this.subDocName = paramString3;
    this.docId = paramString4;
    this.voucherType = paramString5;
    this.voucherTypeCode = paramString6;
    this.deadline = paramString7;
    this.enabledFlag = paramString8;
    this.subDocMemo = paramString9;
    this.sequenceNumber = paramString10;
  }
  
  public String getSubDocId()
  {
    return this.subDocId;
  }
  
  public void setSubDocId(String paramString)
  {
    this.subDocId = paramString;
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
  
  public String getDocId()
  {
    return this.docId;
  }
  
  public void setDocId(String paramString)
  {
    this.docId = paramString;
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
  
  public String getVoucherTypeCode()
  {
    return this.voucherTypeCode;
  }
  
  public void setVoucherTypeCode(String paramString)
  {
    this.voucherTypeCode = paramString;
  }
  
  public String getSequenceNumber()
  {
    return this.sequenceNumber;
  }
  
  public void setSequenceNumber(String paramString)
  {
    this.sequenceNumber = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsSubDocTypeVo
 * JD-Core Version:    0.7.0.1
 */