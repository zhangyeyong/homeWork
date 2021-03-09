package com.zte.eas.resconfig.business.numberrule.model;

import com.zte.ssb.exportExcel.tableModel.selectModel;
import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpNumberRulesV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected Long numberRuleId;
  protected String numberRuleCode;
  protected String numberRuleName;
  protected String boeClassCode;
  protected Date startDate;
  protected Date endDate;
  protected String connectChar;
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
  protected String usedFlag;
  protected String meaning;
  protected String enabledFlag;
  protected String enabledFlagMeaning;
  protected selectModel ruleTypeSelect;
  
  public FbpNumberRulesV() {}
  
  public FbpNumberRulesV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, String paramString1, String paramString2, String paramString3, Date paramDate3, Date paramDate4, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setNumberRuleId(paramLong4);
    setNumberRuleCode(paramString1);
    setNumberRuleName(paramString2);
    setBoeClassCode(paramString3);
    setStartDate(paramDate3);
    setEndDate(paramDate4);
    setConnectChar(paramString4);
    setAttributeCategory(paramString5);
    setAttribute1(paramString6);
    setAttribute2(paramString7);
    setAttribute3(paramString8);
    setAttribute4(paramString9);
    setAttribute5(paramString10);
    setAttribute6(paramString11);
    setAttribute7(paramString12);
    setAttribute8(paramString13);
    setAttribute9(paramString14);
    setAttribute10(paramString15);
    setMemo(paramString16);
    setUsedFlag(paramString17);
    setMeaning(paramString18);
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
  
  public Long getNumberRuleId()
  {
    return this.numberRuleId;
  }
  
  public void setNumberRuleId(Long paramLong)
  {
    this.numberRuleId = paramLong;
  }
  
  public String getNumberRuleCode()
  {
    return this.numberRuleCode;
  }
  
  public void setNumberRuleCode(String paramString)
  {
    this.numberRuleCode = paramString;
  }
  
  public String getNumberRuleName()
  {
    return this.numberRuleName;
  }
  
  public void setNumberRuleName(String paramString)
  {
    this.numberRuleName = paramString;
  }
  
  public String getBoeClassCode()
  {
    return this.boeClassCode;
  }
  
  public void setBoeClassCode(String paramString)
  {
    this.boeClassCode = paramString;
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
  
  public String getConnectChar()
  {
    return this.connectChar;
  }
  
  public void setConnectChar(String paramString)
  {
    this.connectChar = paramString;
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
  
  public String getUsedFlag()
  {
    return this.usedFlag;
  }
  
  public void setUsedFlag(String paramString)
  {
    this.usedFlag = paramString;
  }
  
  public String getMeaning()
  {
    return this.meaning;
  }
  
  public void setMeaning(String paramString)
  {
    this.meaning = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpNumberRulesV)) {
      return false;
    }
    FbpNumberRulesV localFbpNumberRulesV = (FbpNumberRulesV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpNumberRulesV.lastUpdateDate).append(this.lastUpdatedBy, localFbpNumberRulesV.lastUpdatedBy).append(this.creationDate, localFbpNumberRulesV.creationDate).append(this.createdBy, localFbpNumberRulesV.createdBy).append(this.lastUpdateLogin, localFbpNumberRulesV.lastUpdateLogin).append(this.numberRuleId, localFbpNumberRulesV.numberRuleId).append(this.numberRuleCode, localFbpNumberRulesV.numberRuleCode).append(this.numberRuleName, localFbpNumberRulesV.numberRuleName).append(this.boeClassCode, localFbpNumberRulesV.boeClassCode).append(this.startDate, localFbpNumberRulesV.startDate).append(this.endDate, localFbpNumberRulesV.endDate).append(this.connectChar, localFbpNumberRulesV.connectChar).append(this.attributeCategory, localFbpNumberRulesV.attributeCategory).append(this.attribute1, localFbpNumberRulesV.attribute1).append(this.attribute2, localFbpNumberRulesV.attribute2).append(this.attribute3, localFbpNumberRulesV.attribute3).append(this.attribute4, localFbpNumberRulesV.attribute4).append(this.attribute5, localFbpNumberRulesV.attribute5).append(this.attribute6, localFbpNumberRulesV.attribute6).append(this.attribute7, localFbpNumberRulesV.attribute7).append(this.attribute8, localFbpNumberRulesV.attribute8).append(this.attribute9, localFbpNumberRulesV.attribute9).append(this.attribute10, localFbpNumberRulesV.attribute10).append(this.memo, localFbpNumberRulesV.memo).append(this.usedFlag, localFbpNumberRulesV.usedFlag).append(this.meaning, localFbpNumberRulesV.meaning).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.numberRuleId).append(this.numberRuleCode).append(this.numberRuleName).append(this.boeClassCode).append(this.startDate).append(this.endDate).append(this.connectChar).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.memo).append(this.usedFlag).append(this.meaning).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("numberRuleId", this.numberRuleId).append("numberRuleCode", this.numberRuleCode).append("numberRuleName", this.numberRuleName).append("boeClassCode", this.boeClassCode).append("startDate", this.startDate).append("endDate", this.endDate).append("connectChar", this.connectChar).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("memo", this.memo).append("usedFlag", this.usedFlag).append("meaning", this.meaning).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public selectModel getRuleTypeSelect()
  {
    return this.ruleTypeSelect;
  }
  
  public void setRuleTypeSelect(selectModel paramselectModel)
  {
    this.ruleTypeSelect = paramselectModel;
  }
  
  public String getEnabledFlagMeaning()
  {
    return this.enabledFlagMeaning;
  }
  
  public void setEnabledFlagMeaning(String paramString)
  {
    this.enabledFlagMeaning = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.numberrule.model.FbpNumberRulesV
 * JD-Core Version:    0.7.0.1
 */