package com.zte.esb.bean.fssc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="eisEvaluationRequest", propOrder={"eisFileNo", "eisTaskNo", "evaluateType", "evaluateDescription", "evaluatePerson", "evaluateDate"})
@XmlRootElement
public class EisEvaluationRequest
{
  @XmlElement(required=true)
  protected String eisFileNo;
  @XmlElement(required=true)
  protected String eisTaskNo;
  @XmlElement(required=true)
  protected String evaluateType;
  @XmlElement(required=true)
  protected String evaluateDescription;
  @XmlElement(required=true)
  protected String evaluatePerson;
  @XmlElement(required=true)
  protected String evaluateDate;
  
  public String getEisFileNo()
  {
    return this.eisFileNo;
  }
  
  public void setEisFileNo(String paramString)
  {
    this.eisFileNo = paramString;
  }
  
  public String getEisTaskNo()
  {
    return this.eisTaskNo;
  }
  
  public void setEisTaskNo(String paramString)
  {
    this.eisTaskNo = paramString;
  }
  
  public String getEvaluateType()
  {
    return this.evaluateType;
  }
  
  public void setEvaluateType(String paramString)
  {
    this.evaluateType = paramString;
  }
  
  public String getEvaluateDescription()
  {
    return this.evaluateDescription;
  }
  
  public void setEvaluateDescription(String paramString)
  {
    this.evaluateDescription = paramString;
  }
  
  public String getEvaluatePerson()
  {
    return this.evaluatePerson;
  }
  
  public void setEvaluatePerson(String paramString)
  {
    this.evaluatePerson = paramString;
  }
  
  public String getEvaluateDate()
  {
    return this.evaluateDate;
  }
  
  public void setEvaluateDate(String paramString)
  {
    this.evaluateDate = paramString;
  }
  
  public String toString()
  {
    return "EisEvaluationRequest [eisFileNo=" + this.eisFileNo + ", eisTaskNo=" + this.eisTaskNo + ", evaluateType=" + this.evaluateType + ", evaluateDescription=" + this.evaluateDescription + ", evaluatePerson=" + this.evaluatePerson + ", evaluateDate=" + this.evaluateDate + "]";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.fssc.EisEvaluationRequest
 * JD-Core Version:    0.7.0.1
 */