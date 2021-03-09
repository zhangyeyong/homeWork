package com.zte.esb.bean.fssc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="eisGetResponse", propOrder={"claimBillNumber", "successMark", "failtureReason"})
@XmlRootElement
public class EisGetResponse
{
  @XmlElement(required=true)
  protected String claimBillNumber;
  @XmlElement(required=true)
  protected Boolean successMark;
  @XmlElement(required=true)
  protected String failtureReason;
  
  public String getClaimBillNumber()
  {
    return this.claimBillNumber;
  }
  
  public void setClaimBillNumber(String paramString)
  {
    this.claimBillNumber = paramString;
  }
  
  public Boolean getSuccessMark()
  {
    return this.successMark;
  }
  
  public void setSuccessMark(Boolean paramBoolean)
  {
    this.successMark = paramBoolean;
  }
  
  public String getFailtureReason()
  {
    return this.failtureReason;
  }
  
  public void setFailtureReason(String paramString)
  {
    this.failtureReason = paramString;
  }
  
  public String toString()
  {
    return "EisGetResponse [claimBillNumber=" + this.claimBillNumber + ", successMark=" + this.successMark + ", failtureReason=" + this.failtureReason + "]";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.fssc.EisGetResponse
 * JD-Core Version:    0.7.0.1
 */