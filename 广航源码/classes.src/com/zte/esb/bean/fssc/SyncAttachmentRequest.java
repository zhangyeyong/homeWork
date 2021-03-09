package com.zte.esb.bean.fssc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="syncAttachmentRequest", propOrder={"billNo"})
@XmlRootElement
public class SyncAttachmentRequest
{
  @XmlElement(required=true)
  protected String billNo;
  
  public String getBillNo()
  {
    return this.billNo;
  }
  
  public void setBillNo(String paramString)
  {
    this.billNo = paramString;
  }
  
  public String toString()
  {
    return "SyncAttachmentRequest [billNo=" + this.billNo + "]";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.fssc.SyncAttachmentRequest
 * JD-Core Version:    0.7.0.1
 */