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

public class OutputType
  implements Serializable
{
  private RowSetRowColumn[][] returnRowInfo;
  private RowSingle extendField;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(OutputType.class, true);
  
  public OutputType() {}
  
  public OutputType(RowSetRowColumn[][] paramArrayOfRowSetRowColumn, RowSingle paramRowSingle)
  {
    this.returnRowInfo = paramArrayOfRowSetRowColumn;
    this.extendField = paramRowSingle;
  }
  
  public RowSetRowColumn[][] getReturnRowInfo()
  {
    return this.returnRowInfo;
  }
  
  public void setReturnRowInfo(RowSetRowColumn[][] paramArrayOfRowSetRowColumn)
  {
    this.returnRowInfo = paramArrayOfRowSetRowColumn;
  }
  
  public RowSingle getExtendField()
  {
    return this.extendField;
  }
  
  public void setExtendField(RowSingle paramRowSingle)
  {
    this.extendField = paramRowSingle;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof OutputType)) {
      return false;
    }
    OutputType localOutputType = (OutputType)paramObject;
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
    boolean bool = ((this.returnRowInfo == null) && (localOutputType.getReturnRowInfo() == null)) || ((this.returnRowInfo != null) && (Arrays.equals(this.returnRowInfo, localOutputType.getReturnRowInfo())) && (((this.extendField == null) && (localOutputType.getExtendField() == null)) || ((this.extendField != null) && (this.extendField.equals(localOutputType.getExtendField())))));
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
    if (getReturnRowInfo() != null) {
      for (int j = 0; j < Array.getLength(getReturnRowInfo()); j++)
      {
        Object localObject = Array.get(getReturnRowInfo(), j);
        if ((localObject != null) && (!localObject.getClass().isArray())) {
          i += localObject.hashCode();
        }
      }
    }
    if (getExtendField() != null) {
      i += getExtendField().hashCode();
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
    typeDesc.setXmlType(new QName("http://eai.haier.com/QueryPortalCommonService/", "OutputType"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("returnRowInfo");
    localElementDesc.setXmlName(new QName("http://eai.haier.com/QueryPortalCommonService/", "ReturnRowInfo"));
    localElementDesc.setXmlType(new QName("http://eai.haier.com/QueryPortalCommonService/", ">RowSet>Row"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    localElementDesc.setItemQName(new QName("http://eai.haier.com/QueryPortalCommonService/", "Row"));
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("extendField");
    localElementDesc.setXmlName(new QName("http://eai.haier.com/QueryPortalCommonService/", "ExtendField"));
    localElementDesc.setXmlType(new QName("http://eai.haier.com/QueryPortalCommonService/", "RowSingle"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.esp.OutputType
 * JD-Core Version:    0.7.0.1
 */