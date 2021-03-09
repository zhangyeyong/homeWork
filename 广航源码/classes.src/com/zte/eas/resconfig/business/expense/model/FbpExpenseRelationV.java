package com.zte.eas.resconfig.business.expense.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpExpenseRelationV
  extends BaseObject
  implements Serializable
{
  protected Long expenseId;
  protected Long expenseRelationId;
  protected Long accountId;
  protected String accountCode;
  protected String accountName;
  
  public FbpExpenseRelationV() {}
  
  public FbpExpenseRelationV(Long paramLong1, Long paramLong2, Long paramLong3, String paramString1, String paramString2)
  {
    setExpenseId(paramLong1);
    setExpenseRelationId(paramLong2);
    setAccountId(paramLong3);
    setAccountCode(paramString1);
    setAccountName(paramString2);
  }
  
  public Long getExpenseId()
  {
    return this.expenseId;
  }
  
  public void setExpenseId(Long paramLong)
  {
    this.expenseId = paramLong;
  }
  
  public Long getExpenseRelationId()
  {
    return this.expenseRelationId;
  }
  
  public void setExpenseRelationId(Long paramLong)
  {
    this.expenseRelationId = paramLong;
  }
  
  public Long getAccountId()
  {
    return this.accountId;
  }
  
  public void setAccountId(Long paramLong)
  {
    this.accountId = paramLong;
  }
  
  public String getAccountName()
  {
    return this.accountName;
  }
  
  public void setAccountName(String paramString)
  {
    this.accountName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpExpenseRelationV)) {
      return false;
    }
    FbpExpenseRelationV localFbpExpenseRelationV = (FbpExpenseRelationV)paramObject;
    return new EqualsBuilder().append(this.expenseId, localFbpExpenseRelationV.expenseId).append(this.expenseRelationId, localFbpExpenseRelationV.expenseRelationId).append(this.accountId, localFbpExpenseRelationV.accountId).append(this.accountName, localFbpExpenseRelationV.accountName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.expenseId).append(this.expenseRelationId).append(this.accountId).append(this.accountName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("expenseId", this.expenseId).append("expenseRelationId", this.expenseRelationId).append("accountId", this.accountId).append("accountName", this.accountName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getAccountCode()
  {
    return this.accountCode;
  }
  
  public void setAccountCode(String paramString)
  {
    this.accountCode = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.expense.model.FbpExpenseRelationV
 * JD-Core Version:    0.7.0.1
 */