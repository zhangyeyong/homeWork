package com.zte.web.service.client.createImage.client.gems;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class EIS_Rewrite_SrvRequest
  implements Serializable
{
  private String i_BOE_NUM;
  private String i_IMAGE_SOURCE;
  private String i_IMAGE_STATUS;
  private String i_SCAN_NUM;
  private String i_SCAN_URL;
  private String i_UPDATE_BY;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(EIS_Rewrite_SrvRequest.class, true);
  
  public EIS_Rewrite_SrvRequest() {}
  
  public EIS_Rewrite_SrvRequest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.i_BOE_NUM = paramString1;
    this.i_IMAGE_SOURCE = paramString2;
    this.i_IMAGE_STATUS = paramString3;
    this.i_SCAN_NUM = paramString4;
    this.i_SCAN_URL = paramString5;
    this.i_UPDATE_BY = paramString6;
  }
  
  public String getI_BOE_NUM()
  {
    return this.i_BOE_NUM;
  }
  
  public void setI_BOE_NUM(String paramString)
  {
    this.i_BOE_NUM = paramString;
  }
  
  public String getI_IMAGE_SOURCE()
  {
    return this.i_IMAGE_SOURCE;
  }
  
  public void setI_IMAGE_SOURCE(String paramString)
  {
    this.i_IMAGE_SOURCE = paramString;
  }
  
  public String getI_IMAGE_STATUS()
  {
    return this.i_IMAGE_STATUS;
  }
  
  public void setI_IMAGE_STATUS(String paramString)
  {
    this.i_IMAGE_STATUS = paramString;
  }
  
  public String getI_SCAN_NUM()
  {
    return this.i_SCAN_NUM;
  }
  
  public void setI_SCAN_NUM(String paramString)
  {
    this.i_SCAN_NUM = paramString;
  }
  
  public String getI_SCAN_URL()
  {
    return this.i_SCAN_URL;
  }
  
  public void setI_SCAN_URL(String paramString)
  {
    this.i_SCAN_URL = paramString;
  }
  
  public String getI_UPDATE_BY()
  {
    return this.i_UPDATE_BY;
  }
  
  public void setI_UPDATE_BY(String paramString)
  {
    this.i_UPDATE_BY = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EIS_Rewrite_SrvRequest)) {
      return false;
    }
    EIS_Rewrite_SrvRequest localEIS_Rewrite_SrvRequest = (EIS_Rewrite_SrvRequest)paramObject;
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
    boolean bool = ((this.i_BOE_NUM == null) && (localEIS_Rewrite_SrvRequest.getI_BOE_NUM() == null)) || ((this.i_BOE_NUM != null) && (this.i_BOE_NUM.equals(localEIS_Rewrite_SrvRequest.getI_BOE_NUM())) && (((this.i_IMAGE_SOURCE == null) && (localEIS_Rewrite_SrvRequest.getI_IMAGE_SOURCE() == null)) || ((this.i_IMAGE_SOURCE != null) && (this.i_IMAGE_SOURCE.equals(localEIS_Rewrite_SrvRequest.getI_IMAGE_SOURCE())) && (((this.i_IMAGE_STATUS == null) && (localEIS_Rewrite_SrvRequest.getI_IMAGE_STATUS() == null)) || ((this.i_IMAGE_STATUS != null) && (this.i_IMAGE_STATUS.equals(localEIS_Rewrite_SrvRequest.getI_IMAGE_STATUS())) && (((this.i_SCAN_NUM == null) && (localEIS_Rewrite_SrvRequest.getI_SCAN_NUM() == null)) || ((this.i_SCAN_NUM != null) && (this.i_SCAN_NUM.equals(localEIS_Rewrite_SrvRequest.getI_SCAN_NUM())) && (((this.i_SCAN_URL == null) && (localEIS_Rewrite_SrvRequest.getI_SCAN_URL() == null)) || ((this.i_SCAN_URL != null) && (this.i_SCAN_URL.equals(localEIS_Rewrite_SrvRequest.getI_SCAN_URL())) && (((this.i_UPDATE_BY == null) && (localEIS_Rewrite_SrvRequest.getI_UPDATE_BY() == null)) || ((this.i_UPDATE_BY != null) && (this.i_UPDATE_BY.equals(localEIS_Rewrite_SrvRequest.getI_UPDATE_BY())))))))))))));
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
    if (getI_BOE_NUM() != null) {
      i += getI_BOE_NUM().hashCode();
    }
    if (getI_IMAGE_SOURCE() != null) {
      i += getI_IMAGE_SOURCE().hashCode();
    }
    if (getI_IMAGE_STATUS() != null) {
      i += getI_IMAGE_STATUS().hashCode();
    }
    if (getI_SCAN_NUM() != null) {
      i += getI_SCAN_NUM().hashCode();
    }
    if (getI_SCAN_URL() != null) {
      i += getI_SCAN_URL().hashCode();
    }
    if (getI_UPDATE_BY() != null) {
      i += getI_UPDATE_BY().hashCode();
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
    typeDesc.setXmlType(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "EIS_Rewrite_SrvRequest"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("i_BOE_NUM");
    localElementDesc.setXmlName(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "I_BOE_NUM"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("i_IMAGE_SOURCE");
    localElementDesc.setXmlName(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "I_IMAGE_SOURCE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("i_IMAGE_STATUS");
    localElementDesc.setXmlName(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "I_IMAGE_STATUS"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("i_SCAN_NUM");
    localElementDesc.setXmlName(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "I_SCAN_NUM"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("i_SCAN_URL");
    localElementDesc.setXmlName(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "I_SCAN_URL"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("i_UPDATE_BY");
    localElementDesc.setXmlName(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "I_UPDATE_BY"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.createImage.client.gems.EIS_Rewrite_SrvRequest
 * JD-Core Version:    0.7.0.1
 */