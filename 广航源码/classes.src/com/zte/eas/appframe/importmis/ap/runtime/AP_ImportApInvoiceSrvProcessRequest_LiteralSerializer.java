package com.zte.eas.appframe.importmis.ap.runtime;

import com.zte.eas.appframe.importmis.ap.AP_ImportApInvoiceSrvProcessRequest;
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

public class AP_ImportApInvoiceSrvProcessRequest_LiteralSerializer
  extends LiteralObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_boeHeaderId_QNAME = new QName("http://eas.zte.com.cn/all/AP_ImportApInvoiceSrv", "boeHeaderId");
  private static final QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
  private CombinedSerializer myns2_string__java_lang_String_String_Serializer;
  private static final QName ns1_invoiceData_QNAME = new QName("http://eas.zte.com.cn/all/AP_ImportApInvoiceSrv", "invoiceData");
  private static final QName ns2_date_TYPE_QNAME = SchemaConstants.QNAME_TYPE_DATE;
  private CombinedSerializer myns2_date__java_util_Calendar_DateCalendar_Serializer;
  
  public AP_ImportApInvoiceSrvProcessRequest_LiteralSerializer(QName paramQName)
  {
    this(paramQName, false);
  }
  
  public AP_ImportApInvoiceSrvProcessRequest_LiteralSerializer(QName paramQName, boolean paramBoolean)
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
    AP_ImportApInvoiceSrvProcessRequest localAP_ImportApInvoiceSrvProcessRequest = new AP_ImportApInvoiceSrvProcessRequest();
    Object localObject = null;
    paramXMLReader.nextElementContent();
    HashSet localHashSet = new HashSet();
    localHashSet.add("boeHeaderId");
    localHashSet.add("invoiceData");
    for (int i = 0; i < 2; i++)
    {
      QName localQName = paramXMLReader.getName();
      if (matchQName(localQName, ns1_boeHeaderId_QNAME))
      {
        this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
        localObject = this.myns2_string__java_lang_String_String_Serializer.deserialize(ns1_boeHeaderId_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("boeHeaderId");
        if (localObject == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localAP_ImportApInvoiceSrvProcessRequest.setBoeHeaderId((String)localObject);
        paramSOAPDeserializationContext.setXmlFragmentWrapperName(null);
        paramXMLReader.nextElementContent();
      }
      if (matchQName(localQName, ns1_invoiceData_QNAME))
      {
        this.myns2_date__java_util_Calendar_DateCalendar_Serializer.setNullable(false);
        localObject = this.myns2_date__java_util_Calendar_DateCalendar_Serializer.deserialize(ns1_invoiceData_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("invoiceData");
        if (localObject == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localAP_ImportApInvoiceSrvProcessRequest.setInvoiceData((Calendar)localObject);
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
    return localAP_ImportApInvoiceSrvProcessRequest;
  }
  
  public void doSerializeAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    AP_ImportApInvoiceSrvProcessRequest localAP_ImportApInvoiceSrvProcessRequest = (AP_ImportApInvoiceSrvProcessRequest)paramObject;
  }
  
  public void doSerializeAnyAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    AP_ImportApInvoiceSrvProcessRequest localAP_ImportApInvoiceSrvProcessRequest = (AP_ImportApInvoiceSrvProcessRequest)paramObject;
  }
  
  public void doSerialize(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    AP_ImportApInvoiceSrvProcessRequest localAP_ImportApInvoiceSrvProcessRequest = (AP_ImportApInvoiceSrvProcessRequest)paramObject;
    this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
    this.myns2_string__java_lang_String_String_Serializer.serialize(localAP_ImportApInvoiceSrvProcessRequest.getBoeHeaderId(), ns1_boeHeaderId_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
    this.myns2_date__java_util_Calendar_DateCalendar_Serializer.setNullable(false);
    this.myns2_date__java_util_Calendar_DateCalendar_Serializer.serialize(localAP_ImportApInvoiceSrvProcessRequest.getInvoiceData(), ns1_invoiceData_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.ap.runtime.AP_ImportApInvoiceSrvProcessRequest_LiteralSerializer
 * JD-Core Version:    0.7.0.1
 */