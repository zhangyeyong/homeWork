package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsAllotRelations
  implements Serializable
{
  private Long allotRelationId;
  private Long allotTypeId;
  private String sourceCheckUnit;
  private String storeCheckUnit;
  private Long archivesSiteId;
  private String enabledFlag;
  private Long createdBy;
  private Date creationDate;
  private Long lastUpdateLogin;
  private Long lastUpdatedBy;
  private Date lastUpdateDate;
  
  public EvsAllotRelations() {}
  
  public EvsAllotRelations(Long paramLong1, Long paramLong2, String paramString1, String paramString2, Long paramLong3, String paramString3, Long paramLong4, Date paramDate1, Long paramLong5, Long paramLong6, Date paramDate2)
  {
    this.allotRelationId = paramLong1;
    this.allotTypeId = paramLong2;
    this.sourceCheckUnit = paramString1;
    this.storeCheckUnit = paramString2;
    this.archivesSiteId = paramLong3;
    this.enabledFlag = paramString3;
    this.createdBy = paramLong4;
    this.creationDate = paramDate1;
    this.lastUpdateLogin = paramLong5;
    this.lastUpdatedBy = paramLong6;
    this.lastUpdateDate = paramDate2;
  }
  
  public Long getAllotRelationId()
  {
    return this.allotRelationId;
  }
  
  public void setAllotRelationId(Long paramLong)
  {
    this.allotRelationId = paramLong;
  }
  
  public Long getAllotTypeId()
  {
    return this.allotTypeId;
  }
  
  public void setAllotTypeId(Long paramLong)
  {
    this.allotTypeId = paramLong;
  }
  
  public String getSourceCheckUnit()
  {
    return this.sourceCheckUnit;
  }
  
  public void setSourceCheckUnit(String paramString)
  {
    this.sourceCheckUnit = paramString;
  }
  
  public String getStoreCheckUnit()
  {
    return this.storeCheckUnit;
  }
  
  public void setStoreCheckUnit(String paramString)
  {
    this.storeCheckUnit = paramString;
  }
  
  public Long getArchivesSiteId()
  {
    return this.archivesSiteId;
  }
  
  public void setArchivesSiteId(Long paramLong)
  {
    this.archivesSiteId = paramLong;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Long getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(Long paramLong)
  {
    this.createdBy = paramLong;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsAllotRelations
 * JD-Core Version:    0.7.0.1
 */