package com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _SBFIAPInquiryAPJournalInfoSrvResponse_QNAME = new QName("http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv", "SB_FI_AP_InquiryAPJournalInfoSrvResponse");
  private static final QName _SBFIAPInquiryAPJournalInfoSrvRequest_QNAME = new QName("http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv", "SB_FI_AP_InquiryAPJournalInfoSrvRequest");
  
  public SBFIAPInquiryAPJournalInfoSrvResponse createSBFIAPInquiryAPJournalInfoSrvResponse()
  {
    return new SBFIAPInquiryAPJournalInfoSrvResponse();
  }
  
  public InquiryAPJournalInfoSrvOutputCollection createInquiryAPJournalInfoSrvOutputCollection()
  {
    return new InquiryAPJournalInfoSrvOutputCollection();
  }
  
  public SBFIAPInquiryAPJournalInfoSrvRequest createSBFIAPInquiryAPJournalInfoSrvRequest()
  {
    return new SBFIAPInquiryAPJournalInfoSrvRequest();
  }
  
  public JournalAccountingInfoCollection createJournalAccountingInfoCollection()
  {
    return new JournalAccountingInfoCollection();
  }
  
  public InquiryAPJournalInfoSrvOutputItem createInquiryAPJournalInfoSrvOutputItem()
  {
    return new InquiryAPJournalInfoSrvOutputItem();
  }
  
  public JournalAccountingInfoItem createJournalAccountingInfoItem()
  {
    return new JournalAccountingInfoItem();
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv", name="SB_FI_AP_InquiryAPJournalInfoSrvResponse")
  public JAXBElement<SBFIAPInquiryAPJournalInfoSrvResponse> createSBFIAPInquiryAPJournalInfoSrvResponse(SBFIAPInquiryAPJournalInfoSrvResponse paramSBFIAPInquiryAPJournalInfoSrvResponse)
  {
    return new JAXBElement(_SBFIAPInquiryAPJournalInfoSrvResponse_QNAME, SBFIAPInquiryAPJournalInfoSrvResponse.class, null, paramSBFIAPInquiryAPJournalInfoSrvResponse);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv", name="SB_FI_AP_InquiryAPJournalInfoSrvRequest")
  public JAXBElement<SBFIAPInquiryAPJournalInfoSrvRequest> createSBFIAPInquiryAPJournalInfoSrvRequest(SBFIAPInquiryAPJournalInfoSrvRequest paramSBFIAPInquiryAPJournalInfoSrvRequest)
  {
    return new JAXBElement(_SBFIAPInquiryAPJournalInfoSrvRequest_QNAME, SBFIAPInquiryAPJournalInfoSrvRequest.class, null, paramSBFIAPInquiryAPJournalInfoSrvRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */