package com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv", name="SB_EAS_EAS_InquiryUsersInfoSrv")
@XmlSeeAlso({com.cmcc.mss.msgheader.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public abstract interface SBEASEASInquiryUsersInfoSrv
{
  @WebResult(name="SB_EAS_EAS_InquiryUsersInfoSrvResponse", targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv", partName="payload")
  @WebMethod(action="process")
  public abstract SBEASEASInquiryUsersInfoSrvResponse process(@WebParam(partName="payload", name="SB_EAS_EAS_InquiryUsersInfoSrvRequest", targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryUsersInfoSrv") SBEASEASInquiryUsersInfoSrvRequest paramSBEASEASInquiryUsersInfoSrvRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.SBEASEASInquiryUsersInfoSrv
 * JD-Core Version:    0.7.0.1
 */