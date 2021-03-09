package com.zte.evs.ebill.model.eBillManage;

public class EvsDocTypeVo
{
  private String docId;
  private String docCode;
  private String docName;
  private String docDeadline;
  private String enabledFlag;
  private String docMemo;
  
  public EvsDocTypeVo() {}
  
  public EvsDocTypeVo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.docId = paramString1;
    this.docCode = paramString2;
    this.docName = paramString3;
    this.docDeadline = paramString4;
    this.enabledFlag = paramString5;
    this.docMemo = paramString6;
  }
  
  public String getDocId()
  {
    return this.docId;
  }
  
  public void setDocId(String paramString)
  {
    this.docId = paramString;
  }
  
  public String getDocCode()
  {
    return this.docCode;
  }
  
  public void setDocCode(String paramString)
  {
    this.docCode = paramString;
  }
  
  public String getDocName()
  {
    return this.docName;
  }
  
  public void setDocName(String paramString)
  {
    this.docName = paramString;
  }
  
  public String getDocDeadline()
  {
    return this.docDeadline;
  }
  
  public void setDocDeadline(String paramString)
  {
    this.docDeadline = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getDocMemo()
  {
    return this.docMemo;
  }
  
  public void setDocMemo(String paramString)
  {
    this.docMemo = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsDocTypeVo
 * JD-Core Version:    0.7.0.1
 */