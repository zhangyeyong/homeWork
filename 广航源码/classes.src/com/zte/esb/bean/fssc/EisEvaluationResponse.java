package com.zte.esb.bean.fssc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="eisEvaluationResponse", propOrder={"claimBillNumber", "successMark", "failtureReason", "evaluationType"})
@XmlRootElement
public class EisEvaluationResponse
{
  @XmlElement(required=true)
  protected String claimBillNumber;
  @XmlElement(required=true)
  protected Boolean successMark;
  @XmlElement(required=true)
  protected String failtureReason;
  @XmlElement(required=true)
  protected String evaluationType;
  
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
  
  public String getEvaluationType()
  {
    return this.evaluationType;
  }
  
  public void setEvaluationType(String paramString)
  {
    this.evaluationType = paramString;
  }
  
  public String toString()
  {
    return "EisEvaluationResponse [claimBillNumber=" + this.claimBillNumber + ", successMark=" + this.successMark + ", failtureReason=" + this.failtureReason + ", evaluationType=" + this.evaluationType + "]";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.fssc.EisEvaluationResponse
 * JD-Core Version:    0.7.0.1
 */