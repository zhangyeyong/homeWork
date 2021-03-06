package com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="InquiryUsersInfoSrvOutputItem", propOrder={"employeenum", "employeename", "deptid", "oaaddress", "mobilephone", "emailaddress", "password", "enabledflag", "lastupdatedate", "oreserved1", "oreserved2", "oreserved3", "oreserved4", "oreserved5", "oreserved6", "oreserved7", "oreserved8", "oreserved9", "oreserved10"})
public class InquiryUsersInfoSrvOutputItem
{
  @XmlElement(name="EMPLOYEE_NUM", required=true, nillable=true)
  protected String employeenum;
  @XmlElement(name="EMPLOYEE_NAME", required=true, nillable=true)
  protected String employeename;
  @XmlElement(name="DEPT_ID", required=true, nillable=true)
  protected BigDecimal deptid;
  @XmlElement(name="OA_ADDRESS", required=true, nillable=true)
  protected String oaaddress;
  @XmlElement(name="MOBILE_PHONE", required=true, nillable=true)
  protected String mobilephone;
  @XmlElement(name="EMAIL_ADDRESS", required=true, nillable=true)
  protected String emailaddress;
  @XmlElement(name="PASSWORD", required=true, nillable=true)
  protected String password;
  @XmlElement(name="ENABLED_FLAG", required=true, nillable=true)
  protected String enabledflag;
  @XmlElement(name="LAST_UPDATE_DATE", required=true, nillable=true)
  protected String lastupdatedate;
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
  
  public BigDecimal getDEPTID()
  {
    return this.deptid;
  }
  
  public void setDEPTID(BigDecimal paramBigDecimal)
  {
    this.deptid = paramBigDecimal;
  }
  
  public String getOAADDRESS()
  {
    return this.oaaddress;
  }
  
  public void setOAADDRESS(String paramString)
  {
    this.oaaddress = paramString;
  }
  
  public String getMOBILEPHONE()
  {
    return this.mobilephone;
  }
  
  public void setMOBILEPHONE(String paramString)
  {
    this.mobilephone = paramString;
  }
  
  public String getEMAILADDRESS()
  {
    return this.emailaddress;
  }
  
  public void setEMAILADDRESS(String paramString)
  {
    this.emailaddress = paramString;
  }
  
  public String getPASSWORD()
  {
    return this.password;
  }
  
  public void setPASSWORD(String paramString)
  {
    this.password = paramString;
  }
  
  public String getENABLEDFLAG()
  {
    return this.enabledflag;
  }
  
  public void setENABLEDFLAG(String paramString)
  {
    this.enabledflag = paramString;
  }
  
  public String getLASTUPDATEDATE()
  {
    return this.lastupdatedate;
  }
  
  public void setLASTUPDATEDATE(String paramString)
  {
    this.lastupdatedate = paramString;
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
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.InquiryUsersInfoSrvOutputItem
 * JD-Core Version:    0.7.0.1
 */