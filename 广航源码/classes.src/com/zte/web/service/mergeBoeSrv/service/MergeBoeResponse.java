package com.zte.web.service.mergeBoeSrv.service;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class MergeBoeResponse
  implements Serializable
{
  private String ERROR_FLAG;
  private String ERROR_MESSAGE;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(MergeBoeResponse.class, true);
  
  public MergeBoeResponse() {}
  
  public MergeBoeResponse(String paramString1, String paramString2)
  {
    this.ERROR_FLAG = paramString1;
    this.ERROR_MESSAGE = paramString2;
  }
  
  public String getERROR_FLAG()
  {
    return this.ERROR_FLAG;
  }
  
  public void setERROR_FLAG(String paramString)
  {
    this.ERROR_FLAG = paramString;
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
    if (!(paramObject instanceof MergeBoeResponse)) {
      return false;
    }
    MergeBoeResponse localMergeBoeResponse = (MergeBoeResponse)paramObject;
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
    boolean bool = ((this.ERROR_FLAG == null) && (localMergeBoeResponse.getERROR_FLAG() == null)) || ((this.ERROR_FLAG != null) && (this.ERROR_FLAG.equals(localMergeBoeResponse.getERROR_FLAG())) && (((this.ERROR_MESSAGE == null) && (localMergeBoeResponse.getERROR_MESSAGE() == null)) || ((this.ERROR_MESSAGE != null) && (this.ERROR_MESSAGE.equals(localMergeBoeResponse.getERROR_MESSAGE())))));
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
    if (getERROR_FLAG() != null) {
      i += getERROR_FLAG().hashCode();
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
    typeDesc.setXmlType(new QName("impl:MergeBoeResponse", "MergeBoeResponse"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("ERROR_FLAG");
    localElementDesc.setXmlName(new QName("impl:MergeBoeResponse", "ERROR_FLAG"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("ERROR_MESSAGE");
    localElementDesc.setXmlName(new QName("impl:MergeBoeResponse", "ERROR_MESSAGE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.service.MergeBoeResponse
 * JD-Core Version:    0.7.0.1
 */