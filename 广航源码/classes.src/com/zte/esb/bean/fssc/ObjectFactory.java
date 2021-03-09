package com.zte.esb.bean.fssc;

import com.zte.esb.bean.foss.DistrictInfo;
import com.zte.esb.bean.foss.FailInfo;
import com.zte.esb.bean.foss.SyncDistrictRequest;
import com.zte.esb.bean.foss.SyncDistrictResponse;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _EisEvaluationResponse_QNAME = new QName("http://www.deppon.com/fssc/remote/eis/domain/type", "eisEvaluationResponse");
  private static final QName _SyncAttachmentResponse_QNAME = new QName("http://www.deppon.com/fssc/remote/eis/domain/type", "syncAttachmentResponse");
  private static final QName _EisGetResponse_QNAME = new QName("http://www.deppon.com/fssc/remote/eis/domain/type", "eisGetResponse");
  private static final QName _SpecialAttachmentResponse_QNAME = new QName("http://www.deppon.com/fssc/remote/eis/domain/type", "specialAttachmentResponse");
  private static final QName _SyncAttachmentRequest_QNAME = new QName("http://www.deppon.com/fssc/remote/eis/domain/type", "syncAttachmentRequest");
  private static final QName _GetEisRequest_QNAME = new QName("http://www.deppon.com/fssc/remote/eis/domain/type", "getEisRequest");
  private static final QName _EisEvaluationRequest_QNAME = new QName("http://www.deppon.com/fssc/remote/eis/domain/type", "eisEvaluationRequest");
  private static final QName _SpecialAttachmentRequest_QNAME = new QName("http://www.deppon.com/fssc/remote/eis/domain/type", "specialAttachmentRequest");
  private static final QName _SyncDistrictResponse_QNAME = new QName("http://www.deppon.com/ows/inteface/domain/", "SyncDistrictResponse");
  private static final QName _SyncDistrictRequest_QNAME = new QName("http://www.deppon.com/ows/inteface/domain/", "SyncDistrictRequest");
  
  public GetEisRequest createGetEisRequest()
  {
    return new GetEisRequest();
  }
  
  public SyncAttachmentRequest createSyncAttachmentRequest()
  {
    return new SyncAttachmentRequest();
  }
  
  public SpecialAttachmentResponse createSpecialAttachmentResponse()
  {
    return new SpecialAttachmentResponse();
  }
  
  public EisGetResponse createEisGetResponse()
  {
    return new EisGetResponse();
  }
  
  public SynchAttachmentResponse createSynchAttachmentResponse()
  {
    return new SynchAttachmentResponse();
  }
  
  public EisEvaluationResponse createEisEvaluationResponse()
  {
    return new EisEvaluationResponse();
  }
  
  public SpecialAttachmentRequest createSpecialAttachmentRequest()
  {
    return new SpecialAttachmentRequest();
  }
  
  public EisEvaluationRequest createEisEvaluationRequest()
  {
    return new EisEvaluationRequest();
  }
  
  public FailInfo createFailInfo()
  {
    return new FailInfo();
  }
  
  public DistrictInfo createDistrictInfo()
  {
    return new DistrictInfo();
  }
  
  public SyncDistrictResponse createSyncDistrictResponse()
  {
    return new SyncDistrictResponse();
  }
  
  public SyncDistrictRequest createSyncDistrictRequest()
  {
    return new SyncDistrictRequest();
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/fssc/remote/eis/domain/type", name="eisEvaluationResponse")
  public JAXBElement<EisEvaluationResponse> createEisEvaluationResponse(EisEvaluationResponse paramEisEvaluationResponse)
  {
    return new JAXBElement(_EisEvaluationResponse_QNAME, EisEvaluationResponse.class, null, paramEisEvaluationResponse);
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/fssc/remote/eis/domain/type", name="syncAttachmentResponse")
  public JAXBElement<SynchAttachmentResponse> createSyncAttachmentResponse(SynchAttachmentResponse paramSynchAttachmentResponse)
  {
    return new JAXBElement(_SyncAttachmentResponse_QNAME, SynchAttachmentResponse.class, null, paramSynchAttachmentResponse);
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/fssc/remote/eis/domain/type", name="eisGetResponse")
  public JAXBElement<EisGetResponse> createEisGetResponse(EisGetResponse paramEisGetResponse)
  {
    return new JAXBElement(_EisGetResponse_QNAME, EisGetResponse.class, null, paramEisGetResponse);
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/fssc/remote/eis/domain/type", name="specialAttachmentResponse")
  public JAXBElement<SpecialAttachmentResponse> createSpecialAttachmentResponse(SpecialAttachmentResponse paramSpecialAttachmentResponse)
  {
    return new JAXBElement(_SpecialAttachmentResponse_QNAME, SpecialAttachmentResponse.class, null, paramSpecialAttachmentResponse);
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/fssc/remote/eis/domain/type", name="syncAttachmentRequest")
  public JAXBElement<SyncAttachmentRequest> createSyncAttachmentRequest(SyncAttachmentRequest paramSyncAttachmentRequest)
  {
    return new JAXBElement(_SyncAttachmentRequest_QNAME, SyncAttachmentRequest.class, null, paramSyncAttachmentRequest);
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/fssc/remote/eis/domain/type", name="getEisRequest")
  public JAXBElement<GetEisRequest> createGetEisRequest(GetEisRequest paramGetEisRequest)
  {
    return new JAXBElement(_GetEisRequest_QNAME, GetEisRequest.class, null, paramGetEisRequest);
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/fssc/remote/eis/domain/type", name="eisEvaluationRequest")
  public JAXBElement<EisEvaluationRequest> createEisEvaluationRequest(EisEvaluationRequest paramEisEvaluationRequest)
  {
    return new JAXBElement(_EisEvaluationRequest_QNAME, EisEvaluationRequest.class, null, paramEisEvaluationRequest);
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/fssc/remote/eis/domain/type", name="specialAttachmentRequest")
  public JAXBElement<SpecialAttachmentRequest> createSpecialAttachmentRequest(SpecialAttachmentRequest paramSpecialAttachmentRequest)
  {
    return new JAXBElement(_SpecialAttachmentRequest_QNAME, SpecialAttachmentRequest.class, null, paramSpecialAttachmentRequest);
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/ows/inteface/domain/", name="SyncDistrictResponse")
  public JAXBElement<SyncDistrictResponse> createSyncDistrictResponse(SyncDistrictResponse paramSyncDistrictResponse)
  {
    return new JAXBElement(_SyncDistrictResponse_QNAME, SyncDistrictResponse.class, null, paramSyncDistrictResponse);
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/ows/inteface/domain/", name="SyncDistrictRequest")
  public JAXBElement<SyncDistrictRequest> createSyncDistrictRequest(SyncDistrictRequest paramSyncDistrictRequest)
  {
    return new JAXBElement(_SyncDistrictRequest_QNAME, SyncDistrictRequest.class, null, paramSyncDistrictRequest);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.fssc.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */