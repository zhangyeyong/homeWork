package com.zte.eas.resconfig.business.numberrule.model;

import com.zte.ssb.exportExcel.tableModel.selectModel;
import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpNumberRuleDetails
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected Long ruleDetailId;
  protected Long numberRuleId;
  protected Long lineNum;
  protected String ruleType;
  protected String ruleValue;
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
  protected String enabledFlag;
  protected selectModel ruleTypeSelect;
  
  public FbpNumberRuleDetails() {}
  
  public FbpNumberRuleDetails(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, Long paramLong5, Long paramLong6, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setRuleDetailId(paramLong4);
    setNumberRuleId(paramLong5);
    setLineNum(paramLong6);
    setRuleType(paramString1);
    setRuleValue(paramString2);
    setAttributeCategory(paramString3);
    setAttribute1(paramString4);
    setAttribute2(paramString5);
    setAttribute3(paramString6);
    setAttribute4(paramString7);
    setAttribute5(paramString8);
    setAttribute6(paramString9);
    setAttribute7(paramString10);
    setAttribute8(paramString11);
    setAttribute9(paramString12);
    setAttribute10(paramString13);
    setMemo(paramString14);
    setEnabledFlag(paramString15);
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
  
  public Long getRuleDetailId()
  {
    return this.ruleDetailId;
  }
  
  public void setRuleDetailId(Long paramLong)
  {
    this.ruleDetailId = paramLong;
  }
  
  public Long getNumberRuleId()
  {
    return this.numberRuleId;
  }
  
  public void setNumberRuleId(Long paramLong)
  {
    this.numberRuleId = paramLong;
  }
  
  public Long getLineNum()
  {
    return this.lineNum;
  }
  
  public void setLineNum(Long paramLong)
  {
    this.lineNum = paramLong;
  }
  
  public String getRuleType()
  {
    return this.ruleType;
  }
  
  public void setRuleType(String paramString)
  {
    this.ruleType = paramString;
  }
  
  public String getRuleValue()
  {
    return this.ruleValue;
  }
  
  public void setRuleValue(String paramString)
  {
    this.ruleValue = paramString;
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
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpNumberRuleDetails)) {
      return false;
    }
    FbpNumberRuleDetails localFbpNumberRuleDetails = (FbpNumberRuleDetails)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpNumberRuleDetails.lastUpdateDate).append(this.lastUpdatedBy, localFbpNumberRuleDetails.lastUpdatedBy).append(this.creationDate, localFbpNumberRuleDetails.creationDate).append(this.createdBy, localFbpNumberRuleDetails.createdBy).append(this.lastUpdateLogin, localFbpNumberRuleDetails.lastUpdateLogin).append(this.ruleDetailId, localFbpNumberRuleDetails.ruleDetailId).append(this.numberRuleId, localFbpNumberRuleDetails.numberRuleId).append(this.lineNum, localFbpNumberRuleDetails.lineNum).append(this.ruleType, localFbpNumberRuleDetails.ruleType).append(this.ruleValue, localFbpNumberRuleDetails.ruleValue).append(this.attributeCategory, localFbpNumberRuleDetails.attributeCategory).append(this.attribute1, localFbpNumberRuleDetails.attribute1).append(this.attribute2, localFbpNumberRuleDetails.attribute2).append(this.attribute3, localFbpNumberRuleDetails.attribute3).append(this.attribute4, localFbpNumberRuleDetails.attribute4).append(this.attribute5, localFbpNumberRuleDetails.attribute5).append(this.attribute6, localFbpNumberRuleDetails.attribute6).append(this.attribute7, localFbpNumberRuleDetails.attribute7).append(this.attribute8, localFbpNumberRuleDetails.attribute8).append(this.attribute9, localFbpNumberRuleDetails.attribute9).append(this.attribute10, localFbpNumberRuleDetails.attribute10).append(this.memo, localFbpNumberRuleDetails.memo).append(this.enabledFlag, localFbpNumberRuleDetails.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.ruleDetailId).append(this.numberRuleId).append(this.lineNum).append(this.ruleType).append(this.ruleValue).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.memo).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("ruleDetailId", this.ruleDetailId).append("numberRuleId", this.numberRuleId).append("lineNum", this.lineNum).append("ruleType", this.ruleType).append("ruleValue", this.ruleValue).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("memo", this.memo).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "ruleDetailId";
  }
  
  public selectModel getRuleTypeSelect()
  {
    return this.ruleTypeSelect;
  }
  
  public void setRuleTypeSelect(selectModel paramselectModel)
  {
    this.ruleTypeSelect = paramselectModel;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.numberrule.model.FbpNumberRuleDetails
 * JD-Core Version:    0.7.0.1
 */