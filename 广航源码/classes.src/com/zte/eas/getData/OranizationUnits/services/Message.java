package com.zte.eas.getData.OranizationUnits.services;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class Message
  implements Serializable
{
  private String errCode;
  private String errInfos;
  private String result;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(Message.class, true);
  
  public Message() {}
  
  public Message(String paramString1, String paramString2, String paramString3)
  {
    this.errCode = paramString1;
    this.errInfos = paramString2;
    this.result = paramString3;
  }
  
  public String getErrCode()
  {
    return this.errCode;
  }
  
  public void setErrCode(String paramString)
  {
    this.errCode = paramString;
  }
  
  public String getErrInfos()
  {
    return this.errInfos;
  }
  
  public void setErrInfos(String paramString)
  {
    this.errInfos = paramString;
  }
  
  public String getResult()
  {
    return this.result;
  }
  
  public void setResult(String paramString)
  {
    this.result = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Message)) {
      return false;
    }
    Message localMessage = (Message)paramObject;
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
    boolean bool = ((this.errCode == null) && (localMessage.getErrCode() == null)) || ((this.errCode != null) && (this.errCode.equals(localMessage.getErrCode())) && (((this.errInfos == null) && (localMessage.getErrInfos() == null)) || ((this.errInfos != null) && (this.errInfos.equals(localMessage.getErrInfos())) && (((this.result == null) && (localMessage.getResult() == null)) || ((this.result != null) && (this.result.equals(localMessage.getResult())))))));
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
    if (getErrCode() != null) {
      i += getErrCode().hashCode();
    }
    if (getErrInfos() != null) {
      i += getErrInfos().hashCode();
    }
    if (getResult() != null) {
      i += getResult().hashCode();
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
    typeDesc.setXmlType(new QName("impl:Message", "Message"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("errCode");
    localElementDesc.setXmlName(new QName("impl:Message", "errCode"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("errInfos");
    localElementDesc.setXmlName(new QName("impl:Message", "errInfos"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("result");
    localElementDesc.setXmlName(new QName("impl:Message", "result"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.services.Message
 * JD-Core Version:    0.7.0.1
 */