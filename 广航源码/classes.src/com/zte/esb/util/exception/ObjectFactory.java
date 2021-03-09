package com.zte.esb.util.exception;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _CommonExceptionInfo_QNAME = new QName("http://www.deppon.com/esb/exception", "commonExceptionInfo");
  
  public CommonExceptionInfo createCommonExceptionInfo()
  {
    return new CommonExceptionInfo();
  }
  
  @XmlElementDecl(namespace="http://www.deppon.com/esb/exception", name="commonExceptionInfo")
  public JAXBElement<CommonExceptionInfo> createCommonExceptionInfo(CommonExceptionInfo paramCommonExceptionInfo)
  {
    return new JAXBElement(_CommonExceptionInfo_QNAME, CommonExceptionInfo.class, null, paramCommonExceptionInfo);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.exception.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */