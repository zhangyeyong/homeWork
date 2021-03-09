package com.zte.evs.ebill.model.eBillManage;

import com.zte.evs.ebill.common.EvsStatusUtil;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class EvsVoucherHistory
  implements Serializable
{
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
  private String statusName;
  private String checkComment;
  private Long companyId;
  protected String sourceCompanyCode;
  protected String storeCompanyCode;
  protected BigInteger archivesSiteId;
  protected String describe;
  private String address;
  
  public EvsVoucherHistory() {}
  
  public EvsVoucherHistory(Long paramLong1, String paramString1, Long paramLong2, String paramString2, Date paramDate1, Date paramDate2, Long paramLong3, Date paramDate3, Long paramLong4, Long paramLong5, String paramString3, String paramString4, String paramString5, String paramString6)
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
    this.statusName = paramString6;
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
  
  public String getStatusName()
  {
    if (getBeginStatus() != null) {
      return EvsStatusUtil.getVoucherStatusName(this.endStatus);
    }
    return getBeginStatus();
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public BigInteger getArchivesSiteId()
  {
    return this.archivesSiteId;
  }
  
  public void setArchivesSiteId(BigInteger paramBigInteger)
  {
    this.archivesSiteId = paramBigInteger;
  }
  
  public String getSourceCompanyCode()
  {
    return this.sourceCompanyCode;
  }
  
  public void setSourceCompanyCode(String paramString)
  {
    this.sourceCompanyCode = paramString;
  }
  
  public String getStoreCompanyCode()
  {
    return this.storeCompanyCode;
  }
  
  public void setStoreCompanyCode(String paramString)
  {
    this.storeCompanyCode = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCheckComment()
  {
    return this.checkComment;
  }
  
  public void setCheckComment(String paramString)
  {
    this.checkComment = paramString;
  }
  
  public String getDescribe()
  {
    return this.describe;
  }
  
  public void setDescribe(String paramString)
  {
    this.describe = paramString;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherHistory
 * JD-Core Version:    0.7.0.1
 */