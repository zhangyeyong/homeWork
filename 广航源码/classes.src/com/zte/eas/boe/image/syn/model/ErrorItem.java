package com.zte.eas.boe.image.syn.model;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class ErrorItem
  implements Serializable
{
  private String ENTITY_NAME;
  private String RECORD_NUMBER;
  private String ERROR_MESSAGE;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(ErrorItem.class, true);
  
  public ErrorItem() {}
  
  public ErrorItem(String paramString1, String paramString2, String paramString3)
  {
    this.ENTITY_NAME = paramString1;
    this.RECORD_NUMBER = paramString2;
    this.ERROR_MESSAGE = paramString3;
  }
  
  public String getENTITY_NAME()
  {
    return this.ENTITY_NAME;
  }
  
  public void setENTITY_NAME(String paramString)
  {
    this.ENTITY_NAME = paramString;
  }
  
  public String getRECORD_NUMBER()
  {
    return this.RECORD_NUMBER;
  }
  
  public void setRECORD_NUMBER(String paramString)
  {
    this.RECORD_NUMBER = paramString;
  }
  
  public String getERROR_MESSAGE()
  {
    return this.ERROR_MESSAGE;
  }
  
  public void setERROR_MESSAGE(String paramString)
  {
    this.ERROR_MESSAGE = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ErrorItem)) {
      return false;
    }
    ErrorItem localErrorItem = (ErrorItem)paramObject;
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
    boolean bool = ((this.ENTITY_NAME == null) && (localErrorItem.getENTITY_NAME() == null)) || ((this.ENTITY_NAME != null) && (this.ENTITY_NAME.equals(localErrorItem.getENTITY_NAME())) && (((this.RECORD_NUMBER == null) && (localErrorItem.getRECORD_NUMBER() == null)) || ((this.RECORD_NUMBER != null) && (this.RECORD_NUMBER.equals(localErrorItem.getRECORD_NUMBER())) && (((this.ERROR_MESSAGE == null) && (localErrorItem.getERROR_MESSAGE() == null)) || ((this.ERROR_MESSAGE != null) && (this.ERROR_MESSAGE.equals(localErrorItem.getERROR_MESSAGE())))))));
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
    if (getENTITY_NAME() != null) {
      i += getENTITY_NAME().hashCode();
    }
    if (getRECORD_NUMBER() != null) {
      i += getRECORD_NUMBER().hashCode();
    }
    if (getERROR_MESSAGE() != null) {
      i += getERROR_MESSAGE().hashCode();
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
    typeDesc.setXmlType(new QName("http://mss.cmcc.com/ImportSrvResponse", "ErrorItem"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("ENTITY_NAME");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/ImportSrvResponse", "ENTITY_NAME"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("RECORD_NUMBER");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/ImportSrvResponse", "RECORD_NUMBER"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("ERROR_MESSAGE");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/ImportSrvResponse", "ERROR_MESSAGE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.model.ErrorItem
 * JD-Core Version:    0.7.0.1
 */