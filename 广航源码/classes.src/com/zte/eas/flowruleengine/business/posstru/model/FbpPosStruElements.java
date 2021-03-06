package com.zte.eas.flowruleengine.business.posstru.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpPosStruElements
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected Long posStruElementId;
  protected String posStructureCode;
  protected Long positionId;
  protected Long parentPosStruElementId;
  protected String determiner;
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
  protected String enabledFlag;
  protected String memo;
  
  public FbpPosStruElements() {}
  
  public FbpPosStruElements(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, String paramString1, Long paramLong5, Long paramLong6, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setPosStruElementId(paramLong4);
    setPosStructureCode(paramString1);
    setPositionId(paramLong5);
    setParentPosStruElementId(paramLong6);
    setDeterminer(paramString2);
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
    setEnabledFlag(paramString14);
    setMemo(paramString15);
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
  
  public Long getPosStruElementId()
  {
    return this.posStruElementId;
  }
  
  public void setPosStruElementId(Long paramLong)
  {
    this.posStruElementId = paramLong;
  }
  
  public String getPosStructureCode()
  {
    return this.posStructureCode;
  }
  
  public void setPosStructureCode(String paramString)
  {
    this.posStructureCode = paramString;
  }
  
  public Long getPositionId()
  {
    return this.positionId;
  }
  
  public void setPositionId(Long paramLong)
  {
    this.positionId = paramLong;
  }
  
  public Long getParentPosStruElementId()
  {
    return this.parentPosStruElementId;
  }
  
  public void setParentPosStruElementId(Long paramLong)
  {
    this.parentPosStruElementId = paramLong;
  }
  
  public String getDeterminer()
  {
    return this.determiner;
  }
  
  public void setDeterminer(String paramString)
  {
    this.determiner = paramString;
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
    if (!(paramObject instanceof FbpPosStruElements)) {
      return false;
    }
    FbpPosStruElements localFbpPosStruElements = (FbpPosStruElements)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpPosStruElements.lastUpdateDate).append(this.lastUpdatedBy, localFbpPosStruElements.lastUpdatedBy).append(this.creationDate, localFbpPosStruElements.creationDate).append(this.createdBy, localFbpPosStruElements.createdBy).append(this.lastUpdateLogin, localFbpPosStruElements.lastUpdateLogin).append(this.posStruElementId, localFbpPosStruElements.posStruElementId).append(this.posStructureCode, localFbpPosStruElements.posStructureCode).append(this.positionId, localFbpPosStruElements.positionId).append(this.parentPosStruElementId, localFbpPosStruElements.parentPosStruElementId).append(this.determiner, localFbpPosStruElements.determiner).append(this.attributeCategory, localFbpPosStruElements.attributeCategory).append(this.attribute1, localFbpPosStruElements.attribute1).append(this.attribute2, localFbpPosStruElements.attribute2).append(this.attribute3, localFbpPosStruElements.attribute3).append(this.attribute4, localFbpPosStruElements.attribute4).append(this.attribute5, localFbpPosStruElements.attribute5).append(this.attribute6, localFbpPosStruElements.attribute6).append(this.attribute7, localFbpPosStruElements.attribute7).append(this.attribute8, localFbpPosStruElements.attribute8).append(this.attribute9, localFbpPosStruElements.attribute9).append(this.attribute10, localFbpPosStruElements.attribute10).append(this.enabledFlag, localFbpPosStruElements.enabledFlag).append(this.memo, localFbpPosStruElements.memo).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.posStruElementId).append(this.posStructureCode).append(this.positionId).append(this.parentPosStruElementId).append(this.determiner).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).append(this.memo).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("posStruElementId", this.posStruElementId).append("posStructureCode", this.posStructureCode).append("positionId", this.positionId).append("parentPosStruElementId", this.parentPosStruElementId).append("determiner", this.determiner).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).append("memo", this.memo).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "posStruElementId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElements
 * JD-Core Version:    0.7.0.1
 */