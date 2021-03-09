package com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv;

import com.cmcc.mss.importsrvresponse.ImportSrvResponse;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", name="SB_EAS_EAS_ImportImageOperationInfoSrv")
@XmlSeeAlso({com.cmcc.mss.importsrvresponse.ObjectFactory.class, com.cmcc.mss.msgheader.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public abstract interface SBEASEASImportImageOperationInfoSrv
{
  @WebResult(name="SB_EAS_EAS_ImportImageOperationInfoSrvResponse", targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", partName="payload")
  @WebMethod(action="process")
  public abstract ImportSrvResponse process(@WebParam(partName="payload", name="SB_EAS_EAS_ImportImageOperationInfoSrvRequest", targetNamespace="http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv") SBEASEASImportImageOperationInfoSrvRequest paramSBEASEASImportImageOperationInfoSrvRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.SBEASEASImportImageOperationInfoSrv
 * JD-Core Version:    0.7.0.1
 */