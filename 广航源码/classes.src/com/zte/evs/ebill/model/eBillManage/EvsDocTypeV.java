package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsDocTypeV
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private Long docId;
  private String docCode;
  private String docName;
  private String docDeadline;
  private String enabledFlag;
  private String enabledFlagMeaning;
  private String docMemo;
  private String tagType;
  
  public EvsDocTypeV() {}
  
  public EvsDocTypeV(String paramString)
  {
    this.docCode = paramString;
  }
  
  public EvsDocTypeV(Long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.docId = paramLong;
    this.docCode = paramString1;
    this.docName = paramString2;
    this.docDeadline = paramString3;
    this.enabledFlag = paramString4;
    this.docMemo = paramString5;
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
  
  public Long getDocId()
  {
    return this.docId;
  }
  
  public void setDocId(Long paramLong)
  {
    this.docId = paramLong;
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
    if ("Y".equals(this.enabledFlag)) {
      this.tagType = "启用";
    } else if ("N".equals(this.enabledFlag)) {
      this.tagType = "禁用";
    }
  }
  
  public String getDocMemo()
  {
    return this.docMemo;
  }
  
  public void setDocMemo(String paramString)
  {
    this.docMemo = paramString;
  }
  
  public String getTagType()
  {
    return this.tagType;
  }
  
  public void setTagType(String paramString)
  {
    this.tagType = paramString;
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
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsDocTypeV
 * JD-Core Version:    0.7.0.1
 */