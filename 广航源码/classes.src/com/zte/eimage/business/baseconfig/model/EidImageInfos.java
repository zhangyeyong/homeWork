package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EidImageInfos
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long imageInfoId;
  protected String imageNumber;
  protected Long uploadEmployeeId;
  protected Date uploadDate;
  protected String checkUnit;
  protected String imageStatus;
  protected String appraiseNode;
  protected String memo;
  protected Long imageCount;
  protected String easImageFlag;
  protected String taskNum;
  protected String syncSaFlag;
  protected Long operationTypeId;
  protected Long companyId;
  protected Date signDate;
  protected String isBoe;
  protected EidImages[] eidImages;
  protected String sourceCode;
  protected String deleteImageFlag;
  protected String synchFlag;
  
  public String getSourceCode()
  {
    return this.sourceCode;
  }
  
  public void setSourceCode(String paramString)
  {
    this.sourceCode = paramString;
  }
  
  public EidImageInfos() {}
  
  public EidImageInfos(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, Long paramLong5, Date paramDate3, String paramString3, String paramString4, String paramString5, String paramString6, Long paramLong6)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setImageInfoId(paramLong4);
    setImageNumber(paramString2);
    setUploadEmployeeId(paramLong5);
    setUploadDate(paramDate3);
    setCheckUnit(paramString3);
    setImageStatus(paramString4);
    setAppraiseNode(paramString5);
    setMemo(paramString6);
    setImageCount(paramLong6);
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
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Long getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(Long paramLong)
  {
    this.imageInfoId = paramLong;
  }
  
  public String getImageNumber()
  {
    return this.imageNumber;
  }
  
  public void setImageNumber(String paramString)
  {
    this.imageNumber = paramString;
  }
  
  public Long getUploadEmployeeId()
  {
    return this.uploadEmployeeId;
  }
  
  public void setUploadEmployeeId(Long paramLong)
  {
    this.uploadEmployeeId = paramLong;
  }
  
  public Date getUploadDate()
  {
    return this.uploadDate;
  }
  
  public void setUploadDate(Date paramDate)
  {
    this.uploadDate = paramDate;
  }
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
  
  public String getImageStatus()
  {
    return this.imageStatus;
  }
  
  public void setImageStatus(String paramString)
  {
    this.imageStatus = paramString;
  }
  
  public String getAppraiseNode()
  {
    return this.appraiseNode;
  }
  
  public void setAppraiseNode(String paramString)
  {
    this.appraiseNode = paramString;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public Long getImageCount()
  {
    return this.imageCount;
  }
  
  public void setImageCount(Long paramLong)
  {
    this.imageCount = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EidImageInfos)) {
      return false;
    }
    EidImageInfos localEidImageInfos = (EidImageInfos)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localEidImageInfos.lastUpdateDate).append(this.lastUpdatedBy, localEidImageInfos.lastUpdatedBy).append(this.creationDate, localEidImageInfos.creationDate).append(this.createdBy, localEidImageInfos.createdBy).append(this.lastUpdateLogin, localEidImageInfos.lastUpdateLogin).append(this.enabledFlag, localEidImageInfos.enabledFlag).append(this.imageInfoId, localEidImageInfos.imageInfoId).append(this.imageNumber, localEidImageInfos.imageNumber).append(this.uploadEmployeeId, localEidImageInfos.uploadEmployeeId).append(this.uploadDate, localEidImageInfos.uploadDate).append(this.checkUnit, localEidImageInfos.checkUnit).append(this.imageStatus, localEidImageInfos.imageStatus).append(this.appraiseNode, localEidImageInfos.appraiseNode).append(this.memo, localEidImageInfos.memo).append(this.imageCount, localEidImageInfos.imageCount).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.imageInfoId).append(this.imageNumber).append(this.uploadEmployeeId).append(this.uploadDate).append(this.checkUnit).append(this.imageStatus).append(this.appraiseNode).append(this.memo).append(this.imageCount).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("imageInfoId", this.imageInfoId).append("imageNumber", this.imageNumber).append("uploadEmployeeId", this.uploadEmployeeId).append("uploadDate", this.uploadDate).append("checkUnit", this.checkUnit).append("imageStatus", this.imageStatus).append("appraiseNode", this.appraiseNode).append("memo", this.memo).append("imageCount", this.imageCount).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "imageInfoId";
  }
  
  public EidImages[] getEidImages()
  {
    return this.eidImages;
  }
  
  public void setEidImages(EidImages[] paramArrayOfEidImages)
  {
    this.eidImages = paramArrayOfEidImages;
  }
  
  public String getEasImageFlag()
  {
    return this.easImageFlag;
  }
  
  public void setEasImageFlag(String paramString)
  {
    this.easImageFlag = paramString;
  }
  
  public Long getOperationTypeId()
  {
    return this.operationTypeId;
  }
  
  public void setOperationTypeId(Long paramLong)
  {
    this.operationTypeId = paramLong;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public Date getSignDate()
  {
    return this.signDate;
  }
  
  public void setSignDate(Date paramDate)
  {
    this.signDate = paramDate;
  }
  
  public String getTaskNum()
  {
    return this.taskNum;
  }
  
  public void setTaskNum(String paramString)
  {
    this.taskNum = paramString;
  }
  
  public String getIsBoe()
  {
    return this.isBoe;
  }
  
  public void setIsBoe(String paramString)
  {
    this.isBoe = paramString;
  }
  
  public String getDeleteImageFlag()
  {
    return this.deleteImageFlag;
  }
  
  public void setDeleteImageFlag(String paramString)
  {
    this.deleteImageFlag = paramString;
  }
  
  public String getSynchFlag()
  {
    return this.synchFlag;
  }
  
  public void setSynchFlag(String paramString)
  {
    this.synchFlag = paramString;
  }
  
  public String getSyncSaFlag()
  {
    return this.syncSaFlag;
  }
  
  public void setSyncSaFlag(String paramString)
  {
    this.syncSaFlag = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidImageInfos
 * JD-Core Version:    0.7.0.1
 */