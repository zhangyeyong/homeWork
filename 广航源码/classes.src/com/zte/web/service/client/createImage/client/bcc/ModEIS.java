package com.zte.web.service.client.createImage.client.bcc;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class ModEIS
  implements Serializable
{
  private String BILLCODE;
  private String imageSource;
  private String imageStatus;
  private String scanNum;
  private String scanUrl;
  private String updateBy;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(ModEIS.class, true);
  
  public ModEIS() {}
  
  public ModEIS(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.BILLCODE = paramString1;
    this.imageSource = paramString2;
    this.imageStatus = paramString3;
    this.scanNum = paramString4;
    this.scanUrl = paramString5;
    this.updateBy = paramString6;
  }
  
  public String getBILLCODE()
  {
    return this.BILLCODE;
  }
  
  public void setBILLCODE(String paramString)
  {
    this.BILLCODE = paramString;
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
    if (!(paramObject instanceof ModEIS)) {
      return false;
    }
    ModEIS localModEIS = (ModEIS)paramObject;
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
    boolean bool = ((this.BILLCODE == null) && (localModEIS.getBILLCODE() == null)) || ((this.BILLCODE != null) && (this.BILLCODE.equals(localModEIS.getBILLCODE())) && (((this.imageSource == null) && (localModEIS.getImageSource() == null)) || ((this.imageSource != null) && (this.imageSource.equals(localModEIS.getImageSource())) && (((this.imageStatus == null) && (localModEIS.getImageStatus() == null)) || ((this.imageStatus != null) && (this.imageStatus.equals(localModEIS.getImageStatus())) && (((this.scanNum == null) && (localModEIS.getScanNum() == null)) || ((this.scanNum != null) && (this.scanNum.equals(localModEIS.getScanNum())) && (((this.scanUrl == null) && (localModEIS.getScanUrl() == null)) || ((this.scanUrl != null) && (this.scanUrl.equals(localModEIS.getScanUrl())) && (((this.updateBy == null) && (localModEIS.getUpdateBy() == null)) || ((this.updateBy != null) && (this.updateBy.equals(localModEIS.getUpdateBy())))))))))))));
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
    if (getBILLCODE() != null) {
      i += getBILLCODE().hashCode();
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
    typeDesc.setXmlType(new QName("http://tempuri.org/", "modEIS"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("BILLCODE");
    localElementDesc.setXmlName(new QName("http://tempuri.org/", "BILLCODE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("imageSource");
    localElementDesc.setXmlName(new QName("http://tempuri.org/", "ImageSource"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("imageStatus");
    localElementDesc.setXmlName(new QName("http://tempuri.org/", "ImageStatus"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("scanNum");
    localElementDesc.setXmlName(new QName("http://tempuri.org/", "ScanNum"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("scanUrl");
    localElementDesc.setXmlName(new QName("http://tempuri.org/", "ScanUrl"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("updateBy");
    localElementDesc.setXmlName(new QName("http://tempuri.org/", "UpdateBy"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.createImage.client.bcc.ModEIS
 * JD-Core Version:    0.7.0.1
 */