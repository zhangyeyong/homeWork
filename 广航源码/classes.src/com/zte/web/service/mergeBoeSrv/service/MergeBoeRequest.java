package com.zte.web.service.mergeBoeSrv.service;

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

public class MergeBoeRequest
  implements Serializable
{
  private String BOE_NUM;
  private String[] DETAIL_BOE_NUM;
  private String operationType;
  private String employeeNumber;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(MergeBoeRequest.class, true);
  
  public MergeBoeRequest() {}
  
  public MergeBoeRequest(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3)
  {
    this.BOE_NUM = paramString1;
    this.DETAIL_BOE_NUM = paramArrayOfString;
    this.operationType = paramString2;
    this.employeeNumber = paramString3;
  }
  
  public String getBOE_NUM()
  {
    return this.BOE_NUM;
  }
  
  public void setBOE_NUM(String paramString)
  {
    this.BOE_NUM = paramString;
  }
  
  public String[] getDETAIL_BOE_NUM()
  {
    return this.DETAIL_BOE_NUM;
  }
  
  public void setDETAIL_BOE_NUM(String[] paramArrayOfString)
  {
    this.DETAIL_BOE_NUM = paramArrayOfString;
  }
  
  public String getOperationType()
  {
    return this.operationType;
  }
  
  public void setOperationType(String paramString)
  {
    this.operationType = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MergeBoeRequest)) {
      return false;
    }
    MergeBoeRequest localMergeBoeRequest = (MergeBoeRequest)paramObject;
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
    boolean bool = ((this.BOE_NUM == null) && (localMergeBoeRequest.getBOE_NUM() == null)) || ((this.BOE_NUM != null) && (this.BOE_NUM.equals(localMergeBoeRequest.getBOE_NUM())) && (((this.DETAIL_BOE_NUM == null) && (localMergeBoeRequest.getDETAIL_BOE_NUM() == null)) || ((this.DETAIL_BOE_NUM != null) && (Arrays.equals(this.DETAIL_BOE_NUM, localMergeBoeRequest.getDETAIL_BOE_NUM())) && (((this.operationType == null) && (localMergeBoeRequest.getOperationType() == null)) || ((this.operationType != null) && (this.operationType.equals(localMergeBoeRequest.getOperationType())))))));
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
    if (getBOE_NUM() != null) {
      i += getBOE_NUM().hashCode();
    }
    if (getDETAIL_BOE_NUM() != null) {
      for (int j = 0; j < Array.getLength(getDETAIL_BOE_NUM()); j++)
      {
        Object localObject = Array.get(getDETAIL_BOE_NUM(), j);
        if ((localObject != null) && (!localObject.getClass().isArray())) {
          i += localObject.hashCode();
        }
      }
    }
    if (getOperationType() != null) {
      i += getOperationType().hashCode();
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
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  static
  {
    typeDesc.setXmlType(new QName("impl:MergeBoeRequest", "MergeBoeRequest"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("BOE_NUM");
    localElementDesc.setXmlName(new QName("impl:MergeBoeRequest", "BOE_NUM"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("DETAIL_BOE_NUM");
    localElementDesc.setXmlName(new QName("impl:MergeBoeRequest", "DETAIL_BOE_NUM"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    localElementDesc.setItemQName(new QName("http://127.0.0.1/deppon", "item"));
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("operationType");
    localElementDesc.setXmlName(new QName("impl:MergeBoeRequest", "operationType"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("employeeNumber");
    localElementDesc.setXmlName(new QName("impl:MergeBoeRequest", "employeeNumber"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.service.MergeBoeRequest
 * JD-Core Version:    0.7.0.1
 */