package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsVoucherInvoice
  extends BaseObject
  implements Serializable
{
  protected Date creationDate;
  protected Long createdBy;
  protected Date lastUpdateDate;
  protected Long lastUpdateBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long relationId;
  protected Long voucherId;
  protected Long invoiceId;
  protected String relationType;
  
  public EvsVoucherInvoice() {}
  
  public EvsVoucherInvoice(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, Long paramLong5, Long paramLong6, String paramString2)
  {
    setCreationDate(paramDate1);
    setCreatedBy(paramLong1);
    setLastUpdateDate(paramDate2);
    setLastUpdateBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setRelationId(paramLong4);
    setVoucherId(paramLong5);
    setInvoiceId(paramLong6);
    setRelationType(paramString2);
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
  
  public Long getRelationId()
  {
    return this.relationId;
  }
  
  public void setRelationId(Long paramLong)
  {
    this.relationId = paramLong;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public Long getInvoiceId()
  {
    return this.invoiceId;
  }
  
  public void setInvoiceId(Long paramLong)
  {
    this.invoiceId = paramLong;
  }
  
  public String getRelationType()
  {
    return this.relationType;
  }
  
  public void setRelationType(String paramString)
  {
    this.relationType = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsVoucherInvoice)) {
      return false;
    }
    EvsVoucherInvoice localEvsVoucherInvoice = (EvsVoucherInvoice)paramObject;
    return new EqualsBuilder().append(this.creationDate, localEvsVoucherInvoice.creationDate).append(this.createdBy, localEvsVoucherInvoice.createdBy).append(this.lastUpdateDate, localEvsVoucherInvoice.lastUpdateDate).append(this.lastUpdateBy, localEvsVoucherInvoice.lastUpdateBy).append(this.lastUpdateLogin, localEvsVoucherInvoice.lastUpdateLogin).append(this.enabledFlag, localEvsVoucherInvoice.enabledFlag).append(this.relationId, localEvsVoucherInvoice.relationId).append(this.voucherId, localEvsVoucherInvoice.voucherId).append(this.invoiceId, localEvsVoucherInvoice.invoiceId).append(this.relationType, localEvsVoucherInvoice.relationType).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.creationDate).append(this.createdBy).append(this.lastUpdateDate).append(this.lastUpdateBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.relationId).append(this.voucherId).append(this.invoiceId).append(this.relationType).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdateBy", this.lastUpdateBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("relationId", this.relationId).append("voucherId", this.voucherId).append("invoiceId", this.invoiceId).append("relationType", this.relationType).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "relationId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherInvoice
 * JD-Core Version:    0.7.0.1
 */