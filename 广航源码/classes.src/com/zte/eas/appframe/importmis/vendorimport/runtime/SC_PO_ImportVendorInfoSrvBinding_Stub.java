package com.zte.eas.appframe.importmis.vendorimport.runtime;

import com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrvProcessRequest;
import com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrvProcessResponse;
import com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrv_PortType;
import com.zte.ssb.AccessPropertiesFile;
import java.rmi.RemoteException;
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

public class SC_PO_ImportVendorInfoSrvBinding_Stub
  extends StubBase
  implements SC_PO_ImportVendorInfoSrv_PortType
{
  private static final QName _portName = new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "SC_PO_ImportVendorInfoSrvPort");
  private static final int process_OPCODE = 0;
  private static final QName ns1_process_SC_PO_ImportVendorInfoSrvProcessRequest_QNAME = new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "SC_PO_ImportVendorInfoSrvProcessRequest");
  private static final QName ns1_SC_PO_ImportVendorInfoSrvProcessRequest_TYPE_QNAME = new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "SC_PO_ImportVendorInfoSrvProcessRequest");
  private CombinedSerializer myns1_SC_PO_ImportVendorInfoSrvProcessRequest__SC_PO_ImportVendorInfoSrvProcessRequest_LiteralSerializer;
  private static final QName ns1_process_SC_PO_ImportVendorInfoSrvProcessResponse_QNAME = new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "SC_PO_ImportVendorInfoSrvProcessResponse");
  private static final QName ns1_SC_PO_ImportVendorInfoSrvProcessResponse_TYPE_QNAME = new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "SC_PO_ImportVendorInfoSrvProcessResponse");
  private CombinedSerializer myns1_SC_PO_ImportVendorInfoSrvProcessResponse__SC_PO_ImportVendorInfoSrvProcessResponse_LiteralSerializer;
  private static final String[] myNamespace_declarations = { "ns0", "http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv" };
  private static final QName[] understoodHeaderNames = new QName[0];
  
  public SC_PO_ImportVendorInfoSrvBinding_Stub(HandlerChain paramHandlerChain)
  {
    super(paramHandlerChain);
    _setProperty("javax.xml.rpc.service.endpoint.address", AccessPropertiesFile.getValue("vendor_import"));
    setSoapVersion(SOAPVersion.SOAP_11);
    setServiceName(new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "SC_PO_ImportVendorInfoSrv"));
    setPortName(new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "SC_PO_ImportVendorInfoSrvPort"));
    setupConfig("com/zte/eas/appframe/importmis/vendorimport/runtime/SC_PO_ImportVendorInfoSrvBinding_Stub.xml");
  }
  
  public SC_PO_ImportVendorInfoSrvProcessResponse process(SC_PO_ImportVendorInfoSrvProcessRequest paramSC_PO_ImportVendorInfoSrvProcessRequest)
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
      localStreamingSenderState.getMessageContext().setProperty("oracle.j2ee.ws.mgmt.interceptor.operation-qname", new QName("", "process"));
      SOAPBlockInfo localSOAPBlockInfo = new SOAPBlockInfo(ns1_process_SC_PO_ImportVendorInfoSrvProcessRequest_QNAME);
      localSOAPBlockInfo.setValue(paramSC_PO_ImportVendorInfoSrvProcessRequest);
      localSOAPBlockInfo.setSerializer(this.myns1_SC_PO_ImportVendorInfoSrvProcessRequest__SC_PO_ImportVendorInfoSrvProcessRequest_LiteralSerializer);
      localInternalSOAPMessage.setBody(localSOAPBlockInfo);
      localStreamingSenderState.getMessageContext().setProperty("http.soap.action", "process");
      _send((String)_getProperty("javax.xml.rpc.service.endpoint.address"), localStreamingSenderState);
      SC_PO_ImportVendorInfoSrvProcessResponse localSC_PO_ImportVendorInfoSrvProcessResponse = null;
      Object localObject = localStreamingSenderState.getResponse().getBody().getValue();
      if ((localObject instanceof SOAPDeserializationState)) {
        localSC_PO_ImportVendorInfoSrvProcessResponse = (SC_PO_ImportVendorInfoSrvProcessResponse)((SOAPDeserializationState)localObject).getInstance();
      } else {
        localSC_PO_ImportVendorInfoSrvProcessResponse = (SC_PO_ImportVendorInfoSrvProcessResponse)localObject;
      }
      return localSC_PO_ImportVendorInfoSrvProcessResponse;
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
      _deserialize_process(paramXMLReader, paramSOAPDeserializationContext, paramStreamingSenderState);
      break;
    default: 
      throw new SenderException("sender.response.unrecognizedOperation", Integer.toString(i));
    }
  }
  
  private void _deserialize_process(XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext, StreamingSenderState paramStreamingSenderState)
    throws Exception
  {
    try
    {
      Object localObject = this.myns1_SC_PO_ImportVendorInfoSrvProcessResponse__SC_PO_ImportVendorInfoSrvProcessResponse_LiteralSerializer.deserialize(ns1_process_SC_PO_ImportVendorInfoSrvProcessResponse_QNAME, paramXMLReader, paramSOAPDeserializationContext);
      SOAPBlockInfo localSOAPBlockInfo = new SOAPBlockInfo(ns1_process_SC_PO_ImportVendorInfoSrvProcessResponse_QNAME);
      localSOAPBlockInfo.setValue(localObject);
      paramStreamingSenderState.getResponse().setBody(localSOAPBlockInfo);
    }
    catch (DeserializationException localDeserializationException)
    {
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
    this.myns1_SC_PO_ImportVendorInfoSrvProcessRequest__SC_PO_ImportVendorInfoSrvProcessRequest_LiteralSerializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer("", SC_PO_ImportVendorInfoSrvProcessRequest.class, ns1_SC_PO_ImportVendorInfoSrvProcessRequest_TYPE_QNAME));
    this.myns1_SC_PO_ImportVendorInfoSrvProcessResponse__SC_PO_ImportVendorInfoSrvProcessResponse_LiteralSerializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer("", SC_PO_ImportVendorInfoSrvProcessResponse.class, ns1_SC_PO_ImportVendorInfoSrvProcessResponse_TYPE_QNAME));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.vendorimport.runtime.SC_PO_ImportVendorInfoSrvBinding_Stub
 * JD-Core Version:    0.7.0.1
 */