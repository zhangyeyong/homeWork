package com.zte.eas.organization.business.organizationmanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpDeptsTl
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected FbpDeptsTlPk deptTlPK = new FbpDeptsTlPk();
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger deptId;
  protected String deptName;
  protected String deptLongName;
  protected String description;
  protected String language;
  protected String sourceLang;
  
  public FbpDeptsTl() {}
  
  public FbpDeptsTl(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setDeptId(paramBigInteger);
    setDeptName(paramString1);
    setDescription(paramString2);
    setLanguage(paramString3);
    setSourceLang(paramString4);
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
  
  public BigInteger getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(BigInteger paramBigInteger)
  {
    this.deptId = paramBigInteger;
  }
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
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
    if (!(paramObject instanceof FbpDeptsTl)) {
      return false;
    }
    FbpDeptsTl localFbpDeptsTl = (FbpDeptsTl)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpDeptsTl.lastUpdateDate).append(this.lastUpdatedBy, localFbpDeptsTl.lastUpdatedBy).append(this.creationDate, localFbpDeptsTl.creationDate).append(this.createdBy, localFbpDeptsTl.createdBy).append(this.lastUpdateLogin, localFbpDeptsTl.lastUpdateLogin).append(this.deptId, localFbpDeptsTl.deptId).append(this.deptName, localFbpDeptsTl.deptName).append(this.description, localFbpDeptsTl.description).append(this.language, localFbpDeptsTl.language).append(this.sourceLang, localFbpDeptsTl.sourceLang).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.deptId).append(this.deptName).append(this.description).append(this.language).append(this.sourceLang).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("deptId", this.deptId).append("deptName", this.deptName).append("description", this.description).append("language", this.language).append("sourceLang", this.sourceLang).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public FbpDeptsTlPk getDeptTlPK()
  {
    return this.deptTlPK;
  }
  
  public void setDeptTlPK(FbpDeptsTlPk paramFbpDeptsTlPk)
  {
    this.deptTlPK = paramFbpDeptsTlPk;
  }
  
  public String getDeptLongName()
  {
    return this.deptLongName;
  }
  
  public void setDeptLongName(String paramString)
  {
    this.deptLongName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTl
 * JD-Core Version:    0.7.0.1
 */