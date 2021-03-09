package com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv;

import com.cmcc.mss.msgheader.MsgHeader;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SB_EAS_EAS_InquiryUsersInfoSrvRequest", propOrder={"msgHeader", "employeenum", "employeename", "startlastupdatedate", "endlastupdatedate", "ireserved1", "ireserved2", "ireserved3", "ireserved4", "ireserved5"})
public class SBEASEASInquiryUsersInfoSrvRequest
{
  @XmlElement(name="MsgHeader", required=true, nillable=true)
  protected MsgHeader msgHeader;
  @XmlElement(name="EMPLOYEE_NUM", required=true, nillable=true)
  protected String employeenum;
  @XmlElement(name="EMPLOYEE_NAME", required=true, nillable=true)
  protected String employeename;
  @XmlElement(name="START_LAST_UPDATE_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar startlastupdatedate;
  @XmlElement(name="END_LAST_UPDATE_DATE", required=true, nillable=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar endlastupdatedate;
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
  
  public MsgHeader getMsgHeader()
  {
    return this.msgHeader;
  }
  
  public void setMsgHeader(MsgHeader paramMsgHeader)
  {
    this.msgHeader = paramMsgHeader;
  }
  
  public String getEMPLOYEENUM()
  {
    return this.employeenum;
  }
  
  public void setEMPLOYEENUM(String paramString)
  {
    this.employeenum = paramString;
  }
  
  public String getEMPLOYEENAME()
  {
    return this.employeename;
  }
  
  public void setEMPLOYEENAME(String paramString)
  {
    this.employeename = paramString;
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
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.SBEASEASInquiryUsersInfoSrvRequest
 * JD-Core Version:    0.7.0.1
 */