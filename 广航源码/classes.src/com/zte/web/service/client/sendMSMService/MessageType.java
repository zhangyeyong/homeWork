package com.zte.web.service.client.sendMSMService;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class MessageType
  implements Serializable
{
  private String desMobile;
  private String content;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(MessageType.class, true);
  
  public MessageType() {}
  
  public MessageType(String paramString1, String paramString2)
  {
    this.desMobile = paramString1;
    this.content = paramString2;
  }
  
  public String getDesMobile()
  {
    return this.desMobile;
  }
  
  public void setDesMobile(String paramString)
  {
    this.desMobile = paramString;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MessageType)) {
      return false;
    }
    MessageType localMessageType = (MessageType)paramObject;
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
    boolean bool = ((this.desMobile == null) && (localMessageType.getDesMobile() == null)) || ((this.desMobile != null) && (this.desMobile.equals(localMessageType.getDesMobile())) && (((this.content == null) && (localMessageType.getContent() == null)) || ((this.content != null) && (this.content.equals(localMessageType.getContent())))));
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
    if (getDesMobile() != null) {
      i += getDesMobile().hashCode();
    }
    if (getContent() != null) {
      i += getContent().hashCode();
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
    typeDesc.setXmlType(new QName("http://www.haier.eai/SendMSMService/", "MessageType"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("desMobile");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "DesMobile"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("content");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "Content"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.sendMSMService.MessageType
 * JD-Core Version:    0.7.0.1
 */