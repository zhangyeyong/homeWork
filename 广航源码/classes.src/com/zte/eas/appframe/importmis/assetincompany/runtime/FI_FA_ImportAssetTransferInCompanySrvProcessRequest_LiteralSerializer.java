package com.zte.eas.appframe.importmis.assetincompany.runtime;

import com.zte.eas.appframe.importmis.assetincompany.FI_FA_ImportAssetTransferInCompanySrvProcessRequest;
import com.zte.eas.appframe.importmis.assetincompany.LineIDCollection;
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

public class FI_FA_ImportAssetTransferInCompanySrvProcessRequest_LiteralSerializer
  extends LiteralObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_LineIds_QNAME = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetTransferInCompanySrv", "LineIds");
  private static final QName ns1_LineIDCollection_TYPE_QNAME = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetTransferInCompanySrv", "LineIDCollection");
  private CombinedSerializer myns1_LineIDCollection__LineIDCollection_LiteralSerializer;
  private static final QName ns1_EmployeeNumber_QNAME = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetTransferInCompanySrv", "EmployeeNumber");
  private static final QName ns2_string_TYPE_QNAME = SchemaConstants.QNAME_TYPE_STRING;
  private CombinedSerializer myns2_string__java_lang_String_String_Serializer;
  
  public FI_FA_ImportAssetTransferInCompanySrvProcessRequest_LiteralSerializer(QName paramQName)
  {
    this(paramQName, false);
  }
  
  public FI_FA_ImportAssetTransferInCompanySrvProcessRequest_LiteralSerializer(QName paramQName, boolean paramBoolean)
  {
    super(paramQName, true, paramBoolean);
    setSOAPVersion(SOAPVersion.SOAP_11);
  }
  
  public void initialize(InternalTypeMappingRegistry paramInternalTypeMappingRegistry)
    throws Exception
  {
    this.myns1_LineIDCollection__LineIDCollection_LiteralSerializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer("", LineIDCollection.class, ns1_LineIDCollection_TYPE_QNAME));
    this.myns2_string__java_lang_String_String_Serializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer("", String.class, ns2_string_TYPE_QNAME));
  }
  
  public Object doDeserialize(XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext)
    throws Exception
  {
    FI_FA_ImportAssetTransferInCompanySrvProcessRequest localFI_FA_ImportAssetTransferInCompanySrvProcessRequest = new FI_FA_ImportAssetTransferInCompanySrvProcessRequest();
    Object localObject = null;
    paramXMLReader.nextElementContent();
    HashSet localHashSet = new HashSet();
    localHashSet.add("LineIds");
    localHashSet.add("EmployeeNumber");
    for (int i = 0; i < 2; i++)
    {
      QName localQName = paramXMLReader.getName();
      if (matchQName(localQName, ns1_LineIds_QNAME))
      {
        this.myns1_LineIDCollection__LineIDCollection_LiteralSerializer.setNullable(false);
        localObject = this.myns1_LineIDCollection__LineIDCollection_LiteralSerializer.deserialize(ns1_LineIds_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("LineIds");
        if (localObject == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localFI_FA_ImportAssetTransferInCompanySrvProcessRequest.setLineIds((LineIDCollection)localObject);
        paramSOAPDeserializationContext.setXmlFragmentWrapperName(null);
        paramXMLReader.nextElementContent();
      }
      if (matchQName(localQName, ns1_EmployeeNumber_QNAME))
      {
        this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
        localObject = this.myns2_string__java_lang_String_String_Serializer.deserialize(ns1_EmployeeNumber_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("EmployeeNumber");
        if (localObject == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localFI_FA_ImportAssetTransferInCompanySrvProcessRequest.setEmployeeNumber((String)localObject);
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
    return localFI_FA_ImportAssetTransferInCompanySrvProcessRequest;
  }
  
  public void doSerializeAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    FI_FA_ImportAssetTransferInCompanySrvProcessRequest localFI_FA_ImportAssetTransferInCompanySrvProcessRequest = (FI_FA_ImportAssetTransferInCompanySrvProcessRequest)paramObject;
  }
  
  public void doSerializeAnyAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    FI_FA_ImportAssetTransferInCompanySrvProcessRequest localFI_FA_ImportAssetTransferInCompanySrvProcessRequest = (FI_FA_ImportAssetTransferInCompanySrvProcessRequest)paramObject;
  }
  
  public void doSerialize(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    FI_FA_ImportAssetTransferInCompanySrvProcessRequest localFI_FA_ImportAssetTransferInCompanySrvProcessRequest = (FI_FA_ImportAssetTransferInCompanySrvProcessRequest)paramObject;
    this.myns1_LineIDCollection__LineIDCollection_LiteralSerializer.setNullable(false);
    this.myns1_LineIDCollection__LineIDCollection_LiteralSerializer.serialize(localFI_FA_ImportAssetTransferInCompanySrvProcessRequest.getLineIds(), ns1_LineIds_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
    this.myns2_string__java_lang_String_String_Serializer.setNullable(false);
    this.myns2_string__java_lang_String_String_Serializer.serialize(localFI_FA_ImportAssetTransferInCompanySrvProcessRequest.getEmployeeNumber(), ns1_EmployeeNumber_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetincompany.runtime.FI_FA_ImportAssetTransferInCompanySrvProcessRequest_LiteralSerializer
 * JD-Core Version:    0.7.0.1
 */