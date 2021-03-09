package com.zte.eas.appframe.importmis.assetreduice.runtime;

import com.zte.eas.appframe.importmis.assetreduice.FI_FA_ImportAssetDevalueSrvProcessRequest;
import com.zte.eas.appframe.importmis.assetreduice.FI_FA_ImportAssetDevalueSrvProcessResponse;
import com.zte.eas.appframe.importmis.assetreduice.LineIDCollection;
import com.zte.eas.appframe.importmis.assetreduice.LineIDItem;
import com.zte.eas.appframe.importmis.assetreduice.types.com.oracle.xmlns.pcbpel.adapter.db.getdata.GetDataInput;
import com.zte.eas.appframe.importmis.assetreduice.types.com.oracle.xmlns.pcbpel.adapter.db.getdata.GetDataOutput;
import com.zte.eas.appframe.importmis.assetreduice.types.com.oracle.xmlns.pcbpel.adapter.db.getdata.GetDataOutputCollection;
import com.zte.eas.appframe.importmis.assetreduice.types.com.oracle.xmlns.pcbpel.adapter.db.getdata.runtime.GetDataInput_LiteralSerializer;
import com.zte.eas.appframe.importmis.assetreduice.types.com.oracle.xmlns.pcbpel.adapter.db.getdata.runtime.GetDataOutputCollection_LiteralSerializer;
import com.zte.eas.appframe.importmis.assetreduice.types.com.oracle.xmlns.pcbpel.adapter.db.getdata.runtime.GetDataOutput_LiteralSerializer;
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

public class FI_FA_ImportAssetDevalueSrv_Service_SerializerRegistry
  extends SerializerRegistryBase
  implements SerializerConstants
{
  public TypeMappingRegistry getRegistry()
  {
    TypeMappingRegistry localTypeMappingRegistry = BasicService.createStandardTypeMappingRegistry();
    TypeMapping localTypeMapping1 = localTypeMappingRegistry.getTypeMapping(SOAPEncodingConstants.getSOAPEncodingConstants(SOAPVersion.SOAP_11).getURIEncoding());
    TypeMapping localTypeMapping2 = localTypeMappingRegistry.getTypeMapping("");
    Object localObject1 = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/GetData", "GetDataOutputCollection");
    Object localObject2 = new GetDataOutputCollection_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, GetDataOutputCollection.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/GetData", "GetDataOutput");
    localObject2 = new GetDataOutput_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, GetDataOutput.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetDevalueSrv", "LineIDCollection");
    localObject2 = new LineIDCollection_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, LineIDCollection.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetDevalueSrv", "FI_FA_ImportAssetDevalueSrvProcessResponse");
    localObject2 = new FI_FA_ImportAssetDevalueSrvProcessResponse_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, FI_FA_ImportAssetDevalueSrvProcessResponse.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/GetData", "GetDataInput");
    localObject2 = new GetDataInput_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, GetDataInput.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetDevalueSrv", "FI_FA_ImportAssetDevalueSrvProcessRequest");
    localObject2 = new FI_FA_ImportAssetDevalueSrvProcessRequest_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, FI_FA_ImportAssetDevalueSrvProcessRequest.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetDevalueSrv", "LineIDItem");
    localObject2 = new LineIDItem_LiteralSerializer((QName)localObject1, false);
    registerSerializer(localTypeMapping2, LineIDItem.class, (QName)localObject1, (Serializer)localObject2);
    localObject1 = new FI_FA_ImportAssetDevalueSrv_Service_SerializerRegistry12();
    return ((FI_FA_ImportAssetDevalueSrv_Service_SerializerRegistry12)localObject1).getRegistry(localTypeMappingRegistry);
  }
  
  private static void registerSerializer(TypeMapping paramTypeMapping, Class paramClass, QName paramQName, Serializer paramSerializer)
  {
    paramTypeMapping.register(paramClass, paramQName, new SingletonSerializerFactory(paramSerializer), new SingletonDeserializerFactory((Deserializer)paramSerializer));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetreduice.runtime.FI_FA_ImportAssetDevalueSrv_Service_SerializerRegistry
 * JD-Core Version:    0.7.0.1
 */