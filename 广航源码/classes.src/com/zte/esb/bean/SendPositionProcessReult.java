package com.zte.esb.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendPositionProcessReult", propOrder={"positionChangeId", "result", "reason", "positionCode", "positionName", "changeType"})
public class SendPositionProcessReult
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String positionChangeId;
  protected boolean result;
  protected String reason;
  @XmlElement(required=true)
  protected String positionCode;
  @XmlElement(required=true)
  protected String positionName;
  @XmlElement(required=true)
  protected String changeType;
  
  public String getPositionChangeId()
  {
    return this.positionChangeId;
  }
  
  public void setPositionChangeId(String paramString)
  {
    this.positionChangeId = paramString;
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
  
  public String getPositionCode()
  {
    return this.positionCode;
  }
  
  public void setPositionCode(String paramString)
  {
    this.positionCode = paramString;
  }
  
  public String getPositionName()
  {
    return this.positionName;
  }
  
  public void setPositionName(String paramString)
  {
    this.positionName = paramString;
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
 * Qualified Name:     com.zte.esb.bean.SendPositionProcessReult
 * JD-Core Version:    0.7.0.1
 */