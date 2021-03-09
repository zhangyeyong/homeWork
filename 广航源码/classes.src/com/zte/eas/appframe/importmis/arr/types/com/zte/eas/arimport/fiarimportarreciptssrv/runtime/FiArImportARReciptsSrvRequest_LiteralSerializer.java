package com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.runtime;

import com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.FiArImportARReciptsSrvRequest;
import java.util.Calendar;
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

public class FiArImportARReciptsSrvRequest_LiteralSerializer
  extends LiteralObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_boeHeaders_QNAME = new QName("http://eas.zte.com/ArImport/FiArImportARReciptsSrv", "boeHeaders");
  private static final QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
  private CombinedSerializer myns2_string__java_lang_String_String_Serializer;
  private static final QName ns1_importDate_QNAME = new QName("http://eas.zte.com/ArImport/FiArImportARReciptsSrv", "importDate");
  private static final QName ns2_date_TYPE_QNAME = SchemaConstants.QNAME_TYPE_DATE;
  private CombinedSerializer myns2_date__java_util_Calendar_DateCalendar_Serializer;
  
  public FiArImportARReciptsSrvRequest_LiteralSerializer(QName paramQName)
  {
    this(paramQName, false);
  }
  
  public FiArImportARReciptsSrvRequest_LiteralSerializer(QName paramQName, boolean paramBoolean)
  {
    super(paramQName, true, paramBoolean);
    setSOAPVersion(SOAPVersion.SOAP_11);
  }
  
  public void initialize(InternalTypeMappingRegistry paramInternalTypeMappingRegistry)
    throws Exception
  {
    this.myns2_string__java_lang_String_String_Serializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer("", String.class, ns2_string_TYPE_QNAME));
    this.myns2_date__java_util_Calendar_DateCalendar_Serializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer("", Calendar.class, ns2_date_TYPE_QNAME));
  }
  
  public Object doDeserialize(XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext)
    throws Exception
  {
    FiArImportARReciptsSrvRequest localFiArImportARReciptsSrvRequest = new FiArImportARReciptsSrvRequest();
    Object localObject = null;
    paramXMLReader.nextElementContent();
    HashSet localHashSet = new HashSet();
    localHashSet.add("boeHeaders");
    localHashSet.add("importDate");
    for (int i = 0; i < 2; i++)
    {
      QName localQName = paramXMLReader.getName();
      if (matchQName(localQName, ns1_boeHeaders_QNAME))
      {
        this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
        localObject = this.myns2_string__java_lang_String_String_Serializer.deserialize(ns1_boeHeaders_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("boeHeaders");
        if (localObject == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localFiArImportARReciptsSrvRequest.setBoeHeaders((String)localObject);
        paramSOAPDeserializationContext.setXmlFragmentWrapperName(null);
        paramXMLReader.nextElementContent();
      }
      if (matchQName(localQName, ns1_importDate_QNAME))
      {
        this.myns2_date__java_util_Calendar_DateCalendar_Serializer.setNullable(false);
        localObject = this.myns2_date__java_util_Calendar_DateCalendar_Serializer.deserialize(ns1_importDate_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("importDate");
        if (localObject == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localFiArImportARReciptsSrvRequest.setImportDate((Calendar)localObject);
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
    return localFiArImportARReciptsSrvRequest;
  }
  
  public void doSerializeAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    FiArImportARReciptsSrvRequest localFiArImportARReciptsSrvRequest = (FiArImportARReciptsSrvRequest)paramObject;
  }
  
  public void doSerializeAnyAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    FiArImportARReciptsSrvRequest localFiArImportARReciptsSrvRequest = (FiArImportARReciptsSrvRequest)paramObject;
  }
  
  public void doSerialize(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    FiArImportARReciptsSrvRequest localFiArImportARReciptsSrvRequest = (FiArImportARReciptsSrvRequest)paramObject;
    this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
    this.myns2_string__java_lang_String_String_Serializer.serialize(localFiArImportARReciptsSrvRequest.getBoeHeaders(), ns1_boeHeaders_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
    this.myns2_date__java_util_Calendar_DateCalendar_Serializer.setNullable(false);
    this.myns2_date__java_util_Calendar_DateCalendar_Serializer.serialize(localFiArImportARReciptsSrvRequest.getImportDate(), ns1_importDate_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.runtime.FiArImportARReciptsSrvRequest_LiteralSerializer
 * JD-Core Version:    0.7.0.1
 */