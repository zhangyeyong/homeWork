package com.zte.eas.organization.business.employeemanage.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpCreditAdjustmentsV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger adjustmentId;
  protected BigInteger entityId;
  protected BigInteger lastCredit;
  protected BigInteger adjustmentCredit;
  protected BigInteger latestCredit;
  protected BigInteger boeHeaderId;
  protected String boeNum;
  protected String employeeName;
  protected BigDecimal applyAmount;
  protected BigDecimal financeAuditAmount;
  protected String applyEmployeeName;
  protected Date boeDate;
  protected Date checkDate;
  protected String boeAbstract;
  protected String adjustEmployeeName;
  protected String adjustmentReason;
  protected String enabledFlag;
  protected String attributeCategory;
  protected String attribute1;
  protected String attribute2;
  protected String attribute3;
  protected String attribute4;
  protected String attribute5;
  protected String attribute6;
  protected String attribute7;
  protected String attribute8;
  protected String attribute9;
  protected String attribute10;
  protected String memo;
  
  public FbpCreditAdjustmentsV() {}
  
  public FbpCreditAdjustmentsV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5, BigInteger paramBigInteger6, String paramString1, String paramString2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, String paramString3, Date paramDate3, Date paramDate4, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setAdjustmentId(paramBigInteger1);
    setEntityId(paramBigInteger2);
    setLastCredit(paramBigInteger3);
    setAdjustmentCredit(paramBigInteger4);
    setLatestCredit(paramBigInteger5);
    setBoeHeaderId(paramBigInteger6);
    setBoeNum(paramString1);
    setEmployeeName(paramString2);
    setApplyAmount(paramBigDecimal1);
    setFinanceAuditAmount(paramBigDecimal2);
    setApplyEmployeeName(paramString3);
    setBoeDate(paramDate3);
    setCheckDate(paramDate4);
    setBoeAbstract(paramString4);
    setAdjustEmployeeName(paramString5);
    setAdjustmentReason(paramString6);
    setEnabledFlag(paramString7);
    setAttributeCategory(paramString8);
    setAttribute1(paramString9);
    setAttribute2(paramString10);
    setAttribute3(paramString11);
    setAttribute4(paramString12);
    setAttribute5(paramString13);
    setAttribute6(paramString14);
    setAttribute7(paramString15);
    setAttribute8(paramString16);
    setAttribute9(paramString17);
    setAttribute10(paramString18);
    setMemo(paramString19);
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
  
  public BigInteger getAdjustmentId()
  {
    return this.adjustmentId;
  }
  
  public void setAdjustmentId(BigInteger paramBigInteger)
  {
    this.adjustmentId = paramBigInteger;
  }
  
  public BigInteger getEntityId()
  {
    return this.entityId;
  }
  
  public void setEntityId(BigInteger paramBigInteger)
  {
    this.entityId = paramBigInteger;
  }
  
  public BigInteger getLastCredit()
  {
    return this.lastCredit;
  }
  
  public void setLastCredit(BigInteger paramBigInteger)
  {
    this.lastCredit = paramBigInteger;
  }
  
  public BigInteger getAdjustmentCredit()
  {
    return this.adjustmentCredit;
  }
  
  public void setAdjustmentCredit(BigInteger paramBigInteger)
  {
    this.adjustmentCredit = paramBigInteger;
  }
  
  public BigInteger getLatestCredit()
  {
    return this.latestCredit;
  }
  
  public void setLatestCredit(BigInteger paramBigInteger)
  {
    this.latestCredit = paramBigInteger;
  }
  
  public BigInteger getBoeHeaderId()
  {
    return this.boeHeaderId;
  }
  
  public void setBoeHeaderId(BigInteger paramBigInteger)
  {
    this.boeHeaderId = paramBigInteger;
  }
  
  public String getBoeNum()
  {
    return this.boeNum;
  }
  
  public void setBoeNum(String paramString)
  {
    this.boeNum = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public BigDecimal getApplyAmount()
  {
    return this.applyAmount;
  }
  
  public void setApplyAmount(BigDecimal paramBigDecimal)
  {
    this.applyAmount = paramBigDecimal;
  }
  
  public BigDecimal getFinanceAuditAmount()
  {
    return this.financeAuditAmount;
  }
  
  public void setFinanceAuditAmount(BigDecimal paramBigDecimal)
  {
    this.financeAuditAmount = paramBigDecimal;
  }
  
  public String getApplyEmployeeName()
  {
    return this.applyEmployeeName;
  }
  
  public void setApplyEmployeeName(String paramString)
  {
    this.applyEmployeeName = paramString;
  }
  
  public Date getBoeDate()
  {
    return this.boeDate;
  }
  
  public void setBoeDate(Date paramDate)
  {
    this.boeDate = paramDate;
  }
  
  public Date getCheckDate()
  {
    return this.checkDate;
  }
  
  public void setCheckDate(Date paramDate)
  {
    this.checkDate = paramDate;
  }
  
  public String getBoeAbstract()
  {
    return this.boeAbstract;
  }
  
  public void setBoeAbstract(String paramString)
  {
    this.boeAbstract = paramString;
  }
  
  public String getAdjustEmployeeName()
  {
    return this.adjustEmployeeName;
  }
  
  public void setAdjustEmployeeName(String paramString)
  {
    this.adjustEmployeeName = paramString;
  }
  
  public String getAdjustmentReason()
  {
    return this.adjustmentReason;
  }
  
  public void setAdjustmentReason(String paramString)
  {
    this.adjustmentReason = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getAttributeCategory()
  {
    return this.attributeCategory;
  }
  
  public void setAttributeCategory(String paramString)
  {
    this.attributeCategory = paramString;
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
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpCreditAdjustmentsV)) {
      return false;
    }
    FbpCreditAdjustmentsV localFbpCreditAdjustmentsV = (FbpCreditAdjustmentsV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpCreditAdjustmentsV.lastUpdateDate).append(this.lastUpdatedBy, localFbpCreditAdjustmentsV.lastUpdatedBy).append(this.creationDate, localFbpCreditAdjustmentsV.creationDate).append(this.createdBy, localFbpCreditAdjustmentsV.createdBy).append(this.lastUpdateLogin, localFbpCreditAdjustmentsV.lastUpdateLogin).append(this.adjustmentId, localFbpCreditAdjustmentsV.adjustmentId).append(this.entityId, localFbpCreditAdjustmentsV.entityId).append(this.lastCredit, localFbpCreditAdjustmentsV.lastCredit).append(this.adjustmentCredit, localFbpCreditAdjustmentsV.adjustmentCredit).append(this.latestCredit, localFbpCreditAdjustmentsV.latestCredit).append(this.boeHeaderId, localFbpCreditAdjustmentsV.boeHeaderId).append(this.boeNum, localFbpCreditAdjustmentsV.boeNum).append(this.employeeName, localFbpCreditAdjustmentsV.employeeName).append(this.applyAmount, localFbpCreditAdjustmentsV.applyAmount).append(this.financeAuditAmount, localFbpCreditAdjustmentsV.financeAuditAmount).append(this.applyEmployeeName, localFbpCreditAdjustmentsV.applyEmployeeName).append(this.boeDate, localFbpCreditAdjustmentsV.boeDate).append(this.checkDate, localFbpCreditAdjustmentsV.checkDate).append(this.boeAbstract, localFbpCreditAdjustmentsV.boeAbstract).append(this.adjustEmployeeName, localFbpCreditAdjustmentsV.adjustEmployeeName).append(this.adjustmentReason, localFbpCreditAdjustmentsV.adjustmentReason).append(this.enabledFlag, localFbpCreditAdjustmentsV.enabledFlag).append(this.attributeCategory, localFbpCreditAdjustmentsV.attributeCategory).append(this.attribute1, localFbpCreditAdjustmentsV.attribute1).append(this.attribute2, localFbpCreditAdjustmentsV.attribute2).append(this.attribute3, localFbpCreditAdjustmentsV.attribute3).append(this.attribute4, localFbpCreditAdjustmentsV.attribute4).append(this.attribute5, localFbpCreditAdjustmentsV.attribute5).append(this.attribute6, localFbpCreditAdjustmentsV.attribute6).append(this.attribute7, localFbpCreditAdjustmentsV.attribute7).append(this.attribute8, localFbpCreditAdjustmentsV.attribute8).append(this.attribute9, localFbpCreditAdjustmentsV.attribute9).append(this.attribute10, localFbpCreditAdjustmentsV.attribute10).append(this.memo, localFbpCreditAdjustmentsV.memo).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.adjustmentId).append(this.entityId).append(this.lastCredit).append(this.adjustmentCredit).append(this.latestCredit).append(this.boeHeaderId).append(this.boeNum).append(this.employeeName).append(this.applyAmount).append(this.financeAuditAmount).append(this.applyEmployeeName).append(this.boeDate).append(this.checkDate).append(this.boeAbstract).append(this.adjustEmployeeName).append(this.adjustmentReason).append(this.enabledFlag).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.memo).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("adjustmentId", this.adjustmentId).append("entityId", this.entityId).append("lastCredit", this.lastCredit).append("adjustmentCredit", this.adjustmentCredit).append("latestCredit", this.latestCredit).append("boeHeaderId", this.boeHeaderId).append("boeNum", this.boeNum).append("employeeName", this.employeeName).append("applyAmount", this.applyAmount).append("financeAuditAmount", this.financeAuditAmount).append("applyEmployeeName", this.applyEmployeeName).append("boeDate", this.boeDate).append("checkDate", this.checkDate).append("boeAbstract", this.boeAbstract).append("adjustEmployeeName", this.adjustEmployeeName).append("adjustmentReason", this.adjustmentReason).append("enabledFlag", this.enabledFlag).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("memo", this.memo).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpCreditAdjustmentsV
 * JD-Core Version:    0.7.0.1
 */