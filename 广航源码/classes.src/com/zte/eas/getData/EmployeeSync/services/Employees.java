package com.zte.eas.getData.EmployeeSync.services;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class Employees
  implements Serializable
{
  private String attribute3;
  private String attribute5;
  private String attribute8;
  private String dataType;
  private String deptCode;
  private String emailAddress;
  private String employeeName;
  private String employeeNumber;
  private String enabledFlag;
  private String idCard;
  private String mobilePhone;
  private String oaAddress;
  private String sourceReference;
  private String sourceType;
  private Calendar sysnceDate;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(Employees.class, true);
  
  public Employees() {}
  
  public Employees(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, Calendar paramCalendar)
  {
    this.attribute3 = paramString1;
    this.attribute5 = paramString2;
    this.attribute8 = paramString3;
    this.dataType = paramString4;
    this.deptCode = paramString5;
    this.emailAddress = paramString6;
    this.employeeName = paramString7;
    this.employeeNumber = paramString8;
    this.enabledFlag = paramString9;
    this.idCard = paramString10;
    this.mobilePhone = paramString11;
    this.oaAddress = paramString12;
    this.sourceReference = paramString13;
    this.sourceType = paramString14;
    this.sysnceDate = paramCalendar;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public void setAttribute3(String paramString)
  {
    this.attribute3 = paramString;
  }
  
  public String getAttribute5()
  {
    return this.attribute5;
  }
  
  public void setAttribute5(String paramString)
  {
    this.attribute5 = paramString;
  }
  
  public String getAttribute8()
  {
    return this.attribute8;
  }
  
  public void setAttribute8(String paramString)
  {
    this.attribute8 = paramString;
  }
  
  public String getDataType()
  {
    return this.dataType;
  }
  
  public void setDataType(String paramString)
  {
    this.dataType = paramString;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public String getEmailAddress()
  {
    return this.emailAddress;
  }
  
  public void setEmailAddress(String paramString)
  {
    this.emailAddress = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getIdCard()
  {
    return this.idCard;
  }
  
  public void setIdCard(String paramString)
  {
    this.idCard = paramString;
  }
  
  public String getMobilePhone()
  {
    return this.mobilePhone;
  }
  
  public void setMobilePhone(String paramString)
  {
    this.mobilePhone = paramString;
  }
  
  public String getOaAddress()
  {
    return this.oaAddress;
  }
  
  public void setOaAddress(String paramString)
  {
    this.oaAddress = paramString;
  }
  
  public String getSourceReference()
  {
    return this.sourceReference;
  }
  
  public void setSourceReference(String paramString)
  {
    this.sourceReference = paramString;
  }
  
  public String getSourceType()
  {
    return this.sourceType;
  }
  
  public void setSourceType(String paramString)
  {
    this.sourceType = paramString;
  }
  
  public Calendar getSysnceDate()
  {
    return this.sysnceDate;
  }
  
  public void setSysnceDate(Calendar paramCalendar)
  {
    this.sysnceDate = paramCalendar;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Employees)) {
      return false;
    }
    Employees localEmployees = (Employees)paramObject;
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
    boolean bool = ((this.attribute3 == null) && (localEmployees.getAttribute3() == null)) || ((this.attribute3 != null) && (this.attribute3.equals(localEmployees.getAttribute3())) && (((this.attribute5 == null) && (localEmployees.getAttribute5() == null)) || ((this.attribute5 != null) && (this.attribute5.equals(localEmployees.getAttribute5())) && (((this.attribute8 == null) && (localEmployees.getAttribute8() == null)) || ((this.attribute8 != null) && (this.attribute8.equals(localEmployees.getAttribute8())) && (((this.dataType == null) && (localEmployees.getDataType() == null)) || ((this.dataType != null) && (this.dataType.equals(localEmployees.getDataType())) && (((this.deptCode == null) && (localEmployees.getDeptCode() == null)) || ((this.deptCode != null) && (this.deptCode.equals(localEmployees.getDeptCode())) && (((this.emailAddress == null) && (localEmployees.getEmailAddress() == null)) || ((this.emailAddress != null) && (this.emailAddress.equals(localEmployees.getEmailAddress())) && (((this.employeeName == null) && (localEmployees.getEmployeeName() == null)) || ((this.employeeName != null) && (this.employeeName.equals(localEmployees.getEmployeeName())) && (((this.employeeNumber == null) && (localEmployees.getEmployeeNumber() == null)) || ((this.employeeNumber != null) && (this.employeeNumber.equals(localEmployees.getEmployeeNumber())) && (((this.enabledFlag == null) && (localEmployees.getEnabledFlag() == null)) || ((this.enabledFlag != null) && (this.enabledFlag.equals(localEmployees.getEnabledFlag())) && (((this.idCard == null) && (localEmployees.getIdCard() == null)) || ((this.idCard != null) && (this.idCard.equals(localEmployees.getIdCard())) && (((this.mobilePhone == null) && (localEmployees.getMobilePhone() == null)) || ((this.mobilePhone != null) && (this.mobilePhone.equals(localEmployees.getMobilePhone())) && (((this.oaAddress == null) && (localEmployees.getOaAddress() == null)) || ((this.oaAddress != null) && (this.oaAddress.equals(localEmployees.getOaAddress())) && (((this.sourceReference == null) && (localEmployees.getSourceReference() == null)) || ((this.sourceReference != null) && (this.sourceReference.equals(localEmployees.getSourceReference())) && (((this.sourceType == null) && (localEmployees.getSourceType() == null)) || ((this.sourceType != null) && (this.sourceType.equals(localEmployees.getSourceType())) && (((this.sysnceDate == null) && (localEmployees.getSysnceDate() == null)) || ((this.sysnceDate != null) && (this.sysnceDate.equals(localEmployees.getSysnceDate())))))))))))))))))))))))))))))));
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
    if (getAttribute3() != null) {
      i += getAttribute3().hashCode();
    }
    if (getAttribute5() != null) {
      i += getAttribute5().hashCode();
    }
    if (getAttribute8() != null) {
      i += getAttribute8().hashCode();
    }
    if (getDataType() != null) {
      i += getDataType().hashCode();
    }
    if (getDeptCode() != null) {
      i += getDeptCode().hashCode();
    }
    if (getEmailAddress() != null) {
      i += getEmailAddress().hashCode();
    }
    if (getEmployeeName() != null) {
      i += getEmployeeName().hashCode();
    }
    if (getEmployeeNumber() != null) {
      i += getEmployeeNumber().hashCode();
    }
    if (getEnabledFlag() != null) {
      i += getEnabledFlag().hashCode();
    }
    if (getIdCard() != null) {
      i += getIdCard().hashCode();
    }
    if (getMobilePhone() != null) {
      i += getMobilePhone().hashCode();
    }
    if (getOaAddress() != null) {
      i += getOaAddress().hashCode();
    }
    if (getSourceReference() != null) {
      i += getSourceReference().hashCode();
    }
    if (getSourceType() != null) {
      i += getSourceType().hashCode();
    }
    if (getSysnceDate() != null) {
      i += getSysnceDate().hashCode();
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
    typeDesc.setXmlType(new QName("impl:Employees", "Employees"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute3");
    localElementDesc.setXmlName(new QName("impl:Employees", "attribute3"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute5");
    localElementDesc.setXmlName(new QName("impl:Employees", "attribute5"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute8");
    localElementDesc.setXmlName(new QName("impl:Employees", "attribute8"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("dataType");
    localElementDesc.setXmlName(new QName("impl:Employees", "dataType"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("deptCode");
    localElementDesc.setXmlName(new QName("impl:Employees", "deptCode"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("emailAddress");
    localElementDesc.setXmlName(new QName("impl:Employees", "emailAddress"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("employeeName");
    localElementDesc.setXmlName(new QName("impl:Employees", "employeeName"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("employeeNumber");
    localElementDesc.setXmlName(new QName("impl:Employees", "employeeNumber"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("enabledFlag");
    localElementDesc.setXmlName(new QName("impl:Employees", "enabledFlag"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("idCard");
    localElementDesc.setXmlName(new QName("impl:Employees", "idCard"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("mobilePhone");
    localElementDesc.setXmlName(new QName("impl:Employees", "mobilePhone"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("oaAddress");
    localElementDesc.setXmlName(new QName("impl:Employees", "oaAddress"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("sourceReference");
    localElementDesc.setXmlName(new QName("impl:Employees", "sourceReference"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("sourceType");
    localElementDesc.setXmlName(new QName("impl:Employees", "sourceType"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("sysnceDate");
    localElementDesc.setXmlName(new QName("impl:Employees", "sysnceDate"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.EmployeeSync.services.Employees
 * JD-Core Version:    0.7.0.1
 */