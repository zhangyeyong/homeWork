package com.zte.web.service.client.sendEmailPS;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class OutputMessageType
  implements Serializable
{
  private String consumerEmailID;
  private String resultFlag;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(OutputMessageType.class, true);
  
  public OutputMessageType() {}
  
  public OutputMessageType(String paramString1, String paramString2)
  {
    this.consumerEmailID = paramString1;
    this.resultFlag = paramString2;
  }
  
  public String getConsumerEmailID()
  {
    return this.consumerEmailID;
  }
  
  public void setConsumerEmailID(String paramString)
  {
    this.consumerEmailID = paramString;
  }
  
  public String getResultFlag()
  {
    return this.resultFlag;
  }
  
  public void setResultFlag(String paramString)
  {
    this.resultFlag = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof OutputMessageType)) {
      return false;
    }
    OutputMessageType localOutputMessageType = (OutputMessageType)paramObject;
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
    boolean bool = ((this.consumerEmailID == null) && (localOutputMessageType.getConsumerEmailID() == null)) || ((this.consumerEmailID != null) && (this.consumerEmailID.equals(localOutputMessageType.getConsumerEmailID())) && (((this.resultFlag == null) && (localOutputMessageType.getResultFlag() == null)) || ((this.resultFlag != null) && (this.resultFlag.equals(localOutputMessageType.getResultFlag())))));
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
    if (getConsumerEmailID() != null) {
      i += getConsumerEmailID().hashCode();
    }
    if (getResultFlag() != null) {
      i += getResultFlag().hashCode();
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
    typeDesc.setXmlType(new QName("http://www.haier.eai.com/SendEmailPS", "OutputMessageType"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("consumerEmailID");
    localElementDesc.setXmlName(new QName("http://www.haier.eai.com/SendEmailPS", "ConsumerEmailID"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("resultFlag");
    localElementDesc.setXmlName(new QName("http://www.haier.eai.com/SendEmailPS", "ResultFlag"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.sendEmailPS.OutputMessageType
 * JD-Core Version:    0.7.0.1
 */