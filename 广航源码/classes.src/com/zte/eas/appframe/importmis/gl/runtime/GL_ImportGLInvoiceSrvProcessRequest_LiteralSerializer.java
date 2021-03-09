package com.zte.eas.appframe.importmis.gl.runtime;

import com.zte.eas.appframe.importmis.gl.GL_ImportGLInvoiceSrvProcessRequest;
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

public class GL_ImportGLInvoiceSrvProcessRequest_LiteralSerializer
  extends LiteralObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_invoiceId_QNAME = new QName("http://eas.zte.com.cn/all/GL_ImportGLInvoiceSrv", "invoiceId");
  private static final QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
  private CombinedSerializer myns2_string__java_lang_String_String_Serializer;
  private static final QName ns1_invoicedate_QNAME = new QName("http://eas.zte.com.cn/all/GL_ImportGLInvoiceSrv", "invoicedate");
  private static final QName ns2_dateTime_TYPE_QNAME = SchemaConstants.QNAME_TYPE_DATE_TIME;
  private CombinedSerializer myns2_dateTime__java_util_Calendar_DateTimeCalendar_Serializer;
  
  public GL_ImportGLInvoiceSrvProcessRequest_LiteralSerializer(QName paramQName)
  {
    this(paramQName, false);
  }
  
  public GL_ImportGLInvoiceSrvProcessRequest_LiteralSerializer(QName paramQName, boolean paramBoolean)
  {
    super(paramQName, true, paramBoolean);
    setSOAPVersion(SOAPVersion.SOAP_11);
  }
  
  public void initialize(InternalTypeMappingRegistry paramInternalTypeMappingRegistry)
    throws Exception
  {
    this.myns2_string__java_lang_String_String_Serializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer("", String.class, ns2_string_TYPE_QNAME));
    this.myns2_dateTime__java_util_Calendar_DateTimeCalendar_Serializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer("", Calendar.class, ns2_dateTime_TYPE_QNAME));
  }
  
  public Object doDeserialize(XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext)
    throws Exception
  {
    GL_ImportGLInvoiceSrvProcessRequest localGL_ImportGLInvoiceSrvProcessRequest = new GL_ImportGLInvoiceSrvProcessRequest();
    Object localObject = null;
    paramXMLReader.nextElementContent();
    HashSet localHashSet = new HashSet();
    localHashSet.add("invoiceId");
    localHashSet.add("invoicedate");
    for (int i = 0; i < 2; i++)
    {
      QName localQName = paramXMLReader.getName();
      if (matchQName(localQName, ns1_invoiceId_QNAME))
      {
        this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
        localObject = this.myns2_string__java_lang_String_String_Serializer.deserialize(ns1_invoiceId_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("invoiceId");
        if (localObject == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localGL_ImportGLInvoiceSrvProcessRequest.setInvoiceId((String)localObject);
        paramSOAPDeserializationContext.setXmlFragmentWrapperName(null);
        paramXMLReader.nextElementContent();
      }
      if (matchQName(localQName, ns1_invoicedate_QNAME))
      {
        this.myns2_dateTime__java_util_Calendar_DateTimeCalendar_Serializer.setNullable(false);
        localObject = this.myns2_dateTime__java_util_Calendar_DateTimeCalendar_Serializer.deserialize(ns1_invoicedate_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("invoicedate");
        if (localObject == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localGL_ImportGLInvoiceSrvProcessRequest.setInvoicedate((Calendar)localObject);
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
    return localGL_ImportGLInvoiceSrvProcessRequest;
  }
  
  public void doSerializeAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    GL_ImportGLInvoiceSrvProcessRequest localGL_ImportGLInvoiceSrvProcessRequest = (GL_ImportGLInvoiceSrvProcessRequest)paramObject;
  }
  
  public void doSerializeAnyAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    GL_ImportGLInvoiceSrvProcessRequest localGL_ImportGLInvoiceSrvProcessRequest = (GL_ImportGLInvoiceSrvProcessRequest)paramObject;
  }
  
  public void doSerialize(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    GL_ImportGLInvoiceSrvProcessRequest localGL_ImportGLInvoiceSrvProcessRequest = (GL_ImportGLInvoiceSrvProcessRequest)paramObject;
    this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
    this.myns2_string__java_lang_String_String_Serializer.serialize(localGL_ImportGLInvoiceSrvProcessRequest.getInvoiceId(), ns1_invoiceId_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
    this.myns2_dateTime__java_util_Calendar_DateTimeCalendar_Serializer.setNullable(false);
    this.myns2_dateTime__java_util_Calendar_DateTimeCalendar_Serializer.serialize(localGL_ImportGLInvoiceSrvProcessRequest.getInvoicedate(), ns1_invoicedate_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.gl.runtime.GL_ImportGLInvoiceSrvProcessRequest_LiteralSerializer
 * JD-Core Version:    0.7.0.1
 */