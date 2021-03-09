package com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="InquiryPaymentJournalInfoSrvOutputItem", propOrder={"orgid", "orgname", "setofbooks", "periodname", "vendornumber", "vendorname", "vendorsitecode", "headerid", "journalnum", "journalname", "journaltype", "checkname", "checkid", "checknum", "chequenum", "apjournalnum", "currencycode", "sourcecode", "orgcharge", "createdby", "createddate", "accountingdate", "approver", "approveddate", "attachmentnum", "lastupdatedate", "oreserved1", "oreserved2", "oreserved3", "oreserved4", "oreserved5", "oreserved6", "oreserved7", "oreserved8", "oreserved9", "oreserved10", "journalaccountinginfo"})
public class InquiryPaymentJournalInfoSrvOutputItem
{
  @XmlElement(name="ORG_ID", required=true, nillable=true)
  protected BigDecimal orgid;
  @XmlElement(name="ORG_NAME", required=true, nillable=true)
  protected String orgname;
  @XmlElement(name="SET_OF_BOOKS", required=true, nillable=true)
  protected String setofbooks;
  @XmlElement(name="PERIOD_NAME", required=true, nillable=true)
  protected String periodname;
  @XmlElement(name="VENDOR_NUMBER", required=true, nillable=true)
  protected String vendornumber;
  @XmlElement(name="VENDOR_NAME", required=true, nillable=true)
  protected String vendorname;
  @XmlElement(name="VENDOR_SITE_CODE", required=true, nillable=true)
  protected String vendorsitecode;
  @XmlElement(name="HEADER_ID", required=true, nillable=true)
  protected BigDecimal headerid;
  @XmlElement(name="JOURNAL_NUM", required=true, nillable=true)
  protected String journalnum;
  @XmlElement(name="JOURNAL_NAME", required=true, nillable=true)
  protected String journalname;
  @XmlElement(name="JOURNAL_TYPE", required=true, nillable=true)
  protected String journaltype;
  @XmlElement(name="CHECK_NAME", required=true, nillable=true)
  protected String checkname;
  @XmlElement(name="CHECK_ID", required=true, nillable=true)
  protected BigDecimal checkid;
  @XmlElement(name="CHECK_NUM", required=true, nillable=true)
  protected String checknum;
  @XmlElement(name="CHEQUE_NUM", required=true, nillable=true)
  protected String chequenum;
  @XmlElement(name="AP_JOURNAL_NUM", required=true, nillable=true)
  protected String apjournalnum;
  @XmlElement(name="CURRENCY_CODE", required=true, nillable=true)
  protected String currencycode;
  @XmlElement(name="SOURCE_CODE", required=true, nillable=true)
  protected String sourcecode;
  @XmlElement(name="ORG_CHARGE", required=true, nillable=true)
  protected String orgcharge;
  @XmlElement(name="CREATED_BY", required=true, nillable=true)
  protected String createdby;
  @XmlElement(name="CREATED_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar createddate;
  @XmlElement(name="ACCOUNTING_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar accountingdate;
  @XmlElement(name="APPROVER", required=true, nillable=true)
  protected String approver;
  @XmlElement(name="APPROVED_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar approveddate;
  @XmlElement(name="ATTACHMENT_NUM", required=true, nillable=true)
  protected BigDecimal attachmentnum;
  @XmlElement(name="LAST_UPDATE_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar lastupdatedate;
  @XmlElement(name="ORESERVED_1", required=true, nillable=true)
  protected String oreserved1;
  @XmlElement(name="ORESERVED_2", required=true, nillable=true)
  protected String oreserved2;
  @XmlElement(name="ORESERVED_3", required=true, nillable=true)
  protected String oreserved3;
  @XmlElement(name="ORESERVED_4", required=true, nillable=true)
  protected String oreserved4;
  @XmlElement(name="ORESERVED_5", required=true, nillable=true)
  protected String oreserved5;
  @XmlElement(name="ORESERVED_6", required=true, nillable=true)
  protected String oreserved6;
  @XmlElement(name="ORESERVED_7", required=true, nillable=true)
  protected String oreserved7;
  @XmlElement(name="ORESERVED_8", required=true, nillable=true)
  protected String oreserved8;
  @XmlElement(name="ORESERVED_9", required=true, nillable=true)
  protected String oreserved9;
  @XmlElement(name="ORESERVED_10", required=true, nillable=true)
  protected String oreserved10;
  @XmlElement(name="JOURNAL_ACCOUNTING_INFO", required=true, nillable=true)
  protected JournalAccountingInfoCollection journalaccountinginfo;
  
  public BigDecimal getORGID()
  {
    return this.orgid;
  }
  
  public void setORGID(BigDecimal paramBigDecimal)
  {
    this.orgid = paramBigDecimal;
  }
  
  public String getORGNAME()
  {
    return this.orgname;
  }
  
  public void setORGNAME(String paramString)
  {
    this.orgname = paramString;
  }
  
  public String getSETOFBOOKS()
  {
    return this.setofbooks;
  }
  
  public void setSETOFBOOKS(String paramString)
  {
    this.setofbooks = paramString;
  }
  
  public String getPERIODNAME()
  {
    return this.periodname;
  }
  
  public void setPERIODNAME(String paramString)
  {
    this.periodname = paramString;
  }
  
  public String getVENDORNUMBER()
  {
    return this.vendornumber;
  }
  
  public void setVENDORNUMBER(String paramString)
  {
    this.vendornumber = paramString;
  }
  
  public String getVENDORNAME()
  {
    return this.vendorname;
  }
  
  public void setVENDORNAME(String paramString)
  {
    this.vendorname = paramString;
  }
  
  public String getVENDORSITECODE()
  {
    return this.vendorsitecode;
  }
  
  public void setVENDORSITECODE(String paramString)
  {
    this.vendorsitecode = paramString;
  }
  
  public BigDecimal getHEADERID()
  {
    return this.headerid;
  }
  
  public void setHEADERID(BigDecimal paramBigDecimal)
  {
    this.headerid = paramBigDecimal;
  }
  
  public String getJOURNALNUM()
  {
    return this.journalnum;
  }
  
  public void setJOURNALNUM(String paramString)
  {
    this.journalnum = paramString;
  }
  
  public String getJOURNALNAME()
  {
    return this.journalname;
  }
  
  public void setJOURNALNAME(String paramString)
  {
    this.journalname = paramString;
  }
  
  public String getJOURNALTYPE()
  {
    return this.journaltype;
  }
  
  public void setJOURNALTYPE(String paramString)
  {
    this.journaltype = paramString;
  }
  
  public String getCHECKNAME()
  {
    return this.checkname;
  }
  
  public void setCHECKNAME(String paramString)
  {
    this.checkname = paramString;
  }
  
  public BigDecimal getCHECKID()
  {
    return this.checkid;
  }
  
  public void setCHECKID(BigDecimal paramBigDecimal)
  {
    this.checkid = paramBigDecimal;
  }
  
  public String getCHECKNUM()
  {
    return this.checknum;
  }
  
  public void setCHECKNUM(String paramString)
  {
    this.checknum = paramString;
  }
  
  public String getCHEQUENUM()
  {
    return this.chequenum;
  }
  
  public void setCHEQUENUM(String paramString)
  {
    this.chequenum = paramString;
  }
  
  public String getAPJOURNALNUM()
  {
    return this.apjournalnum;
  }
  
  public void setAPJOURNALNUM(String paramString)
  {
    this.apjournalnum = paramString;
  }
  
  public String getCURRENCYCODE()
  {
    return this.currencycode;
  }
  
  public void setCURRENCYCODE(String paramString)
  {
    this.currencycode = paramString;
  }
  
  public String getSOURCECODE()
  {
    return this.sourcecode;
  }
  
  public void setSOURCECODE(String paramString)
  {
    this.sourcecode = paramString;
  }
  
  public String getORGCHARGE()
  {
    return this.orgcharge;
  }
  
  public void setORGCHARGE(String paramString)
  {
    this.orgcharge = paramString;
  }
  
  public String getCREATEDBY()
  {
    return this.createdby;
  }
  
  public void setCREATEDBY(String paramString)
  {
    this.createdby = paramString;
  }
  
  public XMLGregorianCalendar getCREATEDDATE()
  {
    return this.createddate;
  }
  
  public void setCREATEDDATE(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    this.createddate = paramXMLGregorianCalendar;
  }
  
  public XMLGregorianCalendar getACCOUNTINGDATE()
  {
    return this.accountingdate;
  }
  
  public void setACCOUNTINGDATE(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    this.accountingdate = paramXMLGregorianCalendar;
  }
  
  public String getAPPROVER()
  {
    return this.approver;
  }
  
  public void setAPPROVER(String paramString)
  {
    this.approver = paramString;
  }
  
  public XMLGregorianCalendar getAPPROVEDDATE()
  {
    return this.approveddate;
  }
  
  public void setAPPROVEDDATE(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    this.approveddate = paramXMLGregorianCalendar;
  }
  
  public BigDecimal getATTACHMENTNUM()
  {
    return this.attachmentnum;
  }
  
  public void setATTACHMENTNUM(BigDecimal paramBigDecimal)
  {
    this.attachmentnum = paramBigDecimal;
  }
  
  public XMLGregorianCalendar getLASTUPDATEDATE()
  {
    return this.lastupdatedate;
  }
  
  public void setLASTUPDATEDATE(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    this.lastupdatedate = paramXMLGregorianCalendar;
  }
  
  public String getORESERVED1()
  {
    return this.oreserved1;
  }
  
  public void setORESERVED1(String paramString)
  {
    this.oreserved1 = paramString;
  }
  
  public String getORESERVED2()
  {
    return this.oreserved2;
  }
  
  public void setORESERVED2(String paramString)
  {
    this.oreserved2 = paramString;
  }
  
  public String getORESERVED3()
  {
    return this.oreserved3;
  }
  
  public void setORESERVED3(String paramString)
  {
    this.oreserved3 = paramString;
  }
  
  public String getORESERVED4()
  {
    return this.oreserved4;
  }
  
  public void setORESERVED4(String paramString)
  {
    this.oreserved4 = paramString;
  }
  
  public String getORESERVED5()
  {
    return this.oreserved5;
  }
  
  public void setORESERVED5(String paramString)
  {
    this.oreserved5 = paramString;
  }
  
  public String getORESERVED6()
  {
    return this.oreserved6;
  }
  
  public void setORESERVED6(String paramString)
  {
    this.oreserved6 = paramString;
  }
  
  public String getORESERVED7()
  {
    return this.oreserved7;
  }
  
  public void setORESERVED7(String paramString)
  {
    this.oreserved7 = paramString;
  }
  
  public String getORESERVED8()
  {
    return this.oreserved8;
  }
  
  public void setORESERVED8(String paramString)
  {
    this.oreserved8 = paramString;
  }
  
  public String getORESERVED9()
  {
    return this.oreserved9;
  }
  
  public void setORESERVED9(String paramString)
  {
    this.oreserved9 = paramString;
  }
  
  public String getORESERVED10()
  {
    return this.oreserved10;
  }
  
  public void setORESERVED10(String paramString)
  {
    this.oreserved10 = paramString;
  }
  
  public JournalAccountingInfoCollection getJOURNALACCOUNTINGINFO()
  {
    return this.journalaccountinginfo;
  }
  
  public void setJOURNALACCOUNTINGINFO(JournalAccountingInfoCollection paramJournalAccountingInfoCollection)
  {
    this.journalaccountinginfo = paramJournalAccountingInfoCollection;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.InquiryPaymentJournalInfoSrvOutputItem
 * JD-Core Version:    0.7.0.1
 */