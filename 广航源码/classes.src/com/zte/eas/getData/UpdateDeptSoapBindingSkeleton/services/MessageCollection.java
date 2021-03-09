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

public class MessageCollection
  implements Serializable
{
  private Message[] messageList;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(MessageCollection.class, true);
  
  public MessageCollection() {}
  
  public MessageCollection(Message[] paramArrayOfMessage)
  {
    this.messageList = paramArrayOfMessage;
  }
  
  public Message[] getMessageList()
  {
    return this.messageList;
  }
  
  public void setMessageList(Message[] paramArrayOfMessage)
  {
    this.messageList = paramArrayOfMessage;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MessageCollection)) {
      return false;
    }
    MessageCollection localMessageCollection = (MessageCollection)paramObject;
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
    boolean bool = ((this.messageList == null) && (localMessageCollection.getMessageList() == null)) || ((this.messageList != null) && (Arrays.equals(this.messageList, localMessageCollection.getMessageList())));
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
    if (getMessageList() != null) {
      for (int j = 0; j < Array.getLength(getMessageList()); j++)
      {
        Object localObject = Array.get(getMessageList(), j);
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
    typeDesc.setXmlType(new QName("impl:MessageCollection", "MessageCollection"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("messageList");
    localElementDesc.setXmlName(new QName("impl:MessageCollection", "messageList"));
    localElementDesc.setXmlType(new QName("impl:Message", "Message"));
    localElementDesc.setNillable(true);
    localElementDesc.setItemQName(new QName("http://www.evs.com/services/syncEmployeeDeptSrv", "item"));
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.MessageCollection
 * JD-Core Version:    0.7.0.1
 */