package com.zte.eas.boe.image.syn.model;

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

public class SB_EAS_EAS_ImportImageOperationInfoSrvRequest
  implements Serializable
{
  private MsgHeader msgHeader;
  private ImportImageOperationInfoSrvInputItem[] importImageOperationInfoSrvInputCollection;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(SB_EAS_EAS_ImportImageOperationInfoSrvRequest.class, true);
  
  public SB_EAS_EAS_ImportImageOperationInfoSrvRequest() {}
  
  public SB_EAS_EAS_ImportImageOperationInfoSrvRequest(MsgHeader paramMsgHeader, ImportImageOperationInfoSrvInputItem[] paramArrayOfImportImageOperationInfoSrvInputItem)
  {
    this.msgHeader = paramMsgHeader;
    this.importImageOperationInfoSrvInputCollection = paramArrayOfImportImageOperationInfoSrvInputItem;
  }
  
  public MsgHeader getMsgHeader()
  {
    return this.msgHeader;
  }
  
  public void setMsgHeader(MsgHeader paramMsgHeader)
  {
    this.msgHeader = paramMsgHeader;
  }
  
  public ImportImageOperationInfoSrvInputItem[] getImportImageOperationInfoSrvInputCollection()
  {
    return this.importImageOperationInfoSrvInputCollection;
  }
  
  public void setImportImageOperationInfoSrvInputCollection(ImportImageOperationInfoSrvInputItem[] paramArrayOfImportImageOperationInfoSrvInputItem)
  {
    this.importImageOperationInfoSrvInputCollection = paramArrayOfImportImageOperationInfoSrvInputItem;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SB_EAS_EAS_ImportImageOperationInfoSrvRequest)) {
      return false;
    }
    SB_EAS_EAS_ImportImageOperationInfoSrvRequest localSB_EAS_EAS_ImportImageOperationInfoSrvRequest = (SB_EAS_EAS_ImportImageOperationInfoSrvRequest)paramObject;
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
    boolean bool = ((this.msgHeader == null) && (localSB_EAS_EAS_ImportImageOperationInfoSrvRequest.getMsgHeader() == null)) || ((this.msgHeader != null) && (this.msgHeader.equals(localSB_EAS_EAS_ImportImageOperationInfoSrvRequest.getMsgHeader())) && (((this.importImageOperationInfoSrvInputCollection == null) && (localSB_EAS_EAS_ImportImageOperationInfoSrvRequest.getImportImageOperationInfoSrvInputCollection() == null)) || ((this.importImageOperationInfoSrvInputCollection != null) && (Arrays.equals(this.importImageOperationInfoSrvInputCollection, localSB_EAS_EAS_ImportImageOperationInfoSrvRequest.getImportImageOperationInfoSrvInputCollection())))));
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
    if (getMsgHeader() != null) {
      i += getMsgHeader().hashCode();
    }
    if (getImportImageOperationInfoSrvInputCollection() != null) {
      for (int j = 0; j < Array.getLength(getImportImageOperationInfoSrvInputCollection()); j++)
      {
        Object localObject = Array.get(getImportImageOperationInfoSrvInputCollection(), j);
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
    typeDesc.setXmlType(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "SB_EAS_EAS_ImportImageOperationInfoSrvRequest"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("msgHeader");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "MsgHeader"));
    localElementDesc.setXmlType(new QName("http://mss.cmcc.com/MsgHeader", "MsgHeader"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("importImageOperationInfoSrvInputCollection");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "ImportImageOperationInfoSrvInputCollection"));
    localElementDesc.setXmlType(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "ImportImageOperationInfoSrvInputItem"));
    localElementDesc.setNillable(true);
    localElementDesc.setItemQName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "ImportImageOperationInfoSrvInputItem"));
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.model.SB_EAS_EAS_ImportImageOperationInfoSrvRequest
 * JD-Core Version:    0.7.0.1
 */