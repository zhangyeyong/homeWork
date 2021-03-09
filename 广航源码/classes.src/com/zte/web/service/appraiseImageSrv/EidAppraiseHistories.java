package com.zte.web.service.appraiseImageSrv;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class EidAppraiseHistories
  implements Serializable
{
  private String actionCode;
  private Calendar appraiseDate;
  private String appraiseDesc;
  private Long appraiseEmployeeId;
  private Long appraiseHistoryId;
  private String appraiseNode;
  private String appraiseNodeName;
  private String appraiseType;
  private String appraiseTypeName;
  private Long createdBy;
  private Calendar creationDate;
  private String enabledFlag;
  private Long imageInfoId;
  private String imageStatus;
  private String imageStatusName;
  private Calendar lastUpdateDate;
  private Long lastUpdateLogin;
  private Long lastUpdatedBy;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(EidAppraiseHistories.class, true);
  
  public EidAppraiseHistories() {}
  
  public EidAppraiseHistories(String paramString1, Calendar paramCalendar1, String paramString2, Long paramLong1, Long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, Long paramLong3, Calendar paramCalendar2, String paramString7, Long paramLong4, String paramString8, String paramString9, Calendar paramCalendar3, Long paramLong5, Long paramLong6)
  {
    this.actionCode = paramString1;
    this.appraiseDate = paramCalendar1;
    this.appraiseDesc = paramString2;
    this.appraiseEmployeeId = paramLong1;
    this.appraiseHistoryId = paramLong2;
    this.appraiseNode = paramString3;
    this.appraiseNodeName = paramString4;
    this.appraiseType = paramString5;
    this.appraiseTypeName = paramString6;
    this.createdBy = paramLong3;
    this.creationDate = paramCalendar2;
    this.enabledFlag = paramString7;
    this.imageInfoId = paramLong4;
    this.imageStatus = paramString8;
    this.imageStatusName = paramString9;
    this.lastUpdateDate = paramCalendar3;
    this.lastUpdateLogin = paramLong5;
    this.lastUpdatedBy = paramLong6;
  }
  
  public String getActionCode()
  {
    return this.actionCode;
  }
  
  public void setActionCode(String paramString)
  {
    this.actionCode = paramString;
  }
  
  public Calendar getAppraiseDate()
  {
    return this.appraiseDate;
  }
  
  public void setAppraiseDate(Calendar paramCalendar)
  {
    this.appraiseDate = paramCalendar;
  }
  
  public String getAppraiseDesc()
  {
    return this.appraiseDesc;
  }
  
  public void setAppraiseDesc(String paramString)
  {
    this.appraiseDesc = paramString;
  }
  
  public Long getAppraiseEmployeeId()
  {
    return this.appraiseEmployeeId;
  }
  
  public void setAppraiseEmployeeId(Long paramLong)
  {
    this.appraiseEmployeeId = paramLong;
  }
  
  public Long getAppraiseHistoryId()
  {
    return this.appraiseHistoryId;
  }
  
  public void setAppraiseHistoryId(Long paramLong)
  {
    this.appraiseHistoryId = paramLong;
  }
  
  public String getAppraiseNode()
  {
    return this.appraiseNode;
  }
  
  public void setAppraiseNode(String paramString)
  {
    this.appraiseNode = paramString;
  }
  
  public String getAppraiseNodeName()
  {
    return this.appraiseNodeName;
  }
  
  public void setAppraiseNodeName(String paramString)
  {
    this.appraiseNodeName = paramString;
  }
  
  public String getAppraiseType()
  {
    return this.appraiseType;
  }
  
  public void setAppraiseType(String paramString)
  {
    this.appraiseType = paramString;
  }
  
  public String getAppraiseTypeName()
  {
    return this.appraiseTypeName;
  }
  
  public void setAppraiseTypeName(String paramString)
  {
    this.appraiseTypeName = paramString;
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
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Long getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(Long paramLong)
  {
    this.imageInfoId = paramLong;
  }
  
  public String getImageStatus()
  {
    return this.imageStatus;
  }
  
  public void setImageStatus(String paramString)
  {
    this.imageStatus = paramString;
  }
  
  public String getImageStatusName()
  {
    return this.imageStatusName;
  }
  
  public void setImageStatusName(String paramString)
  {
    this.imageStatusName = paramString;
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
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EidAppraiseHistories)) {
      return false;
    }
    EidAppraiseHistories localEidAppraiseHistories = (EidAppraiseHistories)paramObject;
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
    boolean bool = ((this.actionCode == null) && (localEidAppraiseHistories.getActionCode() == null)) || ((this.actionCode != null) && (this.actionCode.equals(localEidAppraiseHistories.getActionCode())) && (((this.appraiseDate == null) && (localEidAppraiseHistories.getAppraiseDate() == null)) || ((this.appraiseDate != null) && (this.appraiseDate.equals(localEidAppraiseHistories.getAppraiseDate())) && (((this.appraiseDesc == null) && (localEidAppraiseHistories.getAppraiseDesc() == null)) || ((this.appraiseDesc != null) && (this.appraiseDesc.equals(localEidAppraiseHistories.getAppraiseDesc())) && (((this.appraiseEmployeeId == null) && (localEidAppraiseHistories.getAppraiseEmployeeId() == null)) || ((this.appraiseEmployeeId != null) && (this.appraiseEmployeeId.equals(localEidAppraiseHistories.getAppraiseEmployeeId())) && (((this.appraiseHistoryId == null) && (localEidAppraiseHistories.getAppraiseHistoryId() == null)) || ((this.appraiseHistoryId != null) && (this.appraiseHistoryId.equals(localEidAppraiseHistories.getAppraiseHistoryId())) && (((this.appraiseNode == null) && (localEidAppraiseHistories.getAppraiseNode() == null)) || ((this.appraiseNode != null) && (this.appraiseNode.equals(localEidAppraiseHistories.getAppraiseNode())) && (((this.appraiseNodeName == null) && (localEidAppraiseHistories.getAppraiseNodeName() == null)) || ((this.appraiseNodeName != null) && (this.appraiseNodeName.equals(localEidAppraiseHistories.getAppraiseNodeName())) && (((this.appraiseType == null) && (localEidAppraiseHistories.getAppraiseType() == null)) || ((this.appraiseType != null) && (this.appraiseType.equals(localEidAppraiseHistories.getAppraiseType())) && (((this.appraiseTypeName == null) && (localEidAppraiseHistories.getAppraiseTypeName() == null)) || ((this.appraiseTypeName != null) && (this.appraiseTypeName.equals(localEidAppraiseHistories.getAppraiseTypeName())) && (((this.createdBy == null) && (localEidAppraiseHistories.getCreatedBy() == null)) || ((this.createdBy != null) && (this.createdBy.equals(localEidAppraiseHistories.getCreatedBy())) && (((this.creationDate == null) && (localEidAppraiseHistories.getCreationDate() == null)) || ((this.creationDate != null) && (this.creationDate.equals(localEidAppraiseHistories.getCreationDate())) && (((this.enabledFlag == null) && (localEidAppraiseHistories.getEnabledFlag() == null)) || ((this.enabledFlag != null) && (this.enabledFlag.equals(localEidAppraiseHistories.getEnabledFlag())) && (((this.imageInfoId == null) && (localEidAppraiseHistories.getImageInfoId() == null)) || ((this.imageInfoId != null) && (this.imageInfoId.equals(localEidAppraiseHistories.getImageInfoId())) && (((this.imageStatus == null) && (localEidAppraiseHistories.getImageStatus() == null)) || ((this.imageStatus != null) && (this.imageStatus.equals(localEidAppraiseHistories.getImageStatus())) && (((this.imageStatusName == null) && (localEidAppraiseHistories.getImageStatusName() == null)) || ((this.imageStatusName != null) && (this.imageStatusName.equals(localEidAppraiseHistories.getImageStatusName())) && (((this.lastUpdateDate == null) && (localEidAppraiseHistories.getLastUpdateDate() == null)) || ((this.lastUpdateDate != null) && (this.lastUpdateDate.equals(localEidAppraiseHistories.getLastUpdateDate())) && (((this.lastUpdateLogin == null) && (localEidAppraiseHistories.getLastUpdateLogin() == null)) || ((this.lastUpdateLogin != null) && (this.lastUpdateLogin.equals(localEidAppraiseHistories.getLastUpdateLogin())) && (((this.lastUpdatedBy == null) && (localEidAppraiseHistories.getLastUpdatedBy() == null)) || ((this.lastUpdatedBy != null) && (this.lastUpdatedBy.equals(localEidAppraiseHistories.getLastUpdatedBy())))))))))))))))))))))))))))))))))))));
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
    if (getActionCode() != null) {
      i += getActionCode().hashCode();
    }
    if (getAppraiseDate() != null) {
      i += getAppraiseDate().hashCode();
    }
    if (getAppraiseDesc() != null) {
      i += getAppraiseDesc().hashCode();
    }
    if (getAppraiseEmployeeId() != null) {
      i += getAppraiseEmployeeId().hashCode();
    }
    if (getAppraiseHistoryId() != null) {
      i += getAppraiseHistoryId().hashCode();
    }
    if (getAppraiseNode() != null) {
      i += getAppraiseNode().hashCode();
    }
    if (getAppraiseNodeName() != null) {
      i += getAppraiseNodeName().hashCode();
    }
    if (getAppraiseType() != null) {
      i += getAppraiseType().hashCode();
    }
    if (getAppraiseTypeName() != null) {
      i += getAppraiseTypeName().hashCode();
    }
    if (getCreatedBy() != null) {
      i += getCreatedBy().hashCode();
    }
    if (getCreationDate() != null) {
      i += getCreationDate().hashCode();
    }
    if (getEnabledFlag() != null) {
      i += getEnabledFlag().hashCode();
    }
    if (getImageInfoId() != null) {
      i += getImageInfoId().hashCode();
    }
    if (getImageStatus() != null) {
      i += getImageStatus().hashCode();
    }
    if (getImageStatusName() != null) {
      i += getImageStatusName().hashCode();
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
    typeDesc.setXmlType(new QName("impl:EidAppraiseHistories", "EidAppraiseHistories"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("actionCode");
    localElementDesc.setXmlName(new QName("", "actionCode"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("appraiseDate");
    localElementDesc.setXmlName(new QName("", "appraiseDate"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("appraiseDesc");
    localElementDesc.setXmlName(new QName("", "appraiseDesc"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("appraiseEmployeeId");
    localElementDesc.setXmlName(new QName("", "appraiseEmployeeId"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("appraiseHistoryId");
    localElementDesc.setXmlName(new QName("", "appraiseHistoryId"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("appraiseNode");
    localElementDesc.setXmlName(new QName("", "appraiseNode"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("appraiseNodeName");
    localElementDesc.setXmlName(new QName("", "appraiseNodeName"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("appraiseType");
    localElementDesc.setXmlName(new QName("", "appraiseType"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("appraiseTypeName");
    localElementDesc.setXmlName(new QName("", "appraiseTypeName"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("createdBy");
    localElementDesc.setXmlName(new QName("", "createdBy"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("creationDate");
    localElementDesc.setXmlName(new QName("", "creationDate"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("enabledFlag");
    localElementDesc.setXmlName(new QName("", "enabledFlag"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("imageInfoId");
    localElementDesc.setXmlName(new QName("", "imageInfoId"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("imageStatus");
    localElementDesc.setXmlName(new QName("", "imageStatus"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("imageStatusName");
    localElementDesc.setXmlName(new QName("", "imageStatusName"));
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
    localElementDesc.setFieldName("lastUpdateLogin");
    localElementDesc.setXmlName(new QName("", "lastUpdateLogin"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("lastUpdatedBy");
    localElementDesc.setXmlName(new QName("", "lastUpdatedBy"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.appraiseImageSrv.EidAppraiseHistories
 * JD-Core Version:    0.7.0.1
 */