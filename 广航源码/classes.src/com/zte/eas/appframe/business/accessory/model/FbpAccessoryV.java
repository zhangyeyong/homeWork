package com.zte.eas.appframe.business.accessory.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpAccessoryV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
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
  protected BigInteger accessoryId;
  protected String accessoryType;
  protected BigInteger relationId;
  protected String accessoryTitle;
  protected String accessoryFileName;
  protected String extendedName;
  protected BigInteger accessorySize;
  protected String accessoryOldFileName;
  protected String accessoryActualPath;
  protected BigInteger employeeId;
  protected String employeeName;
  protected String upload;
  
  public String getUpload()
  {
    return this.upload;
  }
  
  public void setUpload(String paramString)
  {
    this.upload = paramString;
  }
  
  public FbpAccessoryV() {}
  
  public FbpAccessoryV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, BigInteger paramBigInteger1, String paramString13, BigInteger paramBigInteger2, String paramString14, String paramString15, String paramString16, BigInteger paramBigInteger3, String paramString17, String paramString18, BigInteger paramBigInteger4, String paramString19)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setAttribute1(paramString1);
    setAttribute2(paramString2);
    setAttribute3(paramString3);
    setAttribute4(paramString4);
    setAttribute5(paramString5);
    setAttribute6(paramString6);
    setAttribute7(paramString7);
    setAttribute8(paramString8);
    setAttribute9(paramString9);
    setAttribute10(paramString10);
    setMemo(paramString11);
    setEnabledFlag(paramString12);
    setAccessoryId(paramBigInteger1);
    setAccessoryType(paramString13);
    setRelationId(paramBigInteger2);
    setAccessoryTitle(paramString14);
    setAccessoryFileName(paramString15);
    setExtendedName(paramString16);
    setAccessorySize(paramBigInteger3);
    setAccessoryOldFileName(paramString17);
    setAccessoryActualPath(paramString18);
    setEmployeeId(paramBigInteger4);
    setEmployeeName(paramString19);
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
  
  public String getAccessoryActualPath()
  {
    return this.accessoryActualPath;
  }
  
  public void setAccessoryActualPath(String paramString)
  {
    this.accessoryActualPath = paramString;
  }
  
  public BigInteger getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(BigInteger paramBigInteger)
  {
    this.employeeId = paramBigInteger;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpAccessoryV)) {
      return false;
    }
    FbpAccessoryV localFbpAccessoryV = (FbpAccessoryV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpAccessoryV.lastUpdateDate).append(this.lastUpdatedBy, localFbpAccessoryV.lastUpdatedBy).append(this.creationDate, localFbpAccessoryV.creationDate).append(this.createdBy, localFbpAccessoryV.createdBy).append(this.lastUpdateLogin, localFbpAccessoryV.lastUpdateLogin).append(this.attribute1, localFbpAccessoryV.attribute1).append(this.attribute2, localFbpAccessoryV.attribute2).append(this.attribute3, localFbpAccessoryV.attribute3).append(this.attribute4, localFbpAccessoryV.attribute4).append(this.attribute5, localFbpAccessoryV.attribute5).append(this.attribute6, localFbpAccessoryV.attribute6).append(this.attribute7, localFbpAccessoryV.attribute7).append(this.attribute8, localFbpAccessoryV.attribute8).append(this.attribute9, localFbpAccessoryV.attribute9).append(this.attribute10, localFbpAccessoryV.attribute10).append(this.memo, localFbpAccessoryV.memo).append(this.enabledFlag, localFbpAccessoryV.enabledFlag).append(this.accessoryId, localFbpAccessoryV.accessoryId).append(this.accessoryType, localFbpAccessoryV.accessoryType).append(this.relationId, localFbpAccessoryV.relationId).append(this.accessoryTitle, localFbpAccessoryV.accessoryTitle).append(this.accessoryFileName, localFbpAccessoryV.accessoryFileName).append(this.extendedName, localFbpAccessoryV.extendedName).append(this.accessorySize, localFbpAccessoryV.accessorySize).append(this.accessoryOldFileName, localFbpAccessoryV.accessoryOldFileName).append(this.accessoryActualPath, localFbpAccessoryV.accessoryActualPath).append(this.employeeId, localFbpAccessoryV.employeeId).append(this.employeeName, localFbpAccessoryV.employeeName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.memo).append(this.enabledFlag).append(this.accessoryId).append(this.accessoryType).append(this.relationId).append(this.accessoryTitle).append(this.accessoryFileName).append(this.extendedName).append(this.accessorySize).append(this.accessoryOldFileName).append(this.accessoryActualPath).append(this.employeeId).append(this.employeeName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("memo", this.memo).append("enabledFlag", this.enabledFlag).append("accessoryId", this.accessoryId).append("accessoryType", this.accessoryType).append("relationId", this.relationId).append("accessoryTitle", this.accessoryTitle).append("accessoryFileName", this.accessoryFileName).append("extendedName", this.extendedName).append("accessorySize", this.accessorySize).append("accessoryOldFileName", this.accessoryOldFileName).append("accessoryActualPath", this.accessoryActualPath).append("employeeId", this.employeeId).append("employeeName", this.employeeName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.accessory.model.FbpAccessoryV
 * JD-Core Version:    0.7.0.1
 */