package com.zte.web.service.client.getUrlServiceSrv;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class FileModel
  implements Serializable
{
  private String ACCESSORY_NAME;
  private Double ACCESSORY_SIZE;
  private String ACCESSORY_TITLE;
  private String ACCESSORY_URL;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(FileModel.class, true);
  
  public FileModel() {}
  
  public FileModel(String paramString1, Double paramDouble, String paramString2, String paramString3)
  {
    this.ACCESSORY_NAME = paramString1;
    this.ACCESSORY_SIZE = paramDouble;
    this.ACCESSORY_TITLE = paramString2;
    this.ACCESSORY_URL = paramString3;
  }
  
  public String getACCESSORY_NAME()
  {
    return this.ACCESSORY_NAME;
  }
  
  public void setACCESSORY_NAME(String paramString)
  {
    this.ACCESSORY_NAME = paramString;
  }
  
  public Double getACCESSORY_SIZE()
  {
    return this.ACCESSORY_SIZE;
  }
  
  public void setACCESSORY_SIZE(Double paramDouble)
  {
    this.ACCESSORY_SIZE = paramDouble;
  }
  
  public String getACCESSORY_TITLE()
  {
    return this.ACCESSORY_TITLE;
  }
  
  public void setACCESSORY_TITLE(String paramString)
  {
    this.ACCESSORY_TITLE = paramString;
  }
  
  public String getACCESSORY_URL()
  {
    return this.ACCESSORY_URL;
  }
  
  public void setACCESSORY_URL(String paramString)
  {
    this.ACCESSORY_URL = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FileModel)) {
      return false;
    }
    FileModel localFileModel = (FileModel)paramObject;
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
    boolean bool = ((this.ACCESSORY_NAME == null) && (localFileModel.getACCESSORY_NAME() == null)) || ((this.ACCESSORY_NAME != null) && (this.ACCESSORY_NAME.equals(localFileModel.getACCESSORY_NAME())) && (((this.ACCESSORY_SIZE == null) && (localFileModel.getACCESSORY_SIZE() == null)) || ((this.ACCESSORY_SIZE != null) && (this.ACCESSORY_SIZE.equals(localFileModel.getACCESSORY_SIZE())) && (((this.ACCESSORY_TITLE == null) && (localFileModel.getACCESSORY_TITLE() == null)) || ((this.ACCESSORY_TITLE != null) && (this.ACCESSORY_TITLE.equals(localFileModel.getACCESSORY_TITLE())) && (((this.ACCESSORY_URL == null) && (localFileModel.getACCESSORY_URL() == null)) || ((this.ACCESSORY_URL != null) && (this.ACCESSORY_URL.equals(localFileModel.getACCESSORY_URL())))))))));
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
    if (getACCESSORY_NAME() != null) {
      i += getACCESSORY_NAME().hashCode();
    }
    if (getACCESSORY_SIZE() != null) {
      i += getACCESSORY_SIZE().hashCode();
    }
    if (getACCESSORY_TITLE() != null) {
      i += getACCESSORY_TITLE().hashCode();
    }
    if (getACCESSORY_URL() != null) {
      i += getACCESSORY_URL().hashCode();
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
    typeDesc.setXmlType(new QName("urn:BeanService", "FileModel"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("ACCESSORY_NAME");
    localElementDesc.setXmlName(new QName("urn:BeanService", "ACCESSORY_NAME"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("ACCESSORY_SIZE");
    localElementDesc.setXmlName(new QName("urn:BeanService", "ACCESSORY_SIZE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "double"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("ACCESSORY_TITLE");
    localElementDesc.setXmlName(new QName("urn:BeanService", "ACCESSORY_TITLE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("ACCESSORY_URL");
    localElementDesc.setXmlName(new QName("urn:BeanService", "ACCESSORY_URL"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.getUrlServiceSrv.FileModel
 * JD-Core Version:    0.7.0.1
 */