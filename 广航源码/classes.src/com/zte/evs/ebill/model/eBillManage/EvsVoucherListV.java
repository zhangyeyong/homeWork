package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsVoucherListV
  extends BaseObject
  implements Serializable
{
  protected Long lineId;
  protected Long voucherId;
  protected String companyCode;
  protected String companyName;
  protected String invoiceType;
  protected String invoiceTypeName;
  protected Date journalDate;
  protected String journalNum;
  protected String settlementType;
  protected String accType;
  protected String subjectCode;
  protected String subjectDetail;
  protected BigDecimal accAmount;
  protected String lineDesc;
  protected String userNumber;
  protected String userName;
  protected String boeAbstract;
  protected String journalYear;
  
  public EvsVoucherListV() {}
  
  public EvsVoucherListV(BigInteger paramBigInteger1, BigInteger paramBigInteger2, String paramString1, String paramString2, String paramString3, Date paramDate, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, BigInteger paramBigInteger3, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    setCompanyCode(paramString1);
    setCompanyName(paramString2);
    setInvoiceType(paramString3);
    setJournalDate(paramDate);
    setJournalNum(paramString4);
    setSettlementType(paramString5);
    setAccType(paramString6);
    setSubjectCode(paramString7);
    setSubjectDetail(paramString8);
    setLineDesc(paramString9);
    setUserNumber(paramString10);
    setUserName(paramString11);
    setJournalYear(paramString12);
  }
  
  public String getInvoiceTypeName()
  {
    return this.invoiceTypeName;
  }
  
  public void setInvoiceTypeName(String paramString)
  {
    this.invoiceTypeName = paramString;
  }
  
  public Long getLineId()
  {
    return this.lineId;
  }
  
  public void setLineId(Long paramLong)
  {
    this.lineId = paramLong;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public void setInvoiceType(String paramString)
  {
    this.invoiceType = paramString;
  }
  
  public Date getJournalDate()
  {
    return this.journalDate;
  }
  
  public void setJournalDate(Date paramDate)
  {
    this.journalDate = paramDate;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public String getSettlementType()
  {
    return this.settlementType;
  }
  
  public void setSettlementType(String paramString)
  {
    this.settlementType = paramString;
  }
  
  public String getAccType()
  {
    return this.accType;
  }
  
  public void setAccType(String paramString)
  {
    this.accType = paramString;
  }
  
  public String getSubjectCode()
  {
    return this.subjectCode;
  }
  
  public void setSubjectCode(String paramString)
  {
    this.subjectCode = paramString;
  }
  
  public String getSubjectDetail()
  {
    return this.subjectDetail;
  }
  
  public void setSubjectDetail(String paramString)
  {
    this.subjectDetail = paramString;
  }
  
  public BigDecimal getAccAmount()
  {
    return this.accAmount;
  }
  
  public void setAccAmount(BigDecimal paramBigDecimal)
  {
    this.accAmount = paramBigDecimal;
  }
  
  public String getLineDesc()
  {
    return this.lineDesc;
  }
  
  public void setLineDesc(String paramString)
  {
    this.lineDesc = paramString;
  }
  
  public String getUserNumber()
  {
    return this.userNumber;
  }
  
  public void setUserNumber(String paramString)
  {
    this.userNumber = paramString;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public String getJournalYear()
  {
    return this.journalYear;
  }
  
  public void setJournalYear(String paramString)
  {
    this.journalYear = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsVoucherListV)) {
      return false;
    }
    EvsVoucherListV localEvsVoucherListV = (EvsVoucherListV)paramObject;
    return new EqualsBuilder().append(this.lineId, localEvsVoucherListV.lineId).append(this.voucherId, localEvsVoucherListV.voucherId).append(this.companyCode, localEvsVoucherListV.companyCode).append(this.companyName, localEvsVoucherListV.companyName).append(this.invoiceType, localEvsVoucherListV.invoiceType).append(this.journalDate, localEvsVoucherListV.journalDate).append(this.journalNum, localEvsVoucherListV.journalNum).append(this.settlementType, localEvsVoucherListV.settlementType).append(this.accType, localEvsVoucherListV.accType).append(this.subjectCode, localEvsVoucherListV.subjectCode).append(this.subjectDetail, localEvsVoucherListV.subjectDetail).append(this.accAmount, localEvsVoucherListV.accAmount).append(this.lineDesc, localEvsVoucherListV.lineDesc).append(this.userNumber, localEvsVoucherListV.userNumber).append(this.userName, localEvsVoucherListV.userName).append(this.journalYear, localEvsVoucherListV.journalYear).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lineId).append(this.voucherId).append(this.companyCode).append(this.companyName).append(this.invoiceType).append(this.journalDate).append(this.journalNum).append(this.settlementType).append(this.accType).append(this.subjectCode).append(this.subjectDetail).append(this.accAmount).append(this.lineDesc).append(this.userNumber).append(this.userName).append(this.journalYear).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lineId", this.lineId).append("voucherId", this.voucherId).append("companyCode", this.companyCode).append("companyName", this.companyName).append("invoiceType", this.invoiceType).append("journalDate", this.journalDate).append("journalNum", this.journalNum).append("settlementType", this.settlementType).append("accType", this.accType).append("subjectCode", this.subjectCode).append("subjectDetail", this.subjectDetail).append("accAmount", this.accAmount).append("lineDesc", this.lineDesc).append("userNumber", this.userNumber).append("userName", this.userName).append("journalYear", this.journalYear).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getBoeAbstract()
  {
    return this.boeAbstract;
  }
  
  public void setBoeAbstract(String paramString)
  {
    this.boeAbstract = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherListV
 * JD-Core Version:    0.7.0.1
 */