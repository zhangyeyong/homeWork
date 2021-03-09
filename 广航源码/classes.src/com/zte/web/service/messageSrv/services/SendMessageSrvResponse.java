package com.zte.web.service.messageSrv.services;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class SendMessageSrvResponse
  implements Serializable
{
  private String attribute1;
  private String attribute10;
  private String attribute2;
  private String attribute3;
  private String attribute4;
  private String attribute5;
  private String attribute6;
  private String attribute7;
  private String attribute8;
  private String attribute9;
  private String boeNum;
  private String employeeNumber;
  private String errorFlag;
  private String errorMessage;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(SendMessageSrvResponse.class, true);
  
  public SendMessageSrvResponse() {}
  
  public SendMessageSrvResponse(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    this.attribute1 = paramString1;
    this.attribute10 = paramString2;
    this.attribute2 = paramString3;
    this.attribute3 = paramString4;
    this.attribute4 = paramString5;
    this.attribute5 = paramString6;
    this.attribute6 = paramString7;
    this.attribute7 = paramString8;
    this.attribute8 = paramString9;
    this.attribute9 = paramString10;
    this.boeNum = paramString11;
    this.employeeNumber = paramString12;
    this.errorFlag = paramString13;
    this.errorMessage = paramString14;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
  }
  
  public String getAttribute10()
  {
    return this.attribute10;
  }
  
  public void setAttribute10(String paramString)
  {
    this.attribute10 = paramString;
  }
  
  public String getAttribute2()
  {
    return this.attribute2;
  }
  
  public void setAttribute2(String paramString)
  {
    this.attribute2 = paramString;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public void setAttribute3(String paramString)
  {
    this.attribute3 = paramString;
  }
  
  public String getAttribute4()
  {
    return this.attribute4;
  }
  
  public void setAttribute4(String paramString)
  {
    this.attribute4 = paramString;
  }
  
  public String getAttribute5()
  {
    return this.attribute5;
  }
  
  public void setAttribute5(String paramString)
  {
    this.attribute5 = paramString;
  }
  
  public String getAttribute6()
  {
    return this.attribute6;
  }
  
  public void setAttribute6(String paramString)
  {
    this.attribute6 = paramString;
  }
  
  public String getAttribute7()
  {
    return this.attribute7;
  }
  
  public void setAttribute7(String paramString)
  {
    this.attribute7 = paramString;
  }
  
  public String getAttribute8()
  {
    return this.attribute8;
  }
  
  public void setAttribute8(String paramString)
  {
    this.attribute8 = paramString;
  }
  
  public String getAttribute9()
  {
    return this.attribute9;
  }
  
  public void setAttribute9(String paramString)
  {
    this.attribute9 = paramString;
  }
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
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
    if (!(paramObject instanceof SendMessageSrvResponse)) {
      return false;
    }
    SendMessageSrvResponse localSendMessageSrvResponse = (SendMessageSrvResponse)paramObject;
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
    boolean bool = ((this.attribute1 == null) && (localSendMessageSrvResponse.getAttribute1() == null)) || ((this.attribute1 != null) && (this.attribute1.equals(localSendMessageSrvResponse.getAttribute1())) && (((this.attribute10 == null) && (localSendMessageSrvResponse.getAttribute10() == null)) || ((this.attribute10 != null) && (this.attribute10.equals(localSendMessageSrvResponse.getAttribute10())) && (((this.attribute2 == null) && (localSendMessageSrvResponse.getAttribute2() == null)) || ((this.attribute2 != null) && (this.attribute2.equals(localSendMessageSrvResponse.getAttribute2())) && (((this.attribute3 == null) && (localSendMessageSrvResponse.getAttribute3() == null)) || ((this.attribute3 != null) && (this.attribute3.equals(localSendMessageSrvResponse.getAttribute3())) && (((this.attribute4 == null) && (localSendMessageSrvResponse.getAttribute4() == null)) || ((this.attribute4 != null) && (this.attribute4.equals(localSendMessageSrvResponse.getAttribute4())) && (((this.attribute5 == null) && (localSendMessageSrvResponse.getAttribute5() == null)) || ((this.attribute5 != null) && (this.attribute5.equals(localSendMessageSrvResponse.getAttribute5())) && (((this.attribute6 == null) && (localSendMessageSrvResponse.getAttribute6() == null)) || ((this.attribute6 != null) && (this.attribute6.equals(localSendMessageSrvResponse.getAttribute6())) && (((this.attribute7 == null) && (localSendMessageSrvResponse.getAttribute7() == null)) || ((this.attribute7 != null) && (this.attribute7.equals(localSendMessageSrvResponse.getAttribute7())) && (((this.attribute8 == null) && (localSendMessageSrvResponse.getAttribute8() == null)) || ((this.attribute8 != null) && (this.attribute8.equals(localSendMessageSrvResponse.getAttribute8())) && (((this.attribute9 == null) && (localSendMessageSrvResponse.getAttribute9() == null)) || ((this.attribute9 != null) && (this.attribute9.equals(localSendMessageSrvResponse.getAttribute9())) && (((this.boeNum == null) && (localSendMessageSrvResponse.getBoeNum() == null)) || ((this.boeNum != null) && (this.boeNum.equals(localSendMessageSrvResponse.getBoeNum())) && (((this.employeeNumber == null) && (localSendMessageSrvResponse.getEmployeeNumber() == null)) || ((this.employeeNumber != null) && (this.employeeNumber.equals(localSendMessageSrvResponse.getEmployeeNumber())) && (((this.errorFlag == null) && (localSendMessageSrvResponse.getErrorFlag() == null)) || ((this.errorFlag != null) && (this.errorFlag.equals(localSendMessageSrvResponse.getErrorFlag())) && (((this.errorMessage == null) && (localSendMessageSrvResponse.getErrorMessage() == null)) || ((this.errorMessage != null) && (this.errorMessage.equals(localSendMessageSrvResponse.getErrorMessage())))))))))))))))))))))))))))));
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
    if (getAttribute1() != null) {
      i += getAttribute1().hashCode();
    }
    if (getAttribute10() != null) {
      i += getAttribute10().hashCode();
    }
    if (getAttribute2() != null) {
      i += getAttribute2().hashCode();
    }
    if (getAttribute3() != null) {
      i += getAttribute3().hashCode();
    }
    if (getAttribute4() != null) {
      i += getAttribute4().hashCode();
    }
    if (getAttribute5() != null) {
      i += getAttribute5().hashCode();
    }
    if (getAttribute6() != null) {
      i += getAttribute6().hashCode();
    }
    if (getAttribute7() != null) {
      i += getAttribute7().hashCode();
    }
    if (getAttribute8() != null) {
      i += getAttribute8().hashCode();
    }
    if (getAttribute9() != null) {
      i += getAttribute9().hashCode();
    }
    if (getBoeNum() != null) {
      i += getBoeNum().hashCode();
    }
    if (getEmployeeNumber() != null) {
      i += getEmployeeNumber().hashCode();
    }
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
    typeDesc.setXmlType(new QName("impl:SendMessageSrvResponse", "SendMessageSrvResponse"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute1");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "attribute1"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute10");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "attribute10"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute2");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "attribute2"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute3");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "attribute3"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute4");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "attribute4"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute5");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "attribute5"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute6");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "attribute6"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute7");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "attribute7"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute8");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "attribute8"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute9");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "attribute9"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("boeNum");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "boeNum"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("employeeNumber");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "employeeNumber"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("errorFlag");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "errorFlag"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("errorMessage");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvResponse", "errorMessage"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.messageSrv.services.SendMessageSrvResponse
 * JD-Core Version:    0.7.0.1
 */