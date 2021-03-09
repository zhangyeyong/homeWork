package com.zte.esb.bean.fssc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="synchAttachmentResponse", propOrder={"claimBillNumber", "attachmentName", "attachmentSize", "attachmentDownUrl", "successMark", "failureReason"})
@XmlRootElement
public class SynchAttachmentResponse
{
  @XmlElement(required=true)
  protected String claimBillNumber;
  @XmlElement(required=true)
  protected String attachmentName;
  @XmlElement(required=true)
  protected String attachmentSize;
  @XmlElement(required=true)
  protected String attachmentDownUrl;
  protected boolean successMark;
  @XmlElement(required=true)
  protected String failureReason;
  
  public String getClaimBillNumber()
  {
    return this.claimBillNumber;
  }
  
  public void setClaimBillNumber(String paramString)
  {
    this.claimBillNumber = paramString;
  }
  
  public String getAttachmentName()
  {
    return this.attachmentName;
  }
  
  public void setAttachmentName(String paramString)
  {
    this.attachmentName = paramString;
  }
  
  public String getAttachmentSize()
  {
    return this.attachmentSize;
  }
  
  public void setAttachmentSize(String paramString)
  {
    this.attachmentSize = paramString;
  }
  
  public String getAttachmentDownUrl()
  {
    return this.attachmentDownUrl;
  }
  
  public void setAttachmentDownUrl(String paramString)
  {
    this.attachmentDownUrl = paramString;
  }
  
  public boolean isSuccessMark()
  {
    return this.successMark;
  }
  
  public void setSuccessMark(boolean paramBoolean)
  {
    this.successMark = paramBoolean;
  }
  
  public String getFailureReason()
  {
    return this.failureReason;
  }
  
  public void setFailureReason(String paramString)
  {
    this.failureReason = paramString;
  }
  
  public String toString()
  {
    return "SynchAttachmentResponse [claimBillNumber=" + this.claimBillNumber + ", attachmentName=" + this.attachmentName + ", attachmentSize=" + this.attachmentSize + ", attachmentDownUrl=" + this.attachmentDownUrl + ", successMark=" + this.successMark + ", failureReason=" + this.failureReason + "]";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.fssc.SynchAttachmentResponse
 * JD-Core Version:    0.7.0.1
 */