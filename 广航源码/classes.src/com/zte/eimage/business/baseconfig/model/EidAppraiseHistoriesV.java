package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EidAppraiseHistoriesV
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long appraiseHistoryId;
  protected Long imageInfoId;
  protected Long appraiseEmployeeId;
  protected Date appraiseDate;
  protected String appraiseNode;
  protected String appraiseType;
  protected String appraiseDesc;
  protected String imageStatus;
  protected String actionCode;
  protected String appraiseNodeName;
  protected String appraiseTypeName;
  protected String imageStatusName;
  
  public EidAppraiseHistoriesV() {}
  
  public EidAppraiseHistoriesV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, Long paramLong5, Long paramLong6, Date paramDate3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setAppraiseHistoryId(paramLong4);
    setImageInfoId(paramLong5);
    setAppraiseEmployeeId(paramLong6);
    setAppraiseDate(paramDate3);
    setAppraiseNode(paramString2);
    setAppraiseType(paramString3);
    setAppraiseDesc(paramString4);
    setImageStatus(paramString5);
    setActionCode(paramString6);
    setAppraiseNodeName(paramString7);
    setAppraiseTypeName(paramString8);
    setImageStatusName(paramString9);
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
  
  public Long getAppraiseHistoryId()
  {
    return this.appraiseHistoryId;
  }
  
  public void setAppraiseHistoryId(Long paramLong)
  {
    this.appraiseHistoryId = paramLong;
  }
  
  public Long getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(Long paramLong)
  {
    this.imageInfoId = paramLong;
  }
  
  public Long getAppraiseEmployeeId()
  {
    return this.appraiseEmployeeId;
  }
  
  public void setAppraiseEmployeeId(Long paramLong)
  {
    this.appraiseEmployeeId = paramLong;
  }
  
  public Date getAppraiseDate()
  {
    return this.appraiseDate;
  }
  
  public void setAppraiseDate(Date paramDate)
  {
    this.appraiseDate = paramDate;
  }
  
  public String getAppraiseNode()
  {
    return this.appraiseNode;
  }
  
  public void setAppraiseNode(String paramString)
  {
    this.appraiseNode = paramString;
  }
  
  public String getAppraiseType()
  {
    return this.appraiseType;
  }
  
  public void setAppraiseType(String paramString)
  {
    this.appraiseType = paramString;
  }
  
  public String getAppraiseDesc()
  {
    return this.appraiseDesc;
  }
  
  public void setAppraiseDesc(String paramString)
  {
    this.appraiseDesc = paramString;
  }
  
  public String getImageStatus()
  {
    return this.imageStatus;
  }
  
  public void setImageStatus(String paramString)
  {
    this.imageStatus = paramString;
  }
  
  public String getActionCode()
  {
    return this.actionCode;
  }
  
  public void setActionCode(String paramString)
  {
    this.actionCode = paramString;
  }
  
  public String getAppraiseNodeName()
  {
    return this.appraiseNodeName;
  }
  
  public void setAppraiseNodeName(String paramString)
  {
    this.appraiseNodeName = paramString;
  }
  
  public String getAppraiseTypeName()
  {
    return this.appraiseTypeName;
  }
  
  public void setAppraiseTypeName(String paramString)
  {
    this.appraiseTypeName = paramString;
  }
  
  public String getImageStatusName()
  {
    return this.imageStatusName;
  }
  
  public void setImageStatusName(String paramString)
  {
    this.imageStatusName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EidAppraiseHistoriesV)) {
      return false;
    }
    EidAppraiseHistoriesV localEidAppraiseHistoriesV = (EidAppraiseHistoriesV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localEidAppraiseHistoriesV.lastUpdateDate).append(this.lastUpdatedBy, localEidAppraiseHistoriesV.lastUpdatedBy).append(this.creationDate, localEidAppraiseHistoriesV.creationDate).append(this.createdBy, localEidAppraiseHistoriesV.createdBy).append(this.lastUpdateLogin, localEidAppraiseHistoriesV.lastUpdateLogin).append(this.enabledFlag, localEidAppraiseHistoriesV.enabledFlag).append(this.appraiseHistoryId, localEidAppraiseHistoriesV.appraiseHistoryId).append(this.imageInfoId, localEidAppraiseHistoriesV.imageInfoId).append(this.appraiseEmployeeId, localEidAppraiseHistoriesV.appraiseEmployeeId).append(this.appraiseDate, localEidAppraiseHistoriesV.appraiseDate).append(this.appraiseNode, localEidAppraiseHistoriesV.appraiseNode).append(this.appraiseType, localEidAppraiseHistoriesV.appraiseType).append(this.appraiseDesc, localEidAppraiseHistoriesV.appraiseDesc).append(this.imageStatus, localEidAppraiseHistoriesV.imageStatus).append(this.actionCode, localEidAppraiseHistoriesV.actionCode).append(this.appraiseNodeName, localEidAppraiseHistoriesV.appraiseNodeName).append(this.appraiseTypeName, localEidAppraiseHistoriesV.appraiseTypeName).append(this.imageStatusName, localEidAppraiseHistoriesV.imageStatusName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.appraiseHistoryId).append(this.imageInfoId).append(this.appraiseEmployeeId).append(this.appraiseDate).append(this.appraiseNode).append(this.appraiseType).append(this.appraiseDesc).append(this.imageStatus).append(this.actionCode).append(this.appraiseNodeName).append(this.appraiseTypeName).append(this.imageStatusName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("appraiseHistoryId", this.appraiseHistoryId).append("imageInfoId", this.imageInfoId).append("appraiseEmployeeId", this.appraiseEmployeeId).append("appraiseDate", this.appraiseDate).append("appraiseNode", this.appraiseNode).append("appraiseType", this.appraiseType).append("appraiseDesc", this.appraiseDesc).append("imageStatus", this.imageStatus).append("actionCode", this.actionCode).append("appraiseNodeName", this.appraiseNodeName).append("appraiseTypeName", this.appraiseTypeName).append("imageStatusName", this.imageStatusName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidAppraiseHistoriesV
 * JD-Core Version:    0.7.0.1
 */