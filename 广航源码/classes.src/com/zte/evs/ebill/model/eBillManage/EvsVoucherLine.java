package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EvsVoucherLine
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long voucherId;
  private String lineDesc;
  private Long lineNum;
  private Long codeId;
  private String accountDesc;
  private Long converRate;
  private BigDecimal accDr;
  private BigDecimal accCr;
  private Long lineId;
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private String voucherType;
  private String accDrStr;
  private String accCrStr;
  private String subjectCode;
  private String subjectDetail;
  private BigDecimal currencyAmount;
  private String currencyAmountStr;
  
  public EvsVoucherLine() {}
  
  public EvsVoucherLine(Long paramLong1, String paramString1, Long paramLong2, Long paramLong3, String paramString2, Long paramLong4, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Long paramLong5, Date paramDate1, Long paramLong6, Date paramDate2, Long paramLong7, Long paramLong8, String paramString3)
  {
    this.voucherId = paramLong1;
    this.lineDesc = paramString1;
    this.lineNum = paramLong2;
    this.codeId = paramLong3;
    this.accountDesc = paramString2;
    this.converRate = paramLong4;
    this.accDr = paramBigDecimal1;
    this.accCr = paramBigDecimal2;
    this.lineId = paramLong5;
    this.creationDate = paramDate1;
    this.createdBy = paramLong6;
    this.lastUpdateDate = paramDate2;
    this.lastUpdateBy = paramLong7;
    this.lastUpdateLogin = paramLong8;
    this.voucherType = paramString3;
  }
  
  public String getLineDesc()
  {
    return this.lineDesc;
  }
  
  public void setLineDesc(String paramString)
  {
    this.lineDesc = paramString;
  }
  
  public Long getLineNum()
  {
    return this.lineNum;
  }
  
  public void setLineNum(Long paramLong)
  {
    this.lineNum = paramLong;
  }
  
  public Long getCodeId()
  {
    return this.codeId;
  }
  
  public void setCodeId(Long paramLong)
  {
    this.codeId = paramLong;
  }
  
  public String getAccountDesc()
  {
    return this.accountDesc;
  }
  
  public void setAccountDesc(String paramString)
  {
    this.accountDesc = paramString;
  }
  
  public Long getConverRate()
  {
    return this.converRate;
  }
  
  public void setConverRate(Long paramLong)
  {
    this.converRate = paramLong;
  }
  
  public BigDecimal getAccDr()
  {
    return this.accDr;
  }
  
  public void setAccDr(BigDecimal paramBigDecimal)
  {
    this.accDr = paramBigDecimal;
  }
  
  public BigDecimal getAccCr()
  {
    return this.accCr;
  }
  
  public void setAccCr(BigDecimal paramBigDecimal)
  {
    this.accCr = paramBigDecimal;
  }
  
  public Long getLineId()
  {
    return this.lineId;
  }
  
  public void setLineId(Long paramLong)
  {
    this.lineId = paramLong;
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
  
  public String getVoucherType()
  {
    return this.voucherType;
  }
  
  public void setVoucherType(String paramString)
  {
    this.voucherType = paramString;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public String getAccDrStr()
  {
    return this.accDrStr;
  }
  
  public void setAccDrStr(String paramString)
  {
    this.accDrStr = paramString;
  }
  
  public String getAccCrStr()
  {
    return this.accCrStr;
  }
  
  public void setAccCrStr(String paramString)
  {
    this.accCrStr = paramString;
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
  
  public BigDecimal getCurrencyAmount()
  {
    return this.currencyAmount;
  }
  
  public void setCurrencyAmount(BigDecimal paramBigDecimal)
  {
    this.currencyAmount = paramBigDecimal;
  }
  
  public String getCurrencyAmountStr()
  {
    return this.currencyAmountStr;
  }
  
  public void setCurrencyAmountStr(String paramString)
  {
    this.currencyAmountStr = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherLine
 * JD-Core Version:    0.7.0.1
 */