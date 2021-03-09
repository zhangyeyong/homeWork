package com.zte.evs.ebill.model.eBillManage;

import com.zte.evs.ebill.common.EvsStatusUtil;
import java.io.Serializable;
import java.util.Date;

public class EvsPackage
  implements Serializable
{
  private Long packageId;
  private String packageCode;
  private String setBookName;
  private String ouName;
  private String periodName;
  private String serialId;
  private String tradType;
  private Long beginNum;
  private Long endNum;
  private String packageStatus;
  private String statusName;
  private Long packageEmployeeId;
  private Date packageDate;
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private String packageBreakFlag;
  private Long companyId;
  private Date incomeDate;
  private Long incomeEmployeeId;
  private String warehouseCode;
  private String companyCode;
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public Date getIncomeDate()
  {
    return this.incomeDate;
  }
  
  public void setIncomeDate(Date paramDate)
  {
    this.incomeDate = paramDate;
  }
  
  public Long getIncomeEmployeeId()
  {
    return this.incomeEmployeeId;
  }
  
  public void setIncomeEmployeeId(Long paramLong)
  {
    this.incomeEmployeeId = paramLong;
  }
  
  public String getWarehouseCode()
  {
    return this.warehouseCode;
  }
  
  public void setWarehouseCode(String paramString)
  {
    this.warehouseCode = paramString;
  }
  
  public EvsPackage() {}
  
  public EvsPackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Long paramLong1, Long paramLong2, String paramString7, Long paramLong3, Date paramDate1, Date paramDate2, Long paramLong4, Date paramDate3, Long paramLong5, Long paramLong6, String paramString8)
  {
    this.packageCode = paramString1;
    this.setBookName = paramString2;
    this.ouName = paramString3;
    this.periodName = paramString4;
    this.serialId = paramString5;
    this.tradType = paramString6;
    this.beginNum = paramLong1;
    this.endNum = paramLong2;
    this.packageStatus = paramString7;
    this.packageEmployeeId = paramLong3;
    this.packageDate = paramDate1;
    this.creationDate = paramDate2;
    this.createdBy = paramLong4;
    this.lastUpdateDate = paramDate3;
    this.lastUpdateBy = paramLong5;
    this.lastUpdateLogin = paramLong6;
    this.packageBreakFlag = paramString8;
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
  
  public Long getBeginNum()
  {
    return this.beginNum;
  }
  
  public void setBeginNum(Long paramLong)
  {
    this.beginNum = paramLong;
  }
  
  public Long getEndNum()
  {
    return this.endNum;
  }
  
  public void setEndNum(Long paramLong)
  {
    this.endNum = paramLong;
  }
  
  public String getPackageStatus()
  {
    return this.packageStatus;
  }
  
  public void setPackageStatus(String paramString)
  {
    this.packageStatus = paramString;
  }
  
  public Long getPackageEmployeeId()
  {
    return this.packageEmployeeId;
  }
  
  public void setPackageEmployeeId(Long paramLong)
  {
    this.packageEmployeeId = paramLong;
  }
  
  public Date getPackageDate()
  {
    return this.packageDate;
  }
  
  public void setPackageDate(Date paramDate)
  {
    this.packageDate = paramDate;
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
  
  public String getStatusName()
  {
    if (getPackageStatus() != null) {
      return EvsStatusUtil.getVoucherStatusName(this.packageStatus);
    }
    return getPackageStatus();
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsPackage
 * JD-Core Version:    0.7.0.1
 */