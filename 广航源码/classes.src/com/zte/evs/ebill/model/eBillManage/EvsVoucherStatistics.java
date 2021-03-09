package com.zte.evs.ebill.model.eBillManage;

import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvsVoucherStatistics
  implements Serializable
{
  private Long companyId;
  private String companyCode;
  private String companyName;
  private Long voucherBookFHY;
  private Long voucherBookTY = Long.valueOf(0L);
  private Long voucherNumberFHY = Long.valueOf(0L);
  private Long voucherNumberTY = Long.valueOf(0L);
  private Long voucherPageFHY = Long.valueOf(0L);
  private Long voucherPageTY = Long.valueOf(0L);
  private String month;
  private String chinaMonth;
  private Long ERPVoucherNumber = Long.valueOf(0L);
  private String isCloseBook;
  private String payableVoucher;
  private String payVoucher;
  private String ledgerVoucher;
  private String voucherBigId;
  private String voucherBigCode;
  private String voucherBigClass;
  private Long voucherTotalBookNumber = Long.valueOf(0L);
  private Long MISVoucher = Long.valueOf(0L);
  private Long notBookNumber = Long.valueOf(0L);
  private String voucherBookId;
  private String voucherBook;
  private String depositSite;
  private String biginVoucherNumber;
  private String endVoucherNumber;
  private Date bookDate;
  private String isBreakNumber;
  private String status;
  private String years;
  private Long voucherNumber = Long.valueOf(0L);
  private Long voucherBookNumber = Long.valueOf(0L);
  private Long voucherPageNumber = Long.valueOf(0L);
  private Map<Integer, Map<List<String>, List<FbpLookupValuesV>>> map = new HashMap();
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public Long getVoucherBookFHY()
  {
    return this.voucherBookFHY;
  }
  
  public void setVoucherBookFHY(Long paramLong)
  {
    this.voucherBookFHY = paramLong;
  }
  
  public Long getVoucherBookTY()
  {
    return this.voucherBookTY;
  }
  
  public void setVoucherBookTY(Long paramLong)
  {
    this.voucherBookTY = paramLong;
  }
  
  public long getVoucherNumberFHY()
  {
    return this.voucherNumberFHY.longValue();
  }
  
  public void setVoucherNumberFHY(long paramLong)
  {
    this.voucherNumberFHY = Long.valueOf(paramLong);
  }
  
  public long getVoucherNumberTY()
  {
    return this.voucherNumberTY.longValue();
  }
  
  public void setVoucherNumberTY(long paramLong)
  {
    this.voucherNumberTY = Long.valueOf(paramLong);
  }
  
  public long getVoucherPageFHY()
  {
    return this.voucherPageFHY.longValue();
  }
  
  public void setVoucherPageFHY(long paramLong)
  {
    this.voucherPageFHY = Long.valueOf(paramLong);
  }
  
  public long getVoucherPageTY()
  {
    return this.voucherPageTY.longValue();
  }
  
  public void setVoucherPageTY(long paramLong)
  {
    this.voucherPageTY = Long.valueOf(paramLong);
  }
  
  public String getMonth()
  {
    return this.month;
  }
  
  public void setMonth(String paramString)
  {
    this.month = paramString;
  }
  
  public Long getERPVoucherNumber()
  {
    return this.ERPVoucherNumber;
  }
  
  public void setERPVoucherNumber(Long paramLong)
  {
    this.ERPVoucherNumber = paramLong;
  }
  
  public String getIsCloseBook()
  {
    return this.isCloseBook;
  }
  
  public void setIsCloseBook(String paramString)
  {
    this.isCloseBook = paramString;
  }
  
  public String getPayableVoucher()
  {
    return this.payableVoucher;
  }
  
  public void setPayableVoucher(String paramString)
  {
    this.payableVoucher = paramString;
  }
  
  public String getPayVoucher()
  {
    return this.payVoucher;
  }
  
  public void setPayVoucher(String paramString)
  {
    this.payVoucher = paramString;
  }
  
  public String getLedgerVoucher()
  {
    return this.ledgerVoucher;
  }
  
  public void setLedgerVoucher(String paramString)
  {
    this.ledgerVoucher = paramString;
  }
  
  public String getVoucherBigClass()
  {
    return this.voucherBigClass;
  }
  
  public void setVoucherBigClass(String paramString)
  {
    this.voucherBigClass = paramString;
  }
  
  public Long getVoucherTotalBookNumber()
  {
    return this.voucherTotalBookNumber;
  }
  
  public void setVoucherTotalBookNumber(Long paramLong)
  {
    this.voucherTotalBookNumber = paramLong;
  }
  
  public Long getMISVoucher()
  {
    return this.MISVoucher;
  }
  
  public void setMISVoucher(Long paramLong)
  {
    this.MISVoucher = paramLong;
  }
  
  public Long getNotBookNumber()
  {
    return this.notBookNumber;
  }
  
  public void setNotBookNumber(Long paramLong)
  {
    this.notBookNumber = paramLong;
  }
  
  public String getVoucherBook()
  {
    return this.voucherBook;
  }
  
  public void setVoucherBook(String paramString)
  {
    this.voucherBook = paramString;
  }
  
  public String getBiginVoucherNumber()
  {
    return this.biginVoucherNumber;
  }
  
  public void setBiginVoucherNumber(String paramString)
  {
    this.biginVoucherNumber = paramString;
  }
  
  public String getEndVoucherNumber()
  {
    return this.endVoucherNumber;
  }
  
  public void setEndVoucherNumber(String paramString)
  {
    this.endVoucherNumber = paramString;
  }
  
  public Date getBookDate()
  {
    return this.bookDate;
  }
  
  public void setBookDate(Date paramDate)
  {
    this.bookDate = paramDate;
  }
  
  public String getIsBreakNumber()
  {
    return this.isBreakNumber;
  }
  
  public void setIsBreakNumber(String paramString)
  {
    this.isBreakNumber = paramString;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public String getYears()
  {
    return this.years;
  }
  
  public void setYears(String paramString)
  {
    this.years = paramString;
  }
  
  public Long getVoucherNumber()
  {
    return this.voucherNumber;
  }
  
  public void setVoucherNumber(Long paramLong)
  {
    this.voucherNumber = paramLong;
  }
  
  public Long getVoucherBookNumber()
  {
    return this.voucherBookNumber;
  }
  
  public void setVoucherBookNumber(Long paramLong)
  {
    this.voucherBookNumber = paramLong;
  }
  
  public Long getVoucherPageNumber()
  {
    return this.voucherPageNumber;
  }
  
  public void setVoucherPageNumber(Long paramLong)
  {
    this.voucherPageNumber = paramLong;
  }
  
  public Map<Integer, Map<List<String>, List<FbpLookupValuesV>>> getMap()
  {
    return this.map;
  }
  
  public void setMap(Map<Integer, Map<List<String>, List<FbpLookupValuesV>>> paramMap)
  {
    this.map = paramMap;
  }
  
  public String getVoucherBigId()
  {
    return this.voucherBigId;
  }
  
  public void setVoucherBigId(String paramString)
  {
    this.voucherBigId = paramString;
  }
  
  public String getVoucherBigCode()
  {
    return this.voucherBigCode;
  }
  
  public void setVoucherBigCode(String paramString)
  {
    this.voucherBigCode = paramString;
  }
  
  public void setVoucherNumberFHY(Long paramLong)
  {
    this.voucherNumberFHY = paramLong;
  }
  
  public void setVoucherNumberTY(Long paramLong)
  {
    this.voucherNumberTY = paramLong;
  }
  
  public void setVoucherPageFHY(Long paramLong)
  {
    this.voucherPageFHY = paramLong;
  }
  
  public void setVoucherPageTY(Long paramLong)
  {
    this.voucherPageTY = paramLong;
  }
  
  public String getChinaMonth()
  {
    return this.chinaMonth;
  }
  
  public void setChinaMonth(String paramString)
  {
    this.chinaMonth = paramString;
  }
  
  public String getVoucherBookId()
  {
    return this.voucherBookId;
  }
  
  public void setVoucherBookId(String paramString)
  {
    this.voucherBookId = paramString;
  }
  
  public String getDepositSite()
  {
    return this.depositSite;
  }
  
  public void setDepositSite(String paramString)
  {
    this.depositSite = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherStatistics
 * JD-Core Version:    0.7.0.1
 */