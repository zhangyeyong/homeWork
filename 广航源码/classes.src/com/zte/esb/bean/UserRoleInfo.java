package com.zte.esb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="UserRoleInfo", propOrder={"orgBenchmarkCode", "orgCode", "roleCode", "roleBseCode"})
public class UserRoleInfo
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String orgBenchmarkCode;
  @XmlElement(required=true)
  protected String orgCode;
  @XmlElement(required=true)
  protected List<String> roleCode;
  @XmlElement(required=true)
  protected List<String> roleBseCode;
  
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
  
  public List<String> getRoleCode()
  {
    if (this.roleCode == null) {
      this.roleCode = new ArrayList();
    }
    return this.roleCode;
  }
  
  public void setRoleCode(List<String> paramList)
  {
    this.roleCode = paramList;
  }
  
  public List<String> getRoleBseCode()
  {
    return this.roleBseCode;
  }
  
  public void setRoleBseCode(List<String> paramList)
  {
    this.roleBseCode = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.UserRoleInfo
 * JD-Core Version:    0.7.0.1
 */