package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsDocTypeMap
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private Long typeId;
  private Long subDocId;
  private String typeCode;
  
  public EvsDocTypeMap() {}
  
  public EvsDocTypeMap(Long paramLong1, Long paramLong2, String paramString)
  {
    this.typeId = paramLong1;
    this.subDocId = paramLong2;
    this.typeCode = paramString;
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
  
  public Long getTypeId()
  {
    return this.typeId;
  }
  
  public void setTypeId(Long paramLong)
  {
    this.typeId = paramLong;
  }
  
  public String getTypeCode()
  {
    return this.typeCode;
  }
  
  public void setTypeCode(String paramString)
  {
    this.typeCode = paramString;
  }
  
  public Long getSubDocId()
  {
    return this.subDocId;
  }
  
  public void setSubDocId(Long paramLong)
  {
    this.subDocId = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsDocTypeMap
 * JD-Core Version:    0.7.0.1
 */