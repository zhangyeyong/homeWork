package com.zte.eas.boe.image.syn.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class ImportImageOperationInfoSrvInputItem
  implements Serializable
{
  private String PRI_KEY;
  private String BATCH_NAME;
  private String BOE_NUM;
  private String OPERATION_TYPE;
  private Calendar OPERATION_DATE;
  private String IRESERVED_1;
  private String IRESERVED_2;
  private String IRESERVED_3;
  private String IRESERVED_4;
  private String IRESERVED_5;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(ImportImageOperationInfoSrvInputItem.class, true);
  
  public ImportImageOperationInfoSrvInputItem() {}
  
  public ImportImageOperationInfoSrvInputItem(String paramString1, String paramString2, String paramString3, String paramString4, Calendar paramCalendar, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.PRI_KEY = paramString1;
    this.BATCH_NAME = paramString2;
    this.BOE_NUM = paramString3;
    this.OPERATION_TYPE = paramString4;
    this.OPERATION_DATE = paramCalendar;
    this.IRESERVED_1 = paramString5;
    this.IRESERVED_2 = paramString6;
    this.IRESERVED_3 = paramString7;
    this.IRESERVED_4 = paramString8;
    this.IRESERVED_5 = paramString9;
  }
  
  public String getPRI_KEY()
  {
    return this.PRI_KEY;
  }
  
  public void setPRI_KEY(String paramString)
  {
    this.PRI_KEY = paramString;
  }
  
  public String getBATCH_NAME()
  {
    return this.BATCH_NAME;
  }
  
  public void setBATCH_NAME(String paramString)
  {
    this.BATCH_NAME = paramString;
  }
  
  public String getBOE_NUM()
  {
    return this.BOE_NUM;
  }
  
  public void setBOE_NUM(String paramString)
  {
    this.BOE_NUM = paramString;
  }
  
  public String getOPERATION_TYPE()
  {
    return this.OPERATION_TYPE;
  }
  
  public void setOPERATION_TYPE(String paramString)
  {
    this.OPERATION_TYPE = paramString;
  }
  
  public Calendar getOPERATION_DATE()
  {
    return this.OPERATION_DATE;
  }
  
  public void setOPERATION_DATE(Calendar paramCalendar)
  {
    this.OPERATION_DATE = paramCalendar;
  }
  
  public String getIRESERVED_1()
  {
    return this.IRESERVED_1;
  }
  
  public void setIRESERVED_1(String paramString)
  {
    this.IRESERVED_1 = paramString;
  }
  
  public String getIRESERVED_2()
  {
    return this.IRESERVED_2;
  }
  
  public void setIRESERVED_2(String paramString)
  {
    this.IRESERVED_2 = paramString;
  }
  
  public String getIRESERVED_3()
  {
    return this.IRESERVED_3;
  }
  
  public void setIRESERVED_3(String paramString)
  {
    this.IRESERVED_3 = paramString;
  }
  
  public String getIRESERVED_4()
  {
    return this.IRESERVED_4;
  }
  
  public void setIRESERVED_4(String paramString)
  {
    this.IRESERVED_4 = paramString;
  }
  
  public String getIRESERVED_5()
  {
    return this.IRESERVED_5;
  }
  
  public void setIRESERVED_5(String paramString)
  {
    this.IRESERVED_5 = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImportImageOperationInfoSrvInputItem)) {
      return false;
    }
    ImportImageOperationInfoSrvInputItem localImportImageOperationInfoSrvInputItem = (ImportImageOperationInfoSrvInputItem)paramObject;
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
    boolean bool = ((this.PRI_KEY == null) && (localImportImageOperationInfoSrvInputItem.getPRI_KEY() == null)) || ((this.PRI_KEY != null) && (this.PRI_KEY.equals(localImportImageOperationInfoSrvInputItem.getPRI_KEY())) && (((this.BATCH_NAME == null) && (localImportImageOperationInfoSrvInputItem.getBATCH_NAME() == null)) || ((this.BATCH_NAME != null) && (this.BATCH_NAME.equals(localImportImageOperationInfoSrvInputItem.getBATCH_NAME())) && (((this.BOE_NUM == null) && (localImportImageOperationInfoSrvInputItem.getBOE_NUM() == null)) || ((this.BOE_NUM != null) && (this.BOE_NUM.equals(localImportImageOperationInfoSrvInputItem.getBOE_NUM())) && (((this.OPERATION_TYPE == null) && (localImportImageOperationInfoSrvInputItem.getOPERATION_TYPE() == null)) || ((this.OPERATION_TYPE != null) && (this.OPERATION_TYPE.equals(localImportImageOperationInfoSrvInputItem.getOPERATION_TYPE())) && (((this.OPERATION_DATE == null) && (localImportImageOperationInfoSrvInputItem.getOPERATION_DATE() == null)) || ((this.OPERATION_DATE != null) && (this.OPERATION_DATE.equals(localImportImageOperationInfoSrvInputItem.getOPERATION_DATE())) && (((this.IRESERVED_1 == null) && (localImportImageOperationInfoSrvInputItem.getIRESERVED_1() == null)) || ((this.IRESERVED_1 != null) && (this.IRESERVED_1.equals(localImportImageOperationInfoSrvInputItem.getIRESERVED_1())) && (((this.IRESERVED_2 == null) && (localImportImageOperationInfoSrvInputItem.getIRESERVED_2() == null)) || ((this.IRESERVED_2 != null) && (this.IRESERVED_2.equals(localImportImageOperationInfoSrvInputItem.getIRESERVED_2())) && (((this.IRESERVED_3 == null) && (localImportImageOperationInfoSrvInputItem.getIRESERVED_3() == null)) || ((this.IRESERVED_3 != null) && (this.IRESERVED_3.equals(localImportImageOperationInfoSrvInputItem.getIRESERVED_3())) && (((this.IRESERVED_4 == null) && (localImportImageOperationInfoSrvInputItem.getIRESERVED_4() == null)) || ((this.IRESERVED_4 != null) && (this.IRESERVED_4.equals(localImportImageOperationInfoSrvInputItem.getIRESERVED_4())) && (((this.IRESERVED_5 == null) && (localImportImageOperationInfoSrvInputItem.getIRESERVED_5() == null)) || ((this.IRESERVED_5 != null) && (this.IRESERVED_5.equals(localImportImageOperationInfoSrvInputItem.getIRESERVED_5())))))))))))))))))))));
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
    if (getPRI_KEY() != null) {
      i += getPRI_KEY().hashCode();
    }
    if (getBATCH_NAME() != null) {
      i += getBATCH_NAME().hashCode();
    }
    if (getBOE_NUM() != null) {
      i += getBOE_NUM().hashCode();
    }
    if (getOPERATION_TYPE() != null) {
      i += getOPERATION_TYPE().hashCode();
    }
    if (getOPERATION_DATE() != null) {
      i += getOPERATION_DATE().hashCode();
    }
    if (getIRESERVED_1() != null) {
      i += getIRESERVED_1().hashCode();
    }
    if (getIRESERVED_2() != null) {
      i += getIRESERVED_2().hashCode();
    }
    if (getIRESERVED_3() != null) {
      i += getIRESERVED_3().hashCode();
    }
    if (getIRESERVED_4() != null) {
      i += getIRESERVED_4().hashCode();
    }
    if (getIRESERVED_5() != null) {
      i += getIRESERVED_5().hashCode();
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
    typeDesc.setXmlType(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "ImportImageOperationInfoSrvInputItem"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("PRI_KEY");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "PRI_KEY"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("BATCH_NAME");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "BATCH_NAME"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("BOE_NUM");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "BOE_NUM"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("OPERATION_TYPE");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "OPERATION_TYPE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("OPERATION_DATE");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "OPERATION_DATE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("IRESERVED_1");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "IRESERVED_1"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("IRESERVED_2");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "IRESERVED_2"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("IRESERVED_3");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "IRESERVED_3"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("IRESERVED_4");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "IRESERVED_4"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("IRESERVED_5");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "IRESERVED_5"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.model.ImportImageOperationInfoSrvInputItem
 * JD-Core Version:    0.7.0.1
 */