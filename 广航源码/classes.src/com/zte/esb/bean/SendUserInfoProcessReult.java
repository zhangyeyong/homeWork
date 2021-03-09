package com.zte.esb.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendUserInfoProcessReult", propOrder={"accountChangeId", "result", "reason", "empCode", "changeType"})
public class SendUserInfoProcessReult
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String accountChangeId;
  protected boolean result;
  protected String reason;
  @XmlElement(required=true)
  protected String empCode;
  @XmlElement(required=true)
  protected String changeType;
  
  public String getAccountChangeId()
  {
    return this.accountChangeId;
  }
  
  public void setAccountChangeId(String paramString)
  {
    this.accountChangeId = paramString;
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
  
  public String getEmpCode()
  {
    return this.empCode;
  }
  
  public void setEmpCode(String paramString)
  {
    this.empCode = paramString;
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
 * Qualified Name:     com.zte.esb.bean.SendUserInfoProcessReult
 * JD-Core Version:    0.7.0.1
 */