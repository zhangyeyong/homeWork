package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsImage
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long imageId;
  private Long voucherId;
  private String imageUrl;
  private String imageMemo;
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private String webhostUrl;
  private String localPath;
  private String barcode;
  private String companyName;
  private String companyCode;
  private String isShowImage;
  private Long originImageId;
  private String imageNum;
  private Long imageInfoId;
  
  public EvsImage() {}
  
  public EvsImage(Long paramLong1, String paramString1, String paramString2, Date paramDate1, Long paramLong2, Date paramDate2, Long paramLong3, Long paramLong4, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.voucherId = paramLong1;
    this.imageUrl = paramString1;
    this.imageMemo = paramString2;
    this.creationDate = paramDate1;
    this.createdBy = paramLong2;
    this.lastUpdateDate = paramDate2;
    this.lastUpdateBy = paramLong3;
    this.lastUpdateLogin = paramLong4;
    this.webhostUrl = paramString3;
    this.localPath = paramString4;
    this.barcode = paramString5;
    this.companyName = paramString6;
    this.companyCode = paramString7;
  }
  
  public Long getImageId()
  {
    return this.imageId;
  }
  
  public void setImageId(Long paramLong)
  {
    this.imageId = paramLong;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public void setImageUrl(String paramString)
  {
    this.imageUrl = paramString;
  }
  
  public String getImageMemo()
  {
    return this.imageMemo;
  }
  
  public void setImageMemo(String paramString)
  {
    this.imageMemo = paramString;
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
  
  public String getBarcode()
  {
    return this.barcode;
  }
  
  public void setBarcode(String paramString)
  {
    this.barcode = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getIsShowImage()
  {
    return this.isShowImage;
  }
  
  public void setIsShowImage(String paramString)
  {
    this.isShowImage = paramString;
  }
  
  public Long getOriginImageId()
  {
    return this.originImageId;
  }
  
  public void setOriginImageId(Long paramLong)
  {
    this.originImageId = paramLong;
  }
  
  public String getImageNum()
  {
    return this.imageNum;
  }
  
  public void setImageNum(String paramString)
  {
    this.imageNum = paramString;
  }
  
  public Long getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(Long paramLong)
  {
    this.imageInfoId = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsImage
 * JD-Core Version:    0.7.0.1
 */