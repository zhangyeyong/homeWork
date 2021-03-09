package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;

public class CompanyInfo
  implements Serializable
{
  private Long siteId;
  private String companyCode;
  private String companyName;
  
  public Long getSiteId()
  {
    return this.siteId;
  }
  
  public void setSiteId(Long paramLong)
  {
    this.siteId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.CompanyInfo
 * JD-Core Version:    0.7.0.1
 */