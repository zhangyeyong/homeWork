package com.zte.web.service.esp;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class RowSingle
  implements Serializable
{
  private RowSingleRowColumn[] row;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(RowSingle.class, true);
  
  public RowSingle() {}
  
  public RowSingle(RowSingleRowColumn[] paramArrayOfRowSingleRowColumn)
  {
    this.row = paramArrayOfRowSingleRowColumn;
  }
  
  public RowSingleRowColumn[] getRow()
  {
    return this.row;
  }
  
  public void setRow(RowSingleRowColumn[] paramArrayOfRowSingleRowColumn)
  {
    this.row = paramArrayOfRowSingleRowColumn;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RowSingle)) {
      return false;
    }
    RowSingle localRowSingle = (RowSingle)paramObject;
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
    boolean bool = ((this.row == null) && (localRowSingle.getRow() == null)) || ((this.row != null) && (Arrays.equals(this.row, localRowSingle.getRow())));
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
    if (getRow() != null) {
      for (int j = 0; j < Array.getLength(getRow()); j++)
      {
        Object localObject = Array.get(getRow(), j);
        if ((localObject != null) && (!localObject.getClass().isArray())) {
          i += localObject.hashCode();
        }
      }
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
    typeDesc.setXmlType(new QName("http://eai.haier.com/QueryPortalCommonService/", "RowSingle"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("row");
    localElementDesc.setXmlName(new QName("http://eai.haier.com/QueryPortalCommonService/", "Row"));
    localElementDesc.setXmlType(new QName("http://eai.haier.com/QueryPortalCommonService/", ">>RowSingle>Row>Column"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(true);
    localElementDesc.setItemQName(new QName("http://eai.haier.com/QueryPortalCommonService/", "Column"));
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.esp.RowSingle
 * JD-Core Version:    0.7.0.1
 */