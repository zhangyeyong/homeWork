package com.zte.eas.appframe.importmis.ap.runtime;

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

public class AP_ImportApInvoiceSrv_Service_SerializerRegistry12
  implements SerializerConstants
{
  public TypeMappingRegistry getRegistry(TypeMappingRegistry paramTypeMappingRegistry)
  {
    TypeMapping localTypeMapping1 = paramTypeMappingRegistry.getTypeMapping(SOAPEncodingConstants.getSOAPEncodingConstants(SOAPVersion.SOAP_12).getURIEncoding());
    TypeMapping localTypeMapping2 = paramTypeMappingRegistry.getTypeMapping("");
    return paramTypeMappingRegistry;
  }
  
  private static void registerSerializer(TypeMapping paramTypeMapping, Class paramClass, QName paramQName, Serializer paramSerializer)
  {
    paramTypeMapping.register(paramClass, paramQName, new SingletonSerializerFactory(paramSerializer), new SingletonDeserializerFactory((Deserializer)paramSerializer));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.ap.runtime.AP_ImportApInvoiceSrv_Service_SerializerRegistry12
 * JD-Core Version:    0.7.0.1
 */