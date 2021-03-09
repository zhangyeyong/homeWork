package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsAttachment
  implements Serializable
{
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private Long attachmentId;
  private Long voucherId;
  private String attachmentUrl;
  private Date createDate;
  private String attachmentMemo;
  
  public EvsAttachment() {}
  
  public EvsAttachment(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, Long paramLong5, String paramString1, Date paramDate3, String paramString2)
  {
    this.creationDate = paramDate1;
    this.createdBy = paramLong1;
    this.lastUpdateDate = paramDate2;
    this.lastUpdateBy = paramLong2;
    this.lastUpdateLogin = paramLong3;
    this.attachmentId = paramLong4;
    this.voucherId = paramLong5;
    this.attachmentUrl = paramString1;
    this.createDate = paramDate3;
    this.attachmentMemo = paramString2;
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
  
  public Long getAttachmentId()
  {
    return this.attachmentId;
  }
  
  public void setAttachmentId(Long paramLong)
  {
    this.attachmentId = paramLong;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public String getAttachmentUrl()
  {
    return this.attachmentUrl;
  }
  
  public void setAttachmentUrl(String paramString)
  {
    this.attachmentUrl = paramString;
  }
  
  public Date getCreateDate()
  {
    return this.createDate;
  }
  
  public void setCreateDate(Date paramDate)
  {
    this.createDate = paramDate;
  }
  
  public String getAttachmentMemo()
  {
    return this.attachmentMemo;
  }
  
  public void setAttachmentMemo(String paramString)
  {
    this.attachmentMemo = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsAttachment
 * JD-Core Version:    0.7.0.1
 */