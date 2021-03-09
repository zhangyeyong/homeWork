package com.zte.esb.bean.foss;

import com.zte.esb.bean.Adapter1;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="DistrictInfo", propOrder={"id", "code", "name", "simpleName", "availableName", "parentDistrictName", "virtualDistrictId", "degree", "parentDistrictCode", "createTime", "modifyTime", "active", "createUserCode", "modifyUserCode", "regionSuffix", "versionNo", "pinyin", "pinyinAbbr"})
public class DistrictInfo
{
  @XmlElement(required=true)
  protected String id;
  protected String code;
  protected String name;
  protected String simpleName;
  protected String availableName;
  protected String parentDistrictName;
  protected String virtualDistrictId;
  protected String degree;
  protected String parentDistrictCode;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date createTime;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date modifyTime;
  protected String active;
  protected String createUserCode;
  protected String modifyUserCode;
  protected String regionSuffix;
  protected Double versionNo;
  protected String pinyin;
  protected String pinyinAbbr;
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public String getSimpleName()
  {
    return this.simpleName;
  }
  
  public void setSimpleName(String paramString)
  {
    this.simpleName = paramString;
  }
  
  public String getAvailableName()
  {
    return this.availableName;
  }
  
  public void setAvailableName(String paramString)
  {
    this.availableName = paramString;
  }
  
  public String getParentDistrictName()
  {
    return this.parentDistrictName;
  }
  
  public void setParentDistrictName(String paramString)
  {
    this.parentDistrictName = paramString;
  }
  
  public String getVirtualDistrictId()
  {
    return this.virtualDistrictId;
  }
  
  public void setVirtualDistrictId(String paramString)
  {
    this.virtualDistrictId = paramString;
  }
  
  public String getDegree()
  {
    return this.degree;
  }
  
  public void setDegree(String paramString)
  {
    this.degree = paramString;
  }
  
  public String getParentDistrictCode()
  {
    return this.parentDistrictCode;
  }
  
  public void setParentDistrictCode(String paramString)
  {
    this.parentDistrictCode = paramString;
  }
  
  public Date getCreateTime()
  {
    return this.createTime;
  }
  
  public void setCreateTime(Date paramDate)
  {
    this.createTime = paramDate;
  }
  
  public Date getModifyTime()
  {
    return this.modifyTime;
  }
  
  public void setModifyTime(Date paramDate)
  {
    this.modifyTime = paramDate;
  }
  
  public String getActive()
  {
    return this.active;
  }
  
  public void setActive(String paramString)
  {
    this.active = paramString;
  }
  
  public String getCreateUserCode()
  {
    return this.createUserCode;
  }
  
  public void setCreateUserCode(String paramString)
  {
    this.createUserCode = paramString;
  }
  
  public String getModifyUserCode()
  {
    return this.modifyUserCode;
  }
  
  public void setModifyUserCode(String paramString)
  {
    this.modifyUserCode = paramString;
  }
  
  public String getRegionSuffix()
  {
    return this.regionSuffix;
  }
  
  public void setRegionSuffix(String paramString)
  {
    this.regionSuffix = paramString;
  }
  
  public Double getVersionNo()
  {
    return this.versionNo;
  }
  
  public void setVersionNo(Double paramDouble)
  {
    this.versionNo = paramDouble;
  }
  
  public String getPinyin()
  {
    return this.pinyin;
  }
  
  public void setPinyin(String paramString)
  {
    this.pinyin = paramString;
  }
  
  public String getPinyinAbbr()
  {
    return this.pinyinAbbr;
  }
  
  public void setPinyinAbbr(String paramString)
  {
    this.pinyinAbbr = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.foss.DistrictInfo
 * JD-Core Version:    0.7.0.1
 */