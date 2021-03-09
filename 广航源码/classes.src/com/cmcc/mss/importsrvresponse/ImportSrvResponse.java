package com.cmcc.mss.importsrvresponse;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ImportSrvResponse", propOrder={"serviceflag", "servicemessage", "instanceid", "errorCollection", "responseCollecion"})
public class ImportSrvResponse
{
  @XmlElement(name="SERVICE_FLAG", required=true, nillable=true)
  protected String serviceflag;
  @XmlElement(name="SERVICE_MESSAGE", required=true, nillable=true)
  protected String servicemessage;
  @XmlElement(name="INSTANCE_ID", required=true, nillable=true)
  protected BigDecimal instanceid;
  @XmlElement(name="ErrorCollection", required=true, nillable=true)
  protected ErrorCollection errorCollection;
  @XmlElement(name="ResponseCollecion", required=true, nillable=true)
  protected ResponseCollecion responseCollecion;
  
  public String getSERVICEFLAG()
  {
    return this.serviceflag;
  }
  
  public void setSERVICEFLAG(String paramString)
  {
    this.serviceflag = paramString;
  }
  
  public String getSERVICEMESSAGE()
  {
    return this.servicemessage;
  }
  
  public void setSERVICEMESSAGE(String paramString)
  {
    this.servicemessage = paramString;
  }
  
  public BigDecimal getINSTANCEID()
  {
    return this.instanceid;
  }
  
  public void setINSTANCEID(BigDecimal paramBigDecimal)
  {
    this.instanceid = paramBigDecimal;
  }
  
  public ErrorCollection getErrorCollection()
  {
    return this.errorCollection;
  }
  
  public void setErrorCollection(ErrorCollection paramErrorCollection)
  {
    this.errorCollection = paramErrorCollection;
  }
  
  public ResponseCollecion getResponseCollecion()
  {
    return this.responseCollecion;
  }
  
  public void setResponseCollecion(ResponseCollecion paramResponseCollecion)
  {
    this.responseCollecion = paramResponseCollecion;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.importsrvresponse.ImportSrvResponse
 * JD-Core Version:    0.7.0.1
 */