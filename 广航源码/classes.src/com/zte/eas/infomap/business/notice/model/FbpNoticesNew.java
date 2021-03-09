package com.zte.eas.infomap.business.notice.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpNoticesNew
  extends BaseObject
  implements Serializable
{
  protected Long id;
  protected Long fromUserId;
  protected Long submitUserId;
  protected Long boeHeaderId;
  protected String workflowTag;
  protected String toUserId;
  protected String templateId;
  protected String content;
  protected Integer status;
  protected Integer operationType;
  protected String attribute1;
  protected String attribute2;
  protected String attribute3;
  protected String attribute4;
  protected String attribute5;
  protected String isRuning;
  protected String noticeType;
  protected String memo;
  protected Date creationDate = new Date();
  
  public FbpNoticesNew() {}
  
  public FbpNoticesNew(Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4, String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger1, Integer paramInteger2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Date paramDate)
  {
    setId(paramLong1);
    setFromUserId(paramLong2);
    setSubmitUserId(paramLong3);
    setBoeHeaderId(paramLong4);
    setWorkflowTag(paramString1);
    setToUserId(paramString2);
    setTemplateId(paramString3);
    setContent(paramString4);
    setStatus(paramInteger1);
    setOperationType(paramInteger2);
    setAttribute1(paramString5);
    setAttribute2(paramString6);
    setAttribute3(paramString7);
    setAttribute4(paramString8);
    setAttribute5(paramString9);
    setIsRuning(paramString10);
    setmemo(paramString11);
    setCreationDate(paramDate);
  }
  
  public String getmemo()
  {
    return this.memo;
  }
  
  public void setmemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public Long getFromUserId()
  {
    return this.fromUserId;
  }
  
  public void setFromUserId(Long paramLong)
  {
    this.fromUserId = paramLong;
  }
  
  public Long getSubmitUserId()
  {
    return this.submitUserId;
  }
  
  public void setSubmitUserId(Long paramLong)
  {
    this.submitUserId = paramLong;
  }
  
  public Long getBoeHeaderId()
  {
    return this.boeHeaderId;
  }
  
  public void setBoeHeaderId(Long paramLong)
  {
    this.boeHeaderId = paramLong;
  }
  
  public String getWorkflowTag()
  {
    return this.workflowTag;
  }
  
  public void setWorkflowTag(String paramString)
  {
    this.workflowTag = paramString;
  }
  
  public String getToUserId()
  {
    return this.toUserId;
  }
  
  public void setToUserId(String paramString)
  {
    this.toUserId = paramString;
  }
  
  public String getTemplateId()
  {
    return this.templateId;
  }
  
  public void setTemplateId(String paramString)
  {
    this.templateId = paramString;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public Integer getStatus()
  {
    return this.status;
  }
  
  public void setStatus(Integer paramInteger)
  {
    this.status = paramInteger;
  }
  
  public Integer getOperationType()
  {
    return this.operationType;
  }
  
  public void setOperationType(Integer paramInteger)
  {
    this.operationType = paramInteger;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
  }
  
  public String getAttribute2()
  {
    return this.attribute2;
  }
  
  public void setAttribute2(String paramString)
  {
    this.attribute2 = paramString;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public void setAttribute3(String paramString)
  {
    this.attribute3 = paramString;
  }
  
  public String getAttribute4()
  {
    return this.attribute4;
  }
  
  public void setAttribute4(String paramString)
  {
    this.attribute4 = paramString;
  }
  
  public String getAttribute5()
  {
    return this.attribute5;
  }
  
  public void setAttribute5(String paramString)
  {
    this.attribute5 = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpNoticesNew)) {
      return false;
    }
    FbpNoticesNew localFbpNoticesNew = (FbpNoticesNew)paramObject;
    return new EqualsBuilder().append(this.id, localFbpNoticesNew.id).append(this.fromUserId, localFbpNoticesNew.fromUserId).append(this.submitUserId, localFbpNoticesNew.submitUserId).append(this.boeHeaderId, localFbpNoticesNew.boeHeaderId).append(this.workflowTag, localFbpNoticesNew.workflowTag).append(this.toUserId, localFbpNoticesNew.toUserId).append(this.templateId, localFbpNoticesNew.templateId).append(this.content, localFbpNoticesNew.content).append(this.status, localFbpNoticesNew.status).append(this.operationType, localFbpNoticesNew.operationType).append(this.attribute1, localFbpNoticesNew.attribute1).append(this.attribute2, localFbpNoticesNew.attribute2).append(this.attribute3, localFbpNoticesNew.attribute3).append(this.attribute4, localFbpNoticesNew.attribute4).append(this.attribute5, localFbpNoticesNew.attribute5).append(this.memo, localFbpNoticesNew.memo).append(this.creationDate, localFbpNoticesNew.creationDate).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.id).append(this.fromUserId).append(this.submitUserId).append(this.boeHeaderId).append(this.workflowTag).append(this.toUserId).append(this.templateId).append(this.content).append(this.status).append(this.operationType).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.memo).append(this.creationDate).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("id", this.id).append("fromUserId", this.fromUserId).append("submitUserId", this.submitUserId).append("boeHeaderId", this.boeHeaderId).append("workflowTag", this.workflowTag).append("toUserId", this.toUserId).append("templateId", this.templateId).append("content", this.content).append("status", this.status).append("operationType", this.operationType).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("memo", this.memo).append("creationDate", this.creationDate).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "id";
  }
  
  public String getIsRuning()
  {
    return this.isRuning;
  }
  
  public void setIsRuning(String paramString)
  {
    this.isRuning = paramString;
  }
  
  public String getNoticeType()
  {
    return this.noticeType;
  }
  
  public void setNoticeType(String paramString)
  {
    this.noticeType = paramString;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.model.FbpNoticesNew
 * JD-Core Version:    0.7.0.1
 */