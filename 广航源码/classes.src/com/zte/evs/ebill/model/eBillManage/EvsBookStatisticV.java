package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsBookStatisticV
  extends BaseObject
  implements Serializable
{
  protected String ouName;
  protected String lastBookMonth;
  protected BigInteger voucherNum;
  protected BigInteger voucherLostNum;
  protected BigInteger voucherNoimageNum;
  protected BigInteger voucherManualNum;
  protected String periodName;
  protected String ouId;
  protected String setBookName;
  protected String invoiceType;
  protected String source;
  protected String categoryName;
  protected Date bookDate;
  protected String bookEmployeeId;
  protected BigInteger bookId;
  protected String beginNum;
  protected String endNum;
  private String checkUnit;
  private String beginDate;
  private String endDate;
  private String journalName;
  
  public EvsBookStatisticV() {}
  
  public EvsBookStatisticV(String paramString1, String paramString2, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, Date paramDate, String paramString9, BigInteger paramBigInteger5, String paramString10, String paramString11)
  {
    setOuName(paramString1);
    setLastBookMonth(paramString2);
    setVoucherNum(paramBigInteger1);
    setVoucherLostNum(paramBigInteger2);
    setVoucherNoimageNum(paramBigInteger3);
    setVoucherManualNum(paramBigInteger4);
    setPeriodName(paramString3);
    setOuId(paramString4);
    setSetBookName(paramString5);
    setInvoiceType(paramString6);
    setSource(paramString7);
    setCategoryName(paramString8);
    setBookDate(paramDate);
    setBookEmployeeId(paramString9);
    setBookId(paramBigInteger5);
    setBeginNum(paramString10);
    setEndNum(paramString11);
  }
  
  public String getOuName()
  {
    return this.ouName;
  }
  
  public void setOuName(String paramString)
  {
    this.ouName = paramString;
  }
  
  public String getLastBookMonth()
  {
    return this.lastBookMonth;
  }
  
  public void setLastBookMonth(String paramString)
  {
    this.lastBookMonth = paramString;
  }
  
  public BigInteger getVoucherNum()
  {
    return this.voucherNum;
  }
  
  public void setVoucherNum(BigInteger paramBigInteger)
  {
    this.voucherNum = paramBigInteger;
  }
  
  public BigInteger getVoucherLostNum()
  {
    return this.voucherLostNum;
  }
  
  public void setVoucherLostNum(BigInteger paramBigInteger)
  {
    this.voucherLostNum = paramBigInteger;
  }
  
  public BigInteger getVoucherNoimageNum()
  {
    return this.voucherNoimageNum;
  }
  
  public void setVoucherNoimageNum(BigInteger paramBigInteger)
  {
    this.voucherNoimageNum = paramBigInteger;
  }
  
  public BigInteger getVoucherManualNum()
  {
    return this.voucherManualNum;
  }
  
  public void setVoucherManualNum(BigInteger paramBigInteger)
  {
    this.voucherManualNum = paramBigInteger;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getOuId()
  {
    return this.ouId;
  }
  
  public void setOuId(String paramString)
  {
    this.ouId = paramString;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
  }
  
  public String getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public void setInvoiceType(String paramString)
  {
    this.invoiceType = paramString;
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public void setSource(String paramString)
  {
    this.source = paramString;
  }
  
  public String getCategoryName()
  {
    return this.categoryName;
  }
  
  public void setCategoryName(String paramString)
  {
    this.categoryName = paramString;
  }
  
  public Date getBookDate()
  {
    return this.bookDate;
  }
  
  public void setBookDate(Date paramDate)
  {
    this.bookDate = paramDate;
  }
  
  public String getBookEmployeeId()
  {
    return this.bookEmployeeId;
  }
  
  public void setBookEmployeeId(String paramString)
  {
    this.bookEmployeeId = paramString;
  }
  
  public BigInteger getBookId()
  {
    return this.bookId;
  }
  
  public void setBookId(BigInteger paramBigInteger)
  {
    this.bookId = paramBigInteger;
  }
  
  public String getBeginNum()
  {
    return this.beginNum;
  }
  
  public void setBeginNum(String paramString)
  {
    this.beginNum = paramString;
  }
  
  public String getEndNum()
  {
    return this.endNum;
  }
  
  public void setEndNum(String paramString)
  {
    this.endNum = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsBookStatisticV)) {
      return false;
    }
    EvsBookStatisticV localEvsBookStatisticV = (EvsBookStatisticV)paramObject;
    return new EqualsBuilder().append(this.ouName, localEvsBookStatisticV.ouName).append(this.lastBookMonth, localEvsBookStatisticV.lastBookMonth).append(this.voucherNum, localEvsBookStatisticV.voucherNum).append(this.voucherLostNum, localEvsBookStatisticV.voucherLostNum).append(this.voucherNoimageNum, localEvsBookStatisticV.voucherNoimageNum).append(this.voucherManualNum, localEvsBookStatisticV.voucherManualNum).append(this.periodName, localEvsBookStatisticV.periodName).append(this.ouId, localEvsBookStatisticV.ouId).append(this.setBookName, localEvsBookStatisticV.setBookName).append(this.invoiceType, localEvsBookStatisticV.invoiceType).append(this.source, localEvsBookStatisticV.source).append(this.categoryName, localEvsBookStatisticV.categoryName).append(this.bookDate, localEvsBookStatisticV.bookDate).append(this.bookEmployeeId, localEvsBookStatisticV.bookEmployeeId).append(this.bookId, localEvsBookStatisticV.bookId).append(this.beginNum, localEvsBookStatisticV.beginNum).append(this.endNum, localEvsBookStatisticV.endNum).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.ouName).append(this.lastBookMonth).append(this.voucherNum).append(this.voucherLostNum).append(this.voucherNoimageNum).append(this.voucherManualNum).append(this.periodName).append(this.ouId).append(this.setBookName).append(this.invoiceType).append(this.source).append(this.categoryName).append(this.bookDate).append(this.bookEmployeeId).append(this.bookId).append(this.beginNum).append(this.endNum).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("ouName", this.ouName).append("lastBookMonth", this.lastBookMonth).append("voucherNum", this.voucherNum).append("voucherLostNum", this.voucherLostNum).append("voucherNoimageNum", this.voucherNoimageNum).append("voucherManualNum", this.voucherManualNum).append("periodName", this.periodName).append("ouId", this.ouId).append("setBookName", this.setBookName).append("invoiceType", this.invoiceType).append("source", this.source).append("categoryName", this.categoryName).append("bookDate", this.bookDate).append("bookEmployeeId", this.bookEmployeeId).append("bookId", this.bookId).append("beginNum", this.beginNum).append("endNum", this.endNum).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getBeginDate()
  {
    return this.beginDate;
  }
  
  public void setBeginDate(String paramString)
  {
    this.beginDate = paramString;
  }
  
  public String getEndDate()
  {
    return this.endDate;
  }
  
  public void setEndDate(String paramString)
  {
    this.endDate = paramString;
  }
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
  
  public String getJournalName()
  {
    return this.journalName;
  }
  
  public void setJournalName(String paramString)
  {
    this.journalName = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsBookStatisticV
 * JD-Core Version:    0.7.0.1
 */