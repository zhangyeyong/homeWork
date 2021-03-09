package com.zte.web.service.client.WSImgSystemInterfaceFacade;

import java.io.IOException;
import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.AxisFault;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.SerializationContext;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class WSInvokeException
  extends AxisFault
  implements Serializable
{
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(WSInvokeException.class, true);
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof WSInvokeException)) {
      return false;
    }
    WSInvokeException localWSInvokeException = (WSInvokeException)paramObject;
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
    boolean bool = true;
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
  
  public void writeDetails(QName paramQName, SerializationContext paramSerializationContext)
    throws IOException
  {
    paramSerializationContext.serialize(paramQName, null, this);
  }
  
  static
  {
    typeDesc.setXmlType(new QName("urn:client.imgsysteminterfacefacade", "WSInvokeException"));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.WSImgSystemInterfaceFacade.WSInvokeException
 * JD-Core Version:    0.7.0.1
 */