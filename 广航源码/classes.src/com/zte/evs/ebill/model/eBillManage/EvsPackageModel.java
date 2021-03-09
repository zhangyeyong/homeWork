package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsPackageModel
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long packageId;
  private String packageCode;
  private String setBookName;
  private String ouName;
  private String periodName;
  private String serialId;
  private String tradType;
  private String beginNum;
  private String endNum;
  private String packageStatus;
  private String packageEmployeeId;
  private String packageEmployeeName;
  private String packageDate;
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private String packageBreakFlag;
  private String companyId;
  private String companyName;
  private String incomeDate;
  private String incomeTempDate;
  private String incomeEmployeeId;
  private String incomeEmployeeName;
  private String warehouseCode;
  private String tempDate;
  private String tempCode;
  private String likeSelect;
  
  public String getLikeSelect()
  {
    return this.likeSelect;
  }
  
  public void setLikeSelect(String paramString)
  {
    this.likeSelect = paramString;
  }
  
  public EvsPackageModel() {}
  
  public EvsPackageModel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString12, String paramString13, String paramString14)
  {
    this.packageCode = paramString1;
    this.setBookName = paramString2;
    this.ouName = paramString3;
    this.periodName = paramString4;
    this.serialId = paramString5;
    this.tradType = paramString6;
    this.beginNum = paramString7;
    this.endNum = paramString8;
    this.packageStatus = paramString9;
    this.packageEmployeeId = paramString10;
    this.packageDate = paramString11;
    this.creationDate = paramDate1;
    this.createdBy = paramLong1;
    this.lastUpdateDate = paramDate2;
    this.lastUpdateBy = paramLong2;
    this.lastUpdateLogin = paramLong3;
    this.packageBreakFlag = paramString12;
    this.tempDate = paramString13;
    this.tempCode = paramString14;
  }
  
  public Long getPackageId()
  {
    return this.packageId;
  }
  
  public void setPackageId(Long paramLong)
  {
    this.packageId = paramLong;
  }
  
  public String getPackageCode()
  {
    return this.packageCode;
  }
  
  public void setPackageCode(String paramString)
  {
    this.packageCode = paramString;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
  }
  
  public String getOuName()
  {
    return this.ouName;
  }
  
  public void setOuName(String paramString)
  {
    this.ouName = paramString;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getSerialId()
  {
    return this.serialId;
  }
  
  public void setSerialId(String paramString)
  {
    this.serialId = paramString;
  }
  
  public String getTradType()
  {
    return this.tradType;
  }
  
  public void setTradType(String paramString)
  {
    this.tradType = paramString;
  }
  
  public String getBeginNum()
  {
    return this.beginNum;
  }
  
  public void setBeginNum(String paramString)
  {
    this.beginNum = paramString;
  }
  
  public String getEndNum()
  {
    return this.endNum;
  }
  
  public void setEndNum(String paramString)
  {
    this.endNum = paramString;
  }
  
  public String getPackageStatus()
  {
    return this.packageStatus;
  }
  
  public void setPackageStatus(String paramString)
  {
    this.packageStatus = paramString;
  }
  
  public String getPackageEmployeeId()
  {
    return this.packageEmployeeId;
  }
  
  public void setPackageEmployeeId(String paramString)
  {
    this.packageEmployeeId = paramString;
  }
  
  public String getPackageDate()
  {
    return this.packageDate;
  }
  
  public void setPackageDate(String paramString)
  {
    this.packageDate = paramString;
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
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdateBy()
  {
    return this.lastUpdateBy;
  }
  
  public void setLastUpdateBy(Long paramLong)
  {
    this.lastUpdateBy = paramLong;
  }
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public String getPackageBreakFlag()
  {
    return this.packageBreakFlag;
  }
  
  public void setPackageBreakFlag(String paramString)
  {
    this.packageBreakFlag = paramString;
  }
  
  public String getTempDate()
  {
    return this.tempDate;
  }
  
  public void setTempDate(String paramString)
  {
    this.tempDate = paramString;
  }
  
  public String getTempCode()
  {
    return this.tempCode;
  }
  
  public void setTempCode(String paramString)
  {
    this.tempCode = paramString;
  }
  
  public String getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(String paramString)
  {
    this.companyId = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getIncomeDate()
  {
    return this.incomeDate;
  }
  
  public void setIncomeDate(String paramString)
  {
    this.incomeDate = paramString;
  }
  
  public String getIncomeEmployeeId()
  {
    return this.incomeEmployeeId;
  }
  
  public void setIncomeEmployeeId(String paramString)
  {
    this.incomeEmployeeId = paramString;
  }
  
  public String getIncomeEmployeeName()
  {
    return this.incomeEmployeeName;
  }
  
  public void setIncomeEmployeeName(String paramString)
  {
    this.incomeEmployeeName = paramString;
  }
  
  public String getWarehouseCode()
  {
    return this.warehouseCode;
  }
  
  public void setWarehouseCode(String paramString)
  {
    this.warehouseCode = paramString;
  }
  
  public String getIncomeTempDate()
  {
    return this.incomeTempDate;
  }
  
  public void setIncomeTempDate(String paramString)
  {
    this.incomeTempDate = paramString;
  }
  
  public String getPackageEmployeeName()
  {
    return this.packageEmployeeName;
  }
  
  public void setPackageEmployeeName(String paramString)
  {
    this.packageEmployeeName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsPackageModel
 * JD-Core Version:    0.7.0.1
 */