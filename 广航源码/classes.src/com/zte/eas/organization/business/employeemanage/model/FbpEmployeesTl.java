package com.zte.eas.organization.business.employeemanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpEmployeesTl
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String employeeName;
  protected String description;
  protected String sourceLang;
  protected FbpEmployeesTlPk employeePkTl;
  
  public FbpEmployeesTl() {}
  
  public FbpEmployeesTl(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, FbpEmployeesTlPk paramFbpEmployeesTlPk, String paramString1, String paramString2, String paramString3)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEmployeePkTl(paramFbpEmployeesTlPk);
    setEmployeeName(paramString1);
    setDescription(paramString2);
    setSourceLang(paramString3);
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public Long getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(Long paramLong)
  {
    this.createdBy = paramLong;
  }
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public String getSourceLang()
  {
    return this.sourceLang;
  }
  
  public void setSourceLang(String paramString)
  {
    this.sourceLang = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpEmployeesTl)) {
      return false;
    }
    FbpEmployeesTl localFbpEmployeesTl = (FbpEmployeesTl)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpEmployeesTl.lastUpdateDate).append(this.lastUpdatedBy, localFbpEmployeesTl.lastUpdatedBy).append(this.creationDate, localFbpEmployeesTl.creationDate).append(this.createdBy, localFbpEmployeesTl.createdBy).append(this.lastUpdateLogin, localFbpEmployeesTl.lastUpdateLogin).append(this.employeePkTl.getEmployeeId(), localFbpEmployeesTl.employeePkTl.getEmployeeId()).append(this.employeeName, localFbpEmployeesTl.employeeName).append(this.description, localFbpEmployeesTl.description).append(this.employeePkTl.getLanguage(), localFbpEmployeesTl.employeePkTl.getLanguage()).append(this.sourceLang, localFbpEmployeesTl.sourceLang).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.employeePkTl.getEmployeeId()).append(this.employeeName).append(this.description).append(this.employeePkTl.getLanguage()).append(this.sourceLang).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("employeeId", this.employeePkTl.getEmployeeId()).append("employeeName", this.employeeName).append("description", this.description).append("language", this.employeePkTl.getLanguage()).append("sourceLang", this.sourceLang).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public FbpEmployeesTlPk getEmployeePkTl()
  {
    return this.employeePkTl;
  }
  
  public void setEmployeePkTl(FbpEmployeesTlPk paramFbpEmployeesTlPk)
  {
    this.employeePkTl = paramFbpEmployeesTlPk;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTl
 * JD-Core Version:    0.7.0.1
 */