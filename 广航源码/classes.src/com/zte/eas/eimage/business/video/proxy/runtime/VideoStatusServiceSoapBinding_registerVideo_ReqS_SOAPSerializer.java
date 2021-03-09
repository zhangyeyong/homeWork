package com.zte.eas.eimage.business.video.proxy.runtime;

import java.util.Calendar;
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

public class VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPSerializer
  extends ObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_boeNum_QNAME = new QName("", "boeNum");
  private static final QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
  private CombinedSerializer myns2_string__java_lang_String_String_Serializer;
  private static final QName ns1_uploadDate_QNAME = new QName("", "uploadDate");
  private static final QName ns2_dateTime_TYPE_QNAME = SchemaConstants.QNAME_TYPE_DATE_TIME;
  private CombinedSerializer myns2_dateTime__java_util_Calendar_DateTimeCalendar_Serializer;
  private static final int myboeNum_INDEX = 0;
  private static final int myuploadDate_INDEX = 1;
  
  public VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPSerializer(QName paramQName, boolean paramBoolean1, boolean paramBoolean2, SOAPVersion paramSOAPVersion)
  {
    super(paramQName, paramBoolean1, paramBoolean2, paramSOAPVersion);
  }
  
  public void initialize(InternalTypeMappingRegistry paramInternalTypeMappingRegistry)
    throws Exception
  {
    this.myns2_string__java_lang_String_String_Serializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer(SOAPEncodingConstants.getSOAPEncodingConstants(this.soapVersion).getURIEncoding(), String.class, ns2_string_TYPE_QNAME));
    this.myns2_dateTime__java_util_Calendar_DateTimeCalendar_Serializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer(SOAPEncodingConstants.getSOAPEncodingConstants(this.soapVersion).getURIEncoding(), Calendar.class, ns2_dateTime_TYPE_QNAME));
  }
  
  public Object doDeserialize(SOAPDeserializationState paramSOAPDeserializationState, XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext)
    throws Exception
  {
    VideoStatusServiceSoapBinding_registerVideo_ReqS localVideoStatusServiceSoapBinding_registerVideo_ReqS = new VideoStatusServiceSoapBinding_registerVideo_ReqS();
    VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder localVideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder = null;
    int i = 1;
    paramXMLReader.nextElementContent();
    QName localQName2 = paramXMLReader.getName();
    for (int j = 0; j < 2; j++)
    {
      QName localQName1 = paramXMLReader.getName();
      if (paramXMLReader.getState() == 2) {
        break;
      }
      Object localObject;
      if (matchQName(localQName1, ns1_boeNum_QNAME))
      {
        paramSOAPDeserializationContext.setNillable(true);
        localObject = this.myns2_string__java_lang_String_String_Serializer.deserialize(ns1_boeNum_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        if ((localObject instanceof SOAPDeserializationState))
        {
          if (localVideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder == null) {
            localVideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder = new VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder();
          }
          paramSOAPDeserializationState = registerWithMemberState(localVideoStatusServiceSoapBinding_registerVideo_ReqS, paramSOAPDeserializationState, localObject, 0, localVideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder);
          i = 0;
        }
        else if (localObject != null)
        {
          localVideoStatusServiceSoapBinding_registerVideo_ReqS.setBoeNum((String)localObject);
        }
        paramXMLReader.nextElementContent();
      }
      else if (matchQName(localQName1, ns1_uploadDate_QNAME))
      {
        paramSOAPDeserializationContext.setNillable(true);
        localObject = this.myns2_dateTime__java_util_Calendar_DateTimeCalendar_Serializer.deserialize(ns1_uploadDate_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        if ((localObject instanceof SOAPDeserializationState))
        {
          if (localVideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder == null) {
            localVideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder = new VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder();
          }
          paramSOAPDeserializationState = registerWithMemberState(localVideoStatusServiceSoapBinding_registerVideo_ReqS, paramSOAPDeserializationState, localObject, 1, localVideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPBuilder);
          i = 0;
        }
        else if (localObject != null)
        {
          localVideoStatusServiceSoapBinding_registerVideo_ReqS.setUploadDate((Calendar)localObject);
        }
        paramXMLReader.nextElementContent();
      }
      else
      {
        throw new DeserializationException("soap.unexpectedElementName", new Object[] { ns1_uploadDate_QNAME, localQName1 }, 1);
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
    return i != 0 ? localVideoStatusServiceSoapBinding_registerVideo_ReqS : paramSOAPDeserializationState;
  }
  
  public void doSerializeInstance(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    VideoStatusServiceSoapBinding_registerVideo_ReqS localVideoStatusServiceSoapBinding_registerVideo_ReqS = (VideoStatusServiceSoapBinding_registerVideo_ReqS)paramObject;
    paramSOAPSerializationContext.setNillable(true);
    this.myns2_string__java_lang_String_String_Serializer.serialize(localVideoStatusServiceSoapBinding_registerVideo_ReqS.getBoeNum(), ns1_boeNum_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
    paramSOAPSerializationContext.setNillable(true);
    this.myns2_dateTime__java_util_Calendar_DateTimeCalendar_Serializer.serialize(localVideoStatusServiceSoapBinding_registerVideo_ReqS.getUploadDate(), ns1_uploadDate_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.runtime.VideoStatusServiceSoapBinding_registerVideo_ReqS_SOAPSerializer
 * JD-Core Version:    0.7.0.1
 */