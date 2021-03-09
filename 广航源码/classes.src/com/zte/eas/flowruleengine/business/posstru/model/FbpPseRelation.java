package com.zte.eas.flowruleengine.business.posstru.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpPseRelation
  extends BaseObject
  implements Serializable
{
  protected Date creationDate;
  protected Date lastUpdateDate;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long lastUpdateBy;
  protected Long createdBy;
  protected Long pseRelationId;
  protected Long pseHolderId;
  protected Long employeeId;
  protected Long companyId;
  protected Long operationTypeId;
  
  public FbpPseRelation() {}
  
  public FbpPseRelation(Date paramDate1, Date paramDate2, Long paramLong1, String paramString, Long paramLong2, Long paramLong3, Long paramLong4, Long paramLong5, Long paramLong6, Long paramLong7, Long paramLong8)
  {
    setCreationDate(paramDate1);
    setLastUpdateDate(paramDate2);
    setLastUpdateLogin(paramLong1);
    setEnabledFlag(paramString);
    setLastUpdateBy(paramLong2);
    setCreatedBy(paramLong3);
    setPseRelationId(paramLong4);
    setPseHolderId(paramLong5);
    setEmployeeId(paramLong6);
    setCompanyId(paramLong7);
    setOperationTypeId(paramLong8);
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
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
  
  public Long getLastUpdateBy()
  {
    return this.lastUpdateBy;
  }
  
  public void setLastUpdateBy(Long paramLong)
  {
    this.lastUpdateBy = paramLong;
  }
  
  public Long getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(Long paramLong)
  {
    this.createdBy = paramLong;
  }
  
  public Long getPseRelationId()
  {
    return this.pseRelationId;
  }
  
  public void setPseRelationId(Long paramLong)
  {
    this.pseRelationId = paramLong;
  }
  
  public Long getPseHolderId()
  {
    return this.pseHolderId;
  }
  
  public void setPseHolderId(Long paramLong)
  {
    this.pseHolderId = paramLong;
  }
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public Long getOperationTypeId()
  {
    return this.operationTypeId;
  }
  
  public void setOperationTypeId(Long paramLong)
  {
    this.operationTypeId = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpPseRelation)) {
      return false;
    }
    FbpPseRelation localFbpPseRelation = (FbpPseRelation)paramObject;
    return new EqualsBuilder().append(this.creationDate, localFbpPseRelation.creationDate).append(this.lastUpdateDate, localFbpPseRelation.lastUpdateDate).append(this.lastUpdateLogin, localFbpPseRelation.lastUpdateLogin).append(this.enabledFlag, localFbpPseRelation.enabledFlag).append(this.lastUpdateBy, localFbpPseRelation.lastUpdateBy).append(this.createdBy, localFbpPseRelation.createdBy).append(this.pseRelationId, localFbpPseRelation.pseRelationId).append(this.pseHolderId, localFbpPseRelation.pseHolderId).append(this.employeeId, localFbpPseRelation.employeeId).append(this.companyId, localFbpPseRelation.companyId).append(this.operationTypeId, localFbpPseRelation.operationTypeId).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.creationDate).append(this.lastUpdateDate).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.lastUpdateBy).append(this.createdBy).append(this.pseRelationId).append(this.pseHolderId).append(this.employeeId).append(this.companyId).append(this.operationTypeId).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("creationDate", this.creationDate).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("lastUpdateBy", this.lastUpdateBy).append("createdBy", this.createdBy).append("pseRelationId", this.pseRelationId).append("pseHolderId", this.pseHolderId).append("employeeId", this.employeeId).append("companyId", this.companyId).append("operationTypeId", this.operationTypeId).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "pseRelationId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.business.posstru.model.FbpPseRelation
 * JD-Core Version:    0.7.0.1
 */