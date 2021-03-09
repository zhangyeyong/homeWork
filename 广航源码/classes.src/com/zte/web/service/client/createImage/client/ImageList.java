package com.zte.web.service.client.createImage.client;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class ImageList
  implements Serializable
{
  private String boeNum;
  private String imageSource;
  private String imageStatus;
  private String scanNum;
  private String scanUrl;
  private String updateBy;
  private Long imageCount;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(ImageList.class, true);
  
  public Long getImageCount()
  {
    return this.imageCount;
  }
  
  public void setImageCount(Long paramLong)
  {
    this.imageCount = paramLong;
  }
  
  public ImageList() {}
  
  public ImageList(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.boeNum = paramString1;
    this.imageSource = paramString2;
    this.imageStatus = paramString3;
    this.scanNum = paramString4;
    this.scanUrl = paramString5;
    this.updateBy = paramString6;
  }
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
  
  public String getImageSource()
  {
    return this.imageSource;
  }
  
  public void setImageSource(String paramString)
  {
    this.imageSource = paramString;
  }
  
  public String getImageStatus()
  {
    return this.imageStatus;
  }
  
  public void setImageStatus(String paramString)
  {
    this.imageStatus = paramString;
  }
  
  public String getScanNum()
  {
    return this.scanNum;
  }
  
  public void setScanNum(String paramString)
  {
    this.scanNum = paramString;
  }
  
  public String getScanUrl()
  {
    return this.scanUrl;
  }
  
  public void setScanUrl(String paramString)
  {
    this.scanUrl = paramString;
  }
  
  public String getUpdateBy()
  {
    return this.updateBy;
  }
  
  public void setUpdateBy(String paramString)
  {
    this.updateBy = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImageList)) {
      return false;
    }
    ImageList localImageList = (ImageList)paramObject;
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if (this.__equalsCalc != null) {
      return this.__equalsCalc == paramObject;
    }
    this.__equalsCalc = paramObject;
    boolean bool = ((this.boeNum == null) && (localImageList.getBoeNum() == null)) || ((this.boeNum != null) && (this.boeNum.equals(localImageList.getBoeNum())) && (((this.imageSource == null) && (localImageList.getImageSource() == null)) || ((this.imageSource != null) && (this.imageSource.equals(localImageList.getImageSource())) && (((this.imageStatus == null) && (localImageList.getImageStatus() == null)) || ((this.imageStatus != null) && (this.imageStatus.equals(localImageList.getImageStatus())) && (((this.scanNum == null) && (localImageList.getScanNum() == null)) || ((this.scanNum != null) && (this.scanNum.equals(localImageList.getScanNum())) && (((this.scanUrl == null) && (localImageList.getScanUrl() == null)) || ((this.scanUrl != null) && (this.scanUrl.equals(localImageList.getScanUrl())) && (((this.updateBy == null) && (localImageList.getUpdateBy() == null)) || ((this.updateBy != null) && (this.updateBy.equals(localImageList.getUpdateBy())))))))))))));
    this.__equalsCalc = null;
    return bool;
  }
  
  public synchronized int hashCode()
  {
    if (this.__hashCodeCalc) {
      return 0;
    }
    this.__hashCodeCalc = true;
    int i = 1;
    if (getBoeNum() != null) {
      i += getBoeNum().hashCode();
    }
    if (getImageSource() != null) {
      i += getImageSource().hashCode();
    }
    if (getImageStatus() != null) {
      i += getImageStatus().hashCode();
    }
    if (getScanNum() != null) {
      i += getScanNum().hashCode();
    }
    if (getScanUrl() != null) {
      i += getScanUrl().hashCode();
    }
    if (getUpdateBy() != null) {
      i += getUpdateBy().hashCode();
    }
    this.__hashCodeCalc = false;
    return i;
  }
  
  public static TypeDesc getTypeDesc()
  {
    return typeDesc;
  }
  
  public static Serializer getSerializer(String paramString, Class paramClass, QName paramQName)
  {
    return new BeanSerializer(paramClass, paramQName, typeDesc);
  }
  
  public static Deserializer getDeserializer(String paramString, Class paramClass, QName paramQName)
  {
    return new BeanDeserializer(paramClass, paramQName, typeDesc);
  }
  
  static
  {
    typeDesc.setXmlType(new QName("http://127.0.0.1/evs_haier", "ImageList"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("boeNum");
    localElementDesc.setXmlName(new QName("http://127.0.0.1/evs_haier", "boeNum"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("imageSource");
    localElementDesc.setXmlName(new QName("http://127.0.0.1/evs_haier", "imageSource"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("imageStatus");
    localElementDesc.setXmlName(new QName("http://127.0.0.1/evs_haier", "imageStatus"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("scanNum");
    localElementDesc.setXmlName(new QName("http://127.0.0.1/evs_haier", "scanNum"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("scanUrl");
    localElementDesc.setXmlName(new QName("http://127.0.0.1/evs_haier", "scanUrl"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("updateBy");
    localElementDesc.setXmlName(new QName("http://127.0.0.1/evs_haier", "updateBy"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.createImage.client.ImageList
 * JD-Core Version:    0.7.0.1
 */