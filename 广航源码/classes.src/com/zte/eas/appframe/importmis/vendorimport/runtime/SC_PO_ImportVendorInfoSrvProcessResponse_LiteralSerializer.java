package com.zte.eas.appframe.importmis.vendorimport.runtime;

import com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrvProcessResponse;
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

public class SC_PO_ImportVendorInfoSrvProcessResponse_LiteralSerializer
  extends LiteralObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_ErrorFlag_QNAME = new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "ErrorFlag");
  private static final QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
  private CombinedSerializer myns2_string__java_lang_String_String_Serializer;
  private static final QName ns1_ErrorMessage_QNAME = new QName("http://eas.zte.com.cn/all/SC_PO_ImportVendorInfoSrv", "ErrorMessage");
  
  public SC_PO_ImportVendorInfoSrvProcessResponse_LiteralSerializer(QName paramQName)
  {
    this(paramQName, false);
  }
  
  public SC_PO_ImportVendorInfoSrvProcessResponse_LiteralSerializer(QName paramQName, boolean paramBoolean)
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
    SC_PO_ImportVendorInfoSrvProcessResponse localSC_PO_ImportVendorInfoSrvProcessResponse = new SC_PO_ImportVendorInfoSrvProcessResponse();
    Object localObject = null;
    paramXMLReader.nextElementContent();
    HashSet localHashSet = new HashSet();
    localHashSet.add("ErrorFlag");
    localHashSet.add("ErrorMessage");
    for (int i = 0; i < 2; i++)
    {
      QName localQName = paramXMLReader.getName();
      if (matchQName(localQName, ns1_ErrorFlag_QNAME))
      {
        this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
        localObject = this.myns2_string__java_lang_String_String_Serializer.deserialize(ns1_ErrorFlag_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("ErrorFlag");
        if (localObject == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localSC_PO_ImportVendorInfoSrvProcessResponse.setErrorFlag((String)localObject);
        paramSOAPDeserializationContext.setXmlFragmentWrapperName(null);
        paramXMLReader.nextElementContent();
      }
      if (matchQName(localQName, ns1_ErrorMessage_QNAME))
      {
        this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
        localObject = this.myns2_string__java_lang_String_String_Serializer.deserialize(ns1_ErrorMessage_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("ErrorMessage");
        if (localObject == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localSC_PO_ImportVendorInfoSrvProcessResponse.setErrorMessage((String)localObject);
        paramSOAPDeserializationContext.setXmlFragmentWrapperName(null);
        paramXMLReader.nextElementContent();
      }
    }
    if (!localHashSet.isEmpty()) {
      throw new DeserializationException("literal.expectedElementName", localHashSet.iterator().next().toString(), 1);
    }
    if (paramXMLReader.getState() != 2) {
      paramXMLReader.skipElement();
    }
    XMLReaderUtil.verifyReaderState(paramXMLReader, 2);
    return localSC_PO_ImportVendorInfoSrvProcessResponse;
  }
  
  public void doSerializeAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    SC_PO_ImportVendorInfoSrvProcessResponse localSC_PO_ImportVendorInfoSrvProcessResponse = (SC_PO_ImportVendorInfoSrvProcessResponse)paramObject;
  }
  
  public void doSerializeAnyAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    SC_PO_ImportVendorInfoSrvProcessResponse localSC_PO_ImportVendorInfoSrvProcessResponse = (SC_PO_ImportVendorInfoSrvProcessResponse)paramObject;
  }
  
  public void doSerialize(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    SC_PO_ImportVendorInfoSrvProcessResponse localSC_PO_ImportVendorInfoSrvProcessResponse = (SC_PO_ImportVendorInfoSrvProcessResponse)paramObject;
    this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
    this.myns2_string__java_lang_String_String_Serializer.serialize(localSC_PO_ImportVendorInfoSrvProcessResponse.getErrorFlag(), ns1_ErrorFlag_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
    this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
    this.myns2_string__java_lang_String_String_Serializer.serialize(localSC_PO_ImportVendorInfoSrvProcessResponse.getErrorMessage(), ns1_ErrorMessage_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.vendorimport.runtime.SC_PO_ImportVendorInfoSrvProcessResponse_LiteralSerializer
 * JD-Core Version:    0.7.0.1
 */