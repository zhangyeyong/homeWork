package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EidImages
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long imageId;
  protected Long imageInfoId;
  protected String imagePath;
  protected String imageMemo;
  protected String webhostUrl;
  protected String localPath;
  protected Long originImageId;
  protected String isShowImage;
  
  public String getIsShowImage()
  {
    return this.isShowImage;
  }
  
  public void setIsShowImage(String paramString)
  {
    this.isShowImage = paramString;
  }
  
  public EidImages() {}
  
  public EidImages(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, Long paramLong5, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong6)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setImageId(paramLong4);
    setImageInfoId(paramLong5);
    setImagePath(paramString2);
    setImageMemo(paramString3);
    setWebhostUrl(paramString4);
    setLocalPath(paramString5);
    setOriginImageId(paramLong6);
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
  
  public Long getImageId()
  {
    return this.imageId;
  }
  
  public void setImageId(Long paramLong)
  {
    this.imageId = paramLong;
  }
  
  public Long getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(Long paramLong)
  {
    this.imageInfoId = paramLong;
  }
  
  public String getImagePath()
  {
    return this.imagePath;
  }
  
  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public String getImageMemo()
  {
    return this.imageMemo;
  }
  
  public void setImageMemo(String paramString)
  {
    this.imageMemo = paramString;
  }
  
  public String getWebhostUrl()
  {
    return this.webhostUrl;
  }
  
  public void setWebhostUrl(String paramString)
  {
    this.webhostUrl = paramString;
  }
  
  public String getLocalPath()
  {
    return this.localPath;
  }
  
  public void setLocalPath(String paramString)
  {
    this.localPath = paramString;
  }
  
  public Long getOriginImageId()
  {
    return this.originImageId;
  }
  
  public void setOriginImageId(Long paramLong)
  {
    this.originImageId = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EidImages)) {
      return false;
    }
    EidImages localEidImages = (EidImages)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localEidImages.lastUpdateDate).append(this.lastUpdatedBy, localEidImages.lastUpdatedBy).append(this.creationDate, localEidImages.creationDate).append(this.createdBy, localEidImages.createdBy).append(this.lastUpdateLogin, localEidImages.lastUpdateLogin).append(this.enabledFlag, localEidImages.enabledFlag).append(this.imageId, localEidImages.imageId).append(this.imageInfoId, localEidImages.imageInfoId).append(this.imagePath, localEidImages.imagePath).append(this.imageMemo, localEidImages.imageMemo).append(this.webhostUrl, localEidImages.webhostUrl).append(this.localPath, localEidImages.localPath).append(this.originImageId, localEidImages.originImageId).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.imageId).append(this.imageInfoId).append(this.imagePath).append(this.imageMemo).append(this.webhostUrl).append(this.localPath).append(this.originImageId).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("imageId", this.imageId).append("imageInfoId", this.imageInfoId).append("imagePath", this.imagePath).append("imageMemo", this.imageMemo).append("webhostUrl", this.webhostUrl).append("localPath", this.localPath).append("originImageId", this.originImageId).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "imageId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidImages
 * JD-Core Version:    0.7.0.1
 */