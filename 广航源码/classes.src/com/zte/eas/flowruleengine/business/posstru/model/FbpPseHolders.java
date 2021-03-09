package com.zte.eas.flowruleengine.business.posstru.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpPseHolders
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected Long pseHolderId;
  protected Long posStruElementId;
  protected Long employeeId;
  protected String attribute1;
  protected String attribute2;
  protected String attribute3;
  protected String attribute4;
  protected String attribute5;
  protected String attribute6;
  protected String attribute7;
  protected String attribute8;
  protected String attribute9;
  protected String attribute10;
  protected String enabledFlag;
  protected String memo;
  
  public FbpPseHolders() {}
  
  public FbpPseHolders(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, Long paramLong5, Long paramLong6, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setPseHolderId(paramLong4);
    setPosStruElementId(paramLong5);
    setEmployeeId(paramLong6);
    setAttribute1(paramString1);
    setAttribute2(paramString2);
    setAttribute3(paramString3);
    setAttribute4(paramString4);
    setAttribute5(paramString5);
    setAttribute6(paramString6);
    setAttribute7(paramString7);
    setAttribute8(paramString8);
    setAttribute9(paramString9);
    setAttribute10(paramString10);
    setEnabledFlag(paramString11);
    setMemo(paramString12);
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
  
  public Long getPseHolderId()
  {
    return this.pseHolderId;
  }
  
  public void setPseHolderId(Long paramLong)
  {
    this.pseHolderId = paramLong;
  }
  
  public Long getPosStruElementId()
  {
    return this.posStruElementId;
  }
  
  public void setPosStruElementId(Long paramLong)
  {
    this.posStruElementId = paramLong;
  }
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
  }
  
  public String getAttribute2()
  {
    return this.attribute2;
  }
  
  public void setAttribute2(String paramString)
  {
    this.attribute2 = paramString;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public void setAttribute3(String paramString)
  {
    this.attribute3 = paramString;
  }
  
  public String getAttribute4()
  {
    return this.attribute4;
  }
  
  public void setAttribute4(String paramString)
  {
    this.attribute4 = paramString;
  }
  
  public String getAttribute5()
  {
    return this.attribute5;
  }
  
  public void setAttribute5(String paramString)
  {
    this.attribute5 = paramString;
  }
  
  public String getAttribute6()
  {
    return this.attribute6;
  }
  
  public void setAttribute6(String paramString)
  {
    this.attribute6 = paramString;
  }
  
  public String getAttribute7()
  {
    return this.attribute7;
  }
  
  public void setAttribute7(String paramString)
  {
    this.attribute7 = paramString;
  }
  
  public String getAttribute8()
  {
    return this.attribute8;
  }
  
  public void setAttribute8(String paramString)
  {
    this.attribute8 = paramString;
  }
  
  public String getAttribute9()
  {
    return this.attribute9;
  }
  
  public void setAttribute9(String paramString)
  {
    this.attribute9 = paramString;
  }
  
  public String getAttribute10()
  {
    return this.attribute10;
  }
  
  public void setAttribute10(String paramString)
  {
    this.attribute10 = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpPseHolders)) {
      return false;
    }
    FbpPseHolders localFbpPseHolders = (FbpPseHolders)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpPseHolders.lastUpdateDate).append(this.lastUpdatedBy, localFbpPseHolders.lastUpdatedBy).append(this.creationDate, localFbpPseHolders.creationDate).append(this.createdBy, localFbpPseHolders.createdBy).append(this.lastUpdateLogin, localFbpPseHolders.lastUpdateLogin).append(this.pseHolderId, localFbpPseHolders.pseHolderId).append(this.posStruElementId, localFbpPseHolders.posStruElementId).append(this.employeeId, localFbpPseHolders.employeeId).append(this.attribute1, localFbpPseHolders.attribute1).append(this.attribute2, localFbpPseHolders.attribute2).append(this.attribute3, localFbpPseHolders.attribute3).append(this.attribute4, localFbpPseHolders.attribute4).append(this.attribute5, localFbpPseHolders.attribute5).append(this.attribute6, localFbpPseHolders.attribute6).append(this.attribute7, localFbpPseHolders.attribute7).append(this.attribute8, localFbpPseHolders.attribute8).append(this.attribute9, localFbpPseHolders.attribute9).append(this.attribute10, localFbpPseHolders.attribute10).append(this.enabledFlag, localFbpPseHolders.enabledFlag).append(this.memo, localFbpPseHolders.memo).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.pseHolderId).append(this.posStruElementId).append(this.employeeId).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).append(this.memo).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("pseHolderId", this.pseHolderId).append("posStruElementId", this.posStruElementId).append("employeeId", this.employeeId).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).append("memo", this.memo).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "pseHolderId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.business.posstru.model.FbpPseHolders
 * JD-Core Version:    0.7.0.1
 */