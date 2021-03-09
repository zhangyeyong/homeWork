package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsAllotHeaders
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected BigInteger allotHeaderId;
  protected String allotNum;
  protected BigInteger allotTypeId;
  protected Date allotDate;
  protected String sourceCheckUnit;
  protected String storeCheckUnit;
  protected BigInteger archivesSiteId;
  protected String allotDesc;
  protected BigInteger allotBy;
  protected String allotMode;
  protected String allotStatus;
  protected BigInteger receiveBy;
  protected Date receiveDate;
  protected BigInteger receiveTypeId;
  protected String attribute1;
  protected String attribute2;
  protected String attribute3;
  protected String attribute4;
  protected String attribute5;
  protected String attribute6;
  protected String attribute7;
  protected String attribute8;
  protected String attribute9;
  protected String allotDateStr;
  protected String attribute10;
  protected Date beginDate;
  protected Date endDate;
  private String receiveByStr;
  private String storageStr;
  private String companyStr;
  protected Long companyId;
  
  public EvsAllotHeaders() {}
  
  public EvsAllotHeaders(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, BigInteger paramBigInteger1, String paramString2, BigInteger paramBigInteger2, Date paramDate3, String paramString3, String paramString4, BigInteger paramBigInteger3, String paramString5, BigInteger paramBigInteger4, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setAllotHeaderId(paramBigInteger1);
    setAllotNum(paramString2);
    setAllotTypeId(paramBigInteger2);
    setAllotDate(paramDate3);
    setSourceCheckUnit(paramString3);
    setStoreCheckUnit(paramString4);
    setArchivesSiteId(paramBigInteger3);
    setAllotDesc(paramString5);
    setAllotBy(paramBigInteger4);
    setAllotMode(paramString6);
    setAllotStatus(paramString7);
    setAttribute1(paramString8);
    setAttribute2(paramString9);
    setAttribute3(paramString10);
    setAttribute4(paramString11);
    setAttribute5(paramString12);
    setAttribute6(paramString13);
    setAttribute7(paramString14);
    setAttribute8(paramString15);
    setAttribute9(paramString16);
    setAttribute10(paramString17);
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
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
  
  public BigInteger getAllotHeaderId()
  {
    return this.allotHeaderId;
  }
  
  public void setAllotHeaderId(BigInteger paramBigInteger)
  {
    this.allotHeaderId = paramBigInteger;
  }
  
  public String getAllotNum()
  {
    return this.allotNum;
  }
  
  public void setAllotNum(String paramString)
  {
    this.allotNum = paramString;
  }
  
  public BigInteger getAllotTypeId()
  {
    return this.allotTypeId;
  }
  
  public void setAllotTypeId(BigInteger paramBigInteger)
  {
    this.allotTypeId = paramBigInteger;
  }
  
  public Date getAllotDate()
  {
    return this.allotDate;
  }
  
  public void setAllotDate(Date paramDate)
  {
    this.allotDate = paramDate;
  }
  
  public String getSourceCheckUnit()
  {
    return this.sourceCheckUnit;
  }
  
  public void setSourceCheckUnit(String paramString)
  {
    this.sourceCheckUnit = paramString;
  }
  
  public String getStoreCheckUnit()
  {
    return this.storeCheckUnit;
  }
  
  public void setStoreCheckUnit(String paramString)
  {
    this.storeCheckUnit = paramString;
  }
  
  public BigInteger getArchivesSiteId()
  {
    return this.archivesSiteId;
  }
  
  public void setArchivesSiteId(BigInteger paramBigInteger)
  {
    this.archivesSiteId = paramBigInteger;
  }
  
  public String getAllotDesc()
  {
    return this.allotDesc;
  }
  
  public void setAllotDesc(String paramString)
  {
    this.allotDesc = paramString;
  }
  
  public BigInteger getAllotBy()
  {
    return this.allotBy;
  }
  
  public void setAllotBy(BigInteger paramBigInteger)
  {
    this.allotBy = paramBigInteger;
  }
  
  public String getAllotMode()
  {
    return this.allotMode;
  }
  
  public void setAllotMode(String paramString)
  {
    this.allotMode = paramString;
  }
  
  public String getAllotStatus()
  {
    return this.allotStatus;
  }
  
  public void setAllotStatus(String paramString)
  {
    this.allotStatus = paramString;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
  }
  
  public String getAttribute2()
  {
    return this.attribute2;
  }
  
  public void setAttribute2(String paramString)
  {
    this.attribute2 = paramString;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public void setAttribute3(String paramString)
  {
    this.attribute3 = paramString;
  }
  
  public String getAttribute4()
  {
    return this.attribute4;
  }
  
  public void setAttribute4(String paramString)
  {
    this.attribute4 = paramString;
  }
  
  public String getAttribute5()
  {
    return this.attribute5;
  }
  
  public void setAttribute5(String paramString)
  {
    this.attribute5 = paramString;
  }
  
  public String getAttribute6()
  {
    return this.attribute6;
  }
  
  public void setAttribute6(String paramString)
  {
    this.attribute6 = paramString;
  }
  
  public String getAttribute7()
  {
    return this.attribute7;
  }
  
  public void setAttribute7(String paramString)
  {
    this.attribute7 = paramString;
  }
  
  public String getAttribute8()
  {
    return this.attribute8;
  }
  
  public void setAttribute8(String paramString)
  {
    this.attribute8 = paramString;
  }
  
  public String getAttribute9()
  {
    return this.attribute9;
  }
  
  public void setAttribute9(String paramString)
  {
    this.attribute9 = paramString;
  }
  
  public String getAttribute10()
  {
    return this.attribute10;
  }
  
  public void setAttribute10(String paramString)
  {
    this.attribute10 = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsAllotHeaders)) {
      return false;
    }
    EvsAllotHeaders localEvsAllotHeaders = (EvsAllotHeaders)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localEvsAllotHeaders.lastUpdateDate).append(this.lastUpdatedBy, localEvsAllotHeaders.lastUpdatedBy).append(this.creationDate, localEvsAllotHeaders.creationDate).append(this.createdBy, localEvsAllotHeaders.createdBy).append(this.lastUpdateLogin, localEvsAllotHeaders.lastUpdateLogin).append(this.enabledFlag, localEvsAllotHeaders.enabledFlag).append(this.allotHeaderId, localEvsAllotHeaders.allotHeaderId).append(this.allotNum, localEvsAllotHeaders.allotNum).append(this.allotTypeId, localEvsAllotHeaders.allotTypeId).append(this.allotDate, localEvsAllotHeaders.allotDate).append(this.sourceCheckUnit, localEvsAllotHeaders.sourceCheckUnit).append(this.storeCheckUnit, localEvsAllotHeaders.storeCheckUnit).append(this.archivesSiteId, localEvsAllotHeaders.archivesSiteId).append(this.allotDesc, localEvsAllotHeaders.allotDesc).append(this.allotBy, localEvsAllotHeaders.allotBy).append(this.allotMode, localEvsAllotHeaders.allotMode).append(this.allotStatus, localEvsAllotHeaders.allotStatus).append(this.attribute1, localEvsAllotHeaders.attribute1).append(this.attribute2, localEvsAllotHeaders.attribute2).append(this.attribute3, localEvsAllotHeaders.attribute3).append(this.attribute4, localEvsAllotHeaders.attribute4).append(this.attribute5, localEvsAllotHeaders.attribute5).append(this.attribute6, localEvsAllotHeaders.attribute6).append(this.attribute7, localEvsAllotHeaders.attribute7).append(this.attribute8, localEvsAllotHeaders.attribute8).append(this.attribute9, localEvsAllotHeaders.attribute9).append(this.attribute10, localEvsAllotHeaders.attribute10).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.allotHeaderId).append(this.allotNum).append(this.allotTypeId).append(this.allotDate).append(this.sourceCheckUnit).append(this.storeCheckUnit).append(this.archivesSiteId).append(this.allotDesc).append(this.allotBy).append(this.allotMode).append(this.allotStatus).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("allotHeaderId", this.allotHeaderId).append("allotNum", this.allotNum).append("allotTypeId", this.allotTypeId).append("allotDate", this.allotDate).append("sourceCheckUnit", this.sourceCheckUnit).append("storeCheckUnit", this.storeCheckUnit).append("archivesSiteId", this.archivesSiteId).append("allotDesc", this.allotDesc).append("allotBy", this.allotBy).append("allotMode", this.allotMode).append("allotStatus", this.allotStatus).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "allotHeaderId";
  }
  
  public Date getBeginDate()
  {
    return this.beginDate;
  }
  
  public void setBeginDate(Date paramDate)
  {
    this.beginDate = paramDate;
  }
  
  public Date getEndDate()
  {
    return this.endDate;
  }
  
  public void setEndDate(Date paramDate)
  {
    this.endDate = paramDate;
  }
  
  public String getAllotDateStr()
  {
    return this.allotDateStr;
  }
  
  public void setAllotDateStr(String paramString)
  {
    this.allotDateStr = paramString;
  }
  
  public BigInteger getReceiveBy()
  {
    return this.receiveBy;
  }
  
  public void setReceiveBy(BigInteger paramBigInteger)
  {
    this.receiveBy = paramBigInteger;
  }
  
  public Date getReceiveDate()
  {
    return this.receiveDate;
  }
  
  public void setReceiveDate(Date paramDate)
  {
    this.receiveDate = paramDate;
  }
  
  public BigInteger getReceiveTypeId()
  {
    return this.receiveTypeId;
  }
  
  public void setReceiveTypeId(BigInteger paramBigInteger)
  {
    this.receiveTypeId = paramBigInteger;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getReceiveByStr()
  {
    return this.receiveByStr;
  }
  
  public void setReceiveByStr(String paramString)
  {
    this.receiveByStr = paramString;
  }
  
  public String getStorageStr()
  {
    return this.storageStr;
  }
  
  public void setStorageStr(String paramString)
  {
    this.storageStr = paramString;
  }
  
  public String getCompanyStr()
  {
    return this.companyStr;
  }
  
  public void setCompanyStr(String paramString)
  {
    this.companyStr = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsAllotHeaders
 * JD-Core Version:    0.7.0.1
 */