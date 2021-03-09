package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpImages
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
  protected String employeeNumber;
  protected Date uploadDate;
  protected byte[] imgBinary;
  protected String imgExtension;
  
  public FbpImages() {}
  
  public FbpImages(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, Date paramDate3, byte[] paramArrayOfByte, String paramString3)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setImageId(paramLong4);
    setEmployeeNumber(paramString2);
    setUploadDate(paramDate3);
    setImgBinary(paramArrayOfByte);
    setImgExtension(paramString3);
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
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public Date getUploadDate()
  {
    return this.uploadDate;
  }
  
  public void setUploadDate(Date paramDate)
  {
    this.uploadDate = paramDate;
  }
  
  public byte[] getImgBinary()
  {
    return this.imgBinary;
  }
  
  public void setImgBinary(byte[] paramArrayOfByte)
  {
    this.imgBinary = paramArrayOfByte;
  }
  
  public String getImgExtension()
  {
    return this.imgExtension;
  }
  
  public void setImgExtension(String paramString)
  {
    this.imgExtension = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpImages)) {
      return false;
    }
    FbpImages localFbpImages = (FbpImages)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpImages.lastUpdateDate).append(this.lastUpdatedBy, localFbpImages.lastUpdatedBy).append(this.creationDate, localFbpImages.creationDate).append(this.createdBy, localFbpImages.createdBy).append(this.lastUpdateLogin, localFbpImages.lastUpdateLogin).append(this.enabledFlag, localFbpImages.enabledFlag).append(this.imageId, localFbpImages.imageId).append(this.employeeNumber, localFbpImages.employeeNumber).append(this.uploadDate, localFbpImages.uploadDate).append(this.imgBinary, localFbpImages.imgBinary).append(this.imgExtension, localFbpImages.imgExtension).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.imageId).append(this.employeeNumber).append(this.uploadDate).append(this.imgBinary).append(this.imgExtension).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("imageId", this.imageId).append("employeeNumber", this.employeeNumber).append("uploadDate", this.uploadDate).append("imgBinary", this.imgBinary).append("imgExtension", this.imgExtension).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "employeeNumber";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.FbpImages
 * JD-Core Version:    0.7.0.1
 */