package com.zte.eas.eimage.business.video.proxy.runtime;

import javax.xml.namespace.QName;
import javax.xml.rpc.encoding.Deserializer;
import javax.xml.rpc.encoding.Serializer;
import javax.xml.rpc.encoding.TypeMapping;
import javax.xml.rpc.encoding.TypeMappingRegistry;
import oracle.j2ee.ws.client.BasicService;
import oracle.j2ee.ws.common.encoding.SerializerConstants;
import oracle.j2ee.ws.common.encoding.SerializerRegistryBase;
import oracle.j2ee.ws.common.encoding.SingletonDeserializerFactory;
import oracle.j2ee.ws.common.encoding.SingletonSerializerFactory;
import oracle.j2ee.ws.common.soap.SOAPEncodingConstants;
import oracle.j2ee.ws.common.soap.SOAPVersion;

public class EasBoeVideoStatusDSService_SerializerRegistry
  extends SerializerRegistryBase
  implements SerializerConstants
{
  public TypeMappingRegistry getRegistry()
  {
    TypeMappingRegistry localTypeMappingRegistry = BasicService.createStandardTypeMappingRegistry();
    TypeMapping localTypeMapping1 = localTypeMappingRegistry.getTypeMapping(SOAPEncodingConstants.getSOAPEncodingConstants(SOAPVersion.SOAP_11).getURIEncoding());
    TypeMapping localTypeMapping2 = localTypeMappingRegistry.getTypeMapping("");
    Object localObject1 = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "registerVideoResponse");
    Object localObject2 = new VideoStatusServiceSoapBinding_registerVideo_RespS_SOAPSerializer((QName)localObject1, false, false, SOAPVersion.SOAP_11);
    registerSerializer(localTypeMapping1, VideoStatusServiceSoapBinding_registerVideo_RespS.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "cancelVideoResponse");
    localObject2 = new VideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPSerializer((QName)localObject1, false, false, SOAPVersion.SOAP_11);
    registerSerializer(localTypeMapping1, VideoStatusServiceSoapBinding_cancelVideo_RespS.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://service.video.business.gdyd.eas.zte.com", "registerVideo");
    localObject2 = new VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPSerializer((QName)localObject1, false, false, SOAPVersion.SOAP_11);
    registerSerializer(localTypeMapping1, VideoStatusServiceSoapBinding_registerVideo_ReqS.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://service.video.business.gdyd.eas.zte.com", "cancelVideo");
    localObject2 = new VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPSerializer((QName)localObject1, false, false, SOAPVersion.SOAP_11);
    registerSerializer(localTypeMapping1, VideoStatusServiceSoapBinding_cancelVideo_ReqS.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new EasBoeVideoStatusDSService_SerializerRegistry12();
    return ((EasBoeVideoStatusDSService_SerializerRegistry12)localObject1).getRegistry(localTypeMappingRegistry);
  }
  
  private static void registerSerializer(TypeMapping paramTypeMapping, Class paramClass, QName paramQName, Serializer paramSerializer)
  {
    paramTypeMapping.register(paramClass, paramQName, new SingletonSerializerFactory(paramSerializer), new SingletonDeserializerFactory((Deserializer)paramSerializer));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.runtime.EasBoeVideoStatusDSService_SerializerRegistry
 * JD-Core Version:    0.7.0.1
 */