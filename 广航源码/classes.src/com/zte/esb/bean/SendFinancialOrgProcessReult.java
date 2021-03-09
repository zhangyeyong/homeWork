package com.zte.esb.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendFinancialOrgProcessReult", propOrder={"finOrgChangeId", "result", "reason", "finOrgName", "finOrgCode", "changeType"})
public class SendFinancialOrgProcessReult
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String finOrgChangeId;
  protected boolean result;
  protected String reason;
  @XmlElement(required=true)
  protected String finOrgName;
  @XmlElement(required=true)
  protected String finOrgCode;
  @XmlElement(required=true)
  protected String changeType;
  
  public String getFinOrgChangeId()
  {
    return this.finOrgChangeId;
  }
  
  public void setFinOrgChangeId(String paramString)
  {
    this.finOrgChangeId = paramString;
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
  
  public String getFinOrgName()
  {
    return this.finOrgName;
  }
  
  public void setFinOrgName(String paramString)
  {
    this.finOrgName = paramString;
  }
  
  public String getFinOrgCode()
  {
    return this.finOrgCode;
  }
  
  public void setFinOrgCode(String paramString)
  {
    this.finOrgCode = paramString;
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
 * Qualified Name:     com.zte.esb.bean.SendFinancialOrgProcessReult
 * JD-Core Version:    0.7.0.1
 */