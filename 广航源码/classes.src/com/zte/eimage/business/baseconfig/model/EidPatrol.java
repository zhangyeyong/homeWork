package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EidPatrol
  extends BaseObject
  implements Serializable
{
  private Date lastUpdateDate;
  private Long lastUpdatedBy;
  private Date creationDate;
  private Long createdBy;
  private Long lastUpdateLogin;
  private String enabledFlag;
  private Integer patrolId;
  private Integer imageInfoId;
  private String patrolEmployee;
  private Date patrolDate;
  private String patrolIssue;
  private String isSolve;
  private Date solveDate;
  private String patrolDescribe;
  
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
  
  public Integer getPatrolId()
  {
    return this.patrolId;
  }
  
  public void setPatrolId(Integer paramInteger)
  {
    this.patrolId = paramInteger;
  }
  
  public Integer getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(Integer paramInteger)
  {
    this.imageInfoId = paramInteger;
  }
  
  public String getPatrolEmployee()
  {
    return this.patrolEmployee;
  }
  
  public void setPatrolEmployee(String paramString)
  {
    this.patrolEmployee = paramString;
  }
  
  public Date getPatrolDate()
  {
    return this.patrolDate;
  }
  
  public void setPatrolDate(Date paramDate)
  {
    this.patrolDate = paramDate;
  }
  
  public String getPatrolIssue()
  {
    return this.patrolIssue;
  }
  
  public void setPatrolIssue(String paramString)
  {
    this.patrolIssue = paramString;
  }
  
  public String getIsSolve()
  {
    return this.isSolve;
  }
  
  public void setIsSolve(String paramString)
  {
    this.isSolve = paramString;
  }
  
  public Date getSolveDate()
  {
    return this.solveDate;
  }
  
  public void setSolveDate(Date paramDate)
  {
    this.solveDate = paramDate;
  }
  
  public String getPatrolDescribe()
  {
    return this.patrolDescribe;
  }
  
  public void setPatrolDescribe(String paramString)
  {
    this.patrolDescribe = paramString;
  }
  
  public int hashCode()
  {
    int i = 1;
    i = 31 * i + (this.createdBy == null ? 0 : this.createdBy.hashCode());
    i = 31 * i + (this.creationDate == null ? 0 : this.creationDate.hashCode());
    i = 31 * i + (this.enabledFlag == null ? 0 : this.enabledFlag.hashCode());
    i = 31 * i + (this.imageInfoId == null ? 0 : this.imageInfoId.hashCode());
    i = 31 * i + (this.isSolve == null ? 0 : this.isSolve.hashCode());
    i = 31 * i + (this.lastUpdateDate == null ? 0 : this.lastUpdateDate.hashCode());
    i = 31 * i + (this.lastUpdateLogin == null ? 0 : this.lastUpdateLogin.hashCode());
    i = 31 * i + (this.lastUpdatedBy == null ? 0 : this.lastUpdatedBy.hashCode());
    i = 31 * i + (this.patrolDate == null ? 0 : this.patrolDate.hashCode());
    i = 31 * i + (this.patrolDescribe == null ? 0 : this.patrolDescribe.hashCode());
    i = 31 * i + (this.patrolEmployee == null ? 0 : this.patrolEmployee.hashCode());
    i = 31 * i + (this.patrolId == null ? 0 : this.patrolId.hashCode());
    i = 31 * i + (this.patrolIssue == null ? 0 : this.patrolIssue.hashCode());
    i = 31 * i + (this.solveDate == null ? 0 : this.solveDate.hashCode());
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    EidPatrol localEidPatrol = (EidPatrol)paramObject;
    if (this.createdBy == null)
    {
      if (localEidPatrol.createdBy != null) {
        return false;
      }
    }
    else if (!this.createdBy.equals(localEidPatrol.createdBy)) {
      return false;
    }
    if (this.creationDate == null)
    {
      if (localEidPatrol.creationDate != null) {
        return false;
      }
    }
    else if (!this.creationDate.equals(localEidPatrol.creationDate)) {
      return false;
    }
    if (this.enabledFlag == null)
    {
      if (localEidPatrol.enabledFlag != null) {
        return false;
      }
    }
    else if (!this.enabledFlag.equals(localEidPatrol.enabledFlag)) {
      return false;
    }
    if (this.imageInfoId == null)
    {
      if (localEidPatrol.imageInfoId != null) {
        return false;
      }
    }
    else if (!this.imageInfoId.equals(localEidPatrol.imageInfoId)) {
      return false;
    }
    if (this.isSolve == null)
    {
      if (localEidPatrol.isSolve != null) {
        return false;
      }
    }
    else if (!this.isSolve.equals(localEidPatrol.isSolve)) {
      return false;
    }
    if (this.lastUpdateDate == null)
    {
      if (localEidPatrol.lastUpdateDate != null) {
        return false;
      }
    }
    else if (!this.lastUpdateDate.equals(localEidPatrol.lastUpdateDate)) {
      return false;
    }
    if (this.lastUpdateLogin == null)
    {
      if (localEidPatrol.lastUpdateLogin != null) {
        return false;
      }
    }
    else if (!this.lastUpdateLogin.equals(localEidPatrol.lastUpdateLogin)) {
      return false;
    }
    if (this.lastUpdatedBy == null)
    {
      if (localEidPatrol.lastUpdatedBy != null) {
        return false;
      }
    }
    else if (!this.lastUpdatedBy.equals(localEidPatrol.lastUpdatedBy)) {
      return false;
    }
    if (this.patrolDate == null)
    {
      if (localEidPatrol.patrolDate != null) {
        return false;
      }
    }
    else if (!this.patrolDate.equals(localEidPatrol.patrolDate)) {
      return false;
    }
    if (this.patrolDescribe == null)
    {
      if (localEidPatrol.patrolDescribe != null) {
        return false;
      }
    }
    else if (!this.patrolDescribe.equals(localEidPatrol.patrolDescribe)) {
      return false;
    }
    if (this.patrolEmployee == null)
    {
      if (localEidPatrol.patrolEmployee != null) {
        return false;
      }
    }
    else if (!this.patrolEmployee.equals(localEidPatrol.patrolEmployee)) {
      return false;
    }
    if (this.patrolId == null)
    {
      if (localEidPatrol.patrolId != null) {
        return false;
      }
    }
    else if (!this.patrolId.equals(localEidPatrol.patrolId)) {
      return false;
    }
    if (this.patrolIssue == null)
    {
      if (localEidPatrol.patrolIssue != null) {
        return false;
      }
    }
    else if (!this.patrolIssue.equals(localEidPatrol.patrolIssue)) {
      return false;
    }
    if (this.solveDate == null)
    {
      if (localEidPatrol.solveDate != null) {
        return false;
      }
    }
    else if (!this.solveDate.equals(localEidPatrol.solveDate)) {
      return false;
    }
    return true;
  }
  
  public EidPatrol() {}
  
  public EidPatrol(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, Date paramDate3, String paramString3, String paramString4, Date paramDate4, String paramString5)
  {
    this.lastUpdateDate = paramDate1;
    this.lastUpdatedBy = paramLong1;
    this.creationDate = paramDate2;
    this.createdBy = paramLong2;
    this.lastUpdateLogin = paramLong3;
    this.enabledFlag = paramString1;
    this.patrolId = paramInteger1;
    this.imageInfoId = paramInteger2;
    this.patrolEmployee = paramString2;
    this.patrolDate = paramDate3;
    this.patrolIssue = paramString3;
    this.isSolve = paramString4;
    this.solveDate = paramDate4;
    this.patrolDescribe = paramString5;
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("patrolId", this.patrolId).append("imageInfoId", this.imageInfoId).append("patrolEmployee", this.patrolEmployee).append("patrolIssue", this.patrolIssue).append("isSolve", this.isSolve).append("solveDate", this.solveDate).append("patrolDate", this.patrolDate).append("patrolDescribe", this.patrolDescribe).toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidPatrol
 * JD-Core Version:    0.7.0.1
 */