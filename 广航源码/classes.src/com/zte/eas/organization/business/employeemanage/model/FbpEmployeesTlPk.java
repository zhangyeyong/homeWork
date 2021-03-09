package com.zte.eas.organization.business.employeemanage.model;

import java.io.Serializable;
import java.math.BigInteger;

public class FbpEmployeesTlPk
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String language;
  private BigInteger employeeId;
  
  public BigInteger getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(BigInteger paramBigInteger)
  {
    this.employeeId = paramBigInteger;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.employeemanage.model.FbpEmployeesTlPk
 * JD-Core Version:    0.7.0.1
 */