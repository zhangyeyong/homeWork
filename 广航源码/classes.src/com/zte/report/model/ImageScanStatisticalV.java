package com.zte.report.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ImageScanStatisticalV
  extends BaseObject
  implements Serializable
{
  protected BigInteger rn;
  protected Long companyId;
  protected String companyCode;
  protected String companyName;
  protected Long operationTypeId;
  protected String operationTypeCode;
  protected String operationTypeName;
  protected BigInteger scanCount;
  protected BigInteger imageCount;
  protected Date beginUploadDate;
  protected Date endUploadDate;
  protected String uploadDate;
  
  public Date getBeginUploadDate()
  {
    return this.beginUploadDate;
  }
  
  public void setBeginUploadDate(Date paramDate)
  {
    this.beginUploadDate = paramDate;
  }
  
  public Date getEndUploadDate()
  {
    return this.endUploadDate;
  }
  
  public void setEndUploadDate(Date paramDate)
  {
    this.endUploadDate = paramDate;
  }
  
  public ImageScanStatisticalV() {}
  
  public ImageScanStatisticalV(BigInteger paramBigInteger1, Long paramLong1, String paramString1, String paramString2, Long paramLong2, String paramString3, String paramString4, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    setRn(paramBigInteger1);
    setCompanyId(paramLong1);
    setCompanyCode(paramString1);
    setCompanyName(paramString2);
    setOperationTypeId(paramLong2);
    setOperationTypeCode(paramString3);
    setOperationTypeName(paramString4);
    setScanCount(paramBigInteger2);
    setImageCount(paramBigInteger3);
  }
  
  public BigInteger getRn()
  {
    return this.rn;
  }
  
  public void setRn(BigInteger paramBigInteger)
  {
    this.rn = paramBigInteger;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public Long getOperationTypeId()
  {
    return this.operationTypeId;
  }
  
  public void setOperationTypeId(Long paramLong)
  {
    this.operationTypeId = paramLong;
  }
  
  public String getOperationTypeCode()
  {
    return this.operationTypeCode;
  }
  
  public void setOperationTypeCode(String paramString)
  {
    this.operationTypeCode = paramString;
  }
  
  public String getOperationTypeName()
  {
    return this.operationTypeName;
  }
  
  public void setOperationTypeName(String paramString)
  {
    this.operationTypeName = paramString;
  }
  
  public BigInteger getScanCount()
  {
    return this.scanCount;
  }
  
  public void setScanCount(BigInteger paramBigInteger)
  {
    this.scanCount = paramBigInteger;
  }
  
  public BigInteger getImageCount()
  {
    return this.imageCount;
  }
  
  public void setImageCount(BigInteger paramBigInteger)
  {
    this.imageCount = paramBigInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImageScanStatisticalV)) {
      return false;
    }
    ImageScanStatisticalV localImageScanStatisticalV = (ImageScanStatisticalV)paramObject;
    return new EqualsBuilder().append(this.rn, localImageScanStatisticalV.rn).append(this.companyId, localImageScanStatisticalV.companyId).append(this.companyCode, localImageScanStatisticalV.companyCode).append(this.companyName, localImageScanStatisticalV.companyName).append(this.operationTypeId, localImageScanStatisticalV.operationTypeId).append(this.operationTypeCode, localImageScanStatisticalV.operationTypeCode).append(this.operationTypeName, localImageScanStatisticalV.operationTypeName).append(this.scanCount, localImageScanStatisticalV.scanCount).append(this.imageCount, localImageScanStatisticalV.imageCount).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.rn).append(this.companyId).append(this.companyCode).append(this.companyName).append(this.operationTypeId).append(this.operationTypeCode).append(this.operationTypeName).append(this.scanCount).append(this.imageCount).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("rn", this.rn).append("companyId", this.companyId).append("companyCode", this.companyCode).append("companyName", this.companyName).append("operationTypeId", this.operationTypeId).append("operationTypeCode", this.operationTypeCode).append("operationTypeName", this.operationTypeName).append("scanCount", this.scanCount).append("imageCount", this.imageCount).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getUploadDate()
  {
    return this.uploadDate;
  }
  
  public void setUploadDate(String paramString)
  {
    this.uploadDate = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.model.ImageScanStatisticalV
 * JD-Core Version:    0.7.0.1
 */