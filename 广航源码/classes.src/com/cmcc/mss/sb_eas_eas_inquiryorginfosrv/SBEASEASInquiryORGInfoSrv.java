package com.cmcc.mss.sb_eas_eas_inquiryorginfosrv;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv", name="SB_EAS_EAS_InquiryORGInfoSrv")
@XmlSeeAlso({ObjectFactory.class, com.cmcc.mss.msgheader.ObjectFactory.class})
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public abstract interface SBEASEASInquiryORGInfoSrv
{
  @WebResult(name="SB_EAS_EAS_InquiryORGInfoSrvResponse", targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv", partName="payload")
  @WebMethod(action="process")
  public abstract SBEASEASInquiryORGInfoSrvResponse process(@WebParam(partName="payload", name="SB_EAS_EAS_InquiryORGInfoSrvRequest", targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_InquiryORGInfoSrv") SBEASEASInquiryORGInfoSrvRequest paramSBEASEASInquiryORGInfoSrvRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.SBEASEASInquiryORGInfoSrv
 * JD-Core Version:    0.7.0.1
 */