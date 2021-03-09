package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class EmployeeDept
  implements Serializable
{
  private String deptCode;
  private String employeeNumber;
  private Calendar syncDate;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(EmployeeDept.class, true);
  
  public EmployeeDept() {}
  
  public EmployeeDept(String paramString1, String paramString2, Calendar paramCalendar)
  {
    this.deptCode = paramString1;
    this.employeeNumber = paramString2;
    this.syncDate = paramCalendar;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public Calendar getSyncDate()
  {
    return this.syncDate;
  }
  
  public void setSyncDate(Calendar paramCalendar)
  {
    this.syncDate = paramCalendar;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EmployeeDept)) {
      return false;
    }
    EmployeeDept localEmployeeDept = (EmployeeDept)paramObject;
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
    boolean bool = ((this.deptCode == null) && (localEmployeeDept.getDeptCode() == null)) || ((this.deptCode != null) && (this.deptCode.equals(localEmployeeDept.getDeptCode())) && (((this.employeeNumber == null) && (localEmployeeDept.getEmployeeNumber() == null)) || ((this.employeeNumber != null) && (this.employeeNumber.equals(localEmployeeDept.getEmployeeNumber())) && (((this.syncDate == null) && (localEmployeeDept.getSyncDate() == null)) || ((this.syncDate != null) && (this.syncDate.equals(localEmployeeDept.getSyncDate())))))));
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
    if (getDeptCode() != null) {
      i += getDeptCode().hashCode();
    }
    if (getEmployeeNumber() != null) {
      i += getEmployeeNumber().hashCode();
    }
    if (getSyncDate() != null) {
      i += getSyncDate().hashCode();
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
    typeDesc.setXmlType(new QName("impl:EmployeeDept", "EmployeeDept"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("deptCode");
    localElementDesc.setXmlName(new QName("impl:EmployeeDept", "deptCode"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("employeeNumber");
    localElementDesc.setXmlName(new QName("impl:EmployeeDept", "employeeNumber"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("syncDate");
    localElementDesc.setXmlName(new QName("impl:EmployeeDept", "syncDate"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.EmployeeDept
 * JD-Core Version:    0.7.0.1
 */