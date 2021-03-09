package com.zte.eas.boe.image.syn.judget;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class MsgHeader
  implements Serializable
{
  private String SOURCE_SYSTEM_ID;
  private String SOURCE_SYSTEM_NAME;
  private String USER_ID;
  private String USER_NAME;
  private Calendar SUBMIT_DATE;
  private BigDecimal PAGE_SIZE;
  private BigDecimal CURRENT_PAGE;
  private BigDecimal TOTAL_RECORD;
  private String PROVINCE_CODE;
  private String ENVIRONMENT_NAME;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(MsgHeader.class, true);
  
  public MsgHeader() {}
  
  public MsgHeader(String paramString1, String paramString2, String paramString3, String paramString4, Calendar paramCalendar, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, String paramString5, String paramString6)
  {
    this.SOURCE_SYSTEM_ID = paramString1;
    this.SOURCE_SYSTEM_NAME = paramString2;
    this.USER_ID = paramString3;
    this.USER_NAME = paramString4;
    this.SUBMIT_DATE = paramCalendar;
    this.PAGE_SIZE = paramBigDecimal1;
    this.CURRENT_PAGE = paramBigDecimal2;
    this.TOTAL_RECORD = paramBigDecimal3;
    this.PROVINCE_CODE = paramString5;
    this.ENVIRONMENT_NAME = paramString6;
  }
  
  public String getSOURCE_SYSTEM_ID()
  {
    return this.SOURCE_SYSTEM_ID;
  }
  
  public void setSOURCE_SYSTEM_ID(String paramString)
  {
    this.SOURCE_SYSTEM_ID = paramString;
  }
  
  public String getSOURCE_SYSTEM_NAME()
  {
    return this.SOURCE_SYSTEM_NAME;
  }
  
  public void setSOURCE_SYSTEM_NAME(String paramString)
  {
    this.SOURCE_SYSTEM_NAME = paramString;
  }
  
  public String getUSER_ID()
  {
    return this.USER_ID;
  }
  
  public void setUSER_ID(String paramString)
  {
    this.USER_ID = paramString;
  }
  
  public String getUSER_NAME()
  {
    return this.USER_NAME;
  }
  
  public void setUSER_NAME(String paramString)
  {
    this.USER_NAME = paramString;
  }
  
  public Calendar getSUBMIT_DATE()
  {
    return this.SUBMIT_DATE;
  }
  
  public void setSUBMIT_DATE(Calendar paramCalendar)
  {
    this.SUBMIT_DATE = paramCalendar;
  }
  
  public BigDecimal getPAGE_SIZE()
  {
    return this.PAGE_SIZE;
  }
  
  public void setPAGE_SIZE(BigDecimal paramBigDecimal)
  {
    this.PAGE_SIZE = paramBigDecimal;
  }
  
  public BigDecimal getCURRENT_PAGE()
  {
    return this.CURRENT_PAGE;
  }
  
  public void setCURRENT_PAGE(BigDecimal paramBigDecimal)
  {
    this.CURRENT_PAGE = paramBigDecimal;
  }
  
  public BigDecimal getTOTAL_RECORD()
  {
    return this.TOTAL_RECORD;
  }
  
  public void setTOTAL_RECORD(BigDecimal paramBigDecimal)
  {
    this.TOTAL_RECORD = paramBigDecimal;
  }
  
  public String getPROVINCE_CODE()
  {
    return this.PROVINCE_CODE;
  }
  
  public void setPROVINCE_CODE(String paramString)
  {
    this.PROVINCE_CODE = paramString;
  }
  
  public String getENVIRONMENT_NAME()
  {
    return this.ENVIRONMENT_NAME;
  }
  
  public void setENVIRONMENT_NAME(String paramString)
  {
    this.ENVIRONMENT_NAME = paramString;
  }
  
  public synchronized boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MsgHeader)) {
      return false;
    }
    MsgHeader localMsgHeader = (MsgHeader)paramObject;
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
    boolean bool = ((this.SOURCE_SYSTEM_ID == null) && (localMsgHeader.getSOURCE_SYSTEM_ID() == null)) || ((this.SOURCE_SYSTEM_ID != null) && (this.SOURCE_SYSTEM_ID.equals(localMsgHeader.getSOURCE_SYSTEM_ID())) && (((this.SOURCE_SYSTEM_NAME == null) && (localMsgHeader.getSOURCE_SYSTEM_NAME() == null)) || ((this.SOURCE_SYSTEM_NAME != null) && (this.SOURCE_SYSTEM_NAME.equals(localMsgHeader.getSOURCE_SYSTEM_NAME())) && (((this.USER_ID == null) && (localMsgHeader.getUSER_ID() == null)) || ((this.USER_ID != null) && (this.USER_ID.equals(localMsgHeader.getUSER_ID())) && (((this.USER_NAME == null) && (localMsgHeader.getUSER_NAME() == null)) || ((this.USER_NAME != null) && (this.USER_NAME.equals(localMsgHeader.getUSER_NAME())) && (((this.SUBMIT_DATE == null) && (localMsgHeader.getSUBMIT_DATE() == null)) || ((this.SUBMIT_DATE != null) && (this.SUBMIT_DATE.equals(localMsgHeader.getSUBMIT_DATE())) && (((this.PAGE_SIZE == null) && (localMsgHeader.getPAGE_SIZE() == null)) || ((this.PAGE_SIZE != null) && (this.PAGE_SIZE.equals(localMsgHeader.getPAGE_SIZE())) && (((this.CURRENT_PAGE == null) && (localMsgHeader.getCURRENT_PAGE() == null)) || ((this.CURRENT_PAGE != null) && (this.CURRENT_PAGE.equals(localMsgHeader.getCURRENT_PAGE())) && (((this.TOTAL_RECORD == null) && (localMsgHeader.getTOTAL_RECORD() == null)) || ((this.TOTAL_RECORD != null) && (this.TOTAL_RECORD.equals(localMsgHeader.getTOTAL_RECORD())) && (((this.PROVINCE_CODE == null) && (localMsgHeader.getPROVINCE_CODE() == null)) || ((this.PROVINCE_CODE != null) && (this.PROVINCE_CODE.equals(localMsgHeader.getPROVINCE_CODE())) && (((this.ENVIRONMENT_NAME == null) && (localMsgHeader.getENVIRONMENT_NAME() == null)) || ((this.ENVIRONMENT_NAME != null) && (this.ENVIRONMENT_NAME.equals(localMsgHeader.getENVIRONMENT_NAME())))))))))))))))))))));
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
    if (getSOURCE_SYSTEM_ID() != null) {
      i += getSOURCE_SYSTEM_ID().hashCode();
    }
    if (getSOURCE_SYSTEM_NAME() != null) {
      i += getSOURCE_SYSTEM_NAME().hashCode();
    }
    if (getUSER_ID() != null) {
      i += getUSER_ID().hashCode();
    }
    if (getUSER_NAME() != null) {
      i += getUSER_NAME().hashCode();
    }
    if (getSUBMIT_DATE() != null) {
      i += getSUBMIT_DATE().hashCode();
    }
    if (getPAGE_SIZE() != null) {
      i += getPAGE_SIZE().hashCode();
    }
    if (getCURRENT_PAGE() != null) {
      i += getCURRENT_PAGE().hashCode();
    }
    if (getTOTAL_RECORD() != null) {
      i += getTOTAL_RECORD().hashCode();
    }
    if (getPROVINCE_CODE() != null) {
      i += getPROVINCE_CODE().hashCode();
    }
    if (getENVIRONMENT_NAME() != null) {
      i += getENVIRONMENT_NAME().hashCode();
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
    typeDesc.setXmlType(new QName("http://mss.cmcc.com/MsgHeader", "MsgHeader"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("SOURCE_SYSTEM_ID");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/MsgHeader", "SOURCE_SYSTEM_ID"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("SOURCE_SYSTEM_NAME");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/MsgHeader", "SOURCE_SYSTEM_NAME"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("USER_ID");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/MsgHeader", "USER_ID"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("USER_NAME");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/MsgHeader", "USER_NAME"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("SUBMIT_DATE");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/MsgHeader", "SUBMIT_DATE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("PAGE_SIZE");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/MsgHeader", "PAGE_SIZE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "decimal"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("CURRENT_PAGE");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/MsgHeader", "CURRENT_PAGE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "decimal"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("TOTAL_RECORD");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/MsgHeader", "TOTAL_RECORD"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "decimal"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("PROVINCE_CODE");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/MsgHeader", "PROVINCE_CODE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("ENVIRONMENT_NAME");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/MsgHeader", "ENVIRONMENT_NAME"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.judget.MsgHeader
 * JD-Core Version:    0.7.0.1
 */