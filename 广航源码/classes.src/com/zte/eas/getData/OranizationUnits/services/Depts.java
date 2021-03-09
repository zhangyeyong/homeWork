package com.zte.eas.getData.OranizationUnits.services;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class Depts
  implements Serializable
{
  private String attribute2;
  private String attribute3;
  private String attribute4;
  private String attribute5;
  private String attribute6;
  private String attribute7;
  private String attribute8;
  private Long createdBy;
  private Calendar creationDate;
  private String deptCode;
  private String enabledFlag;
  private Calendar lastUpdateDate;
  private Long lastUpdateLogin;
  private Long lastUpdatedBy;
  private Calendar sysnceDate;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(Depts.class, true);
  
  public Depts() {}
  
  public Depts(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Long paramLong1, Calendar paramCalendar1, String paramString8, String paramString9, Calendar paramCalendar2, Long paramLong2, Long paramLong3, Calendar paramCalendar3)
  {
    this.attribute2 = paramString1;
    this.attribute3 = paramString2;
    this.attribute4 = paramString3;
    this.attribute5 = paramString4;
    this.attribute6 = paramString5;
    this.attribute7 = paramString6;
    this.attribute8 = paramString7;
    this.createdBy = paramLong1;
    this.creationDate = paramCalendar1;
    this.deptCode = paramString8;
    this.enabledFlag = paramString9;
    this.lastUpdateDate = paramCalendar2;
    this.lastUpdateLogin = paramLong2;
    this.lastUpdatedBy = paramLong3;
    this.sysnceDate = paramCalendar3;
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
  
  public Long getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(Long paramLong)
  {
    this.createdBy = paramLong;
  }
  
  public Calendar getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Calendar paramCalendar)
  {
    this.creationDate = paramCalendar;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Calendar getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Calendar paramCalendar)
  {
    this.lastUpdateDate = paramCalendar;
  }
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
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
    if (!(paramObject instanceof Depts)) {
      return false;
    }
    Depts localDepts = (Depts)paramObject;
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
    boolean bool = ((this.attribute2 == null) && (localDepts.getAttribute2() == null)) || ((this.attribute2 != null) && (this.attribute2.equals(localDepts.getAttribute2())) && (((this.attribute3 == null) && (localDepts.getAttribute3() == null)) || ((this.attribute3 != null) && (this.attribute3.equals(localDepts.getAttribute3())) && (((this.attribute4 == null) && (localDepts.getAttribute4() == null)) || ((this.attribute4 != null) && (this.attribute4.equals(localDepts.getAttribute4())) && (((this.attribute5 == null) && (localDepts.getAttribute5() == null)) || ((this.attribute5 != null) && (this.attribute5.equals(localDepts.getAttribute5())) && (((this.attribute6 == null) && (localDepts.getAttribute6() == null)) || ((this.attribute6 != null) && (this.attribute6.equals(localDepts.getAttribute6())) && (((this.attribute7 == null) && (localDepts.getAttribute7() == null)) || ((this.attribute7 != null) && (this.attribute7.equals(localDepts.getAttribute7())) && (((this.attribute8 == null) && (localDepts.getAttribute8() == null)) || ((this.attribute8 != null) && (this.attribute8.equals(localDepts.getAttribute8())) && (((this.createdBy == null) && (localDepts.getCreatedBy() == null)) || ((this.createdBy != null) && (this.createdBy.equals(localDepts.getCreatedBy())) && (((this.creationDate == null) && (localDepts.getCreationDate() == null)) || ((this.creationDate != null) && (this.creationDate.equals(localDepts.getCreationDate())) && (((this.deptCode == null) && (localDepts.getDeptCode() == null)) || ((this.deptCode != null) && (this.deptCode.equals(localDepts.getDeptCode())) && (((this.enabledFlag == null) && (localDepts.getEnabledFlag() == null)) || ((this.enabledFlag != null) && (this.enabledFlag.equals(localDepts.getEnabledFlag())) && (((this.lastUpdateDate == null) && (localDepts.getLastUpdateDate() == null)) || ((this.lastUpdateDate != null) && (this.lastUpdateDate.equals(localDepts.getLastUpdateDate())) && (((this.lastUpdateLogin == null) && (localDepts.getLastUpdateLogin() == null)) || ((this.lastUpdateLogin != null) && (this.lastUpdateLogin.equals(localDepts.getLastUpdateLogin())) && (((this.lastUpdatedBy == null) && (localDepts.getLastUpdatedBy() == null)) || ((this.lastUpdatedBy != null) && (this.lastUpdatedBy.equals(localDepts.getLastUpdatedBy())) && (((this.sysnceDate == null) && (localDepts.getSysnceDate() == null)) || ((this.sysnceDate != null) && (this.sysnceDate.equals(localDepts.getSysnceDate())))))))))))))))))))))))))))))));
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
    if (getCreatedBy() != null) {
      i += getCreatedBy().hashCode();
    }
    if (getCreationDate() != null) {
      i += getCreationDate().hashCode();
    }
    if (getDeptCode() != null) {
      i += getDeptCode().hashCode();
    }
    if (getEnabledFlag() != null) {
      i += getEnabledFlag().hashCode();
    }
    if (getLastUpdateDate() != null) {
      i += getLastUpdateDate().hashCode();
    }
    if (getLastUpdateLogin() != null) {
      i += getLastUpdateLogin().hashCode();
    }
    if (getLastUpdatedBy() != null) {
      i += getLastUpdatedBy().hashCode();
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
    typeDesc.setXmlType(new QName("impl:Depts", "Depts"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute2");
    localElementDesc.setXmlName(new QName("impl:Depts", "attribute2"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute3");
    localElementDesc.setXmlName(new QName("impl:Depts", "attribute3"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute4");
    localElementDesc.setXmlName(new QName("impl:Depts", "attribute4"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute5");
    localElementDesc.setXmlName(new QName("impl:Depts", "attribute5"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute6");
    localElementDesc.setXmlName(new QName("impl:Depts", "attribute6"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute7");
    localElementDesc.setXmlName(new QName("impl:Depts", "attribute7"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("attribute8");
    localElementDesc.setXmlName(new QName("impl:Depts", "attribute8"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("createdBy");
    localElementDesc.setXmlName(new QName("impl:Depts", "createdBy"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("creationDate");
    localElementDesc.setXmlName(new QName("impl:Depts", "creationDate"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("deptCode");
    localElementDesc.setXmlName(new QName("impl:Depts", "deptCode"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("enabledFlag");
    localElementDesc.setXmlName(new QName("impl:Depts", "enabledFlag"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("lastUpdateDate");
    localElementDesc.setXmlName(new QName("impl:Depts", "lastUpdateDate"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("lastUpdateLogin");
    localElementDesc.setXmlName(new QName("impl:Depts", "lastUpdateLogin"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("lastUpdatedBy");
    localElementDesc.setXmlName(new QName("impl:Depts", "lastUpdatedBy"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("sysnceDate");
    localElementDesc.setXmlName(new QName("impl:Depts", "sysnceDate"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.services.Depts
 * JD-Core Version:    0.7.0.1
 */