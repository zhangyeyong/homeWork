package com.zte.esb.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendEmployeeProcessReult", propOrder={"employeeChangeId", "result", "reason", "employeeCode", "changeType"})
public class SendEmployeeProcessReult
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String employeeChangeId;
  protected boolean result;
  protected String reason;
  @XmlElement(required=true)
  protected String employeeCode;
  @XmlElement(required=true)
  protected String changeType;
  
  public String getEmployeeChangeId()
  {
    return this.employeeChangeId;
  }
  
  public void setEmployeeChangeId(String paramString)
  {
    this.employeeChangeId = paramString;
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
  
  public String getEmployeeCode()
  {
    return this.employeeCode;
  }
  
  public void setEmployeeCode(String paramString)
  {
    this.employeeCode = paramString;
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
 * Qualified Name:     com.zte.esb.bean.SendEmployeeProcessReult
 * JD-Core Version:    0.7.0.1
 */