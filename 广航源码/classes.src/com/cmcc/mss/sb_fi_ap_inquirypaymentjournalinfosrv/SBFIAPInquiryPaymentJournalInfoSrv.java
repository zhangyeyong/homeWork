package com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace="http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv", name="SB_FI_AP_InquiryPaymentJournalInfoSrv")
@XmlSeeAlso({com.cmcc.mss.msgheader.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public abstract interface SBFIAPInquiryPaymentJournalInfoSrv
{
  @WebResult(name="SB_FI_AP_InquiryPaymentJournalInfoSrvResponse", targetNamespace="http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv", partName="payload")
  @WebMethod(action="process")
  public abstract SBFIAPInquiryPaymentJournalInfoSrvResponse process(@WebParam(partName="payload", name="SB_FI_AP_InquiryPaymentJournalInfoSrvRequest", targetNamespace="http://mss.cmcc.com/SB_FI_AP_InquiryPaymentJournalInfoSrv") SBFIAPInquiryPaymentJournalInfoSrvRequest paramSBFIAPInquiryPaymentJournalInfoSrvRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.SBFIAPInquiryPaymentJournalInfoSrv
 * JD-Core Version:    0.7.0.1
 */