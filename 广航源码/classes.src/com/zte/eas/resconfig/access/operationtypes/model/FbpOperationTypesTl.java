package com.zte.eas.resconfig.access.operationtypes.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpOperationTypesTl
  extends BaseObject
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected FbpOperationTypesTlPK fbpOperationTypesTlPK = new FbpOperationTypesTlPK();
  protected String operationTypeName;
  protected String description;
  protected String sourceLang;
  
  public FbpOperationTypesTl() {}
  
  public FbpOperationTypesTl clone()
  {
    FbpOperationTypesTl localFbpOperationTypesTl = null;
    try
    {
      localFbpOperationTypesTl = (FbpOperationTypesTl)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    localFbpOperationTypesTl.fbpOperationTypesTlPK = new FbpOperationTypesTlPK();
    return localFbpOperationTypesTl;
  }
  
  public FbpOperationTypesTl(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setOperationTypeId(paramLong4);
    setOperationTypeName(paramString1);
    setDescription(paramString2);
    setLanguage(paramString3);
    setSourceLang(paramString4);
  }
  
  public FbpOperationTypesTlPK getFbpOperationTypesTlPK()
  {
    return this.fbpOperationTypesTlPK;
  }
  
  public void setFbpOperationTypesTlPK(FbpOperationTypesTlPK paramFbpOperationTypesTlPK)
  {
    this.fbpOperationTypesTlPK = paramFbpOperationTypesTlPK;
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
  
  public Long getOperationTypeId()
  {
    return getFbpOperationTypesTlPK().getOperationTypeId();
  }
  
  public void setOperationTypeId(Long paramLong)
  {
    getFbpOperationTypesTlPK().setOperationTypeId(paramLong);
  }
  
  public String getOperationTypeName()
  {
    return this.operationTypeName;
  }
  
  public void setOperationTypeName(String paramString)
  {
    this.operationTypeName = paramString;
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
    return getFbpOperationTypesTlPK().getLanguage();
  }
  
  public void setLanguage(String paramString)
  {
    getFbpOperationTypesTlPK().setLanguage(paramString);
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
    if (!(paramObject instanceof FbpOperationTypesTl)) {
      return false;
    }
    FbpOperationTypesTl localFbpOperationTypesTl = (FbpOperationTypesTl)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpOperationTypesTl.lastUpdateDate).append(this.lastUpdatedBy, localFbpOperationTypesTl.lastUpdatedBy).append(this.creationDate, localFbpOperationTypesTl.creationDate).append(this.createdBy, localFbpOperationTypesTl.createdBy).append(this.lastUpdateLogin, localFbpOperationTypesTl.lastUpdateLogin).append(this.fbpOperationTypesTlPK.operationTypeId, localFbpOperationTypesTl.fbpOperationTypesTlPK.operationTypeId).append(this.operationTypeName, localFbpOperationTypesTl.operationTypeName).append(this.description, localFbpOperationTypesTl.description).append(this.fbpOperationTypesTlPK.language, localFbpOperationTypesTl.fbpOperationTypesTlPK.language).append(this.sourceLang, localFbpOperationTypesTl.sourceLang).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.fbpOperationTypesTlPK.operationTypeId).append(this.operationTypeName).append(this.description).append(this.fbpOperationTypesTlPK.language).append(this.sourceLang).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("operationTypeId", this.fbpOperationTypesTlPK.operationTypeId).append("operationTypeName", this.operationTypeName).append("description", this.description).append("language", this.fbpOperationTypesTlPK.language).append("sourceLang", this.sourceLang).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "operationTypeId";
  }
  
  public Map getPrimaryKeyMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("operationTypeId", getOperationTypeId());
    localHashMap.put("language", getLanguage());
    return localHashMap;
  }
  
  public String getPrimaryKeyString()
  {
    StringBuffer localStringBuffer = new StringBuffer("[");
    localStringBuffer.append("operationTypeId=");
    localStringBuffer.append(getOperationTypeId());
    localStringBuffer.append(",");
    localStringBuffer.append("language=");
    localStringBuffer.append(getLanguage());
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.operationtypes.model.FbpOperationTypesTl
 * JD-Core Version:    0.7.0.1
 */