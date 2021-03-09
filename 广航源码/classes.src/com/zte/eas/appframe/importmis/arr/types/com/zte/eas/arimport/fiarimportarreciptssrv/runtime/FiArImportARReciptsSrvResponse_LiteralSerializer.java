package com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.runtime;

import com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.FiArImportARReciptsSrvResponse;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.namespace.QName;
import oracle.j2ee.ws.common.encoding.CombinedSerializer;
import oracle.j2ee.ws.common.encoding.DeserializationException;
import oracle.j2ee.ws.common.encoding.Initializable;
import oracle.j2ee.ws.common.encoding.InternalTypeMappingRegistry;
import oracle.j2ee.ws.common.encoding.SOAPDeserializationContext;
import oracle.j2ee.ws.common.encoding.SOAPSerializationContext;
import oracle.j2ee.ws.common.encoding.literal.LiteralObjectSerializerBase;
import oracle.j2ee.ws.common.soap.SOAPVersion;
import oracle.j2ee.ws.common.streaming.XMLReader;
import oracle.j2ee.ws.common.streaming.XMLReaderUtil;
import oracle.j2ee.ws.common.streaming.XMLWriter;
import oracle.j2ee.ws.common.wsdl.document.schema.SchemaConstants;

public class FiArImportARReciptsSrvResponse_LiteralSerializer
  extends LiteralObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_result_QNAME = new QName("http://eas.zte.com/ArImport/FiArImportARReciptsSrv", "result");
  private static final QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
  private CombinedSerializer myns2_string__java_lang_String_String_Serializer;
  
  public FiArImportARReciptsSrvResponse_LiteralSerializer(QName paramQName)
  {
    this(paramQName, false);
  }
  
  public FiArImportARReciptsSrvResponse_LiteralSerializer(QName paramQName, boolean paramBoolean)
  {
    super(paramQName, true, paramBoolean);
    setSOAPVersion(SOAPVersion.SOAP_11);
  }
  
  public void initialize(InternalTypeMappingRegistry paramInternalTypeMappingRegistry)
    throws Exception
  {
    this.myns2_string__java_lang_String_String_Serializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer("", String.class, ns2_string_TYPE_QNAME));
  }
  
  public Object doDeserialize(XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext)
    throws Exception
  {
    FiArImportARReciptsSrvResponse localFiArImportARReciptsSrvResponse = new FiArImportARReciptsSrvResponse();
    Object localObject = null;
    paramXMLReader.nextElementContent();
    HashSet localHashSet = new HashSet();
    localHashSet.add("result");
    QName localQName = paramXMLReader.getName();
    if (matchQName(localQName, ns1_result_QNAME))
    {
      this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
      localObject = this.myns2_string__java_lang_String_String_Serializer.deserialize(ns1_result_QNAME, paramXMLReader, paramSOAPDeserializationContext);
      localHashSet.remove("result");
      if (localObject == null) {
        throw new DeserializationException("literal.unexpectedNull", 1);
      }
      localFiArImportARReciptsSrvResponse.setResult((String)localObject);
      paramSOAPDeserializationContext.setXmlFragmentWrapperName(null);
      paramXMLReader.nextElementContent();
    }
    if (!localHashSet.isEmpty()) {
      throw new DeserializationException("literal.expectedElementName", localHashSet.iterator().next().toString(), 1);
    }
    if (paramXMLReader.getState() != 2) {
      paramXMLReader.skipElement();
    }
    XMLReaderUtil.verifyReaderState(paramXMLReader, 2);
    return localFiArImportARReciptsSrvResponse;
  }
  
  public void doSerializeAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    FiArImportARReciptsSrvResponse localFiArImportARReciptsSrvResponse = (FiArImportARReciptsSrvResponse)paramObject;
  }
  
  public void doSerializeAnyAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    FiArImportARReciptsSrvResponse localFiArImportARReciptsSrvResponse = (FiArImportARReciptsSrvResponse)paramObject;
  }
  
  public void doSerialize(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    FiArImportARReciptsSrvResponse localFiArImportARReciptsSrvResponse = (FiArImportARReciptsSrvResponse)paramObject;
    this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
    this.myns2_string__java_lang_String_String_Serializer.serialize(localFiArImportARReciptsSrvResponse.getResult(), ns1_result_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.runtime.FiArImportARReciptsSrvResponse_LiteralSerializer
 * JD-Core Version:    0.7.0.1
 */