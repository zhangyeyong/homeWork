package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpDegreeInfo
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long degreeInfoId;
  protected String sourceId;
  protected String degreeChangeId;
  protected String degreeCode;
  protected String degreeName;
  
  public FbpDegreeInfo() {}
  
  public FbpDegreeInfo(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setDegreeInfoId(paramLong4);
    setSourceId(paramString2);
    setDegreeChangeId(paramString3);
    setDegreeCode(paramString4);
    setDegreeName(paramString5);
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
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Long getDegreeInfoId()
  {
    return this.degreeInfoId;
  }
  
  public void setDegreeInfoId(Long paramLong)
  {
    this.degreeInfoId = paramLong;
  }
  
  public String getSourceId()
  {
    return this.sourceId;
  }
  
  public void setSourceId(String paramString)
  {
    this.sourceId = paramString;
  }
  
  public String getDegreeChangeId()
  {
    return this.degreeChangeId;
  }
  
  public void setDegreeChangeId(String paramString)
  {
    this.degreeChangeId = paramString;
  }
  
  public String getDegreeCode()
  {
    return this.degreeCode;
  }
  
  public void setDegreeCode(String paramString)
  {
    this.degreeCode = paramString;
  }
  
  public String getDegreeName()
  {
    return this.degreeName;
  }
  
  public void setDegreeName(String paramString)
  {
    this.degreeName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpDegreeInfo)) {
      return false;
    }
    FbpDegreeInfo localFbpDegreeInfo = (FbpDegreeInfo)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpDegreeInfo.lastUpdateDate).append(this.lastUpdatedBy, localFbpDegreeInfo.lastUpdatedBy).append(this.creationDate, localFbpDegreeInfo.creationDate).append(this.createdBy, localFbpDegreeInfo.createdBy).append(this.lastUpdateLogin, localFbpDegreeInfo.lastUpdateLogin).append(this.enabledFlag, localFbpDegreeInfo.enabledFlag).append(this.degreeInfoId, localFbpDegreeInfo.degreeInfoId).append(this.sourceId, localFbpDegreeInfo.sourceId).append(this.degreeChangeId, localFbpDegreeInfo.degreeChangeId).append(this.degreeCode, localFbpDegreeInfo.degreeCode).append(this.degreeName, localFbpDegreeInfo.degreeName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.degreeInfoId).append(this.sourceId).append(this.degreeChangeId).append(this.degreeCode).append(this.degreeName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("degreeInfoId", this.degreeInfoId).append("sourceId", this.sourceId).append("degreeChangeId", this.degreeChangeId).append("degreeCode", this.degreeCode).append("degreeName", this.degreeName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "degreeInfoId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.FbpDegreeInfo
 * JD-Core Version:    0.7.0.1
 */