package com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="PageInquiryGLJournalInfoSrvOutputItem", propOrder={"orgid", "orgname", "setofbooks", "periodname", "headerid", "journalnum", "gljournalname", "journaltype", "batchname", "journalname", "docsequence", "currencycode", "source", "sourcecode", "orgcharge", "createdby", "createddate", "accountingdate", "approver", "approveddate", "attachmentnum", "lastupdatedate", "journalaccountinginfo"})
public class PageInquiryGLJournalInfoSrvOutputItem
{
  @XmlElement(name="ORG_ID", required=true, nillable=true)
  protected BigDecimal orgid;
  @XmlElement(name="ORG_NAME", required=true, nillable=true)
  protected String orgname;
  @XmlElement(name="SET_OF_BOOKS", required=true, nillable=true)
  protected String setofbooks;
  @XmlElement(name="PERIOD_NAME", required=true, nillable=true)
  protected String periodname;
  @XmlElement(name="HEADER_ID", required=true, nillable=true)
  protected BigDecimal headerid;
  @XmlElement(name="JOURNAL_NUM", required=true, nillable=true)
  protected String journalnum;
  @XmlElement(name="GL_JOURNAL_NAME", required=true, nillable=true)
  protected String gljournalname;
  @XmlElement(name="JOURNAL_TYPE", required=true, nillable=true)
  protected String journaltype;
  @XmlElement(name="BATCH_NAME", required=true, nillable=true)
  protected String batchname;
  @XmlElement(name="JOURNAL_NAME", required=true, nillable=true)
  protected String journalname;
  @XmlElement(name="DOC_SEQUENCE", required=true, nillable=true)
  protected BigDecimal docsequence;
  @XmlElement(name="CURRENCY_CODE", required=true, nillable=true)
  protected String currencycode;
  @XmlElement(name="SOURCE", required=true, nillable=true)
  protected String source;
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
  
  public String getGLJOURNALNAME()
  {
    return this.gljournalname;
  }
  
  public void setGLJOURNALNAME(String paramString)
  {
    this.gljournalname = paramString;
  }
  
  public String getJOURNALTYPE()
  {
    return this.journaltype;
  }
  
  public void setJOURNALTYPE(String paramString)
  {
    this.journaltype = paramString;
  }
  
  public String getBATCHNAME()
  {
    return this.batchname;
  }
  
  public void setBATCHNAME(String paramString)
  {
    this.batchname = paramString;
  }
  
  public String getJOURNALNAME()
  {
    return this.journalname;
  }
  
  public void setJOURNALNAME(String paramString)
  {
    this.journalname = paramString;
  }
  
  public BigDecimal getDOCSEQUENCE()
  {
    return this.docsequence;
  }
  
  public void setDOCSEQUENCE(BigDecimal paramBigDecimal)
  {
    this.docsequence = paramBigDecimal;
  }
  
  public String getCURRENCYCODE()
  {
    return this.currencycode;
  }
  
  public void setCURRENCYCODE(String paramString)
  {
    this.currencycode = paramString;
  }
  
  public String getSOURCE()
  {
    return this.source;
  }
  
  public void setSOURCE(String paramString)
  {
    this.source = paramString;
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
 * Qualified Name:     com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.PageInquiryGLJournalInfoSrvOutputItem
 * JD-Core Version:    0.7.0.1
 */