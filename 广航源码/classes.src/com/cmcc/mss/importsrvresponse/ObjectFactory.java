package com.cmcc.mss.importsrvresponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _ErrorItem_QNAME = new QName("http://mss.cmcc.com/ImportSrvResponse", "ErrorItem");
  private static final QName _ErrorCollection_QNAME = new QName("http://mss.cmcc.com/ImportSrvResponse", "ErrorCollection");
  private static final QName _ResponseItem_QNAME = new QName("http://mss.cmcc.com/ImportSrvResponse", "ResponseItem");
  private static final QName _ResponseCollecion_QNAME = new QName("http://mss.cmcc.com/ImportSrvResponse", "ResponseCollecion");
  
  public ImportSrvResponse createImportSrvResponse()
  {
    return new ImportSrvResponse();
  }
  
  public ResponseCollecion createResponseCollecion()
  {
    return new ResponseCollecion();
  }
  
  public ErrorCollection createErrorCollection()
  {
    return new ErrorCollection();
  }
  
  public ResponseItem createResponseItem()
  {
    return new ResponseItem();
  }
  
  public ErrorItem createErrorItem()
  {
    return new ErrorItem();
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/ImportSrvResponse", name="ErrorItem")
  public JAXBElement<ErrorItem> createErrorItem(ErrorItem paramErrorItem)
  {
    return new JAXBElement(_ErrorItem_QNAME, ErrorItem.class, null, paramErrorItem);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/ImportSrvResponse", name="ErrorCollection")
  public JAXBElement<ErrorCollection> createErrorCollection(ErrorCollection paramErrorCollection)
  {
    return new JAXBElement(_ErrorCollection_QNAME, ErrorCollection.class, null, paramErrorCollection);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/ImportSrvResponse", name="ResponseItem")
  public JAXBElement<ResponseItem> createResponseItem(ResponseItem paramResponseItem)
  {
    return new JAXBElement(_ResponseItem_QNAME, ResponseItem.class, null, paramResponseItem);
  }
  
  @XmlElementDecl(namespace="http://mss.cmcc.com/ImportSrvResponse", name="ResponseCollecion")
  public JAXBElement<ResponseCollecion> createResponseCollecion(ResponseCollecion paramResponseCollecion)
  {
    return new JAXBElement(_ResponseCollecion_QNAME, ResponseCollecion.class, null, paramResponseCollecion);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.importsrvresponse.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */