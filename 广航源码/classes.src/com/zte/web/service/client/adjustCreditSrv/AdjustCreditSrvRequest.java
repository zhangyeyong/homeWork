package com.zte.web.service.client.adjustCreditSrv;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class AdjustCreditSrvRequest
  implements Serializable
{
  private String assessCode;
  private String attribute1;
  private String attribute2;
  private String attribute3;
  private String attribute4;
  private String attribute5;
  private String employeeNumber;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(AdjustCreditSrvRequest.class, true);
  
  public AdjustCreditSrvRequest() {}
  
  public AdjustCreditSrvRequest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.assessCode = paramString1;
    this.attribute1 = paramString2;
    this.attribute2 = paramString3;
    this.attribute3 = paramString4;
    this.attribute4 = paramString5;
    this.attribute5 = paramString6;
    this.employeeNumber = paramString7;
  }
  
  public String getAssessCode()
  {
    return this.assessCode;
  }
  
  public void setAssessCode(String paramString)
  {
    this.assessCode = paramString;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
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
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdjustCreditSrvRequest)) {
      return false;
    }
    AdjustCreditSrvRequest localAdjustCreditSrvRequest = (AdjustCreditSrvRequest)paramObject;
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
    boolean bool = ((this.assessCode == null) && (localAdjustCreditSrvRequest.getAssessCode() == null)) || ((this.assessCode != null) && (this.assessCode.equals(localAdjustCreditSrvRequest.getAssessCode())) && (((this.attribute1 == null) && (localAdjustCreditSrvRequest.getAttribute1() == null)) || ((this.attribute1 != null) && (this.attribute1.equals(localAdjustCreditSrvRequest.getAttribute1())) && (((this.attribute2 == null) && (localAdjustCreditSrvRequest.getAttribute2() == null)) || ((this.attribute2 != null) && (this.attribute2.equals(localAdjustCreditSrvRequest.getAttribute2())) && (((this.attribute3 == null) && (localAdjustCreditSrvRequest.getAttribute3() == null)) || ((this.attribute3 != null) && (this.attribute3.equals(localAdjustCreditSrvRequest.getAttribute3())) && (((this.attribute4 == null) && (localAdjustCreditSrvRequest.getAttribute4() == null)) || ((this.attribute4 != null) && (this.attribute4.equals(localAdjustCreditSrvRequest.getAttribute4())) && (((this.attribute5 == null) && (localAdjustCreditSrvRequest.getAttribute5() == null)) || ((this.attribute5 != null) && (this.attribute5.equals(localAdjustCreditSrvRequest.getAttribute5())) && (((this.employeeNumber == null) && (localAdjustCreditSrvRequest.getEmployeeNumber() == null)) || ((this.employeeNumber != null) && (this.employeeNumber.equals(localAdjustCreditSrvRequest.getEmployeeNumber())))))))))))))));
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
    if (getAssessCode() != null) {
      i += getAssessCode().hashCode();
    }
    if (getAttribute1() != null) {
      i += getAttribute1().hashCode();
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
    if (getEmployeeNumber() != null) {
      i += getEmployeeNumber().hashCode();
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
    typeDesc.setXmlType(new QName("impl:AdjustCreditSrvRequest", "AdjustCreditSrvRequest"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("assessCode");
    localElementDesc.setXmlName(new QName("", "assessCode"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute1");
    localElementDesc.setXmlName(new QName("", "attribute1"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute2");
    localElementDesc.setXmlName(new QName("", "attribute2"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute3");
    localElementDesc.setXmlName(new QName("", "attribute3"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute4");
    localElementDesc.setXmlName(new QName("", "attribute4"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute5");
    localElementDesc.setXmlName(new QName("", "attribute5"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("employeeNumber");
    localElementDesc.setXmlName(new QName("", "employeeNumber"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.adjustCreditSrv.AdjustCreditSrvRequest
 * JD-Core Version:    0.7.0.1
 */