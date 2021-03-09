package com.zte.evs.ebill.model.eBillManage;

import java.util.Date;

public class EvsVoucherHistoryModel
{
  private static final long serialVersionUID = 1L;
  private Long historyId;
  private Long opObjectType;
  private String objectCode;
  private Long opPeople;
  private String action;
  private Date handleDate;
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private String beginStatus;
  private String endStatus;
  private String positionsName;
  
  public EvsVoucherHistoryModel() {}
  
  public EvsVoucherHistoryModel(Long paramLong1, String paramString1, Long paramLong2, String paramString2, Date paramDate1, Date paramDate2, Long paramLong3, Date paramDate3, Long paramLong4, Long paramLong5, String paramString3, String paramString4, String paramString5)
  {
    this.opObjectType = paramLong1;
    this.objectCode = paramString1;
    this.opPeople = paramLong2;
    this.action = paramString2;
    this.handleDate = paramDate1;
    this.creationDate = paramDate2;
    this.createdBy = paramLong3;
    this.lastUpdateDate = paramDate3;
    this.lastUpdateBy = paramLong4;
    this.lastUpdateLogin = paramLong5;
    this.beginStatus = paramString3;
    this.endStatus = paramString4;
    this.positionsName = paramString5;
  }
  
  public Long getHistoryId()
  {
    return this.historyId;
  }
  
  public void setHistoryId(Long paramLong)
  {
    this.historyId = paramLong;
  }
  
  public Long getOpObjectType()
  {
    return this.opObjectType;
  }
  
  public void setOpObjectType(Long paramLong)
  {
    this.opObjectType = paramLong;
  }
  
  public String getObjectCode()
  {
    return this.objectCode;
  }
  
  public void setObjectCode(String paramString)
  {
    this.objectCode = paramString;
  }
  
  public Long getOpPeople()
  {
    return this.opPeople;
  }
  
  public void setOpPeople(Long paramLong)
  {
    this.opPeople = paramLong;
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public Date getHandleDate()
  {
    return this.handleDate;
  }
  
  public void setHandleDate(Date paramDate)
  {
    this.handleDate = paramDate;
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
  
  public String getBeginStatus()
  {
    return this.beginStatus;
  }
  
  public void setBeginStatus(String paramString)
  {
    this.beginStatus = paramString;
  }
  
  public String getEndStatus()
  {
    return this.endStatus;
  }
  
  public void setEndStatus(String paramString)
  {
    this.endStatus = paramString;
  }
  
  public String getPositionsName()
  {
    return this.positionsName;
  }
  
  public void setPositionsName(String paramString)
  {
    this.positionsName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryModel
 * JD-Core Version:    0.7.0.1
 */