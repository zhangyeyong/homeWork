package com.zte.eas.boe.image.syn.judget;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class ResponseItem
  implements Serializable
{
  private String REQUEST_ID;
  private String RECORD_NUMBER;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(ResponseItem.class, true);
  
  public ResponseItem() {}
  
  public ResponseItem(String paramString1, String paramString2)
  {
    this.REQUEST_ID = paramString1;
    this.RECORD_NUMBER = paramString2;
  }
  
  public String getREQUEST_ID()
  {
    return this.REQUEST_ID;
  }
  
  public void setREQUEST_ID(String paramString)
  {
    this.REQUEST_ID = paramString;
  }
  
  public String getRECORD_NUMBER()
  {
    return this.RECORD_NUMBER;
  }
  
  public void setRECORD_NUMBER(String paramString)
  {
    this.RECORD_NUMBER = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ResponseItem)) {
      return false;
    }
    ResponseItem localResponseItem = (ResponseItem)paramObject;
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
    boolean bool = ((this.REQUEST_ID == null) && (localResponseItem.getREQUEST_ID() == null)) || ((this.REQUEST_ID != null) && (this.REQUEST_ID.equals(localResponseItem.getREQUEST_ID())) && (((this.RECORD_NUMBER == null) && (localResponseItem.getRECORD_NUMBER() == null)) || ((this.RECORD_NUMBER != null) && (this.RECORD_NUMBER.equals(localResponseItem.getRECORD_NUMBER())))));
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
    if (getREQUEST_ID() != null) {
      i += getREQUEST_ID().hashCode();
    }
    if (getRECORD_NUMBER() != null) {
      i += getRECORD_NUMBER().hashCode();
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
    typeDesc.setXmlType(new QName("http://mss.cmcc.com/ImportSrvResponse", "ResponseItem"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("REQUEST_ID");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/ImportSrvResponse", "REQUEST_ID"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("RECORD_NUMBER");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/ImportSrvResponse", "RECORD_NUMBER"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.judget.ResponseItem
 * JD-Core Version:    0.7.0.1
 */