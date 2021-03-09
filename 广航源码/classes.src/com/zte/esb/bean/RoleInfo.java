package com.zte.esb.bean;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RoleInfo", propOrder={"roleId", "roleName", "roleBasCode", "roleEnCode", "roleType", "changeType", "changeDate"})
public class RoleInfo
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String roleId;
  @XmlElement(required=true)
  protected String roleName;
  @XmlElement(required=true)
  protected String roleBasCode;
  @XmlElement(required=true)
  protected String roleEnCode;
  @XmlElement(required=true)
  protected String roleType;
  @XmlElement(required=true)
  protected String changeType;
  @XmlElement(type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date changeDate;
  
  public String getRoleId()
  {
    return this.roleId;
  }
  
  public void setRoleId(String paramString)
  {
    this.roleId = paramString;
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
  
  public String getRoleEnCode()
  {
    return this.roleEnCode;
  }
  
  public void setRoleEnCode(String paramString)
  {
    this.roleEnCode = paramString;
  }
  
  public String getRoleType()
  {
    return this.roleType;
  }
  
  public void setRoleType(String paramString)
  {
    this.roleType = paramString;
  }
  
  public String getChangeType()
  {
    return this.changeType;
  }
  
  public void setChangeType(String paramString)
  {
    this.changeType = paramString;
  }
  
  public Date getChangeDate()
  {
    return this.changeDate;
  }
  
  public void setChangeDate(Date paramDate)
  {
    this.changeDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.RoleInfo
 * JD-Core Version:    0.7.0.1
 */