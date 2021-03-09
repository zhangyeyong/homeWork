package com.zte.eas.resconfig.business.periods.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpPeriods
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected BigInteger lastUpdatedBy;
  protected Date creationDate;
  protected BigInteger createdBy;
  protected BigInteger lastUpdateLogin;
  protected String periodSetName;
  protected String periodName;
  protected Date startDate;
  protected Date endDate;
  protected Date yearStartDate;
  protected Date quarterStartDate;
  protected String periodType;
  protected BigInteger periodYear;
  protected BigInteger periodNum;
  protected BigInteger quarterNum;
  protected String enteredPeriodName;
  protected String adjustmentPeriodFlag;
  protected String description;
  protected String closingStatus;
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
  
  public FbpPeriods() {}
  
  public FbpPeriods(Date paramDate1, BigInteger paramBigInteger1, Date paramDate2, BigInteger paramBigInteger2, BigInteger paramBigInteger3, String paramString1, String paramString2, Date paramDate3, Date paramDate4, Date paramDate5, Date paramDate6, String paramString3, BigInteger paramBigInteger4, BigInteger paramBigInteger5, BigInteger paramBigInteger6, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramBigInteger1);
    setCreationDate(paramDate2);
    setCreatedBy(paramBigInteger2);
    setLastUpdateLogin(paramBigInteger3);
    setPeriodSetName(paramString1);
    setPeriodName(paramString2);
    setStartDate(paramDate3);
    setEndDate(paramDate4);
    setYearStartDate(paramDate5);
    setQuarterStartDate(paramDate6);
    setPeriodType(paramString3);
    setPeriodYear(paramBigInteger4);
    setPeriodNum(paramBigInteger5);
    setQuarterNum(paramBigInteger6);
    setEnteredPeriodName(paramString4);
    setAdjustmentPeriodFlag(paramString5);
    setDescription(paramString6);
    setClosingStatus(paramString7);
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
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public BigInteger getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(BigInteger paramBigInteger)
  {
    this.lastUpdatedBy = paramBigInteger;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public BigInteger getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(BigInteger paramBigInteger)
  {
    this.createdBy = paramBigInteger;
  }
  
  public BigInteger getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(BigInteger paramBigInteger)
  {
    this.lastUpdateLogin = paramBigInteger;
  }
  
  public String getPeriodSetName()
  {
    return this.periodSetName;
  }
  
  public void setPeriodSetName(String paramString)
  {
    this.periodSetName = paramString;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public Date getStartDate()
  {
    return this.startDate;
  }
  
  public void setStartDate(Date paramDate)
  {
    this.startDate = paramDate;
  }
  
  public Date getEndDate()
  {
    return this.endDate;
  }
  
  public void setEndDate(Date paramDate)
  {
    this.endDate = paramDate;
  }
  
  public Date getYearStartDate()
  {
    return this.yearStartDate;
  }
  
  public void setYearStartDate(Date paramDate)
  {
    this.yearStartDate = paramDate;
  }
  
  public Date getQuarterStartDate()
  {
    return this.quarterStartDate;
  }
  
  public void setQuarterStartDate(Date paramDate)
  {
    this.quarterStartDate = paramDate;
  }
  
  public String getPeriodType()
  {
    return this.periodType;
  }
  
  public void setPeriodType(String paramString)
  {
    this.periodType = paramString;
  }
  
  public BigInteger getPeriodYear()
  {
    return this.periodYear;
  }
  
  public void setPeriodYear(BigInteger paramBigInteger)
  {
    this.periodYear = paramBigInteger;
  }
  
  public BigInteger getPeriodNum()
  {
    return this.periodNum;
  }
  
  public void setPeriodNum(BigInteger paramBigInteger)
  {
    this.periodNum = paramBigInteger;
  }
  
  public BigInteger getQuarterNum()
  {
    return this.quarterNum;
  }
  
  public void setQuarterNum(BigInteger paramBigInteger)
  {
    this.quarterNum = paramBigInteger;
  }
  
  public String getEnteredPeriodName()
  {
    return this.enteredPeriodName;
  }
  
  public void setEnteredPeriodName(String paramString)
  {
    this.enteredPeriodName = paramString;
  }
  
  public String getAdjustmentPeriodFlag()
  {
    return this.adjustmentPeriodFlag;
  }
  
  public void setAdjustmentPeriodFlag(String paramString)
  {
    this.adjustmentPeriodFlag = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public String getClosingStatus()
  {
    return this.closingStatus;
  }
  
  public void setClosingStatus(String paramString)
  {
    this.closingStatus = paramString;
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
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpPeriods)) {
      return false;
    }
    FbpPeriods localFbpPeriods = (FbpPeriods)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpPeriods.lastUpdateDate).append(this.lastUpdatedBy, localFbpPeriods.lastUpdatedBy).append(this.creationDate, localFbpPeriods.creationDate).append(this.createdBy, localFbpPeriods.createdBy).append(this.lastUpdateLogin, localFbpPeriods.lastUpdateLogin).append(this.periodSetName, localFbpPeriods.periodSetName).append(this.periodName, localFbpPeriods.periodName).append(this.startDate, localFbpPeriods.startDate).append(this.endDate, localFbpPeriods.endDate).append(this.yearStartDate, localFbpPeriods.yearStartDate).append(this.quarterStartDate, localFbpPeriods.quarterStartDate).append(this.periodType, localFbpPeriods.periodType).append(this.periodYear, localFbpPeriods.periodYear).append(this.periodNum, localFbpPeriods.periodNum).append(this.quarterNum, localFbpPeriods.quarterNum).append(this.enteredPeriodName, localFbpPeriods.enteredPeriodName).append(this.adjustmentPeriodFlag, localFbpPeriods.adjustmentPeriodFlag).append(this.description, localFbpPeriods.description).append(this.closingStatus, localFbpPeriods.closingStatus).append(this.attributeCategory, localFbpPeriods.attributeCategory).append(this.attribute1, localFbpPeriods.attribute1).append(this.attribute2, localFbpPeriods.attribute2).append(this.attribute3, localFbpPeriods.attribute3).append(this.attribute4, localFbpPeriods.attribute4).append(this.attribute5, localFbpPeriods.attribute5).append(this.attribute6, localFbpPeriods.attribute6).append(this.attribute7, localFbpPeriods.attribute7).append(this.attribute8, localFbpPeriods.attribute8).append(this.attribute9, localFbpPeriods.attribute9).append(this.attribute10, localFbpPeriods.attribute10).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.periodSetName).append(this.periodName).append(this.startDate).append(this.endDate).append(this.yearStartDate).append(this.quarterStartDate).append(this.periodType).append(this.periodYear).append(this.periodNum).append(this.quarterNum).append(this.enteredPeriodName).append(this.adjustmentPeriodFlag).append(this.description).append(this.closingStatus).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("periodSetName", this.periodSetName).append("periodName", this.periodName).append("startDate", this.startDate).append("endDate", this.endDate).append("yearStartDate", this.yearStartDate).append("quarterStartDate", this.quarterStartDate).append("periodType", this.periodType).append("periodYear", this.periodYear).append("periodNum", this.periodNum).append("quarterNum", this.quarterNum).append("enteredPeriodName", this.enteredPeriodName).append("adjustmentPeriodFlag", this.adjustmentPeriodFlag).append("description", this.description).append("closingStatus", this.closingStatus).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.periods.model.FbpPeriods
 * JD-Core Version:    0.7.0.1
 */