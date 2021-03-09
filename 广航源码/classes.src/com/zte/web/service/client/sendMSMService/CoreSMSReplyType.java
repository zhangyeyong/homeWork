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

public class CoreSMSReplyType
  implements Serializable
{
  private String code;
  private String consumeSMSID;
  private MessageReplyType[] messageReply;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(CoreSMSReplyType.class, true);
  
  public CoreSMSReplyType() {}
  
  public CoreSMSReplyType(String paramString1, String paramString2, MessageReplyType[] paramArrayOfMessageReplyType)
  {
    this.code = paramString1;
    this.consumeSMSID = paramString2;
    this.messageReply = paramArrayOfMessageReplyType;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public String getConsumeSMSID()
  {
    return this.consumeSMSID;
  }
  
  public void setConsumeSMSID(String paramString)
  {
    this.consumeSMSID = paramString;
  }
  
  public MessageReplyType[] getMessageReply()
  {
    return this.messageReply;
  }
  
  public void setMessageReply(MessageReplyType[] paramArrayOfMessageReplyType)
  {
    this.messageReply = paramArrayOfMessageReplyType;
  }
  
  public MessageReplyType getMessageReply(int paramInt)
  {
    return this.messageReply[paramInt];
  }
  
  public void setMessageReply(int paramInt, MessageReplyType paramMessageReplyType)
  {
    this.messageReply[paramInt] = paramMessageReplyType;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CoreSMSReplyType)) {
      return false;
    }
    CoreSMSReplyType localCoreSMSReplyType = (CoreSMSReplyType)paramObject;
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
    boolean bool = ((this.code == null) && (localCoreSMSReplyType.getCode() == null)) || ((this.code != null) && (this.code.equals(localCoreSMSReplyType.getCode())) && (((this.consumeSMSID == null) && (localCoreSMSReplyType.getConsumeSMSID() == null)) || ((this.consumeSMSID != null) && (this.consumeSMSID.equals(localCoreSMSReplyType.getConsumeSMSID())) && (((this.messageReply == null) && (localCoreSMSReplyType.getMessageReply() == null)) || ((this.messageReply != null) && (Arrays.equals(this.messageReply, localCoreSMSReplyType.getMessageReply())))))));
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
    if (getCode() != null) {
      i += getCode().hashCode();
    }
    if (getConsumeSMSID() != null) {
      i += getConsumeSMSID().hashCode();
    }
    if (getMessageReply() != null) {
      for (int j = 0; j < Array.getLength(getMessageReply()); j++)
      {
        Object localObject = Array.get(getMessageReply(), j);
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
    typeDesc.setXmlType(new QName("http://www.haier.eai/SendMSMService/", "CoreSMSReplyType"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("code");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "Code"));
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
    localElementDesc.setFieldName("messageReply");
    localElementDesc.setXmlName(new QName("http://www.haier.eai/SendMSMService/", "MessageReply"));
    localElementDesc.setXmlType(new QName("http://www.haier.eai/SendMSMService/", "MessageReplyType"));
    localElementDesc.setNillable(false);
    localElementDesc.setMaxOccursUnbounded(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.sendMSMService.CoreSMSReplyType
 * JD-Core Version:    0.7.0.1
 */