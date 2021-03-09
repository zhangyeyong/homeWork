package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;

public class EvsAllotRelationsV
  implements Serializable
{
  private Long allotRelationId;
  private Long allotTypeId;
  private String allotTypeCode;
  private String allotTypeName;
  private String allotWay;
  private String allotWayName;
  private Long archivesSiteId;
  private String archivesSiteCode;
  private String archivesSiteName;
  private String sourceCheckUnit;
  private String sourceName;
  private String storeCheckUnit;
  private String storeName;
  private String enabledFlag;
  private String enabledFlagName;
  
  public EvsAllotRelationsV() {}
  
  public EvsAllotRelationsV(Long paramLong1, Long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.allotRelationId = paramLong1;
    this.allotTypeId = paramLong2;
    this.allotTypeCode = paramString1;
    this.allotTypeName = paramString2;
    this.allotWay = paramString3;
    this.allotWayName = paramString4;
    this.archivesSiteId = paramLong3;
    this.archivesSiteCode = paramString5;
    this.archivesSiteName = paramString6;
    this.sourceCheckUnit = paramString7;
    this.sourceName = paramString8;
    this.storeCheckUnit = paramString9;
    this.storeName = paramString10;
    this.enabledFlag = paramString11;
    this.enabledFlagName = paramString12;
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
  
  public String getAllotWayName()
  {
    return this.allotWayName;
  }
  
  public void setAllotWayName(String paramString)
  {
    this.allotWayName = paramString;
  }
  
  public String getSourceCheckUnit()
  {
    return this.sourceCheckUnit;
  }
  
  public void setSourceCheckUnit(String paramString)
  {
    this.sourceCheckUnit = paramString;
  }
  
  public String getSourceName()
  {
    return this.sourceName;
  }
  
  public void setSourceName(String paramString)
  {
    this.sourceName = paramString;
  }
  
  public String getStoreCheckUnit()
  {
    return this.storeCheckUnit;
  }
  
  public void setStoreCheckUnit(String paramString)
  {
    this.storeCheckUnit = paramString;
  }
  
  public String getStoreName()
  {
    return this.storeName;
  }
  
  public void setStoreName(String paramString)
  {
    this.storeName = paramString;
  }
  
  public Long getArchivesSiteId()
  {
    return this.archivesSiteId;
  }
  
  public void setArchivesSiteId(Long paramLong)
  {
    this.archivesSiteId = paramLong;
  }
  
  public String getArchivesSiteCode()
  {
    return this.archivesSiteCode;
  }
  
  public void setArchivesSiteCode(String paramString)
  {
    this.archivesSiteCode = paramString;
  }
  
  public String getArchivesSiteName()
  {
    return this.archivesSiteName;
  }
  
  public void setArchivesSiteName(String paramString)
  {
    this.archivesSiteName = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getEnabledFlagName()
  {
    return this.enabledFlagName;
  }
  
  public void setEnabledFlagName(String paramString)
  {
    this.enabledFlagName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsAllotRelationsV
 * JD-Core Version:    0.7.0.1
 */