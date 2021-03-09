package com.zte.eas.eimage.business.video.proxy.runtime;

import com.zte.eas.eimage.business.video.proxy.EasBoeVideoStatusDS;
import com.zte.ssb.AccessPropertiesFile;
import java.rmi.RemoteException;
import java.util.Calendar;
import javax.xml.namespace.QName;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.handler.HandlerChain;
import javax.xml.soap.SOAPMessage;
import oracle.j2ee.ws.client.ClientTransportException;
import oracle.j2ee.ws.client.SenderException;
import oracle.j2ee.ws.client.StreamingSenderState;
import oracle.j2ee.ws.client.StubBase;
import oracle.j2ee.ws.common.encoding.CombinedSerializer;
import oracle.j2ee.ws.common.encoding.DeserializationException;
import oracle.j2ee.ws.common.encoding.InternalTypeMappingRegistry;
import oracle.j2ee.ws.common.encoding.SOAPDeserializationContext;
import oracle.j2ee.ws.common.encoding.SOAPDeserializationState;
import oracle.j2ee.ws.common.soap.SOAPEncodingConstants;
import oracle.j2ee.ws.common.soap.SOAPVersion;
import oracle.j2ee.ws.common.soap.message.InternalSOAPMessage;
import oracle.j2ee.ws.common.soap.message.SOAPBlockInfo;
import oracle.j2ee.ws.common.soap.message.SOAPMessageContext;
import oracle.j2ee.ws.common.streaming.XMLReader;
import oracle.webservices.transport.ClientTransport;

public class VideoStatusServiceSoapBinding_Stub
  extends StubBase
  implements EasBoeVideoStatusDS
{
  private static final QName _portName = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "VideoStatusService");
  private static final int registerVideo_OPCODE = 0;
  private static final int cancelVideo_OPCODE = 1;
  private static final QName ns1_registerVideo_registerVideo_QNAME = new QName("http://service.video.business.gdyd.eas.zte.com", "registerVideo");
  private static final QName ns1_registerVideo_TYPE_QNAME = new QName("http://service.video.business.gdyd.eas.zte.com", "registerVideo");
  private CombinedSerializer myns1_registerVideo__VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPSerializer;
  private static final QName ns2_registerVideo_registerVideoResponse_QNAME = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "registerVideoResponse");
  private static final QName ns2_registerVideoResponse_TYPE_QNAME = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "registerVideoResponse");
  private CombinedSerializer myns2_registerVideoResponse__VideoStatusServiceSoapBinding_registerVideo_RespS_SOAPSerializer;
  private static final QName ns1_cancelVideo_cancelVideo_QNAME = new QName("http://service.video.business.gdyd.eas.zte.com", "cancelVideo");
  private static final QName ns1_cancelVideo_TYPE_QNAME = new QName("http://service.video.business.gdyd.eas.zte.com", "cancelVideo");
  private CombinedSerializer myns1_cancelVideo__VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPSerializer;
  private static final QName ns2_cancelVideo_cancelVideoResponse_QNAME = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "cancelVideoResponse");
  private static final QName ns2_cancelVideoResponse_TYPE_QNAME = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "cancelVideoResponse");
  private CombinedSerializer myns2_cancelVideoResponse__VideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPSerializer;
  private static final String[] myNamespace_declarations = { "ns0", "http://service.video.business.gdyd.eas.zte.com", "ns1", "http://localhost:8080/gdyd/services/VideoStatusService" };
  private static final QName[] understoodHeaderNames = new QName[0];
  
  public VideoStatusServiceSoapBinding_Stub(HandlerChain paramHandlerChain)
  {
    super(paramHandlerChain);
    _setProperty("javax.xml.rpc.service.endpoint.address", AccessPropertiesFile.getValue("VideoStatusURL", "evs_interface.properties"));
    setSoapVersion(SOAPVersion.SOAP_11);
    setServiceName(new QName("http://localhost:8080/gdyd/services/VideoStatusService", "EasBoeVideoStatusDSService"));
    setPortName(new QName("http://localhost:8080/gdyd/services/VideoStatusService", "VideoStatusService"));
    setupConfig("com/zte/eas/eimage/business/video/proxy/runtime/VideoStatusServiceSoapBinding_Stub.xml");
  }
  
  public boolean registerVideo(String paramString, Calendar paramCalendar)
    throws RemoteException
  {
    StreamingSenderState localStreamingSenderState = null;
    try
    {
      localStreamingSenderState = _start(this._handlerChain);
      if (_getProperty("oracle.webservices.dimeEncodeMessagesWithAttachments") != null) {
        localStreamingSenderState.getMessageContext().getMessage().setProperty("DimeEncode", _getProperty("oracle.webservices.dimeEncodeMessagesWithAttachments"));
      }
      InternalSOAPMessage localInternalSOAPMessage = localStreamingSenderState.getRequest();
      localInternalSOAPMessage.setOperationCode(0);
      localStreamingSenderState.getMessageContext().setProperty("oracle.j2ee.ws.mgmt.interceptor.operation-qname", new QName("", "registerVideo"));
      VideoStatusServiceSoapBinding_registerVideo_ReqS localVideoStatusServiceSoapBinding_registerVideo_ReqS = new VideoStatusServiceSoapBinding_registerVideo_ReqS();
      localVideoStatusServiceSoapBinding_registerVideo_ReqS.setBoeNum(paramString);
      localVideoStatusServiceSoapBinding_registerVideo_ReqS.setUploadDate(paramCalendar);
      SOAPBlockInfo localSOAPBlockInfo = new SOAPBlockInfo(ns1_registerVideo_registerVideo_QNAME);
      localSOAPBlockInfo.setValue(localVideoStatusServiceSoapBinding_registerVideo_ReqS);
      localSOAPBlockInfo.setSerializer(this.myns1_registerVideo__VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPSerializer);
      localInternalSOAPMessage.setBody(localSOAPBlockInfo);
      localStreamingSenderState.getMessageContext().setProperty("http.soap.action", "");
      _send((String)_getProperty("javax.xml.rpc.service.endpoint.address"), localStreamingSenderState);
      VideoStatusServiceSoapBinding_registerVideo_RespS localVideoStatusServiceSoapBinding_registerVideo_RespS = null;
      Object localObject = localStreamingSenderState.getResponse().getBody().getValue();
      if ((localObject instanceof SOAPDeserializationState)) {
        localVideoStatusServiceSoapBinding_registerVideo_RespS = (VideoStatusServiceSoapBinding_registerVideo_RespS)((SOAPDeserializationState)localObject).getInstance();
      } else {
        localVideoStatusServiceSoapBinding_registerVideo_RespS = (VideoStatusServiceSoapBinding_registerVideo_RespS)localObject;
      }
      return localVideoStatusServiceSoapBinding_registerVideo_RespS.isRegisterVideoReturn();
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (ClientTransportException localClientTransportException)
    {
      throw new RemoteException("", localClientTransportException);
    }
    catch (JAXRPCException localJAXRPCException)
    {
      throw localJAXRPCException;
    }
    catch (Exception localException)
    {
      if ((localException instanceof RuntimeException)) {
        throw ((RuntimeException)localException);
      }
      throw new RemoteException(localException.getMessage(), localException);
    }
  }
  
  public boolean cancelVideo(String paramString)
    throws RemoteException
  {
    StreamingSenderState localStreamingSenderState = null;
    try
    {
      localStreamingSenderState = _start(this._handlerChain);
      if (_getProperty("oracle.webservices.dimeEncodeMessagesWithAttachments") != null) {
        localStreamingSenderState.getMessageContext().getMessage().setProperty("DimeEncode", _getProperty("oracle.webservices.dimeEncodeMessagesWithAttachments"));
      }
      InternalSOAPMessage localInternalSOAPMessage = localStreamingSenderState.getRequest();
      localInternalSOAPMessage.setOperationCode(1);
      localStreamingSenderState.getMessageContext().setProperty("oracle.j2ee.ws.mgmt.interceptor.operation-qname", new QName("", "cancelVideo"));
      VideoStatusServiceSoapBinding_cancelVideo_ReqS localVideoStatusServiceSoapBinding_cancelVideo_ReqS = new VideoStatusServiceSoapBinding_cancelVideo_ReqS();
      localVideoStatusServiceSoapBinding_cancelVideo_ReqS.setBoeNum(paramString);
      SOAPBlockInfo localSOAPBlockInfo = new SOAPBlockInfo(ns1_cancelVideo_cancelVideo_QNAME);
      localSOAPBlockInfo.setValue(localVideoStatusServiceSoapBinding_cancelVideo_ReqS);
      localSOAPBlockInfo.setSerializer(this.myns1_cancelVideo__VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPSerializer);
      localInternalSOAPMessage.setBody(localSOAPBlockInfo);
      localStreamingSenderState.getMessageContext().setProperty("http.soap.action", "");
      _send((String)_getProperty("javax.xml.rpc.service.endpoint.address"), localStreamingSenderState);
      VideoStatusServiceSoapBinding_cancelVideo_RespS localVideoStatusServiceSoapBinding_cancelVideo_RespS = null;
      Object localObject = localStreamingSenderState.getResponse().getBody().getValue();
      if ((localObject instanceof SOAPDeserializationState)) {
        localVideoStatusServiceSoapBinding_cancelVideo_RespS = (VideoStatusServiceSoapBinding_cancelVideo_RespS)((SOAPDeserializationState)localObject).getInstance();
      } else {
        localVideoStatusServiceSoapBinding_cancelVideo_RespS = (VideoStatusServiceSoapBinding_cancelVideo_RespS)localObject;
      }
      return localVideoStatusServiceSoapBinding_cancelVideo_RespS.isCancelVideoReturn();
    }
    catch (RemoteException localRemoteException)
    {
      throw localRemoteException;
    }
    catch (ClientTransportException localClientTransportException)
    {
      throw new RemoteException("", localClientTransportException);
    }
    catch (JAXRPCException localJAXRPCException)
    {
      throw localJAXRPCException;
    }
    catch (Exception localException)
    {
      if ((localException instanceof RuntimeException)) {
        throw ((RuntimeException)localException);
      }
      throw new RemoteException(localException.getMessage(), localException);
    }
  }
  
  protected void _readFirstBodyElement(XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext, StreamingSenderState paramStreamingSenderState)
    throws Exception
  {
    int i = paramStreamingSenderState.getRequest().getOperationCode();
    switch (i)
    {
    case 0: 
      _deserialize_registerVideo(paramXMLReader, paramSOAPDeserializationContext, paramStreamingSenderState);
      break;
    case 1: 
      _deserialize_cancelVideo(paramXMLReader, paramSOAPDeserializationContext, paramStreamingSenderState);
      break;
    default: 
      throw new SenderException("sender.response.unrecognizedOperation", Integer.toString(i));
    }
  }
  
  private void _deserialize_registerVideo(XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext, StreamingSenderState paramStreamingSenderState)
    throws Exception
  {
    try
    {
      Object localObject = this.myns2_registerVideoResponse__VideoStatusServiceSoapBinding_registerVideo_RespS_SOAPSerializer.deserialize(ns2_registerVideo_registerVideoResponse_QNAME, paramXMLReader, paramSOAPDeserializationContext);
      SOAPBlockInfo localSOAPBlockInfo = new SOAPBlockInfo(ns2_registerVideo_registerVideoResponse_QNAME);
      localSOAPBlockInfo.setValue(localObject);
      paramStreamingSenderState.getResponse().setBody(localSOAPBlockInfo);
    }
    catch (DeserializationException localDeserializationException)
    {
      if ((localDeserializationException.getSoapFaultSubCodeType() == -1) && (localDeserializationException.getSoapFaultCodeType() != 4)) {
        localDeserializationException.setSoapFaultSubCodeType(6);
      }
      throw localDeserializationException;
    }
  }
  
  private void _deserialize_cancelVideo(XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext, StreamingSenderState paramStreamingSenderState)
    throws Exception
  {
    try
    {
      Object localObject = this.myns2_cancelVideoResponse__VideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPSerializer.deserialize(ns2_cancelVideo_cancelVideoResponse_QNAME, paramXMLReader, paramSOAPDeserializationContext);
      SOAPBlockInfo localSOAPBlockInfo = new SOAPBlockInfo(ns2_cancelVideo_cancelVideoResponse_QNAME);
      localSOAPBlockInfo.setValue(localObject);
      paramStreamingSenderState.getResponse().setBody(localSOAPBlockInfo);
    }
    catch (DeserializationException localDeserializationException)
    {
      if ((localDeserializationException.getSoapFaultSubCodeType() == -1) && (localDeserializationException.getSoapFaultCodeType() != 4)) {
        localDeserializationException.setSoapFaultSubCodeType(6);
      }
      throw localDeserializationException;
    }
  }
  
  public String _getEncodingStyle()
  {
    return SOAPEncodingConstants.getSOAPEncodingConstants(this.soapVersion).getURIEncoding();
  }
  
  public void _setEncodingStyle(String paramString)
  {
    throw new UnsupportedOperationException("cannot set encoding style");
  }
  
  public ClientTransport getClientTransport()
  {
    return super._getTransport();
  }
  
  protected String[] _getNamespaceDeclarations()
  {
    return myNamespace_declarations;
  }
  
  public QName[] _getUnderstoodHeaders()
  {
    return understoodHeaderNames;
  }
  
  protected void _handleEmptyBody(XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext, StreamingSenderState paramStreamingSenderState)
    throws Exception
  {}
  
  public void _initialize(InternalTypeMappingRegistry paramInternalTypeMappingRegistry)
    throws Exception
  {
    super._initialize(paramInternalTypeMappingRegistry);
    this.myns2_cancelVideoResponse__VideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPSerializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer(SOAPEncodingConstants.getSOAPEncodingConstants(this.soapVersion).getURIEncoding(), VideoStatusServiceSoapBinding_cancelVideo_RespS.class, ns2_cancelVideoResponse_TYPE_QNAME));
    this.myns2_registerVideoResponse__VideoStatusServiceSoapBinding_registerVideo_RespS_SOAPSerializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer(SOAPEncodingConstants.getSOAPEncodingConstants(this.soapVersion).getURIEncoding(), VideoStatusServiceSoapBinding_registerVideo_RespS.class, ns2_registerVideoResponse_TYPE_QNAME));
    this.myns1_cancelVideo__VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPSerializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer(SOAPEncodingConstants.getSOAPEncodingConstants(this.soapVersion).getURIEncoding(), VideoStatusServiceSoapBinding_cancelVideo_ReqS.class, ns1_cancelVideo_TYPE_QNAME));
    this.myns1_registerVideo__VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPSerializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer(SOAPEncodingConstants.getSOAPEncodingConstants(this.soapVersion).getURIEncoding(), VideoStatusServiceSoapBinding_registerVideo_ReqS.class, ns1_registerVideo_TYPE_QNAME));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.runtime.VideoStatusServiceSoapBinding_Stub
 * JD-Core Version:    0.7.0.1
 */