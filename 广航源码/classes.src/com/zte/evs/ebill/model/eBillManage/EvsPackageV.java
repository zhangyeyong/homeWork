package com.zte.evs.ebill.model.eBillManage;

import com.zte.evs.ebill.common.EvsStatusUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EvsPackageV
  implements Serializable
{
  private Long packageId;
  private String packageCode;
  private String setBookName;
  private String unitName;
  private String periodName;
  private String tradType;
  private String packageStatus;
  private String statusName;
  private String packagePeople;
  private Date packageDate;
  private String ouName;
  private String setBookId;
  private String packageDateStr;
  private Long companyId;
  private String companyCode;
  private String companyName;
  private Date incomeDate;
  private Long incomeEmployeeId;
  private String incomeEmployeeName;
  private String warehouseCode;
  private String warehouseName;
  private Long packageEmployeeId;
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  
  public String getWarehouseName()
  {
    return this.warehouseName;
  }
  
  public void setWarehouseName(String paramString)
  {
    this.warehouseName = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
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
  
  public String getSetBookId()
  {
    return this.setBookId;
  }
  
  public void setSetBookId(String paramString)
  {
    this.setBookId = paramString;
  }
  
  public String getOuName()
  {
    return this.ouName;
  }
  
  public void setOuName(String paramString)
  {
    this.ouName = paramString;
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
  
  public String getUnitName()
  {
    return this.unitName;
  }
  
  public void setUnitName(String paramString)
  {
    this.unitName = paramString;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getTradType()
  {
    return this.tradType;
  }
  
  public void setTradType(String paramString)
  {
    this.tradType = paramString;
  }
  
  public String getPackageStatus()
  {
    return this.packageStatus;
  }
  
  public void setPackageStatus(String paramString)
  {
    this.packageStatus = paramString;
  }
  
  public Date getPackageDate()
  {
    return this.packageDate;
  }
  
  public void setPackageDate(Date paramDate)
  {
    this.packageDate = paramDate;
  }
  
  public Long getPackageId()
  {
    return this.packageId;
  }
  
  public void setPackageId(Long paramLong)
  {
    this.packageId = paramLong;
  }
  
  public String getPackagePeople()
  {
    return this.packagePeople;
  }
  
  public void setPackagePeople(String paramString)
  {
    this.packagePeople = paramString;
  }
  
  public String getPackageDateStr()
  {
    return this.format.format(this.packageDate);
  }
  
  public void setPackageDateStr(String paramString)
  {
    this.packageDateStr = paramString;
  }
  
  public Long getPackageEmployeeId()
  {
    return this.packageEmployeeId;
  }
  
  public void setPackageEmployeeId(Long paramLong)
  {
    this.packageEmployeeId = paramLong;
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
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsPackageV
 * JD-Core Version:    0.7.0.1
 */