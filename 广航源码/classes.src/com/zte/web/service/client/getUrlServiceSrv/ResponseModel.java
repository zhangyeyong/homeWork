package com.zte.web.service.client.getUrlServiceSrv;

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

public class ResponseModel
  implements Serializable
{
  private String errorCode;
  private String errorManage;
  private FileModel[] file;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(ResponseModel.class, true);
  
  public ResponseModel() {}
  
  public ResponseModel(String paramString1, String paramString2, FileModel[] paramArrayOfFileModel)
  {
    this.errorCode = paramString1;
    this.errorManage = paramString2;
    this.file = paramArrayOfFileModel;
  }
  
  public String getErrorCode()
  {
    return this.errorCode;
  }
  
  public void setErrorCode(String paramString)
  {
    this.errorCode = paramString;
  }
  
  public String getErrorManage()
  {
    return this.errorManage;
  }
  
  public void setErrorManage(String paramString)
  {
    this.errorManage = paramString;
  }
  
  public FileModel[] getFile()
  {
    return this.file;
  }
  
  public void setFile(FileModel[] paramArrayOfFileModel)
  {
    this.file = paramArrayOfFileModel;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ResponseModel)) {
      return false;
    }
    ResponseModel localResponseModel = (ResponseModel)paramObject;
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
    boolean bool = ((this.errorCode == null) && (localResponseModel.getErrorCode() == null)) || ((this.errorCode != null) && (this.errorCode.equals(localResponseModel.getErrorCode())) && (((this.errorManage == null) && (localResponseModel.getErrorManage() == null)) || ((this.errorManage != null) && (this.errorManage.equals(localResponseModel.getErrorManage())) && (((this.file == null) && (localResponseModel.getFile() == null)) || ((this.file != null) && (Arrays.equals(this.file, localResponseModel.getFile())))))));
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
    if (getErrorCode() != null) {
      i += getErrorCode().hashCode();
    }
    if (getErrorManage() != null) {
      i += getErrorManage().hashCode();
    }
    if (getFile() != null) {
      for (int j = 0; j < Array.getLength(getFile()); j++)
      {
        Object localObject = Array.get(getFile(), j);
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
    typeDesc.setXmlType(new QName("urn:BeanService", "ResponseModel"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("errorCode");
    localElementDesc.setXmlName(new QName("urn:BeanService", "errorCode"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("errorManage");
    localElementDesc.setXmlName(new QName("urn:BeanService", "errorManage"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("file");
    localElementDesc.setXmlName(new QName("urn:BeanService", "file"));
    localElementDesc.setXmlType(new QName("urn:BeanService", "FileModel"));
    localElementDesc.setNillable(true);
    localElementDesc.setItemQName(new QName("com.zte.eas.workrequest.bean", "item"));
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.getUrlServiceSrv.ResponseModel
 * JD-Core Version:    0.7.0.1
 */