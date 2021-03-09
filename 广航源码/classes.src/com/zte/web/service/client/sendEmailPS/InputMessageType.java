package com.zte.web.service.client.sendEmailPS;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class InputMessageType
  implements Serializable
{
  private String consumerEmailID;
  private String mailTo;
  private String mailCC;
  private String mailSubject;
  private String mailContent;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(InputMessageType.class, true);
  
  public InputMessageType() {}
  
  public InputMessageType(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.consumerEmailID = paramString1;
    this.mailTo = paramString2;
    this.mailCC = paramString3;
    this.mailSubject = paramString4;
    this.mailContent = paramString5;
  }
  
  public String getConsumerEmailID()
  {
    return this.consumerEmailID;
  }
  
  public void setConsumerEmailID(String paramString)
  {
    this.consumerEmailID = paramString;
  }
  
  public String getMailTo()
  {
    return this.mailTo;
  }
  
  public void setMailTo(String paramString)
  {
    this.mailTo = paramString;
  }
  
  public String getMailCC()
  {
    return this.mailCC;
  }
  
  public void setMailCC(String paramString)
  {
    this.mailCC = paramString;
  }
  
  public String getMailSubject()
  {
    return this.mailSubject;
  }
  
  public void setMailSubject(String paramString)
  {
    this.mailSubject = paramString;
  }
  
  public String getMailContent()
  {
    return this.mailContent;
  }
  
  public void setMailContent(String paramString)
  {
    this.mailContent = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof InputMessageType)) {
      return false;
    }
    InputMessageType localInputMessageType = (InputMessageType)paramObject;
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
    boolean bool = ((this.consumerEmailID == null) && (localInputMessageType.getConsumerEmailID() == null)) || ((this.consumerEmailID != null) && (this.consumerEmailID.equals(localInputMessageType.getConsumerEmailID())) && (((this.mailTo == null) && (localInputMessageType.getMailTo() == null)) || ((this.mailTo != null) && (this.mailTo.equals(localInputMessageType.getMailTo())) && (((this.mailCC == null) && (localInputMessageType.getMailCC() == null)) || ((this.mailCC != null) && (this.mailCC.equals(localInputMessageType.getMailCC())) && (((this.mailSubject == null) && (localInputMessageType.getMailSubject() == null)) || ((this.mailSubject != null) && (this.mailSubject.equals(localInputMessageType.getMailSubject())) && (((this.mailContent == null) && (localInputMessageType.getMailContent() == null)) || ((this.mailContent != null) && (this.mailContent.equals(localInputMessageType.getMailContent())))))))))));
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
    if (getConsumerEmailID() != null) {
      i += getConsumerEmailID().hashCode();
    }
    if (getMailTo() != null) {
      i += getMailTo().hashCode();
    }
    if (getMailCC() != null) {
      i += getMailCC().hashCode();
    }
    if (getMailSubject() != null) {
      i += getMailSubject().hashCode();
    }
    if (getMailContent() != null) {
      i += getMailContent().hashCode();
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
    typeDesc.setXmlType(new QName("http://www.haier.eai.com/SendEmailPS", "InputMessageType"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("consumerEmailID");
    localElementDesc.setXmlName(new QName("http://www.haier.eai.com/SendEmailPS", "ConsumerEmailID"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("mailTo");
    localElementDesc.setXmlName(new QName("http://www.haier.eai.com/SendEmailPS", "MailTo"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("mailCC");
    localElementDesc.setXmlName(new QName("http://www.haier.eai.com/SendEmailPS", "MailCC"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("mailSubject");
    localElementDesc.setXmlName(new QName("http://www.haier.eai.com/SendEmailPS", "MailSubject"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("mailContent");
    localElementDesc.setXmlName(new QName("http://www.haier.eai.com/SendEmailPS", "MailContent"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setMinOccurs(0);
    localElementDesc.setNillable(false);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.sendEmailPS.InputMessageType
 * JD-Core Version:    0.7.0.1
 */