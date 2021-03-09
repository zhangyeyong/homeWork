package com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _SBFIARInquiryReceiptJournalInfoSrvResponse_QNAME = new QName("http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv", "SB_FI_AR_InquiryReceiptJournalInfoSrvResponse");
  private static final QName _SBFIARInquiryReceiptJournalInfoSrvRequest_QNAME = new QName("http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv", "SB_FI_AR_InquiryReceiptJournalInfoSrvRequest");
  
  public SBFIARInquiryReceiptJournalInfoSrvRequest createSBFIARInquiryReceiptJournalInfoSrvRequest()
  {
    return new SBFIARInquiryReceiptJournalInfoSrvRequest();
  }
  
  public InquiryReceiptJournalInfoSrvOutputCollection createInquiryReceiptJournalInfoSrvOutputCollection()
  {
    return new InquiryReceiptJournalInfoSrvOutputCollection();
  }
  
  public SBFIARInquiryReceiptJournalInfoSrvResponse createSBFIARInquiryReceiptJournalInfoSrvResponse()
  {
    return new SBFIARInquiryReceiptJournalInfoSrvResponse();
  }
  
  public JournalAccountingInfoCollection createJournalAccountingInfoCollection()
  {
    return new JournalAccountingInfoCollection();
  }
  
  public InquiryReceiptJournalInfoSrvOutputItem createInquiryReceiptJournalInfoSrvOutputItem()
  {
    return new InquiryReceiptJournalInfoSrvOutputItem();
  }
  
  public JournalAccountingInfoItem createJournalAccountingInfoItem()
  {
    return new JournalAccountingInfoItem();
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv", name="SB_FI_AR_InquiryReceiptJournalInfoSrvResponse")
  public JAXBElement<SBFIARInquiryReceiptJournalInfoSrvResponse> createSBFIARInquiryReceiptJournalInfoSrvResponse(SBFIARInquiryReceiptJournalInfoSrvResponse paramSBFIARInquiryReceiptJournalInfoSrvResponse)
  {
    return new JAXBElement(_SBFIARInquiryReceiptJournalInfoSrvResponse_QNAME, SBFIARInquiryReceiptJournalInfoSrvResponse.class, null, paramSBFIARInquiryReceiptJournalInfoSrvResponse);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv", name="SB_FI_AR_InquiryReceiptJournalInfoSrvRequest")
  public JAXBElement<SBFIARInquiryReceiptJournalInfoSrvRequest> createSBFIARInquiryReceiptJournalInfoSrvRequest(SBFIARInquiryReceiptJournalInfoSrvRequest paramSBFIARInquiryReceiptJournalInfoSrvRequest)
  {
    return new JAXBElement(_SBFIARInquiryReceiptJournalInfoSrvRequest_QNAME, SBFIARInquiryReceiptJournalInfoSrvRequest.class, null, paramSBFIARInquiryReceiptJournalInfoSrvRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */