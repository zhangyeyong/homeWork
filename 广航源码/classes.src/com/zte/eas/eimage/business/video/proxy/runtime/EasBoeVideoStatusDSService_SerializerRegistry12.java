package com.zte.eas.eimage.business.video.proxy.runtime;

import javax.xml.namespace.QName;
import javax.xml.rpc.encoding.Deserializer;
import javax.xml.rpc.encoding.Serializer;
import javax.xml.rpc.encoding.TypeMapping;
import javax.xml.rpc.encoding.TypeMappingRegistry;
import oracle.j2ee.ws.common.encoding.SerializerConstants;
import oracle.j2ee.ws.common.encoding.SingletonDeserializerFactory;
import oracle.j2ee.ws.common.encoding.SingletonSerializerFactory;
import oracle.j2ee.ws.common.soap.SOAPEncodingConstants;
import oracle.j2ee.ws.common.soap.SOAPVersion;

public class EasBoeVideoStatusDSService_SerializerRegistry12
  implements SerializerConstants
{
  public TypeMappingRegistry getRegistry(TypeMappingRegistry paramTypeMappingRegistry)
  {
    TypeMapping localTypeMapping1 = paramTypeMappingRegistry.getTypeMapping(SOAPEncodingConstants.getSOAPEncodingConstants(SOAPVersion.SOAP_12).getURIEncoding());
    TypeMapping localTypeMapping2 = paramTypeMappingRegistry.getTypeMapping("");
    QName localQName = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "registerVideoResponse");
    Object localObject = new VideoStatusServiceSoapBinding_registerVideo_RespS_SOAPSerializer(localQName, false, false, SOAPVersion.SOAP_12);
    registerSerializer(localTypeMapping1, VideoStatusServiceSoapBinding_registerVideo_RespS.class, localQName, (Serializer)localObject);
    localQName = new QName("http://localhost:8080/gdyd/services/VideoStatusService", "cancelVideoResponse");
    localObject = new VideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPSerializer(localQName, false, false, SOAPVersion.SOAP_12);
    registerSerializer(localTypeMapping1, VideoStatusServiceSoapBinding_cancelVideo_RespS.class, localQName, (Serializer)localObject);
    localQName = new QName("http://service.video.business.gdyd.eas.zte.com", "registerVideo");
    localObject = new VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPSerializer(localQName, false, false, SOAPVersion.SOAP_12);
    registerSerializer(localTypeMapping1, VideoStatusServiceSoapBinding_registerVideo_ReqS.class, localQName, (Serializer)localObject);
    localQName = new QName("http://service.video.business.gdyd.eas.zte.com", "cancelVideo");
    localObject = new VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPSerializer(localQName, false, false, SOAPVersion.SOAP_12);
    registerSerializer(localTypeMapping1, VideoStatusServiceSoapBinding_cancelVideo_ReqS.class, localQName, (Serializer)localObject);
    return paramTypeMappingRegistry;
  }
  
  private static void registerSerializer(TypeMapping paramTypeMapping, Class paramClass, QName paramQName, Serializer paramSerializer)
  {
    paramTypeMapping.register(paramClass, paramQName, new SingletonSerializerFactory(paramSerializer), new SingletonDeserializerFactory((Deserializer)paramSerializer));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.runtime.EasBoeVideoStatusDSService_SerializerRegistry12
 * JD-Core Version:    0.7.0.1
 */