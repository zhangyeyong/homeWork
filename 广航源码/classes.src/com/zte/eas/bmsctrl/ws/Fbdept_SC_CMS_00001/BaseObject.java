package com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001;

import java.io.Serializable;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public abstract class BaseObject
  implements Serializable
{
  private String firstKeyColumnName;
  private HashMap primaryKeyMap;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(BaseObject.class, true);
  
  public BaseObject() {}
  
  public BaseObject(String paramString, HashMap paramHashMap)
  {
    this.firstKeyColumnName = paramString;
    this.primaryKeyMap = paramHashMap;
  }
  
  public String getFirstKeyColumnName()
  {
    return this.firstKeyColumnName;
  }
  
  public void setFirstKeyColumnName(String paramString)
  {
    this.firstKeyColumnName = paramString;
  }
  
  public HashMap getPrimaryKeyMap()
  {
    return this.primaryKeyMap;
  }
  
  public void setPrimaryKeyMap(HashMap paramHashMap)
  {
    this.primaryKeyMap = paramHashMap;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BaseObject)) {
      return false;
    }
    BaseObject localBaseObject = (BaseObject)paramObject;
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
    boolean bool = ((this.firstKeyColumnName == null) && (localBaseObject.getFirstKeyColumnName() == null)) || ((this.firstKeyColumnName != null) && (this.firstKeyColumnName.equals(localBaseObject.getFirstKeyColumnName())) && (((this.primaryKeyMap == null) && (localBaseObject.getPrimaryKeyMap() == null)) || ((this.primaryKeyMap != null) && (this.primaryKeyMap.equals(localBaseObject.getPrimaryKeyMap())))));
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
    if (getFirstKeyColumnName() != null) {
      i += getFirstKeyColumnName().hashCode();
    }
    if (getPrimaryKeyMap() != null) {
      i += getPrimaryKeyMap().hashCode();
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
    typeDesc.setXmlType(new QName("http://base.framework.ssb.zte.com", "BaseObject"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("firstKeyColumnName");
    localElementDesc.setXmlName(new QName("", "firstKeyColumnName"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("primaryKeyMap");
    localElementDesc.setXmlName(new QName("", "primaryKeyMap"));
    localElementDesc.setXmlType(new QName("http://xml.apache.org/xml-soap", "Map"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001.BaseObject
 * JD-Core Version:    0.7.0.1
 */