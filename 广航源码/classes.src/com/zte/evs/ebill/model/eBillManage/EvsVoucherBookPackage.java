package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsVoucherBookPackage
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private Long realtionId;
  private Long voucherId;
  private Long bookId;
  private Long packageId;
  private String enabledFlag;
  private Long bookSum;
  private Long bookCount;
  private String serialNum;
  private String beginNum;
  private String endNum;
  
  public Long getBookSum()
  {
    return this.bookSum;
  }
  
  public void setBookSum(Long paramLong)
  {
    this.bookSum = paramLong;
  }
  
  public Long getBookCount()
  {
    return this.bookCount;
  }
  
  public void setBookCount(Long paramLong)
  {
    this.bookCount = paramLong;
  }
  
  public String getSerialNum()
  {
    return this.serialNum;
  }
  
  public void setSerialNum(String paramString)
  {
    this.serialNum = paramString;
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
  
  public EvsVoucherBookPackage() {}
  
  public EvsVoucherBookPackage(Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4)
  {
    this.realtionId = paramLong1;
    this.voucherId = paramLong2;
    this.bookId = paramLong3;
    this.packageId = paramLong4;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
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
  
  public Long getRealtionId()
  {
    return this.realtionId;
  }
  
  public void setRealtionId(Long paramLong)
  {
    this.realtionId = paramLong;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public Long getBookId()
  {
    return this.bookId;
  }
  
  public void setBookId(Long paramLong)
  {
    this.bookId = paramLong;
  }
  
  public Long getPackageId()
  {
    return this.packageId;
  }
  
  public void setPackageId(Long paramLong)
  {
    this.packageId = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage
 * JD-Core Version:    0.7.0.1
 */