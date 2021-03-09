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
@XmlType(name="AdminOrgInfo", propOrder={"orgChangeId", "orgId", "orgCode", "parentOrgCode", "orgName", "orgAttribute", "orgBenchmarkCode", "orgManager", "orgPhone", "orgFax", "parentOrgId", "parentOrgBenchmarkCode", "subCompName", "subCompCode", "costCenterCode", "costCenterName", "orgProvince", "orgCity", "orgCountry", "orgZipCode", "orgEmail", "orgAddress", "orgStatus", "validDate", "invalidDate", "isCareerDept", "isBigArea", "isSmallArea", "orgLevel", "orgDesc", "orgSeq", "isLeaf", "changeType", "changeDate", "displayOrder", "deptShortName", "deptAttribute", "areaCode", "canceledSystems", "ehrDeptCode"})
public class AdminOrgInfo
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String orgChangeId;
  @XmlElement(required=true)
  protected String orgId;
  @XmlElement(required=true)
  protected String orgCode;
  @XmlElement(required=true)
  protected String parentOrgCode;
  @XmlElement(required=true)
  protected String orgName;
  protected String orgAttribute;
  @XmlElement(required=true)
  protected String orgBenchmarkCode;
  @XmlElement(required=true)
  protected String orgManager;
  protected String orgPhone;
  protected String orgFax;
  protected String parentOrgId;
  @XmlElement(required=true)
  protected String parentOrgBenchmarkCode;
  protected String subCompName;
  @XmlElement(required=true)
  protected String subCompCode;
  @XmlElement(required=true)
  protected String costCenterCode;
  protected String costCenterName;
  protected String orgProvince;
  protected String orgCity;
  protected String orgCountry;
  protected String orgZipCode;
  protected String orgEmail;
  protected String orgAddress;
  @XmlElement(required=true)
  protected String orgStatus;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date validDate;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date invalidDate;
  protected boolean isCareerDept;
  protected boolean isBigArea;
  protected boolean isSmallArea;
  protected String orgLevel;
  protected String orgDesc;
  protected String orgSeq;
  protected boolean isLeaf;
  @XmlElement(required=true)
  protected String changeType;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date changeDate;
  protected String displayOrder;
  protected String deptShortName;
  protected String deptAttribute;
  protected String areaCode;
  protected String canceledSystems;
  protected String ehrDeptCode;
  
  public String getOrgChangeId()
  {
    return this.orgChangeId;
  }
  
  public void setOrgChangeId(String paramString)
  {
    this.orgChangeId = paramString;
  }
  
  public String getOrgId()
  {
    return this.orgId;
  }
  
  public void setOrgId(String paramString)
  {
    this.orgId = paramString;
  }
  
  public String getOrgCode()
  {
    return this.orgCode;
  }
  
  public void setOrgCode(String paramString)
  {
    this.orgCode = paramString;
  }
  
  public String getParentOrgCode()
  {
    return this.parentOrgCode;
  }
  
  public void setParentOrgCode(String paramString)
  {
    this.parentOrgCode = paramString;
  }
  
  public String getOrgName()
  {
    return this.orgName;
  }
  
  public void setOrgName(String paramString)
  {
    this.orgName = paramString;
  }
  
  public String getOrgAttribute()
  {
    return this.orgAttribute;
  }
  
  public void setOrgAttribute(String paramString)
  {
    this.orgAttribute = paramString;
  }
  
  public String getOrgBenchmarkCode()
  {
    return this.orgBenchmarkCode;
  }
  
  public void setOrgBenchmarkCode(String paramString)
  {
    this.orgBenchmarkCode = paramString;
  }
  
  public String getOrgManager()
  {
    return this.orgManager;
  }
  
  public void setOrgManager(String paramString)
  {
    this.orgManager = paramString;
  }
  
  public String getOrgPhone()
  {
    return this.orgPhone;
  }
  
  public void setOrgPhone(String paramString)
  {
    this.orgPhone = paramString;
  }
  
  public String getOrgFax()
  {
    return this.orgFax;
  }
  
  public void setOrgFax(String paramString)
  {
    this.orgFax = paramString;
  }
  
  public String getParentOrgId()
  {
    return this.parentOrgId;
  }
  
  public void setParentOrgId(String paramString)
  {
    this.parentOrgId = paramString;
  }
  
  public String getParentOrgBenchmarkCode()
  {
    return this.parentOrgBenchmarkCode;
  }
  
  public void setParentOrgBenchmarkCode(String paramString)
  {
    this.parentOrgBenchmarkCode = paramString;
  }
  
  public String getSubCompName()
  {
    return this.subCompName;
  }
  
  public void setSubCompName(String paramString)
  {
    this.subCompName = paramString;
  }
  
  public String getSubCompCode()
  {
    return this.subCompCode;
  }
  
  public void setSubCompCode(String paramString)
  {
    this.subCompCode = paramString;
  }
  
  public String getCostCenterCode()
  {
    return this.costCenterCode;
  }
  
  public void setCostCenterCode(String paramString)
  {
    this.costCenterCode = paramString;
  }
  
  public String getCostCenterName()
  {
    return this.costCenterName;
  }
  
  public void setCostCenterName(String paramString)
  {
    this.costCenterName = paramString;
  }
  
  public String getOrgProvince()
  {
    return this.orgProvince;
  }
  
  public void setOrgProvince(String paramString)
  {
    this.orgProvince = paramString;
  }
  
  public String getOrgCity()
  {
    return this.orgCity;
  }
  
  public void setOrgCity(String paramString)
  {
    this.orgCity = paramString;
  }
  
  public String getOrgCountry()
  {
    return this.orgCountry;
  }
  
  public void setOrgCountry(String paramString)
  {
    this.orgCountry = paramString;
  }
  
  public String getOrgZipCode()
  {
    return this.orgZipCode;
  }
  
  public void setOrgZipCode(String paramString)
  {
    this.orgZipCode = paramString;
  }
  
  public String getOrgEmail()
  {
    return this.orgEmail;
  }
  
  public void setOrgEmail(String paramString)
  {
    this.orgEmail = paramString;
  }
  
  public String getOrgAddress()
  {
    return this.orgAddress;
  }
  
  public void setOrgAddress(String paramString)
  {
    this.orgAddress = paramString;
  }
  
  public String getOrgStatus()
  {
    return this.orgStatus;
  }
  
  public void setOrgStatus(String paramString)
  {
    this.orgStatus = paramString;
  }
  
  public Date getValidDate()
  {
    return this.validDate;
  }
  
  public void setValidDate(Date paramDate)
  {
    this.validDate = paramDate;
  }
  
  public Date getInvalidDate()
  {
    return this.invalidDate;
  }
  
  public void setInvalidDate(Date paramDate)
  {
    this.invalidDate = paramDate;
  }
  
  public boolean isIsCareerDept()
  {
    return this.isCareerDept;
  }
  
  public void setIsCareerDept(boolean paramBoolean)
  {
    this.isCareerDept = paramBoolean;
  }
  
  public boolean isIsBigArea()
  {
    return this.isBigArea;
  }
  
  public void setIsBigArea(boolean paramBoolean)
  {
    this.isBigArea = paramBoolean;
  }
  
  public boolean isIsSmallArea()
  {
    return this.isSmallArea;
  }
  
  public void setIsSmallArea(boolean paramBoolean)
  {
    this.isSmallArea = paramBoolean;
  }
  
  public String getOrgLevel()
  {
    return this.orgLevel;
  }
  
  public void setOrgLevel(String paramString)
  {
    this.orgLevel = paramString;
  }
  
  public String getOrgDesc()
  {
    return this.orgDesc;
  }
  
  public void setOrgDesc(String paramString)
  {
    this.orgDesc = paramString;
  }
  
  public String getOrgSeq()
  {
    return this.orgSeq;
  }
  
  public void setOrgSeq(String paramString)
  {
    this.orgSeq = paramString;
  }
  
  public boolean isIsLeaf()
  {
    return this.isLeaf;
  }
  
  public void setIsLeaf(boolean paramBoolean)
  {
    this.isLeaf = paramBoolean;
  }
  
  public String getChangeType()
  {
    return this.changeType;
  }
  
  public void setChangeType(String paramString)
  {
    this.changeType = paramString;
  }
  
  public Date getChangeDate()
  {
    return this.changeDate;
  }
  
  public void setChangeDate(Date paramDate)
  {
    this.changeDate = paramDate;
  }
  
  public String getDisplayOrder()
  {
    return this.displayOrder;
  }
  
  public void setDisplayOrder(String paramString)
  {
    this.displayOrder = paramString;
  }
  
  public String getDeptShortName()
  {
    return this.deptShortName;
  }
  
  public void setDeptShortName(String paramString)
  {
    this.deptShortName = paramString;
  }
  
  public String getDeptAttribute()
  {
    return this.deptAttribute;
  }
  
  public void setDeptAttribute(String paramString)
  {
    this.deptAttribute = paramString;
  }
  
  public String getAreaCode()
  {
    return this.areaCode;
  }
  
  public void setAreaCode(String paramString)
  {
    this.areaCode = paramString;
  }
  
  public String getCanceledSystems()
  {
    return this.canceledSystems;
  }
  
  public void setCanceledSystems(String paramString)
  {
    this.canceledSystems = paramString;
  }
  
  public String getEhrDeptCode()
  {
    return this.ehrDeptCode;
  }
  
  public void setEhrDeptCode(String paramString)
  {
    this.ehrDeptCode = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.AdminOrgInfo
 * JD-Core Version:    0.7.0.1
 */