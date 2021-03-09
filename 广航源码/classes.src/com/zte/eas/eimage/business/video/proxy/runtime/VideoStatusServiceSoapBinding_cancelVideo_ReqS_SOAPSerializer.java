package com.zte.eas.eimage.business.video.proxy.runtime;

import javax.xml.namespace.QName;
import oracle.j2ee.ws.common.encoding.CombinedSerializer;
import oracle.j2ee.ws.common.encoding.DeserializationException;
import oracle.j2ee.ws.common.encoding.Initializable;
import oracle.j2ee.ws.common.encoding.InternalTypeMappingRegistry;
import oracle.j2ee.ws.common.encoding.ObjectSerializerBase;
import oracle.j2ee.ws.common.encoding.SOAPDeserializationContext;
import oracle.j2ee.ws.common.encoding.SOAPDeserializationState;
import oracle.j2ee.ws.common.encoding.SOAPSerializationContext;
import oracle.j2ee.ws.common.soap.SOAPEncodingConstants;
import oracle.j2ee.ws.common.soap.SOAPVersion;
import oracle.j2ee.ws.common.streaming.XMLReader;
import oracle.j2ee.ws.common.streaming.XMLReaderException;
import oracle.j2ee.ws.common.streaming.XMLReaderUtil;
import oracle.j2ee.ws.common.streaming.XMLWriter;
import oracle.j2ee.ws.common.wsdl.document.schema.SchemaConstants;

public class VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPSerializer
  extends ObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_boeNum_QNAME = new QName("", "boeNum");
  private static final QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
  private CombinedSerializer myns2_string__java_lang_String_String_Serializer;
  private static final int myboeNum_INDEX = 0;
  
  public VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPSerializer(QName paramQName, boolean paramBoolean1, boolean paramBoolean2, SOAPVersion paramSOAPVersion)
  {
    super(paramQName, paramBoolean1, paramBoolean2, paramSOAPVersion);
  }
  
  public void initialize(InternalTypeMappingRegistry paramInternalTypeMappingRegistry)
    throws Exception
  {
    this.myns2_string__java_lang_String_String_Serializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer(SOAPEncodingConstants.getSOAPEncodingConstants(this.soapVersion).getURIEncoding(), String.class, ns2_string_TYPE_QNAME));
  }
  
  public Object doDeserialize(SOAPDeserializationState paramSOAPDeserializationState, XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext)
    throws Exception
  {
    VideoStatusServiceSoapBinding_cancelVideo_ReqS localVideoStatusServiceSoapBinding_cancelVideo_ReqS = new VideoStatusServiceSoapBinding_cancelVideo_ReqS();
    VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPBuilder localVideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPBuilder = null;
    int i = 1;
    paramXMLReader.nextElementContent();
    QName localQName2 = paramXMLReader.getName();
    QName localQName1 = paramXMLReader.getName();
    if (paramXMLReader.getState() == 1) {
      if (matchQName(localQName1, ns1_boeNum_QNAME))
      {
        paramSOAPDeserializationContext.setNillable(true);
        Object localObject = this.myns2_string__java_lang_String_String_Serializer.deserialize(ns1_boeNum_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        if ((localObject instanceof SOAPDeserializationState))
        {
          if (localVideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPBuilder == null) {
            localVideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPBuilder = new VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPBuilder();
          }
          paramSOAPDeserializationState = registerWithMemberState(localVideoStatusServiceSoapBinding_cancelVideo_ReqS, paramSOAPDeserializationState, localObject, 0, localVideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPBuilder);
          i = 0;
        }
        else if (localObject != null)
        {
          localVideoStatusServiceSoapBinding_cancelVideo_ReqS.setBoeNum((String)localObject);
        }
        paramXMLReader.nextElementContent();
      }
      else
      {
        throw new DeserializationException("soap.unexpectedElementName", new Object[] { ns1_boeNum_QNAME, localQName1 }, 1);
      }
    }
    try
    {
      XMLReaderUtil.verifyReaderState(paramXMLReader, 2);
    }
    catch (XMLReaderException localXMLReaderException)
    {
      if (localQName2 != null) {
        throw new DeserializationException("Expect END: " + localQName2, localXMLReaderException);
      }
      throw localXMLReaderException;
    }
    return i != 0 ? localVideoStatusServiceSoapBinding_cancelVideo_ReqS : paramSOAPDeserializationState;
  }
  
  public void doSerializeInstance(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    VideoStatusServiceSoapBinding_cancelVideo_ReqS localVideoStatusServiceSoapBinding_cancelVideo_ReqS = (VideoStatusServiceSoapBinding_cancelVideo_ReqS)paramObject;
    paramSOAPSerializationContext.setNillable(true);
    this.myns2_string__java_lang_String_String_Serializer.serialize(localVideoStatusServiceSoapBinding_cancelVideo_ReqS.getBoeNum(), ns1_boeNum_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.runtime.VideoStatusServiceSoapBinding_cancelVideo_ReqS_SOAPSerializer
 * JD-Core Version:    0.7.0.1
 */