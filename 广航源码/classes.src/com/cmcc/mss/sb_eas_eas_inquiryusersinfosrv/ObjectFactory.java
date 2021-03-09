package com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _SBEASEASInquiryUsersInfoSrvRequest_QNAME = new QName("http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv", "SB_EAS_EAS_InquiryUsersInfoSrvRequest");
  private static final QName _SBEASEASInquiryUsersInfoSrvResponse_QNAME = new QName("http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv", "SB_EAS_EAS_InquiryUsersInfoSrvResponse");
  
  public InquiryUsersInfoSrvOutputItem createInquiryUsersInfoSrvOutputItem()
  {
    return new InquiryUsersInfoSrvOutputItem();
  }
  
  public SBEASEASInquiryUsersInfoSrvRequest createSBEASEASInquiryUsersInfoSrvRequest()
  {
    return new SBEASEASInquiryUsersInfoSrvRequest();
  }
  
  public InquiryUsersInfoSrvOutputCollection createInquiryUsersInfoSrvOutputCollection()
  {
    return new InquiryUsersInfoSrvOutputCollection();
  }
  
  public SBEASEASInquiryUsersInfoSrvResponse createSBEASEASInquiryUsersInfoSrvResponse()
  {
    return new SBEASEASInquiryUsersInfoSrvResponse();
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv", name="SB_EAS_EAS_InquiryUsersInfoSrvRequest")
  public JAXBElement<SBEASEASInquiryUsersInfoSrvRequest> createSBEASEASInquiryUsersInfoSrvRequest(SBEASEASInquiryUsersInfoSrvRequest paramSBEASEASInquiryUsersInfoSrvRequest)
  {
    return new JAXBElement(_SBEASEASInquiryUsersInfoSrvRequest_QNAME, SBEASEASInquiryUsersInfoSrvRequest.class, null, paramSBEASEASInquiryUsersInfoSrvRequest);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv", name="SB_EAS_EAS_InquiryUsersInfoSrvResponse")
  public JAXBElement<SBEASEASInquiryUsersInfoSrvResponse> createSBEASEASInquiryUsersInfoSrvResponse(SBEASEASInquiryUsersInfoSrvResponse paramSBEASEASInquiryUsersInfoSrvResponse)
  {
    return new JAXBElement(_SBEASEASInquiryUsersInfoSrvResponse_QNAME, SBEASEASInquiryUsersInfoSrvResponse.class, null, paramSBEASEASInquiryUsersInfoSrvResponse);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */