package com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="JournalAccountingInfoItem", propOrder={"lineid", "linenum", "linedesc", "codecombinationid", "accountdesc", "exchangerate", "accounteddr", "accountedcr", "lastupdatedate"})
public class JournalAccountingInfoItem
{
  @XmlElement(name="LINE_ID", required=true, nillable=true)
  protected BigDecimal lineid;
  @XmlElement(name="LINE_NUM", required=true, nillable=true)
  protected BigDecimal linenum;
  @XmlElement(name="LINE_DESC", required=true, nillable=true)
  protected String linedesc;
  @XmlElement(name="CODE_COMBINATION_ID", required=true, nillable=true)
  protected BigDecimal codecombinationid;
  @XmlElement(name="ACCOUNT_DESC", required=true, nillable=true)
  protected String accountdesc;
  @XmlElement(name="EXCHANGE_RATE", required=true, nillable=true)
  protected String exchangerate;
  @XmlElement(name="ACCOUNTED_DR", required=true, nillable=true)
  protected BigDecimal accounteddr;
  @XmlElement(name="ACCOUNTED_CR", required=true, nillable=true)
  protected BigDecimal accountedcr;
  @XmlElement(name="LAST_UPDATE_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar lastupdatedate;
  
  public BigDecimal getLINEID()
  {
    return this.lineid;
  }
  
  public void setLINEID(BigDecimal paramBigDecimal)
  {
    this.lineid = paramBigDecimal;
  }
  
  public BigDecimal getLINENUM()
  {
    return this.linenum;
  }
  
  public void setLINENUM(BigDecimal paramBigDecimal)
  {
    this.linenum = paramBigDecimal;
  }
  
  public String getLINEDESC()
  {
    return this.linedesc;
  }
  
  public void setLINEDESC(String paramString)
  {
    this.linedesc = paramString;
  }
  
  public BigDecimal getCODECOMBINATIONID()
  {
    return this.codecombinationid;
  }
  
  public void setCODECOMBINATIONID(BigDecimal paramBigDecimal)
  {
    this.codecombinationid = paramBigDecimal;
  }
  
  public String getACCOUNTDESC()
  {
    return this.accountdesc;
  }
  
  public void setACCOUNTDESC(String paramString)
  {
    this.accountdesc = paramString;
  }
  
  public String getEXCHANGERATE()
  {
    return this.exchangerate;
  }
  
  public void setEXCHANGERATE(String paramString)
  {
    this.exchangerate = paramString;
  }
  
  public BigDecimal getACCOUNTEDDR()
  {
    return this.accounteddr;
  }
  
  public void setACCOUNTEDDR(BigDecimal paramBigDecimal)
  {
    this.accounteddr = paramBigDecimal;
  }
  
  public BigDecimal getACCOUNTEDCR()
  {
    return this.accountedcr;
  }
  
  public void setACCOUNTEDCR(BigDecimal paramBigDecimal)
  {
    this.accountedcr = paramBigDecimal;
  }
  
  public XMLGregorianCalendar getLASTUPDATEDATE()
  {
    return this.lastupdatedate;
  }
  
  public void setLASTUPDATEDATE(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    this.lastupdatedate = paramXMLGregorianCalendar;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.JournalAccountingInfoItem
 * JD-Core Version:    0.7.0.1
 */