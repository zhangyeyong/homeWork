package com.zte.eas.appframe.importmis.assetincompany.runtime;

import com.zte.eas.appframe.importmis.assetincompany.LineIDCollection;
import com.zte.eas.appframe.importmis.assetincompany.LineIDItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import oracle.j2ee.ws.common.encoding.CombinedSerializer;
import oracle.j2ee.ws.common.encoding.DeserializationException;
import oracle.j2ee.ws.common.encoding.Initializable;
import oracle.j2ee.ws.common.encoding.InternalTypeMappingRegistry;
import oracle.j2ee.ws.common.encoding.SOAPDeserializationContext;
import oracle.j2ee.ws.common.encoding.SOAPSerializationContext;
import oracle.j2ee.ws.common.encoding.SerializationException;
import oracle.j2ee.ws.common.encoding.literal.LiteralObjectSerializerBase;
import oracle.j2ee.ws.common.soap.SOAPVersion;
import oracle.j2ee.ws.common.streaming.XMLReader;
import oracle.j2ee.ws.common.streaming.XMLReaderUtil;
import oracle.j2ee.ws.common.streaming.XMLWriter;

public class LineIDCollection_LiteralSerializer
  extends LiteralObjectSerializerBase
  implements Initializable
{
  private static final QName ns1_LineIDItem_QNAME = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetTransferInCompanySrv", "LineIDItem");
  private static final QName ns1_LineIDItem_TYPE_QNAME = new QName("http://eas.zte.com.cn/all/FI_FA_ImportAssetTransferInCompanySrv", "LineIDItem");
  private CombinedSerializer myns1_LineIDItem__LineIDItem_LiteralSerializer;
  
  public LineIDCollection_LiteralSerializer(QName paramQName)
  {
    this(paramQName, false);
  }
  
  public LineIDCollection_LiteralSerializer(QName paramQName, boolean paramBoolean)
  {
    super(paramQName, true, paramBoolean);
    setSOAPVersion(SOAPVersion.SOAP_11);
  }
  
  public void initialize(InternalTypeMappingRegistry paramInternalTypeMappingRegistry)
    throws Exception
  {
    this.myns1_LineIDItem__LineIDItem_LiteralSerializer = ((CombinedSerializer)paramInternalTypeMappingRegistry.getSerializer("", LineIDItem.class, ns1_LineIDItem_TYPE_QNAME));
  }
  
  public Object doDeserialize(XMLReader paramXMLReader, SOAPDeserializationContext paramSOAPDeserializationContext)
    throws Exception
  {
    LineIDCollection localLineIDCollection = new LineIDCollection();
    Object localObject1 = null;
    paramXMLReader.nextElementContent();
    HashSet localHashSet = new HashSet();
    QName localQName = paramXMLReader.getName();
    if ((paramXMLReader.getState() == 1) && (matchQName(localQName, ns1_LineIDItem_QNAME)))
    {
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        localQName = paramXMLReader.getName();
        if ((paramXMLReader.getState() != 1) || (!matchQName(localQName, ns1_LineIDItem_QNAME))) {
          break;
        }
        this.myns1_LineIDItem__LineIDItem_LiteralSerializer.setNullable(false);
        Object localObject2 = this.myns1_LineIDItem__LineIDItem_LiteralSerializer.deserialize(ns1_LineIDItem_QNAME, paramXMLReader, paramSOAPDeserializationContext);
        localHashSet.remove("LineIDItem");
        if (localObject2 == null) {
          throw new DeserializationException("literal.unexpectedNull", 1);
        }
        localArrayList.add(localObject2);
        paramXMLReader.nextElementContent();
      }
      localObject1 = new LineIDItem[localArrayList.size()];
      localObject1 = localArrayList.toArray((Object[])localObject1);
      localLineIDCollection.setLineIDItem((LineIDItem[])localObject1);
    }
    else if (localLineIDCollection.getLineIDItem() == null)
    {
      localLineIDCollection.setLineIDItem(new LineIDItem[0]);
    }
    if (!localHashSet.isEmpty()) {
      throw new DeserializationException("literal.expectedElementName", localHashSet.iterator().next().toString(), 1);
    }
    if (paramXMLReader.getState() != 2) {
      paramXMLReader.skipElement();
    }
    XMLReaderUtil.verifyReaderState(paramXMLReader, 2);
    return localLineIDCollection;
  }
  
  public void doSerializeAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    LineIDCollection localLineIDCollection = (LineIDCollection)paramObject;
  }
  
  public void doSerializeAnyAttributes(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    LineIDCollection localLineIDCollection = (LineIDCollection)paramObject;
  }
  
  public void doSerialize(Object paramObject, XMLWriter paramXMLWriter, SOAPSerializationContext paramSOAPSerializationContext)
    throws Exception
  {
    LineIDCollection localLineIDCollection = (LineIDCollection)paramObject;
    if (localLineIDCollection.getLineIDItem() != null) {
      for (int i = 0; i < localLineIDCollection.getLineIDItem().length; i++)
      {
        if (localLineIDCollection.getLineIDItem()[i] == null) {
          throw new SerializationException("literal.unexpectedNull");
        }
        this.myns1_LineIDItem__LineIDItem_LiteralSerializer.setNullable(false);
        this.myns1_LineIDItem__LineIDItem_LiteralSerializer.serialize(localLineIDCollection.getLineIDItem()[i], ns1_LineIDItem_QNAME, null, paramXMLWriter, paramSOAPSerializationContext);
      }
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetincompany.runtime.LineIDCollection_LiteralSerializer
 * JD-Core Version:    0.7.0.1
 */