package com.zte.eas.boe.image.syn.judget;

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

public class SB_EVS_EVS_ImportImageJudgementInfoSrvRequest
  implements Serializable
{
  private MsgHeader msgHeader;
  private ImportImageJudgementInfoSrvInputItem[] importImageJudgementInfoSrvInputCollection;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(SB_EVS_EVS_ImportImageJudgementInfoSrvRequest.class, true);
  
  public SB_EVS_EVS_ImportImageJudgementInfoSrvRequest() {}
  
  public SB_EVS_EVS_ImportImageJudgementInfoSrvRequest(MsgHeader paramMsgHeader, ImportImageJudgementInfoSrvInputItem[] paramArrayOfImportImageJudgementInfoSrvInputItem)
  {
    this.msgHeader = paramMsgHeader;
    this.importImageJudgementInfoSrvInputCollection = paramArrayOfImportImageJudgementInfoSrvInputItem;
  }
  
  public MsgHeader getMsgHeader()
  {
    return this.msgHeader;
  }
  
  public void setMsgHeader(MsgHeader paramMsgHeader)
  {
    this.msgHeader = paramMsgHeader;
  }
  
  public ImportImageJudgementInfoSrvInputItem[] getImportImageJudgementInfoSrvInputCollection()
  {
    return this.importImageJudgementInfoSrvInputCollection;
  }
  
  public void setImportImageJudgementInfoSrvInputCollection(ImportImageJudgementInfoSrvInputItem[] paramArrayOfImportImageJudgementInfoSrvInputItem)
  {
    this.importImageJudgementInfoSrvInputCollection = paramArrayOfImportImageJudgementInfoSrvInputItem;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SB_EVS_EVS_ImportImageJudgementInfoSrvRequest)) {
      return false;
    }
    SB_EVS_EVS_ImportImageJudgementInfoSrvRequest localSB_EVS_EVS_ImportImageJudgementInfoSrvRequest = (SB_EVS_EVS_ImportImageJudgementInfoSrvRequest)paramObject;
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
    boolean bool = ((this.msgHeader == null) && (localSB_EVS_EVS_ImportImageJudgementInfoSrvRequest.getMsgHeader() == null)) || ((this.msgHeader != null) && (this.msgHeader.equals(localSB_EVS_EVS_ImportImageJudgementInfoSrvRequest.getMsgHeader())) && (((this.importImageJudgementInfoSrvInputCollection == null) && (localSB_EVS_EVS_ImportImageJudgementInfoSrvRequest.getImportImageJudgementInfoSrvInputCollection() == null)) || ((this.importImageJudgementInfoSrvInputCollection != null) && (Arrays.equals(this.importImageJudgementInfoSrvInputCollection, localSB_EVS_EVS_ImportImageJudgementInfoSrvRequest.getImportImageJudgementInfoSrvInputCollection())))));
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
    if (getImportImageJudgementInfoSrvInputCollection() != null) {
      for (int j = 0; j < Array.getLength(getImportImageJudgementInfoSrvInputCollection()); j++)
      {
        Object localObject = Array.get(getImportImageJudgementInfoSrvInputCollection(), j);
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
    typeDesc.setXmlType(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "SB_EVS_EVS_ImportImageJudgementInfoSrvRequest"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("msgHeader");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "MsgHeader"));
    localElementDesc.setXmlType(new QName("http://mss.cmcc.com/MsgHeader", "MsgHeader"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("importImageJudgementInfoSrvInputCollection");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "ImportImageJudgementInfoSrvInputCollection"));
    localElementDesc.setXmlType(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "ImportImageJudgementInfoSrvInputItem"));
    localElementDesc.setNillable(true);
    localElementDesc.setItemQName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "ImportImageJudgementInfoSrvInputItem"));
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.judget.SB_EVS_EVS_ImportImageJudgementInfoSrvRequest
 * JD-Core Version:    0.7.0.1
 */