package com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace="http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv", name="SB_FI_AR_InquiryARJournalInfoSrv")
@XmlSeeAlso({com.cmcc.mss.msgheader.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public abstract interface SBFIARInquiryARJournalInfoSrv
{
  @WebResult(name="SB_FI_AR_InquiryARJournalInfoSrvResponse", targetNamespace="http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv", partName="payload")
  @WebMethod(action="process")
  public abstract SBFIARInquiryARJournalInfoSrvResponse process(@WebParam(partName="payload", name="SB_FI_AR_InquiryARJournalInfoSrvRequest", targetNamespace="http://mss.cmcc.com/SB_FI_AR_InquiryARJournalInfoSrv") SBFIARInquiryARJournalInfoSrvRequest paramSBFIARInquiryARJournalInfoSrvRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.SBFIARInquiryARJournalInfoSrv
 * JD-Core Version:    0.7.0.1
 */