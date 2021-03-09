package com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _SBFIGLPageInquiryGLJournalInfoSrvResponse_QNAME = new QName("http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv", "SB_FI_GL_PageInquiryGLJournalInfoSrvResponse");
  private static final QName _SBFIGLPageInquiryGLJournalInfoSrvRequest_QNAME = new QName("http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv", "SB_FI_GL_PageInquiryGLJournalInfoSrvRequest");
  
  public SBFIGLPageInquiryGLJournalInfoSrvRequest createSBFIGLPageInquiryGLJournalInfoSrvRequest()
  {
    return new SBFIGLPageInquiryGLJournalInfoSrvRequest();
  }
  
  public JournalAccountingInfoCollection createJournalAccountingInfoCollection()
  {
    return new JournalAccountingInfoCollection();
  }
  
  public PageInquiryGLJournalInfoSrvOutputItem createPageInquiryGLJournalInfoSrvOutputItem()
  {
    return new PageInquiryGLJournalInfoSrvOutputItem();
  }
  
  public PageInquiryGLJournalInfoSrvOutputCollection createPageInquiryGLJournalInfoSrvOutputCollection()
  {
    return new PageInquiryGLJournalInfoSrvOutputCollection();
  }
  
  public JournalAccountingInfoItem createJournalAccountingInfoItem()
  {
    return new JournalAccountingInfoItem();
  }
  
  public SBFIGLPageInquiryGLJournalInfoSrvResponse createSBFIGLPageInquiryGLJournalInfoSrvResponse()
  {
    return new SBFIGLPageInquiryGLJournalInfoSrvResponse();
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv", name="SB_FI_GL_PageInquiryGLJournalInfoSrvResponse")
  public JAXBElement<SBFIGLPageInquiryGLJournalInfoSrvResponse> createSBFIGLPageInquiryGLJournalInfoSrvResponse(SBFIGLPageInquiryGLJournalInfoSrvResponse paramSBFIGLPageInquiryGLJournalInfoSrvResponse)
  {
    return new JAXBElement(_SBFIGLPageInquiryGLJournalInfoSrvResponse_QNAME, SBFIGLPageInquiryGLJournalInfoSrvResponse.class, null, paramSBFIGLPageInquiryGLJournalInfoSrvResponse);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv", name="SB_FI_GL_PageInquiryGLJournalInfoSrvRequest")
  public JAXBElement<SBFIGLPageInquiryGLJournalInfoSrvRequest> createSBFIGLPageInquiryGLJournalInfoSrvRequest(SBFIGLPageInquiryGLJournalInfoSrvRequest paramSBFIGLPageInquiryGLJournalInfoSrvRequest)
  {
    return new JAXBElement(_SBFIGLPageInquiryGLJournalInfoSrvRequest_QNAME, SBFIGLPageInquiryGLJournalInfoSrvRequest.class, null, paramSBFIGLPageInquiryGLJournalInfoSrvRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */