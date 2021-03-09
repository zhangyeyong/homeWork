package com.zte.web.service.client.sendMSMService;

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

public class CoreSMSType
  implements Serializable
{
  private String departmentNO;
  private String consumeSMSID;
  private String operID;
  private String operPass;
  private String sendTime;
  private String appendID;
  private MessageType[] message;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(CoreSMSType.class, true);
  
  public CoreSMSType() {}
  
  public CoreSMSType(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, MessageType[] paramArrayOfMessageType)
  {
    this.departmentNO = paramString1;
    this.consumeSMSID = paramString2;
    this.operID = paramString3;
    this.operPass = paramString4;
    this.sendTime = paramString5;
    this.appendID = paramString6;
    this.message = paramArrayOfMessageType;
  }
  
  public String getDepartmentNO()
  {
    return this.departmentNO;
  }
  
  public void setDepartmentNO(String paramString)
  {
    this.departmentNO = paramString;
  }
  
  public String getConsumeSMSID()
  {
    return this.consumeSMSID;
  }
  
  public void setConsumeSMSID(String paramString)
  {
    this.consumeSMSID = paramString;
  }
  
  public String getOperID()
  {
    return this.operID;
  }
  
  public void setOperID(String paramString)
  {
    this.operID = paramString;
  }
  
  public String getOperPass()
  {
    return this.operPass;
  }
  
  public void setOperPass(String paramString)
  {
    this.operPass = paramString;
  }
  
  public String getSendTime()
  {
    return this.sendTime;
  }
  
  public void setSendTime(String paramString)
  {
    this.sendTime = paramString;
  }
  
  public String getAppendID()
  {
    return this.appendID;
  }
  
  public void setAppendID(String paramString)
  {
    this.appendID = paramString;
  }
  
  public MessageType[] getMessage()
  {
    return this.message;
  }
  
  public void setMessage(MessageType[] paramArrayOfMessageType)
  {
    this.message = paramArrayOfMessageType;
  }
  
  public MessageType getMessage(int paramInt)
  {
    return this.message[paramInt];
  }
  
  public void setMessage(int paramInt, MessageType paramMessageType)
  {
    this.message[paramInt] = paramMessageType;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CoreSMSType)) {
      return false;
    }
    CoreSMSType localCoreSMSType = (CoreSMSType)paramObject;
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
    boolean bool = ((this.departmentNO == null) && (localCoreSMSType.getDepartmentNO() == null)) || ((this.departmentNO != null) && (this.departmentNO.equals(localCoreSMSType.getDepartmentNO())) && (((this.consumeSMSID == null) && (localCoreSMSType.getConsumeSMSID() == null)) || ((this.consumeSMSID != null) && (this.consumeSMSID.equals(localCoreSMSType.getConsumeSMSID())) && (((this.operID == null) && (localCoreSMSType.getOperID() == null)) || ((this.operID != null) && (this.operID.equals(localCoreSMSType.getOperID())) && (((this.operPass == null) && (localCoreSMSType.getOperPass() == null)) || ((this.operPass != null) && (this.operPass.equals(localCoreSMSType.getOperPass())) && (((this.sendTime == null) && (localCoreSMSType.getSendTime() == null)) || ((this.sendTime != null) && (this.sendTime.equals(localCoreSMSType.getSendTime())) && (((this.appendID == null) && (localCoreSMSType.getAppendID() == null)) || ((this.appendID != null) && (this.appendID.equals(localCoreSMSType.getAppendID())) && (((this.message == null) && (localCoreSMSType.getMessage() == null)) || ((this.message != null) && (Arrays.equals(this.message, localCoreSMSType.getMessage())))))))))))))));
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
    if (getDepartmentNO() != null) {
      i += getDepartmentNO().hashCode();
    }
    if (getConsumeSMSID() != null) {
      i += getConsumeSMSID().hashCode();
    }
    if (getOperID() != null) {
      i += getOperID().hashCode();
    }
    if (getOperPass() != null) {
      i += getOperPass().hashCode();
    }
    if (getSendTime() != null) {
      i += getSendTime().hashCode();
    }
    if (getAppendID() != null) {
      i += getAppendID().hashCode();
    }
    if (getMessage() != null) {
      for (int j = 0; j < Array.getLength(getMessage()); j++)
      {
        Object localObject = Array.get(getMessage(), j);
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
    typeDesc.setXmlType(new QName("http://www.haier.eai/SendMSMService/", "CoreSMSType"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("departmentNO");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "DepartmentNO"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("consumeSMSID");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "ConsumeSMSID"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("operID");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "OperID"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("operPass");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "OperPass"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("sendTime");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "SendTime"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("appendID");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "AppendID"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("message");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "Message"));
    localElementDesc.setXmlType(new QName("http://www.haier.eai/SendMSMService/", "MessageType"));
    localElementDesc.setNillable(false);
    localElementDesc.setMaxOccursUnbounded(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.sendMSMService.CoreSMSType
 * JD-Core Version:    0.7.0.1
 */