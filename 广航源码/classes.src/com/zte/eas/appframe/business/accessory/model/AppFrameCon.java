package com.zte.eas.appframe.business.accessory.model;

import java.math.BigInteger;

public class AppFrameCon
{
  private BigInteger accessoryId;
  private BigInteger relationId;
  private String accessoryType;
  private String accessoryTitle;
  private String deptId;
  private String accessoryTypes;
  
  public String getAccessoryTitle()
  {
    return this.accessoryTitle;
  }
  
  public void setAccessoryTitle(String paramString)
  {
    this.accessoryTitle = paramString;
  }
  
  public String getAccessoryType()
  {
    return this.accessoryType;
  }
  
  public void setAccessoryType(String paramString)
  {
    this.accessoryType = paramString;
  }
  
  public BigInteger getAccessoryId()
  {
    return this.accessoryId;
  }
  
  public void setAccessoryId(BigInteger paramBigInteger)
  {
    this.accessoryId = paramBigInteger;
  }
  
  public BigInteger getRelationId()
  {
    return this.relationId;
  }
  
  public void setRelationId(BigInteger paramBigInteger)
  {
    this.relationId = paramBigInteger;
  }
  
  public String getDeptId()
  {
    return this.deptId;
  }
  
  public void setDeptId(String paramString)
  {
    this.deptId = paramString;
  }
  
  public String getAccessoryTypes()
  {
    return this.accessoryTypes;
  }
  
  public void setAccessoryTypes(String paramString)
  {
    this.accessoryTypes = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.accessory.model.AppFrameCon
 * JD-Core Version:    0.7.0.1
 */