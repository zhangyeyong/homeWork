package com.cmcc.mss.importsrvresponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ErrorItem", propOrder={"entityname", "recordnumber", "errormessage"})
public class ErrorItem
{
  @XmlElement(name="ENTITY_NAME", required=true, nillable=true)
  protected String entityname;
  @XmlElement(name="RECORD_NUMBER", required=true, nillable=true)
  protected String recordnumber;
  @XmlElement(name="ERROR_MESSAGE", required=true, nillable=true)
  protected String errormessage;
  
  public String getENTITYNAME()
  {
    return this.entityname;
  }
  
  public void setENTITYNAME(String paramString)
  {
    this.entityname = paramString;
  }
  
  public String getRECORDNUMBER()
  {
    return this.recordnumber;
  }
  
  public void setRECORDNUMBER(String paramString)
  {
    this.recordnumber = paramString;
  }
  
  public String getERRORMESSAGE()
  {
    return this.errormessage;
  }
  
  public void setERRORMESSAGE(String paramString)
  {
    this.errormessage = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.importsrvresponse.ErrorItem
 * JD-Core Version:    0.7.0.1
 */