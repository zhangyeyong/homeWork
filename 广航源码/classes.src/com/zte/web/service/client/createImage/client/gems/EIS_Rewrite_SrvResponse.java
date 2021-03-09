package com.zte.web.service.client.createImage.client.gems;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class EIS_Rewrite_SrvResponse
  implements Serializable
{
  private String o_FLAG;
  private String o_MESSAGE;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(EIS_Rewrite_SrvResponse.class, true);
  
  public EIS_Rewrite_SrvResponse() {}
  
  public EIS_Rewrite_SrvResponse(String paramString1, String paramString2)
  {
    this.o_FLAG = paramString1;
    this.o_MESSAGE = paramString2;
  }
  
  public String getO_FLAG()
  {
    return this.o_FLAG;
  }
  
  public void setO_FLAG(String paramString)
  {
    this.o_FLAG = paramString;
  }
  
  public String getO_MESSAGE()
  {
    return this.o_MESSAGE;
  }
  
  public void setO_MESSAGE(String paramString)
  {
    this.o_MESSAGE = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EIS_Rewrite_SrvResponse)) {
      return false;
    }
    EIS_Rewrite_SrvResponse localEIS_Rewrite_SrvResponse = (EIS_Rewrite_SrvResponse)paramObject;
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
    boolean bool = ((this.o_FLAG == null) && (localEIS_Rewrite_SrvResponse.getO_FLAG() == null)) || ((this.o_FLAG != null) && (this.o_FLAG.equals(localEIS_Rewrite_SrvResponse.getO_FLAG())) && (((this.o_MESSAGE == null) && (localEIS_Rewrite_SrvResponse.getO_MESSAGE() == null)) || ((this.o_MESSAGE != null) && (this.o_MESSAGE.equals(localEIS_Rewrite_SrvResponse.getO_MESSAGE())))));
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
    if (getO_FLAG() != null) {
      i += getO_FLAG().hashCode();
    }
    if (getO_MESSAGE() != null) {
      i += getO_MESSAGE().hashCode();
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
    typeDesc.setXmlType(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "EIS_Rewrite_SrvResponse"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("o_FLAG");
    localElementDesc.setXmlName(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "O_FLAG"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("o_MESSAGE");
    localElementDesc.setXmlName(new QName("http://gems.haier.com/EIS_Rewrite_Srv", "O_MESSAGE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.createImage.client.gems.EIS_Rewrite_SrvResponse
 * JD-Core Version:    0.7.0.1
 */