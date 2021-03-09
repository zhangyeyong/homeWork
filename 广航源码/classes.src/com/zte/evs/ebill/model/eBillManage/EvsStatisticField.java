package com.zte.evs.ebill.model.eBillManage;

import java.math.BigInteger;

public class EvsStatisticField
{
  protected String ouName;
  protected String lastBookMonth;
  protected BigInteger voucherNum;
  protected BigInteger voucherLostNum;
  protected BigInteger voucherNoimageNum;
  protected BigInteger voucherManualNum;
  protected String ouId;
  
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
  
  public String getOuName()
  {
    return this.ouName;
  }
  
  public void setOuName(String paramString)
  {
    this.ouName = paramString;
  }
  
  public String getOuId()
  {
    return this.ouId;
  }
  
  public void setOuId(String paramString)
  {
    this.ouId = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsStatisticField
 * JD-Core Version:    0.7.0.1
 */