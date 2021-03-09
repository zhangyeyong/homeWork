package com.zte.web.service.messageSrv.services;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class SendMessageSrvRequest
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
  private String rejectReason;
  private String rejectType;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(SendMessageSrvRequest.class, true);
  
  public SendMessageSrvRequest() {}
  
  public SendMessageSrvRequest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
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
    this.rejectReason = paramString13;
    this.rejectType = paramString14;
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
  
  public String getRejectReason()
  {
    return this.rejectReason;
  }
  
  public void setRejectReason(String paramString)
  {
    this.rejectReason = paramString;
  }
  
  public String getRejectType()
  {
    return this.rejectType;
  }
  
  public void setRejectType(String paramString)
  {
    this.rejectType = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SendMessageSrvRequest)) {
      return false;
    }
    SendMessageSrvRequest localSendMessageSrvRequest = (SendMessageSrvRequest)paramObject;
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
    boolean bool = ((this.attribute1 == null) && (localSendMessageSrvRequest.getAttribute1() == null)) || ((this.attribute1 != null) && (this.attribute1.equals(localSendMessageSrvRequest.getAttribute1())) && (((this.attribute10 == null) && (localSendMessageSrvRequest.getAttribute10() == null)) || ((this.attribute10 != null) && (this.attribute10.equals(localSendMessageSrvRequest.getAttribute10())) && (((this.attribute2 == null) && (localSendMessageSrvRequest.getAttribute2() == null)) || ((this.attribute2 != null) && (this.attribute2.equals(localSendMessageSrvRequest.getAttribute2())) && (((this.attribute3 == null) && (localSendMessageSrvRequest.getAttribute3() == null)) || ((this.attribute3 != null) && (this.attribute3.equals(localSendMessageSrvRequest.getAttribute3())) && (((this.attribute4 == null) && (localSendMessageSrvRequest.getAttribute4() == null)) || ((this.attribute4 != null) && (this.attribute4.equals(localSendMessageSrvRequest.getAttribute4())) && (((this.attribute5 == null) && (localSendMessageSrvRequest.getAttribute5() == null)) || ((this.attribute5 != null) && (this.attribute5.equals(localSendMessageSrvRequest.getAttribute5())) && (((this.attribute6 == null) && (localSendMessageSrvRequest.getAttribute6() == null)) || ((this.attribute6 != null) && (this.attribute6.equals(localSendMessageSrvRequest.getAttribute6())) && (((this.attribute7 == null) && (localSendMessageSrvRequest.getAttribute7() == null)) || ((this.attribute7 != null) && (this.attribute7.equals(localSendMessageSrvRequest.getAttribute7())) && (((this.attribute8 == null) && (localSendMessageSrvRequest.getAttribute8() == null)) || ((this.attribute8 != null) && (this.attribute8.equals(localSendMessageSrvRequest.getAttribute8())) && (((this.attribute9 == null) && (localSendMessageSrvRequest.getAttribute9() == null)) || ((this.attribute9 != null) && (this.attribute9.equals(localSendMessageSrvRequest.getAttribute9())) && (((this.boeNum == null) && (localSendMessageSrvRequest.getBoeNum() == null)) || ((this.boeNum != null) && (this.boeNum.equals(localSendMessageSrvRequest.getBoeNum())) && (((this.employeeNumber == null) && (localSendMessageSrvRequest.getEmployeeNumber() == null)) || ((this.employeeNumber != null) && (this.employeeNumber.equals(localSendMessageSrvRequest.getEmployeeNumber())) && (((this.rejectReason == null) && (localSendMessageSrvRequest.getRejectReason() == null)) || ((this.rejectReason != null) && (this.rejectReason.equals(localSendMessageSrvRequest.getRejectReason())) && (((this.rejectType == null) && (localSendMessageSrvRequest.getRejectType() == null)) || ((this.rejectType != null) && (this.rejectType.equals(localSendMessageSrvRequest.getRejectType())))))))))))))))))))))))))))));
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
    if (getRejectReason() != null) {
      i += getRejectReason().hashCode();
    }
    if (getRejectType() != null) {
      i += getRejectType().hashCode();
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
    typeDesc.setXmlType(new QName("impl:SendMessageSrvRequest", "SendMessageSrvRequest"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute1");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "attribute1"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute10");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "attribute10"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute2");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "attribute2"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute3");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "attribute3"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute4");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "attribute4"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute5");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "attribute5"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute6");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "attribute6"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute7");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "attribute7"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute8");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "attribute8"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute9");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "attribute9"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("boeNum");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "boeNum"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("employeeNumber");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "employeeNumber"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("rejectReason");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "rejectReason"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("rejectType");
    localElementDesc.setXmlName(new QName("impl:SendMessageSrvRequest", "rejectType"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.messageSrv.services.SendMessageSrvRequest
 * JD-Core Version:    0.7.0.1
 */