package com.zte.esb.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendDegreeProcessReult", propOrder={"degreeChangeId", "result", "reason", "degreeCode", "degreeName", "changeType"})
public class SendDegreeProcessReult
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String degreeChangeId;
  protected boolean result;
  protected String reason;
  @XmlElement(required=true)
  protected String degreeCode;
  @XmlElement(required=true)
  protected String degreeName;
  @XmlElement(required=true)
  protected String changeType;
  
  public String getDegreeChangeId()
  {
    return this.degreeChangeId;
  }
  
  public void setDegreeChangeId(String paramString)
  {
    this.degreeChangeId = paramString;
  }
  
  public boolean isResult()
  {
    return this.result;
  }
  
  public void setResult(boolean paramBoolean)
  {
    this.result = paramBoolean;
  }
  
  public String getReason()
  {
    return this.reason;
  }
  
  public void setReason(String paramString)
  {
    this.reason = paramString;
  }
  
  public String getDegreeCode()
  {
    return this.degreeCode;
  }
  
  public void setDegreeCode(String paramString)
  {
    this.degreeCode = paramString;
  }
  
  public String getDegreeName()
  {
    return this.degreeName;
  }
  
  public void setDegreeName(String paramString)
  {
    this.degreeName = paramString;
  }
  
  public String getChangeType()
  {
    return this.changeType;
  }
  
  public void setChangeType(String paramString)
  {
    this.changeType = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.SendDegreeProcessReult
 * JD-Core Version:    0.7.0.1
 */