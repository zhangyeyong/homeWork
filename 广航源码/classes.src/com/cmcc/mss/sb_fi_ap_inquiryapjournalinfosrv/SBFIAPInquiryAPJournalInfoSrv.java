package com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace="http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv", name="SB_FI_AP_InquiryAPJournalInfoSrv")
@XmlSeeAlso({ObjectFactory.class, com.cmcc.mss.msgheader.ObjectFactory.class})
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public abstract interface SBFIAPInquiryAPJournalInfoSrv
{
  @WebResult(name="SB_FI_AP_InquiryAPJournalInfoSrvResponse", targetNamespace="http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv", partName="payload")
  @WebMethod(action="process")
  public abstract SBFIAPInquiryAPJournalInfoSrvResponse process(@WebParam(partName="payload", name="SB_FI_AP_InquiryAPJournalInfoSrvRequest", targetNamespace="http://mss.cmcc.com/SB_FI_AP_InquiryAPJournalInfoSrv") SBFIAPInquiryAPJournalInfoSrvRequest paramSBFIAPInquiryAPJournalInfoSrvRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.SBFIAPInquiryAPJournalInfoSrv
 * JD-Core Version:    0.7.0.1
 */