package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class EmployeeDeptCollection
  implements Serializable
{
  private EmployeeDept[] employeeDeptList;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(EmployeeDeptCollection.class, true);
  
  public EmployeeDeptCollection() {}
  
  public EmployeeDeptCollection(EmployeeDept[] paramArrayOfEmployeeDept)
  {
    this.employeeDeptList = paramArrayOfEmployeeDept;
  }
  
  public EmployeeDept[] getEmployeeDeptList()
  {
    return this.employeeDeptList;
  }
  
  public void setEmployeeDeptList(EmployeeDept[] paramArrayOfEmployeeDept)
  {
    this.employeeDeptList = paramArrayOfEmployeeDept;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EmployeeDeptCollection)) {
      return false;
    }
    EmployeeDeptCollection localEmployeeDeptCollection = (EmployeeDeptCollection)paramObject;
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
    boolean bool = ((this.employeeDeptList == null) && (localEmployeeDeptCollection.getEmployeeDeptList() == null)) || ((this.employeeDeptList != null) && (Arrays.equals(this.employeeDeptList, localEmployeeDeptCollection.getEmployeeDeptList())));
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
    if (getEmployeeDeptList() != null) {
      for (int j = 0; j < Array.getLength(getEmployeeDeptList()); j++)
      {
        Object localObject = Array.get(getEmployeeDeptList(), j);
        if ((localObject != null) && (!localObject.getClass().isArray())) {
          i += localObject.hashCode();
        }
      }
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
    typeDesc.setXmlType(new QName("impl:EmployeeDeptCollection", "EmployeeDeptCollection"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("employeeDeptList");
    localElementDesc.setXmlName(new QName("impl:EmployeeDeptCollection", "employeeDeptList"));
    localElementDesc.setXmlType(new QName("impl:EmployeeDept", "EmployeeDept"));
    localElementDesc.setNillable(true);
    localElementDesc.setItemQName(new QName("http://www.evs.com/services/syncEmployeeDeptSrv", "item"));
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.EmployeeDeptCollection
 * JD-Core Version:    0.7.0.1
 */