package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;

public class EvsInventoryV
  implements Serializable
{
  private Long rn;
  private String invCityId;
  private String cityName;
  private String invStorageCode;
  private String storageName;
  private String invArea;
  private String areaName;
  private String invRow;
  private String rowName;
  private String invColumn;
  private String columnName;
  private String invLevel;
  private String levelName;
  private Long bookCount;
  private String blurQuery;
  
  public String getBlurQuery()
  {
    return this.blurQuery;
  }
  
  public void setBlurQuery(String paramString)
  {
    this.blurQuery = paramString;
  }
  
  public Long getRn()
  {
    return this.rn;
  }
  
  public void setRn(Long paramLong)
  {
    this.rn = paramLong;
  }
  
  public String getCityName()
  {
    return this.cityName;
  }
  
  public void setCityName(String paramString)
  {
    this.cityName = paramString;
  }
  
  public String getStorageName()
  {
    return this.storageName;
  }
  
  public void setStorageName(String paramString)
  {
    this.storageName = paramString;
  }
  
  public String getInvArea()
  {
    return this.invArea;
  }
  
  public void setInvArea(String paramString)
  {
    this.invArea = paramString;
  }
  
  public String getAreaName()
  {
    return this.areaName;
  }
  
  public void setAreaName(String paramString)
  {
    this.areaName = paramString;
  }
  
  public String getInvRow()
  {
    return this.invRow;
  }
  
  public void setInvRow(String paramString)
  {
    this.invRow = paramString;
  }
  
  public String getRowName()
  {
    return this.rowName;
  }
  
  public void setRowName(String paramString)
  {
    this.rowName = paramString;
  }
  
  public String getInvColumn()
  {
    return this.invColumn;
  }
  
  public void setInvColumn(String paramString)
  {
    this.invColumn = paramString;
  }
  
  public String getColumnName()
  {
    return this.columnName;
  }
  
  public void setColumnName(String paramString)
  {
    this.columnName = paramString;
  }
  
  public String getInvLevel()
  {
    return this.invLevel;
  }
  
  public void setInvLevel(String paramString)
  {
    this.invLevel = paramString;
  }
  
  public String getLevelName()
  {
    return this.levelName;
  }
  
  public void setLevelName(String paramString)
  {
    this.levelName = paramString;
  }
  
  public Long getBookCount()
  {
    return this.bookCount;
  }
  
  public void setBookCount(Long paramLong)
  {
    this.bookCount = paramLong;
  }
  
  public String getInvCityId()
  {
    return this.invCityId;
  }
  
  public void setInvCityId(String paramString)
  {
    this.invCityId = paramString;
  }
  
  public String getInvStorageCode()
  {
    return this.invStorageCode;
  }
  
  public void setInvStorageCode(String paramString)
  {
    this.invStorageCode = paramString;
  }
  
  public EvsInventoryV(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, Long paramLong2, String paramString13)
  {
    this.rn = paramLong1;
    this.invCityId = paramString1;
    this.cityName = paramString2;
    this.invStorageCode = paramString3;
    this.storageName = paramString4;
    this.invArea = paramString5;
    this.areaName = paramString6;
    this.invRow = paramString7;
    this.rowName = paramString8;
    this.invColumn = paramString9;
    this.columnName = paramString10;
    this.invLevel = paramString11;
    this.levelName = paramString12;
    this.bookCount = paramLong2;
    this.blurQuery = paramString13;
  }
  
  public EvsInventoryV() {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsInventoryV
 * JD-Core Version:    0.7.0.1
 */