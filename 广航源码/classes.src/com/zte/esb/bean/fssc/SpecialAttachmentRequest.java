package com.zte.esb.bean.fssc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="specialAttachmentRequest", propOrder={"billNo", "isIncludeSpecialAttach", "specialAttachmentPage"})
@XmlRootElement
public class SpecialAttachmentRequest
{
  @XmlElement(required=true)
  protected String billNo;
  @XmlElement(required=true)
  protected String isIncludeSpecialAttach;
  @XmlElement(required=true)
  protected String specialAttachmentPage;
  
  public String getBillNo()
  {
    return this.billNo;
  }
  
  public void setBillNo(String paramString)
  {
    this.billNo = paramString;
  }
  
  public String getIsIncludeSpecialAttach()
  {
    return this.isIncludeSpecialAttach;
  }
  
  public void setIsIncludeSpecialAttach(String paramString)
  {
    this.isIncludeSpecialAttach = paramString;
  }
  
  public String getSpecialAttachmentPage()
  {
    return this.specialAttachmentPage;
  }
  
  public void setSpecialAttachmentPage(String paramString)
  {
    this.specialAttachmentPage = paramString;
  }
  
  public String toString()
  {
    return "SpecialAttachmentRequest [billNo=" + this.billNo + ", isIncludeSpecialAttach=" + this.isIncludeSpecialAttach + ", specialAttachmentPage=" + this.specialAttachmentPage + "]";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.fssc.SpecialAttachmentRequest
 * JD-Core Version:    0.7.0.1
 */