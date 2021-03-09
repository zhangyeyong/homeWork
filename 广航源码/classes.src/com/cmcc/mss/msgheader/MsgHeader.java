package com.cmcc.mss.msgheader;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="MsgHeader", propOrder={"sourcesystemid", "sourcesystemname", "userid", "username", "submitdate", "pagesize", "currentpage", "totalrecord", "provincecode", "environmentname"})
public class MsgHeader
{
  @XmlElement(name="SOURCE_SYSTEM_ID", required=true, nillable=true)
  protected String sourcesystemid;
  @XmlElement(name="SOURCE_SYSTEM_NAME", required=true, nillable=true)
  protected String sourcesystemname;
  @XmlElement(name="USER_ID", required=true, nillable=true)
  protected String userid;
  @XmlElement(name="USER_NAME", required=true, nillable=true)
  protected String username;
  @XmlElement(name="SUBMIT_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar submitdate;
  @XmlElement(name="PAGE_SIZE", required=true, nillable=true)
  protected BigDecimal pagesize;
  @XmlElement(name="CURRENT_PAGE", required=true, nillable=true)
  protected BigDecimal currentpage;
  @XmlElement(name="TOTAL_RECORD", required=true, nillable=true)
  protected BigDecimal totalrecord;
  @XmlElement(name="PROVINCE_CODE", required=true, nillable=true)
  protected String provincecode;
  @XmlElement(name="ENVIRONMENT_NAME", required=true, nillable=true)
  protected String environmentname;
  
  public String getSOURCESYSTEMID()
  {
    return this.sourcesystemid;
  }
  
  public void setSOURCESYSTEMID(String paramString)
  {
    this.sourcesystemid = paramString;
  }
  
  public String getSOURCESYSTEMNAME()
  {
    return this.sourcesystemname;
  }
  
  public void setSOURCESYSTEMNAME(String paramString)
  {
    this.sourcesystemname = paramString;
  }
  
  public String getUSERID()
  {
    return this.userid;
  }
  
  public void setUSERID(String paramString)
  {
    this.userid = paramString;
  }
  
  public String getUSERNAME()
  {
    return this.username;
  }
  
  public void setUSERNAME(String paramString)
  {
    this.username = paramString;
  }
  
  public XMLGregorianCalendar getSUBMITDATE()
  {
    return this.submitdate;
  }
  
  public void setSUBMITDATE(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    this.submitdate = paramXMLGregorianCalendar;
  }
  
  public BigDecimal getPAGESIZE()
  {
    return this.pagesize;
  }
  
  public void setPAGESIZE(BigDecimal paramBigDecimal)
  {
    this.pagesize = paramBigDecimal;
  }
  
  public BigDecimal getCURRENTPAGE()
  {
    return this.currentpage;
  }
  
  public void setCURRENTPAGE(BigDecimal paramBigDecimal)
  {
    this.currentpage = paramBigDecimal;
  }
  
  public BigDecimal getTOTALRECORD()
  {
    return this.totalrecord;
  }
  
  public void setTOTALRECORD(BigDecimal paramBigDecimal)
  {
    this.totalrecord = paramBigDecimal;
  }
  
  public String getPROVINCECODE()
  {
    return this.provincecode;
  }
  
  public void setPROVINCECODE(String paramString)
  {
    this.provincecode = paramString;
  }
  
  public String getENVIRONMENTNAME()
  {
    return this.environmentname;
  }
  
  public void setENVIRONMENTNAME(String paramString)
  {
    this.environmentname = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.msgheader.MsgHeader
 * JD-Core Version:    0.7.0.1
 */