package com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ImportImageOperationInfoSrvInputItem", propOrder={"prikey", "batchname", "boenum", "operationtype", "operationdate", "ireserved1", "ireserved2", "ireserved3", "ireserved4", "ireserved5"})
public class ImportImageOperationInfoSrvInputItem
{
  @XmlElement(name="PRI_KEY", required=true, nillable=true)
  protected String prikey;
  @XmlElement(name="BATCH_NAME", required=true, nillable=true)
  protected String batchname;
  @XmlElement(name="BOE_NUM", required=true, nillable=true)
  protected String boenum;
  @XmlElement(name="OPERATION_TYPE", required=true, nillable=true)
  protected String operationtype;
  @XmlElement(name="OPERATION_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar operationdate;
  @XmlElement(name="IRESERVED_1", required=true, nillable=true)
  protected String ireserved1;
  @XmlElement(name="IRESERVED_2", required=true, nillable=true)
  protected String ireserved2;
  @XmlElement(name="IRESERVED_3", required=true, nillable=true)
  protected String ireserved3;
  @XmlElement(name="IRESERVED_4", required=true, nillable=true)
  protected String ireserved4;
  @XmlElement(name="IRESERVED_5", required=true, nillable=true)
  protected String ireserved5;
  
  public String getPRIKEY()
  {
    return this.prikey;
  }
  
  public void setPRIKEY(String paramString)
  {
    this.prikey = paramString;
  }
  
  public String getBATCHNAME()
  {
    return this.batchname;
  }
  
  public void setBATCHNAME(String paramString)
  {
    this.batchname = paramString;
  }
  
  public String getBOENUM()
  {
    return this.boenum;
  }
  
  public void setBOENUM(String paramString)
  {
    this.boenum = paramString;
  }
  
  public String getOPERATIONTYPE()
  {
    return this.operationtype;
  }
  
  public void setOPERATIONTYPE(String paramString)
  {
    this.operationtype = paramString;
  }
  
  public XMLGregorianCalendar getOPERATIONDATE()
  {
    return this.operationdate;
  }
  
  public void setOPERATIONDATE(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    this.operationdate = paramXMLGregorianCalendar;
  }
  
  public String getIRESERVED1()
  {
    return this.ireserved1;
  }
  
  public void setIRESERVED1(String paramString)
  {
    this.ireserved1 = paramString;
  }
  
  public String getIRESERVED2()
  {
    return this.ireserved2;
  }
  
  public void setIRESERVED2(String paramString)
  {
    this.ireserved2 = paramString;
  }
  
  public String getIRESERVED3()
  {
    return this.ireserved3;
  }
  
  public void setIRESERVED3(String paramString)
  {
    this.ireserved3 = paramString;
  }
  
  public String getIRESERVED4()
  {
    return this.ireserved4;
  }
  
  public void setIRESERVED4(String paramString)
  {
    this.ireserved4 = paramString;
  }
  
  public String getIRESERVED5()
  {
    return this.ireserved5;
  }
  
  public void setIRESERVED5(String paramString)
  {
    this.ireserved5 = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.ImportImageOperationInfoSrvInputItem
 * JD-Core Version:    0.7.0.1
 */