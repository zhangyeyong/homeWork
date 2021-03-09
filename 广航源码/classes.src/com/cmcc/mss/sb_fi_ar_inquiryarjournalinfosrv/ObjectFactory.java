package com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _SBFIARInquiryARJournalInfoSrvResponse_QNAME = new QName("http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv", "SB_FI_AR_InquiryARJournalInfoSrvResponse");
  private static final QName _SBFIARInquiryARJournalInfoSrvRequest_QNAME = new QName("http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv", "SB_FI_AR_InquiryARJournalInfoSrvRequest");
  
  public InquiryARJournalInfoSrvOutputItem createInquiryARJournalInfoSrvOutputItem()
  {
    return new InquiryARJournalInfoSrvOutputItem();
  }
  
  public JournalAccountingInfoItem createJournalAccountingInfoItem()
  {
    return new JournalAccountingInfoItem();
  }
  
  public SBFIARInquiryARJournalInfoSrvResponse createSBFIARInquiryARJournalInfoSrvResponse()
  {
    return new SBFIARInquiryARJournalInfoSrvResponse();
  }
  
  public SBFIARInquiryARJournalInfoSrvRequest createSBFIARInquiryARJournalInfoSrvRequest()
  {
    return new SBFIARInquiryARJournalInfoSrvRequest();
  }
  
  public InquiryARJournalInfoSrvOutputCollection createInquiryARJournalInfoSrvOutputCollection()
  {
    return new InquiryARJournalInfoSrvOutputCollection();
  }
  
  public JournalAccountingInfoCollection createJournalAccountingInfoCollection()
  {
    return new JournalAccountingInfoCollection();
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv", name="SB_FI_AR_InquiryARJournalInfoSrvResponse")
  public JAXBElement<SBFIARInquiryARJournalInfoSrvResponse> createSBFIARInquiryARJournalInfoSrvResponse(SBFIARInquiryARJournalInfoSrvResponse paramSBFIARInquiryARJournalInfoSrvResponse)
  {
    return new JAXBElement(_SBFIARInquiryARJournalInfoSrvResponse_QNAME, SBFIARInquiryARJournalInfoSrvResponse.class, null, paramSBFIARInquiryARJournalInfoSrvResponse);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv", name="SB_FI_AR_InquiryARJournalInfoSrvRequest")
  public JAXBElement<SBFIARInquiryARJournalInfoSrvRequest> createSBFIARInquiryARJournalInfoSrvRequest(SBFIARInquiryARJournalInfoSrvRequest paramSBFIARInquiryARJournalInfoSrvRequest)
  {
    return new JAXBElement(_SBFIARInquiryARJournalInfoSrvRequest_QNAME, SBFIARInquiryARJournalInfoSrvRequest.class, null, paramSBFIARInquiryARJournalInfoSrvRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */