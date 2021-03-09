package com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv;

import com.cmcc.mss.msgheader.MsgHeader;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SB_FI_AP_InquiryPaymentJournalInfoSrvRequest", propOrder={"msgHeader", "journalnum", "startlastupdatedate", "endlastupdatedate", "ireserved1", "ireserved2", "ireserved3", "ireserved4", "ireserved5"})
public class SBFIAPInquiryPaymentJournalInfoSrvRequest
{
  @XmlElement(name="MsgHeader", required=true, nillable=true)
  protected MsgHeader msgHeader;
  @XmlElement(name="JOURNAL_NUM", required=true, nillable=true)
  protected String journalnum;
  @XmlElement(name="START_LAST_UPDATE_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar startlastupdatedate;
  @XmlElement(name="END_LAST_UPDATE_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar endlastupdatedate;
  @XmlElement(name="IRESERVED1", required=true, nillable=true)
  protected String ireserved1;
  @XmlElement(name="IRESERVED2", required=true, nillable=true)
  protected String ireserved2;
  @XmlElement(name="IRESERVED3", required=true, nillable=true)
  protected String ireserved3;
  @XmlElement(name="IRESERVED4", required=true, nillable=true)
  protected String ireserved4;
  @XmlElement(name="IRESERVED5", required=true, nillable=true)
  protected String ireserved5;
  
  public MsgHeader getMsgHeader()
  {
    return this.msgHeader;
  }
  
  public void setMsgHeader(MsgHeader paramMsgHeader)
  {
    this.msgHeader = paramMsgHeader;
  }
  
  public String getJOURNALNUM()
  {
    return this.journalnum;
  }
  
  public void setJOURNALNUM(String paramString)
  {
    this.journalnum = paramString;
  }
  
  public XMLGregorianCalendar getSTARTLASTUPDATEDATE()
  {
    return this.startlastupdatedate;
  }
  
  public void setSTARTLASTUPDATEDATE(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    this.startlastupdatedate = paramXMLGregorianCalendar;
  }
  
  public XMLGregorianCalendar getENDLASTUPDATEDATE()
  {
    return this.endlastupdatedate;
  }
  
  public void setENDLASTUPDATEDATE(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    this.endlastupdatedate = paramXMLGregorianCalendar;
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
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrvRequest
 * JD-Core Version:    0.7.0.1
 */