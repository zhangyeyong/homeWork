package com.zte.eas.appframe.sync.runtime;

import com.zte.eas.appframe.sync.ALLBPELSYNCProcessRequest;
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

public class ALLBPELSYNCProcessRequest_LiteralSerializer
  extends LiteralObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_syncType_QNAME = new QName("http://eas.zte.com.cn/all/ALLBPELSYNC", "syncType");
  private static final QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
  private CombinedSerializer myns2_string__java_lang_String_String_Serializer;
  
  public ALLBPELSYNCProcessRequest_LiteralSerializer(QName paramQName)
  {
    this(paramQName, false);
  }
  
  public ALLBPELSYNCProcessRequest_LiteralSerializer(QName paramQName, boolean paramBoolean)
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
    ALLBPELSYNCProcessRequest localALLBPELSYNCProcessRequest = new ALLBPELSYNCProcessRequest();
    Object localObject = null;
    paramXMLReader.nextElementContent();
    HashSet localHashSet = new HashSet();
    localHashSet.add("syncType");
    QName localQName = paramXMLReader.getName();
    if (matchQName(localQName, ns1_syncType_QNAME))
    {
      this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
      localObject = this.myns2_string__java_lang_String_String_Serializer.deserialize(ns1_syncType_QNAME, paramXMLReader, paramSOAPDeserializationContext);
      localHashSet.remove("syncType");
      if (localObject == null) {
        throw new DeserializationException("literal.unexpectedNull", 1);
      }
      localALLBPELSYNCProcessRequest.setSyncType((String)localObject);
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
    return localALLBPELSYNCProcessRequest;
  }
  
  public void doSerializeAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    ALLBPELSYNCProcessRequest localALLBPELSYNCProcessRequest = (ALLBPELSYNCProcessRequest)paramObject;
  }
  
  public void doSerializeAnyAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    ALLBPELSYNCProcessRequest localALLBPELSYNCProcessRequest = (ALLBPELSYNCProcessRequest)paramObject;
  }
  
  public void doSerialize(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    ALLBPELSYNCProcessRequest localALLBPELSYNCProcessRequest = (ALLBPELSYNCProcessRequest)paramObject;
    this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
    this.myns2_string__java_lang_String_String_Serializer.serialize(localALLBPELSYNCProcessRequest.getSyncType(), ns1_syncType_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.sync.runtime.ALLBPELSYNCProcessRequest_LiteralSerializer
 * JD-Core Version:    0.7.0.1
 */