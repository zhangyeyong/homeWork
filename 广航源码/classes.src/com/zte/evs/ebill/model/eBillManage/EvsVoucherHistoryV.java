package com.zte.evs.ebill.model.eBillManage;

import com.zte.evs.ebill.common.EvsStatusUtil;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class EvsVoucherHistoryV
  implements Serializable
{
  private Long historyId;
  private Long opObjectType;
  private String objectCode;
  private String opPeople;
  private String action;
  private String actionName;
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
  private String sourceCompanyCode;
  private String sourceCompanyName;
  private String storeCompanyCode;
  private String storeCompanyName;
  private BigInteger archivesSiteId;
  private String archivesSiteName;
  private String deptName;
  private String companyName;
  private String checkComment;
  private String describe;
  private String address;
  
  public String getCheckComment()
  {
    return this.checkComment;
  }
  
  public void setCheckComment(String paramString)
  {
    this.checkComment = paramString;
  }
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
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
  
  public String getOpPeople()
  {
    return this.opPeople;
  }
  
  public void setOpPeople(String paramString)
  {
    this.opPeople = paramString;
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
    if (getEndStatus() != null) {
      return EvsStatusUtil.getVoucherStatusName(this.endStatus);
    }
    return getEndStatus();
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public String getSourceCompanyCode()
  {
    return this.sourceCompanyCode;
  }
  
  public void setSourceCompanyCode(String paramString)
  {
    this.sourceCompanyCode = paramString;
  }
  
  public String getSourceCompanyName()
  {
    return this.sourceCompanyName;
  }
  
  public void setSourceCompanyName(String paramString)
  {
    this.sourceCompanyName = paramString;
  }
  
  public String getStoreCompanyCode()
  {
    return this.storeCompanyCode;
  }
  
  public void setStoreCompanyCode(String paramString)
  {
    this.storeCompanyCode = paramString;
  }
  
  public String getStoreCompanyName()
  {
    return this.storeCompanyName;
  }
  
  public void setStoreCompanyName(String paramString)
  {
    this.storeCompanyName = paramString;
  }
  
  public BigInteger getArchivesSiteId()
  {
    return this.archivesSiteId;
  }
  
  public void setArchivesSiteId(BigInteger paramBigInteger)
  {
    this.archivesSiteId = paramBigInteger;
  }
  
  public String getArchivesSiteName()
  {
    return this.archivesSiteName;
  }
  
  public void setArchivesSiteName(String paramString)
  {
    this.archivesSiteName = paramString;
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
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getDescribe()
  {
    return this.describe;
  }
  
  public void setDescribe(String paramString)
  {
    this.describe = paramString;
  }
  
  public String getActionName()
  {
    return this.actionName;
  }
  
  public void setActionName(String paramString)
  {
    this.actionName = paramString;
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
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryV
 * JD-Core Version:    0.7.0.1
 */