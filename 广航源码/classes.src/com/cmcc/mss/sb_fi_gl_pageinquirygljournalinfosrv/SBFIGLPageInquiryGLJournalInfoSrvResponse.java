package com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SB_FI_GL_PageInquiryGLJournalInfoSrvResponse", propOrder={"serviceflag", "servicemessage", "totalrecord", "totalpage", "pagesize", "currentpage", "instanceid", "pageInquiryGLJournalInfoSrvOutputCollection"})
public class SBFIGLPageInquiryGLJournalInfoSrvResponse
{
  @XmlElement(name="SERVICE_FLAG", required=true, nillable=true)
  protected String serviceflag;
  @XmlElement(name="SERVICE_MESSAGE", required=true, nillable=true)
  protected String servicemessage;
  @XmlElement(name="TOTAL_RECORD", required=true, nillable=true)
  protected BigDecimal totalrecord;
  @XmlElement(name="TOTAL_PAGE", required=true, nillable=true)
  protected BigDecimal totalpage;
  @XmlElement(name="PAGE_SIZE", required=true, nillable=true)
  protected BigDecimal pagesize;
  @XmlElement(name="CURRENT_PAGE", required=true, nillable=true)
  protected BigDecimal currentpage;
  @XmlElement(name="INSTANCE_ID", required=true, nillable=true)
  protected String instanceid;
  @XmlElement(name="PageInquiryGLJournalInfoSrvOutputCollection", required=true, nillable=true)
  protected PageInquiryGLJournalInfoSrvOutputCollection pageInquiryGLJournalInfoSrvOutputCollection;
  
  public String getSERVICEFLAG()
  {
    return this.serviceflag;
  }
  
  public void setSERVICEFLAG(String paramString)
  {
    this.serviceflag = paramString;
  }
  
  public String getSERVICEMESSAGE()
  {
    return this.servicemessage;
  }
  
  public void setSERVICEMESSAGE(String paramString)
  {
    this.servicemessage = paramString;
  }
  
  public BigDecimal getTOTALRECORD()
  {
    return this.totalrecord;
  }
  
  public void setTOTALRECORD(BigDecimal paramBigDecimal)
  {
    this.totalrecord = paramBigDecimal;
  }
  
  public BigDecimal getTOTALPAGE()
  {
    return this.totalpage;
  }
  
  public void setTOTALPAGE(BigDecimal paramBigDecimal)
  {
    this.totalpage = paramBigDecimal;
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
  
  public String getINSTANCEID()
  {
    return this.instanceid;
  }
  
  public void setINSTANCEID(String paramString)
  {
    this.instanceid = paramString;
  }
  
  public PageInquiryGLJournalInfoSrvOutputCollection getPageInquiryGLJournalInfoSrvOutputCollection()
  {
    return this.pageInquiryGLJournalInfoSrvOutputCollection;
  }
  
  public void setPageInquiryGLJournalInfoSrvOutputCollection(PageInquiryGLJournalInfoSrvOutputCollection paramPageInquiryGLJournalInfoSrvOutputCollection)
  {
    this.pageInquiryGLJournalInfoSrvOutputCollection = paramPageInquiryGLJournalInfoSrvOutputCollection;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrvResponse
 * JD-Core Version:    0.7.0.1
 */