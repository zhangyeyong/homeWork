package com.zte.eas.appframe.business.bulletinmanager.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpBulletinsDept
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected Long bulletinId;
  protected Long bulletinsDeptId;
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
  protected String enabledFlag;
  protected String memo;
  
  public FbpBulletinsDept() {}
  
  public FbpBulletinsDept(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, Long paramLong5, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setBulletinId(paramLong4);
    setBulletinsDeptId(paramLong5);
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
    setEnabledFlag(paramString11);
    setMemo(paramString12);
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
  
  public Long getBulletinId()
  {
    return this.bulletinId;
  }
  
  public void setBulletinId(Long paramLong)
  {
    this.bulletinId = paramLong;
  }
  
  public Long getBulletinsDeptId()
  {
    return this.bulletinsDeptId;
  }
  
  public void setBulletinsDeptId(Long paramLong)
  {
    this.bulletinsDeptId = paramLong;
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
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
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
    if (!(paramObject instanceof FbpBulletinsDept)) {
      return false;
    }
    FbpBulletinsDept localFbpBulletinsDept = (FbpBulletinsDept)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpBulletinsDept.lastUpdateDate).append(this.lastUpdatedBy, localFbpBulletinsDept.lastUpdatedBy).append(this.creationDate, localFbpBulletinsDept.creationDate).append(this.createdBy, localFbpBulletinsDept.createdBy).append(this.lastUpdateLogin, localFbpBulletinsDept.lastUpdateLogin).append(this.bulletinId, localFbpBulletinsDept.bulletinId).append(this.bulletinsDeptId, localFbpBulletinsDept.bulletinsDeptId).append(this.attribute1, localFbpBulletinsDept.attribute1).append(this.attribute2, localFbpBulletinsDept.attribute2).append(this.attribute3, localFbpBulletinsDept.attribute3).append(this.attribute4, localFbpBulletinsDept.attribute4).append(this.attribute5, localFbpBulletinsDept.attribute5).append(this.attribute6, localFbpBulletinsDept.attribute6).append(this.attribute7, localFbpBulletinsDept.attribute7).append(this.attribute8, localFbpBulletinsDept.attribute8).append(this.attribute9, localFbpBulletinsDept.attribute9).append(this.attribute10, localFbpBulletinsDept.attribute10).append(this.enabledFlag, localFbpBulletinsDept.enabledFlag).append(this.memo, localFbpBulletinsDept.memo).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.bulletinId).append(this.bulletinsDeptId).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).append(this.memo).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("bulletinId", this.bulletinId).append("bulletinsDeptId", this.bulletinsDeptId).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).append("memo", this.memo).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "bulletinsDeptId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsDept
 * JD-Core Version:    0.7.0.1
 */