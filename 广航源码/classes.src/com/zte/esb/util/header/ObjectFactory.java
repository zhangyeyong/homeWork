package com.zte.esb.util.header;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _EsbHeader_QNAME = new QName("http://www.deppon.com/esb/header", "esbHeader");
  
  public ESBHeader createESBHeader()
  {
    return new ESBHeader();
  }
  
  public StatusInfo createStatusInfo()
  {
    return new StatusInfo();
  }
  
  public AuthInfo createAuthInfo()
  {
    return new AuthInfo();
  }
  
  public StatusList createStatusList()
  {
    return new StatusList();
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/esb/header", name="esbHeader")
  public JAXBElement<ESBHeader> createEsbHeader(ESBHeader paramESBHeader)
  {
    return new JAXBElement(_EsbHeader_QNAME, ESBHeader.class, null, paramESBHeader);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.header.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */