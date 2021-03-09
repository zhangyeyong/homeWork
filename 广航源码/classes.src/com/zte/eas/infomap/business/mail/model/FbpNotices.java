package com.zte.eas.infomap.business.mail.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpNotices
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger noticeId;
  protected String noticeMode;
  protected String noticeFrom;
  protected String noticeTo;
  protected String title;
  protected String content;
  protected BigInteger status;
  protected String attributeCategory;
  protected String attribute1;
  protected String attribute2;
  protected String attribute3;
  protected String attribute4;
  protected String attribute5;
  protected String attribute6;
  protected String attribute7;
  protected String attribute8;
  protected String attribute9;
  protected String attribute10;
  protected String description;
  protected BigInteger operationType;
  
  public FbpNotices() {}
  
  public FbpNotices(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, BigInteger paramBigInteger2, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, BigInteger paramBigInteger3)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setNoticeId(paramBigInteger1);
    setNoticeMode(paramString1);
    setNoticeFrom(paramString2);
    setNoticeTo(paramString3);
    setTitle(paramString4);
    setContent(paramString5);
    setStatus(paramBigInteger2);
    setAttributeCategory(paramString6);
    setAttribute1(paramString7);
    setAttribute2(paramString8);
    setAttribute3(paramString9);
    setAttribute4(paramString10);
    setAttribute5(paramString11);
    setAttribute6(paramString12);
    setAttribute7(paramString13);
    setAttribute8(paramString14);
    setAttribute9(paramString15);
    setAttribute10(paramString16);
    setDescription(paramString17);
    setOperationType(paramBigInteger3);
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
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
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public BigInteger getNoticeId()
  {
    return this.noticeId;
  }
  
  public void setNoticeId(BigInteger paramBigInteger)
  {
    this.noticeId = paramBigInteger;
  }
  
  public String getNoticeMode()
  {
    return this.noticeMode;
  }
  
  public void setNoticeMode(String paramString)
  {
    this.noticeMode = paramString;
  }
  
  public String getNoticeFrom()
  {
    return this.noticeFrom;
  }
  
  public void setNoticeFrom(String paramString)
  {
    this.noticeFrom = paramString;
  }
  
  public String getNoticeTo()
  {
    return this.noticeTo;
  }
  
  public void setNoticeTo(String paramString)
  {
    this.noticeTo = paramString;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public BigInteger getStatus()
  {
    return this.status;
  }
  
  public void setStatus(BigInteger paramBigInteger)
  {
    this.status = paramBigInteger;
  }
  
  public String getAttributeCategory()
  {
    return this.attributeCategory;
  }
  
  public void setAttributeCategory(String paramString)
  {
    this.attributeCategory = paramString;
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
  
  public String getAttribute6()
  {
    return this.attribute6;
  }
  
  public void setAttribute6(String paramString)
  {
    this.attribute6 = paramString;
  }
  
  public String getAttribute7()
  {
    return this.attribute7;
  }
  
  public void setAttribute7(String paramString)
  {
    this.attribute7 = paramString;
  }
  
  public String getAttribute8()
  {
    return this.attribute8;
  }
  
  public void setAttribute8(String paramString)
  {
    this.attribute8 = paramString;
  }
  
  public String getAttribute9()
  {
    return this.attribute9;
  }
  
  public void setAttribute9(String paramString)
  {
    this.attribute9 = paramString;
  }
  
  public String getAttribute10()
  {
    return this.attribute10;
  }
  
  public void setAttribute10(String paramString)
  {
    this.attribute10 = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public BigInteger getOperationType()
  {
    return this.operationType;
  }
  
  public void setOperationType(BigInteger paramBigInteger)
  {
    this.operationType = paramBigInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpNotices)) {
      return false;
    }
    FbpNotices localFbpNotices = (FbpNotices)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpNotices.lastUpdateDate).append(this.lastUpdatedBy, localFbpNotices.lastUpdatedBy).append(this.creationDate, localFbpNotices.creationDate).append(this.createdBy, localFbpNotices.createdBy).append(this.lastUpdateLogin, localFbpNotices.lastUpdateLogin).append(this.noticeId, localFbpNotices.noticeId).append(this.noticeMode, localFbpNotices.noticeMode).append(this.noticeFrom, localFbpNotices.noticeFrom).append(this.noticeTo, localFbpNotices.noticeTo).append(this.title, localFbpNotices.title).append(this.content, localFbpNotices.content).append(this.status, localFbpNotices.status).append(this.attributeCategory, localFbpNotices.attributeCategory).append(this.attribute1, localFbpNotices.attribute1).append(this.attribute2, localFbpNotices.attribute2).append(this.attribute3, localFbpNotices.attribute3).append(this.attribute4, localFbpNotices.attribute4).append(this.attribute5, localFbpNotices.attribute5).append(this.attribute6, localFbpNotices.attribute6).append(this.attribute7, localFbpNotices.attribute7).append(this.attribute8, localFbpNotices.attribute8).append(this.attribute9, localFbpNotices.attribute9).append(this.attribute10, localFbpNotices.attribute10).append(this.description, localFbpNotices.description).append(this.operationType, localFbpNotices.operationType).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.noticeId).append(this.noticeMode).append(this.noticeFrom).append(this.noticeTo).append(this.title).append(this.content).append(this.status).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.description).append(this.operationType).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("noticeId", this.noticeId).append("noticeMode", this.noticeMode).append("noticeFrom", this.noticeFrom).append("noticeTo", this.noticeTo).append("title", this.title).append("content", this.content).append("status", this.status).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("description", this.description).append("operationType", this.operationType).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "noticeId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.mail.model.FbpNotices
 * JD-Core Version:    0.7.0.1
 */