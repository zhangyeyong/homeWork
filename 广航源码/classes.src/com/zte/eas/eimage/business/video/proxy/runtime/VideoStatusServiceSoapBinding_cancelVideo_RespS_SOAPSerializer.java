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

public class VideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPSerializer
  extends ObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_cancelVideoReturn_QNAME = new QName("", "cancelVideoReturn");
  private static final QName ns2_boolean_TYPE_QNAME = SchemaConstants.QNAME_TYPE_BOOLEAN;
  private CombinedSerializer myns2__boolean__boolean_Boolean_Serializer;
  private static final int mycancelVideoReturn_INDEX = 0;
  
  public VideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPSerializer(QName paramQName, boolean paramBoolean1, boolean paramBoolean2, SOAPVersion paramSOAPVersion)
  {
    super(paramQName, paramBoolean1, paramBoolean2, paramSOAPVersion);
  }
  
  public void initialize(InternalTypeMappingRegistry paramInternalTypeMappingRegistry)
    throws Exception
  {
    this.myns2__boolean__boolean_Boolean_Serializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer(SOAPEncodingConstants.getSOAPEncodingConstants(this.soapVersion).getURIEncoding(), Boolean.TYPE, ns2_boolean_TYPE_QNAME));
  }
  
  public Object doDeserialize(SOAPDeserializationState paramSOAPDeserializationState, XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext)
    throws Exception
  {
    VideoStatusServiceSoapBinding_cancelVideo_RespS localVideoStatusServiceSoapBinding_cancelVideo_RespS = new VideoStatusServiceSoapBinding_cancelVideo_RespS();
    VideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPBuilder localVideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPBuilder = null;
    int i = 1;
    paramXMLReader.nextElementContent();
    QName localQName2 = paramXMLReader.getName();
    if (paramXMLReader.getState() == 1)
    {
      paramSOAPDeserializationContext.setNillable(true);
      Object localObject = this.myns2__boolean__boolean_Boolean_Serializer.deserialize(null, paramXMLReader, paramSOAPDeserializationContext);
      if ((localObject instanceof SOAPDeserializationState))
      {
        if (localVideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPBuilder == null) {
          localVideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPBuilder = new VideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPBuilder();
        }
        paramSOAPDeserializationState = registerWithMemberState(localVideoStatusServiceSoapBinding_cancelVideo_RespS, paramSOAPDeserializationState, localObject, 0, localVideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPBuilder);
        i = 0;
      }
      else if (localObject != null)
      {
        localVideoStatusServiceSoapBinding_cancelVideo_RespS.setCancelVideoReturn(((Boolean)localObject).booleanValue());
      }
      paramXMLReader.nextElementContent();
    }
    QName localQName1 = paramXMLReader.getName();
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
    return i != 0 ? localVideoStatusServiceSoapBinding_cancelVideo_RespS : paramSOAPDeserializationState;
  }
  
  public void doSerializeInstance(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    VideoStatusServiceSoapBinding_cancelVideo_RespS localVideoStatusServiceSoapBinding_cancelVideo_RespS = (VideoStatusServiceSoapBinding_cancelVideo_RespS)paramObject;
    paramSOAPSerializationContext.setNillable(true);
    this.myns2__boolean__boolean_Boolean_Serializer.serialize(new Boolean(localVideoStatusServiceSoapBinding_cancelVideo_RespS.isCancelVideoReturn()), ns1_cancelVideoReturn_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
  }
  
  protected void verifyName(XMLReader paramXMLReader, QName paramQName)
    throws Exception
  {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.eimage.business.video.proxy.runtime.VideoStatusServiceSoapBinding_cancelVideo_RespS_SOAPSerializer
 * JD-Core Version:    0.7.0.1
 */