package com.zte.eas.organization.business.checkunits.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpCheckUnitContentsAllV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected BigInteger contentId;
  protected String checkUnit;
  protected String checkUnitName;
  protected BigInteger orgId;
  protected BigInteger erpOrgId;
  protected String erpOrgName;
  protected String enabledFlag;
  
  public FbpCheckUnitContentsAllV() {}
  
  public FbpCheckUnitContentsAllV(BigInteger paramBigInteger1, String paramString1, String paramString2, BigInteger paramBigInteger2, BigInteger paramBigInteger3, String paramString3, String paramString4)
  {
    setContentId(paramBigInteger1);
    setCheckUnit(paramString1);
    setCheckUnitName(paramString2);
    setOrgId(paramBigInteger2);
    setErpOrgId(paramBigInteger3);
    setErpOrgName(paramString3);
    setEnabledFlag(paramString4);
  }
  
  public BigInteger getContentId()
  {
    return this.contentId;
  }
  
  public void setContentId(BigInteger paramBigInteger)
  {
    this.contentId = paramBigInteger;
  }
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
  
  public String getCheckUnitName()
  {
    return this.checkUnitName;
  }
  
  public void setCheckUnitName(String paramString)
  {
    this.checkUnitName = paramString;
  }
  
  public BigInteger getOrgId()
  {
    return this.orgId;
  }
  
  public void setOrgId(BigInteger paramBigInteger)
  {
    this.orgId = paramBigInteger;
  }
  
  public BigInteger getErpOrgId()
  {
    return this.erpOrgId;
  }
  
  public void setErpOrgId(BigInteger paramBigInteger)
  {
    this.erpOrgId = paramBigInteger;
  }
  
  public String getErpOrgName()
  {
    return this.erpOrgName;
  }
  
  public void setErpOrgName(String paramString)
  {
    this.erpOrgName = paramString;
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
    if (!(paramObject instanceof FbpCheckUnitContentsAllV)) {
      return false;
    }
    FbpCheckUnitContentsAllV localFbpCheckUnitContentsAllV = (FbpCheckUnitContentsAllV)paramObject;
    return new EqualsBuilder().append(this.contentId, localFbpCheckUnitContentsAllV.contentId).append(this.checkUnit, localFbpCheckUnitContentsAllV.checkUnit).append(this.checkUnitName, localFbpCheckUnitContentsAllV.checkUnitName).append(this.orgId, localFbpCheckUnitContentsAllV.orgId).append(this.erpOrgId, localFbpCheckUnitContentsAllV.erpOrgId).append(this.erpOrgName, localFbpCheckUnitContentsAllV.erpOrgName).append(this.enabledFlag, localFbpCheckUnitContentsAllV.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.contentId).append(this.checkUnit).append(this.checkUnitName).append(this.orgId).append(this.erpOrgId).append(this.erpOrgName).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("contentId", this.contentId).append("checkUnit", this.checkUnit).append("checkUnitName", this.checkUnitName).append("orgId", this.orgId).append("erpOrgId", this.erpOrgId).append("erpOrgName", this.erpOrgName).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContentsAllV
 * JD-Core Version:    0.7.0.1
 */