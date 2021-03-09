package com.zte.esb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="UserInfo", propOrder={"accountChangeId", "empCode", "userName", "empName", "desPassword", "sysName", "orgName", "orgBenchmarkCode", "orgCode", "position", "workCode", "gender", "isTemp", "isActive", "validDate", "invalidDate", "lastModifyTime", "roleInfo", "changeType", "changeDate"})
public class UserInfo
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String accountChangeId;
  @XmlElement(required=true)
  protected String empCode;
  @XmlElement(required=true)
  protected String userName;
  @XmlElement(required=true)
  protected String empName;
  @XmlElement(required=true)
  protected String desPassword;
  @XmlElement(required=true)
  protected String sysName;
  @XmlElement(required=true)
  protected String orgName;
  @XmlElement(required=true)
  protected String orgBenchmarkCode;
  @XmlElement(required=true)
  protected String orgCode;
  @XmlElement(required=true)
  protected String position;
  @XmlElement(required=true)
  protected String workCode;
  @XmlElement(required=true)
  protected String gender;
  protected boolean isTemp;
  protected boolean isActive;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date validDate;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date invalidDate;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date lastModifyTime;
  protected List<UserRoleInfo> roleInfo;
  @XmlElement(required=true)
  protected String changeType;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date changeDate;
  
  public String getAccountChangeId()
  {
    return this.accountChangeId;
  }
  
  public void setAccountChangeId(String paramString)
  {
    this.accountChangeId = paramString;
  }
  
  public String getEmpCode()
  {
    return this.empCode;
  }
  
  public void setEmpCode(String paramString)
  {
    this.empCode = paramString;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public String getEmpName()
  {
    return this.empName;
  }
  
  public void setEmpName(String paramString)
  {
    this.empName = paramString;
  }
  
  public String getDesPassword()
  {
    return this.desPassword;
  }
  
  public void setDesPassword(String paramString)
  {
    this.desPassword = paramString;
  }
  
  public String getSysName()
  {
    return this.sysName;
  }
  
  public void setSysName(String paramString)
  {
    this.sysName = paramString;
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
  
  public String getOrgCode()
  {
    return this.orgCode;
  }
  
  public void setOrgCode(String paramString)
  {
    this.orgCode = paramString;
  }
  
  public String getPosition()
  {
    return this.position;
  }
  
  public void setPosition(String paramString)
  {
    this.position = paramString;
  }
  
  public String getWorkCode()
  {
    return this.workCode;
  }
  
  public void setWorkCode(String paramString)
  {
    this.workCode = paramString;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public void setGender(String paramString)
  {
    this.gender = paramString;
  }
  
  public boolean getIsTemp()
  {
    return this.isTemp;
  }
  
  public void setIsTemp(boolean paramBoolean)
  {
    this.isTemp = paramBoolean;
  }
  
  public boolean getIsActive()
  {
    return this.isActive;
  }
  
  public void setIsActive(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  public Date getValidDate()
  {
    return this.validDate;
  }
  
  public void setValidDate(Date paramDate)
  {
    this.validDate = paramDate;
  }
  
  public Date getInvalidDate()
  {
    return this.invalidDate;
  }
  
  public void setInvalidDate(Date paramDate)
  {
    this.invalidDate = paramDate;
  }
  
  public Date getLastModifyTime()
  {
    return this.lastModifyTime;
  }
  
  public void setLastModifyTime(Date paramDate)
  {
    this.lastModifyTime = paramDate;
  }
  
  public List<UserRoleInfo> getRoleInfo()
  {
    if (this.roleInfo == null) {
      this.roleInfo = new ArrayList();
    }
    return this.roleInfo;
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
  
  public void setRoleInfo(List<UserRoleInfo> paramList)
  {
    this.roleInfo = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.UserInfo
 * JD-Core Version:    0.7.0.1
 */