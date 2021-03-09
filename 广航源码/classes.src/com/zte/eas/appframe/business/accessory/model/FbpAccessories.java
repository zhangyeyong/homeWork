package com.zte.eas.appframe.business.accessory.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpAccessories
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger accessoryId;
  protected String accessoryType;
  protected BigInteger relationId;
  protected String accessoryTitle;
  protected BigInteger accessoryPathId;
  protected String accessoryFileName;
  protected String extendedName;
  protected BigInteger accessorySize;
  protected String accessoryOldFileName;
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
  
  public FbpAccessories() {}
  
  public FbpAccessories(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger1, String paramString1, BigInteger paramBigInteger2, String paramString2, BigInteger paramBigInteger3, String paramString3, String paramString4, BigInteger paramBigInteger4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setAccessoryId(paramBigInteger1);
    setAccessoryType(paramString1);
    setRelationId(paramBigInteger2);
    setAccessoryTitle(paramString2);
    setAccessoryPathId(paramBigInteger3);
    setAccessoryFileName(paramString3);
    setExtendedName(paramString4);
    setAccessorySize(paramBigInteger4);
    setAccessoryOldFileName(paramString5);
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
    setEnabledFlag(paramString17);
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
  
  public BigInteger getAccessoryId()
  {
    return this.accessoryId;
  }
  
  public void setAccessoryId(BigInteger paramBigInteger)
  {
    this.accessoryId = paramBigInteger;
  }
  
  public String getAccessoryType()
  {
    return this.accessoryType;
  }
  
  public void setAccessoryType(String paramString)
  {
    this.accessoryType = paramString;
  }
  
  public BigInteger getRelationId()
  {
    return this.relationId;
  }
  
  public void setRelationId(BigInteger paramBigInteger)
  {
    this.relationId = paramBigInteger;
  }
  
  public String getAccessoryTitle()
  {
    return this.accessoryTitle;
  }
  
  public void setAccessoryTitle(String paramString)
  {
    this.accessoryTitle = paramString;
  }
  
  public BigInteger getAccessoryPathId()
  {
    return this.accessoryPathId;
  }
  
  public void setAccessoryPathId(BigInteger paramBigInteger)
  {
    this.accessoryPathId = paramBigInteger;
  }
  
  public String getAccessoryFileName()
  {
    return this.accessoryFileName;
  }
  
  public void setAccessoryFileName(String paramString)
  {
    this.accessoryFileName = paramString;
  }
  
  public String getExtendedName()
  {
    return this.extendedName;
  }
  
  public void setExtendedName(String paramString)
  {
    this.extendedName = paramString;
  }
  
  public BigInteger getAccessorySize()
  {
    return this.accessorySize;
  }
  
  public void setAccessorySize(BigInteger paramBigInteger)
  {
    this.accessorySize = paramBigInteger;
  }
  
  public String getAccessoryOldFileName()
  {
    return this.accessoryOldFileName;
  }
  
  public void setAccessoryOldFileName(String paramString)
  {
    this.accessoryOldFileName = paramString;
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
    if (!(paramObject instanceof FbpAccessories)) {
      return false;
    }
    FbpAccessories localFbpAccessories = (FbpAccessories)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpAccessories.lastUpdateDate).append(this.lastUpdatedBy, localFbpAccessories.lastUpdatedBy).append(this.creationDate, localFbpAccessories.creationDate).append(this.createdBy, localFbpAccessories.createdBy).append(this.lastUpdateLogin, localFbpAccessories.lastUpdateLogin).append(this.accessoryId, localFbpAccessories.accessoryId).append(this.accessoryType, localFbpAccessories.accessoryType).append(this.relationId, localFbpAccessories.relationId).append(this.accessoryTitle, localFbpAccessories.accessoryTitle).append(this.accessoryPathId, localFbpAccessories.accessoryPathId).append(this.accessoryFileName, localFbpAccessories.accessoryFileName).append(this.extendedName, localFbpAccessories.extendedName).append(this.accessorySize, localFbpAccessories.accessorySize).append(this.accessoryOldFileName, localFbpAccessories.accessoryOldFileName).append(this.attribute1, localFbpAccessories.attribute1).append(this.attribute2, localFbpAccessories.attribute2).append(this.attribute3, localFbpAccessories.attribute3).append(this.attribute4, localFbpAccessories.attribute4).append(this.attribute5, localFbpAccessories.attribute5).append(this.attribute6, localFbpAccessories.attribute6).append(this.attribute7, localFbpAccessories.attribute7).append(this.attribute8, localFbpAccessories.attribute8).append(this.attribute9, localFbpAccessories.attribute9).append(this.attribute10, localFbpAccessories.attribute10).append(this.memo, localFbpAccessories.memo).append(this.enabledFlag, localFbpAccessories.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.accessoryId).append(this.accessoryType).append(this.relationId).append(this.accessoryTitle).append(this.accessoryPathId).append(this.accessoryFileName).append(this.extendedName).append(this.accessorySize).append(this.accessoryOldFileName).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.memo).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("accessoryId", this.accessoryId).append("accessoryType", this.accessoryType).append("relationId", this.relationId).append("accessoryTitle", this.accessoryTitle).append("accessoryPathId", this.accessoryPathId).append("accessoryFileName", this.accessoryFileName).append("extendedName", this.extendedName).append("accessorySize", this.accessorySize).append("accessoryOldFileName", this.accessoryOldFileName).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("memo", this.memo).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "accessoryId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.accessory.model.FbpAccessories
 * JD-Core Version:    0.7.0.1
 */