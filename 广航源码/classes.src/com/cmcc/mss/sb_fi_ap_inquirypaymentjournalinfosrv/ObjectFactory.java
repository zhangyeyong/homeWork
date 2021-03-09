package com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _SBFIAPInquiryPaymentJournalInfoSrvResponse_QNAME = new QName("http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv", "SB_FI_AP_InquiryPaymentJournalInfoSrvResponse");
  private static final QName _SBFIAPInquiryPaymentJournalInfoSrvRequest_QNAME = new QName("http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv", "SB_FI_AP_InquiryPaymentJournalInfoSrvRequest");
  
  public SBFIAPInquiryPaymentJournalInfoSrvResponse createSBFIAPInquiryPaymentJournalInfoSrvResponse()
  {
    return new SBFIAPInquiryPaymentJournalInfoSrvResponse();
  }
  
  public SBFIAPInquiryPaymentJournalInfoSrvRequest createSBFIAPInquiryPaymentJournalInfoSrvRequest()
  {
    return new SBFIAPInquiryPaymentJournalInfoSrvRequest();
  }
  
  public JournalAccountingInfoItem createJournalAccountingInfoItem()
  {
    return new JournalAccountingInfoItem();
  }
  
  public JournalAccountingInfoCollection createJournalAccountingInfoCollection()
  {
    return new JournalAccountingInfoCollection();
  }
  
  public InquiryPaymentJournalInfoSrvOutputItem createInquiryPaymentJournalInfoSrvOutputItem()
  {
    return new InquiryPaymentJournalInfoSrvOutputItem();
  }
  
  public InquiryPaymentJournalInfoSrvOutputCollection createInquiryPaymentJournalInfoSrvOutputCollection()
  {
    return new InquiryPaymentJournalInfoSrvOutputCollection();
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv", name="SB_FI_AP_InquiryPaymentJournalInfoSrvResponse")
  public JAXBElement<SBFIAPInquiryPaymentJournalInfoSrvResponse> createSBFIAPInquiryPaymentJournalInfoSrvResponse(SBFIAPInquiryPaymentJournalInfoSrvResponse paramSBFIAPInquiryPaymentJournalInfoSrvResponse)
  {
    return new JAXBElement(_SBFIAPInquiryPaymentJournalInfoSrvResponse_QNAME, SBFIAPInquiryPaymentJournalInfoSrvResponse.class, null, paramSBFIAPInquiryPaymentJournalInfoSrvResponse);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv", name="SB_FI_AP_InquiryPaymentJournalInfoSrvRequest")
  public JAXBElement<SBFIAPInquiryPaymentJournalInfoSrvRequest> createSBFIAPInquiryPaymentJournalInfoSrvRequest(SBFIAPInquiryPaymentJournalInfoSrvRequest paramSBFIAPInquiryPaymentJournalInfoSrvRequest)
  {
    return new JAXBElement(_SBFIAPInquiryPaymentJournalInfoSrvRequest_QNAME, SBFIAPInquiryPaymentJournalInfoSrvRequest.class, null, paramSBFIAPInquiryPaymentJournalInfoSrvRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */