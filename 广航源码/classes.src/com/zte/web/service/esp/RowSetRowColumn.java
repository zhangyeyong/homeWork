package com.zte.web.service.esp;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.AttributeDesc;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.SimpleType;
import org.apache.axis.encoding.ser.SimpleDeserializer;
import org.apache.axis.encoding.ser.SimpleSerializer;

public class RowSetRowColumn
  implements Serializable, SimpleType
{
  private String _value;
  private String name;
  private String relationalName;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(RowSetRowColumn.class, true);
  
  public RowSetRowColumn() {}
  
  public RowSetRowColumn(String paramString)
  {
    this._value = paramString;
  }
  
  public String toString()
  {
    return this._value;
  }
  
  public String get_value()
  {
    return this._value;
  }
  
  public void set_value(String paramString)
  {
    this._value = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public String getRelationalName()
  {
    return this.relationalName;
  }
  
  public void setRelationalName(String paramString)
  {
    this.relationalName = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RowSetRowColumn)) {
      return false;
    }
    RowSetRowColumn localRowSetRowColumn = (RowSetRowColumn)paramObject;
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
    boolean bool = ((this._value == null) && (localRowSetRowColumn.get_value() == null)) || ((this._value != null) && (this._value.equals(localRowSetRowColumn.get_value())) && (((this.name == null) && (localRowSetRowColumn.getName() == null)) || ((this.name != null) && (this.name.equals(localRowSetRowColumn.getName())) && (((this.relationalName == null) && (localRowSetRowColumn.getRelationalName() == null)) || ((this.relationalName != null) && (this.relationalName.equals(localRowSetRowColumn.getRelationalName())))))));
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
    if (get_value() != null) {
      i += get_value().hashCode();
    }
    if (getName() != null) {
      i += getName().hashCode();
    }
    if (getRelationalName() != null) {
      i += getRelationalName().hashCode();
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
    return new SimpleSerializer(paramClass, paramQName, typeDesc);
  }
  
  public static Deserializer getDeserializer(String paramString, Class paramClass, QName paramQName)
  {
    return new SimpleDeserializer(paramClass, paramQName, typeDesc);
  }
  
  static
  {
    typeDesc.setXmlType(new QName("http://eai.haier.com/QueryPortalCommonService/", ">>RowSet>Row>Column"));
    AttributeDesc localAttributeDesc = new AttributeDesc();
    localAttributeDesc.setFieldName("name");
    localAttributeDesc.setXmlName(new QName("", "name"));
    localAttributeDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    typeDesc.addFieldDesc(localAttributeDesc);
    localAttributeDesc = new AttributeDesc();
    localAttributeDesc.setFieldName("relationalName");
    localAttributeDesc.setXmlName(new QName("", "relationalName"));
    localAttributeDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    typeDesc.addFieldDesc(localAttributeDesc);
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("_value");
    localElementDesc.setXmlName(new QName("", "_value"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.esp.RowSetRowColumn
 * JD-Core Version:    0.7.0.1
 */