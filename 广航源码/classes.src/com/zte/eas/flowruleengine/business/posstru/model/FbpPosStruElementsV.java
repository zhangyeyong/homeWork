package com.zte.eas.flowruleengine.business.posstru.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpPosStruElementsV
  extends BaseObject
  implements Serializable
{
  protected String rowId;
  protected Long posStruElementId;
  protected String posStruElementName;
  protected Long positionId;
  protected String positionName;
  protected String meaning;
  protected String posStructureCode;
  protected Long parentPosStruElementId;
  protected String parentPosStruElementName;
  protected String determiner;
  protected String determinerName;
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
  protected BigInteger childrenStruCount;
  
  public FbpPosStruElementsV() {}
  
  public FbpPosStruElementsV(String paramString1, Long paramLong1, String paramString2, Long paramLong2, String paramString3, String paramString4, String paramString5, Long paramLong3, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, BigInteger paramBigInteger)
  {
    setRowId(paramString1);
    setPosStruElementId(paramLong1);
    setPosStruElementName(paramString2);
    setPositionId(paramLong2);
    setPositionName(paramString3);
    setMeaning(paramString4);
    setPosStructureCode(paramString5);
    setParentPosStruElementId(paramLong3);
    setParentPosStruElementName(paramString6);
    setDeterminer(paramString7);
    setDeterminerName(paramString8);
    setAttributeCategory(paramString9);
    setAttribute1(paramString10);
    setAttribute2(paramString11);
    setAttribute3(paramString12);
    setAttribute4(paramString13);
    setAttribute5(paramString14);
    setAttribute6(paramString15);
    setAttribute7(paramString16);
    setAttribute8(paramString17);
    setAttribute9(paramString18);
    setAttribute10(paramString19);
    setEnabledFlag(paramString20);
    setMemo(paramString21);
    setChildrenStruCount(paramBigInteger);
  }
  
  public String getRowId()
  {
    return this.rowId;
  }
  
  public void setRowId(String paramString)
  {
    this.rowId = paramString;
  }
  
  public Long getPosStruElementId()
  {
    return this.posStruElementId;
  }
  
  public void setPosStruElementId(Long paramLong)
  {
    this.posStruElementId = paramLong;
  }
  
  public String getPosStruElementName()
  {
    return this.posStruElementName;
  }
  
  public void setPosStruElementName(String paramString)
  {
    this.posStruElementName = paramString;
  }
  
  public Long getPositionId()
  {
    return this.positionId;
  }
  
  public void setPositionId(Long paramLong)
  {
    this.positionId = paramLong;
  }
  
  public String getPositionName()
  {
    return this.positionName;
  }
  
  public void setPositionName(String paramString)
  {
    this.positionName = paramString;
  }
  
  public String getMeaning()
  {
    return this.meaning;
  }
  
  public void setMeaning(String paramString)
  {
    this.meaning = paramString;
  }
  
  public String getPosStructureCode()
  {
    return this.posStructureCode;
  }
  
  public void setPosStructureCode(String paramString)
  {
    this.posStructureCode = paramString;
  }
  
  public Long getParentPosStruElementId()
  {
    return this.parentPosStruElementId;
  }
  
  public void setParentPosStruElementId(Long paramLong)
  {
    this.parentPosStruElementId = paramLong;
  }
  
  public String getParentPosStruElementName()
  {
    return this.parentPosStruElementName;
  }
  
  public void setParentPosStruElementName(String paramString)
  {
    this.parentPosStruElementName = paramString;
  }
  
  public String getDeterminer()
  {
    return this.determiner;
  }
  
  public void setDeterminer(String paramString)
  {
    this.determiner = paramString;
  }
  
  public String getDeterminerName()
  {
    return this.determinerName;
  }
  
  public void setDeterminerName(String paramString)
  {
    this.determinerName = paramString;
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
  
  public BigInteger getChildrenStruCount()
  {
    return this.childrenStruCount;
  }
  
  public void setChildrenStruCount(BigInteger paramBigInteger)
  {
    this.childrenStruCount = paramBigInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpPosStruElementsV)) {
      return false;
    }
    FbpPosStruElementsV localFbpPosStruElementsV = (FbpPosStruElementsV)paramObject;
    return new EqualsBuilder().append(this.rowId, localFbpPosStruElementsV.rowId).append(this.posStruElementId, localFbpPosStruElementsV.posStruElementId).append(this.posStruElementName, localFbpPosStruElementsV.posStruElementName).append(this.positionId, localFbpPosStruElementsV.positionId).append(this.positionName, localFbpPosStruElementsV.positionName).append(this.meaning, localFbpPosStruElementsV.meaning).append(this.posStructureCode, localFbpPosStruElementsV.posStructureCode).append(this.parentPosStruElementId, localFbpPosStruElementsV.parentPosStruElementId).append(this.parentPosStruElementName, localFbpPosStruElementsV.parentPosStruElementName).append(this.determiner, localFbpPosStruElementsV.determiner).append(this.determinerName, localFbpPosStruElementsV.determinerName).append(this.attributeCategory, localFbpPosStruElementsV.attributeCategory).append(this.attribute1, localFbpPosStruElementsV.attribute1).append(this.attribute2, localFbpPosStruElementsV.attribute2).append(this.attribute3, localFbpPosStruElementsV.attribute3).append(this.attribute4, localFbpPosStruElementsV.attribute4).append(this.attribute5, localFbpPosStruElementsV.attribute5).append(this.attribute6, localFbpPosStruElementsV.attribute6).append(this.attribute7, localFbpPosStruElementsV.attribute7).append(this.attribute8, localFbpPosStruElementsV.attribute8).append(this.attribute9, localFbpPosStruElementsV.attribute9).append(this.attribute10, localFbpPosStruElementsV.attribute10).append(this.enabledFlag, localFbpPosStruElementsV.enabledFlag).append(this.memo, localFbpPosStruElementsV.memo).append(this.childrenStruCount, localFbpPosStruElementsV.childrenStruCount).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.rowId).append(this.posStruElementId).append(this.posStruElementName).append(this.positionId).append(this.positionName).append(this.meaning).append(this.posStructureCode).append(this.parentPosStruElementId).append(this.parentPosStruElementName).append(this.determiner).append(this.determinerName).append(this.attributeCategory).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).append(this.memo).append(this.childrenStruCount).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("rowId", this.rowId).append("posStruElementId", this.posStruElementId).append("posStruElementName", this.posStruElementName).append("positionId", this.positionId).append("positionName", this.positionName).append("meaning", this.meaning).append("posStructureCode", this.posStructureCode).append("parentPosStruElementId", this.parentPosStruElementId).append("parentPosStruElementName", this.parentPosStruElementName).append("determiner", this.determiner).append("determinerName", this.determinerName).append("attributeCategory", this.attributeCategory).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).append("memo", this.memo).append("childrenStruCount", this.childrenStruCount).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElementsV
 * JD-Core Version:    0.7.0.1
 */