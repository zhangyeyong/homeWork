package com.zte.evs.business.month.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsVoucherMonthV
  extends BaseObject
  implements Serializable
{
  protected BigInteger num;
  protected BigDecimal bookNumber;
  protected BigDecimal markNumber;
  protected BigDecimal booknotNumber;
  protected String journalName;
  protected String lastUpdateDate;
  protected String posStruElementId;
  protected String posStruElementName;
  protected Long ouId;
  protected String periodName;
  protected BigInteger parentDeptId;
  protected String parentDeptName;
  
  public String getParentDeptName()
  {
    return this.parentDeptName;
  }
  
  public void setParentDeptName(String paramString)
  {
    this.parentDeptName = paramString;
  }
  
  public BigInteger getParentDeptId()
  {
    return this.parentDeptId;
  }
  
  public void setParentDeptId(BigInteger paramBigInteger)
  {
    this.parentDeptId = paramBigInteger;
  }
  
  public EvsVoucherMonthV() {}
  
  public EvsVoucherMonthV(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, String paramString1, String paramString2)
  {
    setBookNumber(paramBigDecimal1);
    setMarkNumber(paramBigDecimal2);
    setBooknotNumber(paramBigDecimal3);
    setJournalName(paramString1);
    setLastUpdateDate(paramString2);
  }
  
  public BigDecimal getBookNumber()
  {
    return this.bookNumber;
  }
  
  public void setBookNumber(BigDecimal paramBigDecimal)
  {
    this.bookNumber = paramBigDecimal;
  }
  
  public BigDecimal getMarkNumber()
  {
    return this.markNumber;
  }
  
  public void setMarkNumber(BigDecimal paramBigDecimal)
  {
    this.markNumber = paramBigDecimal;
  }
  
  public BigDecimal getBooknotNumber()
  {
    return this.booknotNumber;
  }
  
  public void setBooknotNumber(BigDecimal paramBigDecimal)
  {
    this.booknotNumber = paramBigDecimal;
  }
  
  public String getJournalName()
  {
    return this.journalName;
  }
  
  public void setJournalName(String paramString)
  {
    this.journalName = paramString;
  }
  
  public String getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(String paramString)
  {
    this.lastUpdateDate = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsVoucherMonthV)) {
      return false;
    }
    EvsVoucherMonthV localEvsVoucherMonthV = (EvsVoucherMonthV)paramObject;
    return new EqualsBuilder().append(this.bookNumber, localEvsVoucherMonthV.bookNumber).append(this.markNumber, localEvsVoucherMonthV.markNumber).append(this.booknotNumber, localEvsVoucherMonthV.booknotNumber).append(this.journalName, localEvsVoucherMonthV.journalName).append(this.lastUpdateDate, localEvsVoucherMonthV.lastUpdateDate).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.bookNumber).append(this.markNumber).append(this.booknotNumber).append(this.journalName).append(this.lastUpdateDate).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("bookNumber", this.bookNumber).append("markNumber", this.markNumber).append("booknotNumber", this.booknotNumber).append("journalName", this.journalName).append("lastUpdateDate", this.lastUpdateDate).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getPosStruElementId()
  {
    return this.posStruElementId;
  }
  
  public void setPosStruElementId(String paramString)
  {
    this.posStruElementId = paramString;
  }
  
  public String getPosStruElementName()
  {
    return this.posStruElementName;
  }
  
  public void setPosStruElementName(String paramString)
  {
    this.posStruElementName = paramString;
  }
  
  public BigInteger getNum()
  {
    return this.num;
  }
  
  public void setNum(BigInteger paramBigInteger)
  {
    this.num = paramBigInteger;
  }
  
  public Long getOuId()
  {
    return this.ouId;
  }
  
  public void setOuId(Long paramLong)
  {
    this.ouId = paramLong;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.business.month.model.EvsVoucherMonthV
 * JD-Core Version:    0.7.0.1
 */