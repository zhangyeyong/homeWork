package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;
import java.util.Date;

public class FbpPositionsTl
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private FbpPositionsTlPk positionsTlPK;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String positionName;
  protected String description;
  protected String sourceLang;
  
  public FbpPositionsTl() {}
  
  public FbpPositionsTl(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, String paramString2, String paramString3)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setPositionName(paramString1);
    setDescription(paramString2);
    setSourceLang(paramString3);
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
  
  public String getPositionName()
  {
    return this.positionName;
  }
  
  public void setPositionName(String paramString)
  {
    this.positionName = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public String getSourceLang()
  {
    return this.sourceLang;
  }
  
  public void setSourceLang(String paramString)
  {
    this.sourceLang = paramString;
  }
  
  public FbpPositionsTlPk getPositionsTlPK()
  {
    return this.positionsTlPK;
  }
  
  public void setPositionsTlPK(FbpPositionsTlPk paramFbpPositionsTlPk)
  {
    this.positionsTlPK = paramFbpPositionsTlPk;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.FbpPositionsTl
 * JD-Core Version:    0.7.0.1
 */