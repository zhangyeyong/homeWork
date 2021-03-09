package com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SB_FI_AP_InquiryAPJournalInfoSrvResponse", propOrder={"serviceflag", "servicemessage", "instanceid", "inquiryAPJournalInfoSrvOutputCollection"})
public class SBFIAPInquiryAPJournalInfoSrvResponse
{
  @XmlElement(name="SERVICE_FLAG", required=true, nillable=true)
  protected String serviceflag;
  @XmlElement(name="SERVICE_MESSAGE", required=true, nillable=true)
  protected String servicemessage;
  @XmlElement(name="INSTANCE_ID", required=true, nillable=true)
  protected String instanceid;
  @XmlElement(name="InquiryAPJournalInfoSrvOutputCollection", required=true, nillable=true)
  protected InquiryAPJournalInfoSrvOutputCollection inquiryAPJournalInfoSrvOutputCollection;
  
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
  
  public String getINSTANCEID()
  {
    return this.instanceid;
  }
  
  public void setINSTANCEID(String paramString)
  {
    this.instanceid = paramString;
  }
  
  public InquiryAPJournalInfoSrvOutputCollection getInquiryAPJournalInfoSrvOutputCollection()
  {
    return this.inquiryAPJournalInfoSrvOutputCollection;
  }
  
  public void setInquiryAPJournalInfoSrvOutputCollection(InquiryAPJournalInfoSrvOutputCollection paramInquiryAPJournalInfoSrvOutputCollection)
  {
    this.inquiryAPJournalInfoSrvOutputCollection = paramInquiryAPJournalInfoSrvOutputCollection;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrvResponse
 * JD-Core Version:    0.7.0.1
 */