package com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SB_FI_AP_InquiryPaymentJournalInfoSrvResponse", propOrder={"serviceflag", "servicemessage", "instanceid", "inquiryPaymentJournalInfoSrvOutputCollection"})
public class SBFIAPInquiryPaymentJournalInfoSrvResponse
{
  @XmlElement(name="SERVICE_FLAG", required=true, nillable=true)
  protected String serviceflag;
  @XmlElement(name="SERVICE_MESSAGE", required=true, nillable=true)
  protected String servicemessage;
  @XmlElement(name="INSTANCE_ID", required=true, nillable=true)
  protected String instanceid;
  @XmlElement(name="InquiryPaymentJournalInfoSrvOutputCollection", required=true, nillable=true)
  protected InquiryPaymentJournalInfoSrvOutputCollection inquiryPaymentJournalInfoSrvOutputCollection;
  
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
  
  public InquiryPaymentJournalInfoSrvOutputCollection getInquiryPaymentJournalInfoSrvOutputCollection()
  {
    return this.inquiryPaymentJournalInfoSrvOutputCollection;
  }
  
  public void setInquiryPaymentJournalInfoSrvOutputCollection(InquiryPaymentJournalInfoSrvOutputCollection paramInquiryPaymentJournalInfoSrvOutputCollection)
  {
    this.inquiryPaymentJournalInfoSrvOutputCollection = paramInquiryPaymentJournalInfoSrvOutputCollection;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrvResponse
 * JD-Core Version:    0.7.0.1
 */