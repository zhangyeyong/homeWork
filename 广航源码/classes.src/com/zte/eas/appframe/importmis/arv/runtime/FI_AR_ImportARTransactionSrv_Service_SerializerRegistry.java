package com.zte.eas.appframe.importmis.arv.runtime;

import com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv.FiArImportARTransactionSrvRequest;
import com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv.FiArImportARTransactionSrvResponse;
import com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv.runtime.FiArImportARTransactionSrvRequest_LiteralSerializer;
import com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv.runtime.FiArImportARTransactionSrvResponse_LiteralSerializer;
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

public class FI_AR_ImportARTransactionSrv_Service_SerializerRegistry
  extends SerializerRegistryBase
  implements SerializerConstants
{
  public TypeMappingRegistry getRegistry()
  {
    TypeMappingRegistry localTypeMappingRegistry = BasicService.createStandardTypeMappingRegistry();
    TypeMapping localTypeMapping1 = localTypeMappingRegistry.getTypeMapping(SOAPEncodingConstants.getSOAPEncodingConstants(SOAPVersion.SOAP_11).getURIEncoding());
    TypeMapping localTypeMapping2 = localTypeMappingRegistry.getTypeMapping("");
    Object localObject1 = new QName("http://eas.zte.com/ArImport/FiArImportARTransactionSrv", "FiArImportARTransactionSrvResponse");
    Object localObject2 = new FiArImportARTransactionSrvResponse_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, FiArImportARTransactionSrvResponse.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://eas.zte.com/ArImport/FiArImportARTransactionSrv", "FiArImportARTransactionSrvRequest");
    localObject2 = new FiArImportARTransactionSrvRequest_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, FiArImportARTransactionSrvRequest.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new FI_AR_ImportARTransactionSrv_Service_SerializerRegistry12();
    return ((FI_AR_ImportARTransactionSrv_Service_SerializerRegistry12)localObject1).getRegistry(localTypeMappingRegistry);
  }
  
  private static void registerSerializer(TypeMapping paramTypeMapping, Class paramClass, QName paramQName, Serializer paramSerializer)
  {
    paramTypeMapping.register(paramClass, paramQName, new SingletonSerializerFactory(paramSerializer), new SingletonDeserializerFactory((Deserializer)paramSerializer));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arv.runtime.FI_AR_ImportARTransactionSrv_Service_SerializerRegistry
 * JD-Core Version:    0.7.0.1
 */