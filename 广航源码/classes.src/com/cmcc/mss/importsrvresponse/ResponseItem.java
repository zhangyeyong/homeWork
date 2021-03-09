package com.cmcc.mss.importsrvresponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ResponseItem", propOrder={"requestid", "recordnumber"})
public class ResponseItem
{
  @XmlElement(name="REQUEST_ID", required=true, nillable=true)
  protected String requestid;
  @XmlElement(name="RECORD_NUMBER", required=true, nillable=true)
  protected String recordnumber;
  
  public String getREQUESTID()
  {
    return this.requestid;
  }
  
  public void setREQUESTID(String paramString)
  {
    this.requestid = paramString;
  }
  
  public String getRECORDNUMBER()
  {
    return this.recordnumber;
  }
  
  public void setRECORDNUMBER(String paramString)
  {
    this.recordnumber = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.importsrvresponse.ResponseItem
 * JD-Core Version:    0.7.0.1
 */