package com.zte.eas.login.EASLogin;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class WSContext
  implements Serializable
{
  private int dbType;
  private String dcName;
  private String password;
  private String sessionId;
  private String slnName;
  private String userName;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(WSContext.class, true);
  
  public WSContext() {}
  
  public WSContext(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.dbType = paramInt;
    this.dcName = paramString1;
    this.password = paramString2;
    this.sessionId = paramString3;
    this.slnName = paramString4;
    this.userName = paramString5;
  }
  
  public int getDbType()
  {
    return this.dbType;
  }
  
  public void setDbType(int paramInt)
  {
    this.dbType = paramInt;
  }
  
  public String getDcName()
  {
    return this.dcName;
  }
  
  public void setDcName(String paramString)
  {
    this.dcName = paramString;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public String getSlnName()
  {
    return this.slnName;
  }
  
  public void setSlnName(String paramString)
  {
    this.slnName = paramString;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof WSContext)) {
      return false;
    }
    WSContext localWSContext = (WSContext)paramObject;
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
    boolean bool = (this.dbType == localWSContext.getDbType()) && (((this.dcName == null) && (localWSContext.getDcName() == null)) || ((this.dcName != null) && (this.dcName.equals(localWSContext.getDcName())) && (((this.password == null) && (localWSContext.getPassword() == null)) || ((this.password != null) && (this.password.equals(localWSContext.getPassword())) && (((this.sessionId == null) && (localWSContext.getSessionId() == null)) || ((this.sessionId != null) && (this.sessionId.equals(localWSContext.getSessionId())) && (((this.slnName == null) && (localWSContext.getSlnName() == null)) || ((this.slnName != null) && (this.slnName.equals(localWSContext.getSlnName())) && (((this.userName == null) && (localWSContext.getUserName() == null)) || ((this.userName != null) && (this.userName.equals(localWSContext.getUserName()))))))))))));
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
    i += getDbType();
    if (getDcName() != null) {
      i += getDcName().hashCode();
    }
    if (getPassword() != null) {
      i += getPassword().hashCode();
    }
    if (getSessionId() != null) {
      i += getSessionId().hashCode();
    }
    if (getSlnName() != null) {
      i += getSlnName().hashCode();
    }
    if (getUserName() != null) {
      i += getUserName().hashCode();
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
    typeDesc.setXmlType(new QName("urn:client", "WSContext"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("dbType");
    localElementDesc.setXmlName(new QName("", "dbType"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("dcName");
    localElementDesc.setXmlName(new QName("", "dcName"));
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
    localElementDesc.setFieldName("sessionId");
    localElementDesc.setXmlName(new QName("", "sessionId"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("slnName");
    localElementDesc.setXmlName(new QName("", "slnName"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("userName");
    localElementDesc.setXmlName(new QName("", "userName"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.login.EASLogin.WSContext
 * JD-Core Version:    0.7.0.1
 */