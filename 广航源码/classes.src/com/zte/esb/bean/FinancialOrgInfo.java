package com.zte.esb.bean;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="FinancialOrgInfo", propOrder={"finOrgChangeId", "finOrgId", "fullPath", "finOrgCode", "finOrgBenchmarkCode", "parentFinOrgCode", "parentFinOrgBenchmarkCode", "isLeaf", "isMothball", "lastModifyTime", "sysOrgCode", "finOrgName", "isCostCenter", "subCompanyName", "subCompanyCode", "finOrgFullName", "description"})
public class FinancialOrgInfo
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String finOrgChangeId;
  @XmlElement(required=true)
  protected String finOrgId;
  @XmlElement(required=true)
  protected String fullPath;
  @XmlElement(required=true)
  protected String finOrgCode;
  protected String finOrgBenchmarkCode;
  @XmlElement(required=true)
  protected String parentFinOrgCode;
  protected String parentFinOrgBenchmarkCode;
  protected boolean isLeaf;
  protected boolean isMothball;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date lastModifyTime;
  @XmlElement(required=true)
  protected String sysOrgCode;
  @XmlElement(required=true)
  protected String finOrgName;
  protected boolean isCostCenter;
  protected String subCompanyName;
  protected String subCompanyCode;
  @XmlElement(required=true)
  protected String finOrgFullName;
  @XmlElement(required=true)
  protected String description;
  
  public String getFinOrgChangeId()
  {
    return this.finOrgChangeId;
  }
  
  public void setFinOrgChangeId(String paramString)
  {
    this.finOrgChangeId = paramString;
  }
  
  public String getFinOrgId()
  {
    return this.finOrgId;
  }
  
  public void setFinOrgId(String paramString)
  {
    this.finOrgId = paramString;
  }
  
  public String getFullPath()
  {
    return this.fullPath;
  }
  
  public void setFullPath(String paramString)
  {
    this.fullPath = paramString;
  }
  
  public String getFinOrgCode()
  {
    return this.finOrgCode;
  }
  
  public void setFinOrgCode(String paramString)
  {
    this.finOrgCode = paramString;
  }
  
  public String getFinOrgBenchmarkCode()
  {
    return this.finOrgBenchmarkCode;
  }
  
  public void setFinOrgBenchmarkCode(String paramString)
  {
    this.finOrgBenchmarkCode = paramString;
  }
  
  public String getParentFinOrgCode()
  {
    return this.parentFinOrgCode;
  }
  
  public void setParentFinOrgCode(String paramString)
  {
    this.parentFinOrgCode = paramString;
  }
  
  public String getParentFinOrgBenchmarkCode()
  {
    return this.parentFinOrgBenchmarkCode;
  }
  
  public void setParentFinOrgBenchmarkCode(String paramString)
  {
    this.parentFinOrgBenchmarkCode = paramString;
  }
  
  public boolean isIsLeaf()
  {
    return this.isLeaf;
  }
  
  public void setIsLeaf(boolean paramBoolean)
  {
    this.isLeaf = paramBoolean;
  }
  
  public boolean isIsMothball()
  {
    return this.isMothball;
  }
  
  public void setIsMothball(boolean paramBoolean)
  {
    this.isMothball = paramBoolean;
  }
  
  public Date getLastModifyTime()
  {
    return this.lastModifyTime;
  }
  
  public void setLastModifyTime(Date paramDate)
  {
    this.lastModifyTime = paramDate;
  }
  
  public String getSysOrgCode()
  {
    return this.sysOrgCode;
  }
  
  public void setSysOrgCode(String paramString)
  {
    this.sysOrgCode = paramString;
  }
  
  public String getFinOrgName()
  {
    return this.finOrgName;
  }
  
  public void setFinOrgName(String paramString)
  {
    this.finOrgName = paramString;
  }
  
  public boolean isIsCostCenter()
  {
    return this.isCostCenter;
  }
  
  public void setIsCostCenter(boolean paramBoolean)
  {
    this.isCostCenter = paramBoolean;
  }
  
  public String getSubCompanyName()
  {
    return this.subCompanyName;
  }
  
  public void setSubCompanyName(String paramString)
  {
    this.subCompanyName = paramString;
  }
  
  public String getSubCompanyCode()
  {
    return this.subCompanyCode;
  }
  
  public void setSubCompanyCode(String paramString)
  {
    this.subCompanyCode = paramString;
  }
  
  public String getFinOrgFullName()
  {
    return this.finOrgFullName;
  }
  
  public void setFinOrgFullName(String paramString)
  {
    this.finOrgFullName = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.FinancialOrgInfo
 * JD-Core Version:    0.7.0.1
 */