package com.zte.evs.ebill.model.eBillManage;

import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsCity
{
  protected Date creationDate;
  protected Long createdBy;
  protected Date lastUpdateDate;
  protected Long lastUpdateBy;
  protected Long lastUpdateLogin;
  protected Long cityId;
  protected String cityCode;
  protected String cityName;
  protected String citySimname;
  protected String cityAvailname;
  protected Long parentCityId;
  protected String virDistrict;
  protected String cityDegree;
  protected String regionSuffix;
  protected String vesionNo;
  protected String pingYin;
  protected String pingyinAbbr;
  protected String enabledFlag;
  
  public EvsCity() {}
  
  public EvsCity(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong5, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    setCreationDate(paramDate1);
    setCreatedBy(paramLong1);
    setLastUpdateDate(paramDate2);
    setLastUpdateBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setCityId(paramLong4);
    setCityCode(paramString1);
    setCityName(paramString2);
    setCitySimname(paramString3);
    setCityAvailname(paramString4);
    setParentCityId(paramLong5);
    setVirDistrict(paramString5);
    setCityDegree(paramString6);
    setRegionSuffix(paramString7);
    setVesionNo(paramString8);
    setPingYin(paramString9);
    setPingyinAbbr(paramString10);
    setEnabledFlag(paramString11);
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
  
  public Long getCityId()
  {
    return this.cityId;
  }
  
  public void setCityId(Long paramLong)
  {
    this.cityId = paramLong;
  }
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public String getCityName()
  {
    return this.cityName;
  }
  
  public void setCityName(String paramString)
  {
    this.cityName = paramString;
  }
  
  public String getCitySimname()
  {
    return this.citySimname;
  }
  
  public void setCitySimname(String paramString)
  {
    this.citySimname = paramString;
  }
  
  public String getCityAvailname()
  {
    return this.cityAvailname;
  }
  
  public void setCityAvailname(String paramString)
  {
    this.cityAvailname = paramString;
  }
  
  public Long getParentCityId()
  {
    return this.parentCityId;
  }
  
  public void setParentCityId(Long paramLong)
  {
    this.parentCityId = paramLong;
  }
  
  public String getVirDistrict()
  {
    return this.virDistrict;
  }
  
  public void setVirDistrict(String paramString)
  {
    this.virDistrict = paramString;
  }
  
  public String getCityDegree()
  {
    return this.cityDegree;
  }
  
  public void setCityDegree(String paramString)
  {
    this.cityDegree = paramString;
  }
  
  public String getRegionSuffix()
  {
    return this.regionSuffix;
  }
  
  public void setRegionSuffix(String paramString)
  {
    this.regionSuffix = paramString;
  }
  
  public String getVesionNo()
  {
    return this.vesionNo;
  }
  
  public void setVesionNo(String paramString)
  {
    this.vesionNo = paramString;
  }
  
  public String getPingYin()
  {
    return this.pingYin;
  }
  
  public void setPingYin(String paramString)
  {
    this.pingYin = paramString;
  }
  
  public String getPingyinAbbr()
  {
    return this.pingyinAbbr;
  }
  
  public void setPingyinAbbr(String paramString)
  {
    this.pingyinAbbr = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsCity)) {
      return false;
    }
    EvsCity localEvsCity = (EvsCity)paramObject;
    return new EqualsBuilder().append(this.creationDate, localEvsCity.creationDate).append(this.createdBy, localEvsCity.createdBy).append(this.lastUpdateDate, localEvsCity.lastUpdateDate).append(this.lastUpdateBy, localEvsCity.lastUpdateBy).append(this.lastUpdateLogin, localEvsCity.lastUpdateLogin).append(this.cityId, localEvsCity.cityId).append(this.cityCode, localEvsCity.cityCode).append(this.cityName, localEvsCity.cityName).append(this.citySimname, localEvsCity.citySimname).append(this.cityAvailname, localEvsCity.cityAvailname).append(this.parentCityId, localEvsCity.parentCityId).append(this.virDistrict, localEvsCity.virDistrict).append(this.cityDegree, localEvsCity.cityDegree).append(this.regionSuffix, localEvsCity.regionSuffix).append(this.vesionNo, localEvsCity.vesionNo).append(this.pingYin, localEvsCity.pingYin).append(this.pingyinAbbr, localEvsCity.pingyinAbbr).append(this.enabledFlag, localEvsCity.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.creationDate).append(this.createdBy).append(this.lastUpdateDate).append(this.lastUpdateBy).append(this.lastUpdateLogin).append(this.cityId).append(this.cityCode).append(this.cityName).append(this.citySimname).append(this.cityAvailname).append(this.parentCityId).append(this.virDistrict).append(this.cityDegree).append(this.regionSuffix).append(this.vesionNo).append(this.pingYin).append(this.pingyinAbbr).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdateBy", this.lastUpdateBy).append("lastUpdateLogin", this.lastUpdateLogin).append("cityId", this.cityId).append("cityCode", this.cityCode).append("cityName", this.cityName).append("citySimname", this.citySimname).append("cityAvailname", this.cityAvailname).append("parentCityId", this.parentCityId).append("virDistrict", this.virDistrict).append("cityDegree", this.cityDegree).append("regionSuffix", this.regionSuffix).append("vesionNo", this.vesionNo).append("pingYin", this.pingYin).append("pingyinAbbr", this.pingyinAbbr).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "cityId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsCity
 * JD-Core Version:    0.7.0.1
 */