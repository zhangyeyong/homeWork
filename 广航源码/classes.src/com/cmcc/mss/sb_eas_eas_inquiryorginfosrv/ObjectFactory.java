package com.cmcc.mss.sb_eas_eas_inquiryorginfosrv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _SBEASEASInquiryORGInfoSrvRequest_QNAME = new QName("http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv", "SB_EAS_EAS_InquiryORGInfoSrvRequest");
  private static final QName _SBEASEASInquiryORGInfoSrvResponse_QNAME = new QName("http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv", "SB_EAS_EAS_InquiryORGInfoSrvResponse");
  
  public SBEASEASInquiryORGInfoSrvResponse createSBEASEASInquiryORGInfoSrvResponse()
  {
    return new SBEASEASInquiryORGInfoSrvResponse();
  }
  
  public SBEASEASInquiryORGInfoSrvRequest createSBEASEASInquiryORGInfoSrvRequest()
  {
    return new SBEASEASInquiryORGInfoSrvRequest();
  }
  
  public InquiryORGInfoSrvOutputItem createInquiryORGInfoSrvOutputItem()
  {
    return new InquiryORGInfoSrvOutputItem();
  }
  
  public InquiryORGInfoSrvOutputCollection createInquiryORGInfoSrvOutputCollection()
  {
    return new InquiryORGInfoSrvOutputCollection();
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv", name="SB_EAS_EAS_InquiryORGInfoSrvRequest")
  public JAXBElement<SBEASEASInquiryORGInfoSrvRequest> createSBEASEASInquiryORGInfoSrvRequest(SBEASEASInquiryORGInfoSrvRequest paramSBEASEASInquiryORGInfoSrvRequest)
  {
    return new JAXBElement(_SBEASEASInquiryORGInfoSrvRequest_QNAME, SBEASEASInquiryORGInfoSrvRequest.class, null, paramSBEASEASInquiryORGInfoSrvRequest);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv", name="SB_EAS_EAS_InquiryORGInfoSrvResponse")
  public JAXBElement<SBEASEASInquiryORGInfoSrvResponse> createSBEASEASInquiryORGInfoSrvResponse(SBEASEASInquiryORGInfoSrvResponse paramSBEASEASInquiryORGInfoSrvResponse)
  {
    return new JAXBElement(_SBEASEASInquiryORGInfoSrvResponse_QNAME, SBEASEASInquiryORGInfoSrvResponse.class, null, paramSBEASEASInquiryORGInfoSrvResponse);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */