package com.zte.eas.appframe.business.currencies.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpCurrenciesV
  extends BaseObject
  implements Serializable
{
  protected String currencyCode;
  protected String currencyName;
  protected String description;
  protected Date startDateActive;
  protected Date endDateActive;
  protected String enabledFlag;
  
  public FbpCurrenciesV() {}
  
  public FbpCurrenciesV(String paramString1, String paramString2, String paramString3, Date paramDate1, Date paramDate2, String paramString4)
  {
    setCurrencyCode(paramString1);
    setCurrencyName(paramString2);
    setDescription(paramString3);
    setStartDateActive(paramDate1);
    setEndDateActive(paramDate2);
    setEnabledFlag(paramString4);
  }
  
  public String getCurrencyCode()
  {
    return this.currencyCode;
  }
  
  public void setCurrencyCode(String paramString)
  {
    this.currencyCode = paramString;
  }
  
  public String getCurrencyName()
  {
    return this.currencyName;
  }
  
  public void setCurrencyName(String paramString)
  {
    this.currencyName = paramString;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public Date getStartDateActive()
  {
    return this.startDateActive;
  }
  
  public void setStartDateActive(Date paramDate)
  {
    this.startDateActive = paramDate;
  }
  
  public Date getEndDateActive()
  {
    return this.endDateActive;
  }
  
  public void setEndDateActive(Date paramDate)
  {
    this.endDateActive = paramDate;
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
    if (!(paramObject instanceof FbpCurrenciesV)) {
      return false;
    }
    FbpCurrenciesV localFbpCurrenciesV = (FbpCurrenciesV)paramObject;
    return new EqualsBuilder().append(this.currencyCode, localFbpCurrenciesV.currencyCode).append(this.currencyName, localFbpCurrenciesV.currencyName).append(this.description, localFbpCurrenciesV.description).append(this.startDateActive, localFbpCurrenciesV.startDateActive).append(this.endDateActive, localFbpCurrenciesV.endDateActive).append(this.enabledFlag, localFbpCurrenciesV.enabledFlag).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.currencyCode).append(this.currencyName).append(this.description).append(this.startDateActive).append(this.endDateActive).append(this.enabledFlag).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("currencyCode", this.currencyCode).append("currencyName", this.currencyName).append("description", this.description).append("startDateActive", this.startDateActive).append("endDateActive", this.endDateActive).append("enabledFlag", this.enabledFlag).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.currencies.model.FbpCurrenciesV
 * JD-Core Version:    0.7.0.1
 */