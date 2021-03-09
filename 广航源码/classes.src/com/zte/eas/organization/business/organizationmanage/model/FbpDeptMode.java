package com.zte.eas.organization.business.organizationmanage.model;

import java.math.BigInteger;
import java.util.Date;

public class FbpDeptMode
{
  protected Date lastUpdateDate;
  protected String deptCode;
  protected BigInteger parentDeptId;
  protected String deptName;
  protected String enabledFlag;
  
  public FbpDeptMode() {}
  
  public FbpDeptMode(Date paramDate, String paramString1, BigInteger paramBigInteger, String paramString2, String paramString3)
  {
    this.lastUpdateDate = paramDate;
    this.deptCode = paramString1;
    this.parentDeptId = paramBigInteger;
    this.deptName = paramString2;
    this.enabledFlag = paramString3;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public String getDeptCode()
  {
    return this.deptCode;
  }
  
  public void setDeptCode(String paramString)
  {
    this.deptCode = paramString;
  }
  
  public BigInteger getParentDeptId()
  {
    return this.parentDeptId;
  }
  
  public void setParentDeptId(BigInteger paramBigInteger)
  {
    this.parentDeptId = paramBigInteger;
  }
  
  public String getDeptName()
  {
    return this.deptName;
  }
  
  public void setDeptName(String paramString)
  {
    this.deptName = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.organizationmanage.model.FbpDeptMode
 * JD-Core Version:    0.7.0.1
 */