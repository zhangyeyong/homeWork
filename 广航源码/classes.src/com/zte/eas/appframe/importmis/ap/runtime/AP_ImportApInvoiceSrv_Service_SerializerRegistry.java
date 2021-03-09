package com.zte.eas.appframe.importmis.ap.runtime;

import com.zte.eas.appframe.importmis.ap.AP_ImportApInvoiceSrvProcessRequest;
import com.zte.eas.appframe.importmis.ap.AP_ImportApInvoiceSrvProcessResponse;
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

public class AP_ImportApInvoiceSrv_Service_SerializerRegistry
  extends SerializerRegistryBase
  implements SerializerConstants
{
  public TypeMappingRegistry getRegistry()
  {
    TypeMappingRegistry localTypeMappingRegistry = BasicService.createStandardTypeMappingRegistry();
    TypeMapping localTypeMapping1 = localTypeMappingRegistry.getTypeMapping(SOAPEncodingConstants.getSOAPEncodingConstants(SOAPVersion.SOAP_11).getURIEncoding());
    TypeMapping localTypeMapping2 = localTypeMappingRegistry.getTypeMapping("");
    Object localObject1 = new QName("http://eas.zte.com.cn/all/AP_ImportApInvoiceSrv", "AP_ImportApInvoiceSrvProcessResponse");
    Object localObject2 = new AP_ImportApInvoiceSrvProcessResponse_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, AP_ImportApInvoiceSrvProcessResponse.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://eas.zte.com.cn/all/AP_ImportApInvoiceSrv", "AP_ImportApInvoiceSrvProcessRequest");
    localObject2 = new AP_ImportApInvoiceSrvProcessRequest_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, AP_ImportApInvoiceSrvProcessRequest.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new AP_ImportApInvoiceSrv_Service_SerializerRegistry12();
    return ((AP_ImportApInvoiceSrv_Service_SerializerRegistry12)localObject1).getRegistry(localTypeMappingRegistry);
  }
  
  private static void registerSerializer(TypeMapping paramTypeMapping, Class paramClass, QName paramQName, Serializer paramSerializer)
  {
    paramTypeMapping.register(paramClass, paramQName, new SingletonSerializerFactory(paramSerializer), new SingletonDeserializerFactory((Deserializer)paramSerializer));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.ap.runtime.AP_ImportApInvoiceSrv_Service_SerializerRegistry
 * JD-Core Version:    0.7.0.1
 */