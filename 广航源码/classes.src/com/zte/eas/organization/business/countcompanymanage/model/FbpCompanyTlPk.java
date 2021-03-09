package com.zte.eas.organization.business.countcompanymanage.model;

import java.io.Serializable;

public class FbpCompanyTlPk
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String language;
  private Long companyId;
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyTlPk
 * JD-Core Version:    0.7.0.1
 */