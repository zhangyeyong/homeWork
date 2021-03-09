package com.zte.eas.resconfig.business.expense.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpExpenseDimensions
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long expenseId;
  protected String expenseCode;
  protected String expenseName;
  protected String attribute1;
  protected String attribute2;
  protected String attribute3;
  protected String attribute4;
  protected String attribute5;
  protected String attribute6;
  protected String attribute7;
  protected String attribute8;
  protected String attribute9;
  protected String attribute10;
  
  public FbpExpenseDimensions() {}
  
  public FbpExpenseDimensions(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setExpenseId(paramLong4);
    setExpenseCode(paramString2);
    setExpenseName(paramString3);
    setAttribute1(paramString4);
    setAttribute2(paramString5);
    setAttribute3(paramString6);
    setAttribute4(paramString7);
    setAttribute5(paramString8);
    setAttribute6(paramString9);
    setAttribute7(paramString10);
    setAttribute8(paramString11);
    setAttribute9(paramString12);
    setAttribute10(paramString13);
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
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
  
  public Long getExpenseId()
  {
    return this.expenseId;
  }
  
  public void setExpenseId(Long paramLong)
  {
    this.expenseId = paramLong;
  }
  
  public String getExpenseCode()
  {
    return this.expenseCode;
  }
  
  public void setExpenseCode(String paramString)
  {
    this.expenseCode = paramString;
  }
  
  public String getExpenseName()
  {
    return this.expenseName;
  }
  
  public void setExpenseName(String paramString)
  {
    this.expenseName = paramString;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
  }
  
  public String getAttribute2()
  {
    return this.attribute2;
  }
  
  public void setAttribute2(String paramString)
  {
    this.attribute2 = paramString;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public void setAttribute3(String paramString)
  {
    this.attribute3 = paramString;
  }
  
  public String getAttribute4()
  {
    return this.attribute4;
  }
  
  public void setAttribute4(String paramString)
  {
    this.attribute4 = paramString;
  }
  
  public String getAttribute5()
  {
    return this.attribute5;
  }
  
  public void setAttribute5(String paramString)
  {
    this.attribute5 = paramString;
  }
  
  public String getAttribute6()
  {
    return this.attribute6;
  }
  
  public void setAttribute6(String paramString)
  {
    this.attribute6 = paramString;
  }
  
  public String getAttribute7()
  {
    return this.attribute7;
  }
  
  public void setAttribute7(String paramString)
  {
    this.attribute7 = paramString;
  }
  
  public String getAttribute8()
  {
    return this.attribute8;
  }
  
  public void setAttribute8(String paramString)
  {
    this.attribute8 = paramString;
  }
  
  public String getAttribute9()
  {
    return this.attribute9;
  }
  
  public void setAttribute9(String paramString)
  {
    this.attribute9 = paramString;
  }
  
  public String getAttribute10()
  {
    return this.attribute10;
  }
  
  public void setAttribute10(String paramString)
  {
    this.attribute10 = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpExpenseDimensions)) {
      return false;
    }
    FbpExpenseDimensions localFbpExpenseDimensions = (FbpExpenseDimensions)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpExpenseDimensions.lastUpdateDate).append(this.lastUpdatedBy, localFbpExpenseDimensions.lastUpdatedBy).append(this.creationDate, localFbpExpenseDimensions.creationDate).append(this.createdBy, localFbpExpenseDimensions.createdBy).append(this.lastUpdateLogin, localFbpExpenseDimensions.lastUpdateLogin).append(this.enabledFlag, localFbpExpenseDimensions.enabledFlag).append(this.expenseId, localFbpExpenseDimensions.expenseId).append(this.expenseCode, localFbpExpenseDimensions.expenseCode).append(this.expenseName, localFbpExpenseDimensions.expenseName).append(this.attribute1, localFbpExpenseDimensions.attribute1).append(this.attribute2, localFbpExpenseDimensions.attribute2).append(this.attribute3, localFbpExpenseDimensions.attribute3).append(this.attribute4, localFbpExpenseDimensions.attribute4).append(this.attribute5, localFbpExpenseDimensions.attribute5).append(this.attribute6, localFbpExpenseDimensions.attribute6).append(this.attribute7, localFbpExpenseDimensions.attribute7).append(this.attribute8, localFbpExpenseDimensions.attribute8).append(this.attribute9, localFbpExpenseDimensions.attribute9).append(this.attribute10, localFbpExpenseDimensions.attribute10).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.expenseId).append(this.expenseCode).append(this.expenseName).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("expenseId", this.expenseId).append("expenseCode", this.expenseCode).append("expenseName", this.expenseName).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "expenseId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.expense.model.FbpExpenseDimensions
 * JD-Core Version:    0.7.0.1
 */