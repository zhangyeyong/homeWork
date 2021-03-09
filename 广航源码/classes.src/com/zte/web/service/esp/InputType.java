package com.zte.web.service.esp;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class InputType
  implements Serializable
{
  private String userCode;
  private String sysName;
  private String funcName;
  private String limit;
  private RowSingle extendElement;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(InputType.class, true);
  
  public InputType() {}
  
  public InputType(String paramString1, String paramString2, String paramString3, String paramString4, RowSingle paramRowSingle)
  {
    this.userCode = paramString1;
    this.sysName = paramString2;
    this.funcName = paramString3;
    this.limit = paramString4;
    this.extendElement = paramRowSingle;
  }
  
  public String getUserCode()
  {
    return this.userCode;
  }
  
  public void setUserCode(String paramString)
  {
    this.userCode = paramString;
  }
  
  public String getSysName()
  {
    return this.sysName;
  }
  
  public void setSysName(String paramString)
  {
    this.sysName = paramString;
  }
  
  public String getFuncName()
  {
    return this.funcName;
  }
  
  public void setFuncName(String paramString)
  {
    this.funcName = paramString;
  }
  
  public String getLimit()
  {
    return this.limit;
  }
  
  public void setLimit(String paramString)
  {
    this.limit = paramString;
  }
  
  public RowSingle getExtendElement()
  {
    return this.extendElement;
  }
  
  public void setExtendElement(RowSingle paramRowSingle)
  {
    this.extendElement = paramRowSingle;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof InputType)) {
      return false;
    }
    InputType localInputType = (InputType)paramObject;
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
    boolean bool = ((this.userCode == null) && (localInputType.getUserCode() == null)) || ((this.userCode != null) && (this.userCode.equals(localInputType.getUserCode())) && (((this.sysName == null) && (localInputType.getSysName() == null)) || ((this.sysName != null) && (this.sysName.equals(localInputType.getSysName())) && (((this.funcName == null) && (localInputType.getFuncName() == null)) || ((this.funcName != null) && (this.funcName.equals(localInputType.getFuncName())) && (((this.limit == null) && (localInputType.getLimit() == null)) || ((this.limit != null) && (this.limit.equals(localInputType.getLimit())) && (((this.extendElement == null) && (localInputType.getExtendElement() == null)) || ((this.extendElement != null) && (this.extendElement.equals(localInputType.getExtendElement())))))))))));
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
    if (getUserCode() != null) {
      i += getUserCode().hashCode();
    }
    if (getSysName() != null) {
      i += getSysName().hashCode();
    }
    if (getFuncName() != null) {
      i += getFuncName().hashCode();
    }
    if (getLimit() != null) {
      i += getLimit().hashCode();
    }
    if (getExtendElement() != null) {
      i += getExtendElement().hashCode();
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
    typeDesc.setXmlType(new QName("http://eai.haier.com/QueryPortalCommonService/", "InputType"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("userCode");
    localElementDesc.setXmlName(new QName("http://eai.haier.com/QueryPortalCommonService/", "userCode"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("sysName");
    localElementDesc.setXmlName(new QName("http://eai.haier.com/QueryPortalCommonService/", "sysName"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("funcName");
    localElementDesc.setXmlName(new QName("http://eai.haier.com/QueryPortalCommonService/", "funcName"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("limit");
    localElementDesc.setXmlName(new QName("http://eai.haier.com/QueryPortalCommonService/", "limit"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("extendElement");
    localElementDesc.setXmlName(new QName("http://eai.haier.com/QueryPortalCommonService/", "ExtendElement"));
    localElementDesc.setXmlType(new QName("http://eai.haier.com/QueryPortalCommonService/", "RowSingle"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.esp.InputType
 * JD-Core Version:    0.7.0.1
 */