package com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001;

import java.io.Serializable;
import java.util.Date;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class FbpDeptsVll
  implements Serializable
{
  private String defaultCheckUnit;
  private String deptCode;
  private Long deptId;
  private String deptName;
  private String enabledFlag;
  private String language;
  private Date lastUpdateDate;
  private Long parentId;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(FbpDeptsVll.class, true);
  
  public FbpDeptsVll() {}
  
  public FbpDeptsVll(String paramString1, String paramString2, Long paramLong1, String paramString3, String paramString4, String paramString5, Date paramDate, Long paramLong2)
  {
    this.defaultCheckUnit = paramString1;
    this.deptCode = paramString2;
    this.deptId = paramLong1;
    this.deptName = paramString3;
    this.enabledFlag = paramString4;
    this.language = paramString5;
    this.lastUpdateDate = paramDate;
    this.parentId = paramLong2;
  }
  
  public String getDefaultCheckUnit()
  {
    return this.defaultCheckUnit;
  }
  
  public void setDefaultCheckUnit(String paramString)
  {
    this.defaultCheckUnit = paramString;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public Long getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(Long paramLong)
  {
    this.deptId = paramLong;
  }
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
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
  
  public Long getParentId()
  {
    return this.parentId;
  }
  
  public void setParentId(Long paramLong)
  {
    this.parentId = paramLong;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpDeptsVll)) {
      return false;
    }
    FbpDeptsVll localFbpDeptsVll = (FbpDeptsVll)paramObject;
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
    boolean bool = ((this.defaultCheckUnit == null) && (localFbpDeptsVll.getDefaultCheckUnit() == null)) || ((this.defaultCheckUnit != null) && (this.defaultCheckUnit.equals(localFbpDeptsVll.getDefaultCheckUnit())) && (((this.deptCode == null) && (localFbpDeptsVll.getDeptCode() == null)) || ((this.deptCode != null) && (this.deptCode.equals(localFbpDeptsVll.getDeptCode())) && (((this.deptId == null) && (localFbpDeptsVll.getDeptId() == null)) || ((this.deptId != null) && (this.deptId.equals(localFbpDeptsVll.getDeptId())) && (((this.deptName == null) && (localFbpDeptsVll.getDeptName() == null)) || ((this.deptName != null) && (this.deptName.equals(localFbpDeptsVll.getDeptName())) && (((this.enabledFlag == null) && (localFbpDeptsVll.getEnabledFlag() == null)) || ((this.enabledFlag != null) && (this.enabledFlag.equals(localFbpDeptsVll.getEnabledFlag())) && (((this.language == null) && (localFbpDeptsVll.getLanguage() == null)) || ((this.language != null) && (this.language.equals(localFbpDeptsVll.getLanguage())) && (((this.lastUpdateDate == null) && (localFbpDeptsVll.getLastUpdateDate() == null)) || ((this.lastUpdateDate != null) && (this.lastUpdateDate.equals(localFbpDeptsVll.getLastUpdateDate())) && (((this.parentId == null) && (localFbpDeptsVll.getParentId() == null)) || ((this.parentId != null) && (this.parentId.equals(localFbpDeptsVll.getParentId())))))))))))))))));
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
    if (getDefaultCheckUnit() != null) {
      i += getDefaultCheckUnit().hashCode();
    }
    if (getDeptCode() != null) {
      i += getDeptCode().hashCode();
    }
    if (getDeptId() != null) {
      i += getDeptId().hashCode();
    }
    if (getDeptName() != null) {
      i += getDeptName().hashCode();
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
    if (getParentId() != null) {
      i += getParentId().hashCode();
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
    typeDesc.setXmlType(new QName("urn:BeanService", "FbpDeptsVll"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("defaultCheckUnit");
    localElementDesc.setXmlName(new QName("", "defaultCheckUnit"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("deptCode");
    localElementDesc.setXmlName(new QName("", "deptCode"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("deptId");
    localElementDesc.setXmlName(new QName("", "deptId"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("deptName");
    localElementDesc.setXmlName(new QName("", "deptName"));
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
    localElementDesc.setFieldName("parentId");
    localElementDesc.setXmlName(new QName("", "parentId"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.Fbdept_SC_CMS_00001.FbpDeptsVll
 * JD-Core Version:    0.7.0.1
 */