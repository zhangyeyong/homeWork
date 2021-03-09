package com.zte.esb.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendRoleInfoProcessReult", propOrder={"roleId", "result", "reason", "roleName", "roleBasCode", "changeType"})
public class SendRoleInfoProcessReult
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String roleId;
  protected boolean result;
  protected String reason;
  @XmlElement(required=true)
  protected String roleName;
  @XmlElement(required=true)
  protected String roleBasCode;
  @XmlElement(required=true)
  protected String changeType;
  
  public String getRoleId()
  {
    return this.roleId;
  }
  
  public void setRoleId(String paramString)
  {
    this.roleId = paramString;
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
  
  public String getRoleName()
  {
    return this.roleName;
  }
  
  public void setRoleName(String paramString)
  {
    this.roleName = paramString;
  }
  
  public String getRoleBasCode()
  {
    return this.roleBasCode;
  }
  
  public void setRoleBasCode(String paramString)
  {
    this.roleBasCode = paramString;
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
 * Qualified Name:     com.zte.esb.bean.SendRoleInfoProcessReult
 * JD-Core Version:    0.7.0.1
 */