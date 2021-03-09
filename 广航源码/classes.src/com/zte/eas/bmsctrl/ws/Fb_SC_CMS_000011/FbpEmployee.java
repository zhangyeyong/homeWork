package com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011;

import java.io.Serializable;
import java.util.Date;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class FbpEmployee
  implements Serializable
{
  private Long deptId;
  private String email;
  private String employeeName;
  private String employeeNum;
  private String enabledFlag;
  private String language;
  private Date lastUpdateDate;
  private String oaAdress;
  private String password;
  private String phone;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(FbpEmployee.class, true);
  
  public FbpEmployee() {}
  
  public FbpEmployee(Long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Date paramDate, String paramString6, String paramString7, String paramString8)
  {
    this.deptId = paramLong;
    this.email = paramString1;
    this.employeeName = paramString2;
    this.employeeNum = paramString3;
    this.enabledFlag = paramString4;
    this.language = paramString5;
    this.lastUpdateDate = paramDate;
    this.oaAdress = paramString6;
    this.password = paramString7;
    this.phone = paramString8;
  }
  
  public Long getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(Long paramLong)
  {
    this.deptId = paramLong;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getEmployeeNum()
  {
    return this.employeeNum;
  }
  
  public void setEmployeeNum(String paramString)
  {
    this.employeeNum = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public String getOaAdress()
  {
    return this.oaAdress;
  }
  
  public void setOaAdress(String paramString)
  {
    this.oaAdress = paramString;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpEmployee)) {
      return false;
    }
    FbpEmployee localFbpEmployee = (FbpEmployee)paramObject;
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
    boolean bool = ((this.deptId == null) && (localFbpEmployee.getDeptId() == null)) || ((this.deptId != null) && (this.deptId.equals(localFbpEmployee.getDeptId())) && (((this.email == null) && (localFbpEmployee.getEmail() == null)) || ((this.email != null) && (this.email.equals(localFbpEmployee.getEmail())) && (((this.employeeName == null) && (localFbpEmployee.getEmployeeName() == null)) || ((this.employeeName != null) && (this.employeeName.equals(localFbpEmployee.getEmployeeName())) && (((this.employeeNum == null) && (localFbpEmployee.getEmployeeNum() == null)) || ((this.employeeNum != null) && (this.employeeNum.equals(localFbpEmployee.getEmployeeNum())) && (((this.enabledFlag == null) && (localFbpEmployee.getEnabledFlag() == null)) || ((this.enabledFlag != null) && (this.enabledFlag.equals(localFbpEmployee.getEnabledFlag())) && (((this.language == null) && (localFbpEmployee.getLanguage() == null)) || ((this.language != null) && (this.language.equals(localFbpEmployee.getLanguage())) && (((this.lastUpdateDate == null) && (localFbpEmployee.getLastUpdateDate() == null)) || ((this.lastUpdateDate != null) && (this.lastUpdateDate.equals(localFbpEmployee.getLastUpdateDate())) && (((this.oaAdress == null) && (localFbpEmployee.getOaAdress() == null)) || ((this.oaAdress != null) && (this.oaAdress.equals(localFbpEmployee.getOaAdress())) && (((this.password == null) && (localFbpEmployee.getPassword() == null)) || ((this.password != null) && (this.password.equals(localFbpEmployee.getPassword())) && (((this.phone == null) && (localFbpEmployee.getPhone() == null)) || ((this.phone != null) && (this.phone.equals(localFbpEmployee.getPhone())))))))))))))))))))));
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
    if (getDeptId() != null) {
      i += getDeptId().hashCode();
    }
    if (getEmail() != null) {
      i += getEmail().hashCode();
    }
    if (getEmployeeName() != null) {
      i += getEmployeeName().hashCode();
    }
    if (getEmployeeNum() != null) {
      i += getEmployeeNum().hashCode();
    }
    if (getEnabledFlag() != null) {
      i += getEnabledFlag().hashCode();
    }
    if (getLanguage() != null) {
      i += getLanguage().hashCode();
    }
    if (getLastUpdateDate() != null) {
      i += getLastUpdateDate().hashCode();
    }
    if (getOaAdress() != null) {
      i += getOaAdress().hashCode();
    }
    if (getPassword() != null) {
      i += getPassword().hashCode();
    }
    if (getPhone() != null) {
      i += getPhone().hashCode();
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
    typeDesc.setXmlType(new QName("urn:BeanService", "FbpEmployee"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("deptId");
    localElementDesc.setXmlName(new QName("", "deptId"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("email");
    localElementDesc.setXmlName(new QName("", "email"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("employeeName");
    localElementDesc.setXmlName(new QName("", "employeeName"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("employeeNum");
    localElementDesc.setXmlName(new QName("", "employeeNum"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("enabledFlag");
    localElementDesc.setXmlName(new QName("", "enabledFlag"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("language");
    localElementDesc.setXmlName(new QName("", "language"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("lastUpdateDate");
    localElementDesc.setXmlName(new QName("", "lastUpdateDate"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("oaAdress");
    localElementDesc.setXmlName(new QName("", "oaAdress"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("password");
    localElementDesc.setXmlName(new QName("", "password"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("phone");
    localElementDesc.setXmlName(new QName("", "phone"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fb_SC_CMS_000011.FbpEmployee
 * JD-Core Version:    0.7.0.1
 */