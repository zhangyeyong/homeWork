package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsInvoices
  extends BaseObject
  implements Serializable
{
  protected Date creationDate;
  protected Long createdBy;
  protected Date lastUpdateDate;
  protected Long lastUpdateBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long invoiceId;
  protected String invoiceNum;
  protected BigDecimal invoiceAmount;
  protected Date invoiceDate;
  protected String sellCompanyCode;
  protected String sellCompanyName;
  protected String buyCompanyCode;
  protected String buyCompanyName;
  
  public EvsInvoices() {}
  
  public EvsInvoices(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, BigDecimal paramBigDecimal, Date paramDate3, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    setCreationDate(paramDate1);
    setCreatedBy(paramLong1);
    setLastUpdateDate(paramDate2);
    setLastUpdateBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setInvoiceId(paramLong4);
    setInvoiceNum(paramString2);
    setInvoiceAmount(paramBigDecimal);
    setInvoiceDate(paramDate3);
    setSellCompanyCode(paramString3);
    setSellCompanyName(paramString4);
    setBuyCompanyCode(paramString5);
    setBuyCompanyName(paramString6);
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
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Long getInvoiceId()
  {
    return this.invoiceId;
  }
  
  public void setInvoiceId(Long paramLong)
  {
    this.invoiceId = paramLong;
  }
  
  public String getInvoiceNum()
  {
    return this.invoiceNum;
  }
  
  public void setInvoiceNum(String paramString)
  {
    this.invoiceNum = paramString;
  }
  
  public BigDecimal getInvoiceAmount()
  {
    return this.invoiceAmount;
  }
  
  public void setInvoiceAmount(BigDecimal paramBigDecimal)
  {
    this.invoiceAmount = paramBigDecimal;
  }
  
  public Date getInvoiceDate()
  {
    return this.invoiceDate;
  }
  
  public void setInvoiceDate(Date paramDate)
  {
    this.invoiceDate = paramDate;
  }
  
  public String getSellCompanyCode()
  {
    return this.sellCompanyCode;
  }
  
  public void setSellCompanyCode(String paramString)
  {
    this.sellCompanyCode = paramString;
  }
  
  public String getSellCompanyName()
  {
    return this.sellCompanyName;
  }
  
  public void setSellCompanyName(String paramString)
  {
    this.sellCompanyName = paramString;
  }
  
  public String getBuyCompanyCode()
  {
    return this.buyCompanyCode;
  }
  
  public void setBuyCompanyCode(String paramString)
  {
    this.buyCompanyCode = paramString;
  }
  
  public String getBuyCompanyName()
  {
    return this.buyCompanyName;
  }
  
  public void setBuyCompanyName(String paramString)
  {
    this.buyCompanyName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsInvoices)) {
      return false;
    }
    EvsInvoices localEvsInvoices = (EvsInvoices)paramObject;
    return new EqualsBuilder().append(this.creationDate, localEvsInvoices.creationDate).append(this.createdBy, localEvsInvoices.createdBy).append(this.lastUpdateDate, localEvsInvoices.lastUpdateDate).append(this.lastUpdateBy, localEvsInvoices.lastUpdateBy).append(this.lastUpdateLogin, localEvsInvoices.lastUpdateLogin).append(this.enabledFlag, localEvsInvoices.enabledFlag).append(this.invoiceId, localEvsInvoices.invoiceId).append(this.invoiceNum, localEvsInvoices.invoiceNum).append(this.invoiceAmount, localEvsInvoices.invoiceAmount).append(this.invoiceDate, localEvsInvoices.invoiceDate).append(this.sellCompanyCode, localEvsInvoices.sellCompanyCode).append(this.sellCompanyName, localEvsInvoices.sellCompanyName).append(this.buyCompanyCode, localEvsInvoices.buyCompanyCode).append(this.buyCompanyName, localEvsInvoices.buyCompanyName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.creationDate).append(this.createdBy).append(this.lastUpdateDate).append(this.lastUpdateBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.invoiceId).append(this.invoiceNum).append(this.invoiceAmount).append(this.invoiceDate).append(this.sellCompanyCode).append(this.sellCompanyName).append(this.buyCompanyCode).append(this.buyCompanyName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdateBy", this.lastUpdateBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("invoiceId", this.invoiceId).append("invoiceNum", this.invoiceNum).append("invoiceAmount", this.invoiceAmount).append("invoiceDate", this.invoiceDate).append("sellCompanyCode", this.sellCompanyCode).append("sellCompanyName", this.sellCompanyName).append("buyCompanyCode", this.buyCompanyCode).append("buyCompanyName", this.buyCompanyName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "invoiceId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsInvoices
 * JD-Core Version:    0.7.0.1
 */