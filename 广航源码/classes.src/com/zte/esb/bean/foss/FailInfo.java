package com.zte.esb.bean.foss;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="FailInfo", namespace="http://www.deppon.com/ows/inteface/domain/failInfo", propOrder={"id", "reason"})
public class FailInfo
{
  @XmlElement(namespace="http://www.deppon.com/ows/inteface/domain/failInfo", required=true)
  protected String id;
  @XmlElement(namespace="http://www.deppon.com/ows/inteface/domain/failInfo", required=true)
  protected String reason;
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public String getReason()
  {
    return this.reason;
  }
  
  public void setReason(String paramString)
  {
    this.reason = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.foss.FailInfo
 * JD-Core Version:    0.7.0.1
 */