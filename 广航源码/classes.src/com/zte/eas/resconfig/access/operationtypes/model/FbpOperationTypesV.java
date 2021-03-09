package com.zte.eas.resconfig.access.operationtypes.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpOperationTypesV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = -2246357520359402372L;
  protected Date creationDate;
  protected Long createdBy;
  protected Date lastUpdateDate;
  protected Long lastUpdateBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long operationTypeId;
  protected String operationTypeCode;
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
  protected String operationTypeName;
  
  public FbpOperationTypesV() {}
  
  public FbpOperationTypesV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    setCreationDate(paramDate1);
    setCreatedBy(paramLong1);
    setLastUpdateDate(paramDate2);
    setLastUpdateBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setOperationTypeId(paramLong4);
    setOperationTypeCode(paramString2);
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
    setOperationTypeName(paramString13);
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
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdateBy()
  {
    return this.lastUpdateBy;
  }
  
  public void setLastUpdateBy(Long paramLong)
  {
    this.lastUpdateBy = paramLong;
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
  
  public Long getOperationTypeId()
  {
    return this.operationTypeId;
  }
  
  public void setOperationTypeId(Long paramLong)
  {
    this.operationTypeId = paramLong;
  }
  
  public String getOperationTypeCode()
  {
    return this.operationTypeCode;
  }
  
  public void setOperationTypeCode(String paramString)
  {
    this.operationTypeCode = paramString;
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
  
  public String getOperationTypeName()
  {
    return this.operationTypeName;
  }
  
  public void setOperationTypeName(String paramString)
  {
    this.operationTypeName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpOperationTypesV)) {
      return false;
    }
    FbpOperationTypesV localFbpOperationTypesV = (FbpOperationTypesV)paramObject;
    return new EqualsBuilder().append(this.creationDate, localFbpOperationTypesV.creationDate).append(this.createdBy, localFbpOperationTypesV.createdBy).append(this.lastUpdateDate, localFbpOperationTypesV.lastUpdateDate).append(this.lastUpdateBy, localFbpOperationTypesV.lastUpdateBy).append(this.lastUpdateLogin, localFbpOperationTypesV.lastUpdateLogin).append(this.enabledFlag, localFbpOperationTypesV.enabledFlag).append(this.operationTypeId, localFbpOperationTypesV.operationTypeId).append(this.operationTypeCode, localFbpOperationTypesV.operationTypeCode).append(this.attribute1, localFbpOperationTypesV.attribute1).append(this.attribute2, localFbpOperationTypesV.attribute2).append(this.attribute3, localFbpOperationTypesV.attribute3).append(this.attribute4, localFbpOperationTypesV.attribute4).append(this.attribute5, localFbpOperationTypesV.attribute5).append(this.attribute6, localFbpOperationTypesV.attribute6).append(this.attribute7, localFbpOperationTypesV.attribute7).append(this.attribute8, localFbpOperationTypesV.attribute8).append(this.attribute9, localFbpOperationTypesV.attribute9).append(this.attribute10, localFbpOperationTypesV.attribute10).append(this.operationTypeName, localFbpOperationTypesV.operationTypeName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.creationDate).append(this.createdBy).append(this.lastUpdateDate).append(this.lastUpdateBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.operationTypeId).append(this.operationTypeCode).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.operationTypeName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdateBy", this.lastUpdateBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("operationTypeId", this.operationTypeId).append("operationTypeCode", this.operationTypeCode).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("operationTypeName", this.operationTypeName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.operationtypes.model.FbpOperationTypesV
 * JD-Core Version:    0.7.0.1
 */