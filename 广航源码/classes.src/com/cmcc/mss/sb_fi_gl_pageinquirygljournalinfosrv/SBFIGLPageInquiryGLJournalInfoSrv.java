package com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace="http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv", name="SB_FI_GL_PageInquiryGLJournalInfoSrv")
@XmlSeeAlso({com.cmcc.mss.msgheader.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public abstract interface SBFIGLPageInquiryGLJournalInfoSrv
{
  @WebResult(name="SB_FI_GL_PageInquiryGLJournalInfoSrvResponse", targetNamespace="http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv", partName="payload")
  @WebMethod(action="process")
  public abstract SBFIGLPageInquiryGLJournalInfoSrvResponse process(@WebParam(partName="payload", name="SB_FI_GL_PageInquiryGLJournalInfoSrvRequest", targetNamespace="http://mss.cmcc.com/SB_FI_GL_PageInquiryGLJournalInfoSrv") SBFIGLPageInquiryGLJournalInfoSrvRequest paramSBFIGLPageInquiryGLJournalInfoSrvRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.SBFIGLPageInquiryGLJournalInfoSrv
 * JD-Core Version:    0.7.0.1
 */