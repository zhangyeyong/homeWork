package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;

public class EvsAllotTypesV
  implements Serializable
{
  private Long allotTypeId;
  private String allotTypeCode;
  private String allotTypeName;
  private Long allotWayId;
  private String allotWay;
  private String allotWayName;
  private String enabledFlag;
  private String enabledFlagName;
  private String description;
  
  public EvsAllotTypesV() {}
  
  public EvsAllotTypesV(Long paramLong1, String paramString1, String paramString2, Long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.allotTypeId = paramLong1;
    this.allotTypeCode = paramString1;
    this.allotTypeName = paramString2;
    this.allotWayId = paramLong2;
    this.allotWay = paramString3;
    this.allotWayName = paramString4;
    this.enabledFlag = paramString5;
    this.enabledFlagName = paramString6;
    this.description = paramString7;
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
  
  public Long getAllotWayId()
  {
    return this.allotWayId;
  }
  
  public void setAllotWayId(Long paramLong)
  {
    this.allotWayId = paramLong;
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
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsAllotTypesV
 * JD-Core Version:    0.7.0.1
 */