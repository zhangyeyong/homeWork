package com.zte.eas.boe.image.syn.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class ImportSrvResponse
  implements Serializable
{
  private String SERVICE_FLAG;
  private String SERVICE_MESSAGE;
  private BigDecimal INSTANCE_ID;
  private ErrorItem[] errorCollection;
  private ResponseItem[] responseCollecion;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(ImportSrvResponse.class, true);
  
  public ImportSrvResponse() {}
  
  public ImportSrvResponse(String paramString1, String paramString2, BigDecimal paramBigDecimal, ErrorItem[] paramArrayOfErrorItem, ResponseItem[] paramArrayOfResponseItem)
  {
    this.SERVICE_FLAG = paramString1;
    this.SERVICE_MESSAGE = paramString2;
    this.INSTANCE_ID = paramBigDecimal;
    this.errorCollection = paramArrayOfErrorItem;
    this.responseCollecion = paramArrayOfResponseItem;
  }
  
  public String getSERVICE_FLAG()
  {
    return this.SERVICE_FLAG;
  }
  
  public void setSERVICE_FLAG(String paramString)
  {
    this.SERVICE_FLAG = paramString;
  }
  
  public String getSERVICE_MESSAGE()
  {
    return this.SERVICE_MESSAGE;
  }
  
  public void setSERVICE_MESSAGE(String paramString)
  {
    this.SERVICE_MESSAGE = paramString;
  }
  
  public BigDecimal getINSTANCE_ID()
  {
    return this.INSTANCE_ID;
  }
  
  public void setINSTANCE_ID(BigDecimal paramBigDecimal)
  {
    this.INSTANCE_ID = paramBigDecimal;
  }
  
  public ErrorItem[] getErrorCollection()
  {
    return this.errorCollection;
  }
  
  public void setErrorCollection(ErrorItem[] paramArrayOfErrorItem)
  {
    this.errorCollection = paramArrayOfErrorItem;
  }
  
  public ResponseItem[] getResponseCollecion()
  {
    return this.responseCollecion;
  }
  
  public void setResponseCollecion(ResponseItem[] paramArrayOfResponseItem)
  {
    this.responseCollecion = paramArrayOfResponseItem;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImportSrvResponse)) {
      return false;
    }
    ImportSrvResponse localImportSrvResponse = (ImportSrvResponse)paramObject;
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
    boolean bool = ((this.SERVICE_FLAG == null) && (localImportSrvResponse.getSERVICE_FLAG() == null)) || ((this.SERVICE_FLAG != null) && (this.SERVICE_FLAG.equals(localImportSrvResponse.getSERVICE_FLAG())) && (((this.SERVICE_MESSAGE == null) && (localImportSrvResponse.getSERVICE_MESSAGE() == null)) || ((this.SERVICE_MESSAGE != null) && (this.SERVICE_MESSAGE.equals(localImportSrvResponse.getSERVICE_MESSAGE())) && (((this.INSTANCE_ID == null) && (localImportSrvResponse.getINSTANCE_ID() == null)) || ((this.INSTANCE_ID != null) && (this.INSTANCE_ID.equals(localImportSrvResponse.getINSTANCE_ID())) && (((this.errorCollection == null) && (localImportSrvResponse.getErrorCollection() == null)) || ((this.errorCollection != null) && (Arrays.equals(this.errorCollection, localImportSrvResponse.getErrorCollection())) && (((this.responseCollecion == null) && (localImportSrvResponse.getResponseCollecion() == null)) || ((this.responseCollecion != null) && (Arrays.equals(this.responseCollecion, localImportSrvResponse.getResponseCollecion())))))))))));
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
    if (getSERVICE_FLAG() != null) {
      i += getSERVICE_FLAG().hashCode();
    }
    if (getSERVICE_MESSAGE() != null) {
      i += getSERVICE_MESSAGE().hashCode();
    }
    if (getINSTANCE_ID() != null) {
      i += getINSTANCE_ID().hashCode();
    }
    int j;
    Object localObject;
    if (getErrorCollection() != null) {
      for (j = 0; j < Array.getLength(getErrorCollection()); j++)
      {
        localObject = Array.get(getErrorCollection(), j);
        if ((localObject != null) && (!localObject.getClass().isArray())) {
          i += localObject.hashCode();
        }
      }
    }
    if (getResponseCollecion() != null) {
      for (j = 0; j < Array.getLength(getResponseCollecion()); j++)
      {
        localObject = Array.get(getResponseCollecion(), j);
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
    typeDesc.setXmlType(new QName("http://mss.cmcc.com/ImportSrvResponse", "ImportSrvResponse"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("SERVICE_FLAG");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/ImportSrvResponse", "SERVICE_FLAG"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("SERVICE_MESSAGE");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/ImportSrvResponse", "SERVICE_MESSAGE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("INSTANCE_ID");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/ImportSrvResponse", "INSTANCE_ID"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "decimal"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("errorCollection");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/ImportSrvResponse", "ErrorCollection"));
    localElementDesc.setXmlType(new QName("http://mss.cmcc.com/ImportSrvResponse", "ErrorItem"));
    localElementDesc.setNillable(true);
    localElementDesc.setItemQName(new QName("http://mss.cmcc.com/ImportSrvResponse", "ErrorItem"));
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("responseCollecion");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/ImportSrvResponse", "ResponseCollecion"));
    localElementDesc.setXmlType(new QName("http://mss.cmcc.com/ImportSrvResponse", "ResponseItem"));
    localElementDesc.setNillable(true);
    localElementDesc.setItemQName(new QName("http://mss.cmcc.com/ImportSrvResponse", "ResponseItem"));
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.model.ImportSrvResponse
 * JD-Core Version:    0.7.0.1
 */