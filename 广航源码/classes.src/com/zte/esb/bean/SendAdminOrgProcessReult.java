package com.zte.esb.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendAdminOrgProcessReult", propOrder={"orgChangeId", "result", "reason", "orgName", "orgBenchmarkCode", "changeType"})
public class SendAdminOrgProcessReult
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String orgChangeId;
  protected boolean result;
  protected String reason;
  @XmlElement(required=true)
  protected String orgName;
  @XmlElement(required=true)
  protected String orgBenchmarkCode;
  @XmlElement(required=true)
  protected String changeType;
  
  public String getOrgChangeId()
  {
    return this.orgChangeId;
  }
  
  public void setOrgChangeId(String paramString)
  {
    this.orgChangeId = paramString;
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
  
  public String getOrgName()
  {
    return this.orgName;
  }
  
  public void setOrgName(String paramString)
  {
    this.orgName = paramString;
  }
  
  public String getOrgBenchmarkCode()
  {
    return this.orgBenchmarkCode;
  }
  
  public void setOrgBenchmarkCode(String paramString)
  {
    this.orgBenchmarkCode = paramString;
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
 * Qualified Name:     com.zte.esb.bean.SendAdminOrgProcessReult
 * JD-Core Version:    0.7.0.1
 */