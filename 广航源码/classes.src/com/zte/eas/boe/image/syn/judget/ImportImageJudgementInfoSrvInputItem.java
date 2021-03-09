package com.zte.eas.boe.image.syn.judget;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class ImportImageJudgementInfoSrvInputItem
  implements Serializable
{
  private String PRI_KEY;
  private String BATCH_NAME;
  private String BOE_NUM;
  private String JUDGE_TYPE;
  private String PROBLEM;
  private String DETAILS;
  private String EMPLOYEE_NUM;
  private String IRESERVED_1;
  private String IRESERVED_2;
  private String IRESERVED_3;
  private String IRESERVED_4;
  private String IRESERVED_5;
  private Object __equalsCalc = null;
  private boolean __hashCodeCalc = false;
  private static TypeDesc typeDesc = new TypeDesc(ImportImageJudgementInfoSrvInputItem.class, true);
  
  public ImportImageJudgementInfoSrvInputItem() {}
  
  public ImportImageJudgementInfoSrvInputItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.PRI_KEY = paramString1;
    this.BATCH_NAME = paramString2;
    this.BOE_NUM = paramString3;
    this.JUDGE_TYPE = paramString4;
    this.PROBLEM = paramString5;
    this.DETAILS = paramString6;
    this.EMPLOYEE_NUM = paramString7;
    this.IRESERVED_1 = paramString8;
    this.IRESERVED_2 = paramString9;
    this.IRESERVED_3 = paramString10;
    this.IRESERVED_4 = paramString11;
    this.IRESERVED_5 = paramString12;
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
  
  public String getJUDGE_TYPE()
  {
    return this.JUDGE_TYPE;
  }
  
  public void setJUDGE_TYPE(String paramString)
  {
    this.JUDGE_TYPE = paramString;
  }
  
  public String getPROBLEM()
  {
    return this.PROBLEM;
  }
  
  public void setPROBLEM(String paramString)
  {
    this.PROBLEM = paramString;
  }
  
  public String getDETAILS()
  {
    return this.DETAILS;
  }
  
  public void setDETAILS(String paramString)
  {
    this.DETAILS = paramString;
  }
  
  public String getEMPLOYEE_NUM()
  {
    return this.EMPLOYEE_NUM;
  }
  
  public void setEMPLOYEE_NUM(String paramString)
  {
    this.EMPLOYEE_NUM = paramString;
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
    if (!(paramObject instanceof ImportImageJudgementInfoSrvInputItem)) {
      return false;
    }
    ImportImageJudgementInfoSrvInputItem localImportImageJudgementInfoSrvInputItem = (ImportImageJudgementInfoSrvInputItem)paramObject;
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
    boolean bool = ((this.PRI_KEY == null) && (localImportImageJudgementInfoSrvInputItem.getPRI_KEY() == null)) || ((this.PRI_KEY != null) && (this.PRI_KEY.equals(localImportImageJudgementInfoSrvInputItem.getPRI_KEY())) && (((this.BATCH_NAME == null) && (localImportImageJudgementInfoSrvInputItem.getBATCH_NAME() == null)) || ((this.BATCH_NAME != null) && (this.BATCH_NAME.equals(localImportImageJudgementInfoSrvInputItem.getBATCH_NAME())) && (((this.BOE_NUM == null) && (localImportImageJudgementInfoSrvInputItem.getBOE_NUM() == null)) || ((this.BOE_NUM != null) && (this.BOE_NUM.equals(localImportImageJudgementInfoSrvInputItem.getBOE_NUM())) && (((this.JUDGE_TYPE == null) && (localImportImageJudgementInfoSrvInputItem.getJUDGE_TYPE() == null)) || ((this.JUDGE_TYPE != null) && (this.JUDGE_TYPE.equals(localImportImageJudgementInfoSrvInputItem.getJUDGE_TYPE())) && (((this.PROBLEM == null) && (localImportImageJudgementInfoSrvInputItem.getPROBLEM() == null)) || ((this.PROBLEM != null) && (this.PROBLEM.equals(localImportImageJudgementInfoSrvInputItem.getPROBLEM())) && (((this.DETAILS == null) && (localImportImageJudgementInfoSrvInputItem.getDETAILS() == null)) || ((this.DETAILS != null) && (this.DETAILS.equals(localImportImageJudgementInfoSrvInputItem.getDETAILS())) && (((this.EMPLOYEE_NUM == null) && (localImportImageJudgementInfoSrvInputItem.getEMPLOYEE_NUM() == null)) || ((this.EMPLOYEE_NUM != null) && (this.EMPLOYEE_NUM.equals(localImportImageJudgementInfoSrvInputItem.getEMPLOYEE_NUM())) && (((this.IRESERVED_1 == null) && (localImportImageJudgementInfoSrvInputItem.getIRESERVED_1() == null)) || ((this.IRESERVED_1 != null) && (this.IRESERVED_1.equals(localImportImageJudgementInfoSrvInputItem.getIRESERVED_1())) && (((this.IRESERVED_2 == null) && (localImportImageJudgementInfoSrvInputItem.getIRESERVED_2() == null)) || ((this.IRESERVED_2 != null) && (this.IRESERVED_2.equals(localImportImageJudgementInfoSrvInputItem.getIRESERVED_2())) && (((this.IRESERVED_3 == null) && (localImportImageJudgementInfoSrvInputItem.getIRESERVED_3() == null)) || ((this.IRESERVED_3 != null) && (this.IRESERVED_3.equals(localImportImageJudgementInfoSrvInputItem.getIRESERVED_3())) && (((this.IRESERVED_4 == null) && (localImportImageJudgementInfoSrvInputItem.getIRESERVED_4() == null)) || ((this.IRESERVED_4 != null) && (this.IRESERVED_4.equals(localImportImageJudgementInfoSrvInputItem.getIRESERVED_4())) && (((this.IRESERVED_5 == null) && (localImportImageJudgementInfoSrvInputItem.getIRESERVED_5() == null)) || ((this.IRESERVED_5 != null) && (this.IRESERVED_5.equals(localImportImageJudgementInfoSrvInputItem.getIRESERVED_5())))))))))))))))))))))))));
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
    if (getJUDGE_TYPE() != null) {
      i += getJUDGE_TYPE().hashCode();
    }
    if (getPROBLEM() != null) {
      i += getPROBLEM().hashCode();
    }
    if (getDETAILS() != null) {
      i += getDETAILS().hashCode();
    }
    if (getEMPLOYEE_NUM() != null) {
      i += getEMPLOYEE_NUM().hashCode();
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
    typeDesc.setXmlType(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "ImportImageJudgementInfoSrvInputItem"));
    ElementDesc localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("PRI_KEY");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "PRI_KEY"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("BATCH_NAME");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "BATCH_NAME"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("BOE_NUM");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "BOE_NUM"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("JUDGE_TYPE");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "JUDGE_TYPE"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("PROBLEM");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "PROBLEM"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("DETAILS");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "DETAILS"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("EMPLOYEE_NUM");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "EMPLOYEE_NUM"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("IRESERVED_1");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "IRESERVED_1"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("IRESERVED_2");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "IRESERVED_2"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("IRESERVED_3");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "IRESERVED_3"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("IRESERVED_4");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "IRESERVED_4"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
    localElementDesc = new ElementDesc();
    localElementDesc.setFieldName("IRESERVED_5");
    localElementDesc.setXmlName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "IRESERVED_5"));
    localElementDesc.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localElementDesc.setNillable(true);
    typeDesc.addFieldDesc(localElementDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.judget.ImportImageJudgementInfoSrvInputItem
 * JD-Core Version:    0.7.0.1
 */