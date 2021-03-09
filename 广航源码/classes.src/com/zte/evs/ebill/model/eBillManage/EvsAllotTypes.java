package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsAllotTypes
  implements Serializable
{
  private Long allotTypeId;
  private String allotTypeCode;
  private String allotTypeName;
  private String allotWay;
  private String enabledFlag;
  private String description;
  private Long createdBy;
  private Date creationDate;
  private Long lastUpdateLogin;
  private Long lastUpdatedBy;
  private Date lastUpdateDate;
  
  public EvsAllotTypes() {}
  
  public EvsAllotTypes(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Long paramLong2, Date paramDate1, Long paramLong3, Long paramLong4, Date paramDate2)
  {
    this.allotTypeId = paramLong1;
    this.allotTypeCode = paramString1;
    this.allotTypeName = paramString2;
    this.allotWay = paramString3;
    this.enabledFlag = paramString4;
    this.description = paramString5;
    this.createdBy = paramLong2;
    this.creationDate = paramDate1;
    this.lastUpdateLogin = paramLong3;
    this.lastUpdatedBy = paramLong4;
    this.lastUpdateDate = paramDate2;
  }
  
  public Long getAllotTypeId()
  {
    return this.allotTypeId;
  }
  
  public void setAllotTypeId(Long paramLong)
  {
    this.allotTypeId = paramLong;
  }
  
  public String getAllotTypeCode()
  {
    return this.allotTypeCode;
  }
  
  public void setAllotTypeCode(String paramString)
  {
    this.allotTypeCode = paramString;
  }
  
  public String getAllotTypeName()
  {
    return this.allotTypeName;
  }
  
  public void setAllotTypeName(String paramString)
  {
    this.allotTypeName = paramString;
  }
  
  public String getAllotWay()
  {
    return this.allotWay;
  }
  
  public void setAllotWay(String paramString)
  {
    this.allotWay = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
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
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsAllotTypes
 * JD-Core Version:    0.7.0.1
 */