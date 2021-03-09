package com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace="http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv", name="SB_FI_AR_InquiryReceiptJournalInfoSrv")
@XmlSeeAlso({com.cmcc.mss.msgheader.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public abstract interface SBFIARInquiryReceiptJournalInfoSrv
{
  @WebResult(name="SB_FI_AR_InquiryReceiptJournalInfoSrvResponse", targetNamespace="http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv", partName="payload")
  @WebMethod(action="process")
  public abstract SBFIARInquiryReceiptJournalInfoSrvResponse process(@WebParam(partName="payload", name="SB_FI_AR_InquiryReceiptJournalInfoSrvRequest", targetNamespace="http://mss.cmcc.com/SB_FI_AR_InquiryReceiptJournalInfoSrv") SBFIARInquiryReceiptJournalInfoSrvRequest paramSBFIARInquiryReceiptJournalInfoSrvRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.SBFIARInquiryReceiptJournalInfoSrv
 * JD-Core Version:    0.7.0.1
 */