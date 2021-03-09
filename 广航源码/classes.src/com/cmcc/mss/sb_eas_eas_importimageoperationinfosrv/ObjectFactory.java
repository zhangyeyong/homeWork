package com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv;

import com.cmcc.mss.importsrvresponse.ImportSrvResponse;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _SBEASEASImportImageOperationInfoSrvResponse_QNAME = new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "SB_EAS_EAS_ImportImageOperationInfoSrvResponse");
  private static final QName _SBEASEASImportImageOperationInfoSrvRequest_QNAME = new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "SB_EAS_EAS_ImportImageOperationInfoSrvRequest");
  
  public ImportImageOperationInfoSrvInputCollection createImportImageOperationInfoSrvInputCollection()
  {
    return new ImportImageOperationInfoSrvInputCollection();
  }
  
  public ImportImageOperationInfoSrvInputItem createImportImageOperationInfoSrvInputItem()
  {
    return new ImportImageOperationInfoSrvInputItem();
  }
  
  public SBEASEASImportImageOperationInfoSrvRequest createSBEASEASImportImageOperationInfoSrvRequest()
  {
    return new SBEASEASImportImageOperationInfoSrvRequest();
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", name="SB_EAS_EAS_ImportImageOperationInfoSrvResponse")
  public JAXBElement<ImportSrvResponse> createSBEASEASImportImageOperationInfoSrvResponse(ImportSrvResponse paramImportSrvResponse)
  {
    return new JAXBElement(_SBEASEASImportImageOperationInfoSrvResponse_QNAME, ImportSrvResponse.class, null, paramImportSrvResponse);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", name="SB_EAS_EAS_ImportImageOperationInfoSrvRequest")
  public JAXBElement<SBEASEASImportImageOperationInfoSrvRequest> createSBEASEASImportImageOperationInfoSrvRequest(SBEASEASImportImageOperationInfoSrvRequest paramSBEASEASImportImageOperationInfoSrvRequest)
  {
    return new JAXBElement(_SBEASEASImportImageOperationInfoSrvRequest_QNAME, SBEASEASImportImageOperationInfoSrvRequest.class, null, paramSBEASEASImportImageOperationInfoSrvRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */