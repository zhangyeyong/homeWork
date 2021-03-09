package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsAllotDetails
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected BigInteger allotDetailId;
  protected BigInteger allotHeaderId;
  protected String relationType;
  protected Long relationId;
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
  
  public EvsAllotDetails() {}
  
  public EvsAllotDetails(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, BigInteger paramBigInteger1, BigInteger paramBigInteger2, String paramString2, Long paramLong4, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setAllotDetailId(paramBigInteger1);
    setAllotHeaderId(paramBigInteger2);
    setRelationType(paramString2);
    setRelationId(paramLong4);
    setAttribute1(paramString3);
    setAttribute2(paramString4);
    setAttribute3(paramString5);
    setAttribute4(paramString6);
    setAttribute5(paramString7);
    setAttribute6(paramString8);
    setAttribute7(paramString9);
    setAttribute8(paramString10);
    setAttribute9(paramString11);
    setAttribute10(paramString12);
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
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public BigInteger getAllotDetailId()
  {
    return this.allotDetailId;
  }
  
  public void setAllotDetailId(BigInteger paramBigInteger)
  {
    this.allotDetailId = paramBigInteger;
  }
  
  public BigInteger getAllotHeaderId()
  {
    return this.allotHeaderId;
  }
  
  public void setAllotHeaderId(BigInteger paramBigInteger)
  {
    this.allotHeaderId = paramBigInteger;
  }
  
  public String getRelationType()
  {
    return this.relationType;
  }
  
  public void setRelationType(String paramString)
  {
    this.relationType = paramString;
  }
  
  public Long getRelationId()
  {
    return this.relationId;
  }
  
  public void setRelationId(Long paramLong)
  {
    this.relationId = paramLong;
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
    if (!(paramObject instanceof EvsAllotDetails)) {
      return false;
    }
    EvsAllotDetails localEvsAllotDetails = (EvsAllotDetails)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localEvsAllotDetails.lastUpdateDate).append(this.lastUpdatedBy, localEvsAllotDetails.lastUpdatedBy).append(this.creationDate, localEvsAllotDetails.creationDate).append(this.createdBy, localEvsAllotDetails.createdBy).append(this.lastUpdateLogin, localEvsAllotDetails.lastUpdateLogin).append(this.enabledFlag, localEvsAllotDetails.enabledFlag).append(this.allotDetailId, localEvsAllotDetails.allotDetailId).append(this.allotHeaderId, localEvsAllotDetails.allotHeaderId).append(this.relationType, localEvsAllotDetails.relationType).append(this.relationId, localEvsAllotDetails.relationId).append(this.attribute1, localEvsAllotDetails.attribute1).append(this.attribute2, localEvsAllotDetails.attribute2).append(this.attribute3, localEvsAllotDetails.attribute3).append(this.attribute4, localEvsAllotDetails.attribute4).append(this.attribute5, localEvsAllotDetails.attribute5).append(this.attribute6, localEvsAllotDetails.attribute6).append(this.attribute7, localEvsAllotDetails.attribute7).append(this.attribute8, localEvsAllotDetails.attribute8).append(this.attribute9, localEvsAllotDetails.attribute9).append(this.attribute10, localEvsAllotDetails.attribute10).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.allotDetailId).append(this.allotHeaderId).append(this.relationType).append(this.relationId).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("allotDetailId", this.allotDetailId).append("allotHeaderId", this.allotHeaderId).append("relationType", this.relationType).append("relationId", this.relationId).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "allotDetailId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsAllotDetails
 * JD-Core Version:    0.7.0.1
 */