package com.zte.eas.appframe.importmis.assetgarbage.runtime;

import com.zte.eas.appframe.importmis.assetgarbage.FI_FA_ImportAssetRetirmentSrvProcessRequest;
import com.zte.eas.appframe.importmis.assetgarbage.FI_FA_ImportAssetRetirmentSrvProcessResponse;
import com.zte.eas.appframe.importmis.assetgarbage.LineIDCollection;
import com.zte.eas.appframe.importmis.assetgarbage.LineIDItem;
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

public class FI_FA_ImportAssetRetirmentSrv_Service_SerializerRegistry
  extends SerializerRegistryBase
  implements SerializerConstants
{
  public TypeMappingRegistry getRegistry()
  {
    TypeMappingRegistry localTypeMappingRegistry = BasicService.createStandardTypeMappingRegistry();
    TypeMapping localTypeMapping1 = localTypeMappingRegistry.getTypeMapping(SOAPEncodingConstants.getSOAPEncodingConstants(SOAPVersion.SOAP_11).getURIEncoding());
    TypeMapping localTypeMapping2 = localTypeMappingRegistry.getTypeMapping("");
    Object localObject1 = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetRetirmentSrv", "LineIDCollection");
    Object localObject2 = new LineIDCollection_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, LineIDCollection.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetRetirmentSrv", "LineIDItem");
    localObject2 = new LineIDItem_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, LineIDItem.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetRetirmentSrv", "FI_FA_ImportAssetRetirmentSrvProcessRequest");
    localObject2 = new FI_FA_ImportAssetRetirmentSrvProcessRequest_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, FI_FA_ImportAssetRetirmentSrvProcessRequest.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetRetirmentSrv", "FI_FA_ImportAssetRetirmentSrvProcessResponse");
    localObject2 = new FI_FA_ImportAssetRetirmentSrvProcessResponse_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, FI_FA_ImportAssetRetirmentSrvProcessResponse.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new FI_FA_ImportAssetRetirmentSrv_Service_SerializerRegistry12();
    return ((FI_FA_ImportAssetRetirmentSrv_Service_SerializerRegistry12)localObject1).getRegistry(localTypeMappingRegistry);
  }
  
  private static void registerSerializer(TypeMapping paramTypeMapping, Class paramClass, QName paramQName, Serializer paramSerializer)
  {
    paramTypeMapping.register(paramClass, paramQName, new SingletonSerializerFactory(paramSerializer), new SingletonDeserializerFactory((Deserializer)paramSerializer));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetgarbage.runtime.FI_FA_ImportAssetRetirmentSrv_Service_SerializerRegistry
 * JD-Core Version:    0.7.0.1
 */