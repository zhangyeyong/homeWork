package com.zte.web.service.client.adjustCreditSrv;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class AdjustCreditSrvResponse
  implements Serializable
{
  private String errorFlag;
  private String errorMessage;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(AdjustCreditSrvResponse.class, true);
  
  public AdjustCreditSrvResponse() {}
  
  public AdjustCreditSrvResponse(String paramString1, String paramString2)
  {
    this.errorFlag = paramString1;
    this.errorMessage = paramString2;
  }
  
  public String getErrorFlag()
  {
    return this.errorFlag;
  }
  
  public void setErrorFlag(String paramString)
  {
    this.errorFlag = paramString;
  }
  
  public String getErrorMessage()
  {
    return this.errorMessage;
  }
  
  public void setErrorMessage(String paramString)
  {
    this.errorMessage = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdjustCreditSrvResponse)) {
      return false;
    }
    AdjustCreditSrvResponse localAdjustCreditSrvResponse = (AdjustCreditSrvResponse)paramObject;
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
    boolean bool = ((this.errorFlag == null) && (localAdjustCreditSrvResponse.getErrorFlag() == null)) || ((this.errorFlag != null) && (this.errorFlag.equals(localAdjustCreditSrvResponse.getErrorFlag())) && (((this.errorMessage == null) && (localAdjustCreditSrvResponse.getErrorMessage() == null)) || ((this.errorMessage != null) && (this.errorMessage.equals(localAdjustCreditSrvResponse.getErrorMessage())))));
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
    if (getErrorFlag() != null) {
      i += getErrorFlag().hashCode();
    }
    if (getErrorMessage() != null) {
      i += getErrorMessage().hashCode();
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
    typeDesc.setXmlType(new QName("impl:AdjustCreditSrvResponse", "AdjustCreditSrvResponse"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("errorFlag");
    localElementDesc.setXmlName(new QName("", "errorFlag"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("errorMessage");
    localElementDesc.setXmlName(new QName("", "errorMessage"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.adjustCreditSrv.AdjustCreditSrvResponse
 * JD-Core Version:    0.7.0.1
 */