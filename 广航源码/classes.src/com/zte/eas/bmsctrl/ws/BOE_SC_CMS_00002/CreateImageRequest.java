package com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002;

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

public class CreateImageRequest
  implements Serializable
{
  private ImageList[] imageList;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(CreateImageRequest.class, true);
  
  public CreateImageRequest() {}
  
  public CreateImageRequest(ImageList[] paramArrayOfImageList)
  {
    this.imageList = paramArrayOfImageList;
  }
  
  public ImageList[] getImageList()
  {
    return this.imageList;
  }
  
  public void setImageList(ImageList[] paramArrayOfImageList)
  {
    this.imageList = paramArrayOfImageList;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CreateImageRequest)) {
      return false;
    }
    CreateImageRequest localCreateImageRequest = (CreateImageRequest)paramObject;
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
    boolean bool = ((this.imageList == null) && (localCreateImageRequest.getImageList() == null)) || ((this.imageList != null) && (Arrays.equals(this.imageList, localCreateImageRequest.getImageList())));
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
    if (getImageList() != null) {
      for (int j = 0; j < Array.getLength(getImageList()); j++)
      {
        Object localObject = Array.get(getImageList(), j);
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
    typeDesc.setXmlType(new QName("http://127.0.0.1/evs_ydzd", "CreateImageRequest"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("imageList");
    localElementDesc.setXmlName(new QName("http://127.0.0.1/evs_ydzd", "imageList"));
    localElementDesc.setXmlType(new QName("http://127.0.0.1/evs_ydzd", "ImageList"));
    localElementDesc.setNillable(true);
    localElementDesc.setItemQName(new QName("http://127.0.0.1/evs_ydzd", "item"));
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00002.CreateImageRequest
 * JD-Core Version:    0.7.0.1
 */