package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsVoucherCheckHistories
  implements Serializable
{
  private Date lastUpdateDate;
  private Long lastUpdatedBy;
  private Date creationDate;
  private Long createdBy;
  private Long lastUpdateLogin;
  private String enabledFlag;
  private Long historiesId;
  private Long voucherId;
  private Long checkEmployeeId;
  private String checkEmployeeNum;
  private String checkEmployeeName;
  private Date checkDate;
  private String checkComment;
  
  public EvsVoucherCheckHistories() {}
  
  public EvsVoucherCheckHistories(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, Long paramLong5, Long paramLong6, String paramString2, String paramString3, Date paramDate3, String paramString4)
  {
    this.lastUpdateDate = paramDate1;
    this.lastUpdatedBy = paramLong1;
    this.creationDate = paramDate2;
    this.createdBy = paramLong2;
    this.lastUpdateLogin = paramLong3;
    this.enabledFlag = paramString1;
    this.historiesId = paramLong4;
    this.voucherId = paramLong5;
    this.checkEmployeeId = paramLong6;
    this.checkEmployeeNum = paramString2;
    this.checkEmployeeName = paramString3;
    this.checkDate = paramDate3;
    this.checkComment = paramString4;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdatedDy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedDy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
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
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Long getHistoriesId()
  {
    return this.historiesId;
  }
  
  public void setHistoriesId(Long paramLong)
  {
    this.historiesId = paramLong;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public Long getCheckEmployeeId()
  {
    return this.checkEmployeeId;
  }
  
  public void setCheckEmployeeId(Long paramLong)
  {
    this.checkEmployeeId = paramLong;
  }
  
  public String getCheckEmployeeNum()
  {
    return this.checkEmployeeNum;
  }
  
  public void setCheckEmployeeNum(String paramString)
  {
    this.checkEmployeeNum = paramString;
  }
  
  public String getCheckEmployeeName()
  {
    return this.checkEmployeeName;
  }
  
  public void setCheckEmployeeName(String paramString)
  {
    this.checkEmployeeName = paramString;
  }
  
  public Date getCheckDate()
  {
    return this.checkDate;
  }
  
  public void setCheckDate(Date paramDate)
  {
    this.checkDate = paramDate;
  }
  
  public String getCheckComment()
  {
    return this.checkComment;
  }
  
  public void setCheckComment(String paramString)
  {
    this.checkComment = paramString;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherCheckHistories
 * JD-Core Version:    0.7.0.1
 */