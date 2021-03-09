package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;

public class FasciculeQueryModel
  implements Serializable
{
  private String month;
  private String times;
  private Long voucherBooks;
  private Long vouchersums;
  private Long novouchersums;
  private Long voucherPages;
  private String flage;
  private Long ouId;
  private String ouName;
  private Long vouchersums_sb;
  private Long voucherPages_sb;
  private Long voucherBooks_sb;
  private String checkUnit;
  private String erpId;
  private String months;
  private String years;
  
  public String getMonths()
  {
    return this.months;
  }
  
  public void setMonths(String paramString)
  {
    this.months = paramString;
  }
  
  public String getYears()
  {
    return this.years;
  }
  
  public void setYears(String paramString)
  {
    this.years = paramString;
  }
  
  public String getErpId()
  {
    return this.erpId;
  }
  
  public void setErpId(String paramString)
  {
    this.erpId = paramString;
  }
  
  public Long getVoucherBooks_sb()
  {
    return this.voucherBooks_sb;
  }
  
  public void setVoucherBooks_sb(Long paramLong)
  {
    this.voucherBooks_sb = paramLong;
  }
  
  public Long getVoucherPages_sb()
  {
    return this.voucherPages_sb;
  }
  
  public void setVoucherPages_sb(Long paramLong)
  {
    this.voucherPages_sb = paramLong;
  }
  
  public Long getVouchersums_sb()
  {
    return this.vouchersums_sb;
  }
  
  public void setVouchersums_sb(Long paramLong)
  {
    this.vouchersums_sb = paramLong;
  }
  
  public Long getOuId()
  {
    return this.ouId;
  }
  
  public void setOuId(Long paramLong)
  {
    this.ouId = paramLong;
  }
  
  public String getOuName()
  {
    return this.ouName;
  }
  
  public void setOuName(String paramString)
  {
    this.ouName = paramString;
  }
  
  public String getFlage()
  {
    return this.flage;
  }
  
  public void setFlage(String paramString)
  {
    this.flage = paramString;
  }
  
  public String getMonth()
  {
    return this.month;
  }
  
  public void setMonth(String paramString)
  {
    this.month = paramString;
  }
  
  public Long getNovouchersums()
  {
    return this.novouchersums;
  }
  
  public void setNovouchersums(Long paramLong)
  {
    this.novouchersums = paramLong;
  }
  
  public Long getVoucherBooks()
  {
    return this.voucherBooks;
  }
  
  public void setVoucherBooks(Long paramLong)
  {
    this.voucherBooks = paramLong;
  }
  
  public Long getVoucherPages()
  {
    return this.voucherPages;
  }
  
  public void setVoucherPages(Long paramLong)
  {
    this.voucherPages = paramLong;
  }
  
  public Long getVouchersums()
  {
    return this.vouchersums;
  }
  
  public void setVouchersums(Long paramLong)
  {
    this.vouchersums = paramLong;
  }
  
  public String getTimes()
  {
    return this.times;
  }
  
  public void setTimes(String paramString)
  {
    this.times = paramString;
  }
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.FasciculeQueryModel
 * JD-Core Version:    0.7.0.1
 */