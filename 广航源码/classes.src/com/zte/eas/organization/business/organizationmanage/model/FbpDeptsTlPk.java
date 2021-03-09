package com.zte.eas.organization.business.organizationmanage.model;

import java.io.Serializable;
import java.math.BigInteger;

public class FbpDeptsTlPk
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private BigInteger deptId;
  private String language;
  
  public BigInteger getDeptId()
  {
    return this.deptId;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setDeptId(BigInteger paramBigInteger)
  {
    this.deptId = paramBigInteger;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTlPk
 * JD-Core Version:    0.7.0.1
 */