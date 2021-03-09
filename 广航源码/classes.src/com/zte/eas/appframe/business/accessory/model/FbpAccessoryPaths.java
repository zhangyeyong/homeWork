package com.zte.eas.appframe.business.accessory.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpAccessoryPaths
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected BigInteger accessoryPathId;
  protected String accessoryActualPath;
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
  
  public FbpAccessoryPaths() {}
  
  public FbpAccessoryPaths(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, BigInteger paramBigInteger, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setAccessoryPathId(paramBigInteger);
    setAccessoryActualPath(paramString1);
    setAttribute1(paramString2);
    setAttribute2(paramString3);
    setAttribute3(paramString4);
    setAttribute4(paramString5);
    setAttribute5(paramString6);
    setAttribute6(paramString7);
    setAttribute7(paramString8);
    setAttribute8(paramString9);
    setAttribute9(paramString10);
    setAttribute10(paramString11);
    setMemo(paramString12);
    setEnabledFlag(paramString13);
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
  
  public BigInteger getAccessoryPathId()
  {
    return this.accessoryPathId;
  }
  
  public void setAccessoryPathId(BigInteger paramBigInteger)
  {
    this.accessoryPathId = paramBigInteger;
  }
  
  public String getAccessoryActualPath()
  {
    return this.accessoryActualPath;
  }
  
  public void setAccessoryActualPath(String paramString)
  {
    this.accessoryActualPath = paramString;
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
    if (!(paramObject instanceof FbpAccessoryPaths)) {
      return false;
    }
    FbpAccessoryPaths localFbpAccessoryPaths = (FbpAccessoryPaths)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpAccessoryPaths.lastUpdateDate).append(this.lastUpdatedBy, localFbpAccessoryPaths.lastUpdatedBy).append(this.creationDate, localFbpAccessoryPaths.creationDate).append(this.createdBy, localFbpAccessoryPaths.createdBy).append(this.lastUpdateLogin, localFbpAccessoryPaths.lastUpdateLogin).append(this.accessoryPathId, localFbpAccessoryPaths.accessoryPathId).append(this.accessoryActualPath, localFbpAccessoryPaths.accessoryActualPath).append(this.attribute1, localFbpAccessoryPaths.attribute1).append(this.attribute2, localFbpAccessoryPaths.attribute2).append(this.attribute3, localFbpAccessoryPaths.attribute3).append(this.attribute4, localFbpAccessoryPaths.attribute4).append(this.attribute5, localFbpAccessoryPaths.attribute5).append(this.attribute6, localFbpAccessoryPaths.attribute6).append(this.attribute7, localFbpAccessoryPaths.attribute7).append(this.attribute8, localFbpAccessoryPaths.attribute8).append(this.attribute9, localFbpAccessoryPaths.attribute9).append(this.attribute10, localFbpAccessoryPaths.attribute10).append(this.memo, localFbpAccessoryPaths.memo).append(this.enabledFlag, localFbpAccessoryPaths.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.accessoryPathId).append(this.accessoryActualPath).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.memo).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("accessoryPathId", this.accessoryPathId).append("accessoryActualPath", this.accessoryActualPath).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("memo", this.memo).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "accessoryPathId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.accessory.model.FbpAccessoryPaths
 * JD-Core Version:    0.7.0.1
 */