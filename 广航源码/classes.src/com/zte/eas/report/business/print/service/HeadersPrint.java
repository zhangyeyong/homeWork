package com.zte.eas.report.business.print.service;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import org.apache.commons.lang.builder.ToStringBuilder;

public class HeadersPrint
  extends BaseObject
  implements Serializable
{
  protected BigInteger printId;
  protected BigInteger sessionId;
  protected BigInteger boeHeaderId;
  protected byte[] barCode;
  protected String billPractNum;
  
  public int hashCode()
  {
    int i = 1;
    i = 31 * i + Arrays.hashCode(this.barCode);
    i = 31 * i + (this.billPractNum == null ? 0 : this.billPractNum.hashCode());
    i = 31 * i + (this.boeHeaderId == null ? 0 : this.boeHeaderId.hashCode());
    i = 31 * i + (this.printId == null ? 0 : this.printId.hashCode());
    i = 31 * i + (this.sessionId == null ? 0 : this.sessionId.hashCode());
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    HeadersPrint localHeadersPrint = (HeadersPrint)paramObject;
    if (!Arrays.equals(this.barCode, localHeadersPrint.barCode)) {
      return false;
    }
    if (this.billPractNum == null)
    {
      if (localHeadersPrint.billPractNum != null) {
        return false;
      }
    }
    else if (!this.billPractNum.equals(localHeadersPrint.billPractNum)) {
      return false;
    }
    if (this.boeHeaderId == null)
    {
      if (localHeadersPrint.boeHeaderId != null) {
        return false;
      }
    }
    else if (!this.boeHeaderId.equals(localHeadersPrint.boeHeaderId)) {
      return false;
    }
    if (this.printId == null)
    {
      if (localHeadersPrint.printId != null) {
        return false;
      }
    }
    else if (!this.printId.equals(localHeadersPrint.printId)) {
      return false;
    }
    if (this.sessionId == null)
    {
      if (localHeadersPrint.sessionId != null) {
        return false;
      }
    }
    else if (!this.sessionId.equals(localHeadersPrint.sessionId)) {
      return false;
    }
    return true;
  }
  
  public byte[] getBarCode()
  {
    return this.barCode;
  }
  
  public void setBarCode(byte[] paramArrayOfByte)
  {
    this.barCode = paramArrayOfByte;
  }
  
  public String getBillPractNum()
  {
    return this.billPractNum;
  }
  
  public void setBillPractNum(String paramString)
  {
    this.billPractNum = paramString;
  }
  
  public BigInteger getBoeHeaderId()
  {
    return this.boeHeaderId;
  }
  
  public void setBoeHeaderId(BigInteger paramBigInteger)
  {
    this.boeHeaderId = paramBigInteger;
  }
  
  public BigInteger getPrintId()
  {
    return this.printId;
  }
  
  public void setPrintId(BigInteger paramBigInteger)
  {
    this.printId = paramBigInteger;
  }
  
  public BigInteger getSessionId()
  {
    return this.sessionId;
  }
  
  public void setSessionId(BigInteger paramBigInteger)
  {
    this.sessionId = paramBigInteger;
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("printId", this.printId).append("sessionId", this.sessionId).append("boeHeaderId", this.sessionId).append("boeHeaderId", this.sessionId).append("barCode", this.barCode).append("billPractNum", this.billPractNum).toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.report.business.print.service.HeadersPrint
 * JD-Core Version:    0.7.0.1
 */